/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class viaje_BD extends viaje_MD{

    public viaje_BD(int via, int ca, int cam, int pro, Date fecha_conduccion, Date fecha_llegada) {
        super(via, ca, cam, pro, fecha_conduccion, fecha_llegada);
    }

    public viaje_BD() {
    }
    
       public List<viaje_MD> lista_viaje() {
        List<viaje_MD> lista = new ArrayList<>();
        String sql = "SELECT id_via, id_ca, id_cam, id_pro, fecha_conduccion, fecha_llegada FROM VIAJE order by 1";
        ConnectionG2 conpq = new ConnectionG2();
        ResultSet rs = conpq.Consulta(sql);

        try {
            while (rs.next()) {
                viaje_MD viaje = new viaje_MD();
                viaje.setVia(rs.getInt(1));
                viaje.setCa(rs.getInt(2));
                viaje.setCam(rs.getInt(3));
                viaje.setPro(rs.getInt(4));
                viaje.setFecha_conduccion(rs.getDate(5));
                viaje.setFecha_llegada(rs.getDate(6));
                lista.add(viaje);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(viaje_BD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<viaje_MD> SearchListPersonas() {
        List<viaje_MD> lista = new ArrayList<>();
        String sql = "SELECT * FROM VIAJE WHERE id_viaje like '%" + getVia()+ "%' order by 1";

        ConnectionG2 conpq = new ConnectionG2();
        ResultSet rs = conpq.Consulta(sql);
        try {
            while (rs.next()) {
               viaje_MD viaje = new viaje_MD();
                viaje.setVia(rs.getInt(1));
                viaje.setCa(rs.getInt(2));
                viaje.setCam(rs.getInt(3));
                viaje.setPro(rs.getInt(4));
                viaje.setFecha_conduccion(rs.getDate(5));
                viaje.setFecha_llegada(rs.getDate(6));
                lista.add(viaje);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(viaje_BD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public SQLException GrabaViajeDB() {
        String sql = "INSERT INTO VIAJE (id_via, id_ca, id_cam, id_pro, fecha_conduccion, "
                + "fecha_llegada) VALUES (" + getVia()+ "," + getCa()+ ","
                + getCam()+ "," + getPro()+ ", to_date('" + getFecha_conduccion()+ "', 'yyyy-mm-dd'), to_date('"
                + getFecha_llegada()+ "', 'yyyy-mm-dd'))"; //REVISAR EL INSERT 

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException EditPersonaDB() {
        String sql = "UPDATE VIAJE SET id_via = '" + getVia()
                + "', id_ca = '" + getCa()+ "', id_cam = '" + getCam()
                + "', id_pro = '" + getPro()+ "', fecha_conduccion= '" + getFecha_conduccion()
                + "' WHERE id_via = " + getVia() + "";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException DeleteLogicPerson() {
        String sql = "UPDATE VIAJE SET activo = false WHERE id_viaje = '" + getVia()+ "'";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException DeletePhisicViaje() {
        String sql = "DELETE FROM VIAJE WHERE id_via = " + getVia();

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }
    
    public String NoSerie(){
        String serie = "";
        String sql ="SELECT MAX(id_via) FROM VIAJE";
        
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
    
    public viaje_MD getViaje(int via){
        viaje_MD viaje = new viaje_MD();
        String sql ="SELECT v.id_ca, v.fecha_conduccion FROM VIAJE v, PAQUETE p where v.id_via=p.id_env AND p.id_env = " + via + " ORDER BY 1";
        
        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);
        
        try{
            while(rs.next()){
                viaje.setCa(rs.getInt(1));
                viaje.setFecha_conduccion(rs.getDate(2));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return viaje;
    }
    
    public boolean isUtilize(){
        boolean serie = false;
        String sql ="SELECT count(id_env) FROM PAQUETE WHERE id_env = " + getVia();
        
        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);
        
        try{
            serie = rs.next();
        }catch(SQLException e){
            System.out.println(e);
        }
        return serie;
    }
}
