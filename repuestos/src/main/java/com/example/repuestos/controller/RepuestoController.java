package com.example.repuestos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.repuestos.model.Repuesto;
import com.example.repuestos.service.RepuestoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/repuestos")
public class RepuestoController {

    private final RepuestoService repuestoService;

    @GetMapping
    public List<Repuesto> listarRepuestos() {
        return repuestoService.listarRepuestos();
    }

    @GetMapping("/buscar")
        public List<Repuesto> buscarPorMarcaYModelo(
                @RequestParam String marca,
                @RequestParam String modelo) {
            return repuestoService.buscarPorMarcaYModelo(marca, modelo);
        }

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

    @GetMapping("/consultar-vehiculos")
    public String consultarVehiculos() {
        return repuestoService.consultarVehiculos();
    }

    @GetMapping("/{id}/vehiculos")
    public String consultarVehiculosDelRepuesto(@PathVariable Long id) {
        return repuestoService.consultarVehiculosDelRepuesto(id);
    }
}
