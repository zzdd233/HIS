package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Medicine {
    @TableId
    String medicineId;
    Integer medicinePrice;
    String medicineUsing;//药物使用说明


    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public void setMedicinePrice(Integer medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public void setMedicineUsing(String medicineUsing) {
        this.medicineUsing = medicineUsing;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public Integer getMedicinePrice() {
        return medicinePrice;
    }

    public String getMedicineUsing() {
        return medicineUsing;
    }
}
