package com.example.calculdupoid.controleur;

import com.example.calculdupoid.model.Profil;

public final class Controle {
    private static Controle instance = null;

    private Profil profil;

    private Controle(){
        super();
    }

    public static final Controle getInstance(){
        if(Controle.instance == null){
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }

    /**
     * Creation du profil
     * @param Age
     * @param Poids
     * @param Taille en cm
     * @param Sexe 1 pour homme 0 pour femme
     */
    public void creerProfil(Integer Age, Integer Poids, Integer Taille, Integer Sexe){
        profil = new Profil(Age,Poids,Taille,Sexe);
    }

    /**
     * recuperation de l'ímage
     * @return
     */
    public float getImg(){
        return profil.getImg();
    }
    public String getMessage(){
        return profil.getMessage();
    }




}
