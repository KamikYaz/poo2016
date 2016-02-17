/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NoyauFonctionnel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetjava2016.Aeroport;
import projetjava2016.Personnel;
import projetjava2016.Avion;
import projetjava2016.Vol;
import projetjava2016.Escale;

/**
 *
 * @author Son Goten
 */
public class NoyauFonctionnel {

    //declaration des constantes
    private static String EN_CREATION = "En creation";
    private static String EN_PREPARATION = "En preparation";
    private static String PROGRAMME = "Programme";
    private static String VALIDE = "Valide";

    private ArrayList<Vol> listeVol;
    private ArrayList<Avion> listeAvion;
    private ArrayList<Aeroport> listeAeroport;
    private ArrayList<Personnel> listePersonnel;
    private ArrayList<VueGestionVol> views;

    public NoyauFonctionnel() {
        this.listeAeroport = new ArrayList();
        this.listeVol = new ArrayList();
        this.listeAvion = new ArrayList();
        this.listePersonnel = new ArrayList();
        this.views = new ArrayList();
    }

    public void addView(VueGestionVol view) {
        views.add(view);
    }

    private void notifyViews() {
        for (VueGestionVol view : views) {
            view.notifyFromModel(this);
        }
    }

    public ArrayList<Vol> getListeVol() {
        return listeVol;
    }

    public ArrayList<Avion> getListeAvion() {
        return listeAvion;
    }

    public ArrayList<Aeroport> getListeAeroport() {
        return listeAeroport;
    }

    public ArrayList<Personnel> getListePersonnel() {
        return listePersonnel;
    }

    //Parcour de tableau pour recuperer l'indice d'un aeroport
    private int chercherAero(String lib) {
        boolean trouve = false;
        int i = 0;
        while (i < this.listeAeroport.size() && !trouve) {
            if (this.listeAeroport.get(i).getLibAeroport() == lib) {
                trouve = true;
            } else {
                i++;
            }
        }
        if (trouve) {
            return i;
        } else {
            return -1;
        }
    }

    //Parcour de tableau pour recuperer l'indice d'une personne
    private int chercherPerso(int lib) {
        boolean trouve = false;
        int i = 0;
        while (i < this.listePersonnel.size() && !trouve) {
            if (this.listePersonnel.get(i).getCode() == lib) {
                trouve = true;
            } else {
                i++;
            }
        }
        if (trouve) {
            return i;
        } else {
            return -1;
        }
    }

    //Parcour de tableau pour recuperer l'indice d'un avion
    private int chercherAVion(int lib) {
        boolean trouve = false;
        int i = 0;
        while (i < this.listeAvion.size() && !trouve) {
            if (this.listeAvion.get(i).getIdAvion() == lib) {
                trouve = true;
            } else {
                i++;
            }
        }
        if (trouve) {
            return i;
        } else {
            return -1;
        }
    }

    //Parcour de tableau pour recuperer l'indice d'un vol
    private int chercherVol(String id) {
        boolean trouve = false;
        int i = 0;
        while (i < this.listeVol.size() && !trouve) {
            if (this.listeVol.get(i).getIdvol() == id) {
                trouve = true;
            } else {
                i++;
            }
        }
        if (trouve) {
            return i;
        } else {
            return -1;
        }
    }

    //Fonction qui verifie que les dates sont logiques
    public int verifierDates(Date dd, Date da) {
        Date current = new Date();
        int d;
        if (dd.getTime() < current.getTime() || da.getTime() < current.getTime()) {
            d = 1;
        } else if (dd.getTime() >= da.getTime()) {
            d = 2;
        } else {
            d = 0;
        }
        return d;
    }

    //Fonction pour gerer les dates
    private Date gererDates(String maDate, String monHeure) {
        //Concatenation de la date et l'heure
        String stringToDate = maDate + " " + monHeure;
        //Definition du type de la date
        SimpleDateFormat formater = new SimpleDateFormat();
        //Transformation du String en Date
        try {
            Date d = formater.parse(stringToDate);
            return d;
        } catch (ParseException ex) {
            Logger.getLogger(NoyauFonctionnel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Fonction pour calculer la duree d'un vol
    private float calculDuree(Date depart, Date arrivee) {
        return ((arrivee.getTime() - depart.getTime()) / 3600000);
    }

    //Fonction qui ajoute un Aeroport
    public void ajouterAeroport(String libAeroport, String pays, String ville) {
        Aeroport aero = new Aeroport(libAeroport, pays, ville);
        this.listeAeroport.add(aero);
    }

    //Focntion qui modifie un aeroport
    public void modifierAeroport(String libAeroport, String pays, String ville) {
        int i = chercherAero(libAeroport);
        this.listeAeroport.get(i).setLibAeroport(libAeroport);
        this.listeAeroport.get(i).setPays(pays);
        this.listeAeroport.get(i).setVille(ville);
    }

    //Fonction qui supprime un aeroport
    public void supprimerAeroport(String lib) {
        int i = chercherAero(lib);
        this.listeAeroport.remove(i);
    }

    //Fonction qui affiche un aeroport grace a tostring
    public void consulterAeroport(Aeroport aero) {
        System.out.println(aero.toString());
    }

    //Retourne un aeroport en fonction de son id
    private Aeroport aero(String lib) {
        int i = chercherAero(lib);
        Aeroport aero;
        if (i >= 0) {
            aero = this.listeAeroport.get(i);
        } else {
            aero = null;
        }
        return aero;
    }

    //Retourne un vol en fonction de son id
    public Vol vol(String lib) {
        int i = chercherVol(lib);
        Vol v;
        if (i >= 0) {
            v = this.listeVol.get(i);
        } else {
            v = null;
        }
        return v;
    }

    //Retourne un avion en fonction de son id
    public Avion avion(int lib) {
        int i = chercherAVion(lib);
        Avion v;
        if (i >= 0) {
            v = this.listeAvion.get(i);
        } else {
            v = null;
        }
        return v;
    }

    //Retourne un avion en fonction de son id
    public Personnel perso(int lib) {
        int i = chercherPerso(lib);
        Personnel p;
        if (i >= 0) {
            p = this.listePersonnel.get(i);
        } else {
            p = null;
        }
        return p;
    }

    //Ajoute un vol
    public void ajouterVol(String libVol, String dateDepart, String dateArrivee, String heureDepart, String heureArrivee, Float tarif, String aeroportDepart, String aeroportArrivee) {
        Date dd, da;
        Aeroport ad, aa;
        float duree;
        dd = gererDates(dateDepart, heureDepart);
        da = gererDates(dateArrivee, heureArrivee);
        duree = calculDuree(dd, da);
        ad = aero(aeroportDepart);
        aa = aero(aeroportArrivee);
        //Si l'aeroport d'arrivee et different de l'aeroport de depart
        if (aeroportArrivee != aeroportDepart) {
            Vol v = new Vol(libVol, dd, da, duree, tarif, EN_CREATION, null, ad, aa);
            this.listeVol.add(v);
        } else {
            System.out.println("Les aeroport ne peuvent pas etre identique");
        }
        notifyViews();
    }

    //Fonction pour supprimer un vol
    public void supprimerVol(String lib) {
        int i = chercherVol(lib);
        this.listeVol.remove(i);
    }

    //Fonction pour consulter un vol grâce a la redifinition de tostring
    public void consulterVol(Vol v) {
        System.out.println(v.toString());
    }

    //Fonction pour modifier un vol
    public void modifierVol(String libVol, String dateDepart, String dateArrivee, String heureDepart, String heureArrivee, Float tarif, String aeroportDepart, String aeroportArrivee) {
        Date dd, da;
        Aeroport ad, aa;
        float duree;
        dd = gererDates(dateDepart, heureDepart);
        da = gererDates(dateArrivee, heureArrivee);
        duree = calculDuree(dd, da);
        ad = aero(aeroportDepart);
        aa = aero(aeroportArrivee);
        Vol v;
        v = vol(libVol);
        this.listeVol.remove(v);
        v = new Vol(libVol, dd, da, duree, tarif, EN_CREATION, null, ad, aa);
        this.listeVol.add(v);
    }

    //Retourne vrai si l'avion est dispo pour un vol donné faux sinon
    public boolean chercherDispoAvion(Avion a, Vol v) {
        boolean dispo = true;
        int i = 0;
        while (i < a.getListeVol().size() && dispo) {
            //heure de depart de l'avion < heure depart vol et heure arrive avion > heure depart vol
            if (a.getListeVol().get(i).getHeureDepart().getTime() < v.getHeureDepart().getTime() && a.getListeVol().get(i).getHeureArrivee().getTime() > v.getHeureDepart().getTime()) {
                dispo = false;
                //heure depart avion > vol depart et heure arrive avion < heure arrivee vol
            } else if (a.getListeVol().get(i).getHeureDepart().getTime() > v.getHeureDepart().getTime() && a.getListeVol().get(i).getHeureArrivee().getTime() < v.getHeureArrivee().getTime()) {
                dispo = false;
                //cas heure depart avion < heure du vol et heure arrivee avion > vol arrivee
            } else if (a.getListeVol().get(i).getHeureDepart().getTime() < v.getHeureDepart().getTime() && a.getListeVol().get(i).getHeureArrivee().getTime() > v.getHeureArrivee().getTime()) {
                dispo = false;
                //cas heure d'arrivee de l'avion < heure depart vol et aeroport different
            } else if (a.getListeVol().get(i).getHeureArrivee().getTime() < v.getHeureDepart().getTime() && a.getListeVol().get(i).getAeroArrivee() != v.getAeroDepart()) {
                dispo = false;
                //cas heure de depart de l'avion > heure d'arrivee du vol et aeroport d'arrivee du vol <> aeroport depart avion
            } else if (a.getListeVol().get(i).getHeureDepart().getTime() < v.getHeureArrivee().getTime() && a.getListeVol().get(i).getAeroDepart() != v.getAeroArrivee()) {
                dispo = false;
            } //heure de depart avion > heure depart vol et heure arrivée avion > heure arrive vol
            else if (a.getListeVol().get(i).getHeureDepart().getTime() > v.getHeureDepart().getTime() && a.getListeVol().get(i).getHeureArrivee().getTime() > v.getHeureArrivee().getTime()) {
                dispo = false;
            } else {
                i++;
            }
        }
        return dispo;
    }

    //Verifie la disponibilité d'un avion
    public boolean dispoAvion(int idAvion, String idVol) {
        Avion a;
        Vol v;
        boolean disponible;
        a = avion(idAvion);
        v = vol(idVol);
        //Si la taille des vol = 0 ou qu'il est disponible
        if (a.getListeVol().size() == 0 || chercherDispoAvion(a, v) == true) {
            disponible = true;
        } else {
            disponible = false;
        }
        return disponible;
    }

    //Fonction pour affecter un avion
    public void affecterAvion(int idAvion, String idVol) {
        boolean disponible = dispoAvion(idAvion, idVol);
        Avion a;
        Vol v;
        a = avion(idAvion);
        v = vol(idVol);
        //Si avion disponible et que le vol ne contient pas d'avion
        if (disponible && v.getAvion() == null) {
            if (v.getEtatVol() == EN_CREATION) {
                v.setAvion(a);
                v.setEtatVol(EN_PREPARATION);
                a.getListeVol().add(v);
            }
        } else {
            System.out.println("bug");
        }
    }

    //Retourne vrai si le personnel est dispo pour un vol donné faux sinon
    public boolean chercherEquipe(Personnel p, Vol v) {
        boolean dispo = true;
        int i = 0;
        while (i < p.getListeVol().size() && dispo) {
            //heure de depart de l'avion < heure depart vol et heure arrive avion > heure depart vol
            if (p.getListeVol().get(i).getHeureDepart().getTime() < v.getHeureDepart().getTime() && p.getListeVol().get(i).getHeureArrivee().getTime() > v.getHeureDepart().getTime()) {
                dispo = false;
                //heure depart avion > vol depart et heure arrive avion < heure arrivee vol
            } else if (p.getListeVol().get(i).getHeureDepart().getTime() > v.getHeureDepart().getTime() && p.getListeVol().get(i).getHeureArrivee().getTime() < v.getHeureArrivee().getTime()) {
                dispo = false;
                //cas heure depart avion < heure du vol et heure arrivee avion > vol arrivee
            } else if (p.getListeVol().get(i).getHeureDepart().getTime() < v.getHeureDepart().getTime() && p.getListeVol().get(i).getHeureArrivee().getTime() > v.getHeureArrivee().getTime()) {
                dispo = false;
                //cas heure d'arrivee de l'avion < heure depart vol et aeroport different
            } else if (p.getListeVol().get(i).getHeureArrivee().getTime() < v.getHeureDepart().getTime() && p.getListeVol().get(i).getAeroArrivee() != v.getAeroDepart()) {
                dispo = false;
                //cas heure de depart de l'avion > heure d'arrivee du vol et aeroport d'arrivee du vol <> aeroport depart avion
            } else if (p.getListeVol().get(i).getHeureDepart().getTime() < v.getHeureArrivee().getTime() && p.getListeVol().get(i).getAeroDepart() != v.getAeroArrivee()) {
                dispo = false;
            } //heure de depart avion > heure depart vol et heure arrivée avion > heure arrive vol
            else if (p.getListeVol().get(i).getHeureDepart().getTime() > v.getHeureDepart().getTime() && p.getListeVol().get(i).getHeureArrivee().getTime() > v.getHeureArrivee().getTime()) {
                dispo = false;
            } else {
                i++;
            }
        }
        return dispo;
    }

    //Verifie la disponibilité d'un avion
    public boolean dispoPerso(int idPerso, String idVol) {
        Personnel p;
        Vol v;
        boolean disponible;
        p = perso(idPerso);
        v = vol(idVol);
        disponible = p.getListeVol().size() == 0 || chercherEquipe(p, v);
        return disponible;
    }

    //Fonction pour affecter du personnel
    public void affecterPerso(int idPerso, String idVol) {
        boolean disponible = dispoPerso(idPerso, idVol);
        Personnel p;
        Vol v;
        p = perso(idPerso);
        v = vol(idVol);
        int nbp, nbc, nbh;
        nbp = nbPilote(v);
        nbc = nbCoPilote(v);
        nbh = nbhotesse(v);

        if (disponible) {
            //Si la liste de personnel contient pas le personnel
            if (v.getListePersonnel().contains(p) == false) {
                if (v.getListePersonnel().size() < 5) {
                    //si le nombre de pilote < 1
                    if (nbp < 1 && p.getType() == "Pilote") {
                        v.ajouterPersonne(p);
                        p.getListeVol().add(v);
                    }
                    //si le nombre de Copilote < 1
                    if (nbc < 1 && p.getType() == "CoPilote") {
                        v.ajouterPersonne(p);
                        p.getListeVol().add(v);
                    }
                    //si le nombre d'hotesse < 3
                    if (nbh < 3 && p.getType() == "Hotesse") {
                        v.ajouterPersonne(p);
                        p.getListeVol().add(v);
                    }
                }
                //Si le tableau et plein
                if (v.getListePersonnel().size() == 5) {
                    v.setEtatVol(PROGRAMME);
                }
            }
        } else {
            System.out.println("bug");
        }
    }

    //Retourne le nombre de pilote d'un vol
    public int nbPilote(Vol v) {
        int nb = 0;
        for (int i = 0; i < v.getListePersonnel().size(); i++) {
            if (v.getListePersonnel().get(i).getType() == "Pilote") {
                nb = nb + 1;
            }
        }
        return nb;
    }

    //Retourne le nombre de copilote d'un vol
    public int nbCoPilote(Vol v) {
        int nb = 0;
        for (int i = 0; i < v.getListePersonnel().size(); i++) {
            if (v.getListePersonnel().get(i).getType() == "CoPilote") {
                nb = nb + 1;
            }
        }
        return nb;
    }

    //Retourne le nombre d'hotesse d'un vol
    public int nbhotesse(Vol v) {
        int nb = 0;
        for (int i = 0; i < v.getListePersonnel().size(); i++) {
            if (v.getListePersonnel().get(i).getType() == "Hotesse") {
                nb = nb + 1;
            }
        }
        return nb;
    }

    //Valider un vol
    public void validerVol(String lib) {
        Vol v = vol(lib);
        if (v.getEtatVol() == PROGRAMME && v.getAvion() != null) {
            v.setEtatVol(VALIDE);
        } else {
            System.out.println("Ce vol ne rempli pas les conditions pour etre valide");
        }
    }

    //Gestion escale
    public boolean gererEscale(String vol, String aero, Date dd, Date da) {
        boolean estValide = false;
        float duree;
        Vol v;
        Aeroport a;
        v = vol(vol);
        a = aero(aero);
        //sachant que c'est une escale de reapro celle ci doit etre differente de celle de l'arrivee et de depart
        if (v.getAeroDepart().getLibAeroport() != a.getLibAeroport()) {
            System.out.println("1");
            //si l'heure d'arrivee de l'escale > heure arrive vol et heure depart de l'escale > heure de depart vol
            if (v.getHeureArrivee().getTime() > da.getTime() && v.getHeureDepart().getTime() < dd.getTime()) {
                estValide = true;

            } else {
                estValide = false;
            }
        } else {
            estValide = false;
        }
        return estValide;
    }

    //Fonction qui planifie une escale
    public void escale(String libVol, String libAero, Date dd, Date da) {
        boolean valide;
        Vol v;
        Aeroport a;
        a = aero(libVol);
        v = vol(libVol);
        valide = gererEscale(libVol, libAero, dd, da);
        if (valide) {
            if (v.getListeEscale().isEmpty()) {
                Escale e = new Escale(a, dd, da);
                v.getListeEscale().put(a, e);
            }
        } else {
            System.out.println("bug");
        }
    }

    //Fonction qui supprime une personne d'un vol
    public void enleverPersonnel(String libVol, int idPerso) {
        Vol v = vol(libVol);
        Personnel p = perso(idPerso);
        if (v.getListePersonnel().size() > 0) {
            v.getListePersonnel().remove(p);
            p.getListeVol().remove(v);
            if (v.getListePersonnel().size() == 0) {
                v.setEtatVol(EN_PREPARATION);
            }
        } else {
            System.out.println("Il n'ya pas de personnel affectés a ce vol");
        }
    }

    //Fonction qui supprime un avion d'un vol
    public void enleverAvion(String libVol, int idAvion) {
        Vol v = vol(libVol);
        Avion a = avion(idAvion);
        if (v.getAvion() != null) {
            a.getListeVol().remove(v);
            v.setAvion(null);
            if (v.getAvion() == null) {
                v.setEtatVol(EN_CREATION);
            }
        } else {
            System.out.println("Il n'ya pas d'avion affectés a ce vol");
        }
    }

    //Fonction qui calcule le vol total effectué d'un avion
    public float volAvion(int idAvion) {
        float res = 0F;
        Avion a = avion(idAvion);
        for (int i = 0; i < a.getListeVol().size(); i++) {
            res = res + a.getListeVol().get(i).getDuree();
        }
        return res;
    }

    //Fonction qui calcule le vol total effectué d'une personne
    public float volPerso(int perso) {
        float res = 0F;
        Personnel p = perso(perso);
        for (int i = 0; i < p.getListeVol().size(); i++) {
            res = res + p.getListeVol().get(i).getDuree();
        }
        return res;
    }
    
    //FOnction qui verifie le tarif
    public boolean verifTarif(Float txt){
        boolean t;
        if(txt <= 0){
            t = false;
        }else{
            t = true;
        }
        return t;
    }
    
    //FOnction qui verifie l'heure
    public boolean verifHeure(String heure){
        boolean t;
        int h = Integer.parseInt(heure);
        if(h < 0 && h >= 24){
            t = false;
        }else{
            t = true;
        }
        return t;
    }

    public void bdd() {
        //Insertion des aeroports
        ajouterAeroport("Toulouse", "France", "Toulouse");
        ajouterAeroport("Roissy", "France", "Paris");
        ajouterAeroport("Beziers-Vias", "France", "Beziers");

        //Insertion des avions
        getListeAvion().add(new Avion(1));
        getListeAvion().add(new Avion(2));
        getListeAvion().add(new Avion(3));
        getListeAvion().add(new Avion(4));
        getListeAvion().add(new Avion(5));

        //Insertion du personnel
        getListePersonnel().add(new Personnel(1, "nom1", "prenom1", "Pilote"));
        getListePersonnel().add(new Personnel(2, "nom2", "prenom2", "CoPilote"));
        getListePersonnel().add(new Personnel(3, "nom3", "prenom3", "Hotesse"));
        getListePersonnel().add(new Personnel(4, "nom4", "prenom4", "Hotesse"));
        getListePersonnel().add(new Personnel(5, "nom5", "prenom5", "Hotesse"));
        getListePersonnel().add(new Personnel(6, "nom6", "prenom6", "Pilote"));
        getListePersonnel().add(new Personnel(7, "nom7", "prenom7", "CoPilote"));
        getListePersonnel().add(new Personnel(8, "nom8", "prenom8", "Hotesse"));
        getListePersonnel().add(new Personnel(9, "nom9", "prenom9", "Hotesse"));
        getListePersonnel().add(new Personnel(10, "nom10", "prenom10", "Hotesse"));

        ajouterVol("Vol1", "25/01/2016", "25/01/2016", "17:00", "20:00", 200F, "Toulouse", "Beziers-Vias");
        ajouterVol("Vol2", "25/01/2016", "25/01/2016", "18:00", "19:00", 200F, "Toulouse", "Beziers-Vias");
    }
}
