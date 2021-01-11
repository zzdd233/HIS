package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Bed {//病床
    @TableId
    String bedId;
    String patientId;
    String inDate;//病人入住日期
    Integer bedCost;//病床费用



    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public void setBedCost(Integer bedCost) {
        this.bedCost = bedCost;
    }

    public String getBedId() {
        return bedId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getInDate() {
        return inDate;
    }

    public Integer getBedCost() {
        return bedCost;
    }
}
