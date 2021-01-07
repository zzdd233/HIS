package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class PAndM {
    @TableId
    String prescriptionId;
    @TableId
    String medicineId;

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }
}
