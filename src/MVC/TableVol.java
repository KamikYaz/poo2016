/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import NoyauFonctionnel.NoyauFonctionnel;
import NoyauFonctionnel.VueGestionVol;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saitama
 */
public class TableVol extends DefaultTableModel implements VueGestionVol {

    private final static String[] COLUMN_NAMES = new String[]{"NumVol", "AeroDepart", "AeroArrivee", "DateDepart", "HeureDepart", "DateArrivee", "HeureArrivee", "Tarif"};
    private String NumVol;
    private String AD;
    private String AA;
    private String HD;
    private String HA;
    private String DD;
    private String DA;
    private Float tarif;
    private NoyauFonctionnel model;

    public TableVol(NoyauFonctionnel model) {
        this.model = model;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return (column >= 0 && column < COLUMN_NAMES.length ? COLUMN_NAMES[column] : "???");
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat heureFormat = new SimpleDateFormat("HH:mm");
        if (row >= 0 && row < model.getListeVol().size()) {
            switch (column) {
                case 0:
                    return model.getListeVol().get(row).getIdvol();
                case 1:
                    return model.getListeVol().get(row).getAeroDepart().getLibAeroport();
                case 2:
                    return model.getListeVol().get(row).getAeroArrivee().getLibAeroport();
                case 3:
                    return dateFormat.format(model.getListeVol().get(row).getHeureDepart());
                case 4:
                    return heureFormat.format(model.getListeVol().get(row).getHeureDepart());
                case 5:
                    return dateFormat.format(model.getListeVol().get(row).getHeureArrivee());
                case 6:
                    return heureFormat.format(model.getListeVol().get(row).getHeureArrivee());
                case 7:
                    return model.getListeVol().get(row).getTarif() + "€";
                default:
                    return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public int getRowCount() {
        if (model == null) {
            return 1;
        }

        return model.getListeVol().size() + 1;
    }

    @Override
    public void notifyFromModel(NoyauFonctionnel model) {
        fireTableDataChanged();
    }

}
