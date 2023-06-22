package Controlador;
import Modelo.*;
import Vista.*;
import java.awt.event.KeyAdapter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCamion {
    
    private final ModeloCamion mc;
    private final VistaCamion vc;
    private final ModeloTipoCam tp;
    private final VistaTipoCamion vtc;
    
    public ControladorCamion(ModeloCamion mc, VistaCamion vc, ModeloTipoCam tp, VistaTipoCamion vtc) {
        this.mc = mc;
        this.vc = vc;
        this.tp = tp;
        this.vtc = vtc;
        vc.setVisible(true);
    }
    
    //Mandos primarios de control de la vista y modelo de camión
    public void IniciaControl() {
        vc.getBtnlist().addActionListener(l -> CargaCamiones());
        vc.getBtncrearcam().addActionListener(l -> AbrirDialogo(1));
        vc.getBtncrearcam().addActionListener(l -> LlenaCombo());
        vc.getBtncrearcam().addActionListener(l -> vtc.getLblid().setText(String.valueOf(IncrementaID())));
        vc.getBtnaddtipo().addActionListener(l -> AbreCrudTipo());
        vc.getBtnactualizarcam().addActionListener(l -> AbrirDialogo(2));
        vc.getBtnactualizarcam().addActionListener(l -> LlenaCombo());
        vc.getBtneliminarcam().addActionListener(l -> AbrirDialogo(3));
        vc.getBtneliminarcam().addActionListener(l -> LlenaCombo());
        vc.getBtnaceptar().addActionListener(l -> CrearEditarEliminarCamion());
        vc.getBtncancelar().addActionListener(l -> vc.getDlgCrudCam().setVisible(false));
        vc.getSpnpotencia().setEnabled(true);
        CargaCamiones();
        vc.getTxtbuscarcamion().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscaCamion();
            } 
        });
        vtc.getBtnaceptartip().addActionListener(l -> UsaDialogoTipos());
        vtc.getBtncanceltip().addActionListener(l -> vtc.getDlgCrudTip().dispose());
        
        //Validaciones
        vc.getTxtmodelo().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char key = evt.getKeyChar();
                if (Character.isDigit(key) || vc.getTxtmodelo().getText().length() >= 50) {
                    evt.consume();
                }
            }
        });
        
        //No funciona
        vc.getSpnpotencia().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                char key = e.getKeyChar();
                if (Character.isLetter(key) || Double.parseDouble(vc.getSpnpotencia().getValue().toString()) < 50
                        || Double.parseDouble(vc.getSpnpotencia().getValue().toString()) > 10000) {
                    e.consume();
                }
            }
        });  
    }
        
    //Carga datos desde la tabla
    private boolean MousePress(JTable me) {
        boolean press = false;
        try { 
            if (me.getSelectedRowCount() == 1) {
                vc.getTxtmatricula().setText(vc.getTblcamiones().getValueAt(vc.getTblcamiones().getSelectedRow(), 1).toString());
                vc.getTxtmodelo().setText(vc.getTblcamiones().getValueAt(vc.getTblcamiones().getSelectedRow(), 2).toString());
                String nombre = vc.getTblcamiones().getValueAt(vc.getTblcamiones().getSelectedRow(), 3).toString();
                if (tp.ExisteNombreTipo(nombre)) {
                    int id = tp.ObtieneIdConsulta(nombre);
                    vc.getCmbtipocam().setSelectedItem(new Tipo_camion(id));
                }
                vc.getSpnpotencia().setValue(Double.parseDouble(vc.getTblcamiones().getValueAt(vc.getTblcamiones().getSelectedRow(), 4).toString()));
                press = true;
            } else {
                JOptionPane.showMessageDialog(vc, "Seleccione una fila primero");
            }
        } catch(NullPointerException e) {
            System.out.println(e);
        }
        return press;
    }
    
    public void LimpiaValidacion() {
        vc.getLblvalidamat().setText(null);
        vc.getLblvalidamod().setText(null);
        vc.getLblvalidapot().setText(null);
    }
    
    //Método para abrir el JDialog del camión
    private void AbrirDialogo(int ce) {
        String title = null;
        boolean iscorrect = false;
        
        switch (ce) {

            case 1:
                title = "CREAR CAMIÓN";
                vc.getDlgCrudCam().setName("crear");
                vc.getDlgCrudCam().setTitle(title);
                ActivaCampos();
                vc.getTxtmatricula().setValue(null);
                vc.getTxtmodelo().setText(null);
                vc.getCmbtipocam().setSelectedIndex(0);
                vc.getSpnpotencia().setValue(50);
                LimpiaValidacion();
                iscorrect = true;
                break;
            case 2:
                title = "MODIFICAR CAMIÓN";
                vc.getDlgCrudCam().setName("editar");
                ActivaCampos();
                vc.getTxtmatricula().setEnabled(false);
                vc.getDlgCrudCam().setTitle(title);
                LimpiaValidacion();
                iscorrect = MousePress(vc.getTblcamiones());
                break;
            case 3:
                title = "ELIMINAR CAMIÓN";
                vc.getDlgCrudCam().setName("eliminar");
                vc.getDlgCrudCam().setTitle(title);
                vc.getTxtmatricula().setEnabled(false);
                vc.getTxtmodelo().setEnabled(false);
                vc.getCmbtipocam().setEnabled(false);
                vc.getSpnpotencia().setEnabled(false);
                vc.getBtnaddtipo().setEnabled(false);
                LimpiaValidacion();
                iscorrect = MousePress(vc.getTblcamiones());
                break;
            default:
                break;
        }
        if (iscorrect) {
            vc.getDlgCrudCam().setLocationRelativeTo(vc);
            vc.getDlgCrudCam().setVisible(true);
            vc.getDlgCrudCam().setSize(400, 300);
            vc.getDlgCrudCam().setTitle(title);
        }
    }
    
    private void ActivaCampos() {
        vc.getTxtmatricula().setEnabled(true);
        vc.getTxtmodelo().setEnabled(true);
        vc.getCmbtipocam().setEnabled(true);
        vc.getSpnpotencia().setEnabled(true);
        vc.getBtnaddtipo().setEnabled(true);
    }
    
    //Métodos para cargar datos
    private void CargaCamiones() {
        List<Camion> list = mc.ListarCamiones();
        List<Tipo_camion> listtip = tp.listarTipos();
        DefaultTableModel mtabla;
        mtabla = (DefaultTableModel) vc.getTblcamiones().getModel();
        mtabla.setNumRows(0);
        try {
            list.stream().forEach(ca -> {
                listtip.stream().forEach(tp -> {
                    if (ca.getId_tip() == tp.getId_tip()) {
                        String[] FilaNueva  = {String.valueOf(ca.getId_cam()), ca.getMatricula_cam(), ca.getModelo_cam(),
                        tp.getNombre_tipo(), String.valueOf(ca.getPotencia_cam())};
                        mtabla.addRow(FilaNueva);
                    }
                });
            });
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }

    //sub-diálogo del tipo
    private void AbreCrudTipo() {
        vtc.getDlgCrudTip().setVisible(true);
        vtc.getDlgCrudTip().setSize(370, 180);
        vtc.getDlgCrudTip().setLocationRelativeTo(vc);
    }
    
    //Llena el combobox con los datos del tipo de camión
    private void LlenaCombo() {
        vc.getCmbtipocam().removeAllItems();
        List<Tipo_camion> list = tp.listarTipos();
        try {
            list.stream().forEach(tpc -> {
                vc.getCmbtipocam().addItem(new Tipo_camion(tpc.getId_tip(), tpc.getNombre_tipo()));
            });
        } catch (Exception e) {
        }
    }
    
    //Solventa de momento la falta de un autoincrement---
    private int IncrementaID() {
        int id_cam = mc.Id_cam();
        if (id_cam >= 1) {
            id_cam++;
        } else {
        }
        return id_cam;
    }
    
    //Incrementa id del tipo en 1
    private int IncrementaIDtipo() {
        int id_tip = tp.ObtieneIdTipo();
        if (id_tip >= 1) {
            id_tip++;
        } else {
        }            
        return id_tip;
    }
    //Permite usar la creación del Diálogo de Tipos
    private void UsaDialogoTipos() {
        try {
            int id_tip = IncrementaIDtipo();
            String nombre = vtc.getTxtnombretip().getText().toUpperCase().trim();
            if (tp.ExisteNombreTipo(nombre)) {
                vtc.getLblvalidanom().setText("Ya Registrado");
            } else {
                if (nombre.isEmpty()) {
                    vtc.getLblvalidanom().setText("Campo Vacío");
                } else {
                    ModeloTipoCam tip = new ModeloTipoCam();
                    tip.setId_tip(id_tip);
                    tip.setNombre_tipo(nombre);

                    if (tip.InsertarTipoCamion() == null) {
                        vtc.getDlgCrudTip().setVisible(false);
                        LlenaCombo();
                        JOptionPane.showMessageDialog(vtc, "Tipo añadido correctamente");

                    } else {
                        JOptionPane.showMessageDialog(vtc, "No se pudo añadir el tipo");
                    }
                }
            }
        } catch(NullPointerException | NumberFormatException e) {
            System.out.println(e);
        }
    }
    
    //Busca camiones por matrícula / modelo
    private void BuscaCamion() {
        List<Camion> listaCam = mc.BuscarCamion(vc.getTxtbuscarcamion().getText());
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vc.getTblcamiones().getModel();
        mTabla.setNumRows(0);

        listaCam.stream().forEach(ca -> {
            String[] FilaNueva = {String.valueOf(ca.getId_cam()), ca.getMatricula_cam(), ca.getModelo_cam(), 
                String.valueOf(ca.getId_tip()), String.valueOf(ca.getPotencia_cam())};
            mTabla.addRow(FilaNueva);
        });
    }
    
    //Valida los datos ingresados
    private boolean ValidaDatos(String matricula, String modelo, double potencia) {
        boolean valido = false;
        if (matricula.equals("-") || matricula.length() < 6) {
            vc.getLblvalidamat().setText("Vacío");
            valido = true;
        } else {
            if (mc.ObtieneMatricula(matricula)) {
                vc.getLblvalidamat().setText("Ya Registrado");
                valido = true;
            } else {
                if (modelo.isEmpty()) {
                    vc.getLblvalidamat().setText(null);
                    vc.getLblvalidamod().setText("Vacío");
                    valido = true;
                } else if(potencia < 50  || potencia > 3000) {
                    vc.getLblvalidamod().setText(null);
                    vc.getLblvalidapot().setText("No Válido");
                    valido = true;
                }
            }
        }
        return valido;
    }
    
    //Crear, Editar y Eliminar camión
    private void CrearEditarEliminarCamion() {
        if (vc.getDlgCrudCam().getName().equals("crear")) {
            try {
                ActivaCampos();
                int id_cam = IncrementaID();
                String matricula = vc.getTxtmatricula().getText().trim();
                String modelo = vc.getTxtmodelo().getText().trim();
                int id_tip = vc.getCmbtipocam().getItemAt(vc.getCmbtipocam().getSelectedIndex()).getId_tip();
                double potencia = Double.parseDouble(vc.getSpnpotencia().getValue().toString().trim());
                if (!ValidaDatos(matricula, modelo, potencia)) {
                    ModeloCamion camion = new ModeloCamion();
                    camion.setId_cam(id_cam);
                    camion.setMatricula_cam(matricula);
                    camion.setModelo_cam(modelo);
                    camion.setId_tip(id_tip);
                    camion.setPotencia_cam(potencia);

                    if (camion.InsertaCamion() == null) {
                        LimpiaValidacion();
                        vc.getDlgCrudCam().setVisible(false);
                        JOptionPane.showMessageDialog(vc, "Camión creado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(vc, "No se pudo crear el camión");
                    }  
                }
            } catch(NullPointerException | NumberFormatException e) {
                System.out.println(e);
            }
        } else {
            if (vc.getDlgCrudCam().getName().equals("editar")) {
                try {
                    String matricula = vc.getTxtmatricula().getText().trim();
                    if (matricula.isEmpty()) {
                        vc.getLblvalidamat().setText("Vacío");
                    } else {
                        String modelo = vc.getTxtmodelo().getText().toUpperCase().trim();
                        int id_cam = mc.ObtieneID(matricula);
                        int id_tip = vc.getCmbtipocam().getItemAt(vc.getCmbtipocam().getSelectedIndex()).getId_tip();
                        Double potencia = Double.parseDouble(vc.getSpnpotencia().getValue().toString());
                        if (matricula.equalsIgnoreCase(vc.getTxtmatricula().getText().trim())) {
                            ModeloCamion camion = new ModeloCamion();
                            camion.setMatricula_cam(matricula);
                            camion.setModelo_cam(modelo);
                            camion.setId_tip(id_tip);
                            camion.setPotencia_cam(potencia);
                            if (camion.ModificarCamion(id_cam) == null) {
                                LimpiaValidacion();
                                vc.getDlgCrudCam().setVisible(false);
                                JOptionPane.showMessageDialog(vc, "Camión editado con éxito");
                            } else {
                                JOptionPane.showMessageDialog(vc, "No se pudo editar el camión");
                            }
                        } else {
                            if (mc.ObtieneMatricula(matricula)) {
                            } else {
                                ModeloCamion camion = new ModeloCamion();
                                camion.setMatricula_cam(matricula);
                                camion.setModelo_cam(modelo);
                                camion.setId_tip(id_tip);
                                camion.setPotencia_cam(potencia);
                                if (camion.ModificarCamion(id_cam) == null) {
                                    LimpiaValidacion();
                                    vc.getDlgCrudCam().setVisible(false);
                                    JOptionPane.showMessageDialog(vc, "Camión editado con éxito");
                                } else {
                                    JOptionPane.showMessageDialog(vc, "No se pudo editar el camión");
                                }
                            }
                        }
                    }
                } catch(NumberFormatException | NullPointerException e) {
                    System.out.println(e);
                }
            } else {
                if (vc.getDlgCrudCam().getName().equals("eliminar")) {
                    try {
                        String matricula = vc.getTxtmatricula().getText();
                        if (matricula.isEmpty()) {
                            JOptionPane.showMessageDialog(vc, "Por favor seleccione una fila de la tabla");
                        } else {
                            String modelo = vc.getTxtmodelo().getText();
                            int id_tip = vc.getCmbtipocam().getItemAt(vc.getCmbtipocam().getSelectedIndex()).getId_tip();
                            Double potencia = Double.parseDouble(vc.getSpnpotencia().getValue().toString());

                            ModeloCamion camion = new ModeloCamion();

                            camion.setMatricula_cam(modelo);
                            camion.setModelo_cam(modelo);
                            camion.setId_tip(id_tip);
                            camion.setPotencia_cam(potencia);
                            if (camion.EliminarCamion(matricula) == null) {
                                vc.getDlgCrudCam().setVisible(false);
                                JOptionPane.showMessageDialog(vc, "Camión eliminado con éxito");
                            } else {
                                JOptionPane.showMessageDialog(vc, "No se pudo eliminar el camión");
                            }
                        }
                    } catch(NumberFormatException | NullPointerException e) {
                        System.out.print(e);
                    }
                }
            }
        }
        CargaCamiones();
    }    
    
}
