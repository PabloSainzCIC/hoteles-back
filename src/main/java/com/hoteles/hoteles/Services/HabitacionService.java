package com.hoteles.hoteles.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteles.hoteles.Models.Habitacion;
import com.hoteles.hoteles.Repositories.HabitacionRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    // Crear una nueva habitación
    public Habitacion createHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    // Obtener todas las habitaciones
    public List<Habitacion> getAllHabitaciones() {
        return habitacionRepository.findAll();
    }

    // Obtener una habitación por ID
    public Optional<Habitacion> getHabitacionById(UUID id) {
        return habitacionRepository.findById(id);
    }

    // Actualizar una habitación existente
    public Habitacion updateHabitacion(UUID id, Habitacion habitacion) {
        if (!habitacionRepository.existsById(id)) {
            throw new IllegalArgumentException("Habitación no encontrada con ID: " + id);
        }
        habitacion.setId(id);
        return habitacionRepository.save(habitacion);
    }

    // Eliminar una habitación por ID
    public void deleteHabitacion(UUID id) {
        if (!habitacionRepository.existsById(id)) {
            throw new IllegalArgumentException("Habitación no encontrada con ID: " + id);
        }
        habitacionRepository.deleteById(id);
    }
}