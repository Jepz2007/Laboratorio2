package Lab2.Laboratorio2;
import java.util.Scanner;

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
        parque.habilitarPuntoAcceso(posicion, nuevoAcceso);      
}
}
