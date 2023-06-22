package Modelo;

/**
 *
 * @author HP
 */
public class Camion {
    
    private int id_cam;
    private String matricula_cam;
    private String modelo_cam;
    private int id_tip;
    private double potencia_cam;

    public Camion() {
    }

    public Camion(int id_cam, String matricula_cam) {
        this.id_cam = id_cam;
        this.matricula_cam = matricula_cam;
    }

    public Camion(String matricula_cam, String modelo_cam) {
        this.matricula_cam = matricula_cam;
        this.modelo_cam = modelo_cam;
    }

    public Camion(int id_cam, String matricula_cam, String modelo_cam, int id_tip, double potencia_cam) {
        this.id_cam = id_cam;
        this.matricula_cam = matricula_cam;
        this.modelo_cam = modelo_cam;
        this.id_tip = id_tip;
        this.potencia_cam = potencia_cam;
    }

    public int getId_cam() {
        return id_cam;
    }

    public void setId_cam(int id_cam) {
        this.id_cam = id_cam;
    }

    public String getMatricula_cam() {
        return matricula_cam;
    }

    public void setMatricula_cam(String matricula_cam) {
        this.matricula_cam = matricula_cam;
    }

    public String getModelo_cam() {
        return modelo_cam;
    }

    public void setModelo_cam(String modelo_cam) {
        this.modelo_cam = modelo_cam;
    }

    public int getId_tip() {
        return id_tip;
    }

    public void setId_tip(int id_tip) {
        this.id_tip = id_tip;
    }

    public double getPotencia_cam() {
        return potencia_cam;
    }

    public void setPotencia_cam(double potencia_cam) {
        this.potencia_cam = potencia_cam;
    }

    @Override
    public String toString() {
        return matricula_cam;
    }
}
