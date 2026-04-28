package com.example.repuestos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "repuestos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Repuesto {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String modelo;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private Integer Stock;
    @Column(nullable = false)
    private String TipoRepuesto;

}
