/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patronesds;

/**
 *
 * @author abrahamcedeno
 */
public class TareaSimple extends Tarea {
    
    
    public TareaSimple(String nombre){
    super(nombre);
    }
    @Override
    public void ejecutarTarea() {
        System.out.println("Ejecutando tarea simple: " + getDescripcion());
    }
}

