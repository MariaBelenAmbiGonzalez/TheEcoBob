package com.example.theecobob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Duración de la SP en milisegundos
    private static int splashScreen = 5000;

    //Variables
    Animation top_animation, bottom_animation;
    ImageView image;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animaciones
        top_animation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_animation = AnimationUtils.loadAnimation(this,R.anim.botton_animation);

        //Hooks
        image = findViewById(R.id.imageView2);
        logo = findViewById(R.id.Logo);
        slogan = findViewById(R.id.Slogan);

        //Imagen de arriba
        image.setAnimation(top_animation);
        logo.setAnimation(bottom_animation);
        slogan.setAnimation(bottom_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,DashBoard.class);
                startActivity(intent);
                finish();
            }
        } ,splashScreen);


    }


}