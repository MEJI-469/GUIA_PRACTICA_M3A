/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Camionero;
import Modelo.Cliente;
import Modelo.ConexionGmail;
import Modelo.ConnectionG2;
import Modelo.ModeloCamionero;
import Modelo.ModeloCliente;
import Modelo.ModeloPaquete;
import Modelo.Paquete;
import Modelo.viaje_BD;
import Modelo.viaje_MD;
import Vista.VistaPaquete;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ControladorPaquete {
    private ModeloPaquete modelo;
    private VistaPaquete vista;

    public ControladorPaquete(ModeloPaquete modelo, VistaPaquete vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }
    public void iniciarControl(){
        cargaPaquete();
        vista.getBtnActualizar().addActionListener(l->cargaPaquete());
        vista.getBtnCrear().addActionListener(l->abrirPaqueteDialog(0));
        vista.getBtnEditar().addActionListener(l->abrirPaqueteDialog(1));
        vista.getBtnAceptar().addActionListener(l->ingresarModificarPaquete());
        vista.getBtnCancelar().addActionListener(l->limpiar());
        vista.getBtnEliminar().addActionListener(l->eliminarPaquete());
        vista.getBtnBuscar().addActionListener(l->buscarPaquete());
        vista.getBtnElegirEnvio().addActionListener(l->elegirEnvio());
        vista.getBtnElegirCliente().addActionListener(l->elegirCliente());
        vista.getTblCliente().addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){
                clickTblCliente();
            }
        });
        vista.getTblEnvio().addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){
                clickTblEnvio();
            }
        });
        vista.getTxtBuscar().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt){
                buscarPaquete();
            }
        });
        vista.getBtnSalirCliente().addActionListener(l->vista.getDigSeleccionarCliente().dispose());
        vista.getBtnSalirEnvio().addActionListener(l->vista.getDigSeleccionarEnvio().dispose());
    }
    private void cargaPaquete(){
        List<Paquete> lista=modelo.listaPaquete();
        DefaultTableModel mTabla=(DefaultTableModel) vista.getTblPaquete().getModel();
        mTabla.setNumRows(0);   
        String[] columnas={"Codigo","Descripcion","Id_env","Id_cli"};
        mTabla.setColumnIdentifiers(columnas);
        lista.stream().forEach(paquete->{
            Object[] registro={paquete.getCodigo_paq(),paquete.getDescripcion_paq(),paquete.getId_env(),paquete.getId_cli()};
            mTabla.addRow(registro);
        });
    }
    
    private void abrirPaqueteDialog(int ce){//HACE VISIBLE EL FORMULARIO DEL PAQUETE
        String titulo;
        vista.getTxtIdCliente().setEnabled(false);
        vista.getTxtIdEnvio().setEnabled(false);
        if (ce==0) {
            titulo="Crear Paquete";
            vista.getDigPaquete().setTitle(titulo);
        }else{
            titulo="Modificar Paquete";
            vista.getDigPaquete().setTitle(titulo);
            if (vista.getTblPaquete().getSelectedRow()<0) {
                JOptionPane.showMessageDialog(null, "DEBE DE SELECCIONAR EL PAQUETE A MODIFICAR");
                return;
            }
            try{
                if (modelo.buscarPaquete(vista.getTblPaquete().getValueAt(vista.getTblPaquete().getSelectedRow(), 0).toString())==false) {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO DICHO PAQUETE");
                return;
                }
                ConnectionG2 con=new ConnectionG2();
                String sql="SELECT codigo_paq,descripcion_paq,id_env,id_cli FROM PAQUETE WHERE codigo_paq='"+vista.getTblPaquete().getValueAt(vista.getTblPaquete().getSelectedRow(), 0).toString()+"'";
                ResultSet re=con.Consulta(sql);
                re.next();
                vista.getTxtCodigo().setText(re.getString("codigo_paq"));
                vista.getTxtDescripcion().setText(re.getString("descripcion_paq"));
                vista.getTxtIdEnvio().setText(re.getString("id_env"));
                vista.getTxtIdCliente().setText(re.getString("id_cli"));
                vista.getTxtCodigo().setEnabled(false);
            }catch (SQLException ex) {
                Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        vista.getDigPaquete().setSize(500,500);
        vista.getDigPaquete().setLocationRelativeTo(vista);
        vista.getDigPaquete().setVisible(true);
    }
    private void ingresarModificarPaquete(){//BOTON ACEPTAR DEL FORMULARIO
        if (vista.getDigPaquete().getTitle().equals("Crear Paquete")) {
            if (vista.getTxtCodigo().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UN CODIGO");
                return;
            }
            if (!vista.getTxtCodigo().getText().matches("[a-zA-Z0-9]{1,6}")) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UN CODIGO DE MAXIMO 6 CARACTERES");
                return;
            }
            if (vista.getTxtDescripcion().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UNA DESCRIPCION");
                return;
            }
            if (!vista.getTxtDescripcion().getText().matches("([a-zA-Z0-9.,/-:]|\\s|\\n){1,150}")) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UNA DESCRIPCION MAXIMO 150 CARACTERES");
                return;
            }
            if (vista.getTxtIdEnvio().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE ELEGIR UN ENVIO");
                return;
            }
            if (vista.getTxtIdCliente().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE ELEGIR UN CLIENTE");
                return;
            }
            try{
                if (modelo.buscarPaquete(vista.getTxtCodigo().getText())==true) {
                    JOptionPane.showMessageDialog(null, "YA EXISTE UN PAQUETE CON ESE CODIGO");
                    return;
                }
            }catch (SQLException ex) {
                Logger.getLogger(ModeloPaquete.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(new ModeloPaquete(vista.getTxtCodigo().getText(),vista.getTxtDescripcion().getText(),Integer.parseInt(vista.getTxtIdEnvio().getText()),Integer.parseInt(vista.getTxtIdCliente().getText())).grabarPaquete() == null){
                ConexionGmail con = new ConexionGmail();
                ModeloCliente cli = new ModeloCliente();
                Cliente cliente = cli.getCliente(Integer.parseInt(vista.getTxtIdCliente().getText()));
                viaje_BD vi = new viaje_BD();
                viaje_MD viaje = vi.getViaje(Integer.parseInt(vista.getTxtIdEnvio().getText()));
                ModeloCamionero cam = new ModeloCamionero();
                Camionero camionero = cam.getCamionero(viaje.getCa());
                
                con.enviarCorreo(cliente, viaje, camionero);
            }
            vista.getDigPaquete().dispose();
            cargaPaquete();
        }else{
            if (vista.getTxtCodigo().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UN CODIGO");
                return;
            }
            if (!vista.getTxtCodigo().getText().matches("[a-zA-Z0-9]{1,6}")) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UN CODIGO DE MAXIMO 6 CARACTERES");
                return;
            }
            if (vista.getTxtDescripcion().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UNA DESCRIPCION");
                return;
            }
            if (!vista.getTxtDescripcion().getText().matches("([a-zA-Z0-9.,/-:]|\\s|\\n){1,150}")) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UNA DESCRIPCION MAXIMO 150 CARACTERES");
                return;
            }
            if (vista.getTxtIdEnvio().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE ELEGIR UN ENVIO");
                return;
            }
            if (vista.getTxtIdCliente().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE ELEGIR UN CLIENTE");
                return;
            }
            new ModeloPaquete(vista.getTxtCodigo().getText(),vista.getTxtDescripcion().getText(),Integer.parseInt(vista.getTxtIdEnvio().getText()),Integer.parseInt(vista.getTxtIdCliente().getText())).modificarPaquete();
            cargaPaquete();
            vista.getDigPaquete().dispose();
        }
        limpiar();
    }
    private void limpiar(){
            vista.getTxtCodigo().setText(null);
            vista.getTxtDescripcion().setText(null);
            vista.getTxtIdCliente().setText(null);
            vista.getTxtIdEnvio().setText(null);
            vista.getTxtCodigo().setEnabled(true);
    }
    private void eliminarPaquete() {
        if (vista.getTblPaquete().getSelectedRow()<0) {
                JOptionPane.showMessageDialog(null, "DEBE DE SELECCIONAR EL PAQUETE A ELIMINAR");
        }
        modelo.eliminarPaquete(vista.getTblPaquete().getValueAt(vista.getTblPaquete().getSelectedRow(), 0).toString());
        cargaPaquete();
    };
    private void buscarPaquete(){
        List<Paquete> lista=modelo.buscaPaquete(vista.getTxtBuscar().getText());
        DefaultTableModel mTabla=(DefaultTableModel) vista.getTblPaquete().getModel();
        mTabla.setNumRows(0);   
        String[] columnas={"Codigo","Descripcion","Id_env","Id_cli"};
        mTabla.setColumnIdentifiers(columnas);
        lista.stream().forEach(paquete->{
            String[] registro={paquete.getCodigo_paq(),paquete.getDescripcion_paq(),String.valueOf(paquete.getId_env()), String.valueOf(paquete.getId_cli())};
            mTabla.addRow(registro);
        });
    }
    private void elegirEnvio(){
        vista.getDigSeleccionarEnvio().setTitle("SELECCIONAR ENVIO");
        vista.getDigSeleccionarEnvio().setSize(600,350);
        vista.getDigSeleccionarEnvio().setLocationRelativeTo(vista);
        viaje_BD modeloC=new viaje_BD();
        List<viaje_MD> lista=modeloC.lista_viaje();
        DefaultTableModel mTabla=(DefaultTableModel) vista.getTblEnvio().getModel();
        mTabla.setNumRows(0);   
        String[] columnas={"ID VIA", "ID CAMION", "ID CAMIONERO", "FECHA CONDUCCION"};
        mTabla.setColumnIdentifiers(columnas);
        lista.stream().forEach(pe->{
            String[] registro={String.valueOf(pe.getVia()), String.valueOf(pe.getCam()), String.valueOf(pe.getCa()), String.valueOf(pe.getFecha_conduccion())};
            mTabla.addRow(registro);
        });
        vista.getDigSeleccionarEnvio().setVisible(true);
        
    }
    private void elegirCliente(){
        vista.getDigSeleccionarCliente().setTitle("SELECCIONAR CLIENTE");
        vista.getDigSeleccionarCliente().setSize(890,270);
        vista.getDigSeleccionarCliente().setLocationRelativeTo(vista);
        ModeloCliente modeloC=new ModeloCliente();
        List<Cliente> lista=modeloC.ListClientes();
        DefaultTableModel mTabla=(DefaultTableModel) vista.getTblCliente().getModel();
        mTabla.setNumRows(0);   
        String[] columnas={"ID CLIENTE", "DNI", "NOMBRE", "APELLIDO", "CORREO", "TELEFONO", "DIRECCION", "POBLACION"};
        mTabla.setColumnIdentifiers(columnas);
        lista.stream().forEach(pe->{
            Object[] registro={String.valueOf(pe.getId_cli()), pe.getDni(), pe.getNombre(), pe.getApellido(), String.valueOf(pe.getCorreo()), pe.getTelefono(), String.valueOf(pe.getDireccion()), String.valueOf(pe.getId_pob())};
            mTabla.addRow(registro);
        });
        vista.getDigSeleccionarCliente().setVisible(true);
    }
    private void clickTblCliente(){
        vista.getTxtIdCliente().setText(vista.getTblCliente().getValueAt(vista.getTblCliente().getSelectedRow(), 0).toString());
        vista.getDigSeleccionarCliente().dispose();
    }
    private void clickTblEnvio(){
        vista.getTxtIdEnvio().setText(vista.getTblEnvio().getValueAt(vista.getTblEnvio().getSelectedRow(), 0).toString());
        vista.getDigSeleccionarEnvio().dispose();
    }
}
