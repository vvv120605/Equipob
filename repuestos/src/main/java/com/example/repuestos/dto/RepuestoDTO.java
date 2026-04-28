package com.example.repuestos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RepuestoDTO {

    @NotBlank(message = "El modelo no puede estar vacío")
    @Size(min = 3, max = 20, message = "El modelo debe tener entre 3 y 15 caracteres")
    private String modelo;

    @NotBlank(message = "El nombre del repuesto no puede estar vacío")
    @Size(min = 3, max = 20, message = "El nombre del repuesto debe tener entre 3 y 20 caracteres")
    private String nombre;

    @NotBlank(message = "El nombre de la marca no puede estar vacío")
    @Min(value = 1, message = "El nombre de la marca debe tener al menos desde 1 caracter")
    private String marca;

    @NotNull(message = "El stock no puede ser nulo")
    @Min(value = 1, message = "El stock debe ser mayor o igual a 1")
    private Integer Stock;

    @NotBlank(message = "El tipo de respuesto no puede estar vacío")
    @Min(value = 1, message = "El tipo de respuesto debe tener al menos desde 1 caracter")
    private String TipoRepuesto;

}
