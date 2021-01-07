package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Reception {//前台
    @TableId
    String patientId;
    @TableId
    String bedId;
    @TableId
    String costId;
    @TableId
    String prescriptionId;//电子处方ID

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getBedId() {
        return bedId;
    }

    public String getCostId() {
        return costId;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }
}
