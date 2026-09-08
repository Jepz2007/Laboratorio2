package Lab2.Laboratorio2;

import java.util.Scanner;
import java.util.ArrayList;

public class Parque {
    private int idParque;
    private String nombreParque;
    private String nombreEncargado;
    private PuntoAcceso[] puntosAcceso;
    private ArrayList <Visitantes> visitantes;

    public Parque(int idParque, String nombreParque, String nombreEncargado){
        this.idParque = idParque;
        this.nombreParque = nombreParque;
        this.nombreEncargado = nombreEncargado;
        this.puntosAcceso = new PuntoAcceso[5];
        this.visitantes = new ArrayList <>();
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

        if (posicion < 1 || posicion > puntosAcceso.length) {
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

        if (posicion < 1 || posicion >= puntosAcceso.length) {
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

        if (posicion < 1 || posicion >= puntosAcceso.length) {
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
    
    public void registrarVisitante(Visitantes nuevoVisitante) {
        if (nuevoVisitante == null) {
            System.out.println(
                "No se puede registrar un visitante inválido."
            );
            return;
        }

        for (Visitantes visitanteRegistrado : visitantes) {
            if (visitanteRegistrado.getCodigoEntrada() == nuevoVisitante.getCodigoEntrada()) {
                System.out.println("Ya existe un visitante con ese código de entrada.");
                return;
            }
        }

        visitantes.add(nuevoVisitante);
        System.out.println("Visitante registrado correctamente.");
    }

    public void consultarVisitantes() {
        if (visitantes.isEmpty()) {
            System.out.println(
                "Todavía no existen visitantes registrados."
            );
            return;
        }

        System.out.println();
        System.out.println("VISITANTES REGISTRADOS");

        for (Visitantes visitante : visitantes) {
            System.out.println();
            visitante.mostrarDatos();
        }
    }

    public Visitantes buscarVisitante(int codigoEntrada) {
        for (Visitantes visitante : visitantes) {
            if (visitante.getCodigoEntrada() == codigoEntrada) {
                return visitante;
            }
        }
        return null; 
    }

    public void consultarVisitantePorCodigo(int codigoEntrada) {
        Visitantes visitanteEncontrado = buscarVisitante(codigoEntrada);

        if (visitanteEncontrado == null) {
            System.out.println("No existe un visitante con ese código de entrada.");
            return;
        }

        System.out.println();
        System.out.println("VISITANTE ENCONTRADO");
        visitanteEncontrado.mostrarDatos();
    }

    public void modificarVisitante(int codigoActual, int nuevoCodigo, String nuevoNombre, int nuevaEdad, int nuevasAtracciones, int nuevosPuntos) {
        Visitantes visitante =
            buscarVisitante(codigoActual);

        if (visitante == null) {
            System.out.println("No existe un visitante con ese código de entrada.");
            return;
        }

        Visitantes visitanteConNuevoCodigo = buscarVisitante(nuevoCodigo);

        if (nuevoCodigo != codigoActual && visitanteConNuevoCodigo != null) {
            System.out.println("Ya existe otro visitante con el nuevo código.");
            return;
        }

        visitante.modificarDatos(nuevoCodigo, nuevoNombre, nuevaEdad, nuevasAtracciones, nuevosPuntos);

        System.out.println(
            "Visitante modificado correctamente."
        );
    }

    public void eliminarVisitante(int codigoEntrada) {
        Visitantes visitante = buscarVisitante(codigoEntrada);

        if (visitante == null) {
            System.out.println("No existe un visitante con ese código de entrada.");
            return;
        }

        visitantes.remove(visitante);

        System.out.println(
            "Visitante eliminado correctamente."
        );
    }

    public void mostrarEstadisticas() {
        int cantidadPuntosHabilitados = 0;
        PuntoAcceso puntoMayorCapacidad = null;

        for (PuntoAcceso punto : puntosAcceso) {
            if (punto != null) {
                cantidadPuntosHabilitados++;

                if (puntoMayorCapacidad == null || punto.getCapacidadMaxima() > puntoMayorCapacidad.getCapacidadMaxima()) {
                    puntoMayorCapacidad = punto;
                }
            }
        }

        int espaciosDisponibles = puntosAcceso.length - cantidadPuntosHabilitados;

        System.out.println();
        System.out.println("ESTADÍSTICAS DEL PARQUE");

        System.out.println("Puntos de acceso habilitados: " + cantidadPuntosHabilitados);

        System.out.println("Espacios disponibles: " + espaciosDisponibles);

        if (puntoMayorCapacidad == null) {
            System.out.println("No existen puntos de acceso habilitados.");
        } else {
            System.out.println();
            System.out.println("Punto de acceso con mayor capacidad:");
            puntoMayorCapacidad.mostrarDatos();
        }

        System.out.println();
        System.out.println("Visitantes registrados: " + visitantes.size());

        if (visitantes.isEmpty()) {
            System.out.println("No existen visitantes para calcular estadísticas.");
            return;
        }

        Visitantes visitanteMayorPuntos = visitantes.get(0);
        Visitantes visitanteMayorAtracciones = visitantes.get(0);
        int sumaEdades = 0;

        for (Visitantes visitante : visitantes) {
            sumaEdades += visitante.getEdad();

            if (visitante.getPuntosAcumulados() > visitanteMayorPuntos.getPuntosAcumulados()) {
                visitanteMayorPuntos = visitante;
            }

            if (visitante.getCantidadAtraccionesVisitadas() > visitanteMayorAtracciones.getCantidadAtraccionesVisitadas()) {
                visitanteMayorAtracciones = visitante;
            }
        }

        double promedioEdad = (double) sumaEdades / visitantes.size();

        System.out.println();
        System.out.println("Visitante con más puntos acumulados:");
        visitanteMayorPuntos.mostrarDatos();

        System.out.println();
        System.out.println("Visitante con más atracciones visitadas:");
        visitanteMayorAtracciones.mostrarDatos();

        System.out.printf("%nPromedio de edad: %.2f%n", promedioEdad);
    }
}
