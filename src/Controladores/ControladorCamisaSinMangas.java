package Controladores;

import Clases.Camisa;
import Clases.CamisaSinMangas;
import Conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorCamisaSinMangas {
    public ControladorCamisaSinMangas(){}
    public static void iniciarTablaCamisaSinMangas(JTable tabla, DefaultTableModel modeloTabla)
    {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estilo");
        tabla.setModel(modeloTabla);
    }//Fin del método: iniciarTablaCamisaSinMangas

    public static ArrayList<CamisaSinMangas> leerCamisaSinMangas(){
        ArrayList<CamisaSinMangas> camisaSinMangas = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtenerConexion();
            Statement resultado = conexion.createStatement();
            ResultSet rs = resultado.executeQuery("SELECT codigo, color, precio, estilo FROM CamisaSinMangas");
            while (rs.next()){
                camisaSinMangas.add(new CamisaSinMangas(rs.getLong(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4)));
            }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return camisaSinMangas;
    }//Fin del método: leerTablaCamisaSinMangas

    //Guarda los datos
    public static void insertarCamisaSinMangas(CamisaSinMangas camisaSinMangas){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO CamisaSinMangas VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setString(1,camisaSinMangas.getNombre());
            insertar.setLong(2, camisaSinMangas.getCodigo());
            insertar.setString(3, camisaSinMangas.getColor());
            insertar.setDouble(4, camisaSinMangas.getPrecio());
            insertar.setString(5, camisaSinMangas.getEstilo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarCamisaSinMangas

    public static void eliminarCamisaSinMangas(long codigo){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM CamisaSinMangas WHERE codigo = ?";
            PreparedStatement eliminarCamisa = conexion.prepareStatement(sql);
            eliminarCamisa.setLong(1,codigo);
            eliminarCamisa.execute();
            eliminarCamisa.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminarCamisaSinMangas

    public static void actualizarCamisaSinMangas(CamisaSinMangas camisaSinMangas){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE CamisaSinMangas SET nombre = ?, codigo = ?, color = ?, precio = ?, estilo = ? WHERE codigo = ?";
            PreparedStatement actualizarCamisaSinMangas = conexion.prepareStatement(sql);
            actualizarCamisaSinMangas.setString(1,camisaSinMangas.getNombre());
            actualizarCamisaSinMangas.setLong(2, camisaSinMangas.getCodigo());
            actualizarCamisaSinMangas.setString(3, camisaSinMangas.getColor());
            actualizarCamisaSinMangas.setDouble(4, camisaSinMangas.getPrecio());
            actualizarCamisaSinMangas.setString(5, camisaSinMangas.getEstilo());
            actualizarCamisaSinMangas.setLong(6, camisaSinMangas.getCodigo());
            actualizarCamisaSinMangas.execute();
            conexion.close();
            actualizarCamisaSinMangas.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarCamisaSinMangas

    public static void buscarCamisaSinMangas(long codigo, JTable tabla, DefaultTableModel modeloTabla){
        try {
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaCamisaSinMangas = conexion.prepareStatement("SELECT nombre, codigo, color, precio, estilo FROM CamisaSinMangas WHERE codigo = ?");
            buscaCamisaSinMangas.setLong(1,codigo);
            ResultSet rs = buscaCamisaSinMangas.executeQuery();
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
    }//Fin del método: buscarCamisaSinMangas

}//Fin de la clase
