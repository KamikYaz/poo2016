/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NoyauFonctionnel;

import java.awt.BorderLayout;
import java.util.Date;
import projetjava2016.Avion;
import projetjava2016.Personnel;
import projetjava2016.Vol;

/**
 *
 * @author Son Goten
 */
public class ProjetJava2016 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        NoyauFonctionnel noyau = new NoyauFonctionnel();

//        //Insertion des aeroports
//        noyau.ajouterAeroport("Toulouse", "France", "Toulouse");
//        noyau.ajouterAeroport("Roissy", "France", "Paris");
//        noyau.ajouterAeroport("Beziers-Vias", "France", "Beziers");
//
//        //Insertion des avions
//        noyau.getListeAvion().add(new Avion(1));
//        noyau.getListeAvion().add(new Avion(2));
//        noyau.getListeAvion().add(new Avion(3));
//        noyau.getListeAvion().add(new Avion(4));
//        noyau.getListeAvion().add(new Avion(5));
//
//        //Insertion du personnel
//        noyau.getListePersonnel().add(new Personnel(1, "nom1", "prenom1", "Pilote"));
//        noyau.getListePersonnel().add(new Personnel(2, "nom2", "prenom2", "CoPilote"));
//        noyau.getListePersonnel().add(new Personnel(3, "nom3", "prenom3", "Hotesse"));
//        noyau.getListePersonnel().add(new Personnel(4, "nom4", "prenom4", "Hotesse"));
//        noyau.getListePersonnel().add(new Personnel(5, "nom5", "prenom5", "Hotesse"));
//        noyau.getListePersonnel().add(new Personnel(6, "nom6", "prenom6", "Pilote"));
//        noyau.getListePersonnel().add(new Personnel(7, "nom7", "prenom7", "CoPilote"));
//        noyau.getListePersonnel().add(new Personnel(8, "nom8", "prenom8", "Hotesse"));
//        noyau.getListePersonnel().add(new Personnel(9, "nom9", "prenom9", "Hotesse"));
//        noyau.getListePersonnel().add(new Personnel(10, "nom10", "prenom10", "Hotesse"));
//
//        //insertion des vol
//        noyau.ajouterVol("Vol1", "25/01/2016", "25/01/2016", "17:00", "20:00", 200F, "Toulouse", "Beziers-Vias");
//        noyau.ajouterVol("Vol2", "25/01/2016", "25/01/2016", "18:00", "19:00", 200F, "Toulouse", "Beziers-Vias");
//        noyau.ajouterVol("Vol3", "25/01/2016", "25/01/2016", "12:00", "15:00", 200F, "Beziers-Vias", "Toulouse");
//        noyau.ajouterVol("Vol4", "28/01/2016", "28/01/2016", "17:00", "20:00", 200F, "Beziers-Vias", "Toulouse");
//        noyau.ajouterVol("Vol5", "29/01/2016", "29/01/2016", "17:00", "20:00", 200F, "Toulouse", "Roissy");
//        noyau.ajouterVol("Vol6", "30/01/2016", "30/01/2016", "17:00", "20:00", 200F, "Beziers-Vias", "Roissy");
//
//        for (int i = 0; i < noyau.getListeVol().size(); i++) {
//            noyau.consulterVol(noyau.getListeVol().get(i));
//        }
//
//        System.out.println("**********AFFECTATION D UN AVION**********");
//        System.out.println("Etat initial du vol 1 :");
//        System.out.println("Le vol se retrouve avec l'etat :");
//        System.out.println(noyau.getListeVol().get(0).getEtatVol());
//        System.out.println("--------------------------------");
//        noyau.affecterAvion(1, "Vol1");
//        System.out.println("Le vol 1 a été affecté a L'avion 1 :");
//        System.out.println("Le vol se retrouve avec l'etat :");
//        System.out.println(noyau.getListeVol().get(0).getEtatVol());
//        System.out.println("--------------------------------");
//        System.out.println("**********AFFECTATION DU PERSONNEL**********");
//        System.out.println("La personne 1 a été affecté au vol1");
//        noyau.affecterPerso(1, "Vol1");
//        System.out.println("La personne 2 a été affecté au vol1");
//        noyau.affecterPerso(2, "Vol1");
//        System.out.println("La personne 3 a été affecté au vol1");
//        noyau.affecterPerso(3, "Vol1");
//        System.out.println("La personne 4 a été affecté au vol1");
//        noyau.affecterPerso(4, "Vol1");
//        System.out.println("La personne 5 a été affecté au vol1");
//        noyau.affecterPerso(5, "Vol1");
//        System.out.println("--------------------------------");
//        System.out.println("Le vol se retrouve avec l'etat :");
//        System.out.println(noyau.getListeVol().get(0).getEtatVol());
//        System.out.println("--------------------------------");
//        for (int i = 0; i < noyau.getListeVol().get(0).getListePersonnel().size(); i++) {
//            System.out.println(noyau.getListeVol().get(0).getListePersonnel().get(i).getType());
//        }
//
//        System.out.println("**********SUPPRESSION DE PERSONNES**********");
//        System.out.println("Supression du pilote pout le vol 1");
//        noyau.enleverPersonnel("Vol1", 1);
//        System.out.println("Suppresion d'un hotesse pout le vol 1");
//        noyau.enleverPersonnel("Vol1", 4);
//        System.out.println("--------------------------------");
//        for (int i = 0; i < noyau.getListeVol().get(0).getListePersonnel().size(); i++) {
//            System.out.println(noyau.getListeVol().get(0).getListePersonnel().get(i).getType());
//        }
//        System.out.println("--------------------------------");
//        System.out.println("Le vol se retrouve avec l'etat :");
//        System.out.println(noyau.getListeVol().get(0).getEtatVol());
//        System.out.println("--------------------------------");
//
//        System.out.println("**********SUPPRESSION DE TOUTES LEQUIPE**********");
//        System.out.println("Supression du Copilote pout le vol 1");
//        noyau.enleverPersonnel("Vol1", 2);
//        System.out.println("Suppresion de deux hotesse pout le vol 1");
//        noyau.enleverPersonnel("Vol1", 3);
//        noyau.enleverPersonnel("Vol1", 5);
//        System.out.println("--------------------------------");
//        System.out.println("--------------------------------");
//        System.out.println("Le vol se retrouve avec l'etat :");
//        System.out.println(noyau.getListeVol().get(0).getEtatVol());
//        System.out.println("--------------------------------");
//
//        System.out.println("**********SUPPRESSION DE L AVION**********");
//        System.out.println("Supression de l'avion 1 pour le vol 1");
//        noyau.enleverAvion("Vol1", 1);
//        System.out.println("--------------------------------");
//        System.out.println("Le vol se retrouve avec l'etat :");
//        System.out.println(noyau.getListeVol().get(0).getEtatVol());
//        System.out.println("--------------------------------");
//
//        System.out.println("**********REAFFECTATION D UN AVION ET D UNE EQUIPE**********");
//        System.out.println("**********AFFECTATION D UN AVION**********");
//        System.out.println("Etat initial du vol 1 :");
//        System.out.println("Le vol se retrouve avec l'etat :");
//        System.out.println(noyau.getListeVol().get(0).getEtatVol());
//        System.out.println("--------------------------------");
//        noyau.affecterAvion(1, "Vol1");
//        System.out.println("Le vol 1 a été affecté a L'avion 1 :");
//        System.out.println("Le vol se retrouve avec l'etat :");
//        System.out.println(noyau.getListeVol().get(0).getEtatVol());
//        System.out.println("--------------------------------");
//        System.out.println("**********AFFECTATION DU PERSONNEL**********");
//        System.out.println("La personne 1 a été affecté au vol1");
//        noyau.affecterPerso(1, "Vol1");
//        System.out.println("La personne 2 a été affecté au vol1");
//        noyau.affecterPerso(2, "Vol1");
//        System.out.println("La personne 3 a été affecté au vol1");
//        noyau.affecterPerso(3, "Vol1");
//        System.out.println("La personne 4 a été affecté au vol1");
//        noyau.affecterPerso(4, "Vol1");
//        System.out.println("La personne 5 a été affecté au vol1");
//        noyau.affecterPerso(5, "Vol1");
//        System.out.println("--------------------------------");
//        System.out.println("Le vol se retrouve avec l'etat :");
//        System.out.println(noyau.getListeVol().get(0).getEtatVol());
//        System.out.println("--------------------------------");
//        for (int i = 0; i < noyau.getListeVol().get(0).getListePersonnel().size(); i++) {
//            System.out.println(noyau.getListeVol().get(0).getListePersonnel().get(i).getType());
//        }
//
//        System.out.println("**********TEST AFFECTATION PERSONNE**********");
//        System.out.println("**********CAS EQUIPE COMPLETE**********");
//        System.out.println("Affectation personne 6 au vol 1 sachant que le vol 1 est complet");
//        noyau.affecterPerso(1, "Vol1");
//        System.out.println("**********CAS VOL PENDANT**********");
//        System.out.println("Affectation personne 1 au vol 2 sachant que la personne 1 et affecter au vol 1 et que le vol et pendant le vol 1");
//        noyau.consulterVol(noyau.getListeVol().get(0));
//        noyau.consulterVol(noyau.getListeVol().get(1));
//        noyau.affecterPerso(1, "Vol2");
//        System.out.println("**********CAS VOL AVANT**********");
//        System.out.println("Affectation personne 1 au vol 3 sachant que le vol est avant");
//        noyau.consulterVol(noyau.getListeVol().get(0));
//        noyau.consulterVol(noyau.getListeVol().get(2));
//        noyau.affecterPerso(1, "Vol3");
//        System.out.println("**********CAS VOL APRES**********");
//        System.out.println("Affectation personne 1 au vol 4 sachant que le vol est apres et que l'aeroport d'arrivee et le meme que l'aeroport de depart");
//        noyau.consulterVol(noyau.getListeVol().get(0));
//        noyau.consulterVol(noyau.getListeVol().get(3));
//        noyau.affecterPerso(1, "Vol4");
//        System.out.println("OK");
//
//        System.out.println("**********TEST AFFECTATION AVION**********");
//        System.out.println("**********CAS AVION DEJA AFFECTE**********");
//        System.out.println("Affectation avion 2 au vol 1 sachant que le vol 1 a deja un avion affecte");
//        noyau.affecterAvion(2, "Vol1");
//        System.out.println("**********CAS VOL PENDANT**********");
//        System.out.println("Affectation avion 1 au vol 2 sachant que l'avion 1 et affecter au vol 1 et que le vol 2 est pendant le vol 1");
//        noyau.consulterVol(noyau.getListeVol().get(0));
//        noyau.consulterVol(noyau.getListeVol().get(1));
//        noyau.affecterAvion(1, "Vol2");
//        System.out.println("**********CAS VOL AVANT**********");
//        noyau.consulterVol(noyau.getListeVol().get(0));
//        noyau.consulterVol(noyau.getListeVol().get(2));
//        noyau.affecterAvion(1, "Vol3");
//        System.out.println("**********CAS VOL APRES**********");
//        System.out.println("Affectation avion 1 au vol 4 sachant que le vol est apres et que l'aeroport d'arrivee et le meme que l'aeroport de depart");
//        noyau.consulterVol(noyau.getListeVol().get(0));
//        noyau.consulterVol(noyau.getListeVol().get(3));
//        noyau.affecterAvion(1, "Vol4");
//        System.out.println("OK");
//
//        System.out.println("**********CAS AFFECTATION PILOTE**********");
//        System.out.println("Affectation du pilote 6 sachant q'un pilote est deja affecte");
//        noyau.enleverPersonnel("Vol1", 4);
//        noyau.affecterPerso(6, "Vol1");
//        System.out.println("bug");
//        for (int i = 0; i < noyau.getListeVol().get(0).getListePersonnel().size(); i++) {
//            System.out.println(noyau.getListeVol().get(0).getListePersonnel().get(i).getType());
//        }
//
//        System.out.println("**********CALCUL NB VOL AVION**********");
//        noyau.consulterVol(noyau.getListeVol().get(0));
//        noyau.consulterVol(noyau.getListeVol().get(3));
//        System.out.println(noyau.volAvion(1) + " Heures");
//
//        System.out.println("**********CALCUL NB VOL PERSONNEL**********");
//        noyau.consulterVol(noyau.getListeVol().get(0));
//        System.out.println("La personne 8 a été affecté nul part");
//        System.out.println(noyau.volPerso(8) + " Heures");
//        System.out.println("La personne 2 a été affecté au vol1 d'une duree de 3h ");
//        System.out.println(noyau.volPerso(2) + " Heures");
//
   }
}
