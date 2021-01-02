package com.example.hospital.service;

import com.example.hospital.entity.BodyData;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface BedService {
    BodyData getBodyData();//获取身体状况
    String getMedicineUsingByBedId(String medicineID);//获取给药任务
    void writeBodyData(String patientId,BodyData bodyData);//记录身体状况到患者日志
    List<BodyData> getHistory(String patientId);//获取患者日志
}
