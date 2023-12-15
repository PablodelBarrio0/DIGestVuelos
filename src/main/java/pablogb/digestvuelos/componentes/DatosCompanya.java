/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pablogb.digestvuelos.componentes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.swing.SwingUtilities;
import pablogb.digestvuelos.logica.LogicaNegocio;
import pablogb.digestvuelos.dto.Companya;
import pablogb.digestvuelos.dto.Municipio;
import pablogb.digestvuelos.gui.FrmCompanyas;
import pablogb.digestvuelos.readers.MunicipiosCsvReader;

/**
 *
 * @author Pablo
 */
public class DatosCompanya extends javax.swing.JPanel {

    private Companya companya;

    public Companya getCompanya() {
        return companya;
    }

    private boolean habilitado;

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public void setCompanya(Companya comp) {
        this.companya = comp;
        if (!companya.getCodigo().isBlank()) {
            txtPrefijo.setText(comp.getPrefijo());
            txtCodigo.setText(comp.getCodigo());
            txtNombre.setText(comp.getNombre());
            txtDireccion.setText(comp.getDireccion());
            txtTlfInfoAeropuerto.setText(comp.getTelefonoInformacion());
            txtTlfInfoPasajero.setText(comp.getTelefonoPasajeros());
        }
    }

    private static final DatosCompanya INSTANCE = new DatosCompanya();

    public static DatosCompanya getInstance() {
        return INSTANCE;
    }

    private FrmCompanyas frmCompanyas;

    public void setFrmCompanyas(FrmCompanyas frm) {
        this.frmCompanyas = frm;
    }

    /**
     * Creates new form DatosCompanya
     */
    public DatosCompanya() {
        initComponents();
        cargarMunicipiosCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lbldDireccion = new javax.swing.JLabel();
        lblMunicipio = new javax.swing.JLabel();
        lblTlfInfoPasajero = new javax.swing.JLabel();
        lblTlfInfoAeropuerto = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTlfInfoPasajero = new javax.swing.JTextField();
        txtTlfInfoAeropuerto = new javax.swing.JTextField();
        cbMunicipios = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDireccion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPrefijo = new javax.swing.JTextField();

        lblCodigo.setText("Código:");

        lblNombre.setText("Nombre:");

        lbldDireccion.setText("Dirección:");

        lblMunicipio.setText("Municipio:");

        lblTlfInfoPasajero.setText("Teléfono de información al pasajero:");

        lblTlfInfoAeropuerto.setText("Teléfono de información al aeropuerto:");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        cbMunicipios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMunicipiosActionPerformed(evt);
            }
        });

        txtDireccion.setColumns(20);
        txtDireccion.setRows(5);
        jScrollPane1.setViewportView(txtDireccion);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setText("Prefijo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(392, 392, 392))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblMunicipio)
                    .addComponent(lbldDireccion)
                    .addComponent(lblNombre)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTlfInfoAeropuerto)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblTlfInfoPasajero, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(txtNombre)
                    .addComponent(txtTlfInfoPasajero)
                    .addComponent(cbMunicipios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTlfInfoAeropuerto)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPrefijo))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPrefijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblCodigo))
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldDireccion)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMunicipio)
                    .addComponent(cbMunicipios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTlfInfoPasajero)
                    .addComponent(txtTlfInfoPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTlfInfoAeropuerto)
                    .addComponent(txtTlfInfoAeropuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarDatosCsv();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cargarMunicipiosCombo() {
        MunicipiosCsvReader reader = new MunicipiosCsvReader();
        List<Municipio> municipios = reader.readMunicipios();

        cbMunicipios.removeAllItems();

        for (Municipio municipio : municipios) {
            cbMunicipios.addItem(municipio); 
        }
    }

    private void cbMunicipiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMunicipiosActionPerformed
        if (cbMunicipios.getSelectedItem() != null) {
            String selectedMunicipio = cbMunicipios.getSelectedItem().toString();
        }
    }//GEN-LAST:event_cbMunicipiosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Municipio> cbMunicipios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblMunicipio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTlfInfoAeropuerto;
    private javax.swing.JLabel lblTlfInfoPasajero;
    private javax.swing.JLabel lbldDireccion;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrefijo;
    private javax.swing.JTextField txtTlfInfoAeropuerto;
    private javax.swing.JTextField txtTlfInfoPasajero;
    // End of variables declaration//GEN-END:variables
    private void fillMunicipios() {
        LogicaNegocio.getAllMunicipios().forEach(m -> cbMunicipios.addItem(m));
    }

    private void guardarDatosCsv() {
        String prefijo = txtPrefijo.getText();
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String direccion = txtDireccion.getText();
        Municipio municipioSeleccionado = (Municipio) cbMunicipios.getSelectedItem();
        String municipio = municipioSeleccionado != null ? municipioSeleccionado.codigo() : "";
        String tlfInfoPasajero = txtTlfInfoPasajero.getText();
        String tlfInfoAeropuerto = txtTlfInfoAeropuerto.getText();

        List<String> datos = Arrays.asList(prefijo, codigo, nombre, direccion, municipio, tlfInfoPasajero, tlfInfoAeropuerto);
        String csvData = String.join(";", datos);

        try (FileWriter writer = new FileWriter("./src/main/resources/Companyas.csv", true)) {
            writer.append(csvData);
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (frmCompanyas != null) {
            frmCompanyas.updateTable();
        }

        SwingUtilities.getWindowAncestor(this).dispose();
    }
}
