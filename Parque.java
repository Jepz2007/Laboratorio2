package Lab2.Laboratorio2;
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
    


    
}
