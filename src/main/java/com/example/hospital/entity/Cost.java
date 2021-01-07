package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import javax.annotation.processing.Generated;

public class Cost {
    @TableId(type = IdType.AUTO)
    String costId;
    @TableId
    String prescriptionId;
    @TableId
    String patientId;
    Integer allCost;
    String detailedCost;

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setAllCost(Integer allCost) {
        this.allCost = allCost;
    }

    public void setDetailedCost(String detailedCost) {
        this.detailedCost = detailedCost;
    }

    public String getCostId() {
        return costId;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public Integer getAllCost() {
        return allCost;
    }

    public String getDetailedCost() {
        return detailedCost;
    }
}
