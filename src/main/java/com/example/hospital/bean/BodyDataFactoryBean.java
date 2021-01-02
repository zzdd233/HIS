package com.example.hospital.bean;

import com.example.hospital.entity.BodyData;

import org.springframework.beans.factory.FactoryBean;

import java.util.Map;

public class BodyDataFactoryBean implements FactoryBean<BodyData> {


    @Override
    public BodyData getObject() {
        return new BodyData();
    }

    @Override
    public Class<?> getObjectType() {
        return BodyData.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
