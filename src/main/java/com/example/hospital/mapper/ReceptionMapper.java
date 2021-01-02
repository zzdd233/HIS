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
    String getPrescriptionIdByBedId(String bedId);//通过病床号获取处方号
    String getBedIdByPatientId(String PatientId);//通过病人号获取病床号
}
