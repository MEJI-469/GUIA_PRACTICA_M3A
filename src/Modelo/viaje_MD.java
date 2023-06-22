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
    private int via;
    private int ca;
    private int cam;
    private int pro;
    private Date fecha_conduccion;
    private Date fecha_llegada;

    public viaje_MD() {
    }

    public viaje_MD(int via, int ca, int cam, int pro, Date fecha_conduccion, Date fecha_llegada) {
        this.via = via;
        this.ca = ca;
        this.cam = cam;
        this.pro = pro;
        this.fecha_conduccion = fecha_conduccion;
        this.fecha_llegada = fecha_llegada;
    }

    public int getVia() {
        return via;
    }

    public void setVia(int via) {
        this.via = via;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public int getCam() {
        return cam;
    }

    public void setCam(int cam) {
        this.cam = cam;
    }

    public int getPro() {
        return pro;
    }

    public void setPro(int pro) {
        this.pro = pro;
    }

    public Date getFecha_conduccion() {
        return fecha_conduccion;
    }

    public void setFecha_conduccion(Date fecha_conduccion) {
        this.fecha_conduccion = fecha_conduccion;
    }

    public Date getFecha_llegada() {
        return fecha_llegada;
    }

    public void setFecha_llegada(Date fecha_llegada) {
        this.fecha_llegada = fecha_llegada;
    }

    @Override
    public String toString() {
        return "viaje_MD{" + "via=" + via + ", ca=" + ca + ", cam=" + cam + ", pro=" + pro + ", fecha_conduccion=" + fecha_conduccion + ", fecha_llegada=" + fecha_llegada + '}';
    }
}
