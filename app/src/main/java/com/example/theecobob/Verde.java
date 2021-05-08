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

public class Verde extends AppCompatActivity {

    //Variables para cartas
    RecyclerView featuredRecycler; //Si va en el contenedor verde
    RecyclerView featuredRecycler2; //No va en el contenedor verde

    //Variables para frases
    TextView frasesText;
    ImageButton btn_Generate;

    Button btnHomejuegareciclando;


    RecyclerView.Adapter adapter;


    //Oncreate es el equivalente al main de Java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verde);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler2 = findViewById(R.id.featured_recycler2);

        frasesText=findViewById(R.id.frasesVerde);
        btn_Generate=findViewById(R.id.btnGenerate);
        btnHomejuegareciclando = findViewById(R.id.btnjuegareciclando);

        final String frases[]={
                "El vidrio es 100% reciclable y se puede utilizar una y otra vez.",
                "El vidrio se separa en colores porque el conserva su color incluso después de reciclado.",
                "Una botella de vidrio ahorra energía para una bombilla de 100 vatios durante 4 horas.",
                "Una botella de vidrio moderna puede tardar más de 4000 años en descomponerse.",
                "En el 2021 se recicla un 30% más de vidrio en los últimos cinco años en España.",
                "En España existen 230.950 contenedores para reciclar envases de vidrio.",
                "En España cada ciudadano depositó en el contenedor verde 19kg de vidrio en el 2019."
        };
        btn_Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand= new Random();
                int Frases= rand.nextInt(7); //Total de frases
                frasesText.setText(frases[Frases]); }
        });

        btnHomejuegareciclando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent (Verde.this, CategoryMain.class);
                startActivity(intentHome);
                finish();
            }
        });

        //Llamamos a los métodos
        featuredRecycler(); // Sí va en el contenedor verde
        featuredRecycler2(); //No va en el contenedor verde
    }

    //Método para mostrar lo que si va el contenedor azul
    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //Se crea array de objetos
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.vidrio1, "Botellas", "Vino\n"
            + "Cava\n"
            + "Licores\n"
            + "Cervezas\n"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.vidrio2, "Frascos de perfumes", "Colonias\n"
            + "Cremas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.vidrio3, "Tarros de mermelada", "Conservas\n"
            + "Vegetales"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }

    //Método para mostrar lo que no va el contenedor verde

    private void featuredRecycler2() {
        featuredRecycler2.setHasFixedSize(true);
        featuredRecycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.vidrio4, "Bombillas", "Deben llevarse al punto limpio o centros de recogida"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.vidrio5,"Espejos","Deben llevarse al punto limpio o centros de recogida"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.vidrio6,"Ceniceros","Deben llevarse al punto limpio o centros de recogida"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.vidrio7,"Vasos y vajillas","Deben llevarse al punto limpio o centros de recogida"));

        adapter=new FeaturedAdapter(featuredLocations);
        featuredRecycler2.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }

}