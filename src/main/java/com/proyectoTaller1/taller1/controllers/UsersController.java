package com.proyectoTaller1.taller1.controllers;

import com.proyectoTaller1.taller1.dtos.AdminUserDTO;
import com.proyectoTaller1.taller1.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class UsersController {
    private final UserService userService;
    @PostMapping("users")
    public ResponseEntity<Void> create(@Valid AdminUserDTO userDTO, Errors errors){
        if(errors.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        userService.create(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
