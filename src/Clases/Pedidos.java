package Clases;

import SuperClases.Producto;

public class Pedidos extends Producto {
    private String nombreProducto;
    private String comprador;
    public Pedidos() {}
    public Pedidos(long codigo, String color, double precio, String estilo, String nombreProducto, String comprador) {
        super(codigo, color, precio, estilo);
        this.nombreProducto = nombreProducto;
        this.comprador = comprador;
    }//

    public String getNombreProducto() {return nombreProducto;}
    public String getComprador() {return comprador;}
    public void setNombreProducto(String nombreProducto) {this.nombreProducto = nombreProducto;}
    public void setComprador(String comprador) {this.comprador = comprador;}
}//Fin de la clase Pedidos.
