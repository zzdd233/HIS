package com.example.hospital.service.impl;

import com.example.hospital.entity.Bed;
import com.example.hospital.entity.Cost;
import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Nurse;
import com.example.hospital.mapper.*;
import com.example.hospital.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class ReceptionServiceImpl implements ReceptionService {
    @Autowired
    ReceptionMapper receptionMapper;
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    NurseMapper nurseMapper;
    @Autowired
    CostMapper costMapper;
    @Autowired
    BedMapper bedMapper;

    @Override
    public Integer setCost(String patientId, String costDetail, Integer allCost) {
        String costId=receptionMapper.getCostIdByPatientId(patientId);
        String prescriptionId=receptionMapper.getPrescriptionIdByPatientId(patientId);

        Cost cost=new Cost();
        cost.setAllCost(allCost);
        cost.setDetailedCost(costDetail);
        cost.setPatientId(patientId);
        cost.setPrescriptionId(prescriptionId);

        if(costId==null){
            return costMapper.insert(cost);
        }else{
            cost.setCostId(costId);
            return costMapper.updateById(cost);
        }
    }

    @Override
    public Integer setBed(String bedId, String patientId,String inDate) {
        Bed bed1=bedMapper.selectById(bedId);
        if(bed1.getPatientId().isEmpty()){
            Bed bed=new Bed();
            bed.setBedId(bedId);
            bed.setBedCost(bed1.getBedCost());
            bed.setBedNum(bed1.getBedNum());
            bed.setInDate(inDate);
            bed.setPatientId(patientId);
            return bedMapper.updateById(bed);
        }
        return 0;
    }

    @Override
    public boolean leaveBed(String bedId, String patientId) {
        Bed bed=bedMapper.selectById(bedId);
        if(bed.getPatientId().equals(patientId)){
            bedMapper.leaveBed(bedId);
            return true;
        }
        return false;
    }

    @Override
    public Integer insertDoctor(Doctor doctor) {
        return doctorMapper.insert(doctor);
    }

    @Override
    public Integer insertNurser(Nurse nurse) {
        return nurseMapper.insert(nurse);
    }
}
