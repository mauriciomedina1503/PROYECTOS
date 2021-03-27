package Controladores;

import Clases.Vestido;
import Conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorVestido {
    public ControladorVestido(){}
    public static void iniciarTablaVestidos(JTable tabla, DefaultTableModel modeloTabla)
    {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estilo");
        tabla.setModel(modeloTabla);
    }//Fin del método: iniciarTablaVestidos

    public static ArrayList<Vestido> leerVestido(){
        ArrayList<Vestido> vestido = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtenerConexion();
            Statement resultado = conexion.createStatement();
            ResultSet rs = resultado.executeQuery("SELECT codigo, color, precio, estilo FROM Vestido");
            while (rs.next()){
                vestido.add(new Vestido(rs.getLong(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4)));
            }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return vestido;
    }//Fin del método: leerTablaVestidos

    //Guarda los datos
    public static void insertarVestido(Vestido vestido){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO Vestido VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setString(1,vestido.getNombre());
            insertar.setLong(2, vestido.getCodigo());
            insertar.setString(3, vestido.getColor());
            insertar.setDouble(4, vestido.getPrecio());
            insertar.setString(5, vestido.getEstilo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarVestido

    public static void eliminarVestido(long codigo){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM Vestido WHERE codigo = ?";
            PreparedStatement eliminarVestido = conexion.prepareStatement(sql);
            eliminarVestido.setLong(1,codigo);
            eliminarVestido.execute();
            eliminarVestido.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminarVestido

    public static void actualizarVestido(Vestido vestido){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE Vestido SET nombre = ?, codigo = ?, color = ?, precio = ?, estilo = ? WHERE codigo = ?";
            PreparedStatement actualizarVestido = conexion.prepareStatement(sql);
            actualizarVestido.setString(1,vestido.getNombre());
            actualizarVestido.setLong(2, vestido.getCodigo());
            actualizarVestido.setString(3, vestido.getColor());
            actualizarVestido.setDouble(4, vestido.getPrecio());
            actualizarVestido.setString(5, vestido.getEstilo());
            actualizarVestido.setLong(6, vestido.getCodigo());
            actualizarVestido.execute();
            conexion.close();
            actualizarVestido.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarVestido

    public static void buscarVestido(long codigo, JTable tabla, DefaultTableModel modeloTabla){
        try {
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaVestido = conexion.prepareStatement("SELECT nombre, codigo, color, precio, estilo FROM Vestido WHERE codigo = ?");
            buscaVestido.setLong(1,codigo);
            ResultSet rs = buscaVestido.executeQuery();
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
    }//Fin del método: buscarVestido

}//Fin de la clase