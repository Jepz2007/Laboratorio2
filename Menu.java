package Lab2.Laboratorio2;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public void mostrarMenu(Parque parque) {
        int opcion = 0;

        while (opcion != 9) {
            System.out.println();
            System.out.println("1: Habilitar punto de acceso");
            System.out.println("2: Consultar puntos de acceso habilitados");
            System.out.println("3: Consultar un punto de acceso habilitado");
            System.out.println("4. Modificar capacidad máxima de un punto de acceso");
            System.out.println("5. Modificar estado de un punto de acceso");
            System.out.println("6. Cerrar punto de acceso");
            System.out.println();
            System.out.println("¿Qué desea realizar?: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion < 1 || opcion > 9) {
                System.out.println("Opción inválida. Elija del 1 al 9.");
            } else {
                switch (opcion) {
                    case 1:
                        Main.crearPuntoAcceso(scanner, parque);
                        break;
                    case 2:
                        parque.consultarPuntosAcceso();
                        break;
                    case 3:
                        parque.consultarUnPuntoAcceso();
                        break;
                    case 4:
                        parque.modificarCantMaxPA();
                        break;
                    case 5:
                        parque.modificarEstado();
                        break;
                    case 6:
                        parque.cerrarPuntoAcceso();
                        break;
                }
            }
        } 
    }
}