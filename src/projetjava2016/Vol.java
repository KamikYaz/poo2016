/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava2016;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author Son Goten
 */
public class Vol {

    private String idvol;
    private Date heureDepart;
    private Date heureArrivee;
    private float duree;
    private float tarif;
    private String etatVol;
    private Avion avion;
    private Aeroport aeroDepart;
    private Aeroport aeroArrivee;
    private HashMap<Aeroport, Escale> listeEscale;
    private ArrayList<Personnel> listePersonnel;

    public Vol(String libVol, Date heureDepart, Date heureArrivee, float duree, float tarif, String etatVol, Avion avion, Aeroport aeroDepart, Aeroport aeroArrivee) {
        this.idvol = libVol;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.duree = duree;
        this.tarif = tarif;
        this.etatVol = etatVol;
        this.avion = avion;
        this.aeroDepart = aeroDepart;
        this.aeroArrivee = aeroArrivee;
        this.listeEscale = new HashMap();
        this.listePersonnel = new ArrayList();
    }

    public String getIdvol() {
        return idvol;
    }

    public Date getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(Date heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Date getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(Date heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public float getDuree() {
        return duree;
    }

    public void setDuree(float duree) {
        this.duree = duree;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public String getEtatVol() {
        return etatVol;
    }

    public void setEtatVol(String etatVol) {
        this.etatVol = etatVol;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Aeroport getAeroDepart() {
        return aeroDepart;
    }

    public void setAeroDepart(Aeroport aeroDepart) {
        this.aeroDepart = aeroDepart;
    }

    public Aeroport getAeroArrivee() {
        return aeroArrivee;
    }

    public void setAeroArrivee(Aeroport aeroArrivee) {
        this.aeroArrivee = aeroArrivee;
    }

    public HashMap<Aeroport, Escale> getListeEscale() {
        return listeEscale;
    }

    public ArrayList<Personnel> getListePersonnel() {
        return listePersonnel;
    }

    //Fonctions sur les listes
    //Ajoute une personne au personnel du vol
    public void ajouterPersonne(Personnel p) {
        this.listePersonnel.add(p);
    }

    //supprime une personne
    public void supprimerPersonne(Personnel p) {
        this.listePersonnel.remove(p);
    }

    //Compte le nombre de personne
    public int nombrePersonne() {
        return this.listePersonnel.size();
    }

    //Fonction qui retourne la date sous la forme dd/mm/yyyy
    private String dateFormat(Date d) {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        return formater.format(d);
    }

    //Fonction qui retourne l'heure sous la forme hh:mm
    private String heureFormat(Date d) {
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
        return formater.format(d);
    }

    //Fonction qui retourne le jour de la semaine
    private String jourFormat(Date d) {
        SimpleDateFormat formater = new SimpleDateFormat("E");
        return formater.format(d);
    }

    public String toString() {
        return this.idvol + " Vol de " + this.aeroDepart.getLibAeroport()
                + " le " + jourFormat(this.heureDepart) + dateFormat(this.heureDepart) + " à "
                + heureFormat(this.heureDepart) + " a destination de "
                + this.aeroArrivee.getLibAeroport() + " le "
                + jourFormat(this.heureArrivee) + dateFormat(this.heureArrivee) + " à "
                + heureFormat(this.heureArrivee) + " au tarif de "
                + this.tarif + "€ avec une duree de " + this.duree + " heures";
    }

    public boolean equals(Object obj) {
        Vol v2;
        v2 = (Vol) obj;
        if (v2.getIdvol().equals(this.getIdvol())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idvol);
        return hash;
    }

}
