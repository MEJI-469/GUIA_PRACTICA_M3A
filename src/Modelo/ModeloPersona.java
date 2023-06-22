package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ModeloPersona extends Persona {

    public ModeloPersona() {
    }

    public ModeloPersona(String cedula, String nombre1, String nombre2, String apellido1, String apellido2, String direccion, String telefono) {
        super(cedula, nombre1, nombre2, apellido1, apellido2, direccion, telefono);
    }

    public List<Persona> ListPersonas() {
        List<Persona> lista = new ArrayList<>();
        String sql = "SELECT cedula, nombre1, nombre2, apellido1, apellido12, direccion, telefono FROM PERSONA";
        ConnectionG2 conpq = new ConnectionG2();
        ResultSet rs = conpq.Consulta(sql);

        try {
            while (rs.next()) {
                Persona per = new Persona();
                per.setCedula(rs.getString(1));
                per.setNombre1(rs.getString(2));
                per.setNombre2(rs.getString(3));
                per.setApellido1(rs.getString(4));
                per.setApellido2(rs.getString(5));
                per.setDireccion(rs.getString(6));
                per.setTelefono(rs.getString(7));
                lista.add(per);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Persona> SearchListPersonas() {
        List<Persona> lista = new ArrayList<>();
        String sql = "SELECT * FROM Persona WHERE cedula like '%" + getCedula()+ "%'";

        ConnectionG2 conpq = new ConnectionG2();
        ResultSet rs = conpq.Consulta(sql);
        try {
            while (rs.next()) {
                Persona per = new Persona();
                per.setCedula(rs.getString(1));
                per.setNombre1(rs.getString(2));
                per.setNombre2(rs.getString(3));
                per.setApellido1(rs.getString(4));
                per.setApellido2(rs.getString(5));
                per.setDireccion(rs.getString(6));
                per.setTelefono(rs.getString(7));
                lista.add(per);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public SQLException GrabaPersonaDB() {
        String sql = "INSERT INTO Persona (cedula, nombre1, nombre2, apellido1, apellido2, direccion, "
                + "telefono) VALUES ('" + getCedula()+ "','" + getNombre1()+ "',"
                + "'" + getNombre2() + "','" + getApellido1() + "','" + getApellido2()+ "','"
                + getDireccion() + "','" + getTelefono()+ "')"; //REVISAR EL INSERT 

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException EditPersonaDB() {
        String sql = "UPDATE Persona SET nombre1 = '" + getNombre1() + "', nombre2 = '" + getNombre2()
                + "', apellido1 = '" + getApellido1() + "', apellido2 = '" + getApellido2()
                + "', direccion = '" + getDireccion() + "', telefono= '" + getTelefono();

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException DeleteLogicPerson() {
        String sql = "UPDATE Persona SET activo = false WHERE cedula = '" + getCedula() + "'";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException DeletePhisicPerson() {
        String sql = "DELETE FROM Persona WHERE cedula = '" + getCedula()+ "'";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }
    
    public String NoSerie(){
        String serie = "";
        String sql ="SELECT MAX(id_per) FROM Persona";
        
        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);
        
        try{
            while(rs.next()){
                serie = rs.getString(1);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return serie;
    }
}
