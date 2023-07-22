package com.proyectoTaller1.taller1.dtos;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private int id;
    private String displayName;
}