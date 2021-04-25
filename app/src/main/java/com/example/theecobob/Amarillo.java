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

public class Amarillo extends AppCompatActivity {
    //Variables para cartas
    RecyclerView featuredRecycler; //Si va en el contenedor amarillo
    RecyclerView featuredRecycler2; //No va en el contenedor amarillo

    //Variables para frases
    TextView frasesText;
    ImageButton btn_Generate;

    RecyclerView.Adapter adapter;

    //Oncreate es el equivalente al main de Java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amarillo);

        //Hooks
        featuredRecycler=findViewById(R.id.featured_recycler);
        featuredRecycler2=findViewById(R.id.featured_recycler2);
        //Frases
        frasesText=findViewById(R.id.frasesAmarillo);
        btn_Generate=findViewById(R.id.btnGenerate);

        final String frases[]={
                "Cada minuto se usan cerca de un millón de bolsas de plástico en el mundo.",
                "Se pueden llegar a necesitar cerca de 1.000 años para que la naturaleza consiga eliminar el plástico.",
                "Menos del 5% de las bolsas del plástico son recicladas cada año.",
                "Decenas de miles de toneladas de plástico flotan por los océanos en el mundo.",
                "Los animales que consumen plástico provoca que haya casa vez más especies en peligro de extinción, como peces, tortugas y aves.",
                "El 40% del plástico que se usa para envases son de 1 solo uso.",
                "La mitad del plástico fabricado ha sido a partir del año 2000.",
                "Entre el 8-10% de la producción de petróleo se utiliza para fabricar plástico.",
                "Reciclando 6 latas o briks se contrarresta la emisión de 10 minutos de un tubo de escape."
        };

        btn_Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand= new Random();
                int Frases= rand.nextInt(9); //Total de frases
                frasesText.setText(frases[Frases]);
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

        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico1,"Botellas y envases de plástico","Vasos y platos de plástico típicos de reuniones"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico2,"Bolsas de plástico","Excepto las bolsas de basura \n"
                + "Tarrinas de plástico \n"
                + "Tapas de yogurt"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico3,"Tapas y tapones de plástico","Tubos de pasta de dientes \n"
                + "Papel film y de aluminio \n"
                + "Bandejas de corcho blanco"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico4,"Envases metálicos","Aerosoles \n"
                + "Latas de conserva y de bebidas"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico5,"Bandejas de aluminio","Botes de desodorante \n"
                + "Yogur plástico"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico6,"Briks: de leche, zumos, sopas","Consejo: plegalas antes de tirarlas para aprovechar espacios"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico7,"Otros","Cajas de madera para fruta \n"
                + "Cartuchos de cera depilatoria\n"
                + "Malla de frutas\n"
                + "Precinto de botellas vino y cava"));


        adapter=new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);
    }

    //Método para mostrar lo que no va el contenedor amarillo

    private void featuredRecycler2() {
        featuredRecycler2.setHasFixedSize(true);
        featuredRecycler2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations= new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico8,"Juguetes de plástico","Existen fundaciones donde donar los juguetes y darles una segunda vida"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico9,"Biberones y chupetes","Se debe depositar en el resto"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico10,"Utensilios de cocina","Se debe depositar en el resto"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.plastico11,"Cubos de plástico","Se debe depositar en el resto"));

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