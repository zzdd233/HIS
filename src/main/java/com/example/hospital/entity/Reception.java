package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Reception {//前台
    @TableId
    String patientId;
    @TableId
    String bedId;
    @TableId
    Integer costId;
    @TableId
    Integer prescriptionId;//电子处方ID

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getBedId() {
        return bedId;
    }

    public Integer getCostId() {
        return costId;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }
}
