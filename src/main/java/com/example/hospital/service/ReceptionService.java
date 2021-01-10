package com.example.hospital.service;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Nurse;

public interface ReceptionService {
    Integer setCost(String patientId,String costDetail,Integer cost);//设置费用
    Integer setBed(String bedId, String patientId, String inDate);//设置病人病床信息
    boolean leaveBed(String bedId, String patientId);//病人出院
    Integer insertDoctor(Doctor doctor);//添加医生信息
    Integer insertNurse(Nurse nurse);//添加护士信息
}
