package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class Nurse {
    @TableId
    String NurseId;
    String NurseName;
    Integer NurseAge;
    String NurseContact;

    public void setNurseId(String nurseId) {
        NurseId = nurseId;
    }

    public void setNurseName(String nurseName) {
        NurseName = nurseName;
    }

    public void setNurseAge(Integer nurseAge) {
        NurseAge = nurseAge;
    }

    public void setNurseContact(String nurseContact) {
        NurseContact = nurseContact;
    }

    public String getNurseId() {
        return NurseId;
    }

    public String getNurseName() {
        return NurseName;
    }

    public Integer getNurseAge() {
        return NurseAge;
    }

    public String getNurseContact() {
        return NurseContact;
    }
}
