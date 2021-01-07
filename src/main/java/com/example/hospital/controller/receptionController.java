package com.example.hospital.controller;

import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Nurse;
import com.example.hospital.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reception")
@RestController
public class receptionController {
    @Autowired
    ReceptionService receptionService;

    @RequestMapping("/setCost")//设置费用
    public Integer setCost(String patientId,String costDetail,Integer cost){
        return  receptionService.setCost(patientId,costDetail,cost);
    }

    @RequestMapping("/setBed")//设置病人病床信息
    public Integer setBed(String bedId,String userId,String inDate){
        return receptionService.setBed(bedId,userId,inDate);
    }

    @RequestMapping("/leaveBed")//病人出院
    boolean leaveBed(String bedId,String patientId){
        return receptionService.leaveBed(bedId,patientId);
    }

    @RequestMapping("/insertDoctor") //添加医生信息
    public Integer insertDoctor(Doctor doctor){
        return receptionService.insertDoctor(doctor);
    }

    @RequestMapping("/insertNurser")//添加护士信息
    public Integer insertNurser(Nurse nurse){
        return receptionService.insertNurser(nurse);
    }

}
