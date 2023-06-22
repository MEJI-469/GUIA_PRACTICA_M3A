/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConnectionG2;
import Modelo.ModeloProvincia;
import Modelo.Provincia;
import Vista.VistaProvincia;
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
public class ControladorProvincia {
    private ModeloProvincia modelo;
    private VistaProvincia vista;

    public ControladorProvincia(ModeloProvincia modelo, VistaProvincia vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }
    public void iniciarControl(){
        cargarProvincia();
        vista.getBtnActualizar().addActionListener(l->cargarProvincia());
        vista.getBtnCrear().addActionListener(l->abrirProvinciaDialog(0));
        vista.getBtnEditar().addActionListener(l->abrirProvinciaDialog(1));
        vista.getBtnAceptar().addActionListener(l->ingresarModificarProvincia());
        vista.getBtnEliminar().addActionListener(l->eliminarProvincia());
        vista.getBtnBuscar().addActionListener(l->buscarProvincia());
        vista.getTxtBuscar().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt){
                buscarProvincia();
            }
        });
    }
    private void cargarProvincia(){
        List<Provincia> lista=modelo.listaProvincia();
        DefaultTableModel tablam=(DefaultTableModel) vista.getTblProvincia().getModel();
        tablam.setRowCount(0);
        String[] columnas={"Codigo","Nombre"};
        tablam.setColumnIdentifiers(columnas);
        lista.stream().forEach(provincia->{
            Object[] registro={provincia.getCodigo_pro(),provincia.getNombre_pro()};
            tablam.addRow(registro);
        });
    }
    private void abrirProvinciaDialog(int ce){//HACE VISIBLE EL FORMULARIO DE LA PROVINCIA
        String titulo;
        if (ce==0) {
            titulo="Crear Provincia";
            vista.getDigProvincia().setTitle(titulo);
            vista.getDigProvincia().setSize(600, 600);
            vista.getDigProvincia().setLocationRelativeTo(vista);
            vista.getDigProvincia().setVisible(true);
        }else{
            if (vista.getTblProvincia().getSelectedRow()<0) {
                JOptionPane.showMessageDialog(null, "DEBE DE SELECCIONAR LA PROVINCIA A MODIFICAR");
                return;
            }try{
                if (modelo.buscarProvincia(vista.getTblProvincia().getValueAt(vista.getTblProvincia().getSelectedRow(), 0).toString())==false) {
                    JOptionPane.showMessageDialog(null, "NO SE ENCONTRO DICHA PROVINCIA");
                    return; 
                }
                ConnectionG2 con=new ConnectionG2();
                String sql="SELECT codigo_pro,nombre_pro FROM PROVINCIA WHERE codigo_pro='"+vista.getTblProvincia().getValueAt(vista.getTblProvincia().getSelectedRow(), 0).toString()+"'";
                ResultSet rs=con.Consulta(sql);rs.next();
                vista.getTxtCodigo().setText(rs.getString("codigo_pro"));
                vista.getTxtNombre().setText(rs.getString("nombre_pro"));
                vista.getTxtCodigo().setEnabled(false);
            }catch (SQLException ex) {
                Logger.getLogger(ModeloProvincia.class.getName()).log(Level.SEVERE, null, ex);
            }
            titulo="Modificar Provincia";
            vista.getDigProvincia().setTitle(titulo);
            vista.getDigProvincia().setLocationRelativeTo(vista);
            vista.getDigProvincia().setSize(600, 6000);
            vista.getDigProvincia().setVisible(true);
        }
    }
    private void ingresarModificarProvincia(){//BOTON ACEPTAR DEL FORMULARIO VALIDACIONES
        if (vista.getDigProvincia().getTitle().equals("Crear Provincia")) {
            if (vista.getTxtCodigo().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UN CODIGO");
                return;
            }
            if (!vista.getTxtCodigo().getText().matches("[a-zA-Z0-9]{1,5}")) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UN CODIGO DE MAXIMO 5 CARACTERES");
                return;
            }
            if (vista.getTxtNombre().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UN NOMBRE");
                return;
            }
            if (vista.getTxtNombre().getText().isEmpty()||vista.getTxtNombre().getText().matches("([a-zA-Z0-9.,-]|\\s){1,60}")==false) {
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN NOMBRE DE MAXIMO 60 CARACTERES");
                return;
            }
            try{
                if (modelo.buscarProvincia(vista.getTxtCodigo().getText())==true) {
                    JOptionPane.showMessageDialog(null, "YA EXISTE UNA PROVINCIA CON ESE CODIGO");
                return;
                }
            }catch (SQLException ex) {
                Logger.getLogger(ModeloProvincia.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            new ModeloProvincia(vista.getTxtCodigo().getText(),vista.getTxtNombre().getText()).grabarProvincia();
            cargarProvincia();
        }else{
            if (vista.getTxtNombre().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UN NOMBRE");
                return;
            }
            if (vista.getTxtNombre().getText().isEmpty()||vista.getTxtNombre().getText().matches("([a-zA-Z0-9.,-]|\\s){1,60}")==false) {
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN NOMBRE DE MAXIMO 60 CARACTERES");
                return;
            }
            new ModeloProvincia(vista.getTxtCodigo().getText(),vista.getTxtNombre().getText()).modificarProvincia(vista.getTxtCodigo().getText());
            cargarProvincia();
            vista.getDigProvincia().dispose();
        }
        limpiar();
    }
    private void eliminarProvincia(){
        if (vista.getTblProvincia().getSelectedRow()<0) {
            JOptionPane.showMessageDialog(null, "DEBE DE SELECCIONAR LA PROVINCIA A ELIMINAR");
            return;
        }
        try{
            if (modelo.buscarProvincia(vista.getTblProvincia().getValueAt(vista.getTblProvincia().getSelectedRow(), 0).toString())==false) {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO DICHA PROVINCIA");
                return;
            }
            if(modelo.isUtilizated(vista.getTblProvincia().getValueAt(vista.getTblProvincia().getSelectedRow(), 0).toString()) || modelo.isUtilizated1(vista.getTblProvincia().getValueAt(vista.getTblProvincia().getSelectedRow(), 0).toString())){
                JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR DEBIDO A QUE SE ENCUENTRA RELACIONADA");
            } else{
                modelo.eliminarProvincia(vista.getTblProvincia().getValueAt(vista.getTblProvincia().getSelectedRow(), 0).toString());
            }
            cargarProvincia();
        }catch (SQLException ex) {
            Logger.getLogger(ModeloProvincia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void buscarProvincia(){
        List<Provincia> lista=modelo.buscaProvincia(vista.getTxtBuscar().getText());
        DefaultTableModel tablam=(DefaultTableModel) vista.getTblProvincia().getModel();
        String[] columnas={"Codigo","Nombre"};
        tablam.setColumnIdentifiers(columnas);
        tablam.setRowCount(0);
        lista.stream().forEach(provincia->{
            Object[] registro={provincia.getCodigo_pro(),provincia.getNombre_pro()};
            tablam.addRow(registro);
        });
    }
    private void limpiar(){
            vista.getTxtCodigo().setText(null);
            vista.getTxtNombre().setText(null);
            vista.getTxtCodigo().setEnabled(true);
    }
}
