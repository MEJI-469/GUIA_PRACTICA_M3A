package Modelo;

/**
 *
 * @author HP
 */
public class Persona {
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private int direccion;
    private int id_pob;

    public Persona() {
    }

    public Persona(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Persona(int id, String dni, String nombre, String apellido, String telefono, int direccion, int id_pob) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.id_pob = id_pob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getId_pob() {
        return id_pob;
    }

    public void setId_pob(int id_pob) {
        this.id_pob = id_pob;
    }

    @Override
    public String toString() {
        return "ID: " + id + "DNI: " + dni + "NOMBRE: " + nombre 
                + "APELLIDO: " + apellido + "TELEFONO: " + telefono 
                + "DIRECCION: " + direccion + "ID_POB: " + id_pob;
    }
}
