package com.battle.bo;

import java.util.Scanner;
public class Joueur {
    private String nom;
    private Grille grille;
    private Bateau[] bateaux;

    public Joueur(String nom) {
        this.nom = nom;
        this.grille = new Grille();
        this.bateaux = new Bateau[5];
        bateaux[0] = new Bateau(5);
        bateaux[1] = new Bateau(4);
        bateaux[2] = new Bateau(3);
        bateaux[3] = new Bateau(3);
        bateaux[4] = new Bateau(2);
    }

    public String getNom() {
        return nom;
    }

    public Grille getGrille() {
        return grille;
    }

    public Bateau[] getBateaux() {
        return bateaux;
    }

    public void placerBateaux() {
        Scanner sc = new Scanner(System.in);
        for (Bateau b : bateaux) {
            grille.afficher();
            System.out.println(nom + ", placez votre bateau de taille " + b.getTaille() + ".");
            System.out.print("Ligne (0-9) : ");
            int ligne = sc.nextInt();
            System.out.print("Colonne (0-9) : ");
            int colonne = sc.nextInt();
            System.out.print("Orientation (0 = horizontal, 1 = vertical) : ");
            int orientation = sc.nextInt();
            boolean estVertical = (orientation == 1);
            if (grille.estPlacementValide(ligne, colonne, b.getTaille(), estVertical)) {
                grille.placerBateau(ligne, colonne, b.getTaille(), estVertical);
            } else {
                System.out.println("Placement invalide, veuillez recommencer.");
            }
        }
    }

    public boolean tire(Joueur adversaire, int ligne, int colonne) {
        Case c = adversaire.getGrille().getCase(ligne, colonne);
        if (!c.estOccupee()) {
            System.out.println(nom + " : raté !");
            return false;
        } else {
            for (Bateau b : adversaire.getBateaux()) {
                for (int i = 0; i < b.getTaille(); i++) {
                    if (c.getLigne() == ligne && c.getColonne() == colonne) {
                        b.touche();
                        if (b.estCoule()) {
                            System.out.println(nom + " : touché coulé !");
                            if (adversaire.aPerdu()) {
                                System.out.println("Partie terminée ! " + nom + " a gagné !");
                            }
                        } else {
                            System.out.println(nom + " : touché !");
                        }
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public boolean aPerdu() {
        for (Bateau b : bateaux) {
            if (!b.estCoule()) {
                return false;
            }
        }
        return true;
    }
}
