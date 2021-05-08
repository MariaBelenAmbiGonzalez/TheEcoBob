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

public class Azul extends AppCompatActivity {

    //Variables para cartas
    RecyclerView featuredRecycler; //Si va en el contenedor azul
    RecyclerView featuredRecycler2; //No va en el contenedor azul

    //Variables para frases
    TextView frasesText;
    ImageButton btn_Generate;

    Button btnHomejuegareciclando;

    RecyclerView.Adapter adapter;

    //Oncreate es el equivalente al main de Java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azul);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler2 = findViewById(R.id.featured_recycler2);

        frasesText=findViewById(R.id.frasesAzul);
        btn_Generate=findViewById(R.id.btnGenerate);
        btnHomejuegareciclando = findViewById(R.id.btnjuegareciclando);

        final String frases[]={
                "El 71% de la madera que se usa para el papel procede de madera no certificada de fuentes controlada.",
                "Actualmente en España, se consume una media de 160 kg de papel por usuario y año",
                "Cada tonelada de papel que se recicla evita que se talen alrededor de 3,14 toneladas de árboles.",
                "Existen tipos de papel reciclado en función de la cantidad de fibra reciclada, pueden ser 100% reciclado o pueden tener papel reciclado y papel de fibra virgen. ",
                "Evita hacer impresiones por enviar documentos digitalmente.",
                "No imprimir las transacciones realizadas en los cajeros automáticos.",
                "Recibir vía email las facturas de pago como agua, luz.",
                "Sabías que el papel puede reciclarse hasta 11 veces",
                "27.000 árboles son talados cada día para hacer papel higiénico."
        };

        btn_Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand= new Random();
                int Frases= rand.nextInt(9); //Total de frases
                frasesText.setText(frases[Frases]);
            }
        });

        btnHomejuegareciclando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent (Azul.this, CategoryMain.class);
                startActivity(intentHome);
                finish();
            }
        });

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
        featuredLocations.add(new FeaturedHelperClass(R.drawable.papel5, "Hojas de cpapel", "Se deben depositar aunque tengan tinta"));

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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }
}