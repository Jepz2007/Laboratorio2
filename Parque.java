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
            if (puntosAcceso[i] != null){
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

        System.out.println();
        System.out.println("Punto de acceso: "+ posicion);
        puntosAcceso[posicion-1].mostrarDatos();
        
    }
    


    
}
