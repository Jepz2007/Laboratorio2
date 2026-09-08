package Lab2.Laboratorio2;

import java.util.Scanner;

public class Parque {
    private int idParque;
    private String nombreParque;
    private String nombreEncargado;
    private PuntoAcceso[] puntosAcceso;

    public Parque(int idParque, String nombreParque, String nombreEncargado){
        this.idParque = idParque;
        this.nombreParque = nombreParque;
        this.nombreEncargado = nombreEncargado;
        this.puntosAcceso = new PuntoAcceso[5];
    }

    public void habilitarPuntoAcceso(int posicion, PuntoAcceso nuevoAcceso) {
        if (posicion < 0 || posicion >= puntosAcceso.length) {
            System.out.println("La posición no es válida.");
            return;
        }

        if (puntosAcceso[posicion] != null) {
            System.out.println("La posición ya está ocupada.");
            return;
        }else{
        puntosAcceso[posicion] = nuevoAcceso;
        System.out.println("Punto de acceso creado y habilitado.");
        }
    }

    public void consultarPuntosAcceso(){
        for (int i = 0; i < puntosAcceso.length; i++){
            if (puntosAcceso[i] != null && puntosAcceso[i].isEstado()){
                System.out.println();
                System.out.println("Punto de acceso: "+ (i+1));
                puntosAcceso[i].mostrarDatos();
            }
        }
        
    }
    public void consultarUnPuntoAcceso(){
        System.out.println("Ingrese el número de punto que desea consultar:");
        Scanner scanner = new Scanner(System.in);
        int posicion = scanner.nextInt();
        scanner.nextLine();

        if (posicion < 0 || posicion >= puntosAcceso.length) {
            System.out.println("La posición no es válida.");
            return;
        }
        if (puntosAcceso[posicion-1]==null){
            System.out.println("Punto de acceso no habilitado");
            return;
        }
        if (!puntosAcceso[posicion-1].isEstado()){  
            System.out.println("Punto de acceso no habilitado");
            return;
        }

        System.out.println();
        System.out.println("Punto de acceso: "+ posicion);
        puntosAcceso[posicion-1].mostrarDatos();
        
    }

    public void modificarCantMaxPA(){
        System.out.println("Ingrese el número de punto de acceso a modificar:");
        Scanner scanner = new Scanner(System.in);
        int posicion = scanner.nextInt();
        scanner.nextLine();

        if (posicion < 0 || posicion >= puntosAcceso.length) {
            System.out.println("La posición no es válida.");
            return;
        }
        if (puntosAcceso[posicion-1]==null){
            System.out.println("Punto de acceso no habilitado");
            return;
        }

        System.out.println("La capacidad máxima de este punto de acceso es de: " + puntosAcceso[posicion-1].getCapacidadMaxima());
        System.out.println();
        System.out.println("Indique la nueva capacidad máxima");
        int nuevacapacidad = scanner.nextInt();
        try {
            System.out.println("Indique la nueva capacidad máxima:");
            int nuevaCapacidad = scanner.nextInt();
            scanner.nextLine();

            puntosAcceso[posicion - 1].setCapacidadMaxima(nuevaCapacidad);
            System.out.println("Capacidad maxima modificada correctamente.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public void modificarEstado(){

        System.out.println("Ingrese el número de punto de acceso a modificar:");
        Scanner scanner = new Scanner(System.in);
        int posicion = scanner.nextInt();
        scanner.nextLine();

        if (posicion < 0 || posicion >= puntosAcceso.length) {
            System.out.println("La posición no es válida.");
            return;
        }
        if (puntosAcceso[posicion-1]==null){
            System.out.println("Punto de acceso no habilitado");
            return;
        }

        System.out.println("Estado actual: "  + puntosAcceso[posicion - 1].isEstado());

        System.out.println("1. Habilitar");
        System.out.println("2. Deshabilitar");
        System.out.print("Seleccione el nuevo estado: ");
        int nuevoestado = scanner.nextInt();
        scanner.nextLine();

        if (nuevoestado == 1) {
            puntosAcceso[posicion - 1].setEstado(true);
            System.out.println("Punto de acceso habilitado.");
        } else if (nuevoestado == 2) {
            puntosAcceso[posicion - 1].setEstado(false);
            System.out.println("Punto de acceso deshabilitado.");
        } else {
            System.out.println("Opción no válida.");
        }

    }

    public void cerrarPuntoAcceso(){
        System.out.println("Ingrese el número de punto de acceso a cerrar:");
        Scanner scanner = new Scanner(System.in);
        int posicion = scanner.nextInt();
        scanner.nextLine();

        if (posicion < 0 || posicion >= puntosAcceso.length) {
            System.out.println("La posición no es válida.");
            return;
        }
        if (puntosAcceso[posicion-1]==null){
            System.out.println("Punto de acceso no habilitado");
            return;
        }else{
            puntosAcceso[posicion-1] = null;
            System.out.println("Acceso cerrado correctamente");
        }
    }
    


    
}
