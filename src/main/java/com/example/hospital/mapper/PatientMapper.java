package com.example.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hospital.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface PatientMapper extends BaseMapper<Patient> {
    String getTreatmentHistoryByPatientId(String PatientId);
    boolean setTreatmentHistory(String PatientId,String treatmentHistory);
}
