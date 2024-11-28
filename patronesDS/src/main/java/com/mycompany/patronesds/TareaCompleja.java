/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patronesds;

/**
 *
 * @author abrahamcedeno
 */
public class TareaCompleja extends Tarea {
    
    public TareaCompleja(String nombre) {
        super(nombre);
    }
    @Override
    public void ejecutarTarea() {
        System.out.println("Ejecutando tarea compleja: " + getDescripcion());
    }
}
