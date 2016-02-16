/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava2016;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Son Goten
 */
public class Personnel {

    private int code;
    private String nom;
    private String prenom;
    private String type;
    private ArrayList<Vol> listeVol;

    public Personnel(int code, String nom, String prenom, String type) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.listeVol = new ArrayList();
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Vol> getListeVol() {
        return listeVol;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setListeVol(ArrayList<Vol> listeVol) {
        this.listeVol = listeVol;
    }

}
