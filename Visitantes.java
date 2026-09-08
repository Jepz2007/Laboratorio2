package Lab2.Laboratorio2;

public class Visitantes {
    private int codigoEntrada;
    private String nombre;
    private int edad;
    private int cantidadAtraccionesVisitadas;
    private int puntosAcumulados;

    public Visitantes(int codigoEntrada, String nombre, int edad, int cantidadAtraccionesVisitadas, int puntosAcumulados)
    {
        this.codigoEntrada = codigoEntrada;
        this.nombre = nombre;
        setEdad(edad);
        setCantidadAtraccionesVisitadas(cantidadAtraccionesVisitadas);
        setPuntosAcumulados(puntosAcumulados);
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor que 0.");
        }
        this.edad = edad;
    }

    public void setCantidadAtraccionesVisitadas(int cantidadAtraccionesVisitadas){
        if (cantidadAtraccionesVisitadas < 0) {
            throw new IllegalArgumentException("La cantidad de atracciones visitadas no puede ser negativa.");
        }
        this.cantidadAtraccionesVisitadas = cantidadAtraccionesVisitadas;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        if (puntosAcumulados < 0) {
            throw new IllegalArgumentException("Los puntos acumulados no pueden ser negativos.");
        }
        this.puntosAcumulados = puntosAcumulados;
    }

    public int getCodigoEntrada() {
        return codigoEntrada;
    }

    public void mostrarDatos() {
        System.out.println("Código de entrada: " + codigoEntrada);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Atracciones visitadas: " + cantidadAtraccionesVisitadas);
        System.out.println("Puntos acumulados: " + puntosAcumulados);
    }

    public void modificarDatos(int nuevoCodigoEntrada, String nuevoNombre, int nuevaEdad, int nuevasAtraccionesVisitadas, int nuevosPuntosAcumulados) {
        if (nuevaEdad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor que 0.");
        }

        if (nuevasAtraccionesVisitadas < 0) {
            throw new IllegalArgumentException("La cantidad de atracciones visitadas no puede ser negativa.");
        }

        if (nuevosPuntosAcumulados < 0) {
            throw new IllegalArgumentException("Los puntos acumulados no pueden ser negativos.");
        }

        this.codigoEntrada = nuevoCodigoEntrada;
        this.nombre = nuevoNombre;
        this.edad = nuevaEdad;
        this.cantidadAtraccionesVisitadas = nuevasAtraccionesVisitadas;
        this.puntosAcumulados = nuevosPuntosAcumulados;
    }

    public int getEdad() {
        return edad;
    }

    public int getCantidadAtraccionesVisitadas() {
        return cantidadAtraccionesVisitadas;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }
}
