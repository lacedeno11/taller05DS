/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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

public class PatronesDS {

public static void main(String[] args) {
        // Crear la fachada para gestionar las tareas
        GestionTareasFacade facade = new GestionTareasFacade();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Mostrar menú de opciones
            System.out.println("----- Menú de Gestión de Tareas -----");
            System.out.println("1. Crear tarea");
            System.out.println("2. Asignar prioridad a tarea");
            System.out.println("3. Establecer fecha de vencimiento de tarea");
            System.out.println("4. Cambiar estado de tarea");
            System.out.println("5. Mostrar tareas");
            System.out.println("6. Asignar estrategia de visualización");
            System.out.println("7. Modificar descripción de tarea");
            System.out.println("8. Salir");
            System.out.print("Elija una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Crear tarea
                    System.out.print("Ingrese el nombre de la tarea: ");
                    String nombre = scanner.nextLine();
                    facade.crearTarea(nombre); // Ahora se pasa el nombre a la fachada
                    System.out.println("Tarea creada correctamente.");
                    break;
                
                case 2:
                    // Asignar prioridad a tarea
                    System.out.println("Seleccione la tarea para asignar prioridad:");
                    facade.mostrarTareas(); // Mostrar las tareas antes de asignar la prioridad
                    System.out.print("Ingrese el índice de la tarea (1 para la primera, 2 para la segunda, etc.): ");
                    int tareaIndexP = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consumir el salto de línea
                    System.out.print("Ingrese la prioridad (ALTA, MEDIA, BAJA): ");
                    String prioridadInput = scanner.nextLine().toUpperCase();
                    
                    Tarea tareaP = facade.getTareas().get(tareaIndexP);
                    facade.asignarPrioridad(tareaP, prioridadInput);
                    System.out.println("Prioridad asignada correctamente.");
                    break;

                case 3:
                    // Establecer fecha de vencimiento de tarea
                    System.out.println("Seleccione la tarea para asignar fecha de vencimiento:");
                    facade.mostrarTareas(); // Mostrar las tareas antes de establecer la fecha
                    System.out.print("Ingrese el índice de la tarea (1 para la primera, 2 para la segunda, etc.): ");
                    int tareaIndexF = scanner.nextInt() - 1;
                    System.out.print("Ingrese la fecha de vencimiento (dd/mm/yyyy): ");
                    String fechaString = scanner.next();
                    scanner.nextLine();  // Consumir el salto de línea
                    Date fechaVencimiento = UtilFecha.convertirAFecha(fechaString);
                    Tarea tareaF = facade.getTareas().get(tareaIndexF);
                    facade.establecerFechaVencimiento(tareaF, fechaVencimiento);
                    System.out.println("Fecha de vencimiento asignada correctamente.");
                    break;

                case 4:
                    // Cambiar estado de tarea
                    System.out.println("Seleccione la tarea para cambiar su estado:");
                    facade.mostrarTareas(); // Mostrar las tareas antes de cambiar el estado
                    System.out.print("Ingrese el índice de la tarea (1 para la primera, 2 para la segunda, etc.): ");
                    int tareaIndexS = scanner.nextInt() - 1;
                    System.out.print("Ingrese el nuevo estado (PENDIENTE, EN_PROCESO, COMPLETADA): ");
                    String estadoInput = scanner.next().toUpperCase();
                    EstadoTarea estado = EstadoTarea.valueOf(estadoInput);
                    scanner.nextLine();  // Consumir el salto de línea

                    Tarea tareaS = facade.getTareas().get(tareaIndexS);
                    facade.cambiarEstadoTarea(tareaS, estado);
                    System.out.println("Estado de tarea actualizado.");
                    break;

                case 5:
                    // Mostrar tareas
                    facade.mostrarTareas();
                    break;

                case 6:
                    // Asignar estrategia de visualización
                    System.out.println("Elija una estrategia de visualización:");
                    System.out.println("1. Lista");
                    System.out.println("2. Calendario");
                    System.out.println("3. Tablero");
                    int estrategiaInput = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    
                    VisualizacionStrategy estrategia = null;
                    switch (estrategiaInput) {
                        case 1:
                            estrategia = new ListaVisualizacion();
                            break;
                        case 2:
                            estrategia = new CalendarioVisualizacion();
                            break;
                        case 3:
                            estrategia = new TableroVisualizacion();
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    
                    if (estrategia != null) {
                        facade.asignarVisualizacion(estrategia);
                        System.out.println("Estrategia de visualización asignada.");
                    }
                    break;

                case 7:
                    // Modificar descripción de tarea
                    System.out.println("Seleccione la tarea para modificar su descripción:");
                    facade.mostrarTareas(); // Mostrar las tareas antes de modificar la descripción
                    System.out.print("Ingrese el índice de la tarea (1 para la primera, 2 para la segunda, etc.): ");
                    int tareaIndexD = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consumir el salto de línea
                    System.out.print("Ingrese la nueva descripción: ");
                    String nuevaDescripcion = scanner.nextLine();
                    
                    Tarea tareaD = facade.getTareas().get(tareaIndexD);
                    facade.modificarDescripcionTarea(tareaD, nuevaDescripcion);
                    System.out.println("Descripción de la tarea modificada.");
                    break;

                case 8:
                    // Salir
                    System.out.println("¡Adiós!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}