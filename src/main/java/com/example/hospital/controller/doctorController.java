package com.example.hospital.controller;

import com.example.hospital.entity.Medicine;
import com.example.hospital.entity.pandm;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Prescription;
import com.example.hospital.mapper.MedicineMapper;
import com.example.hospital.mapper.ReceptionMapper;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class doctorController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    ReceptionMapper receptionMapper;
    @Autowired
    MedicineMapper medicineMapper;

    @RequestMapping("/getTreatmentHistory")//获取治疗历史
    public String getTreatmentHistory(String patientId) {
        return doctorService.getTreatmentHistory(patientId);
    }

    @RequestMapping("/setTreatmentHistory")//添加治疗历史
    public boolean setTreatmentHistory(String patientId,String treatmentHistory){
        String t=doctorService.getTreatmentHistory(patientId);
        if(!t.equals("无")) {
            treatmentHistory += " " + t;
        }
        return doctorService.setTreatmentHistory(patientId,treatmentHistory);
    }

    @RequestMapping("/getPrescription")//获取处方信息
    public List<Prescription> getPrescription(String patientId){
        return doctorService.getPrescription(patientId);
    }

    //开新处方，最后一个参数不需要输入处方号，只需药物id和数量即可
    @PostMapping("/setPrescription")//开处方
    public Integer setPrescription(@RequestParam String doctorId, @RequestParam String patientId,@RequestParam String operation,@RequestParam String medicineNotes,@RequestBody List<pandm>  pandmList){
        return doctorService.setPrescription(doctorId,patientId,operation,medicineNotes, pandmList);
    }

    @RequestMapping("/getPatientMessage")//获取病人详细信息，包括个人信息和治疗历史
    public Patient getPatientMessage(String patientId){
        return doctorService.getPatientMessage(patientId);
    }

    @RequestMapping("/getBedId")//通过病人号获取病床号
    public String getBedIdByPatientId(String patientId){
        return receptionMapper.getBedIdByPatientId(patientId);
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

    @RequestMapping("/getMedicines")//获取所有药物信息
    List<Medicine> getMedicines(){
        return medicineMapper.getMedicines();
    }

    @RequestMapping("/getAllConditionReport")//获取病情报告目录
    List<String>getAllConditionReport(String patientId){
        return doctorService.getAllConditionReport(patientId);
    }

    @RequestMapping("/getAllWardRoundRecord")//获取查房记录目录
    List<String>getAllWardRoundRecord(String patientId){
        return doctorService.getAllWardRoundRecord(patientId);
    }

    @RequestMapping("/getAllDiagnosis")//获取电子诊断书目录
    List<String>getAllDiagnosis(String patientId){
        return doctorService.getAllDiagnosis(patientId);
    }

}
