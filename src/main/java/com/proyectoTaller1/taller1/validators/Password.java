package com.proyectoTaller1.taller1.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "La contraseña es necesaria";
    Class<?>[] groups() default {};;
    Class<? extends Payload>[] payload() default {};
    String[] skipMethod();
}