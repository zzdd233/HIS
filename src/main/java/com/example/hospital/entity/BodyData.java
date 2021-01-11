package com.example.hospital.entity;

import org.springframework.boot.jackson.JsonComponent;


@JsonComponent
public class BodyData {//身体状况
    public String patientName;//患者姓名
    public Integer heartbeat;//心跳
    public Double temperature;//体温
    public Integer systolicPressure;//收缩压
    public Integer diastolicPressure;//舒张压
    public Double bloodOxygenContent;//血氧含量
    //private Queue<BodyData> History

    public BodyData(){}

//


    public BodyData(Integer heartbeat, Double temperature, Integer systolicPressure, Integer diastolicPressure, Double bloodOxygenContent) {
        this.heartbeat = heartbeat;
        this.temperature = temperature;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.bloodOxygenContent = bloodOxygenContent;
    }

    public BodyData(String patientName , Integer heartbeat, Double temperature, Integer systolicPressure, Integer diastolicPressure, Double bloodOxygenContent) {
        this.patientName = patientName;
        this.heartbeat = heartbeat;
        this.temperature = temperature;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.bloodOxygenContent = bloodOxygenContent;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setDiastolicPressure(Integer diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public Integer getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setHeartbeat(Integer heartbeat) {
        this.heartbeat = heartbeat;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setSystolicPressure(Integer systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public void setBloodOxygenContent(Double bloodOxygenContent) {
        this.bloodOxygenContent = bloodOxygenContent;
    }


    public Integer getHeartbeat() {
        return heartbeat;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Integer getSystolicPressure() {
        return systolicPressure;
    }

    public Double getBloodOxygenContent() {
        return bloodOxygenContent;
    }

}
