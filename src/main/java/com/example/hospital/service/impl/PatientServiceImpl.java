package com.example.hospital.service.impl;

import com.example.hospital.entity.*;
import com.example.hospital.mapper.*;
import com.example.hospital.service.PatientService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    CostMapper costMapper;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    PAndMMapper pAndMMapper;
    @Autowired
    MedicineMapper medicineMapper;
    @Autowired
    PrescriptionMapper prescriptionMapper;
    @Autowired
    ReceptionMapper receptionMapper;

    @Override
    public Integer getCost(String patientId) {
        return costMapper.getCostById(patientId);
    }

    @Override
    public Integer payCost() {
        String userId = (String) SecurityUtils.getSubject().getPrincipal();
        Integer costId=receptionMapper.getCostIdByPatientId(userId);
        Cost cost =costMapper.selectById(costId);
        cost.setAllCost(0);
        return costMapper.updateById(cost);
    }


    @Override
    public List<Prescription> getPrescription(String patientId) {
        return prescriptionMapper.getPrescriptionByPatientId(patientId);
    }

    @Override
    public Patient getDetailMessage() {
        String userId = (String) SecurityUtils.getSubject().getPrincipal();
        return patientMapper.selectById(userId);
    }

    @Override
    public List<Medicine> getMedicineByPrescriptionId(String prescriptionId) {
        List<String> medicineIdList=pAndMMapper.getMedicineIdByPrescriptionId(prescriptionId);
        List<Medicine> medicineList=new ArrayList<>();
        for (String medicineId : medicineIdList) {
            medicineList.add(medicineMapper.selectById(medicineId));
        }
        return medicineList;
    }
}
