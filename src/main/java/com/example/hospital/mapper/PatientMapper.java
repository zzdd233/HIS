package com.example.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hospital.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface PatientMapper extends BaseMapper<Patient> {
    @Select("select treatment_history from patient where patient_id=#{PatientId}")
    String getTreatmentHistoryByPatientId(String PatientId);

    @Update("update patient " +
            "set treatment_history = #{treatmentHistory}" +
            "where patient_id=#{PatientId}")
    boolean setTreatmentHistory(String PatientId,String treatmentHistory);
}
