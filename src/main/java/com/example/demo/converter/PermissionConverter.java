package com.example.demo.converter;

import com.example.demo.constant.Permission;

import javax.persistence.AttributeConverter;

public class PermissionConverter implements AttributeConverter<Permission, String> {
    @Override
    public String convertToDatabaseColumn(Permission attribute) {
        return attribute.getValue();
    }

    @Override
    public Permission convertToEntityAttribute(String dbData) {
        return Permission.of(dbData);
    }
}
