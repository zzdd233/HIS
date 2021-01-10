package com.example.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hospital.entity.Prescription;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PrescriptionMapper extends BaseMapper<Prescription> {
    @Select("select * from prescription where patient_id =#{patientId}")
    List<Prescription> getPrescriptionByPatientId(String patientId);

    @Select("select medicine_note from prescription where patient_id =#{patientId}")
    String getMedicineNote(String prescriptionId);
}
