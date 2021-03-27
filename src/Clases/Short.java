package Clases;
import SuperClases.Producto;

public class Short extends Producto {
    private final String nombre = "Short";
    public Short(){}
    public Short(long codigo, String color, double precio, String estilo) {
        super(codigo, color, precio, estilo);
    }
    public String getNombre() {return this.nombre;}//Fin del método: getNombre
}//Fin de la clase: Short

