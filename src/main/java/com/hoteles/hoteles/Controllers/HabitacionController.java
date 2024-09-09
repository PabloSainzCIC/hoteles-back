package com.hoteles.hoteles.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hoteles.hoteles.Models.Habitacion;
import com.hoteles.hoteles.Repositories.HabitacionRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    // Crear una nueva habitación
    @PostMapping
    public ResponseEntity<Habitacion> createHabitacion(@RequestBody Habitacion habitacion) {
        Habitacion savedHabitacion = habitacionRepository.save(habitacion);
        return new ResponseEntity<>(savedHabitacion, HttpStatus.CREATED);
    }

    // Obtener todas las habitaciones
    @GetMapping
    public ResponseEntity<List<Habitacion>> getAllHabitaciones() {
        List<Habitacion> habitaciones = habitacionRepository.findAll();
        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }

    // Obtener una habitación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> getHabitacionById(@PathVariable UUID id) {
        Optional<Habitacion> habitacion = habitacionRepository.findById(id);
        return habitacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar una habitación existente
    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> updateHabitacion(@PathVariable UUID id, @RequestBody Habitacion habitacion) {
        if (!habitacionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } 
        Habitacion updatedHabitacion = habitacionRepository.save(habitacion);
        return new ResponseEntity<>(updatedHabitacion, HttpStatus.OK);
    }

    // Eliminar una habitación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitacion(@PathVariable UUID id) {
        if (!habitacionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        habitacionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
