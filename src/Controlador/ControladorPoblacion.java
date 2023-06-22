/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author HP
 */
import Modelo.ModeloPoblacion;
import Modelo.Poblacion;
import Vista.VistaPoblacion;
import java.awt.event.KeyAdapter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrea
 */
public class ControladorPoblacion {
    private ModeloPoblacion modelo;
    private VistaPoblacion vista;

    public ControladorPoblacion(ModeloPoblacion modelo, VistaPoblacion vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }
    
    public void iniciarControl(){
        cargarPoblacion();
        validateCamps();
        vista.getBtnActualizar().addActionListener(l->cargarPoblacion());
        vista.getBtnCrear().addActionListener(l->abrirPoblacionDialog(1));
        vista.getBtnEditar().addActionListener(l->abrirPoblacionDialog(2));
        vista.getBtnAceptar().addActionListener(l->ingresarModificarProvincia());
        vista.getBtnEliminar().addActionListener(l->eliminarPoblacion());
        vista.getBtnBuscar().addActionListener(l->buscarProvincia());
    }
    private void cargarPoblacion(){
        List<Poblacion> lista=modelo.listaPoblacion();
        DefaultTableModel tablam=(DefaultTableModel) vista.getTblProvincia().getModel();
        tablam.setRowCount(0);
        String[] columnas={"ID","Nombre"};
        tablam.setColumnIdentifiers(columnas);
        lista.stream().forEach(provincia->{
            Object[] registro={provincia.getId(),provincia.getNombre()};
            tablam.addRow(registro);
        });
    }
    
    private void abrirPoblacionDialog(int ce){//HACE VISIBLE EL FORMULARIO DE LA PROVINCIA
        String title;
        boolean openwindow = false;
        if (ce == 1) {
            title = "Crear Poblacion";
            vista.getDigProvincia().setName("crear");
            openwindow = true;
        } else {
            title = "Modificar Poblacion";
            vista.getDigProvincia().setName("editar");
            try {
                openwindow = uploadDates(vista.getTblProvincia());
            } catch (ParseException ex) {
                Logger.getLogger(ControladorCamionero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(vista.getDigProvincia().getName().equals("crear")){
            vista.getLabelid().setText(String.valueOf(modelo.idPoblacionGen()+1));
        }
        
        if (openwindow) {
            vista.getDigProvincia().setLocationRelativeTo(vista.getBtnCrear());
            vista.getDigProvincia().setSize(350, 300);
            vista.getDigProvincia().setTitle(title);
            vista.getDigProvincia().setVisible(true);
        }
    }
    
    private void ingresarModificarProvincia(){//BOTON ACEPTAR DEL FORMULARIO VALIDACIONES
        if (vista.getDigProvincia().getTitle().equals("Crear Poblacion")) {
            if (!vista.getTxtNombre().getText().matches("[a-zA-Z]{1,50}")) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UN NOMBRE DE MAXIMO 50 CARACTERES");
                return;
            }
            SQLException grabarPoblacion = new ModeloPoblacion(Integer.parseInt(vista.getLabelid().getText()),vista.getTxtNombre().getText()).grabarPoblacion();
            cargarPoblacion();
        }else{
            if (vista.getTxtNombre().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "DEBE DE INGRESAR UN NOMBRE");
                return;
            }
            if (vista.getTxtNombre().getText().isEmpty()||vista.getTxtNombre().getText().matches("([a-zA-Z0-9.,-]|\\s){1,60}")==false) {
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN NOMBRE DE MAXIMO 60 CARACTERES");
                return;
            }
            new ModeloPoblacion(Integer.parseInt(vista.getLabelid().getText()),vista.getTxtNombre().getText()).modificarPoblacion();
            cargarPoblacion();
        }
        vista.getDigProvincia().dispose();
        limpiar();
    }
    
    private void eliminarPoblacion(){
        if (vista.getTblProvincia().getSelectedRow()!=1) {
            JOptionPane.showMessageDialog(null, "DEBE DE SELECCIONAR UNA FILA DE POBLACION A ELIMINAR");
            return;
        } else
        if (modelo.eliminarPoblacion(Integer.parseInt(vista.getTblProvincia().getValueAt(vista.getTblProvincia().getSelectedRow(), 0).toString())) == null) {
            JOptionPane.showMessageDialog(null, "SE HA ELIMINADO A LA POBLACION");
        } else {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR LA POBLACION");
        }
        cargarPoblacion();
    }
    
    private void buscarProvincia(){
        List<Poblacion> lista=modelo.buscaPoblacion(vista.getTxtBuscar().getText());
        DefaultTableModel tablam=(DefaultTableModel) vista.getTblProvincia().getModel();
        String[] columnas={"ID","Nombre"};
        tablam.setColumnIdentifiers(columnas);
        tablam.setRowCount(0);
        lista.stream().forEach(po->{
            Object[] registro={po.getId(),po.getNombre()};
            tablam.addRow(registro);
        });
    }
    private void limpiar(){
            vista.getTxtNombre().setText(null);
            vista.getLabelid().setText(null);
    }
    
    private boolean uploadDates(JTable table) throws ParseException {
        boolean a = false;
        if (table.getSelectedRowCount() == 1) {
            a = true;
            vista.getLabelid().setText(String.valueOf(vista.getTblProvincia().getValueAt(vista.getTblProvincia().getSelectedRow(), 0)));
            vista.getTxtNombre().setText(String.valueOf(vista.getTblProvincia().getValueAt(vista.getTblProvincia().getSelectedRow(), 1)));
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA DE LA TABLA");
        }
        return a;
    }
    
    private void validateCamps() {
        vista.getTxtNombre().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char key = evt.getKeyChar();
                if (Character.isDigit(key) || vista.getTxtNombre().getText().length() >= 50) {
                    evt.consume();
                }
            }
        });
    }
}

