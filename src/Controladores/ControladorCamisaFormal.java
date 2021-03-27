package Controladores;

import Clases.CamisaFormal;
import Conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorCamisaFormal {
    public ControladorCamisaFormal(){}
    public static void iniciarTablaCamisaFormal(JTable tabla, DefaultTableModel modeloTabla)
    {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estilo");
        tabla.setModel(modeloTabla);
    }//Fin del método: iniciarTablaCamisaFormal

    public static ArrayList<CamisaFormal> leerCamisaFormal(){
        ArrayList<CamisaFormal> camisaFormal = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtenerConexion();
            Statement resultado = conexion.createStatement();
            ResultSet rs = resultado.executeQuery("SELECT codigo, color, precio, estilo FROM CamisaFormal");
            while (rs.next()){
                camisaFormal.add(new CamisaFormal(rs.getLong(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4)));
            }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return camisaFormal;
    }//Fin del método: leerTablaCamisaFormal

    //Guarda los datos de personal.
    public static void insertarCamisaFormal(CamisaFormal camisaFormal){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO CamisaFormal VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setString(1,camisaFormal.getNombre());
            insertar.setLong(2, camisaFormal.getCodigo());
            insertar.setString(3, camisaFormal.getColor());
            insertar.setDouble(4, camisaFormal.getPrecio());
            insertar.setString(5, camisaFormal.getEstilo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarCamisaFormal

    public static void eliminarCamisaFormal(long codigo){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM CamisaFormal WHERE codigo = ?";
            PreparedStatement eliminarCamisaFormal = conexion.prepareStatement(sql);
            eliminarCamisaFormal.setLong(1,codigo);
            eliminarCamisaFormal.execute();
            eliminarCamisaFormal.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminarCamisaFormal

    public static void actualizarCamisaFormal(CamisaFormal camisaFormal){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE CamisaFormal SET nombre = ?, codigo = ?, color = ?, precio = ?, estilo = ? WHERE codigo = ?";
            PreparedStatement actualizarCamisa = conexion.prepareStatement(sql);
            actualizarCamisa.setString(1,camisaFormal.getNombre());
            actualizarCamisa.setLong(2, camisaFormal.getCodigo());
            actualizarCamisa.setString(3, camisaFormal.getColor());
            actualizarCamisa.setDouble(4, camisaFormal.getPrecio());
            actualizarCamisa.setString(5, camisaFormal.getEstilo());
            actualizarCamisa.setLong(6, camisaFormal.getCodigo());
            actualizarCamisa.execute();
            conexion.close();
            actualizarCamisa.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarCamisaFormal

    public static void buscarCamisaFormal(long codigo, JTable tabla, DefaultTableModel modeloTabla){
        try {
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaCamisaFormal = conexion.prepareStatement("SELECT nombre, codigo, color, precio, estilo FROM CamisaFormal WHERE codigo = ?");
            buscaCamisaFormal.setLong(1,codigo);
            ResultSet rs = buscaCamisaFormal.executeQuery();
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
    }//Fin del método: buscarCamisaFormal

}//Fin de la clase