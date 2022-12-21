package com.example.demo.controller;

import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers (){
        List<User> listUser = userRepository.findAll();

        List<UserDto> dtoList = new LinkedList<>();
        listUser.forEach( user -> {
            UserDto userDto = new UserDto();
//            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setGender(user.getGender());
            userDto.setPermissions(user.getPermissions());
            dtoList.add(userDto);
        });

        return ResponseEntity.ok(dtoList);
    }
}
