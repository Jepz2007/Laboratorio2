package Lab2.Laboratorio2;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public void mostrarMenu(Parque parque) {
        int opcion = 0;

        while (opcion != 13) {
            System.out.println();
            System.out.println("1: Habilitar punto de acceso");
            System.out.println("2: Consultar puntos de acceso habilitados");
            System.out.println("3: Consultar un punto de acceso habilitado");
            System.out.println("4. Modificar capacidad máxima de un punto de acceso");
            System.out.println("5. Modificar estado de un punto de acceso");
            System.out.println("6. Cerrar punto de acceso");
            System.out.println("7. Registrar visitante");
            System.out.println("8. Consultar visitantes registrados");
            System.out.println("9. Buscar visitante por código");
            System.out.println("10. Modificar visitante");
            System.out.println("11. Eliminar visitante");
            System.out.println("12. Mostrar estadísticas");
            System.out.println("13. Salir");
            System.out.println("¿Qué desea realizar?: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion < 1 || opcion > 13) {
                System.out.println("Opción inválida. Elija del 1 al 13.");
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
                    case 7:
                        Main.crearVisitante(scanner,parque);
                        break;
                    case 8:
                        parque.consultarVisitantes();
                        break;
                    case 9:
                        System.out.print("Ingrese el código de entrad del visitante: ");
                        int codigoBuscado = scanner.nextInt();
                        scanner.nextLine();

                        parque.consultarVisitantePorCodigo(codigoBuscado);
                        break;
                    case 10:
                        Main.modificarVisitante(scanner, parque);
                        break;
                    case 11:
                        Main.eliminarVisitante(scanner, parque);
                        break;
                    case 12:
                        parque.mostrarEstadisticas();
                        break;
                    case 13:
                        System.out.println("Fin del programa.")
                        break;
                }
            }
        } 
    }
}