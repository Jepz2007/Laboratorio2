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

        
    }
}
