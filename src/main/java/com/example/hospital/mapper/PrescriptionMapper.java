package com.example.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hospital.entity.Prescription;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PrescriptionMapper extends BaseMapper<Prescription> {

    List<Prescription> getPrescriptionByPatientId(String patientId);
    String getMedicineNote(String prescriptionID);
}
