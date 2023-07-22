package com.proyectoTaller1.taller1.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    private String[] skipMethod;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(Password constraintAnnotation) {
        this.skipMethod = constraintAnnotation.skipMethod();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (Arrays.asList(this.skipMethod).contains(request.getMethod()) && password == null) {
            return true;
        }

        return password != null && !password.isEmpty();
    }
}
