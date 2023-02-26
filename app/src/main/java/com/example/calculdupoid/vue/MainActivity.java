package com.example.calculdupoid.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculdupoid.R;
import com.example.calculdupoid.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.controle = Controle.getInstance();
    }
    // les proprieter
    private EditText txtPoid;
    private EditText txtAge;
    private EditText txtTaille;
    private TextView lblIMG;
    private RadioButton rdHomme;
    private ImageView imgSmiley;
    private Controle controle;

    /**
     * initialisation des lien avec les objet layout
     */
    private void init(){
        txtAge = (EditText) findViewById(R.id.txtAge);
        txtPoid = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        lblIMG = (TextView) findViewById(R.id.lblImg);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);

    }

    public void ecouteCalcule(View view) {

        Integer poid = 0;
        Integer taille =0;
        Integer age = 0;
        Integer sexe = 0;
        //repuperation des valeur
        try {
            poid = Integer.parseInt(txtPoid.getText().toString());
            taille = Integer.parseInt(txtTaille.getText().toString());
            age = Integer.parseInt(txtAge.getText().toString());
        }catch (Exception e){}
        if (rdHomme.isChecked()){
            sexe = 1;
        }
        if (poid==0 || taille==0 || age==0){
            Toast.makeText(this, "Valeur entrer incorrect", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Calculer", Toast.LENGTH_SHORT).show();
            affichageResult(poid,taille,age,sexe);

        }
    }

//    private void ecouteCalcul(){
//        ((Button) findViewById(R.id.btnCalculer)).setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              Toast.makeText(this, "Calculer", Toast.LENGTH_SHORT).show();

//            }
//        });
//    }

    private void affichageResult(Integer poid, Integer taille, Integer age, Integer sexe){
        this.controle.creerProfil(age,poid, taille, sexe);
        String message = controle.getMessage();
        float img = controle.getImg();


        if (message=="Grosse"){
            imgSmiley.setImageResource(R.drawable.amoji_graisse);
        } else if (message=="Normal") {
            imgSmiley.setImageResource(R.drawable.emoji_yes);
            lblIMG.setTextColor(Color.GREEN);
        }else {
            imgSmiley.setImageResource(R.drawable.emoji_maigre);
            lblIMG.setTextColor(Color.RED);
        }

    lblIMG.setText(String.format("%.1f", img)+" : IMG "+message);
    }


}