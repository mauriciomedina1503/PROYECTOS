package Clases;
import SuperClases.Producto;

public class CamisaFormal extends Producto {
    private final String nombre = "Camisa Formal";
    public CamisaFormal(){}
    public CamisaFormal(long codigo, String color, double precio, String estilo) {
        super(codigo, color, precio, estilo);
    }
    public String getNombre() {return this.nombre;}//Fin del método: getNombre
}//Fin de la clase: CamisaFormal

