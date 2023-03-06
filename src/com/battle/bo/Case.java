package com.battle.bo;


public class Case {
    private int ligne;
    private int colonne;
    private boolean occupee;

    private boolean touche;

    public Case(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.occupee = false;
        this.touche = false;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public boolean estOccupee() {
        return occupee;
    }

    public void setOccupee(boolean occupee) {
        this.occupee = occupee;
    }
}
