/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class C_viaje {

    private viaje_BD modelo;
    private VistaViaje vista;

    public C_viaje() {
    }

    public C_viaje(viaje_BD modelo, VistaViaje vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.setVisible(true);
    }

    public void iniciarControl() {
        cargar();
        cargarComboCamion();
        cargarComboCamionero();
        cargarComboProvincia();
        vista.getBtnActualizar().addActionListener(l -> cargar());
        vista.getBtnCrear().addActionListener(l -> crearViaje());
        vista.getBtnEditar().addActionListener(l -> editarViaje());
        vista.getBtnEliminar().addActionListener(l -> eliminarviaje(vista.getTblViaje()));
        vista.getTxtBuscar().addActionListener(l -> buscarViaje());

    }

    private void cargar() {
        ModeloCamionero mca = new ModeloCamionero();
        ModeloCamion mcam = new ModeloCamion();
        ModeloProvincia mpro = new ModeloProvincia();
        List<viaje_MD> lista = modelo.lista_viaje();
        List<Provincia> listapro = mpro.listaProvincia();
        List<Camionero> listaca = mca.ListCamioneros();
        List<Camion> listacam = mcam.ListarCamiones();

        DefaultTableModel mTabla;
        mTabla = new DefaultTableModel();
        mTabla.setNumRows(0); //Limpio la tabla
        mTabla.setColumnCount(6);
        mTabla.setColumnIdentifiers(new Object[]{"ID", "CAMIONERO", "CAMION", "PROVINCIA", "FECHA CONDUCCION", "FECHA LLEGADA"});
        vista.getTblViaje().setModel(mTabla);

        lista.stream().forEach(vi -> {
            listapro.stream().forEach(pro -> {
                listaca.stream().forEach(ca -> {
                    listacam.stream().forEach(cam -> {
                        if (vi.getPro() == pro.getId_pro() && vi.getCa() == ca.getId_ca() && vi.getCam() == cam.getId_cam()) {
                            String[] filanueva = {String.valueOf(vi.getVia()), ca.getNombre() + " " + ca.getApellido(), cam.getModelo_cam(),
                                pro.getNombre_pro(), String.valueOf(vi.getFecha_conduccion()), String.valueOf(vi.getFecha_llegada())};
                            mTabla.addRow(filanueva);
                        };
                    });
                });
            });
        });

        viaje_BD vi = new viaje_BD();
        String id_cli = vi.NoSerie();

        int increment_cli;

        if (id_cli == null) {
            vista.getLabelID().setText("000001");
        } else {
            increment_cli = Integer.parseInt(id_cli);
            increment_cli++;
            vista.getLabelID().setText("00000" + increment_cli);
        }

        vista.getDcfechacon().setEnabled(false);
        vista.getDcfechacon().getCalendarButton().setEnabled(true);

        vista.getDcfechallega().setEnabled(false);
        vista.getDcfechallega().getCalendarButton().setEnabled(true);
    }

    private void crearViaje() {
        viaje_BD viaje = new viaje_BD();
        int id = Integer.parseInt(vista.getLabelID().getText());
        int idca = vista.getCombo_camionero().getItemAt(vista.getCombo_camionero().getSelectedIndex()).getId_ca();
        int idcam = vista.getCombo_camion().getItemAt(vista.getCombo_camion().getSelectedIndex()).getId_cam();
        int idpro = vista.getCombo_provincio().getItemAt(vista.getCombo_provincio().getSelectedIndex()).getId_pro();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            java.sql.Date feccond = new java.sql.Date(vista.getDcfechacon().getDate().getTime());
            java.sql.Date feclle = new java.sql.Date(vista.getDcfechallega().getDate().getTime());

            viaje.setVia(id);
            viaje.setCa(idca);
            viaje.setCam(idcam);
            viaje.setPro(idpro);
            viaje.setFecha_conduccion(feccond);
            viaje.setFecha_llegada(feclle);

            if (vista.getDcfechacon().getDate().before(vista.getDcfechallega().getDate())) {
                if (allowCreateEdit()) {
                    if (viaje.GrabaViajeDB() == null) {
                        JOptionPane.showMessageDialog(null, "SE HA CREADO EL VIAJE CON ÉXITO");
                    } else {
                        JOptionPane.showMessageDialog(null, "NO SE HA PODIDO CREAR EL VIAJE");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "ASEGÚRESE QUE TODOS LOS CAMPOS ESTÉN LLENOS");
                }
            } else {
                JOptionPane.showMessageDialog(null, "RANGO DE FECHA NO VÁLIDA \nLA FECHA DE LLEGADA NO PUEDE SER MENOR A LA DEL ENVÍO");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "ASEGÚRESE DE QUE HA ELEGIDO LA FECHA");
        }
        cargar();
    }

    public void buscarViaje() {
        ModeloCamionero mca = new ModeloCamionero();
        ModeloCamion mcam = new ModeloCamion();
        ModeloProvincia mpro = new ModeloProvincia();
        List<viaje_MD> lista = modelo.SearchListPersonas();
        List<Provincia> listapro = mpro.listaProvincia();
        List<Camionero> listaca = mca.ListCamioneros();
        List<Camion> listacam = mcam.ListarCamiones();

        DefaultTableModel mTabla;
        mTabla = new DefaultTableModel();
        mTabla.setNumRows(0); //Limpio la tabla
        mTabla.setColumnCount(6);
        mTabla.setColumnIdentifiers(new Object[]{"ID", "CAMIONERO", "CAMION", "PROVINCIA", "FECHA CONDUCCION", "FECHA LLEGADA"});
        vista.getTblViaje().setModel(mTabla);

        lista.stream().forEach(vi -> {
            listapro.stream().forEach(pro -> {
                listaca.stream().forEach(ca -> {
                    listacam.stream().forEach(cam -> {
                        if (vi.getPro() == pro.getId_pro() && vi.getCa() == ca.getId_ca() && vi.getCam() == cam.getId_cam()) {
                            String[] filanueva = {String.valueOf(vi.getVia()), ca.getNombre() + " " + ca.getApellido(), cam.getModelo_cam(),
                                pro.getNombre_pro(), String.valueOf(vi.getFecha_conduccion()), String.valueOf(vi.getFecha_llegada())};
                            mTabla.addRow(filanueva);
                        };
                    });
                });
            });
        });

        viaje_BD vi = new viaje_BD();
        String id_cli = vi.NoSerie();

        int increment_cli;

        if (id_cli == null) {
            vista.getLabelID().setText("000001");
        } else {
            increment_cli = Integer.parseInt(id_cli);
            increment_cli++;
            vista.getLabelID().setText("00000" + increment_cli);
        }

        vista.getDcfechacon().setEnabled(false);
        vista.getDcfechacon().getCalendarButton().setEnabled(true);

        vista.getDcfechallega().setEnabled(false);
        vista.getDcfechallega().getCalendarButton().setEnabled(true);
    }

    private void editarViaje() {
        JOptionPane.showMessageDialog(null, "REGISTRO PERMANENTE, NO SE PUEDE EDITAR.");
    }

    private void eliminarviaje(JTable table) {
        viaje_BD viaje = new viaje_BD();
        if (table.getSelectedRowCount() == 1) {
            viaje.setVia(Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0)));
            if (!viaje.isUtilize()) {
                if (viaje.DeletePhisicViaje() == null) {
                    JOptionPane.showMessageDialog(null, "SE HA ELIMNADO  CON ÉXITO");
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE HA PODIDO ELIMINAR ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR, HA SIDO REGISTRADO PARA UN PAQUETE");
            }

        } else {
            JOptionPane.showMessageDialog(null, "NECESITA SELECCIONAR UNA FILA PRIMERO");
        }
    }

    public boolean allowCreateEdit() {
        boolean a = (vista.getCombo_camion().getSelectedItem() != null && vista.getCombo_camionero().getSelectedItem() != null
                && vista.getCombo_provincio().getSelectedItem() != null && vista.getDcfechacon().getDate() != null && vista.getDcfechallega().getDate() != null);
        return a;
    }

    private void cargarComboCamion() {
        ModeloCamion modelop = new ModeloCamion();
        List<Camion> listap = modelop.ListarCamiones();

        listap.stream().forEach(pe -> {
            vista.getCombo_camion().addItem(new Camion(pe.getId_cam(), pe.getMatricula_cam()));
        });
    }

    private void cargarComboCamionero() {
        ModeloCamionero modelop = new ModeloCamionero();
        List<Camionero> listap = modelop.ListCamioneros();

        listap.stream().forEach(pe -> {
            vista.getCombo_camionero().addItem(new Camionero(pe.getId_ca(), pe.getDni(), pe.getNombre()));
        });
    }

    private void cargarComboProvincia() {
        ModeloProvincia modelop = new ModeloProvincia();
        List<Provincia> listap = modelop.listaProvincia();

        listap.stream().forEach(pe -> {
            vista.getCombo_provincio().addItem(new Provincia(pe.getId_pro(), pe.getNombre_pro()));
        });
    }
}
