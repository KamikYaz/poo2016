/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava2016;

import java.util.ArrayList;

/**
 *
 * @author Son Goten
 */
public class Avion {
    
    private int idAvion;
    private ArrayList<Vol> listeVol;

    public Avion(int idAvion) {
        this.idAvion = idAvion;
        this.listeVol = new ArrayList();
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public ArrayList<Vol> getListeVol() {
        return listeVol;
    }

    
    
}
