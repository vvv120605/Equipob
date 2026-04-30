
package com.example.repuestos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.repuestos.model.Repuesto;
import com.example.repuestos.repository.RepuestoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RepuestoService {

    private final RepuestoRepository repuestoRepository;
    private final VehiculoClient vehiculoClient;

    public List<Repuesto> listarRepuestos() {
        return repuestoRepository.findAll();
    }

    public List<Repuesto> buscarPorMarcaYModelo(String marca, String modelo) {
        return repuestoRepository.findByMarcaIgnoreCaseAndModeloIgnoreCase(marca, modelo);
    }

    // Agregar repuesto nuevo
    public Repuesto agregarRepuesto(Repuesto repuesto) {
        return repuestoRepository.save(repuesto);
    }

    // Ver stock disponible
    public Integer verStock(Long id) {
        Repuesto rep = repuestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));

        return rep.getStock();
    }

    // Disminuir stock/ stock vendido
    public Repuesto disminuirStock(Long id, int cantidad) {
        Repuesto rep = repuestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));

        if (rep.getStock() < cantidad) {
            throw new RuntimeException("No hay stock disponible");
        }

        rep.setStock(rep.getStock() - cantidad);
        return repuestoRepository.save(rep);
    }

    // Aumentar stock/ingreso
    public Repuesto aumentarStock(Long id, int cantidad) {
        Repuesto rep = repuestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));

        rep.setStock(rep.getStock() + cantidad);
        return repuestoRepository.save(rep);
    }

    public String consultarVehiculos() {
        return vehiculoClient.consultarVehiculos();
    }

    public String consultarVehiculosDelRepuesto(Long id) {
        Repuesto repuesto = repuestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));

        return vehiculoClient.consultarVehiculosPorRepuesto(
                repuesto.getMarca(),
                repuesto.getModelo()
        );
    }
}
