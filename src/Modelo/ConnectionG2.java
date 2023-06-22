package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionG2 {
    Connection con;
//    String CadenaCon = "jdbc:oracle:thin:@localhost:1521/xe";
    String CadenaCon = "jdbc:oracle:thin:@192.168.43.92:1521/xe";
    //Escribir la direccion IPV4 del host
    String UsuarioPG = "GUIABD2";
    String PasswordPG = "1234";

    public ConnectionG2() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionG2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            con = DriverManager.getConnection(CadenaCon, UsuarioPG, PasswordPG);
        }catch(SQLException ex){
            Logger.getLogger(ConnectionG2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet Consulta(String sql) {
        try {
            Statement st = con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionG2.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public SQLException Accion(String sql) {
        try {
            try (Statement st = con.createStatement()) {
                st.execute(sql);
                
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionG2.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    } 

    public Connection getCon() {
        return con;
    }
}
