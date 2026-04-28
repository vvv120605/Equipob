package com.example.repuestos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.repuestos.model.Repuesto;

public interface RepuestoRepository extends JpaRepository<Repuesto,Long> {
   
}

