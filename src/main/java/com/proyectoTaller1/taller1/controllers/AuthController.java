package com.proyectoTaller1.taller1.controllers;

import com.proyectoTaller1.taller1.security.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class AuthController {
    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public String token(Authentication authentication) {
        String token = tokenService.generateToken(authentication);
        return token;
    }
}
