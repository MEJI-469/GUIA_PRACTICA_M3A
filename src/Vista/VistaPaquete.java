/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class VistaPaquete extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaPaquete
     */
    public VistaPaquete() {
        initComponents();
    }

    public JTable getTblCliente() {
        return tblCliente;
    }

    public void setTblCliente(JTable tblCliente) {
        this.tblCliente = tblCliente;
    }

    public JButton getBtnBuscarCliente() {
        return btnBuscarCliente;
    }

    public void setBtnBuscarCliente(JButton btnBuscarCliente) {
        this.btnBuscarCliente = btnBuscarCliente;
    }

    public JButton getBtnSalirCliente() {
        return btnSalirCliente;
    }

    public void setBtnSalirCliente(JButton btnSalirCliente) {
        this.btnSalirCliente = btnSalirCliente;
    }

    public JTextField getTxtBuscarCliente() {
        return txtBuscarCliente;
    }

    public void setTxtBuscarCliente(JTextField txtBuscarCliente) {
        this.txtBuscarCliente = txtBuscarCliente;
    }

    public JDialog getDigSeleccionarCliente() {
        return DigSeleccionarCliente;
    }

    public void setDigSeleccionarCliente(JDialog DigSeleccionarCliente) {
        this.DigSeleccionarCliente = DigSeleccionarCliente;
    }

    public JButton getBtnBuscarEnvio() {
        return btnBuscarEnvio;
    }

    public void setBtnBuscarEnvio(JButton btnBuscarEnvio) {
        this.btnBuscarEnvio = btnBuscarEnvio;
    }

    public JButton getBtnSalirEnvio() {
        return btnSalirEnvio;
    }

    public void setBtnSalirEnvio(JButton btnSalirEnvio) {
        this.btnSalirEnvio = btnSalirEnvio;
    }

    public JTable getTblEnvio() {
        return tblEnvio;
    }

    public void setTblEnvio(JTable tblEnvio) {
        this.tblEnvio = tblEnvio;
    }

    public JTextField getTxtBuscarEnvio() {
        return txtBuscarEnvio;
    }

    public void setTxtBuscarEnvio(JTextField txtBuscarEnvio) {
        this.txtBuscarEnvio = txtBuscarEnvio;
    }

    public JDialog getDigSeleccionarEnvio() {
        return DigSeleccionarEnvio;
    }

    public void setDigSeleccionarEnvio(JDialog DigSeleccionarEnvio) {
        this.DigSeleccionarEnvio = DigSeleccionarEnvio;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JTextField getTxtIdCliente() {
        return txtIdCliente;
    }

    public void setTxtIdCliente(JTextField txtIdCliente) {
        this.txtIdCliente = txtIdCliente;
    }

    public JButton getBtnElegirCliente() {
        return btnElegirCliente;
    }

    public void setBtnElegirCliente(JButton btnElegirCliente) {
        this.btnElegirCliente = btnElegirCliente;
    }

    public JButton getBtnElegirEnvio() {
        return btnElegirEnvio;
    }

    public void setBtnElegirEnvio(JButton btnElegirEnvio) {
        this.btnElegirEnvio = btnElegirEnvio;
    }

    public JTextField getTxtIdEnvio() {
        return txtIdEnvio;
    }

    public void setTxtIdEnvio(JTextField txtIdEnvio) {
        this.txtIdEnvio = txtIdEnvio;
    }

    public JDialog getDigPaquete() {
        return DigPaquete;
    }

    public void setDigPaquete(JDialog DigPaquete) {
        this.DigPaquete = DigPaquete;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnCrear() {
        return btnCrear;
    }

    public void setBtnCrear(JButton btnCrear) {
        this.btnCrear = btnCrear;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnImprimir() {
        return btnImprimir;
    }

    public void setBtnImprimir(JButton btnImprimir) {
        this.btnImprimir = btnImprimir;
    }

    public JTable getTblPaquete() {
        return tblPaquete;
    }

    public void setTblPaquete(JTable tblPaquete) {
        this.tblPaquete = tblPaquete;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextField txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DigPaquete = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtIdEnvio = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnElegirEnvio = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        btnElegirCliente = new javax.swing.JButton();
        DigSeleccionarEnvio = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarEnvio = new javax.swing.JTextField();
        btnBuscarEnvio = new javax.swing.JButton();
        btnSalirEnvio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEnvio = new javax.swing.JTable();
        DigSeleccionarCliente = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscarCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        btnSalirCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tblPaquete = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        jLabel3.setText("PAQUETE");

        jLabel4.setText("CODIGO:");

        jLabel5.setText("DESCRIPCION:");

        jLabel8.setText("ID ENVIO:");

        btnAceptar.setText("ACEPTAR");

        btnCancelar.setText("CANCELAR");

        btnElegirEnvio.setText("ELEGIR");

        jLabel9.setText("ID CLIENTE:");

        btnElegirCliente.setText("ELEGIR");

        javax.swing.GroupLayout DigPaqueteLayout = new javax.swing.GroupLayout(DigPaquete.getContentPane());
        DigPaquete.getContentPane().setLayout(DigPaqueteLayout);
        DigPaqueteLayout.setHorizontalGroup(
            DigPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DigPaqueteLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel3)
                .addContainerGap(242, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DigPaqueteLayout.createSequentialGroup()
                .addGroup(DigPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DigPaqueteLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(DigPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DigPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(txtCodigo)
                            .addComponent(txtIdEnvio)
                            .addComponent(txtIdCliente))
                        .addGap(18, 18, 18)
                        .addGroup(DigPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnElegirCliente)
                            .addComponent(btnElegirEnvio))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(DigPaqueteLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(btnCancelar)))
                .addGap(128, 128, 128))
        );
        DigPaqueteLayout.setVerticalGroup(
            DigPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DigPaqueteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(94, 94, 94)
                .addGroup(DigPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DigPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DigPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIdEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElegirEnvio))
                .addGap(18, 18, 18)
                .addGroup(DigPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElegirCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(DigPaqueteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(74, 74, 74))
        );

        jLabel6.setText("Buscar:");

        btnBuscarEnvio.setText("BUSCAR");

        btnSalirEnvio.setText("SALIR");

        tblEnvio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_cam_ca", "id_cam", "id_ca", "fecha_conduccion"
            }
        ));
        tblEnvio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEnvioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEnvio);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addComponent(txtBuscarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnBuscarEnvio)
                .addGap(48, 48, 48)
                .addComponent(btnSalirEnvio)
                .addContainerGap(221, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscarEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEnvio)
                    .addComponent(btnSalirEnvio))
                .addContainerGap(266, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout DigSeleccionarEnvioLayout = new javax.swing.GroupLayout(DigSeleccionarEnvio.getContentPane());
        DigSeleccionarEnvio.getContentPane().setLayout(DigSeleccionarEnvioLayout);
        DigSeleccionarEnvioLayout.setHorizontalGroup(
            DigSeleccionarEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DigSeleccionarEnvioLayout.setVerticalGroup(
            DigSeleccionarEnvioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel7.setText("Buscar:");

        btnBuscarCliente.setText("BUSCAR");

        btnSalirCliente.setText("SALIR");

        tblCliente = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "NOMBRE", "APELLIDO", "SALARIO", "TELEFONO", "DIRECCION", "POBLACION"
            }
        ));
        tblCliente.getTableHeader().setReorderingAllowed(false);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCliente);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(29, 29, 29)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnBuscarCliente)
                        .addGap(48, 48, 48)
                        .addComponent(btnSalirCliente)
                        .addGap(0, 451, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente)
                    .addComponent(btnSalirCliente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DigSeleccionarClienteLayout = new javax.swing.GroupLayout(DigSeleccionarCliente.getContentPane());
        DigSeleccionarCliente.getContentPane().setLayout(DigSeleccionarClienteLayout);
        DigSeleccionarClienteLayout.setHorizontalGroup(
            DigSeleccionarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DigSeleccionarClienteLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DigSeleccionarClienteLayout.setVerticalGroup(
            DigSeleccionarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DigSeleccionarClienteLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setClosable(true);

        jLabel1.setText("Buscar:");

        btnActualizar.setText("Actualizar");

        btnCrear.setText("Crear");

        btnEditar.setText("Editar");

        btnEliminar.setText("Eliminar");

        btnImprimir.setText("Imprimir");

        tblPaquete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "DESCRIPCION", "ID ENVIO", "ID CLIENTE"
            }
        ));
        jScrollPane.setViewportView(tblPaquete);

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TRANSPORTES S.A");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrear)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnImprimir)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar)
                    .addComponent(btnCrear)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnImprimir)
                    .addComponent(btnBuscar))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tblEnvioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEnvioMouseClicked
        txtBuscar.setText(null);
    }//GEN-LAST:event_tblEnvioMouseClicked

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        
    }//GEN-LAST:event_tblClienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DigPaquete;
    private javax.swing.JDialog DigSeleccionarCliente;
    private javax.swing.JDialog DigSeleccionarEnvio;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarEnvio;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnElegirCliente;
    private javax.swing.JButton btnElegirEnvio;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnSalirCliente;
    private javax.swing.JButton btnSalirEnvio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTable tblEnvio;
    private javax.swing.JTable tblPaquete;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtBuscarEnvio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdEnvio;
    // End of variables declaration//GEN-END:variables
}
