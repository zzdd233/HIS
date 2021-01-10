package com.example.hospital.service.impl;

import com.example.hospital.entity.BodyData;
import com.example.hospital.entity.Medicine;
import com.example.hospital.mapper.MedicineMapper;
import com.example.hospital.mapper.PAndMMapper;
import com.example.hospital.mapper.PrescriptionMapper;
import com.example.hospital.mapper.ReceptionMapper;
import com.example.hospital.service.BedService;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    PrescriptionMapper prescriptionMapper;
    @Autowired
    ReceptionMapper receptionMapper;
    @Autowired
    PAndMMapper pAndMMapper;
    @Autowired
    MedicineMapper medicineMapper;

    @Override
    @JsonBackReference
    public BodyData getBodyData() {
        Random random = new Random();
        int heartbeat;//60~100
        double temperature;//36.3~37.3
        int systolicPressure;//90~140
        int diastolicPressure;//60~90
        double bloodOxygenContent;

        if (random.nextInt(100) > 10) {//正常
            heartbeat = random.nextInt(41) + 60;//60~100
            temperature = random.nextFloat() + 36.3;//36.3~37.3
            BigDecimal bg = new BigDecimal(temperature).setScale(1, RoundingMode.UP);
            temperature = bg.doubleValue();
            systolicPressure = random.nextInt(51) + 90;//90~140
            diastolicPressure = random.nextInt(31) + 60;//60~90
            bloodOxygenContent = random.nextDouble() * 0.05 + 0.95;//95%~100%
            BigDecimal bg2 = new BigDecimal(bloodOxygenContent).setScale(2, RoundingMode.UP);
            bloodOxygenContent = bg2.doubleValue();
        } else {
            heartbeat = random.nextInt(102) + 100;//101~200
            temperature = random.nextFloat() * 3 + 37.3;//37.3~40.3
            BigDecimal bg = new BigDecimal(temperature).setScale(1, RoundingMode.UP);
            temperature = bg.doubleValue();
            systolicPressure = random.nextInt(61) + 140;//140~200
            diastolicPressure = random.nextInt(51) + 90;//90~140
            bloodOxygenContent = random.nextDouble() * 0.25 + 0.75;//75%~95%
            BigDecimal bg2 = new BigDecimal(bloodOxygenContent).setScale(2, RoundingMode.UP);
            bloodOxygenContent = bg2.doubleValue();
        }

        return new BodyData(heartbeat, temperature, systolicPressure, diastolicPressure, bloodOxygenContent);
    }

    @Override
    public String getMedicineUsingByBedId(String bedId) {
        String prescriptionId = receptionMapper.getPrescriptionIdByBedId(bedId);
        List<String> medicineIdList=pAndMMapper.getMedicineIdByPrescriptionId(prescriptionId);
        List<Medicine> medicineList=new ArrayList<>();
        for (String medicineId : medicineIdList) {
            medicineList.add(medicineMapper.selectById(medicineId));
        }
        StringBuilder task= new StringBuilder();
        for (Medicine medicine : medicineList) {
            task.append(medicine).append("\n");
        }
        return task+"备注："+prescriptionMapper.getMedicineNote(prescriptionId);
    }

    @Override
    public void writeBodyData(String patientId, BodyData bodyData) {

        try {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("heartbeat",bodyData.getHeartbeat());
            jsonObject.put("temperature",bodyData.getTemperature());
            jsonObject.put("systolicPressure",bodyData.getSystolicPressure());
            jsonObject.put("diastolicPressure",bodyData.getDiastolicPressure());
            jsonObject.put("bloodOxygenContent",bodyData.getBloodOxygenContent());

            String s = jsonObject.toString()+"\n";
            FileWriter fileWriter=new FileWriter("data/patientLog/"+patientId +".txt",true);
            char[] chars=s.toCharArray();
            fileWriter.append(s);
            fileWriter.flush();
            fileWriter.close();
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BodyData> getHistory(String patientId) {
        List<BodyData> bodyDataList=new ArrayList<>();
        JSONObject jsonObject;
        try {
            BufferedReader bufferedInputStream=new BufferedReader(new FileReader("data/patientLog/"+patientId+".txt"));
            String line = bufferedInputStream.readLine();
            while (line !=null){
                jsonObject=new JSONObject(line);

                Integer heartbeat=jsonObject.getInt("heartbeat");//心跳
                Double temperature=jsonObject.getDouble("temperature");//体温
                Integer systolicPressure=jsonObject.getInt("systolicPressure");//收缩压
                Integer diastolicPressure=jsonObject.getInt("diastolicPressure");//舒张压
                Double bloodOxygenContent=jsonObject.getDouble("bloodOxygenContent");//血氧含量

                BodyData bodyData=new BodyData(heartbeat,temperature,systolicPressure,diastolicPressure,bloodOxygenContent);
                bodyDataList.add(bodyData);
                line =bufferedInputStream.readLine();
            }
            bufferedInputStream.close();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return bodyDataList;
    }

}
