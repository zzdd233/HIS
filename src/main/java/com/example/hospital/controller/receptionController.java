package com.example.hospital.controller;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Nurse;
import com.example.hospital.mapper.DoctorMapper;
import com.example.hospital.mapper.NurseMapper;
import com.example.hospital.service.ReceptionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reception")
@RestController
public class receptionController {
    @Autowired
    ReceptionService receptionService;
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    NurseMapper nurseMapper;

    @RequestMapping("/setCost")//设置费用
    public Integer setCost(String patientId,String costDetail,Integer cost){
        return  receptionService.setCost(patientId,costDetail,cost);
    }

    @RequestMapping("/setBed")//设置病人病床信息
    public Integer setBed(String bedId, String userId, String inDate){
        return receptionService.setBed(bedId,userId,inDate);
    }

    @RequestMapping("/leaveBed")//病人出院
    boolean leaveBed(String bedId, String patientId){
        return receptionService.leaveBed(bedId,patientId);
    }

    @RequestMapping("/insertDoctor") //添加医生信息
    public Integer insertDoctor(Doctor doctor){
        return receptionService.insertDoctor(doctor);
    }

    @RequestMapping("/insertNurse")//添加护士信息
    public Integer insertNurse(Nurse nurse){
        return receptionService.insertNurse(nurse);
    }

    @RequestMapping("/getDoctor")//获取医生信息
    public Doctor getDoctor(){
        String userId = (String) SecurityUtils.getSubject().getPrincipal();
        return doctorMapper.selectById(userId);
    }

    @RequestMapping("/getNurse")//获取护士信息
    public Nurse getNurse(){
        String userId = (String) SecurityUtils.getSubject().getPrincipal();
        return nurseMapper.selectById(userId);
    }

}
