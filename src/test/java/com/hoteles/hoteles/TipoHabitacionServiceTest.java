package com.hoteles.hoteles;


import com.hoteles.hoteles.Models.TipoHabitacion;

import com.hoteles.hoteles.Repositories.HabitacionRepository;
import com.hoteles.hoteles.Repositories.TipoHabitacionRepository;
import com.hoteles.hoteles.Services.TipoHabitacionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DirtiesContext
public class TipoHabitacionServiceTest {

    @Mock
    private TipoHabitacionRepository tipoHabitacionRepository;

    @Mock
    private HabitacionRepository habitacionRepository;

    @InjectMocks
    private TipoHabitacionService tipoHabitacionService;

    private TipoHabitacion tipoHabitacion;

    @BeforeEach
    public void setUp() {
        tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setId(UUID.randomUUID());
        tipoHabitacion.setNombreTipo("Suite");
        tipoHabitacion.setDescripcion("Suite con vista al mar");
        tipoHabitacion.setMinimoMetrosCuadrados(45.00f);
        tipoHabitacion.setMinimoPrecio(200.00);
        tipoHabitacion.setHabitaciones(new ArrayList<>());
    }

    @Test
    public void testCreateTipoHabitacion() {
        // Arrange
        when(tipoHabitacionRepository.save(any(TipoHabitacion.class))).thenReturn(tipoHabitacion);

        // Act
        TipoHabitacion savedTipoHabitacion = tipoHabitacionService.createTipoHabitacion(tipoHabitacion);

        // Assert
        assertNotNull(savedTipoHabitacion);
        assertEquals("Suite", savedTipoHabitacion.getNombreTipo());
        verify(tipoHabitacionRepository, times(1)).save(tipoHabitacion);
    }
}