package com.example.hospital.service.impl;

import com.example.hospital.entity.pandm;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Prescription;
import com.example.hospital.mapper.PAndMMapper;
import com.example.hospital.mapper.PatientMapper;
import com.example.hospital.mapper.PrescriptionMapper;
import com.example.hospital.service.DoctorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    PrescriptionMapper prescriptionMapper;
    @Autowired
    PAndMMapper pAndMMapper;

    @Override
    public String getTreatmentHistory(String PatientId) {
        return patientMapper.getTreatmentHistoryByPatientId(PatientId);
    }

    @Override
    public boolean setTreatmentHistory(String patientId,String treatmentHistory) {
        return patientMapper.setTreatmentHistory(patientId,treatmentHistory);
    }

    @Override
    public List<Prescription> getPrescription(String patientId) {
        return prescriptionMapper.getPrescriptionByPatientId(patientId);
    }

    @Override
    public Integer setPrescription(String DoctorId, String patientId, String operation, String medicineNotes, List<pandm> pandmList ) {
        int insert;
      //  try {
           // JSONArray jsonArray=new JSONArray(pandms);
          //  List<pandm> pandmList=new ArrayList<>();
           /* for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                pandm p=new pandm();
                p.setMedicineId(jsonObject.getString("medicineId"));
               // p.setMedicineNum(jsonObject.getInt("medicineNum"));
            }*/
            Prescription prescription=new Prescription(patientId,DoctorId,operation,medicineNotes);
             insert = prescriptionMapper.insert(prescription);
            for (pandm pAndM : pandmList) {
                pAndM.setPrescriptionId(prescription.getPrescriptionId());
                pAndMMapper.insert(pAndM);
            }
       /* } catch (JSONException e) {
            e.printStackTrace();
        }*/

        return insert;
    }

    @Override
    public Patient getPatientMessage(String PatientId) {
        return patientMapper.selectById(PatientId);
    }

    @Override
    public boolean setConditionReport(String patientId, String date, String conditionReport) {
        try {
            File dir=new File("data/conditionReport/"+patientId);
            if(!dir.exists())
                dir.mkdir();
            File file=new File("data/conditionReport/"+patientId+"/"+date+".txt");
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write(conditionReport);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean setDiagnosis(String patientId, String date,String diagnosis) {
        FileWriter fileWriter;
        try {
            File dir=new File("data/diagnosis/"+patientId);
            if(!dir.exists())
                dir.mkdir();
            File file=new File("data/diagnosis/"+patientId+"/"+date+".txt");
            fileWriter = new FileWriter(file);
            fileWriter.write(diagnosis);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean setWardRoundRecord(String patientId, String date,String wardRoundRecord) {
        try {
            File dir=new File("data/wardRoundRecord/"+patientId);
            if(!dir.exists())
                dir.mkdir();
            File file=new File("data/wardRoundRecord/"+patientId+"/"+date+".txt");
            FileWriter fileWriter=new FileWriter(file);
            fileWriter.write(wardRoundRecord);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String getConditionReport(String patientId,String date) {
        BufferedReader bufferedInputStream;
        StringBuilder s =new StringBuilder();
        try {
            File file=new File("data/conditionReport/"+patientId+"/"+date+".txt");
            bufferedInputStream = new BufferedReader(new FileReader(file));
            String line = bufferedInputStream.readLine();
            while (line !=null){
                    s.append(line).append("\n");
                line = bufferedInputStream.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    @Override
    public String getWardRoundRecord(String patientId, String date) {
        BufferedReader bufferedInputStream;
        StringBuilder s =new StringBuilder();
        try {
            File file=new File("data/wardRoundRecord/"+patientId+"/"+date+".txt");
            bufferedInputStream = new BufferedReader(new FileReader(file));
            String line = bufferedInputStream.readLine();
            while (line !=null){
                s.append(line).append("\n");
                line = bufferedInputStream.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    @Override
    public String getDiagnosis(String patientId,String date) {
        BufferedReader bufferedInputStream;
        StringBuilder s =new StringBuilder();
        try {
            File file=new File("data/diagnosis/"+patientId+"/"+date+".txt");
            bufferedInputStream = new BufferedReader(new FileReader(file));
            String line = bufferedInputStream.readLine();
            while (line !=null){
                s.append(line).append("\n");
                line = bufferedInputStream.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    @Override
    public List<String> getAllConditionReport(String patientId) {
        File file=new File("data/conditionReport/"+patientId);
        File[] files=file.listFiles();
        List<String>fileName=new ArrayList<>();
        if (files != null) {
            for (File value : files) {
                fileName.add(value.getName());
            }
        }
        return fileName;
    }

    @Override
    public List<String> getAllWardRoundRecord(String patientId) {
        File file=new File("data/wardRoundRecord/"+patientId);
        File[] files=file.listFiles();
        List<String>fileName=new ArrayList<>();
        if (files != null) {
            for (File value : files) {
                fileName.add(value.getName());
            }
        }
        return fileName;
    }

    @Override
    public List<String> getAllDiagnosis(String patientId) {
        File file=new File("data/diagnosis/"+patientId);
        File[] files=file.listFiles();
        List<String>fileName=new ArrayList<>();
        if (files != null) {
            for (File value : files) {
                fileName.add(value.getName());
            }
        }
        return fileName;
    }
}
