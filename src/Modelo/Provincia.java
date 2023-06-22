/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author HP
 */
public class Provincia {
    private int id_pro;
    private String codigo_pro;
    private String nombre_pro;

    public Provincia() {
    }

    public Provincia(int id_pro, String nombre_pro) {
        this.id_pro = id_pro;
        this.nombre_pro = nombre_pro;
    }

    public Provincia(String codigo_pro, String nombre_pro) {
        this.codigo_pro = codigo_pro;
        this.nombre_pro = nombre_pro;
    }

    public Provincia(int id_pro, String codigo_pro, String nombre_pro) {
        this.id_pro = id_pro;
        this.codigo_pro = codigo_pro;
        this.nombre_pro = nombre_pro;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public String getCodigo_pro() {
        return codigo_pro;
    }

    public void setCodigo_pro(String codigo_pro) {
        this.codigo_pro = codigo_pro;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    @Override
    public String toString() {
        return id_pro + ": " + nombre_pro;
    }
}
