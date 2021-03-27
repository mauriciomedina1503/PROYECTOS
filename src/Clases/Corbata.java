package Clases;
import SuperClases.Producto;

public class Corbata extends Producto {
    private final String nombre = "Corbata";
    public Corbata(){}
    public Corbata(long codigo, String color, double precio, String estilo) {
        super(codigo, color, precio, estilo);
    }
    public String getNombre() {return this.nombre;}//Fin del método: getNombre
}//Fin de la clase: Corbata

