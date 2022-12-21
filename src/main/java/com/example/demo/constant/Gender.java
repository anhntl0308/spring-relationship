package com.example.demo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aspectj.weaver.GeneratedReferenceTypeDelegate;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("m"),
    FEMALE("f"),
    OTHER("o"),
    HIDDEN("h");

    private String value;

    private static final Map<String, Gender> genderMap = new HashMap<>();

    static {
        for (Gender gender : Gender.values()){
            genderMap.put(gender.value,gender);
        }
    }

    public static Gender of(String s) {
        return genderMap.get(s);
    }

}
