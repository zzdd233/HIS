package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Prescription {//处方
    @TableId(type = IdType.AUTO)
    Integer prescriptionId;
    String patientId;
    String doctorId;
    String operation;//手术
    String medicineNotes;//药物使用备注

    public Prescription() {
    }

    public Prescription(String patientId, String doctorId, String operation, String medicineNotes) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.operation = operation;
        this.medicineNotes = medicineNotes;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setMedicineNotes(String medicineNotes) {
        this.medicineNotes = medicineNotes;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getOperation() {
        return operation;
    }

    public String getMedicineNotes() {
        return medicineNotes;
    }
}
