package Clases;
import SuperClases.Producto;

public class Falda extends Producto {
    private final String nombre = "Falda";
    public Falda(){}
    public Falda(long codigo, String color, double precio, String estilo) {
        super(codigo, color, precio, estilo);
    }
    public String getNombre() {return this.nombre;}//Fin del método: getNombre
}//Fin de la clase: Falda

