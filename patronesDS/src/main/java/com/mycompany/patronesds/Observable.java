/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.patronesds;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author abrahamcedeno
 */
public interface Observable {
    void agregarObservador(Observador observador);
    void eliminarObservador(Observador observador);
    void notificarObservadores();
}