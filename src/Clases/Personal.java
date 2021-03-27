package Clases;

import java.util.Date;

public class Personal {
    private long dni;
    private String nombre;
    private Date fechaNacimiento;
    private Date fechaRegistro;
    private String cargo;
    public Personal(){}
    public Personal(long dni, String nombre, Date fechaNacimiento, Date fechaRegistro, String cargo) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.cargo = cargo;
    }//

    public long getDni() {return this.dni;}
    public String getNombre() {return this.nombre;}
    public Date getFechaNacimiento() {return this.fechaNacimiento;}
    public Date getFechaRegistro() {return this.fechaRegistro;}
    public String getCargo() {return this.cargo;}

    public void setDni(long dni) {this.dni = dni;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setFechaNacimiento(Date fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}
    public void setFechaRegistro(Date fechaRegistro) {this.fechaRegistro = fechaRegistro;}
    public void setCargo(String cargo) {this.cargo = cargo;}
}//Fin de la clase: Personal
