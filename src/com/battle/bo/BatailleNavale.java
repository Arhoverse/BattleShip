package com.battle.bo;

import java.util.Scanner;

public class BatailleNavale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue dans la bataille navale !");
        System.out.print("Joueur 1, entrez votre nom : ");
        Joueur joueur1 = new Joueur(sc.nextLine());
        System.out.print("Joueur 2, entrez votre nom : ");
        Joueur joueur2 = new Joueur(sc.nextLine());

        System.out.println(joueur1.getNom() + ", placez vos bateaux !");
        joueur1.placerBateaux();

        System.out.println(joueur2.getNom() + ", placez vos bateaux !");
        joueur2.placerBateaux();

        Joueur joueurCourant = joueur1;
        while (true) {
            System.out.println(joueurCourant.getNom() + ", à vous de jouer !");
            joueurCourant.getGrille().afficher();
            System.out.print("Ligne (0-9) : ");
            int ligne = sc.nextInt();
            System.out.print("Colonne (0-9) : ");
            int colonne = sc.nextInt();
            if (joueurCourant.tire(joueurCourant == joueur1 ? joueur2 : joueur1, ligne, colonne)) {
                continue;
            }
            joueurCourant = joueurCourant == joueur1 ? joueur2 : joueur1;
        }
    }
}