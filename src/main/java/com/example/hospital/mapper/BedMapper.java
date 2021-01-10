package com.example.hospital.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hospital.entity.Bed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BedMapper extends BaseMapper<Bed> {
    @Select("select bed_num from bed where bed_id=#{bedId}")
    Integer selectBedNumById(String bedId);

    @Select("update bed " +
            "set patient_id = null,in_date=null " +
            "where bed_id =#{bedId}")
    void leaveBed(String  bedId);//病人出院

    @Select("select * from bed")
    List<Bed> getBeds();//获取所有病床信息

}
