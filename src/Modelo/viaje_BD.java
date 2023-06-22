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

    public viaje_BD(int codigo_viaje, Date fecha_viaje, int id_conduc_viaje, String matricula_viaje) {
        super(codigo_viaje, fecha_viaje, id_conduc_viaje, matricula_viaje);
    }

    public viaje_BD() {
    }
    
       public List<viaje_MD> lista_viaje() {
        List<viaje_MD> lista = new ArrayList<>();
        String sql = "SELECT codViajes, fehca, idConduc, matricula FROM VIAJE order by 1";
        ConnectionG2 conpq = new ConnectionG2();
        ResultSet rs = conpq.Consulta(sql);

        try {
            while (rs.next()) {
                viaje_MD viaje = new viaje_MD();
                viaje.setCodigo_viaje(rs.getInt(1));
                viaje.setFecha_viaje(rs.getDate(2));
                viaje.setId_conduc_viaje(rs.getInt(3));
                viaje.setMatricula_viaje(rs.getString(4));
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
        String sql = "SELECT * FROM VIAJE WHERE codViajes like '%" + getCodigo_viaje()+ "%' order by 1";

        ConnectionG2 conpq = new ConnectionG2();
        ResultSet rs = conpq.Consulta(sql);
        try {
            while (rs.next()) {
               viaje_MD viaje = new viaje_MD();
                viaje.setCodigo_viaje(rs.getInt(1));
                viaje.setFecha_viaje(rs.getDate(2));
                viaje.setId_conduc_viaje(rs.getInt(3));
                viaje.setMatricula_viaje(rs.getString(4));
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
        String sql = "INSERT INTO VIAJE (codViajes, fecha, idConduc, matricula) "
                + "VALUES (" + getCodigo_viaje()+ "," + "to_date('" + getFecha_viaje()+ "', 'yyyy-mm-dd')"
                + getId_conduc_viaje()+ ",'" + getMatricula_viaje()+ "')"; //REVISAR EL INSERT 

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException EditPersonaDB() {
        String sql = "UPDATE VIAJE SET codViajes = '" + getCodigo_viaje()
                + "', fecha = '" + getFecha_viaje()+ "', idConduc = '" + getId_conduc_viaje()
                + "', id_pro = '" + getMatricula_viaje() + "' WHERE codViajes = " + getCodigo_viaje()+ "";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException DeleteLogicPerson() {
        String sql = "UPDATE VIAJE SET activo = false WHERE codViajes = '" + getCodigo_viaje()+ "'";

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException DeletePhisicViaje() {
        String sql = "DELETE FROM VIAJE WHERE codViajes = " + getCodigo_viaje();

        ConnectionG2 con = new ConnectionG2();
        SQLException ex = con.Accion(sql);
        return ex;
    }
    
    public String NoSerie(){
        String serie = "";
        String sql ="SELECT MAX(codViajes) FROM VIAJE";
        
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
        String sql ="SELECT v.matricula, v.fecha FROM VIAJE v, PAQUETE p where v.codViajes = p.codViajes AND p.codViajes = " + via + " ORDER BY 1";
        
        ConnectionG2 con = new ConnectionG2();
        ResultSet rs = con.Consulta(sql);
        
        try{
            while(rs.next()){
                viaje.setMatricula_viaje(rs.getString(1));
                viaje.setFecha_viaje(rs.getDate(2));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return viaje;
    }
    
    public boolean isUtilize(){
        boolean serie = false;
        String sql ="SELECT count(codViajes) FROM PAQUETE WHERE codViajes = " + getCodigo_viaje();
        
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
