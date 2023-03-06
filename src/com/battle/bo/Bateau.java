package com.battle.bo;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Bateau {
    private int taille;
    private int nbCasesTouchees;
    private boolean estCoule;

    public Bateau(int taille) {
        this.taille = taille;
        this.nbCasesTouchees = 0;
        this.estCoule = false;
    }

    public int getTaille() {
        return taille;
    }

    public int getNbCasesTouchees() {
        return nbCasesTouchees;
    }

    public boolean estCoule() {
        return estCoule;
    }

    public void touche() {
        nbCasesTouchees++;
        if (nbCasesTouchees == taille) {
            estCoule = true;
        }
    }
}