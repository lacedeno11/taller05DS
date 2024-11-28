/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patronesds;

/**
 *
 * @author abrahamcedeno
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class GestionTareasFacade {
    private List<Tarea> tareas = new ArrayList<>();
    private VisualizacionStrategy estrategiaVisualizacion;
    private List<Notificador> notificadores = new ArrayList<>();

    // Crear tarea de tipo simple o compleja
    public void crearTarea(String nombre) {
        Scanner scanner = new Scanner(System.in);
        
        // Mostrar opciones para elegir el tipo de tarea
        System.out.println("Elija el tipo de tarea:");
        System.out.println("0. Simple");
        System.out.println("1. Compleja");
        System.out.print("Ingrese su opción (0 para simple, 1 para compleja): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        String tipo = (opcion == 0) ? "simple" : "compleja";
        
        TareaFactory factory;
        if ("simple".equals(tipo)) {
            factory = new TareaSimpleFactory();
        } else {
            factory = new TareaComplejaFactory();
        }

        Tarea tarea = factory.crearTarea(nombre);
        tarea.setEstado(EstadoTarea.PENDIENTE);
        
        System.out.println("Ingrese una descripción para su tarea:");
        tarea.setDescripcion(scanner.nextLine());

        // Agregar observadores para notificación
        tarea.agregarObservador(new EmailNotificador());
        tarea.agregarObservador(new SMSNotificador());

        tareas.add(tarea);
        tarea.ejecutarTarea();  // Ejecutar automáticamente
        System.out.println("Tarea creada correctamente: " + nombre);
    }

    // Modificar descripción de tarea
    public void modificarDescripcionTarea(Tarea tarea, String nuevaDescripcion) {
        tarea.setDescripcion(nuevaDescripcion);
    }

    // Asignar prioridad a una tarea
    public void asignarPrioridad(Tarea tarea, String prioridad) {
        tarea.setPrioridad(prioridad);
    }

    // Establecer fecha de vencimiento para la tarea
    public void establecerFechaVencimiento(Tarea tarea, Date fecha) {
        tarea.setFechaVencimiento(fecha);
    }

    // Cambiar estado de la tarea
    public void cambiarEstadoTarea(Tarea tarea, EstadoTarea estado) {
        tarea.setEstado(estado);
    }

    // Asignar estrategia de visualización
    public void asignarVisualizacion(VisualizacionStrategy estrategia) {
        this.estrategiaVisualizacion = estrategia;
    }

    // Mostrar tareas usando la estrategia de visualización
    public void mostrarTareas() {
        if (estrategiaVisualizacion != null) {
            estrategiaVisualizacion.visualizar(tareas);
        } else {
            // Si no hay estrategia, mostrar las tareas por defecto
            System.out.println("Lista de tareas:");
            for (int i = 0; i < tareas.size(); i++) {
                Tarea tarea = tareas.get(i);
                System.out.println((i + 1) + ". " + tarea.getNombre());
            }
        }
    }

    // Agregar un notificador a la lista de notificadores
    public void agregarNotificador(Notificador notificador) {
        this.notificadores.add(notificador);
    }

    // Obtener la lista de tareas
    public List<Tarea> getTareas() {
        return tareas;
    }
}