package com.example.hospital.service.impl;

import com.example.hospital.entity.Prescription;
import com.example.hospital.mapper.CostMapper;
import com.example.hospital.mapper.PrescriptionMapper;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    CostMapper costMapper;
    @Override
    public Integer getCost(String patientId) {
        return costMapper.getCostById(patientId);
    }

    @Override
    public boolean payCost() {
        return true;
    }

    @Autowired
    PrescriptionMapper prescriptionMapper;
    @Override
    public List<Prescription> getPrescription(String patientId) {
        return prescriptionMapper.getPrescriptionByPatientId(patientId);
    }
}
