package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum Permission {
    EXECUTE("e"),
    READ("r"),
    WRITE("w");


    private String value;

    private static final Map<String, Permission> permissionMap = new HashMap<>();

    static {
        for (Permission permission : Permission.values()){
            permissionMap.put(permission.value,permission);
        }
    }

    public static Permission of(String s) {
        return permissionMap.get(s);
    }

}
