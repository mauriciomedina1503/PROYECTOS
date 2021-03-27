package SuperClases;

public class Producto {
    private long codigo;
    private String color;
    private double precio;
    private String estilo;
    public Producto(){}
    public Producto(long codigo, String color, double precio, String estilo) {
        this.codigo = codigo;
        this.color = color;
        this.precio = precio;
        this.estilo = estilo;
    }//Fin del constructor.

    public void setCodigo(long codigo) {this.codigo = codigo;}//Fin del método: setColor
    public void setColor(String color) {this.color = color;}//Fin del método: setColor
    public void setPrecio(double precio) {this.precio = precio;}//Fin del método: setPrecio
    public void setEstilo(String estilo) {this.estilo = estilo;}//Fin del método: setEstilo
    public long getCodigo() {return this.codigo;}//Fin del método: getCodigo
    public String getColor() {return this.color;}//Fin del método: getColor
    public double getPrecio() {return this.precio;}//Fin del método: getPrecio
    public String getEstilo() {return estilo;}//Fin del método: getEstilo
}//Fin de la clase articulos.
