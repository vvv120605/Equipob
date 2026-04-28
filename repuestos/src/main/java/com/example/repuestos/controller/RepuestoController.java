package com.example.repuestos.controller;

import org.springframework.web.bind.annotation.*;

import com.example.repuestos.model.Repuesto;
import com.example.repuestos.service.RepuestoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/repuestos")
public class RepuestoController {

    private final RepuestoService repuestoService;

    // Ver stock
    @GetMapping("/stock")
    public Integer verStock(@RequestParam Long id) {
        return repuestoService.verStock(id);
    }

    // Agregar repuesto
    @PostMapping("/agregar")
    public Repuesto agregarRepuesto(@RequestBody Repuesto repuesto) {
        return repuestoService.agregarRepuesto(repuesto);
    }

    // Disminuir stock
    @PutMapping("/disminuir")
    public Repuesto disminuirStock(@RequestParam Long id,
                                   @RequestParam Integer Stock) {
        return repuestoService.disminuirStock(id, Stock);
    }

    // Aumentar stock
    @PutMapping("/aumentar")
    public Repuesto aumentarStock(@RequestParam Long id,
                                  @RequestParam Integer Stock) {
        return repuestoService.aumentarStock(id, Stock);
    }
}
