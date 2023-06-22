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

    public ModeloPersona(int id, String dni, String nombre, String apellido, String telefono, int direccion, int id_pob) {
        super(id, dni, nombre, apellido, telefono, direccion, id_pob);
    }

    public List<Persona> ListPersonas() {
        List<Persona> lista = new ArrayList<>();
        String sql = "SELECT id_per, dni_per, nombre_per, apellido_per, telefono_per, direccion_per, id_pob FROM PERSONA";
        ConnectionG2 conpq = new ConnectionG2();
        ResultSet rs = conpq.Consulta(sql);

        try {
            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt(1));
                per.setDni(rs.getString(2));
                per.setNombre(rs.getString(3));
                per.setApellido(rs.getString(4));
                per.setTelefono(rs.getString(5));
                per.setDireccion(rs.getInt(6));
                per.setId_pob(rs.getInt(7));
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
        String sql = "SELECT * FROM Persona WHERE idpersona like '%" + getDni() + "%'";

        ConnectionG2 conpq = new ConnectionG2();
        ResultSet rs = conpq.Consulta(sql);
        try {
            while (rs.next()) {
                Persona per = new Persona();
                per.setId(rs.getInt(1));
                per.setDni(rs.getString(2));
                per.setNombre(rs.getString(3));
                per.setApellido(rs.getString(4));
                per.setTelefono(rs.getString(5));
                per.setDireccion(rs.getInt(6));
                per.setId_pob(rs.getInt(7));
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
        String sql = "INSERT INTO Persona (id_per, dni_per, nombre_per, apellido_per, telefono_per, "
                + "direccion_per, id_pob) VALUES ('" + getId() + "','" + getDni() + "',"
                + "'" + getNombre() + "','" + getApellido() + "','" + getTelefono() + "','"
                + getDireccion() + "','" + getId_pob() + "')"; //REVISAR EL INSERT 

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException EditPersonaDB() {
        String sql = "UPDATE Persona SET nombre_per = '" + getNombre()
                + "', apellido_per = '" + getApellido() + "', telefono_per = '" + getTelefono()
                + "', direccion_per = '" + getDireccion() + "', id_pob= '" + getId_pob()
                + "' WHERE id_per = " + getId() + "";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException DeleteLogicPerson() {
        String sql = "UPDATE Persona SET activo = false WHERE id_per = '" + getId() + "'";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException DeletePhisicPerson() {
        String sql = "DELETE FROM Persona WHERE id_per = '" + getId() + "'";

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
