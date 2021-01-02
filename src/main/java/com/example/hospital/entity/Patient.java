package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Patient {
    @TableId
    String patientId;//医保卡号
    String patientName;
    Integer patientAge;
    String patientAddress;//病人家庭地址
    String patientContact;//病人联系方式
    String treatmentHistory;//历史治疗

    String remarks;

    public void setMedicalInsurance(String medicalInsurance) {
        this.patientId = medicalInsurance;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public void setTreatmentHistory(String treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }


    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMedicalInsurance() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public String getTreatmentHistory() {
        return treatmentHistory;
    }


    public String getRemarks() {
        return remarks;
    }
}
