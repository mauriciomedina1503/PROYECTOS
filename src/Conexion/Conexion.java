package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    private static  String USUARIO = "DAVID";
    private static  String CLAVE = "123";
    public static Connection obtenerConexion(){
        try {
            String URL = "jdbc:sqlserver://localhost:1433;database=MaquinaTextil";
            Connection cn = DriverManager.getConnection(URL,USUARIO,CLAVE);
            return cn;
        }catch (Exception e){
            e.printStackTrace();
        }return null;}
        public static void setUsuario(String usuario){USUARIO = usuario;}
        public static void setClave(String clave){CLAVE = clave;}
}//Fin de la clase conexión.