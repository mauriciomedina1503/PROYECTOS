package Controladores;

import Clases.Camisa;
import Clases.Falda;
import Conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorFalda {
    public ControladorFalda(){}
    public static void iniciarTablaFalda(JTable tabla, DefaultTableModel modeloTabla)
    {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estilo");
        tabla.setModel(modeloTabla);
    }//Fin del método: iniciarTablaFalda

    public static ArrayList<Falda> leerFalda(){
        ArrayList<Falda> falda = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtenerConexion();
            Statement resultado = conexion.createStatement();
            ResultSet rs = resultado.executeQuery("SELECT codigo, color, precio, estilo FROM Falda");
            while (rs.next()){
                falda.add(new Falda(rs.getLong(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4)));
            }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return falda;
    }//Fin del método: leerTablaFalda

    //Guarda los datos de personal.
    public static void insertarFalda(Falda falda){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO Falda VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setString(1, falda.getNombre());
            insertar.setLong(2, falda.getCodigo());
            insertar.setString(3, falda.getColor());
            insertar.setDouble(4, falda.getPrecio());
            insertar.setString(5, falda.getEstilo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarFalda

    public static void eliminarFalda(long codigo){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM Falda WHERE codigo = ?";
            PreparedStatement eliminarFalda = conexion.prepareStatement(sql);
            eliminarFalda.setLong(1,codigo);
            eliminarFalda.execute();
            eliminarFalda.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminarFalda

    public static void actualizarFalda(Falda falda){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE Falda SET nombre = ?, codigo = ?, color = ?, precio = ?, estilo = ? WHERE codigo = ?";
            PreparedStatement actualizarFalda = conexion.prepareStatement(sql);
            actualizarFalda.setString(1,falda.getNombre());
            actualizarFalda.setLong(2, falda.getCodigo());
            actualizarFalda.setString(3, falda.getColor());
            actualizarFalda.setDouble(4, falda.getPrecio());
            actualizarFalda.setString(5, falda.getEstilo());
            actualizarFalda.setLong(6, falda.getCodigo());
            actualizarFalda.execute();
            conexion.close();
            actualizarFalda.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarFalda

    public static void buscarFalda(long codigo, JTable tabla, DefaultTableModel modeloTabla){
        try {
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaFalda = conexion.prepareStatement("SELECT nombre, codigo, color, precio, estilo FROM Falda WHERE codigo = ?");
            buscaFalda.setLong(1,codigo);
            ResultSet rs = buscaFalda.executeQuery();
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
    }//Fin del método: buscarFalda

}//Fin de la clase

