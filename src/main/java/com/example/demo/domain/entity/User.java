package com.example.demo.domain.entity;


import com.example.demo.constant.Gender;
import com.example.demo.constant.Permission;
import com.example.demo.converter.GenderConverter;
import com.example.demo.converter.PermissionConverter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    @Convert(converter = GenderConverter.class)
    private Gender gender;

    @ElementCollection(targetClass = Permission.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_permission", joinColumns = {@JoinColumn(name = "user_id")})
    @Convert(converter = PermissionConverter.class)
    @Column(name = "permission")
    private List<Permission> permissions;

}
