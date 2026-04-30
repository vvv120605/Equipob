package com.example.repuestos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.repuestos.model.Repuesto;

public interface RepuestoRepository extends JpaRepository<Repuesto,Long> {
   
    List<Repuesto> findByMarcaIgnoreCaseAndModeloIgnoreCase(String marca, String modelo);
}

