package com.example.hospital.config;

import com.example.hospital.bean.BodyDataFactoryBean;
import com.example.hospital.bean.JSONObjectFactoryBean;
import com.example.hospital.bean.UserFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigration {
    @Bean
    public BodyDataFactoryBean bodyDataFactoryBean(){
        return new BodyDataFactoryBean();
    }
    @Bean
    public JSONObjectFactoryBean jsonObjectFactoryBean(){
        return new JSONObjectFactoryBean();
    }
    @Bean
    public UserFactoryBean userFactoryBean(){
        return new UserFactoryBean();
    }
}
