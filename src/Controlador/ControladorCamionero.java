package Controlador;

import Modelo.Camionero;
import Modelo.ModeloCamionero;
import Modelo.ModeloPersona;
import Modelo.ModeloPoblacion;
import Modelo.ModeloProvincia;
import Modelo.Poblacion;
import Modelo.Provincia;
import Vista.VistaPersona;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
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
public class ControladorCamionero {

    private ModeloCamionero modelo;
    private VistaPersona vista;

    public ControladorCamionero() {
    }

    public ControladorCamionero(ModeloCamionero modelo, VistaPersona vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }

    public void iniciaControl() {
        cargaCamioneros();
        cargarComboPoblacion();
        cargarComboProvincia();
        validateCamps();
        vista.getBtnActualizar().addActionListener(l -> cargaCamioneros());
        vista.getBtnCrear().addActionListener(l -> abrirDialogo(1));
        vista.getBtnEditar().addActionListener(l -> abrirDialogo(2));
        vista.getBtnEliminar().addActionListener(l -> eliminarCamionero(vista.getTblCamionero()));
        vista.getBtnAceptar().addActionListener(l -> crearEditarPersona());
        vista.getTxtBuscar().addActionListener(l -> buscarCamionero());
        vista.getBtnCancelar().addActionListener(l -> cancellOperation());
    }

    private void cargaCamioneros() {
        //Control para consultar a la BD/modelo y luego cargar en la vista
        ModeloPoblacion mp = new ModeloPoblacion();
        ModeloProvincia mpro = new ModeloProvincia();
        List<Camionero> listap = modelo.ListCamioneros();
        List<Poblacion> listapob = mp.listaPoblacion();
        List<Provincia> listapro = mpro.listaProvincia();

        DefaultTableModel mTabla;
        mTabla = new DefaultTableModel();
        mTabla.setNumRows(0); //Limpio la tabla
        mTabla.setColumnCount(7);
        mTabla.setColumnIdentifiers(new Object[]{"ID CAMIONERO", "DNI", "NOMBRE", "APELLIDO", "SALARIO", "TELEFONO", "DIRECCION", "POBLACION"});
        vista.getTblCamionero().setModel(mTabla);

        listap.stream().forEach(pe -> {
            listapob.stream().forEach(pob -> {
                listapro.stream().forEach(pro -> {
                    if (pe.getDireccion() == pro.getId_pro() && pe.getId_pob() == pob.getId()) {
                        String[] filanueva = {String.valueOf(pe.getId_ca()), pe.getDni(), pe.getNombre(),
                            pe.getApellido(), String.valueOf(pe.getSalario()), pe.getTelefono(), 
                            pro.getNombre_pro(),
                            pob.getNombre()};
                        mTabla.addRow(filanueva);
                    };
                });
            });
        });
    }

    private void abrirDialogo(int ce) {
        String title;
        boolean openwindow = false;
        if (ce == 1) {
            title = "Crear Persona";
            vista.getDigCamionero().setName("crear");
            openwindow = true;
        } else {
            title = "Editar Persona";
            vista.getDigCamionero().setName("editar");
            try {
                openwindow = uploadDates(vista.getTblCamionero());
            } catch (ParseException ex) {
                Logger.getLogger(ControladorCamionero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        int prevent = 0;
        if (openwindow) {
            vista.getDigCamionero().setLocationRelativeTo(vista.getBtnCrear());
            vista.getDigCamionero().setSize(500, 400);
            vista.getDigCamionero().setTitle(title);
            vista.getDigCamionero().setVisible(true);

            if (vista.getDigCamionero().getName().equals("crear")) {
                ModeloCamionero persona = new ModeloCamionero();
                String id_ca = persona.NoSerie();

                int increment_ca;

                if (id_ca == null) {
                    vista.getIdlbl().setText("000001");
                } else {
                    increment_ca = Integer.parseInt(id_ca);
                    increment_ca++;
                    vista.getIdlbl().setText("00000" + increment_ca);
                }
            }
        }
    }

    private void crearEditarPersona() {
        ModeloPersona per = new ModeloPersona();
        ModeloCamionero persona = new ModeloCamionero();
        String id_ca = persona.NoSerie();
        String id_per = per.NoSerie();

        int increment_per = 0;
        int increment_ca = 0;

        if (vista.getDigCamionero().getName().equals("crear")) {
            //INSERTAR
            String cedula = vista.getTxtDni().getText();
            String nombre = vista.getTxtNombre().getText();
            String apellido = vista.getTxtApellido().getText();
            String salario = vista.getTxtSalario().getText();
            String telefono = vista.getTxtTelefono().getText();
            int direccion = vista.getTxtDireccion().getSelectedIndex() + 1;
            int poblacion = vista.getTxtPoblacion().getSelectedIndex() + 1;

            if (id_per == null) {
                increment_per = 1;
            } else {
                increment_per = Integer.parseInt(id_per);
                increment_per++;
            }

            if (id_ca == null) {
                increment_ca = 1;
            } else {
                increment_ca = Integer.parseInt(id_ca);
                increment_ca++;
            }

            persona.setId(increment_per);
            persona.setId_ca(increment_ca);
            persona.setDni(cedula);
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setTelefono(telefono);
            persona.setDireccion(direccion);
            persona.setId_pob(poblacion);
            persona.setSalario(Double.parseDouble(salario));

            if (allowCreateEdit()) {
                if (!persona.isRepeat()) {
                    if (persona.GrabaPersonaDB() == null) {
                        JOptionPane.showMessageDialog(null, "SE HA CREADO AL CAMIONERO CON ÉXITO");
                    } else {
                        JOptionPane.showMessageDialog(null, "NO SE HA PODIDO CREAR EL CAMIONERO");
                    }

                } else {
                    int a = JOptionPane.showConfirmDialog(null, "CÉDULA YA INGRESADA, ¿QUIERE REGISTRAR A ESTA PERSONA COMO CAMIONERO?");
                    if (a == 0) {
                        if (!persona.isRepeatCa()) {
                            persona.setId(persona.getID());
                            if (persona.RegistrarCamioneroDB() == null) {
                                JOptionPane.showMessageDialog(null, "LA PERSONA HA SIDO REGISTRADA COMO CAMIONERO");
                            } else {
                                JOptionPane.showMessageDialog(null, "NO SE HA PODIDO REGISTRAR A LA PERSONA");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR, LA PERSONA YA HA SIDO REGISTRADA COMO CAMIONERO ANTERIORMENTE");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "SE HA CANCELADO EL REGISTRO COMO CAMIONERO");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "ASEGÚRESE QUE TODOS LOS CAMPOS ESTÉN LLENOS");
            }
        } else if (vista.getDigCamionero().getName().equals("editar")) {
            //EDITAR
            vista.getIdlbl().setText((String.valueOf(vista.getTblCamionero().getValueAt(vista.getTblCamionero().getSelectedRow(), 0))));
            String id_cam = vista.getIdlbl().getText();
            String cedula = vista.getTxtDni().getText();
            String nombre = vista.getTxtNombre().getText();
            String apellido = vista.getTxtApellido().getText();
            String telefono = vista.getTxtTelefono().getText();
            String salario = vista.getTxtSalario().getText();
            int direccion = vista.getTxtDireccion().getSelectedIndex() + 1;
            int poblacion = vista.getTxtPoblacion().getSelectedIndex() + 1;

            persona.setId_ca(Integer.parseInt(id_cam));
            per.setId(modelo.getIdPer(Integer.parseInt(id_cam)));
            per.setDni(cedula);
            per.setNombre(nombre);
            per.setApellido(apellido);
            per.setTelefono(telefono);
            persona.setSalario(Double.parseDouble(salario));
            per.setDireccion(direccion);
            per.setId_pob(poblacion);
            
            if (allowCreateEdit()) {
                if (persona.EditCamioneroDB() == null && per.EditPersonaDB() == null) {
                    JOptionPane.showMessageDialog(null, "SE HA EDITADO AL CAMIONERO CON ÉXITO");
                    vista.getDigCamionero().dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE HA PODIDO CREAR AL CAMIONERO");
                    vista.getDigCamionero().dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "ASEGÚRESE QUE TODOS LOS CAMPOS SE ENCUENTREN LLENOS");
            }
        }
        closeAndClean();
        cargaCamioneros();
    }

    private void eliminarCamionero(JTable table) {
        int a;
        ModeloCamionero persona = new ModeloCamionero();
        if (table.getSelectedRowCount() == 1) {
            persona.setId_ca(Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0)));
            if (persona.allowDelete() == 0) {
                a = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE ELIMINAR AL CLIENTE");
                switch (a) {
                    case 0:
                        if (persona.DeletePhisicPerson() == null) {
                            JOptionPane.showMessageDialog(null, "SE HA ELIMNADO A LA PERSONA CON ÉXITO");
                        } else {
                            JOptionPane.showMessageDialog(null, "NO SE HA PODIDO ELIMINAR AL CLIENTE");
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "SE HA CANCELADO LA ELIMINACION");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR AL CLIENTE, EL CLIENTE SE ENCUENTRA RELACIONADO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NECESITA SELECCIONAR UNA FILA PRIMERO");
        }
        cargaCamioneros();
    }

    private void buscarCamionero() {
        ModeloCamionero persona = new ModeloCamionero();
        persona.setDni(vista.getTxtBuscar().getText());
        List<Camionero> listap = persona.SearchListCamioneros();

        if (!listap.isEmpty()) {
            DefaultTableModel mTabla;
            mTabla = (DefaultTableModel) vista.getTblCamionero().getModel();
            mTabla.setNumRows(0); //Limpio la tabla
            mTabla.setColumnCount(7);
            mTabla.setColumnIdentifiers(new Object[]{"ID CAMIONERO", "DNI", "NOMBRE", "APELLIDO", "SALARIO", "TELEFONO", "DIRECCION", "POBLACION"});
            vista.getTblCamionero().setModel(mTabla);

            listap.stream().forEach(pe -> {
                String[] filanueva = {String.valueOf(pe.getId_ca()), pe.getDni(), pe.getNombre(), pe.getApellido(), String.valueOf(pe.getSalario()), pe.getTelefono(), String.valueOf(pe.getDireccion()), String.valueOf(pe.getId_pob())};
                mTabla.addRow(filanueva);
            });
        } else {
            JOptionPane.showMessageDialog(null, "NO SE HA ENCONTRADO EL CAMIONERO");
        }

    }

    private boolean uploadDates(JTable table) throws ParseException {
        boolean a = false;
        if (table.getSelectedRowCount() == 1) {
            a = true;
            ModeloProvincia mp = new ModeloProvincia();
            ModeloPoblacion mpo = new ModeloPoblacion();
            vista.getTxtDni().setEnabled(false);
            vista.getIdlbl().setText((String.valueOf(vista.getTblCamionero().getValueAt(vista.getTblCamionero().getSelectedRow(), 0))));
            vista.getTxtDni().setText((String.valueOf(vista.getTblCamionero().getValueAt(vista.getTblCamionero().getSelectedRow(), 1))));
            vista.getTxtNombre().setText(String.valueOf(vista.getTblCamionero().getValueAt(vista.getTblCamionero().getSelectedRow(), 2)));
            vista.getTxtApellido().setText(String.valueOf(vista.getTblCamionero().getValueAt(vista.getTblCamionero().getSelectedRow(), 3)));
            vista.getTxtSalario().setText(String.valueOf(vista.getTblCamionero().getValueAt(vista.getTblCamionero().getSelectedRow(), 4)));
            vista.getTxtTelefono().setText(String.valueOf(vista.getTblCamionero().getValueAt(vista.getTblCamionero().getSelectedRow(), 5)));
            vista.getTxtDireccion().setSelectedIndex(mp.getIdPro(String.valueOf(vista.getTblCamionero().getValueAt(vista.getTblCamionero().getSelectedRow(),6)))-1);
            vista.getTxtPoblacion().setSelectedIndex(mpo.getIdPob(String.valueOf(vista.getTblCamionero().getValueAt(vista.getTblCamionero().getSelectedRow(),7)))-1);
        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA DE LA TABLA");
        }
        return a;
    }

    private void cargarComboProvincia() {
        ModeloProvincia modelop = new ModeloProvincia();
        List<Provincia> listap = modelop.listaProvincia();

        listap.stream().forEach(pe -> {
            vista.getTxtDireccion().addItem(new Provincia(pe.getCodigo_pro(), pe.getNombre_pro()));
        });
    }

    private void cargarComboPoblacion() {
        ModeloPoblacion modelop = new ModeloPoblacion();
        List<Poblacion> listap = modelop.listaPoblacion();

        listap.stream().forEach(pe -> {
            vista.getTxtPoblacion().addItem(new Poblacion(pe.getId(), pe.getNombre()));
        });
    }

    private void closeAndClean() {
        vista.getIdlbl().setText("");
        vista.getTxtDni().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtTelefono().setText("");
        vista.getTxtSalario().setText("");
        vista.getTxtPoblacion().setSelectedItem(null);
        vista.getTxtDireccion().setSelectedItem(null);
        vista.getDigCamionero().dispose();
        vista.getTblCamionero().clearSelection();
        vista.getTxtDni().setEnabled(true);
    }

    private void cancellOperation() {
        closeAndClean();
    }

    private void validateCamps() {
        vista.getTxtDni().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char key = evt.getKeyChar();
                if (!Character.isDigit(key) || vista.getTxtDni().getText().length() >= 10) {
                    evt.consume();
                }
            }
        });

        vista.getTxtNombre().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char key = evt.getKeyChar();
                if (Character.isDigit(key) || vista.getTxtNombre().getText().length() >= 50 || key == KeyEvent.VK_SPACE) {
                    evt.consume();
                }
            }
        });

        vista.getTxtApellido().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char key = evt.getKeyChar();
                if (Character.isDigit(key) || vista.getTxtApellido().getText().length() >= 50 || key == KeyEvent.VK_SPACE) {
                    evt.consume();
                }
            }
        });

        vista.getTxtTelefono().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char key = evt.getKeyChar();
                if (!Character.isDigit(key) || vista.getTxtTelefono().getText().length() >= 10) {
                    evt.consume();
                }
            }
        });

        vista.getTxtSalario().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char key = evt.getKeyChar();
                if (!Character.isDigit(key) || (key == '.' && !vista.getTxtSalario().getText().contains("."))) {
                    evt.consume();
                }
            }
        });
    }

    public boolean allowCreateEdit() {
        boolean a = (!vista.getTxtApellido().getText().isEmpty() && !vista.getTxtNombre().getText().isEmpty()
                && !vista.getTxtTelefono().getText().isEmpty() && !vista.getTxtSalario().getText().isEmpty()
                && vista.getTxtDireccion().getSelectedItem() != null && vista.getTxtPoblacion().getSelectedItem() != null);
        return a;
    }
}
