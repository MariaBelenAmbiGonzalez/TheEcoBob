package com.example.theecobob;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Duración de la SP en milisegundos
    private static int splashScreen = 5000;

    //Variables
    Animation top_animation;
    Animation bottom_animation;

    ImageView image;

    TextView logo;
    TextView slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animaciones
        top_animation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_animation = AnimationUtils.loadAnimation(this,R.anim.botton_animation);

        //Hooks
        image = findViewById(R.id.imageView);
        logo = findViewById(R.id.Logo);
        slogan = findViewById(R.id.Slogan);

        //Imagen de arriba
        image.setAnimation(top_animation);
        logo.setAnimation(bottom_animation);
        slogan.setAnimation(bottom_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class);

                Pair[]  pairs = new Pair[2];
                pairs [0] = new Pair<View,String>(image, "logo_image");
                pairs [1] = new Pair<View,String>(logo, "logo_text");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                }

            }
        } ,splashScreen);


    }


}