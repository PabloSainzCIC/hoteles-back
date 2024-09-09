package com.hoteles.hoteles.Repositories;

import org.springframework.stereotype.Repository;

import com.hoteles.hoteles.Models.TipoHabitacion;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, UUID> {
    
}
