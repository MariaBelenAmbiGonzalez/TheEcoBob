package com.example.theecobob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Variables
        ImageButton btnHomePlastico, btnHomePapel, btnHomeVidrio, btnHomeOrgánico, btnHomeResto;
        Button btnHomejuegareciclando;

        //Hooks
        btnHomePlastico = findViewById(R.id.btnPlastico);
        btnHomePapel = findViewById(R.id.btnPapel);
        btnHomeVidrio = findViewById(R.id.btnVidrio);
        btnHomeOrgánico = findViewById(R.id.btnOrganico);
        btnHomeResto = findViewById(R.id.btnResto);
        btnHomejuegareciclando = findViewById(R.id.btnjuegareciclando);

        //Procedimiento para llamar a la clase Amarillo
        btnHomePlastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent (Home.this,Amarillo.class);
                startActivity(intentHome);
                finish();
            }
        });

        //Procedimiento para llamar a la clase Azul
        btnHomePapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent (Home.this,Azul.class);
                startActivity(intentHome);
                finish();
            }
        });

        //Procedimiento para llamar a la clase Verde
        btnHomeVidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent (Home.this,Verde.class);
                startActivity(intentHome);
                finish();
            }
        });

        //Procedimiento para llamar a la clase Marrón
        btnHomeOrgánico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent (Home.this,Marron.class);
                startActivity(intentHome);
                finish();
            }
        });

        //Procedimiento para llamar a la clase Gris
        btnHomeResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent (Home.this,Gris.class);
                startActivity(intentHome);
                finish();
            }
        });

        btnHomejuegareciclando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent (Home.this, CategoryMain.class);
                startActivity(intentHome);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}