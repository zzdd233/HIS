package com.example.hospital.controller;


import com.example.hospital.entity.Bed;
import com.example.hospital.entity.BodyData;
import com.example.hospital.mapper.BedMapper;
import com.example.hospital.mapper.PatientMapper;
import com.example.hospital.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bed")
public class bedController {

    @Autowired
    BedService bedService;
    @Autowired
    BedMapper bedMapper;
    @Autowired
    PatientMapper patientMapper;


    @RequestMapping("/getBodyDataList")//获取病人状况列表
    public List<BodyData> getBodyDataList(){
        List<BodyData> bodyDataList=new ArrayList<>();
        List<Bed> bedList=bedMapper.getBeds();
        List<String> patientNameList =new ArrayList<>();
        List<String> patientIdList=new ArrayList<>();

        for (Bed bed : bedList) {
            String patientId=bed.getPatientId();
            if(patientId!=null){
                patientIdList.add(patientId);
                patientNameList.add(patientMapper.selectById(patientId).getPatientName());
            }
        }
        for (int i = 0; i < patientIdList.size(); i++) {
            BodyData bodyData = bedService.getBodyData();
            bodyData.setPatientName(patientNameList.get(i));
            bodyDataList.add(bodyData);
            bedService.writeBodyData(patientIdList.get(i), bodyData);
        }

        return bodyDataList;
    }

    @RequestMapping("/getSingleBodyData")//获取单个病人身体状况，并写入患者日志
    public BodyData getSingleBodyData(String patientId) {
        BodyData bodyData=bedService.getBodyData();
        String patientName=patientMapper.selectById(patientId).getPatientName();
        bodyData.setPatientName(patientName);
        bedService.writeBodyData(patientId,bodyData);
        return bodyData;
    }

    @RequestMapping("/getMedicineUsing")//返回给药任务
    public String getMedicineUsing (String bedId){
        return bedService.getMedicineUsingByBedId(bedId);
    }

   @RequestMapping("/getHistory")//获取患者日志
    public List<BodyData>  getHistory(String patientId){
        return bedService.getHistory(patientId);
   }

   @RequestMapping("/getBeds")//获取所有病床信息
    public List<Bed> getBeds(){
        return bedMapper.getBeds();
   }
}
