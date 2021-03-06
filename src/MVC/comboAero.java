/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import NoyauFonctionnel.NoyauFonctionnel;
import NoyauFonctionnel.VueGestionVol;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Saitama
 */
public class comboAero extends DefaultComboBoxModel implements VueGestionVol{

    private NoyauFonctionnel nf;
    
    public comboAero(NoyauFonctionnel nf) {
        this.nf = nf;
    }

    
    @Override
    public void notifyFromModel(NoyauFonctionnel model) {
        this.fireContentsChanged(this, 0, 0);
    }

    @Override
    public Object getElementAt(int index) {
        Object aeroport = null;
        if(index == 0){
            aeroport = "Veuillez choisir un avion";
        } else {
            aeroport = nf.getListeAeroport().get(index-1).getLibAeroport();
        }
        return aeroport; 
    }

    @Override
    public int getSize() {
        return nf.getListeAeroport().size() +1;
    }
    
    
    
    
}
