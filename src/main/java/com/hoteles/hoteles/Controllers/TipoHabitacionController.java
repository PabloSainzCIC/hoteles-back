package com.hoteles.hoteles.Controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteles.hoteles.Models.TipoHabitacion;
import com.hoteles.hoteles.Services.TipoHabitacionService;

@RestController
@RequestMapping("/api/tipo-habitaciones")
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionService tipoHabitacionService;

    // Crear un nuevo tipo de habitación
    @PostMapping
    public ResponseEntity<TipoHabitacion> createTipoHabitacion(@RequestBody TipoHabitacion tipoHabitacion) {
        TipoHabitacion savedTipoHabitacion = tipoHabitacionService.createTipoHabitacion(tipoHabitacion);
        return new ResponseEntity<>(savedTipoHabitacion, HttpStatus.CREATED);
    }

    // Obtener todos los tipos de habitación
    @GetMapping
    public ResponseEntity<List<TipoHabitacion>> getAllTipoHabitaciones() {
        List<TipoHabitacion> tipoHabitaciones = tipoHabitacionService.getAllTipoHabitaciones();
        return new ResponseEntity<>(tipoHabitaciones, HttpStatus.OK);
    }

    // Obtener un tipo de habitación por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacion> getTipoHabitacionById(@PathVariable UUID id) {
        Optional<TipoHabitacion> tipoHabitacion = tipoHabitacionService.getTipoHabitacionById(id);
        return tipoHabitacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un tipo de habitación existente
    @PutMapping("/{id}")
    public ResponseEntity<TipoHabitacion> updateTipoHabitacion(@PathVariable UUID id, @RequestBody TipoHabitacion tipoHabitacion) {
        TipoHabitacion updatedTipoHabitacion = tipoHabitacionService.updateTipoHabitacion(id, tipoHabitacion);
        return updatedTipoHabitacion != null ? new ResponseEntity<>(updatedTipoHabitacion, HttpStatus.OK) : ResponseEntity.notFound().build();
    }

    // Eliminar un tipo de habitación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoHabitacion(@PathVariable UUID id) {
        try {
            tipoHabitacionService.deleteTipoHabitacion(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // 409 Conflict
        }
    }
}