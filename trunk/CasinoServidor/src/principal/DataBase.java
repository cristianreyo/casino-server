package principal;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 import java.sql.*;

/**
 * Clase que se encarga de la conexion con la base de datos
 * 
 * @author Miguel Angel Fuentes Cardenas
 */
public class DataBase {
    
    private static Connection conexion;
    
    private  static void conectar(){
        if(conexion==null){
                try
            {
               Class.forName("com.mysql.jdbc.Driver");

               // Establecemos la conexión con la base de datos. 
                conexion = DriverManager.getConnection ("jdbc:mysql://localhost/Casino","root", "");
            } catch (Exception e)
            {
               e.printStackTrace();
            }
        }
    }
    
    
    /**
     * Dado un usuario y su clave obtiene los puntos asociados a dicho usuario. Si el
     * usuario no existe devolvera -1.
     * 
     * @param user
     * @param password
     * @return 
     */
    public synchronized static int getPuntos(String user, String password){
        
        conectar();
        
        // Preparamos la consulta 
        try{
            Statement s = conexion.createStatement(); 
            ResultSet rs = s.executeQuery ("SELECT puntos FROM Casino.Jugador WHERE nombre=\""+user+"\" and password=\""+password+"\"");
            rs.next();
            return rs.getInt (1);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return -1;
    }
    
    
    /**
     * Dado un usuario, su clave y lo puntos suma a dicho usuario los puntos.
     * 
     * @param user
     * @param password
     * @param puntos 
     */
    public synchronized static  void addPuntos(String user, String password, int puntos){
        conectar();
        
        puntos += getPuntos(user, password);
        
        // Preparamos la consulta 
        try{
            Statement s = conexion.createStatement(); 
            s.executeUpdate("UPDATE Casino.Jugador SET puntos="+puntos+" WHERE nombre=\""+user+"\" and password=\""+password+"\"");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public synchronized static  void setPuntos(String user, String password, int puntos){
        conectar();
        
        
        // Preparamos la consulta 
        try{
            Statement s = conexion.createStatement(); 
            s.executeUpdate("UPDATE Casino.Jugador SET puntos="+puntos+" WHERE nombre=\""+user+"\" and password=\""+password+"\"");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    /**
     * Dado un usuario y un password crea un nuevo usuario si dicho usuario no
     * existia antes.
     * @param user
     * @param password 
     * @return true si lo aniade, false en caso contrario
     */
    public synchronized static boolean newUsuario(String user, String password){
        
        conectar();
        // Preparamos la consulta 
        try{
            Statement s = conexion.createStatement(); 
            s.executeUpdate ("INSERT INTO Casino.Jugador (nombre,password,puntos) VALUES ('"+user+"','"+password+"','50')");
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    
}
