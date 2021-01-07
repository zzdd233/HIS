package com.example.hospital.controller;

import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Prescription;
import com.example.hospital.mapper.ReceptionMapper;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class doctorController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    ReceptionMapper receptionMapper;

    @RequestMapping("/getTreatmentHistory")//获取治疗历史
    public String getTreatmentHistory(String PatientId) {
        return doctorService.getTreatmentHistory(PatientId);
    }

    @RequestMapping("/setTreatmentHistory")//添加治疗历史
    public boolean setTreatmentHistory(String PatientId,String treatmentHistory){
        return doctorService.setTreatmentHistory(PatientId,treatmentHistory);
    }

    @RequestMapping("/getPrescription")//获取处方信息
    public List<Prescription> getPrescription(String patientId){
        return doctorService.getPrescription(patientId);
    }

    @RequestMapping("/setPrescription")//开处方
    public Integer setPrescription(String DoctorId,String patientId,String operation,String medicineNotes){
        return doctorService.setPrescription(DoctorId,patientId,operation,medicineNotes);
    }

    @RequestMapping("/getPatientMessage")//获取病人详细信息，包括个人信息和治疗历史
    public Patient getPatientMessage(String PatientId){
        return doctorService.getPatientMessage(PatientId);
    }

    @RequestMapping("/getBedId")//通过病人号获取病床号
    public String getBedIdByPatientId(String PatientId){
        return receptionMapper.getBedIdByPatientId(PatientId);
    }

    @RequestMapping("/setConditionReport")//添加病情报告
    public boolean setConditionReport(String patientId,String date,String conditionReport){
        return doctorService.setConditionReport(patientId,date,conditionReport);
    }

    @RequestMapping("/setDiagnosis")//添加电子诊断书
    public boolean setDiagnosis(String patientId,String date,String diagnosis){
        return doctorService.setDiagnosis(patientId,date,diagnosis);
    }

    @RequestMapping("/setWardRoundRecord")//添加查房记录
    public boolean setWardRoundRecord(String patientId,String date,String wardRoundRecord){
        return doctorService.setWardRoundRecord(patientId,date,wardRoundRecord);
    }

    @RequestMapping("/getConditionReport")//获取病情报告
    public String getConditionReport(String patientId, String date){
        return doctorService.getConditionReport(patientId,date);
    }

    @RequestMapping("/getWardRoundRecord")//查房记录
    public String getWardRoundRecord(String patientId,String date){
        return doctorService.getWardRoundRecord(patientId,date);
    }

    @RequestMapping("/getDiagnosis")//获取电子诊断书
    public String getDiagnosis(String patientId,String date){
        return doctorService.getDiagnosis(patientId,date);
    }
}
