package Controladores;
import Conexion.Conexion;
import Clases.Short;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorShort {
    public ControladorShort(){}
    public static void iniciarTablaShorts(JTable tabla, DefaultTableModel modeloTabla)
    {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estilo");
        tabla.setModel(modeloTabla);
    }//Fin del método: iniciarTablaShorts

    public static ArrayList<Short> leerShort(){
        ArrayList<Short> shorts = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtenerConexion();
            Statement resultado = conexion.createStatement();
            ResultSet rs = resultado.executeQuery("SELECT codigo, color, precio, estilo FROM Short");
            while (rs.next()){
                shorts.add(new Short(rs.getLong(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4)));
            }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return shorts;
    }//Fin del método: leerTablaShorts

    //Guarda los datos
    public static void insertarShort(Short shorts){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO Short VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setString(1,shorts.getNombre());
            insertar.setLong(2, shorts.getCodigo());
            insertar.setString(3, shorts.getColor());
            insertar.setDouble(4, shorts.getPrecio());
            insertar.setString(5, shorts.getEstilo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarShort

    public static void eliminarShort(long codigo){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM Short WHERE codigo = ?";
            PreparedStatement eliminarShort = conexion.prepareStatement(sql);
            eliminarShort.setLong(1,codigo);
            eliminarShort.execute();
            eliminarShort.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminarShort

    public static void actualizarShort(Short shorts){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE Short SET nombre = ?, codigo = ?, color = ?, precio = ?, estilo = ? WHERE codigo = ?";
            PreparedStatement actualizarCamisa = conexion.prepareStatement(sql);
            actualizarCamisa.setString(1,shorts.getNombre());
            actualizarCamisa.setLong(2, shorts.getCodigo());
            actualizarCamisa.setString(3, shorts.getColor());
            actualizarCamisa.setDouble(4, shorts.getPrecio());
            actualizarCamisa.setString(5, shorts.getEstilo());
            actualizarCamisa.setLong(6, shorts.getCodigo());
            actualizarCamisa.execute();
            conexion.close();
            actualizarCamisa.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarShort

    public static void buscarShort(long codigo, JTable tabla, DefaultTableModel modeloTabla){
        try {
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaShort = conexion.prepareStatement("SELECT nombre, codigo, color, precio, estilo FROM Short WHERE codigo = ?");
            buscaShort.setLong(1,codigo);
            ResultSet rs = buscaShort.executeQuery();
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
    }//Fin del método: buscarShort

}//Fin de la clase
