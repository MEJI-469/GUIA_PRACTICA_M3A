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
public class ModeloCamionero extends Camionero {

    public ModeloCamionero() {
    }

    public ModeloCamionero(int id_ca, double salario, int id, String dni, String nombre, String apellido, String telefono, int direccion, int id_pob) {
        super(id_ca, salario, id, dni, nombre, apellido, telefono, direccion, id_pob);
    }

    public List<Camionero> ListCamioneros() {
        List<Camionero> lista = new ArrayList<>();
        String sql = "SELECT c.id_ca, p.dni_per, p.nombre_per, p.apellido_per, p.telefono_per, c.salario_ca, p.direccion_per, p.id_pob FROM Persona p Join Camionero c on(c.id_per=p.id_per) ORDER BY 1";
        ConnectionG2 conpq = new ConnectionG2();
        ResultSet rs = conpq.Consulta(sql);
        try {
            while (rs.next()) {
                Camionero per = new Camionero();
                per.setId_ca(rs.getInt(1));
                per.setDni(rs.getString(2));
                per.setNombre(rs.getString(3));
                per.setApellido(rs.getString(4));
                per.setTelefono(rs.getString(5));
                per.setSalario(rs.getDouble(6));
                per.setDireccion(rs.getInt(7));
                per.setId_pob(rs.getInt(8));
                lista.add(per);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Camionero> SearchListCamioneros() {
        List<Camionero> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT c.id_ca, p.dni_per, p.nombre_per, p.apellido_per, p.telefono_per, c.salario_ca, p.direccion_per, p.id_pob "
                + "FROM Persona p join Camionero c on(p.id_per=c.id_per AND (p.dni_per like '%" + getDni() + "%' "
                + "OR p.nombre_per like '%" + getDni() + "%' OR p.apellido_per like '%" + getDni() + "%')) ORDER BY 1";

        ConnectionG2 conpq = new ConnectionG2();
        ResultSet rs = conpq.Consulta(sql);
        try {
            while (rs.next()) {
                Camionero per = new Camionero();
                per.setId_ca(rs.getInt(1));
                per.setDni(rs.getString(2));
                per.setNombre(rs.getString(3));
                per.setApellido(rs.getString(4));
                per.setTelefono(rs.getString(5));
                per.setSalario(rs.getDouble(6));
                per.setDireccion(rs.getInt(7));
                per.setId_pob(rs.getInt(8));
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
        String sql = "INSERT ALL INTO Persona (id_per, dni_per, nombre_per, apellido_per, telefono_per, "
                + "direccion_per, id_pob) VALUES ('" + getId() + "','" + getDni() + "',"
                + "'" + getNombre() + "','" + getApellido() + "','" + getTelefono() + "','"
                + getDireccion() + "','" + getId_pob() + "') INTO CAMIONERO (id_ca, salario_ca, id_per)"
                + "VALUES (" + getId_ca() + ", " + getSalario() + ", " + getId() + ") SELECT * FROM DUAL";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }
    
    public SQLException RegistrarCamioneroDB() {
        String sql = "INSERT INTO CAMIONERO (id_ca, salario_ca, id_per)"
                + "VALUES (" + getId_ca() + ", " + getSalario() + ", " + getId() + ")";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException EditCamioneroDB() {
        String sql = "UPDATE Camionero SET salario_ca = " + getSalario()
                + " WHERE id_ca = " + getId_ca() + "";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException DeletePhisicPerson() {
        String sql = "DELETE FROM Camionero WHERE id_ca = '" + getId_ca() + "'";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public String NoSerie() {
        String serie = "";
        String sql = "SELECT MAX(id_ca) FROM Camionero";

        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);

        try {
            while (rs.next()) {
                serie = rs.getString(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return serie;
    }

    public int getIdPer(int id_ca) {
        int id = 0;
        String sql = "SELECT ID_PER FROM CAMIONERO WHERE(ID_CA=" + id_ca + ")";

        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);

        try {
            while (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }
    
    public int allowDelete(){
        int condition = 0;
        String sql = "SELECT COUNT(e.id_ca) FROM ENVIO e WHERE (e.id_ca = '" + getId_ca()+"')";
        
        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);

        try{
            while(rs.next()){
                condition = rs.getInt(1);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return condition;
    }
    
    public boolean isRepeat(){
        boolean condition = false;
        String sql = "SELECT COUNT(p.dni_per) FROM PERSONA p WHERE (p.dni_per = '"+ getDni()+ "')";
        
        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);

        try{
            while(rs.next()){
                condition = rs.getInt(1) > 0;
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return condition;
    }
    
    public boolean isRepeatCa(){
        boolean condition = false;
        String sql = "SELECT COUNT(p.dni_per) FROM PERSONA p, Camionero c WHERE (p.id_per = c.id_per AND p.dni_per = '"+ getDni()+ "')";
        
        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);

        try{
            while(rs.next()){
                condition = rs.getInt(1) > 0;
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return condition;
    }
    
    public int getID(){
        int condition = 0;
        String sql = "SELECT p.id_per FROM Persona p WHERE (p.dni_per = '" + getDni() +"')";
        
        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);

        try{
            while(rs.next()){
                condition = rs.getInt(1);
            }
            rs.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return condition;
    }
    
    public Camionero getCamionero(int id){
        Camionero camionero = new Camionero();
        String sql ="SELECT p.nombre_per, p.apellido_per c FROM PERSONA p, Camionero c WHERE (p.id_per = c.id_per AND  c.id_ca= "+ id + ") ORDER BY 1";
        
        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);
        
        try{
            while(rs.next()){
                camionero.setNombre(rs.getString(1));
                camionero.setApellido(rs.getString(2));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return camionero;
    }
}
