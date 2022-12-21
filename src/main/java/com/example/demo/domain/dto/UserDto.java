package com.example.demo.domain.dto;

import com.example.demo.constant.Gender;
import com.example.demo.constant.Permission;
import com.example.demo.converter.GenderConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import java.util.List;

@Getter
@Setter
public class UserDto {
    private Long id;

    private String name;

    private Gender gender;

    private List<Permission> permissions;

}
