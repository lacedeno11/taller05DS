/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patronesds;

/**
 *
 * @author abrahamcedeno
 */
import java.util.List;

public class CalendarioVisualizacion implements VisualizacionStrategy {
    @Override
    public void visualizar(List<Tarea> tareas) {
        System.out.println("Visualizando tareas en calendario:");
        for (Tarea tarea : tareas) {
            System.out.println(tarea.getDescripcion());
        }
    }
}