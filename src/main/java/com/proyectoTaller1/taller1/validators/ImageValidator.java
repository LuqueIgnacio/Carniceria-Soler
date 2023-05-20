package com.proyectoTaller1.taller1.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class ImageValidator implements ConstraintValidator<Image, MultipartFile> {
    private String[] skipMethod;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(Image constraintAnnotation) {
        this.skipMethod = constraintAnnotation.skipMethod();
    }

    @Override
    public boolean isValid(MultipartFile image, ConstraintValidatorContext context) {
        if (Arrays.asList(this.skipMethod).contains(request.getMethod()) && image.isEmpty()) {
            return true;
        }

        return !image.isEmpty();
    }
}
