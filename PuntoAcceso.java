package Lab2.Laboratorio2;
public class PuntoAcceso {
    private int idAcceso;
    private String nombreAcceso;
    private String ubicacion;
    private int capacidadMaxima;
    private boolean estado;

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
        throw new IllegalArgumentException(
            "La capacidad máxima debe ser mayor a 0."
        );
        }   
        this.capacidadMaxima = capacidadMaxima;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
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
        if (estado ==true){
            System.out.println("Estado: Activo");
        }else{
            System.out.println("Estado Inactivo");
        }
    }

    



}
