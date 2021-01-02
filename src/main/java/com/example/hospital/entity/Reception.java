package com.example.hospital.entity;

public class Reception {//前台
    String patientId;
    String bedId;
    String costId;
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
