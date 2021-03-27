package Clases;
import SuperClases.Producto;

public class Tela extends Producto {
    private final String nombre = "Tela";
    public Tela(){}
    public Tela(long codigo, String color, double precio, String estilo) {
        super(codigo, color, precio, estilo);
    }
    public String getNombre() {return this.nombre;}//Fin del método: getNombre
}//Fin de la clase: Tela

