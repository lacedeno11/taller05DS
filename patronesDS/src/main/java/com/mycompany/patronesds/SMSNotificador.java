/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patronesds;

/**
 *
 * @author abrahamcedeno
 */
public class SMSNotificador extends Notificador {
    @Override
    public void actualizar(Tarea tarea) {
        System.out.println("Enviando SMS sobre la tarea: " + tarea.getDescripcion());
    }
}

