/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patronesds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author abrahamcedeno
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Tarea implements Observable {
    private String descripcion;
    private EstadoTarea estado;
    private Date fechaVencimiento;
    private List<Observador> observadores;
    private String prioridad;
    private String nombre;  

    public Tarea(String nombre) {  // Constructor con nombre
        this.nombre = nombre;
        this.observadores = new ArrayList<>();
    }

    // Métodos para gestionar la descripción
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos para gestionar el estado
    public EstadoTarea getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
        notificarObservadores(); // Notificar a los observadores cuando cambie el estado
    }

    // Métodos para gestionar observadores
    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(this);
        }
    }

    // Método abstracto para ejecutar la tarea
    public abstract void ejecutarTarea();

    // Métodos para gestionar la prioridad y fecha de vencimiento
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public void setFechaVencimiento(Date fecha) {
        this.fechaVencimiento = fecha;
    }

    // Métodos para gestionar el nombre de la tarea
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

