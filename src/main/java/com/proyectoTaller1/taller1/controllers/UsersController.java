package com.proyectoTaller1.taller1.controllers;

import com.proyectoTaller1.taller1.dtos.AdminUserDTO;
import com.proyectoTaller1.taller1.mappers.AdminUserMapper;
import com.proyectoTaller1.taller1.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class UsersController {
    private final UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<AdminUserDTO>> getAllAdminUser(){
        return new ResponseEntity<>(userService.getAllAdminUserDTO(), HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<AdminUserDTO> getAdminUser(@PathVariable Long id){
        try{
            return new ResponseEntity<>(userService.getAdminUserDTO(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("users")
    public ResponseEntity<Void> create(@Valid AdminUserDTO userDTO, Errors errors){
        if(errors.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        userService.create(userDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
