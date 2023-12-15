/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pablogb.digestvuelos.componentes;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import pablogb.digestvuelos.dto.Aeropuerto;
import pablogb.digestvuelos.dto.VueloBase;
import pablogb.digestvuelos.gui.FrmVuelosBase;
import pablogb.digestvuelos.logica.LogicaNegocio;
import pablogb.digestvuelos.readers.AeropuertosCsvReader;
import pablogb.digestvuelos.readers.VuelosBaseCsvReader;

/**
 *
 * @author Pablo
 */
public class EditarVueloBase extends javax.swing.JPanel {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    private VueloBase vueloBase;

    public VueloBase getVueloBase() {
        return vueloBase;
    }

    public void setVueloBase(VueloBase vueloB) {
        this.vueloBase = vueloB;
        if (!vueloBase.getCodigoVuelo().isBlank()) {

            txtCodVuelo.setText(vueloBase.getCodigoVuelo());
            txtNumPlazas.setText(String.valueOf(vueloBase.getNumeroPlazas()));
            txtHoraSalida.setText(vueloBase.getHoraSalida().toString());
            txtHoraLlegada.setText(vueloBase.getHoraLlegada().toString());
            txtDiasOperacion.setText(vueloBase.getDiasOperacion());

            selecCbAeropuerto(cbAerOrigen, vueloBase.getAeropuertoOrigen());
            selecCbAeropuerto(cbAerDestino, vueloBase.getAeropuertoDestino());
        }
    }

    private void selecCbAeropuerto(JComboBox<Aeropuerto> comboBox, Aeropuerto aeropuerto) {
        if (aeropuerto != null) {
            String codigoIATA = aeropuerto.getCodigoIATA();
            for (int i = 0; i < comboBox.getItemCount(); i++) {
                Aeropuerto item = comboBox.getItemAt(i);
                if (item.getCodigoIATA().equals(codigoIATA)) {
                    comboBox.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    private static final EditarVueloBase INSTANCE = new EditarVueloBase();

    public static EditarVueloBase getInstance() {
        return INSTANCE;
    }

    private FrmVuelosBase frmVueloBase;

    public void setFrmVuelosBase(FrmVuelosBase frm) {
        this.frmVueloBase = frm;
    }

    /**
     * Creates new form DatosCompanya
     */
    public EditarVueloBase() {
        initComponents();
        cargarAeropuertosCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNumPlazas = new javax.swing.JLabel();
        lblHoraSalida = new javax.swing.JLabel();
        lblHoraLlegada = new javax.swing.JLabel();
        lblAerOrigen = new javax.swing.JLabel();
        lblAerDestino = new javax.swing.JLabel();
        txtNumPlazas = new javax.swing.JTextField();
        txtHoraSalida = new javax.swing.JTextField();
        cbAerOrigen = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        lblCodVuelo = new javax.swing.JLabel();
        txtCodVuelo = new javax.swing.JTextField();
        txtHoraLlegada = new javax.swing.JTextField();
        lblDiasOperacion = new javax.swing.JLabel();
        txtDiasOperacion = new javax.swing.JTextField();
        cbAerDestino = new javax.swing.JComboBox<>();

        lblNumPlazas.setText("Nº de Plazas");

        lblHoraSalida.setText("Hora de Salida (HH:mm)");

        lblHoraLlegada.setText("Hora de Llegada (HH:mm)");

        lblAerOrigen.setText("Cod Aeropuerto Origen");

        lblAerDestino.setText("Cod Aeropuerto Destino");

        txtNumPlazas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumPlazasActionPerformed(evt);
            }
        });

        cbAerOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAerOrigenActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lblCodVuelo.setText("Código de Vuelo");

        lblDiasOperacion.setText("Días de Operación");

        cbAerDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAerDestinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(408, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(392, 392, 392))
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCodVuelo)
                    .addComponent(lblAerOrigen)
                    .addComponent(lblHoraLlegada)
                    .addComponent(lblHoraSalida)
                    .addComponent(lblNumPlazas)
                    .addComponent(lblAerDestino)
                    .addComponent(lblDiasOperacion))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDiasOperacion)
                        .addComponent(cbAerOrigen, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodVuelo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtHoraLlegada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbAerDestino, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodVuelo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblNumPlazas)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNumPlazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHoraSalida))
                        .addGap(19, 19, 19)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoraLlegada))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiasOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiasOperacion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAerOrigen)
                    .addComponent(cbAerOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAerDestino)
                    .addComponent(cbAerDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnEditar)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumPlazasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumPlazasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumPlazasActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarDatosCsv();

    }//GEN-LAST:event_btnEditarActionPerformed

    private void cargarAeropuertosCombo() {
        AeropuertosCsvReader reader = new AeropuertosCsvReader();
        List<Aeropuerto> aeropuertos = reader.readAeropuertos();

        for (Aeropuerto aeropuerto : aeropuertos) {
            cbAerOrigen.addItem(aeropuerto);
            cbAerDestino.addItem(aeropuerto);
        }
    }

    private void cbAerOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAerOrigenActionPerformed
        if (cbAerOrigen.getSelectedItem() != null) {
            String selectedAerOrigen = cbAerOrigen.getSelectedItem().toString();
        }
    }//GEN-LAST:event_cbAerOrigenActionPerformed

    private void cbAerDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAerDestinoActionPerformed
        if (cbAerDestino.getSelectedItem() != null) {
            String selectedAerDestino = cbAerDestino.getSelectedItem().toString();
        }
    }//GEN-LAST:event_cbAerDestinoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<Aeropuerto> cbAerDestino;
    private javax.swing.JComboBox<Aeropuerto> cbAerOrigen;
    private javax.swing.JLabel lblAerDestino;
    private javax.swing.JLabel lblAerOrigen;
    private javax.swing.JLabel lblCodVuelo;
    private javax.swing.JLabel lblDiasOperacion;
    private javax.swing.JLabel lblHoraLlegada;
    private javax.swing.JLabel lblHoraSalida;
    private javax.swing.JLabel lblNumPlazas;
    private javax.swing.JTextField txtCodVuelo;
    private javax.swing.JTextField txtDiasOperacion;
    private javax.swing.JTextField txtHoraLlegada;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtNumPlazas;
    // End of variables declaration//GEN-END:variables

    private void editarDatosCsv() {
        VuelosBaseCsvReader csvReader = new VuelosBaseCsvReader();
        List<VueloBase> todosLosVuelos = csvReader.readVuelosBase();

        for (int i = 0; i < todosLosVuelos.size(); i++) {
            if (todosLosVuelos.get(i).getCodigoVuelo().equals(this.vueloBase.getCodigoVuelo())) {

                VueloBase compActualizada = todosLosVuelos.get(i);
                compActualizada.setCodigoVuelo(txtCodVuelo.getText());

                int numeroPlazas = Integer.parseInt(txtNumPlazas.getText());
                compActualizada.setNumeroPlazas(numeroPlazas);

                LocalTime horaSalida = LocalTime.parse(txtHoraSalida.getText(), formatter);
                compActualizada.setHoraSalida(horaSalida);

                LocalTime horaLlegada = LocalTime.parse(txtHoraLlegada.getText(), formatter);
                compActualizada.setHoraLlegada(horaLlegada);

                Aeropuerto aeropuertoOrigen = (Aeropuerto) cbAerOrigen.getSelectedItem();
                compActualizada.setAeropuertoOrigen(aeropuertoOrigen);
                
                Aeropuerto aeropuertoDestino = (Aeropuerto) cbAerDestino.getSelectedItem();
                compActualizada.setAeropuertoDestino(aeropuertoDestino);

                compActualizada.setDiasOperacion(txtDiasOperacion.getText());

                todosLosVuelos.set(i, compActualizada);
                break;
            }
        }

        LogicaNegocio.escribirVuelosBaseCsv(todosLosVuelos);

        if (frmVueloBase != null) {
            frmVueloBase.updateTable();
        }

        SwingUtilities.getWindowAncestor(this).dispose();
    }
}
