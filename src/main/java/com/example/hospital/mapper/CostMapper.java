package com.example.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hospital.entity.Cost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CostMapper extends BaseMapper<Cost> {
    @Select("select all_cost from cost where patient_id=#{patientId}")
    Integer getCostById(String patientId);
}
