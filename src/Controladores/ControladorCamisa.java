package Controladores;
import Clases.Camisa;
import Conexion.Conexion;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorCamisa {
    public ControladorCamisa(){}
    public static void iniciarTablaCamisa(JTable tabla, DefaultTableModel modeloTabla)
    {
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Código");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Estilo");
        tabla.setModel(modeloTabla);
    }//Fin del método: iniciarTablaCamisa

    public static ArrayList<Camisa> leerCamisa(){
        ArrayList<Camisa> camisa = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtenerConexion();
            Statement resultado = conexion.createStatement();
            ResultSet rs = resultado.executeQuery("SELECT codigo, color, precio, estilo FROM Camisa");
            while (rs.next()){
                camisa.add(new Camisa(rs.getLong(1), rs.getString(2),
                        rs.getDouble(3), rs.getString(4)));
            }
            conexion.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return camisa;
    }//Fin del método: leerTablaCamisa

    //Guarda los datos de personal.
    public static void insertarCamisa(Camisa camisa){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "INSERT INTO Camisa VALUES (?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setString(1,camisa.getNombre());
            insertar.setLong(2, camisa.getCodigo());
            insertar.setString(3, camisa.getColor());
            insertar.setDouble(4, camisa.getPrecio());
            insertar.setString(5, camisa.getEstilo());
            insertar.execute();
            conexion.close();
            insertar.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: insertarCamisa

    public static void eliminarCamisa(long codigo){
        try{
            Connection conexion = Conexion.obtenerConexion();
            String sql = "DELETE FROM Camisa WHERE codigo = ?";
            PreparedStatement eliminarCamisa = conexion.prepareStatement(sql);
            eliminarCamisa.setLong(1,codigo);
            eliminarCamisa.execute();
            eliminarCamisa.close();
            conexion.close();
        }catch (Exception e){e.printStackTrace();}
    }//Fin del método: eliminarCamisa

    public static void actualizarCamisa(Camisa camisa){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String sql = "UPDATE Camisa SET nombre = ?, codigo = ?, color = ?, precio = ?, estilo = ? WHERE codigo = ?";
            PreparedStatement actualizarCamisa = conexion.prepareStatement(sql);
            actualizarCamisa.setString(1,camisa.getNombre());
            actualizarCamisa.setLong(2, camisa.getCodigo());
            actualizarCamisa.setString(3, camisa.getColor());
            actualizarCamisa.setDouble(4, camisa.getPrecio());
            actualizarCamisa.setString(5, camisa.getEstilo());
            actualizarCamisa.setLong(6, camisa.getCodigo());
            actualizarCamisa.execute();
            conexion.close();
            actualizarCamisa.close();
        }catch (Exception e){
            e.printStackTrace();}
    }//Fin del método: actualizarCamisa

    public static void buscarCamisa(long codigo, JTable tabla, DefaultTableModel modeloTabla){
        try {
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement buscaCamisa = conexion.prepareStatement("SELECT nombre, codigo, color, precio, estilo FROM Camisa WHERE codigo = ?");
            buscaCamisa.setLong(1,codigo);
            ResultSet rs = buscaCamisa.executeQuery();
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
    }//Fin del método: buscarCamisa

}//Fin de la clase
