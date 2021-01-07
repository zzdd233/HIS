package com.example.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hospital.entity.Reception;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReceptionMapper extends BaseMapper<Reception> {
    @Select("select patient_id from Reception where bed_id=#{bedId}")
    String getPatientIdByBedId(String bedId);

    @Select("select prescription_id from Reception where bed_id=#{bedId}")
    String getPrescriptionIdByBedId(String bedId);//通过病床号获取处方号

    @Select("select bed_id from Reception where patient_id=#{PatientId}")
    String getBedIdByPatientId(String PatientId);//通过病人号获取病床号

    @Select("select cost_id from Reception where patient_id=#{PatientId}")
    String getCostIdByPatientId(String PatientId);//通过病人号获取费用号

    @Select("select prescription_id from Reception where patient_id=#{PatientId}")
    String getPrescriptionIdByPatientId(String PatientId);//通过病人号获取处方号
}
