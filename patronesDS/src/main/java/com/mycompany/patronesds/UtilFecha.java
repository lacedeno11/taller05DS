/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patronesds;

/**
 *
 * @author abrahamcedeno
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilFecha {
    public static Date convertirAFecha(String fechaString) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formato.parse(fechaString);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha.");
            return null;
        }
    }
}