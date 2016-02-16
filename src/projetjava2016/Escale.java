/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava2016;

import java.util.Date;

/**
 *
 * @author Son Goten
 */
public class Escale {
    
    private Aeroport aeroport;
    private Date heureDepart;
    private Date heureArrivee;

    public Escale(Aeroport aeroport, Date heureDepart, Date heureArrivee) {
        this.aeroport = aeroport;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
    }

    public Aeroport getAeroport() {
        return aeroport;
    }

    public void setAeroport(Aeroport aeroport) {
        this.aeroport = aeroport;
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
    
    
    
}
