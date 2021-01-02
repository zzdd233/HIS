package com.example.hospital;

import com.example.hospital.entity.BodyData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class HospitalApplication {

    BodyData bodyData;
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

}
