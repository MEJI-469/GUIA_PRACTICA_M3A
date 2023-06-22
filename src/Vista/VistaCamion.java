/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Tipo_camion;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class VistaCamion extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaCamion
     */
    public VistaCamion() {
        initComponents();
    }

    public JButton getBtnactualizarcam() {
        return btnactualizarcam;
    }

    public void setBtnactualizarcam(JButton btnactualizarcam) {
        this.btnactualizarcam = btnactualizarcam;
    }

    public JButton getBtnlist() {
        return btnlist;
    }

    public void setBtnlist(JButton btnlist) {
        this.btnlist = btnlist;
    }

    public JButton getBtnaddtipo() {
        return btnaddtipo;
    }

    public void setBtnaddtipo(JButton btnaddtipo) {
        this.btnaddtipo = btnaddtipo;
    }

    public JButton getBtncrearcam() {
        return btncrearcam;
    }

    public void setBtncrearcam(JButton btncrearcam) {
        this.btncrearcam = btncrearcam;
    }

    public JButton getBtneliminarcam() {
        return btneliminarcam;
    }

    public void setBtneliminarcam(JButton btneliminarcam) {
        this.btneliminarcam = btneliminarcam;
    }

    public JComboBox<Tipo_camion> getCmbtipocam() {
        return cmbtipocam;
    }

    public void setCmbtipocam(JComboBox<Tipo_camion> cmbtipocam) {
        this.cmbtipocam = cmbtipocam;
    }

    public JDialog getDlgCrudCam() {
        return dlgCrudCam;
    }

    public JSpinner getSpnpotencia() {
        return spnpotencia;
    }

    public void setSpnpotencia(JSpinner spnpotencia) {
        this.spnpotencia = spnpotencia;
    }

    public void setDlgCrudCam(JDialog dlgCrudCam) {
        this.dlgCrudCam = dlgCrudCam;
    }

    public JButton getBtnaceptar() {
        return btnaceptar;
    }

    public void setBtnaceptar(JButton btnaceptar) {
        this.btnaceptar = btnaceptar;
    }

    public JButton getBtncancelar() {
        return btncancelar;
    }

    public void setBtncancelar(JButton btncancelar) {
        this.btncancelar = btncancelar;
    }

    public JTable getTblcamiones() {
        return tblcamiones;
    }

    public void setTblcamiones(JTable tblcamiones) {
        this.tblcamiones = tblcamiones;
    }

    public JTextField getTxtbuscarcamion() {
        return txtbuscarcamion;
    }

    public void setTxtbuscarcamion(JTextField txtbuscarcamion) {
        this.txtbuscarcamion = txtbuscarcamion;
    }

    public JFormattedTextField getTxtmatricula() {
        return txtmatricula;
    }

    public void setTxtmatricula(JFormattedTextField txtmatricula) {
        this.txtmatricula = txtmatricula;
    }

    public JTextField getTxtmodelo() {
        return txtmodelo;
    }

    public void setTxtmodelo(JTextField txtmodelo) {
        this.txtmodelo = txtmodelo;
    }

    public JLabel getLblvalidamat() {
        return lblvalidamat;
    }

    public void setLblvalidamat(JLabel lblvalidamat) {
        this.lblvalidamat = lblvalidamat;
    }

    public JLabel getLblvalidamod() {
        return lblvalidamod;
    }

    public void setLblvalidamod(JLabel lblvalidamod) {
        this.lblvalidamod = lblvalidamod;
    }

    public JLabel getLblvalidapot() {
        return lblvalidapot;
    }

    public void setLblvalidapot(JLabel lblvalidapot) {
        this.lblvalidapot = lblvalidapot;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgCrudCam = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnaceptar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        spnpotencia = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        btnaddtipo = new javax.swing.JButton();
        cmbtipocam = new javax.swing.JComboBox<>();
        txtmodelo = new javax.swing.JTextField();
        txtmatricula = new javax.swing.JFormattedTextField();
        lblvalidamat = new javax.swing.JLabel();
        lblvalidamod = new javax.swing.JLabel();
        lblvalidapot = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btncrearcam = new javax.swing.JButton();
        txtbuscarcamion = new javax.swing.JTextField();
        btnactualizarcam = new javax.swing.JButton();
        btneliminarcam = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcamiones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnlist = new javax.swing.JButton();

        jLabel3.setText("Matrícula:");

        jLabel4.setText("Modelo:");

        jLabel5.setText("Tipo:");

        jLabel6.setText("Potencia:");

        btnaceptar.setText("Aceptar");

        btncancelar.setText("Cancelar");

        spnpotencia.setModel(new javax.swing.SpinnerNumberModel(50, 50, 3000, 10));

        jLabel7.setText("CC");

        btnaddtipo.setText("Añadir");

        txtmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmodeloActionPerformed(evt);
            }
        });

        try {
            txtmatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblvalidamat.setForeground(new java.awt.Color(255, 51, 51));

        lblvalidamod.setForeground(new java.awt.Color(255, 51, 51));

        lblvalidapot.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnaceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(btncancelar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(cmbtipocam, 0, 110, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnaddtipo))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(spnpotencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7))
                            .addComponent(txtmatricula, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtmodelo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblvalidamat, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblvalidapot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(lblvalidamod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(lblvalidamat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(lblvalidamod, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbtipocam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddtipo)
                    .addComponent(jLabel5))
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnpotencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6))
                    .addComponent(lblvalidapot, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncancelar)
                    .addComponent(btnaceptar))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout dlgCrudCamLayout = new javax.swing.GroupLayout(dlgCrudCam.getContentPane());
        dlgCrudCam.getContentPane().setLayout(dlgCrudCamLayout);
        dlgCrudCamLayout.setHorizontalGroup(
            dlgCrudCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgCrudCamLayout.setVerticalGroup(
            dlgCrudCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Adminstración de camiones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btncrearcam.setText("Crear");

        btnactualizarcam.setText("Editar");

        btneliminarcam.setText("Eliminar");

        tblcamiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Matrícula", "Modelo", "Tipo", "Potencia (CC)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblcamiones);
        if (tblcamiones.getColumnModel().getColumnCount() > 0) {
            tblcamiones.getColumnModel().getColumn(0).setResizable(false);
            tblcamiones.getColumnModel().getColumn(1).setResizable(false);
            tblcamiones.getColumnModel().getColumn(2).setResizable(false);
            tblcamiones.getColumnModel().getColumn(3).setResizable(false);
            tblcamiones.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel2.setText("Buscar:");

        btnlist.setText("Actualizar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscarcamion, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnlist, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncrearcam, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnactualizarcam, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminarcam, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbuscarcamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btncrearcam)
                        .addComponent(btneliminarcam)
                        .addComponent(btnactualizarcam)
                        .addComponent(btnlist)))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmodeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmodeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmodeloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btnactualizarcam;
    private javax.swing.JButton btnaddtipo;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncrearcam;
    private javax.swing.JButton btneliminarcam;
    private javax.swing.JButton btnlist;
    private javax.swing.JComboBox<Tipo_camion> cmbtipocam;
    private javax.swing.JDialog dlgCrudCam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblvalidamat;
    private javax.swing.JLabel lblvalidamod;
    private javax.swing.JLabel lblvalidapot;
    private javax.swing.JSpinner spnpotencia;
    private javax.swing.JTable tblcamiones;
    private javax.swing.JTextField txtbuscarcamion;
    private javax.swing.JFormattedTextField txtmatricula;
    private javax.swing.JTextField txtmodelo;
    // End of variables declaration//GEN-END:variables
}
