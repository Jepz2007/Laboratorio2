package Lab2.Laboratorio2;
public class PuntoAcceso {
    private int idAcceso;
    private String nombreAcceso;
    private String ubicacion;
    private int capacidadMaxima;
    private boolean estado;

    public PuntoAcceso (int idAcceso, String nombreAcceso,String ubicacion, int capacidadMaxima, boolean estado ){

        if (capacidadMaxima <= 0){
            throw new IllegalArgumentException(
                "La capacidad máxima debe ser mayor a 0"
            );
        }
        this.idAcceso = idAcceso;
        this.nombreAcceso = nombreAcceso;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.estado = estado;
    }
    public void mostrarDatos(){
        System.out.println("Código: " + idAcceso);
        System.out.println("Nombre: " + nombreAcceso);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Capacidad máxima: " + capacidadMaxima);
        System.out.println("Estado: " + estado);
    }

    



}
