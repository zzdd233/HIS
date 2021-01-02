package com.example.hospital.service;

import com.example.hospital.entity.Cost;

public interface ReceptionService {
    boolean setCost(String patientId,String costDetail,Float cost);//设置费用
    boolean setBed(String bedId,String userId);//设置病人病床信息
    
}
