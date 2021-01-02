package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Doctor {
    @TableId
    String doctorId;
    String doctorName;
    Integer doctorAge;
    String doctorSex;
    String doctorContact;//医生联系方式
    String doctorDepartment;//所属科室

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDoctorAge(Integer doctorAge) {
        this.doctorAge = doctorAge;
    }

    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex;
    }

    public void setDoctorContact(String doctorContact) {
        this.doctorContact = doctorContact;
    }

    public void setDoctorDepartment(String doctorDepartment) {
        this.doctorDepartment = doctorDepartment;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Integer getDoctorAge() {
        return doctorAge;
    }

    public String getDoctorSex() {
        return doctorSex;
    }

    public String getDoctorContact() {
        return doctorContact;
    }

    public String getDoctorDepartment() {
        return doctorDepartment;
    }
}
