package com.hoteles.hoteles.Models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "HABITACION")
public class Habitacion {
    
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(nullable = false)
    private String hotel;
    
    @Column(nullable = false)
    private int planta;
    
    @Column(name = "num_habitacion", nullable = false)
    private int numHabitacion;
    
    @Column(nullable = false)
    private int pasillo;
    
    @ManyToOne
    @JoinColumn(name = "tipo_habitacion_id", nullable = false)
    private TipoHabitacion tipoHabitacion;
    
    private String descripcion;
    
    @Column(nullable = false)
    private boolean disponible;
    
    @Column(name = "precio_noche", nullable = false)
    private double precioNoche;
    
    @Column(nullable = false)
    private boolean calefaccion;
    
    @Column(name = "aire_acondicionado", nullable = false)
    private boolean aireAcondicionado;
    
    @Column(nullable = false)
    private boolean nevera;
    
    @Column(name = "metros_cuadrados", nullable = false)
    private float metrosCuadrados;

    @Column(name = "capacidad_maxima", nullable = false)
    private int capacidadMaxima;
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public int getPasillo() {
        return pasillo;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public boolean isCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(boolean calefaccion) {
        this.calefaccion = calefaccion;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isNevera() {
        return nevera;
    }

    public void setNevera(boolean nevera) {
        this.nevera = nevera;
    }

    public float getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(float metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    
  
}
