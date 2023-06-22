package Modelo;

/**
 *
 * @author HP
 */
public class Camionero extends Persona {
    private int id_ca;
    private double salario;

    public Camionero() {
    }

    public Camionero(int id_ca, String nombre, String dni){
        super(nombre, dni);
        this.id_ca = id_ca;
    }
    
    public Camionero(String dni, String nombre) {
        super(dni, nombre);
    }

    public Camionero(int id_ca, double salario, int id, String dni, String nombre, String apellido, String telefono, int direccion, int id_pob) {
        super(id, dni, nombre, apellido, telefono, direccion, id_pob);
        this.id_ca = id_ca;
        this.salario = salario;
    }

    public int getId_ca() {
        return id_ca;
    }

    public void setId_ca(int id_ca) {
        this.id_ca = id_ca;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return id_ca + " - " + super.getDni() + " - " + " - " + super.getNombre();
    }
}
