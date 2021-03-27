package Controladores;


import Clases.PantalonFormal;
import Conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorPantalonesFormales {
    public ControladorPantalonesFormales(){}
    public static void iniciarTablaPantalonesFormales(JTable tabla, DefaultTableModel modeloTabla)
    {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estilo");
        tabla.setModel(modeloTabla);
    }//Fin del método: iniciarTablaPantalonesFormales

    public static ArrayList<PantalonFormal> leerPantalonFormal(){
        ArrayList<PantalonFormal> pantalonFormal = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtenerConexion();
            Statement resultado = conexion.createStatement();
            ResultSet rs = resultado.executeQuery("SELECT codigo, color, precio, estilo FROM PantalonFormal");
            while (rs.next()){
                pantalonFormal.add(new PantalonFormal(rs.getLong(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4)));
            }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pantalonFormal;
    }//Fin del método: leerTablaPantalonesFormales

    //Guarda los datos
    public static void insertarPantalonFormal(PantalonFormal pantalonFormal){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO PantalonFormal VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setString(1,pantalonFormal.getNombre());
            insertar.setLong(2, pantalonFormal.getCodigo());
            insertar.setString(3, pantalonFormal.getColor());
            insertar.setDouble(4, pantalonFormal.getPrecio());
            insertar.setString(5, pantalonFormal.getEstilo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarPantalonFormal

    public static void eliminarPantalonFormal(long codigo){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM PantalonFormal WHERE codigo = ?";
            PreparedStatement eliminarPantalonFormal = conexion.prepareStatement(sql);
            eliminarPantalonFormal.setLong(1,codigo);
            eliminarPantalonFormal.execute();
            eliminarPantalonFormal.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminarPantalonFormal

    public static void actualizarPantalonFormal(PantalonFormal pantalonFormal){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE PantalonFormal SET nombre = ?, codigo = ?, color = ?, precio = ?, estilo = ? WHERE codigo = ?";
            PreparedStatement actualizarPantalonFormal = conexion.prepareStatement(sql);
            actualizarPantalonFormal.setString(1,pantalonFormal.getNombre());
            actualizarPantalonFormal.setLong(2, pantalonFormal.getCodigo());
            actualizarPantalonFormal.setString(3, pantalonFormal.getColor());
            actualizarPantalonFormal.setDouble(4, pantalonFormal.getPrecio());
            actualizarPantalonFormal.setString(5, pantalonFormal.getEstilo());
            actualizarPantalonFormal.setLong(6, pantalonFormal.getCodigo());
            actualizarPantalonFormal.execute();
            conexion.close();
            actualizarPantalonFormal.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarPantalonFormal

    public static void buscarPantalonFormal(long codigo, JTable tabla, DefaultTableModel modeloTabla){
        try {
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaPantalonFormal = conexion.prepareStatement("SELECT nombre, codigo, color, precio, estilo FROM PantalonFormal WHERE codigo = ?");
            buscaPantalonFormal.setLong(1,codigo);
            ResultSet rs = buscaPantalonFormal.executeQuery();
            modeloTabla.setRowCount(0);
            while(rs.next()){
                Object resultado[] = {rs.getString(1), rs.getLong(2),
                        rs.getString(3), rs.getDouble(4), rs.getString(5)};
                modeloTabla.addRow(resultado);
            }
            tabla.setModel(modeloTabla);
            rs.close();
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//Fin del método: buscarPantalonFormal

}//Fin de la clase
