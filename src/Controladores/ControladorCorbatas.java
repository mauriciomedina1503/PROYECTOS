package Controladores;

import Clases.Corbata;
import Conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorCorbatas {
    public ControladorCorbatas(){}
    public static void iniciarTablaCorbatas(JTable tabla, DefaultTableModel modeloTabla)
    {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estilo");
        tabla.setModel(modeloTabla);
    }//Fin del método: iniciarTablaCorbata

    public static ArrayList<Corbata> leerCorbata(){
        ArrayList<Corbata> corbata = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtenerConexion();
            Statement resultado = conexion.createStatement();
            ResultSet rs = resultado.executeQuery("SELECT codigo, color, precio, estilo FROM Corbata");
            while (rs.next()){
                corbata.add(new Corbata(rs.getLong(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4)));
            }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return corbata;
    }//Fin del método: leerTablaCamisa

    //Guarda los datos de personal.
    public static void insertarCorbata(Corbata corbata){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO Corbata VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setString(1,corbata.getNombre());
            insertar.setLong(2, corbata.getCodigo());
            insertar.setString(3, corbata.getColor());
            insertar.setDouble(4, corbata.getPrecio());
            insertar.setString(5, corbata.getEstilo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarCorbata

    public static void eliminarCorbata(long codigo){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM Corbata WHERE codigo = ?";
            PreparedStatement eliminarCorbata = conexion.prepareStatement(sql);
            eliminarCorbata.setLong(1,codigo);
            eliminarCorbata.execute();
            eliminarCorbata.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminarCorbata

    public static void actualizarCorbata(Corbata corbata){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE Corbata SET nombre = ?, codigo = ?, color = ?, precio = ?, estilo = ? WHERE codigo = ?";
            PreparedStatement actualizarCorbata = conexion.prepareStatement(sql);
            actualizarCorbata.setString(1,corbata.getNombre());
            actualizarCorbata.setLong(2, corbata.getCodigo());
            actualizarCorbata.setString(3, corbata.getColor());
            actualizarCorbata.setDouble(4, corbata.getPrecio());
            actualizarCorbata.setString(5, corbata.getEstilo());
            actualizarCorbata.setLong(6, corbata.getCodigo());
            actualizarCorbata.execute();
            conexion.close();
            actualizarCorbata.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarCorbata

    public static void buscarCorbata(long codigo, JTable tabla, DefaultTableModel modeloTabla){
        try {
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaCorbata = conexion.prepareStatement("SELECT nombre, codigo, color, precio, estilo FROM Corbata WHERE codigo = ?");
            buscaCorbata.setLong(1,codigo);
            ResultSet rs = buscaCorbata.executeQuery();
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
    }//Fin del método: buscarCorbata

}//Fin de la clase
