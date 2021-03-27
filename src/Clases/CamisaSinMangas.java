package Clases;
import SuperClases.Producto;

public class CamisaSinMangas extends Producto {
    private final String nombre = "Camisa Sin Mangas";
    public CamisaSinMangas(){}
    public CamisaSinMangas(long codigo, String color, double precio, String estilo) {
        super(codigo, color, precio, estilo);
    }
    public String getNombre() {return this.nombre;}//Fin del método: getNombre
}//Fin de la clase: CamisaSinMangas

