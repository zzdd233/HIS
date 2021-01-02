package com.example.hospital.entity;

public class Bed {//病床

    String bedId;
    String patientId;
    String inDate;//病人入住日期
    Integer bedCost;//病床费用
    Integer bedNum;

    public void setBedNum(Integer bedNum) {
        this.bedNum = bedNum;
    }

    public Integer getBedNum() {
        return bedNum;
    }

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
