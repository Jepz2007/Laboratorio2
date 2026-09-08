package Lab2.Laboratorio2;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el código de identificación: ");
        int idParque = scanner.nextInt();
        scanner.nextLine(); // Limpia el salto de línea pendiente

        System.out.print("Ingrese el nombre del parque: ");
        String nombreParque = scanner.nextLine();

        System.out.print("Ingrese el nombre del encargado: ");
        String nombreEncargado = scanner.nextLine();

        Parque parque = new Parque(
            idParque,
            nombreParque,
            nombreEncargado
        );

        Menu menu = new Menu();
        menu.mostrarMenu(parque);

        
    }
    

    public static void crearPuntoAcceso(Scanner scanner, Parque parque) {
        System.out.print("Ingrese la posición de su punto de acceso (1-5):");
        int posicion = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Código del punto de acceso: ");
        int idAcceso = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre del punto: ");
        String nombreAcceso = scanner.nextLine();

        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();

        PuntoAcceso nuevoAcceso = null;
        while (nuevoAcceso == null){
        try{

        System.out.print("Capacidad máxima por hora: ");
        int capacidadMaxima = scanner.nextInt();
        scanner.nextLine();
        

        nuevoAcceso = new PuntoAcceso(
            idAcceso, 
            nombreAcceso, 
            ubicacion, 
            capacidadMaxima,
            true
        );

        parque.habilitarPuntoAcceso(posicion, nuevoAcceso);

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } 
    }
}
    public static void crearVisitante(Scanner scanner, Parque parque) {
        try {
            System.out.print("Código de entrada: ");
            int codigoEntrada = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nombre del visitante: ");
            String nombre = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Cantidad de atracciones visitadas: ");
            int cantidadAtracciones = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Puntos acumulados: ");
            int puntosAcumulados = scanner.nextInt();
            scanner.nextLine();

            Visitantes nuevoVisitante = new Visitantes(codigoEntrada, nombre, edad, cantidadAtracciones, puntosAcumulados);

            parque.registrarVisitante(nuevoVisitante);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void modificarVisitante(Scanner scanner, Parque parque) {
        System.out.print("Código del visitante que desea modificar: ");
        int codigoActual = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo código de entrada: ");
        int nuevoCodigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nueva edad: ");
        int nuevaEdad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nueva cantidad de atracciones visitadas: ");
        int nuevasAtracciones = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevos puntos acumulados: ");
        int nuevosPuntos = scanner.nextInt();
        scanner.nextLine();

        try {
            parque.modificarVisitante(codigoActual, nuevoCodigo, nuevoNombre, nuevaEdad, nuevasAtracciones, nuevosPuntos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarVisitante(Scanner scanner, Parque parque) {
        System.out.print(
            "Ingrese el código del visitante que desea eliminar: "
        );

        int codigoEntrada = scanner.nextInt();
        scanner.nextLine();

        parque.eliminarVisitante(codigoEntrada);
    }
}
