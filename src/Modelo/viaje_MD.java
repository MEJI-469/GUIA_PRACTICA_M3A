/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author HP
 */
public class viaje_MD {
    private int codigo_viaje;
    private Date fecha_viaje;
    private int id_conduc_viaje;
    private String matricula_viaje;

    public viaje_MD() {
    }

    public viaje_MD(int codigo_viaje, Date fecha_viaje, int id_conduc_viaje, String matricula_viaje) {
        this.codigo_viaje = codigo_viaje;
        this.fecha_viaje = fecha_viaje;
        this.id_conduc_viaje = id_conduc_viaje;
        this.matricula_viaje = matricula_viaje;
    }

    public int getCodigo_viaje() {
        return codigo_viaje;
    }

    public void setCodigo_viaje(int codigo_viaje) {
        this.codigo_viaje = codigo_viaje;
    }

    public Date getFecha_viaje() {
        return fecha_viaje;
    }

    public void setFecha_viaje(Date fecha_viaje) {
        this.fecha_viaje = fecha_viaje;
    }

    public int getId_conduc_viaje() {
        return id_conduc_viaje;
    }

    public void setId_conduc_viaje(int id_conduc_viaje) {
        this.id_conduc_viaje = id_conduc_viaje;
    }

    public String getMatricula_viaje() {
        return matricula_viaje;
    }

    public void setMatricula_viaje(String matricula_viaje) {
        this.matricula_viaje = matricula_viaje;
    }

    @Override
    public String toString() {
        return "viaje_MD{" + "codigo_viaje=" + codigo_viaje + ", fecha_viaje=" + fecha_viaje + ", id_conduc_viaje=" + id_conduc_viaje + ", matricula_viaje=" + matricula_viaje + '}';
    }
    
    
}
