package com.example.hospital.controller;

import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Prescription;
import com.example.hospital.mapper.PatientMapper;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class patientController {
    @Autowired
    PatientService patientService;
    @Autowired
    PatientMapper patientMapper;

    @RequestMapping("/getCost")//获取花费
    public Integer getCost(String patientId){
        return patientService.getCost(patientId);
    }

    @RequestMapping("/payCost")//支付
    public boolean payCost(){
        return patientService.payCost();
    }

    @RequestMapping("/getPrescription")//查看电子处方
    public List<Prescription> getPrescription(String patientId){
        return patientService.getPrescription(patientId);
    }

    @RequestMapping("/getDetailMessage")//获取详细信息
    public Patient getDetailMessage(String patientId){
        return patientMapper.selectById(patientId);
    }
}
