package com.example.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hospital.entity.Medicine;
import com.example.hospital.entity.PAndM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PAndMMapper extends BaseMapper<PAndM> {
    @Select("select medicine.* from medicine m,PAdnM p where " +
            "prescription_id=#{prescriptionId} " +
            "and m.medicine_id=p.medicine_id")
    List<Medicine> getMedicineById(String prescriptionId);
}
