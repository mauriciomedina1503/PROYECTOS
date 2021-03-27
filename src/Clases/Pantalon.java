package Clases;
import SuperClases.Producto;

public class Pantalon extends Producto {
    private final String nombre = "Pantalón";
    public Pantalon(){}
    public Pantalon(long codigo, String color, double precio, String estilo) {
        super(codigo, color, precio, estilo);
    }
    public String getNombre() {return this.nombre;}//Fin del método: getNombre
}//Fin de la clase: Pantalon

