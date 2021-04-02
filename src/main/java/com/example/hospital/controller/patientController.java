package com.example.hospital.controller;

import com.example.hospital.entity.Medicine;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Prescription;
import com.example.hospital.entity.pandm;
import com.example.hospital.mapper.PAndMMapper;
import com.example.hospital.mapper.PatientMapper;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    PAndMMapper pAndMMapper;

    @RequestMapping("/getCost")//获取花费
    public Integer getCost(String patientId){
        return patientService.getCost(patientId);
    }

    //获取详细花费

    @RequestMapping("/payCost")//支付
    public Integer payCost(){
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
    public List<Medicine>getMedicineByPrescriptionId(String prescriptionId){
        return patientService.getMedicineByPrescriptionId(prescriptionId);
    }

    @RequestMapping("/updatePatientMessage")//更新病人个人信息
    public Integer updatePatientMessage(Patient patient){
        return patientMapper.updateById(patient);
    }

    @RequestMapping("/getMedicineAndNum")//获取处方开药数量
    public List<pandm>getMedicineAndNum(String prescriptionId){
        return pAndMMapper.getMedicineAndNum(prescriptionId);
    }
}
