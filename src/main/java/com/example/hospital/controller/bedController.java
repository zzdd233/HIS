package com.example.hospital.controller;


import com.example.hospital.entity.Bed;
import com.example.hospital.entity.BodyData;
import com.example.hospital.mapper.BedMapper;
import com.example.hospital.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bed")
public class bedController {

    @Autowired
    List<BodyData> bodyDataList;
    @Autowired
    BedService bedService;
    @Autowired
    BedMapper bedMapper;

/*
    @RequestMapping("/getBodyDataList")//获取病人状况列表
    public List<BodyData> getBodyDataList(){
        bodyDataList.clear();
        for (int i = 0; i < 10; i++) {
            bodyDataList.add(bedService.getBodyData());
        }
        return bodyDataList;
    }*/

    @RequestMapping("/getSingleBodyData")//获取单个病人身体状况，并写入患者日志
    public BodyData getSingleBodyData(String patientId) {
        BodyData bodyData=bedService.getBodyData();
        bedService.writeBodyData(patientId,bodyData);
        return bodyData;
    }

    @RequestMapping("/getMedicineUsing")//返回给药任务
    public String getMedicineUsing (String bedId){
        return bedService.getMedicineUsingByBedId(bedId);
    }

   @RequestMapping("getHistory")//获取患者日志
    public List<BodyData>  getHistory(String patientId){
        return bedService.getHistory(patientId);
   }

   @RequestMapping("/getBeds")
    public List<Bed> getBeds(){
        return bedMapper.getBeds();
   }
}
