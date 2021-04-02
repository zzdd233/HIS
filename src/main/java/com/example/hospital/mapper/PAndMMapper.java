package com.example.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hospital.entity.pandm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PAndMMapper extends BaseMapper<pandm> {
    @Select("select medicine_id from pandm p where " +
            "prescription_id=#{prescriptionId} ")
    List<String> getMedicineIdByPrescriptionId(String prescriptionId);

    @Select("select * from pandm where prescription_id = #{prescriptionId}")
    List<pandm> getMedicineAndNum(String prescriptionId);
}
