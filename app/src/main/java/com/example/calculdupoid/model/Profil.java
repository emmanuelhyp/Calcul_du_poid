package com.example.calculdupoid.model;

public class Profil {
    private static final Integer minFemme = 15; //
    private static final Integer maxFemme = 30;
    private static final Integer minHomme = 10;
    private static final Integer maxHomme = 25;


    private Integer Age;
    private Integer Poids;
    private Integer Taille;
    private Integer sexe;
    private float Img;
    private String message;

    public Profil(Integer age, Integer poids, Integer taille, Integer sexe) {
        this.Age = age;
        this.Poids = poids;
        this.Taille = taille;
        this.sexe = sexe;
        this.calculIMG();
        this.resultIMG();
    }

    public Integer getAge() {
        return Age;
    }

    public Integer getPoids() {
        return Poids;
    }

    public Integer getTaille() {
        return Taille;
    }

    public Integer getSexe() {
        return sexe;
    }

    public float getImg() {
        return Img;
    }

    public String getMessage() {
        return message;
    }

    private void calculIMG(){
        float tailleM = ((float)Taille)/100;
        this.Img = (float) ((1.2*Poids / (tailleM*tailleM)) + (0.23*Age) - (10.83*sexe) - 5.4 );
    }

    private void resultIMG(){
        Integer min;
        Integer max;
        if (sexe == 0){
            min = minFemme;
            max = maxFemme;
        }else {
            min = minHomme;
            max = maxHomme;
        }

        message = "Normal";
        if (Img < min){
            message = "Maigre";
        }else {
            if (Img>max){
                message = "Grosse";
            }
        }
    }
}
