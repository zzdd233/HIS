package com.example.hospital.service;

import com.example.hospital.entity.pandm;
import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Prescription;

import java.util.List;


public interface DoctorService {
    String getTreatmentHistory(String patientId);//获取治疗历史

    boolean setTreatmentHistory(String patientId,String treatmentHistory);//添加治疗历史

    List<Prescription> getPrescription(String patientId);//获取处方信息

    //开新处方，最后一个参数不需要输入处方号，只需药物id和数量即可
    Integer setPrescription(String DoctorId, String patientId, String operation, String medicineNotes, List<pandm> pandms);

    Patient getPatientMessage(String patientId);//获取病人详细信息

    boolean setConditionReport(String patientId,String date,String conditionReport);//添加病情报告

    boolean setDiagnosis(String patientId,String date,String diagnosis);//添加电子诊断书

    boolean setWardRoundRecord(String patientId,String date,String WardRoundRecord);//添加查房记录

    String getConditionReport(String patientId, String date);//获取病情报告

    String getWardRoundRecord(String patientId,String date);//查房记录

    String getDiagnosis(String patientId,String date);//获取电子诊断书

    List<String>getAllConditionReport(String patientId);//获取病情报告目录

    List<String>getAllWardRoundRecord(String patientId);//获取查房记录目录

    List<String>getAllDiagnosis(String patientId);//获取电子诊断书目录
}
