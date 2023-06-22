package Modelo;

/**
 *
 * @author HP
 */
public class Cliente extends Persona{
    private int id_cli;
    private String correo;

    public Cliente() {
    }

    public Cliente(int id_cli, String correo, int id, String dni, String nombre, String apellido, String telefono, int direccion, int id_pob) {
        super(id, dni, nombre, apellido, telefono, direccion, id_pob);
        this.id_cli = id_cli;
        this.correo = correo;
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "ID_CLI: " + id_cli + "CORREO: " + correo;
    }
}
