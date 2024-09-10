package com.hoteles.hoteles.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteles.hoteles.Models.TipoHabitacion;
import com.hoteles.hoteles.Repositories.HabitacionRepository;
import com.hoteles.hoteles.Repositories.TipoHabitacionRepository;

@Service
public class TipoHabitacionService {

   @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    // Crear un nuevo tipo de habitación
    public TipoHabitacion createTipoHabitacion(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionRepository.save(tipoHabitacion);
    }

    // Obtener todos los tipos de habitación
    public List<TipoHabitacion> getAllTipoHabitaciones() {
        return tipoHabitacionRepository.findAll();
    }

    // Obtener un tipo de habitación por ID
    public Optional<TipoHabitacion> getTipoHabitacionById(UUID id) {
        return tipoHabitacionRepository.findById(id);
    }

    // Actualizar un tipo de habitación existente
    public TipoHabitacion updateTipoHabitacion(UUID id, TipoHabitacion tipoHabitacion) {
        if (tipoHabitacionRepository.existsById(id)) {
            tipoHabitacion.setId(id);
            return tipoHabitacionRepository.save(tipoHabitacion);
        }
        return null;
    }

    // Eliminar un tipo de habitación por ID
    public void deleteTipoHabitacion(UUID id) {
        if (!tipoHabitacionRepository.existsById(id)) {
            throw new IllegalArgumentException("Tipo de habitación no encontrado con ID: " + id);
        }
        if (habitacionRepository.existsByTipoHabitacionId(id)) {
            throw new IllegalStateException("No se puede eliminar el tipo de habitación porque tiene habitaciones asociadas");
        }
        tipoHabitacionRepository.deleteById(id);
    }

    
}