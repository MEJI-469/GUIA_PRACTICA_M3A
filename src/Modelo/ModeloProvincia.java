/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ModeloProvincia extends Provincia {

    public ModeloProvincia() {
    }

    public ModeloProvincia(String codigo_pro, String nombre_pro) {
        super(codigo_pro, nombre_pro);
    }

    public List<Provincia> listaProvincia() {
        try {
            List<Provincia> lista = new ArrayList<>();
            String sql = "SELECT id_pro,codigo_pro,nombre_pro FROM PROVINCIA ORDER BY 1";
            ConnectionG2 con = new ConnectionG2();
            try (ResultSet rs = con.Consulta(sql)) {
                while (rs.next()) {
                    Provincia pr = new Provincia(rs.getInt(1), rs.getString("codigo_pro"), rs.getString("nombre_pro"));
                    lista.add(pr);
                }
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Provincia> buscaProvincia(String nombre) {
        try {
            List<Provincia> lista = new ArrayList<>();
            String sql = "SELECT codigo_pro,nombre_pro FROM PROVINCIA WHERE UPPER(nombre_pro) LIKE UPPER('%" + nombre + "%') OR codigo_pro LIKE '%" + nombre + "%' ORDER BY 1";
            ConnectionG2 con = new ConnectionG2();
            try (ResultSet rs = con.Consulta(sql)) {
                while (rs.next()) {
                    Provincia pr = new Provincia(rs.getString("codigo_pro"), rs.getString("nombre_pro"));
                    lista.add(pr);
                }
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public SQLException grabarProvincia() {
        ConnectionG2 con = new ConnectionG2();
        String sql = "INSERT INTO provincia(id_pro,codigo_pro,nombre_pro) "
                + "VALUES(" + idProvinciaGen() + ",'" + getCodigo_pro() + "','" + getNombre_pro() + "')";
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public int idProvinciaGen() {//GENERA EL ID DE LA PROVINCIA
        ConnectionG2 con = new ConnectionG2();
        String sql = "SELECT MAX(id_pro) FROM PROVINCIA";
        try {
            ResultSet rs = con.Consulta(sql);
            rs.next();
            return rs.getInt("MAX(id_pro)") + 1;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public SQLException eliminarProvincia(String codigo) {
        ConnectionG2 con = new ConnectionG2();
        String sql = "DELETE FROM PROVINCIA WHERE id_pro='" + idProvincia(codigo) + "'";
        SQLException ex = con.Accion(sql);
        return ex;
    }

    public SQLException modificarProvincia(String codigo) {
        ConnectionG2 con = new ConnectionG2();
        String sql = "UPDATE provincia SET nombre_pro='" + getNombre_pro() + "' WHERE id_pro=" + idProvincia(codigo) + "";
        SQLException ex = con.Accion(sql);

        return ex;
    }

    public int idProvincia(String codigo) {//BUSCA EL ID DE LA PROVINCIA MEDIANTE EL CODIGO
        ConnectionG2 con = new ConnectionG2();
        String sql = "SELECT id_pro FROM PROVINCIA WHERE codigo_pro='" + codigo + "'";
        try {
            ResultSet rs = con.Consulta(sql);
            rs.next();
            return rs.getInt("id_pro");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public boolean buscarProvincia(String codigo) throws SQLException {
        boolean test;
        ConnectionG2 con = new ConnectionG2();
        String sql = "SELECT id_pro FROM PROVINCIA WHERE codigo_pro='" + codigo + "'";
        try (ResultSet re = con.Consulta(sql)) {
            test = re.next();
        }
        return test;
    }

    public int getIdPro(String codigo) {
        int test = 0;
        ConnectionG2 con = new ConnectionG2();
        String sql = "SELECT id_pro FROM PROVINCIA WHERE nombre_pro='" + codigo + "'";
        try (ResultSet re = con.Consulta(sql)) {
            while (re.next()) {
                test = re.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProvincia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }

    public boolean isUtilizated(String codigo) {
        boolean test = false;
        ConnectionG2 con = new ConnectionG2();
        String sql = "SELECT count(v.id_pro) FROM Viaje v WHERE v.id_pro=" + idProvincia(codigo) + "";
        try (ResultSet re = con.Consulta(sql)) {
            while (re.next()) {
                test = re.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProvincia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }

    public boolean isUtilizated1(String codigo) {
        boolean test = false;
        ConnectionG2 con = new ConnectionG2();
        String sql = "SELECT count(p.direccion_per) FROM Persona p WHERE p.direccion_per=" + idProvincia(codigo) + "";
        try (ResultSet re = con.Consulta(sql)) {
            while (re.next()) {
                test = re.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProvincia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }
}
