package com.example.theecobob;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.theecobob.HelperClasses.HomeAdapter.FeaturedHelperClass;

import java.util.ArrayList;

public class Amarillo extends AppCompatActivity {
    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amarillo);


        //Hooks
        featuredRecycler=findViewById(R.id.featured_recycler);
        featuredRecycler();
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations= new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.envasesplasticosamarillos,"Plastico","asfasgasgagsagasgasgs"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.boobie_dibu_asustado,"Holita","asfasgasgagsagasgasgs"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.theecobob,"Holota","asfasgasgagsagasgasgs"));

        adapter=new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }
}