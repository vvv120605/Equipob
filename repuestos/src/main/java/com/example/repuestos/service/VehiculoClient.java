package com.example.repuestos.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class VehiculoClient {

    private final WebClient vehiculoWebClient;

    public VehiculoClient(WebClient vehiculoWebClient) {
        this.vehiculoWebClient = vehiculoWebClient;
    }

    public String consultarVehiculos() {
        return vehiculoWebClient.get()
                .uri("/api/v1/vehiculos/list")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String consultarVehiculosPorRepuesto(String marca, String modelo) {
        return vehiculoWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/v1/vehiculos/buscar")
                        .queryParam("marca", marca)
                        .queryParam("modelo", modelo)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}