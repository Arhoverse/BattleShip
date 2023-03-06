package com.battle.bo;

public class Grille {
    private Case[][] cases;

    public Grille() {
        this.cases = new Case[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cases[i][j] = new Case(i, j);
            }
        }
    }

    public Case getCase(int ligne, int colonne) {
        return cases[ligne][colonne];
    }

    public boolean estPlacementValide(int ligne, int colonne, int taille, boolean estVertical) {
        if (estVertical) {
            if (ligne + taille > 10) {
                return false;
            }
            for (int i = ligne; i < ligne + taille; i++) {
                if (cases[i][colonne].estOccupee()) {
                    return false;
                }
            }
        } else {
            if (colonne + taille > 10) {
                return false;
            }
            for (int j = colonne; j < colonne + taille; j++) {
                if (cases[ligne][j].estOccupee()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void placerBateau(int ligne, int colonne, int taille, boolean estVertical) {
        for (int i = 0; i < taille; i++) {
            if (estVertical) {
                cases[ligne + i][colonne].setOccupee(true);
            } else {
                cases[ligne][colonne + i].setOccupee(true);
            }
        }
    }

    public void afficher() {
        System.out.print("  ");
        for (int j = 0; j < 10; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                Case c = cases[i][j];
                if (!c.estOccupee()) {
                    System.out.print(". ");
                } else {
                    System.out.print("B ");
                }
            }
            System.out.println();
        }
    }
}