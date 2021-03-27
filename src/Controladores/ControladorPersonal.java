package Controladores;
import Clases.Personal;
import Conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ControladorPersonal {
    public ControladorPersonal(){}//Constructor

    public static void iniciarTablaPersonal(JTable tablaPersonal, DefaultTableModel modeloTablaPersonal)
    {
        modeloTablaPersonal.addColumn("DNI");
        modeloTablaPersonal.addColumn("Nombre");
        modeloTablaPersonal.addColumn("Fecha Nacimiento");
        modeloTablaPersonal.addColumn("Fecha Registro");
        modeloTablaPersonal.addColumn("Cargo");
        tablaPersonal.setModel(modeloTablaPersonal);
    }//Fin del método: iniciarTablaPersonal

    public static ArrayList<Personal> leerPersonal(){
        ArrayList<Personal> personal = new ArrayList<>();
        try {
                Connection conexion = Conexion.obtenerConexion();
                Statement resultado = conexion.createStatement();
                ResultSet rs = resultado.executeQuery("SELECT dni, nombre, fechaNacimiento, fechaRegistro, cargo FROM Personal");
                while (rs.next()){
                    personal.add(new Personal(rs.getLong(1), rs.getString(2),
                    rs.getDate(3), rs.getDate(4), rs.getString(5)));
                }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return personal;
    }//Fin del método: leerPersonal

    //Guarda los datos de personal.
    public static void insertar(Personal personal){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO Personal VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setLong(1,personal.getDni());
            insertar.setString(2, personal.getNombre());
            insertar.setDate(3, new java.sql.Date(personal.getFechaNacimiento().getTime()));
            insertar.setDate(4, new java.sql.Date(personal.getFechaRegistro().getTime()));
            insertar.setString(5, personal.getCargo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarEnTablaPersonal

    public static void eliminarPersonal(long DNI){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM Personal WHERE dni = ?";
            PreparedStatement eliminarPersonal = conexion.prepareStatement(sql);
            eliminarPersonal.setLong(1,DNI);
            eliminarPersonal.execute();
            eliminarPersonal.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminar

    public static void actualizarPersonal(Personal personal){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE Personal SET dni = ?, nombre = ?, fechaNacimiento = ?, fechaRegistro = ?, cargo = ? WHERE dni = ?";
            PreparedStatement actualizarPersonal = conexion.prepareStatement(sql);
            actualizarPersonal.setLong(1, personal.getDni());
            actualizarPersonal.setString(2, personal.getNombre());
            actualizarPersonal.setDate(3, new java.sql.Date(personal.getFechaNacimiento().getTime()));
            actualizarPersonal.setDate(4, new java.sql.Date(personal.getFechaRegistro().getTime()));
            actualizarPersonal.setString(5, personal.getCargo());
            actualizarPersonal.setLong(6, personal.getDni());
            actualizarPersonal.execute();
            conexion.close();
            actualizarPersonal.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarPersonal

    public static void buscarPersonal(long DNI, JTable tablaPersonal, DefaultTableModel modeloTabla){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaPersonal = conexion.prepareStatement("SELECT dni, nombre, fechaNacimiento, fechaRegistro, cargo FROM Personal WHERE dni = ?");
            buscaPersonal.setLong(1,DNI);
            ResultSet rs = buscaPersonal.executeQuery();
            modeloTabla.setRowCount(0);
            while(rs.next()){
                Object resultado[] = {rs.getLong(1), rs.getString(2),
                sdf.format(rs.getDate(3)), sdf.format(rs.getDate(4)), rs.getString(5)};
                modeloTabla.addRow(resultado);
            }
            tablaPersonal.setModel(modeloTabla);
            rs.close();
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//Fin del método: buscar Personal

}//Fin de la clase: ControladorPanelPersonal
