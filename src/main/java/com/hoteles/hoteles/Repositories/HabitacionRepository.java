package com.hoteles.hoteles.Repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import com.hoteles.hoteles.Models.Habitacion; 
import java.util.UUID;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, UUID> {
	
}
