package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class pandm {
    @TableId
    Integer prescriptionId;
    @TableId
    String medicineId;
    Integer medicineNum;

    public void setMedicineNum(Integer medicineNum) {
        this.medicineNum = medicineNum;
    }

    public Integer getMedicineNum() {
        return medicineNum;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }
}
