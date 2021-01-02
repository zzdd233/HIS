package com.example.hospital.service;

import com.example.hospital.entity.Prescription;

import java.util.List;

public interface PatientService {
    Integer getCost(String patientId);//获取医疗费用
    boolean payCost();//支付
    List<Prescription> getPrescription(String patientId);//获取电子处方
}
