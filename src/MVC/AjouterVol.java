/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import NoyauFonctionnel.NoyauFonctionnel;
import NoyauFonctionnel.VueGestionVol;
import javax.swing.*;
import projetjava2016.*;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Saitama
 */
public class AjouterVol extends javax.swing.JPanel {

    private NoyauFonctionnel nf;
    private TableVol tableVol;
    private comboAero cbAero;
    private boolean tarifCorrect;
    private TarifDocumentListener tarifListener;
    //private dateADocumentListener tarifListener;
    //private heureDDocumentListener libVolListener;
    //private heureADocumentListener tarifListener;

    /**
     * Creates new form AjouterVol
     */
    public AjouterVol() {
        initComponents();
        chargerNF(new NoyauFonctionnel());
    }

    public NoyauFonctionnel getNf() {
        return nf;
    }

    public void setNf(NoyauFonctionnel nf) {
        this.nf = nf;
    }

    public TableVol getTableVol() {
        return tableVol;
    }

    public void setTableVol(TableVol tableVol) {
        this.tableVol = tableVol;
    }

    //Chargement du noyau
    public void chargerNF(NoyauFonctionnel nf) {
        this.nf = nf;
        txt_Tarif.setText(" ");

        tableVol = new TableVol(nf);
        nf.addView(tableVol);
        tableVol.notifyFromModel(nf);
        tbl_Vol.setModel(tableVol);

        cbAero = new comboAero(nf);
        nf.addView(cbAero);
        cbAero.notifyFromModel(nf);
        cb_AeroA.setModel(cbAero);

        cbAero = new comboAero(nf);
        nf.addView(cbAero);
        cbAero.notifyFromModel(nf);
        cb_AeroD.setModel(cbAero);

        cb_AeroA.setSelectedIndex(0);
        cb_AeroD.setSelectedIndex(0);

        tarifListener = new TarifDocumentListener();
        txt_Tarif.getDocument().addDocumentListener(tarifListener);
        tarifListener.verifierTarif(txt_Tarif.getText());

        nf.addView(new VueGestionVol() {
            @Override
            public void notifyFromModel(NoyauFonctionnel model) {
                tarifListener.verifierTarif(txt_Tarif.getText());
            }
        });

    }

    private void setTarifCorrect(boolean tCorrect) {
        this.tarifCorrect = tCorrect;
        err_tarif.setVisible(!tCorrect);
        verifyAjouterEnable();
    }

    private void verifyAjouterEnable() {
        btn_AjouterVol.setEnabled(tarifCorrect);
    }


    private class TarifDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            try {
                String text = e.getDocument().getText(0, e.getDocument().getLength());
                verifierTarif(text);
            } catch (BadLocationException ex) {

            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            try {
                String text = e.getDocument().getText(0, e.getDocument().getLength());
                verifierTarif(text);
            } catch (BadLocationException ex) {

            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            try {
                String text = e.getDocument().getText(0, e.getDocument().getLength());
                verifierTarif(text);
            } catch (BadLocationException ex) {

            }
        }

        public void verifierTarif(String txt_tarif) {
            try {
                float value = Float.parseFloat(txt_tarif);
                //Le nombre est correct
                setTarifCorrect(nf.verifTarif(value));
            } catch (NumberFormatException numberFormatException) {
                //Le nombre n'est pas correct
                setTarifCorrect(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_LibVol = new javax.swing.JLabel();
        lbl_DateD = new javax.swing.JLabel();
        lbl_DateA = new javax.swing.JLabel();
        lbl_HD = new javax.swing.JLabel();
        lbl_HA = new javax.swing.JLabel();
        lbl_Tarif = new javax.swing.JLabel();
        lbl_AeroD = new javax.swing.JLabel();
        lbl_AeroA = new javax.swing.JLabel();
        txt_LibVol = new javax.swing.JTextField();
        txt_Tarif = new javax.swing.JTextField();
        cb_AeroD = new javax.swing.JComboBox<>();
        cb_AeroA = new javax.swing.JComboBox<>();
        txtf_DateD = new javax.swing.JFormattedTextField();
        txtf_DateA = new javax.swing.JFormattedTextField();
        btn_AjouterVol = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Vol = new javax.swing.JTable();
        err_tarif = new javax.swing.JLabel();
        spin_hd = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        spin_md = new javax.swing.JSpinner();
        spin_ha = new javax.swing.JSpinner();
        spin_ma = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        err_HD = new javax.swing.JLabel();
        err_HA = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(900, 450));

        lbl_LibVol.setText("Libelle du vol :");

        lbl_DateD.setText("Date de depart :");

        lbl_DateA.setText("Date d'arrivee :");

        lbl_HD.setText("Heure de depart :");

        lbl_HA.setText("Heure d'arrivee :");

        lbl_Tarif.setText("Tarif :");

        lbl_AeroD.setText("Aeroport de depart :");

        lbl_AeroA.setText("Aeroport d'arrivee :");

        cb_AeroD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_AeroD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_AeroDActionPerformed(evt);
            }
        });

        cb_AeroA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtf_DateD.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        txtf_DateA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        btn_AjouterVol.setText("Ajouter");
        btn_AjouterVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AjouterVolActionPerformed(evt);
            }
        });

        tbl_Vol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_Vol);

        err_tarif.setForeground(new java.awt.Color(255, 153, 0));
        err_tarif.setText("Le tarif doit etre superieure a 0");

        spin_hd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText(":");

        jLabel2.setText(":");

        err_HD.setForeground(new java.awt.Color(255, 153, 0));
        err_HD.setText("L'heure de depart est incorrect");

        err_HA.setForeground(new java.awt.Color(255, 153, 0));
        err_HA.setText("L'heure d'arrivee est incorrect");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_AjouterVol))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_AeroA)
                                    .addComponent(lbl_AeroD))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb_AeroA, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(cb_AeroD, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_LibVol)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_LibVol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_DateA)
                                            .addComponent(lbl_DateD))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtf_DateD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtf_DateA, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_Tarif)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(err_tarif)
                                            .addComponent(txt_Tarif, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(err_HD)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_HD)
                                    .addComponent(lbl_HA))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(spin_ha, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spin_hd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spin_md, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spin_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(err_HA)))
                        .addGap(34, 34, 34)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_LibVol)
                    .addComponent(lbl_Tarif)
                    .addComponent(txt_LibVol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Tarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(err_tarif)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_AeroD)
                    .addComponent(lbl_HD)
                    .addComponent(lbl_DateD)
                    .addComponent(cb_AeroD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtf_DateD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(spin_md, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spin_hd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(err_HD)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_AeroA)
                    .addComponent(lbl_DateA)
                    .addComponent(cb_AeroA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtf_DateA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_HA)
                    .addComponent(spin_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(spin_ha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(err_HA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btn_AjouterVol)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AjouterVolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AjouterVolActionPerformed

        float tarif = Float.valueOf(txt_Tarif.getText());
        String heureD = spin_hd.getValue() + ":" + spin_md.getValue();
        String heureA = spin_ha.getValue() + ":" + spin_ma.getValue();
        nf.ajouterVol(txt_LibVol.getText(), txtf_DateD.getText(), txtf_DateA.getText(), heureD, heureA, tarif, String.valueOf(cb_AeroD.getSelectedItem()), String.valueOf(cb_AeroA.getSelectedItem()));
    }//GEN-LAST:event_btn_AjouterVolActionPerformed

    private void cb_AeroDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_AeroDActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cb_AeroDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AjouterVol;
    private javax.swing.JComboBox<String> cb_AeroA;
    private javax.swing.JComboBox<String> cb_AeroD;
    private javax.swing.JLabel err_HA;
    private javax.swing.JLabel err_HD;
    private javax.swing.JLabel err_tarif;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_AeroA;
    private javax.swing.JLabel lbl_AeroD;
    private javax.swing.JLabel lbl_DateA;
    private javax.swing.JLabel lbl_DateD;
    private javax.swing.JLabel lbl_HA;
    private javax.swing.JLabel lbl_HD;
    private javax.swing.JLabel lbl_LibVol;
    private javax.swing.JLabel lbl_Tarif;
    private javax.swing.JSpinner spin_ha;
    private javax.swing.JSpinner spin_hd;
    private javax.swing.JSpinner spin_ma;
    private javax.swing.JSpinner spin_md;
    private javax.swing.JTable tbl_Vol;
    private javax.swing.JTextField txt_LibVol;
    private javax.swing.JTextField txt_Tarif;
    private javax.swing.JFormattedTextField txtf_DateA;
    private javax.swing.JFormattedTextField txtf_DateD;
    // End of variables declaration//GEN-END:variables
}
