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
public class ModeloPoblacion extends Poblacion{
    
    public ModeloPoblacion() {
    }

    public ModeloPoblacion(int id, String nombre) {
        super(id, nombre);
    }
    
    public List<Poblacion> listaPoblacion(){
        try{
            List<Poblacion> lista=new ArrayList<>();
            String sql="SELECT id_pob, nombre_pob FROM POBLACION ORDER BY 1";
            ConnectionG2 con=new ConnectionG2();
            try (ResultSet rs = con.Consulta(sql)) {
                while (rs.next()) {
                    Poblacion pb = new Poblacion();
                    pb.setId(rs.getInt(1));
                    pb.setNombre(rs.getString(2));
                    lista.add(pb);
                }
            }
            return lista;
        }catch (SQLException ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public List<Poblacion> buscaPoblacion(String nombre){
        try{
            List<Poblacion> lista=new ArrayList<>();
            String sql="SELECT id_pob, nombre_pob FROM POBLACION WHERE nombre_pob LIKE '%"+nombre+"%' OR id_pob LIKE '%"+nombre+"%' ORDER BY 1";
            ConnectionG2 con=new ConnectionG2();
            try (ResultSet rs = con.Consulta(sql)) {
                while (rs.next()) {
                    Poblacion pb = new Poblacion();
                    pb.setId(rs.getInt(1));
                    pb.setNombre(rs.getString(2));
                    lista.add(pb);
                }
            }
            return lista;
        }catch (SQLException ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public SQLException grabarPoblacion(){
        ConnectionG2 con=new ConnectionG2();
        String sql="INSERT INTO Poblacion(id_pob, nombre_pob) "
                + "VALUES('"+getId()+"','"+getNombre()+"')";
        
        SQLException ex=con.Accion(sql);
        return ex;
    }
    
    public int idPoblacionGen(){//GENERA EL ID DE LA PROVINCIA
        ConnectionG2 con=new ConnectionG2();
        String sql="SELECT MAX(id_pob) FROM POBLACION";
        try {
            ResultSet rs=con.Consulta(sql);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public SQLException eliminarPoblacion(int codigo){
        ConnectionG2 con=new ConnectionG2();
        String sql="DELETE FROM Poblacion WHERE id_pob="+codigo+"";
        SQLException ex=con.Accion(sql);
        return ex;   
    }
    public SQLException modificarPoblacion(){
        ConnectionG2 con=new ConnectionG2();
        String sql="UPDATE Poblacion SET nombre_pob='"+getNombre()+"' WHERE id_pob="+ getId()+"";
        SQLException ex=con.Accion(sql);
        
        return ex;
    }
    public int idPoblacion(String codigo){//BUSCA EL ID DE LA PROVINCIA MEDIANTE EL CODIGO
        int i = 0;
        ConnectionG2 con=new ConnectionG2();
        String sql="SELECT id_pob FROM POBLACION WHERE nombre_pob='"+codigo+"'";
        
        try (ResultSet rs = con.Consulta(sql)){
            while(rs.next()){
                i = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public boolean buscarPoblacion(String codigo){
        boolean test = false;
        ConnectionG2 con=new ConnectionG2();
        String sql="SELECT id_pob FROM POBLACION WHERE nombre_pob='"+codigo+"'";
        try (ResultSet re = con.Consulta(sql)) {
            test = re.next();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPoblacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }
    
    public int getIdPob(String codigo){
        int test = 0;
        ConnectionG2 con=new ConnectionG2();
        String sql="SELECT id_pob FROM POBLACION WHERE nombre_pob='"+codigo+"'";
        try (ResultSet re = con.Consulta(sql)) {
            while (re.next()) {
                    test = re.getInt(1);
                }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProvincia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }
}
