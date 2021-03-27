package Clases;
import SuperClases.Producto;

public class Camisa extends Producto {
    private final String nombre = "Camisa";
    public Camisa(){}
    public Camisa(long codigo, String color, double precio, String estilo) {
        super(codigo, color, precio, estilo);
    }
    public String getNombre() {return this.nombre;}//Fin del método: getNombre
}//Fin de la clase: Camisa
