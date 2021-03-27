package Controladores;

import Clases.Camisa;
import Clases.Tela;
import Conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorTela {
    public ControladorTela(){}
    public static void iniciarTablaTela(JTable tabla, DefaultTableModel modeloTabla)
    {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estilo");
        tabla.setModel(modeloTabla);
    }//Fin del método: iniciarTablaTela

    public static ArrayList<Tela> leerTela(){
        ArrayList<Tela> tela = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtenerConexion();
            Statement resultado = conexion.createStatement();
            ResultSet rs = resultado.executeQuery("SELECT codigo, color, precio, estilo FROM Tela");
            while (rs.next()){
                tela.add(new Tela(rs.getLong(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4)));
            }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return tela;
    }//Fin del método: leerTablaTela

    //Guarda los datos de personal.
    public static void insertarTela(Tela tela){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO Tela VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setString(1,tela.getNombre());
            insertar.setLong(2, tela.getCodigo());
            insertar.setString(3, tela.getColor());
            insertar.setDouble(4, tela.getPrecio());
            insertar.setString(5, tela.getEstilo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarTela

    public static void eliminarTela(long codigo){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM Tela WHERE codigo = ?";
            PreparedStatement eliminarTela = conexion.prepareStatement(sql);
            eliminarTela.setLong(1,codigo);
            eliminarTela.execute();
            eliminarTela.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminarTela

    public static void actualizarTela(Tela tela){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE Tela SET nombre = ?, codigo = ?, color = ?, precio = ?, estilo = ? WHERE codigo = ?";
            PreparedStatement actualizarTela = conexion.prepareStatement(sql);
            actualizarTela.setString(1,tela.getNombre());
            actualizarTela.setLong(2, tela.getCodigo());
            actualizarTela.setString(3, tela.getColor());
            actualizarTela.setDouble(4, tela.getPrecio());
            actualizarTela.setString(5, tela.getEstilo());
            actualizarTela.setLong(6, tela.getCodigo());
            actualizarTela.execute();
            conexion.close();
            actualizarTela.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarTela

    public static void buscarCamisaTela(long codigo, JTable tabla, DefaultTableModel modeloTabla){
        try {
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaTela = conexion.prepareStatement("SELECT nombre, codigo, color, precio, estilo FROM Tela WHERE codigo = ?");
            buscaTela.setLong(1,codigo);
            ResultSet rs = buscaTela.executeQuery();
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
    }//Fin del método: buscarTela

}//Fin de la clase

