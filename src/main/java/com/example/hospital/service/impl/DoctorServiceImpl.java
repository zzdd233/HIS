package com.example.hospital.service.impl;

import com.example.hospital.entity.Patient;
import com.example.hospital.entity.Prescription;
import com.example.hospital.mapper.PatientMapper;
import com.example.hospital.mapper.PrescriptionMapper;
import com.example.hospital.service.DoctorService;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    PrescriptionMapper prescriptionMapper;
    @Override
    public String getTreatmentHistory(String PatientId) {
        return patientMapper.getTreatmentHistoryByPatientId(PatientId);
    }

    @Override
    public boolean setTreatmentHistory(String patientId,String treatmentHistory) {
        return patientMapper.setTreatmentHistory(patientId,treatmentHistory);
    }

    @Override
    public List<Prescription> getPrescription(String patientId) {
        return prescriptionMapper.getPrescriptionByPatientId(patientId);
    }

    @Override
    public Integer setPrescription(String DoctorId, String patientId, String operation, String medicineNotes) {
        Prescription prescription=new Prescription(patientId,DoctorId,operation,medicineNotes);
        return prescriptionMapper.insert(prescription);
    }

    @Override
    public Patient getPatientMessage(String PatientId) {
        return patientMapper.selectById(PatientId);
    }

    @Override
    public boolean setConditionReport(String patientId, String date, String conditionReport) {
        try {
            FileWriter fileWriter=new FileWriter("data/conditionReport/"+patientId+"_"+date+".txt",true);
            fileWriter.write(conditionReport);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean setDiagnosis(String patientId, String date,String diagnosis) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("data/diagnosis/"+patientId+"_"+date+".txt",true);
            fileWriter.write(diagnosis);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean setWardRoundRecord(String patientId, String date,String wardRoundRecord) {
        try {
            FileWriter fileWriter=new FileWriter("data/wardRoundRecord/"+patientId+"_"+date+".txt",true);
            fileWriter.write(wardRoundRecord);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String getConditionReport(String patientId,String date) {
        BufferedReader bufferedInputStream;
        StringBuilder s =new StringBuilder();
        try {
            bufferedInputStream = new BufferedReader(new FileReader("data/conditionReport/"+patientId+"_"+date+".txt"));
            String line = bufferedInputStream.readLine();
            while (line !=null){
                    s.append(line).append("\n");
                line = bufferedInputStream.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    @Override
    public String getWardRoundRecord(String patientId, String date) {
        BufferedReader bufferedInputStream;
        StringBuilder s =new StringBuilder();
        try {
            bufferedInputStream = new BufferedReader(new FileReader("data/wardRoundRecord/"+patientId+"_"+date+".txt"));
            String line = bufferedInputStream.readLine();
            while (line !=null){
                s.append(line).append("\n");
                line = bufferedInputStream.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    @Override
    public String getDiagnosis(String patientId,String date) {
        BufferedReader bufferedInputStream;
        StringBuilder s =new StringBuilder();
        try {
            bufferedInputStream = new BufferedReader(new FileReader("data/diagnosis/"+patientId+"_"+date+".txt"));
            String line = bufferedInputStream.readLine();
            while (line !=null){
                s.append(line).append("\n");
                line = bufferedInputStream.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }
}
