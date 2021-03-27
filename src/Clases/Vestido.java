package Clases;
import SuperClases.Producto;

public class Vestido extends Producto {
    private final String nombre = "Vestido";
    public Vestido(){}
    public Vestido(long codigo, String color, double precio, String estilo) {
        super(codigo, color, precio, estilo);
    }
    public String getNombre() {return this.nombre;}//Fin del método: getNombre
}//Fin de la clase: Vestido

