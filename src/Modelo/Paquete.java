/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Paquete {
    private String codigo_paq;
    private String descripcion_paq;
    private int id_env;
    private int id_cli;

    public Paquete() {
    }

    public Paquete(String codigo_paq, String descripcion_paq, int id_env, int id_cli) {
        this.codigo_paq = codigo_paq;
        this.descripcion_paq = descripcion_paq;
        this.id_env = id_env;
        this.id_cli = id_cli;
    }

    public String getCodigo_paq() {
        return codigo_paq;
    }

    public void setCodigo_paq(String codigo_paq) {
        this.codigo_paq = codigo_paq;
    }

    public String getDescripcion_paq() {
        return descripcion_paq;
    }

    public void setDescripcion_paq(String descripcion_paq) {
        this.descripcion_paq = descripcion_paq;
    }

    public int getId_env() {
        return id_env;
    }

    public void setId_env(int id_env) {
        this.id_env = id_env;
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }
    
    
}
