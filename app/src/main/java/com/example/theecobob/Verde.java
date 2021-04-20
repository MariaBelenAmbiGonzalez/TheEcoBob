package com.example.theecobob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedHelperClass;

import java.util.ArrayList;

public class Verde extends AppCompatActivity {

    //Variables para cartas
    RecyclerView featuredRecycler; //Si va en el contenedor verde
    RecyclerView featuredRecycler2; //No va en el contenedor verde

    RecyclerView.Adapter adapter;


    //Oncreate es el equivalente al main de Java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verde);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler2 = findViewById(R.id.featured_recycler2);

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