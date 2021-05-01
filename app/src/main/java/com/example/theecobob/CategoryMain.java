

package com.example.theecobob;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.theecobob.databinding.ActivityCategoryMainBinding;

import java.util.ArrayList;

public class CategoryMain extends AppCompatActivity {

    ActivityCategoryMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);


        ArrayList<CategoryModel> categories = new ArrayList<>();
        categories.add(new CategoryModel("", "Plástico", "https://cdn.dribbble.com/users/427368/screenshots/14114331/dribbble.jpg"));
        categories.add(new CategoryModel("", "Papel", "https://cdn.dribbble.com/users/427368/screenshots/14114331/dribbble.jpg"));
        categories.add(new CategoryModel("", "Vidrio", "https://cdn.dribbble.com/users/427368/screenshots/14114331/dribbble.jpg"));
        categories.add(new CategoryModel("", "Organico", "https://cdn.dribbble.com/users/427368/screenshots/14114331/dribbble.jpg"));
        categories.add(new CategoryModel("", "Resto", "https://cdn.dribbble.com/users/427368/screenshots/14114331/dribbble.jpg"));

        CategoryAdapter adapter = new CategoryAdapter(this, categories);
        binding.categoryList.setLayoutManager((new GridLayoutManager(this, 2)));
        binding.categoryList.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.wallet) {
            Toast.makeText(this, "Cartera seleccionada.", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}