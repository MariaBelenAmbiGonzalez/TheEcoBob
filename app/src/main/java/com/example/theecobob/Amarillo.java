package com.example.theecobob;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedHelperClass;

import java.util.ArrayList;

public class Amarillo extends AppCompatActivity {
    //Variables para cartas
    RecyclerView featuredRecycler; //Si va en el contenedor amarillo
    RecyclerView featuredRecycler2; //No va en el contenedor amarillo

    RecyclerView.Adapter adapter;

    //Oncreate es el equivalente al main de Java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amarillo);

        //Hooks
        featuredRecycler=findViewById(R.id.featured_recycler);
        featuredRecycler2=findViewById(R.id.featured_recycler2);

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
}