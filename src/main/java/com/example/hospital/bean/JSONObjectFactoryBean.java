package com.example.hospital.bean;

import org.json.JSONObject;
import org.springframework.beans.factory.FactoryBean;

public class JSONObjectFactoryBean implements FactoryBean<JSONObject> {
    @Override
    public JSONObject getObject() {
        return new JSONObject();
    }

    @Override
    public Class<?> getObjectType() {
        return JSONObject.class;
    }
}
