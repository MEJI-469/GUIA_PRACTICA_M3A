package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloCamion extends Camion {

    public ModeloCamion() {
    }

    public ModeloCamion(int id_cam, String matricula_cam, String modelo_cam, int id_tip, double potencia_cam) {
        super(id_cam, matricula_cam, modelo_cam, id_tip, potencia_cam);
    }
    
    public List<Camion> ListarCamiones() {
        List<Camion> lista = new ArrayList<>();
        String sql = "SELECT ID_CAM, MATRICULA_CAM, MODELO_CAM, ID_TIP, POTENCIA FROM CAMION ORDER BY 1";
        ConnectionG2 conOracle = new ConnectionG2();
        ResultSet rs = conOracle.Consulta(sql);
        try {
            while (rs.next()) {                
                Camion cam = new Camion();
                cam.setId_cam(rs.getInt("ID_CAM"));
                cam.setMatricula_cam(rs.getString("MATRICULA_CAM"));
                cam.setModelo_cam(rs.getString("MODELO_CAM"));
                cam.setId_tip(rs.getInt("ID_TIP"));
                cam.setPotencia_cam(rs.getDouble("POTENCIA"));
                lista.add(cam);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public SQLException InsertaCamion() {
        String sql = "INSERT INTO CAMION (ID_CAM, MATRICULA_CAM, MODELO_CAM, ID_TIP, POTENCIA) VALUES "
                + "(" + Id_cam() + ", UPPER('"+ getMatricula_cam() + "'), UPPER('" + getModelo_cam() + "'), " + getId_tip() + 
                ", " + getPotencia_cam() + ")";
        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }
    
    // ??????
    public int Id_cam() {
        String sql = "SELECT MAX(ID_CAM) FROM CAMION";
        ConnectionG2 con = new ConnectionG2();
        int id = 1;
        ResultSet rs = con.Consulta(sql);
        try {
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            return id;
        } catch (SQLException e) {
            System.out.println(id);
            return id;
        }
    }
    
    public boolean ObtieneMatricula(String mat) {
        String sql = "SELECT MATRICULA_CAM FROM CAMION WHERE MATRICULA_CAM = '" + mat + "'";
        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);
        boolean existe;
        try {
            existe = rs.next();
            rs.close();
            return existe;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public List<Camion> BuscarCamion(String search) {
            List<Camion> lista = new ArrayList<>();
            String sql = "SELECT ID_CAM, MATRICULA_CAM, MODELO_CAM, ID_TIP, POTENCIA "
                + "FROM CAMION WHERE MATRICULA_CAM LIKE '%" + search + "%' OR MODELO_CAM LIKE '%" + search + "%' "
                    + "OR POTENCIA = TO_NUMBER('" + search + "')";
            ConnectionG2 conpq = new ConnectionG2();
            ResultSet rs = conpq.Consulta(sql);
        try {            
            while (rs.next()) {
                Camion cam = new Camion();
                cam.setId_cam(rs.getInt("ID_CAM"));
                cam.setMatricula_cam(rs.getString("MATRICULA_CAM"));
                cam.setModelo_cam(rs.getString("MODELO_CAM"));
                cam.setId_tip(rs.getInt("ID_TIP"));
                cam.setPotencia_cam(rs.getDouble("POTENCIA"));
                lista.add(cam);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCamion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public int ObtieneID(String mat) {
        String sql = "SELECT ID_CAM FROM CAMION WHERE MATRICULA_CAM = '" + mat + "'";
        ConnectionG2 con = new ConnectionG2();
        int id_cam = 0;
        ResultSet rs = con.Consulta(sql);
        try {
            while(rs.next()) {
                id_cam = rs.getInt(1);
            }
            return id_cam;
        } catch (SQLException e) {
            System.out.println(e);
            return id_cam;
        }
    }
    
    public SQLException ModificarCamion(int id) {
        String sql = "UPDATE CAMION SET  MATRICULA_CAM = '" + getMatricula_cam() + "', MODELO_CAM = '" + getModelo_cam() + "', ID_TIP = " + getId_tip()
                + ", POTENCIA = " + getPotencia_cam()+ " " + "WHERE ID_CAM = " + id + ""; 
        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException EliminarCamion(String matricula) {
        String sql = "DELETE FROM CAMION WHERE MATRICULA_CAM = '" + matricula + "'";
        
        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    } 
}
