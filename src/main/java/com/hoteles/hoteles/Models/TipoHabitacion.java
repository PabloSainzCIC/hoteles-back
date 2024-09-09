package com.hoteles.hoteles.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_HABITACION")
public class TipoHabitacion {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(name = "nombre_tipo", nullable = false)
    private String nombreTipo;
    
    private String descripcion;
    
    @Column(name = "minimo_metros_cuadrados", nullable = false)
    private float minimoMetrosCuadrados;
    
    @Column(name = "minimo_precio", nullable = false)
    private double minimoPrecio;

    @OneToMany(mappedBy = "tipoHabitacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getMinimoMetrosCuadrados() {
        return minimoMetrosCuadrados;
    }

    public void setMinimoMetrosCuadrados(float minimoMetrosCuadrados) {
        this.minimoMetrosCuadrados = minimoMetrosCuadrados;
    }

    public double getMinimoPrecio() {
        return minimoPrecio;
    }

    public void setMinimoPrecio(double minimoPrecio) {
        this.minimoPrecio = minimoPrecio;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    
}
