package com.example.theecobob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedHelperClass;

import java.util.ArrayList;

public class Azul extends AppCompatActivity {

    //Variables para cartas
    RecyclerView featuredRecycler; //Si va en el contenedor azul
    RecyclerView featuredRecycler2; //No va en el contenedor azul

    RecyclerView.Adapter adapter;


    //Oncreate es el equivalente al main de Java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azul);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler2 = findViewById(R.id.featured_recycler2);

        //Llamamos a los métodos
        featuredRecycler(); // Sí va en el contenedor azul
        featuredRecycler2(); //No va en el contenedor azul
    }

    //Método para mostrar lo que si va el contenedor azul
    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //Se crea array de objetos
        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.papel1, "Envases de alimentación", "Aunque estén usados se deben depositar en el papel"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.papel2, "Cajas de cartón", "De todo tipo como de calzado también"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.papel3, "Envases de productos congelados", "Se deben depositar aunque estén mojados o tengan tinta de color. "));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.papel4, "Papel de regalo","Se debe quitar los pedazos de cinta adhesiva"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.papel5, "Hojas de papel", "Se deben depositar aunque tengan tinta"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }

    //Método para mostrar lo que no va el contenedor azul

    private void featuredRecycler2() {
        featuredRecycler2.setHasFixedSize(true);
        featuredRecycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.papel7, "Servilletas de cocina", "Se deben depositar en los desechos orgánicos"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico6,"Bricks","Muchas veces se suelen confundir, pero su lugar es el contenedor amarillo"));

        adapter=new FeaturedAdapter(featuredLocations);
        featuredRecycler2.setAdapter(adapter);
    }
}