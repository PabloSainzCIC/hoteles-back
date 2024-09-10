package com.hoteles.hoteles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hoteles.hoteles.Models.TipoHabitacion;
import com.hoteles.hoteles.Repositories.HabitacionRepository;
import com.hoteles.hoteles.Repositories.TipoHabitacionRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TipoHabitacionControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @BeforeEach
    public void setUp() {
        tipoHabitacionRepository.deleteAll();
        habitacionRepository.deleteAll();
    }

    @Test
    public void contextLoads() {
        assertNotNull(restTemplate);
        assertNotNull(tipoHabitacionRepository);
        assertNotNull(habitacionRepository);
    }

    @Test
    public void testCreateTipoHabitacion() {
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setNombreTipo("Suite");
        tipoHabitacion.setMinimoMetrosCuadrados(45.0f);
        tipoHabitacion.setMinimoPrecio(200.0);

        ResponseEntity<TipoHabitacion> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/tipo-habitaciones",
                tipoHabitacion,
                TipoHabitacion.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getNombreTipo()).isEqualTo("Suite");
    }

    @Test
    public void testGetAllTipoHabitaciones() {
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setNombreTipo("Suite");
        tipoHabitacion.setMinimoMetrosCuadrados(45.0f);
        tipoHabitacion.setMinimoPrecio(200.0);
        tipoHabitacionRepository.save(tipoHabitacion);

        ResponseEntity<TipoHabitacion[]> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/tipo-habitaciones",
                TipoHabitacion[].class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().length).isGreaterThan(0);
    }

    @Test
    public void testGetTipoHabitacionById() {
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setNombreTipo("Suite");
        tipoHabitacion.setMinimoMetrosCuadrados(45.0f);
        tipoHabitacion.setMinimoPrecio(200.0);
        TipoHabitacion savedTipoHabitacion = tipoHabitacionRepository.save(tipoHabitacion);

        ResponseEntity<TipoHabitacion> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/tipo-habitaciones/" + savedTipoHabitacion.getId(),
                TipoHabitacion.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getNombreTipo()).isEqualTo("Suite");
    }

    @Test
    public void testUpdateTipoHabitacion() {
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setNombreTipo("Suite");
        tipoHabitacion.setMinimoMetrosCuadrados(45.0f);
        tipoHabitacion.setMinimoPrecio(200.0);
        TipoHabitacion savedTipoHabitacion = tipoHabitacionRepository.save(tipoHabitacion);

        savedTipoHabitacion.setNombreTipo("Suite Actualizada");

        restTemplate.put(
                "http://localhost:" + port + "/api/tipo-habitaciones/" + savedTipoHabitacion.getId(),
                savedTipoHabitacion
        );

        ResponseEntity<TipoHabitacion> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/tipo-habitaciones/" + savedTipoHabitacion.getId(),
                TipoHabitacion.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getNombreTipo()).isEqualTo("Suite Actualizada");
    }

    @Test
    public void testDeleteTipoHabitacion() {
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setNombreTipo("Suite");
        tipoHabitacion.setMinimoMetrosCuadrados(45.0f);
        tipoHabitacion.setMinimoPrecio(200.0);
        TipoHabitacion savedTipoHabitacion = tipoHabitacionRepository.save(tipoHabitacion);

        restTemplate.delete("http://localhost:" + port + "/api/tipo-habitaciones/" + savedTipoHabitacion.getId());

        ResponseEntity<TipoHabitacion> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/tipo-habitaciones/" + savedTipoHabitacion.getId(),
                TipoHabitacion.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
