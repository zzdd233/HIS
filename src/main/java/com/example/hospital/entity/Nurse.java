package com.example.hospital.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Nurse {
    @TableId(type = IdType.AUTO)
    String nurseId;
    String nurseName;
    Integer nurseAge;
    String nurseContact;

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public void setNurseAge(Integer nurseAge) {
        this.nurseAge = nurseAge;
    }

    public void setNurseContact(String nurseContact) {
        this.nurseContact = nurseContact;
    }

    public String getNurseId() {
        return nurseId;
    }

    public String getNurseName() {
        return nurseName;
    }

    public Integer getNurseAge() {
        return nurseAge;
    }

    public String getNurseContact() {
        return nurseContact;
    }
}
