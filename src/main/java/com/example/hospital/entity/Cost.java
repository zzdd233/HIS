package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Cost {
    @TableId(type = IdType.AUTO)
    Integer costId;
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

    public void setCostId(Integer costId) {
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

    public Integer getCostId() {
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
