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
public class comboAvion extends DefaultComboBoxModel implements VueGestionVol{

    private NoyauFonctionnel nf;
    
    public comboAvion(NoyauFonctionnel nf) {
        this.nf = nf;
    }

    
    
    @Override
    public void notifyFromModel(NoyauFonctionnel model) {
        this.fireContentsChanged(this, 0, 0);
    }

    @Override
    public Object getElementAt(int index) {
        Object avion = null;
        if(index == 0){
            avion = "Veuillez choisir un avion";
        } else {
            avion = nf.getListeAvion().get(index-1).getIdAvion();
        }
        
        return avion; 
    }

    @Override
    public int getSize() {
        return nf.getListeAeroport().size() +1;
    }
    
    
    
    
}
