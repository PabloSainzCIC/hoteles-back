package com.hoteles.hoteles;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.hoteles.hoteles.Models.Habitacion;
import com.hoteles.hoteles.Models.TipoHabitacion;
import com.hoteles.hoteles.Repositories.HabitacionRepository;
import com.hoteles.hoteles.Repositories.TipoHabitacionRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class HabitacionControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @BeforeEach
    public void setUp() {
        habitacionRepository.deleteAll();
        tipoHabitacionRepository.deleteAll();
    }
        @Test
    public void contextLoads() {
        assertNotNull(restTemplate);
        assertNotNull(habitacionRepository);
        assertNotNull(tipoHabitacionRepository);
    }

    @Test
    public void testCreateHabitacion() {
        
        TipoHabitacion tipo = new TipoHabitacion();
        tipo.setNombreTipo("Suite");
        tipo.setMinimoMetrosCuadrados(45.0f);
        tipo.setMinimoPrecio(200.0);
       
        tipoHabitacionRepository.save(tipo);

        Habitacion habitacion = new Habitacion();
        habitacion.setHotel("Hotel Central");
        habitacion.setPlanta(3);
        habitacion.setNumHabitacion(301);
        habitacion.setPasillo(1);
        habitacion.setTipoHabitacion(tipo);
        habitacion.setDescripcion("Suite con vista al mar, jacuzzi privado");
        habitacion.setDisponible(true);
        habitacion.setPrecioNoche(250.0);
        habitacion.setCalefaccion(true);
        habitacion.setAireAcondicionado(true);
        habitacion.setNevera(true);
        habitacion.setMetrosCuadrados(50.0f);
        habitacion.setCapacidadMaxima(4);

        ResponseEntity<Habitacion> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/habitaciones",
                habitacion,
                Habitacion.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getHotel()).isEqualTo("Hotel Central");
    }

    @Test
    public void testGetAllHabitaciones() {
        TipoHabitacion tipo = new TipoHabitacion();
        tipo.setNombreTipo("Suite");
        tipo.setMinimoMetrosCuadrados(45.0f);
        tipo.setMinimoPrecio(200.0);
        tipoHabitacionRepository.save(tipo);

        Habitacion habitacion = new Habitacion();
        habitacion.setHotel("Hotel Central");
        habitacion.setPlanta(3);
        habitacion.setNumHabitacion(301);
        habitacion.setPasillo(1);
        habitacion.setTipoHabitacion(tipo);
        habitacion.setDescripcion("Suite con vista al mar, jacuzzi privado");
        habitacion.setDisponible(true);
        habitacion.setPrecioNoche(250.0);
        habitacion.setCalefaccion(true);
        habitacion.setAireAcondicionado(true);
        habitacion.setNevera(true);
        habitacion.setMetrosCuadrados(50.0f);
        habitacion.setCapacidadMaxima(4);

        habitacionRepository.save(habitacion);

        ResponseEntity<Habitacion[]> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/habitaciones",
                Habitacion[].class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().length).isGreaterThan(0);
    }

    @Test
    public void testGetHabitacionById() {
        TipoHabitacion tipo = new TipoHabitacion();
        tipo.setNombreTipo("Suite");
        tipo.setMinimoMetrosCuadrados(45.0f);
        tipo.setMinimoPrecio(200.0);
        tipoHabitacionRepository.save(tipo);

        Habitacion habitacion = new Habitacion();
        habitacion.setHotel("Hotel Central");
        habitacion.setPlanta(3);
        habitacion.setNumHabitacion(301);
        habitacion.setPasillo(1);
        habitacion.setTipoHabitacion(tipo);
        habitacion.setDescripcion("Suite con vista al mar, jacuzzi privado");
        habitacion.setDisponible(true);
        habitacion.setPrecioNoche(250.0);
        habitacion.setCalefaccion(true);
        habitacion.setAireAcondicionado(true);
        habitacion.setNevera(true);
        habitacion.setMetrosCuadrados(50.0f);
        habitacion.setCapacidadMaxima(4);

        Habitacion savedHabitacion = habitacionRepository.save(habitacion);

        ResponseEntity<Habitacion> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/habitaciones/" + savedHabitacion.getId(),
                Habitacion.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getDescripcion()).isEqualTo("Suite con vista al mar, jacuzzi privado");
    }

    @Test
    public void testUpdateHabitacion() {
        TipoHabitacion tipo = new TipoHabitacion();
        tipo.setNombreTipo("Suite");
        tipo.setMinimoMetrosCuadrados(45.0f);
        tipo.setMinimoPrecio(200.0);
        tipoHabitacionRepository.save(tipo);

        Habitacion habitacion = new Habitacion();
        habitacion.setHotel("Hotel Central");
        habitacion.setPlanta(3);
        habitacion.setNumHabitacion(301);
        habitacion.setPasillo(1);
        habitacion.setTipoHabitacion(tipo);
        habitacion.setDescripcion("Suite con vista al mar, jacuzzi privado");
        habitacion.setDisponible(true);
        habitacion.setPrecioNoche(250.0);
        habitacion.setCalefaccion(true);
        habitacion.setAireAcondicionado(true);
        habitacion.setNevera(true);
        habitacion.setMetrosCuadrados(50.0f);
        habitacion.setCapacidadMaxima(4);

        Habitacion savedHabitacion = habitacionRepository.save(habitacion);

        habitacion.setDescripcion("Suite actualizada");

        restTemplate.put(
                "http://localhost:" + port + "/api/habitaciones/" + savedHabitacion.getId(),
                habitacion
        );

        ResponseEntity<Habitacion> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/habitaciones/" + savedHabitacion.getId(),
                Habitacion.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getDescripcion()).isEqualTo("Suite actualizada");
    }

    @Test
    public void testDeleteHabitacion() {
        TipoHabitacion tipo = new TipoHabitacion();
        tipo.setNombreTipo("Suite");
        tipo.setMinimoMetrosCuadrados(45.0f);
        tipo.setMinimoPrecio(200.0);
        tipoHabitacionRepository.save(tipo);

        Habitacion habitacion = new Habitacion();
        habitacion.setHotel("Hotel Central");
        habitacion.setPlanta(3);
        habitacion.setNumHabitacion(301);
        habitacion.setPasillo(1);
        habitacion.setTipoHabitacion(tipo);
        habitacion.setDescripcion("Suite con vista al mar, jacuzzi privado");
        habitacion.setDisponible(true);
        habitacion.setPrecioNoche(250.0);
        habitacion.setCalefaccion(true);
        habitacion.setAireAcondicionado(true);
        habitacion.setNevera(true);
        habitacion.setMetrosCuadrados(50.0f);
        habitacion.setCapacidadMaxima(4);

        Habitacion savedHabitacion = habitacionRepository.save(habitacion);

        restTemplate.delete("http://localhost:" + port + "/api/habitaciones/" + savedHabitacion.getId());

        ResponseEntity<Habitacion> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/habitaciones/" + savedHabitacion.getId(),
                Habitacion.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
