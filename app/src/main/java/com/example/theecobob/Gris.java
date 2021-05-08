package com.example.theecobob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedHelperClass;

import java.util.ArrayList;
import java.util.Random;

public class Gris extends AppCompatActivity {

    //Variables para cartas
    RecyclerView featuredRecycler; //Si va en el contenedor
    RecyclerView featuredRecycler2; //No va en el contenedor

    //Variables para frases
    TextView frasesText;
    ImageButton btn_Generate;

    Button btnHomejuegareciclando;

    RecyclerView.Adapter adapter;

    //Oncreate es el equivalente al main de Java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gris);

        //Hooks
        featuredRecycler=findViewById(R.id.featured_recycler);
        featuredRecycler2=findViewById(R.id.featured_recycler2);
        //Frases
        frasesText=findViewById(R.id.frasesGris);
        btn_Generate=findViewById(R.id.btnGenerate);
        btnHomejuegareciclando = findViewById(R.id.btnjuegareciclando);

        final String frases[]={
               "Covid 19: las mascarillas y otros elementos aquí",
                "La fracción no reciclable o resto incluye todos los residuos domésticos que no tienen cabida en el resto de contenedores"
        };

        btn_Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand= new Random();
                int Frases= rand.nextInt(2); //Total de frases
                frasesText.setText(frases[Frases]);
            }
        });

        btnHomejuegareciclando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent (Gris.this, CategoryMain.class);
                startActivity(intentHome);
                finish();
            }
        });

        //Llamamos a los métodos
        featuredRecycler(); // Sí va en el contenedor amarillo
        featuredRecycler2(); //No va en el contenedor amarillo
    }

    //Método para mostrar lo que si va el contenedor amarillo

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        //Se crea array de objetos
        ArrayList<FeaturedHelperClass> featuredLocations= new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.juguetes,"Juguetes",""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.biberones,"Biberones y chupetes",""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.cocina,"Utensilios de cocin",""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.panal,"Pañales y compresas",""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.ceramica,"Objetos cerámicos",""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.arena,"Arena para mascotas",""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.pelo,"Pelo",""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.polvo,"Polvo",""));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.cigarrillo,"Colillas",""));


        adapter=new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }

    //Método para mostrar lo que no va el contenedor amarillo

    private void featuredRecycler2() {
        featuredRecycler2.setHasFixedSize(true);
        featuredRecycler2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations= new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.pilas,"Pilas","Otros elementos tecnológicos contenedores de químicos como uranio, titanio, etc"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.farmacocaducado,"Fármacos caducados","Deben llevarse a un punto limpio"));

        adapter=new FeaturedAdapter(featuredLocations);
        featuredRecycler2.setAdapter(adapter);

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
        finish();
    }
}