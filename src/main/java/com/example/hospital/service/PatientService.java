package com.example.hospital.service;

import com.example.hospital.entity.Medicine;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Prescription;

import java.util.List;

public interface PatientService {
    Integer getCost(String patientId);//获取医疗费用
    Integer payCost();//支付
    List<Prescription> getPrescription(String patientId);//获取电子处方
    Patient getDetailMessage();//获取自己的详细信息
    List<Medicine>getMedicineByPrescriptionId(String prescriptionId);//获取处方开出的药物信息
}
