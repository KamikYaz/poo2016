/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava2016;

import java.util.Objects;

/**
 *
 * @author Son Goten
 */
public class Aeroport {

    private String libAeroport;
    private String pays;
    private String ville;

    public Aeroport(String libAeroport, String pays, String ville) {
        this.libAeroport = libAeroport;
        this.pays = pays;
        this.ville = ville;
    }

    public String getLibAeroport() {
        return libAeroport;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public void setLibAeroport(String libAeroport) {
        this.libAeroport = libAeroport;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String toString() {
        return this.libAeroport + " | " + this.pays
                + " | " + this.ville;
    }

    public boolean equals(Object obj) {
        Aeroport a2;
        a2 = (Aeroport) obj;
        if (a2.getLibAeroport().equals(this.getLibAeroport())) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.libAeroport);
        return hash;
    }

}
