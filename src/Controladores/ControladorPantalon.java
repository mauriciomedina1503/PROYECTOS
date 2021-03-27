package Controladores;

import Clases.Pantalon;
import Conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorPantalon {
    public ControladorPantalon(){}
    public static void iniciarTablaPantalon(JTable tabla, DefaultTableModel modeloTabla)
    {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estilo");
        tabla.setModel(modeloTabla);
    }//Fin del método: iniciarTablaPantalon

    public static ArrayList<Pantalon> leerPantalon(){
        ArrayList<Pantalon> pantalon = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtenerConexion();
            Statement resultado = conexion.createStatement();
            ResultSet rs = resultado.executeQuery("SELECT codigo, color, precio, estilo FROM Pantalon");
            while (rs.next()){
                pantalon.add(new Pantalon(rs.getLong(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4)));
            }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pantalon;
    }//Fin del método: leerTablaPantalon

    //Guarda los datos
    public static void insertarPantalon(Pantalon pantalon){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO Pantalon VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setString(1,pantalon.getNombre());
            insertar.setLong(2, pantalon.getCodigo());
            insertar.setString(3, pantalon.getColor());
            insertar.setDouble(4, pantalon.getPrecio());
            insertar.setString(5, pantalon.getEstilo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarPantalon

    public static void eliminarPantalon(long codigo){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM Pantalon WHERE codigo = ?";
            PreparedStatement eliminarPantalon = conexion.prepareStatement(sql);
            eliminarPantalon.setLong(1,codigo);
            eliminarPantalon.execute();
            eliminarPantalon.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminarPantalon

    public static void actualizarPantalon(Pantalon pantalon){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE Pantalon SET nombre = ?, codigo = ?, color = ?, precio = ?, estilo = ? WHERE codigo = ?";
            PreparedStatement actualizarPantalon = conexion.prepareStatement(sql);
            actualizarPantalon.setString(1,pantalon.getNombre());
            actualizarPantalon.setLong(2, pantalon.getCodigo());
            actualizarPantalon.setString(3, pantalon.getColor());
            actualizarPantalon.setDouble(4, pantalon.getPrecio());
            actualizarPantalon.setString(5, pantalon.getEstilo());
            actualizarPantalon.setLong(6, pantalon.getCodigo());
            actualizarPantalon.execute();
            conexion.close();
            actualizarPantalon.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarPantalon

    public static void buscarPantalon(long codigo, JTable tabla, DefaultTableModel modeloTabla){
        try {
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaPantalon = conexion.prepareStatement("SELECT nombre, codigo, color, precio, estilo FROM Pantalon WHERE codigo = ?");
            buscaPantalon.setLong(1,codigo);
            ResultSet rs = buscaPantalon.executeQuery();
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
    }//Fin del método: buscarPantalon

}//Fin de la clase
