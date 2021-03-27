package Controladores;

import Clases.Pedidos;
import Conexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorPedidos {
    public ControladorPedidos(){}
    public static void iniciarTablaPedidos(JTable tabla, DefaultTableModel modeloTabla)
    {
        modeloTabla.addColumn("Nombre Producto");
        modeloTabla.addColumn("Comprador");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estilo");
        tabla.setModel(modeloTabla);
    }//Fin del método: iniciarTablaCamisa

    public static ArrayList<Pedidos> leerPedido(){
        ArrayList<Pedidos> pedidos = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtenerConexion();
            Statement resultado = conexion.createStatement();
            ResultSet rs = resultado.executeQuery("SELECT nombreProducto, nombreComprador, codigoProducto, colorProducto, precioProducto, estiloProducto FROM Pedido");
            while (rs.next()){
                pedidos.add(new Pedidos(rs.getLong(3), rs.getString(4),
                        rs.getDouble(5), rs.getString(6), rs.getString(1),
                        rs.getString(2)));
            }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return pedidos;
    }//Fin del método: leerTablaCamisa

    //Guarda los datos de personal.
    public static void insertarPedido(Pedidos pedido){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO Pedido VALUES (?,?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setString(1,pedido.getNombreProducto());
            insertar.setString(2, pedido.getComprador());
            insertar.setLong(3, pedido.getCodigo());
            insertar.setString(4, pedido.getColor());
            insertar.setDouble(5, pedido.getPrecio());
            insertar.setString(6, pedido.getEstilo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarPedido

    public static void eliminarPedido(long codigo){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM Pedido WHERE codigoProducto = ?";
            PreparedStatement eliminarPedido = conexion.prepareStatement(sql);
            eliminarPedido.setLong(1,codigo);
            eliminarPedido.execute();
            eliminarPedido.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminarPedido

    public static void actualizarPedido(Pedidos pedido){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE Pedido SET nombreProducto = ?, nombreComprador = ?, codigoProducto = ?, colorProducto = ?, precioProducto = ?, estiloProducto = ? WHERE codigoProducto = ?";
            PreparedStatement actualizarPedido = conexion.prepareStatement(sql);
            actualizarPedido.setString(1,pedido.getNombreProducto());
            actualizarPedido.setString(2, pedido.getComprador());
            actualizarPedido.setLong(3, pedido.getCodigo());
            actualizarPedido.setString(4, pedido.getColor());
            actualizarPedido.setDouble(5, pedido.getPrecio());
            actualizarPedido.setString(6, pedido.getEstilo());
            actualizarPedido.setLong(7, pedido.getCodigo());
            actualizarPedido.execute();
            conexion.close();
            actualizarPedido.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarCamisa

    public static void buscarPedido(long codigo, JTable tabla, DefaultTableModel modeloTabla){
        try {
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaPedido = conexion.prepareStatement("SELECT nombreProducto, nombreComprador, codigoProducto, colorProducto, precioProducto, estiloProducto FROM Pedido WHERE codigoProducto = ?");
            buscaPedido.setLong(1,codigo);
            ResultSet rs = buscaPedido.executeQuery();
            while (rs.next()){
                Object ob[] = {rs.getString(1), rs.getString(2), rs.getLong(3),
                rs.getString(4), rs.getDouble(5), rs.getString(6)};
                modeloTabla.addRow(ob);
            }
            tabla.setModel(modeloTabla);
            rs.close();
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//Fin del método: buscarPedido

}//Fin de la clase
