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
    


    
}
