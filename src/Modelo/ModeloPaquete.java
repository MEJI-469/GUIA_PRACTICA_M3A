/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
/**
 *
 * @author HP
 */
public class ModeloPaquete extends Paquete{

    public ModeloPaquete() {
    }

    public ModeloPaquete(String codigo_paq, String descripcion_paq, int id_env, int id_cli) {
        super(codigo_paq, descripcion_paq, id_env, id_cli);
    }
    
    public List<Paquete> listaPaquete(){
        try{
            List<Paquete> lista=new ArrayList<>();
            String sql="SELECT codigo_paq,descripcion_paq,id_env,id_cli FROM PAQUETE";
            ConnectionG2 con=new ConnectionG2();
            ResultSet rs=con.Consulta(sql);
            while (rs.next()) {
                Paquete pa=new Paquete(rs.getString("codigo_paq"),rs.getString("descripcion_paq"),rs.getInt("id_env"),rs.getInt("id_cli"));
                lista.add(pa);
            }
            rs.close();
            return lista;
        }catch (Exception ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public List<Paquete> buscaPaquete(String nombre){
        try{
            List<Paquete> lista=new ArrayList<>();
            String sql="SELECT codigo_paq,descripcion_paq,id_env,id_cli FROM PAQUETE WHERE UPPER(descripcion_paq) "
                    + "LIKE UPPER('%"+nombre+"%') OR UPPER(codigo_paq) LIKE UPPER('%"+nombre+"%')";
            ConnectionG2 con=new ConnectionG2();
            ResultSet rs=con.Consulta(sql);
            while (rs.next()) {
                Paquete pa=new Paquete(rs.getString("codigo_paq"),rs.getString("descripcion_paq"),rs.getInt("id_env"),rs.getInt("id_cli"));
                lista.add(pa);
            }rs.close();
            return lista;
        }catch (Exception ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public SQLException grabarPaquete(){
        ConnectionG2 con=new ConnectionG2();
        String sql="INSERT INTO PAQUETE(id_paq,codigo_paq,descripcion_paq,id_env,id_cli)"
                + "VALUES("+idPaqueteGen()+",'"+getCodigo_paq()+"','"+getDescripcion_paq()+"','"+getId_env()+"','"+getId_cli()+"')";
        SQLException ex=con.Accion(sql);
        return ex;
    }
    public SQLException eliminarPaquete(String codigo){
        ConnectionG2 con=new ConnectionG2();
        String sql="DELETE FROM PAQUETE WHERE codigo_paq='"+codigo +"'";
        SQLException ex=con.Accion(sql);
        return ex;   
    }
    public int idPaqueteGen(){//GENERA EL ID DEL PAQUETE
        ConnectionG2 con=new ConnectionG2();
        String sql="SELECT MAX(id_paq) FROM PAQUETE";
        try {
            ResultSet rs=con.Consulta(sql);
            rs.next();
            return rs.getInt("MAX(id_paq)")+1;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public SQLException modificarPaquete(){
        ConnectionG2 con=new ConnectionG2();
        String sql="UPDATE paquete SET descripcion_paq='"+getDescripcion_paq()+"',id_env='"+getId_env()+"',id_cli='"+getId_cli()+""
                +"' WHERE id_paq="+idPaquete()+";";
        SQLException ex=con.Accion(sql);
        
        return ex;
    }
    public int idPaquete(String codigo){//BUSCA EL ID DEL PAQUETE MEDIANTE EL CODIGO
        ConnectionG2 con=new ConnectionG2();
        String sql="SELECT id_paq FROM PAQUETE WHERE codigo_paq='"+codigo+"'";
        try {
            ResultSet rs=con.Consulta(sql);
            rs.next();
            return rs.getInt("id_paq");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public int idPaquete(){//BUSCA EL ID DEL PAQUETE MEDIANTE EL CODIGO
        ConnectionG2 con=new ConnectionG2();
        String sql="SELECT id_paq FROM PAQUETE WHERE codigo_paq='"+getCodigo_paq()+"'";
        try {
            ResultSet rs=con.Consulta(sql);
            rs.next();
            return rs.getInt("id_paq");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public boolean buscarPaquete(String codigo) throws SQLException{//BUSCA EL PAQUETE PARA NO DEJAR QUE SE REPITAN LOS CODIGOS
        boolean test=false;
        ConnectionG2 con=new ConnectionG2();
        String sql="SELECT codigo_paq FROM PAQUETE WHERE codigo_paq='"+codigo+"'";
        ResultSet re=con.Consulta(sql);
        test = re.next();
        return test;
    }
}
