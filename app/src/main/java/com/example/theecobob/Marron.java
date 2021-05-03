package com.example.theecobob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedHelperClass;

import java.util.ArrayList;
import java.util.Random;

public class Marron extends AppCompatActivity {

    //Variables para cartas
    RecyclerView featuredRecycler; //Si va en el contenedor marrón
    RecyclerView featuredRecycler2; //No va en el contenedor marrón

    //Variables para frases
    TextView frasesText;
    ImageButton btn_Generate;

    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marron);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler2 = findViewById(R.id.featured_recycler2);

        //Frases
        frasesText = findViewById(R.id.frasesMarron);
        btn_Generate = findViewById(R.id.btnGenerate);

        final String frases[] = {
                "Para reciclar la materia orgánica existen dos opciones posibles: su transformación en compost o en biogás.",
                "El compost puede aprovecharse como fertilizante e incluso como generador de energía."
        };

        btn_Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand= new Random();
                int Frases= rand.nextInt(2); //Total de frases
                frasesText.setText(frases[Frases]);
            }
        });

        //Llamamos a los métodos
        featuredRecycler(); // Sí va en el contenedor marrón
        featuredRecycler2(); //No va en el contenedor marrón
    }

    //Método para mostrar lo que si va el contenedor marrón

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        //Se crea array de objetos
        ArrayList<FeaturedHelperClass> featuredLocations= new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.organico1, "1)\tPieles de frutas y espinas de pescado","Así como otros desechos orgánicos"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.plantas, "Plantas", "Elementos que vienen de materias primas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.servilletas, "Servilletas", "Así como papel u otros provenientes de la cocina"));

        adapter=new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }

    //Método para mostrar lo que no va el contenedor amarillo

    private void featuredRecycler2() {
        featuredRecycler2.setHasFixedSize(true);
        featuredRecycler2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations= new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.ceramica,"Objetos de cerámica","Suelen confundirse mucho, pero no van aquí"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.panal,"Pañales","Así como compresas y tampones"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.cigarrillo,"Colillas","Son peligrosos porque pueden causar incendios"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.chicles,"Chicles","No proceden de materias primas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.toallitas,"Toallitas húmedas","Tampoco van aquí sino al resto"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.arena,"Arena para mascotas","Tanto de gatos como perros u otro animales domésticos"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.pelo,"Pelo","El cabello no es orgánico"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.polvo,"Polvo","Se debe depositar en el resto"));

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