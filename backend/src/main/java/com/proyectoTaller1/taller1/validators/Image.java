package com.proyectoTaller1.taller1.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ImageValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Image {
    String message() default "La imagen es necesaria";
    Class<?>[] groups() default {};;
    Class<? extends Payload>[] payload() default {};
    String[] skipMethod();
}