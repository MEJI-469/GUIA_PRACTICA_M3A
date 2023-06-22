package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.KeyAdapter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorTipoCam {
    
    private final VistaTipoCamion vtp;
    private final ModeloTipoCam mtp;

    public ControladorTipoCam(VistaTipoCamion vtp, ModeloTipoCam mtp) {
        this.vtp = vtp;
        this.mtp = mtp;
        vtp.setVisible(true);
    }
    
    public void IniciaControl() {
        CargaTipos();
        vtp.getBtnlistartip().addActionListener(l -> CargaTipos());
        vtp.getBtncreartip().addActionListener(l -> AbrirDialogo(1));
        vtp.getBtneditartip().addActionListener(l -> AbrirDialogo(2));
        vtp.getBtneditartip().addActionListener(l -> mtp.ObtieneIdConsulta(vtp.getTxtnombretip().getText()));
        vtp.getBtneliminartip().addActionListener(l -> AbrirDialogo(3));
        vtp.getBtnaceptartip().addActionListener(l -> CrearEditarEliminarTipoCam());
        vtp.getBtncanceltip().addActionListener(l -> vtp.getDlgCrudTip().setVisible(false));
        vtp.getTxtbuscartip().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BuscaTipoCamion();
            }
        });
        vtp.getTxtnombretip().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValidaCampotxt(evt);
            }
        });
    }
    

    
    public void ValidaCampotxt(java.awt.event.KeyEvent e) {
        char key = e.getKeyChar();
        if (Character.isDigit(key) || vtp.getTxtnombretip().getText().length() >= 50) {
            e.consume();
        }
    }
    
    private boolean MousePress(JTable me) {
        boolean press = false;
        try { 
            if (me.getSelectedRowCount() == 1) {
                vtp.getTxtnombretip().setText(vtp.getTbltipocam().getValueAt(vtp.getTbltipocam().getSelectedRow(), 1).toString());
                press = true;
            } else {
                JOptionPane.showMessageDialog(vtp, "Seleccione una fila primero");
            }
        } catch(NullPointerException e) {
            System.out.println(e);
        }
        return press;
    }
        
    public void AbrirDialogo(int ce) {
        String title = null;
        boolean iscorrect = false;
        switch(ce) {
            case 1:
                title = "CREAR TIPO CAMIÓN";
                vtp.getDlgCrudTip().setName("crear");
                vtp.getDlgCrudTip().setTitle(title);
                vtp.getTxtnombretip().setText(null);
                vtp.getTxtnombretip().setEnabled(true);
                vtp.getLblvalidanom().setText(null);
                iscorrect = true;
                break;
            case 2:
                title = "MODIFICAR";
                vtp.getDlgCrudTip().setName("editar");
                vtp.getDlgCrudTip().setTitle(title);
                vtp.getTxtnombretip().setEnabled(false);
                vtp.getLblvalidanom().setText(null);
                iscorrect = MousePress(vtp.getTbltipocam());
                break;
            case 3:
                title = "ELIMINAR";
                vtp.getDlgCrudTip().setName("eliminar");
                vtp.getDlgCrudTip().setTitle(title);
                vtp.getTxtnombretip().setEnabled(false);
                vtp.getLblvalidanom().setText(null);
                iscorrect = MousePress(vtp.getTbltipocam());
                break;
            default:
                break;
        }
        if (iscorrect) {
            vtp.getDlgCrudTip().setLocationRelativeTo(vtp);
            vtp.getDlgCrudTip().setTitle(title);
            vtp.getDlgCrudTip().setSize(400, 200);
            vtp.getDlgCrudTip().setVisible(true);
        }
    }
    
    public void CargaTipos() {
        List<Tipo_camion> listatip = mtp.listarTipos();
        DefaultTableModel mtable;
        mtable = (DefaultTableModel) vtp.getTbltipocam().getModel();
        mtable.setNumRows(0);
        try {
            listatip.stream().forEach(tip -> {
            String [] FilaNueva = {String.valueOf(tip.getId_tip()), tip.getNombre_tipo()};
            mtable.addRow(FilaNueva);
            });
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    
    private int IncrementaID() {
        int id_cam = mtp.ObtieneIdTipo();
        id_cam++;
        return id_cam;
    }
    
    public void BuscaTipoCamion() {
        List<Tipo_camion> listaCam = mtp.BuscarTipoCamion(vtp.getTxtbuscartip().getText());
        DefaultTableModel mTabla;
        mTabla = (DefaultTableModel) vtp.getTbltipocam().getModel();
        mTabla.setNumRows(0);

        listaCam.stream().forEach(tip -> {
            String[] FilaNueva = {String.valueOf(tip.getId_tip()), tip.getNombre_tipo()};
            mTabla.addRow(FilaNueva);
        });
    }
    
    
    private boolean validaCampo(String nombre){
        return nombre.isEmpty();
    }
    
    private void CrearEditarEliminarTipoCam() {
        if (vtp.getDlgCrudTip().getName().equals("crear")) {
            try {
                int id_tip = IncrementaID();
                String nombre = vtp.getTxtnombretip().getText().toUpperCase().trim();
                if (mtp.ExisteNombreTipo(nombre)) {
                    vtp.getLblvalidanom().setText("Ya Registrado");
                } else {
                    if (validaCampo(nombre)) {
                        vtp.getLblvalidanom().setText("Vacío");
                    } else {
                        ModeloTipoCam tip = new ModeloTipoCam();
                        tip.setId_tip(id_tip);
                        tip.setNombre_tipo(nombre);
                        vtp.getLblvalidanom().setText(null);
                        if (tip.InsertarTipoCamion() == null) {
                            vtp.getDlgCrudTip().setVisible(false);
                            JOptionPane.showMessageDialog(vtp, "Tipo creado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(vtp, "No se pudo crear el tipo");
                        }
                    }
                }
            } catch(NullPointerException | NumberFormatException e) {
                System.out.println(e);
            }
        } else {
            if (vtp.getDlgCrudTip().getName().equals("editar")) {
                try {
                    String nombre = vtp.getTxtnombretip().getText().toUpperCase().trim();
                    int id_tip = mtp.ObtieneIdConsulta(nombre);
                    if (nombre.isEmpty()) {
                            JOptionPane.showMessageDialog(vtp, "Por favor seleccione una fila de la tabla");
                    } else {
                        vtp.getBtnaceptartip().setEnabled(true);
                        if (mtp.ExisteNombreTipo(nombre)) {
                            vtp.getLblvalidanom().setText("Ya Registrado");
                        } else {
                            ModeloTipoCam tip = new ModeloTipoCam();
                            tip.setId_tip(id_tip);
                            tip.setNombre_tipo(nombre);
                            vtp.getLblvalidanom().setText(null);
                            if (tip.ModficarTipoCamion(id_tip) == null) {
                                vtp.getDlgCrudTip().setVisible(false);
                                JOptionPane.showMessageDialog(vtp, "Tipo editado con éxito");
                            } else {
                                JOptionPane.showMessageDialog(vtp, "No se pudo editar el tipo");
                            }
                        }
                    }
                } catch(NumberFormatException | NullPointerException e) {
                    System.out.println(e);
                }
            } else {
                if (vtp.getDlgCrudTip().getName().equals("eliminar")) {
                    try {
                        String nombre = vtp.getTxtnombretip().getText().toUpperCase();
                        int id = mtp.ObtieneIdConsulta(nombre);
                        if (nombre.isEmpty()) {
                            JOptionPane.showMessageDialog(vtp, "Por favor seleccione una fila de la tabla");
                        } else {
                            if (mtp.ExisteAsociacion(nombre)) {
                                vtp.getLblvalidanom().setText("Registro asociado");
                                JOptionPane.showMessageDialog(vtp, "Imposible eliminar, está asociado a uno o más registros");
                            } else {
                                vtp.getLblvalidanom().setText(null);
                                ModeloTipoCam tip = new ModeloTipoCam();
                                tip.setNombre_tipo(vtp.getTxtnombretip().getText());
                                if (tip.EliminarTipoCamion(id) == null) {
                                    vtp.getDlgCrudTip().setVisible(false);
                                    JOptionPane.showMessageDialog(vtp, "Tipo eliminado con éxito");
                                } else {
                                    JOptionPane.showMessageDialog(vtp, "No se pudo eliminar el tipo");
                                }
                            }
                        }
                    } catch(NumberFormatException | NullPointerException e) {
                        System.out.print(e);
                    }
                }
            }
        }
        CargaTipos();
    } 
}
