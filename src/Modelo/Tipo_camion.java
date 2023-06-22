package Modelo;

public class Tipo_camion {
    
    private int id_tip;
    private String nombre_tipo;

    public Tipo_camion() {
    }

    public Tipo_camion(int id_tip) {
        this.id_tip = id_tip;
    }

    public Tipo_camion(int id_tip, String nombre_tipo) {
        this.id_tip = id_tip;
        this.nombre_tipo = nombre_tipo;
    }

    public int getId_tip() {
        return id_tip;
    }

    public void setId_tip(int id_tip) {
        this.id_tip = id_tip;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }   

    @Override
    public String toString() {
        return nombre_tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        try {
        return this.id_tip == ((Tipo_camion) obj).id_tip;
        }catch (NullPointerException e) {
        }
        return false;
    } 
}
