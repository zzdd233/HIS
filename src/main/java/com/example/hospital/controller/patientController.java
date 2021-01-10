package com.example.hospital.controller;

import com.example.hospital.entity.Medicine;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Prescription;
import com.example.hospital.entity.User;
import com.example.hospital.mapper.PatientMapper;
import com.example.hospital.service.PatientService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class patientController {
    @Autowired
    PatientService patientService;

    @RequestMapping("/getCost")//获取花费
    public Integer getCost(String patientId){
        return patientService.getCost(patientId);
    }

    //获取详细花费

    @RequestMapping("/payCost")//支付
    public boolean payCost(){
        return patientService.payCost();
    }

    @RequestMapping("/getPrescription")//查看电子处方
    public List<Prescription> getPrescription(String patientId){
        return patientService.getPrescription(patientId);
    }

    @RequestMapping("/getDetailMessage")//获取个人详细信息
    public Patient getDetailMessage(){
        return patientService.getDetailMessage();
    }

    @RequestMapping("/getMedicineByPrescriptionId")//获取处方开出的药物信息
    List<Medicine>getMedicineByPrescriptionId(String prescriptionId){
        return patientService.getMedicineByPrescriptionId(prescriptionId);
    }

}
