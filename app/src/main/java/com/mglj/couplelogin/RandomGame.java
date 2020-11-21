package com.mglj.couplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class RandomGame extends AppCompatActivity {

    ImageView de_no_cancle, de_no_can, image_view;
    Button slot_Game, rulet_Game, scrach_Game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_game);

        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        image_view = (ImageView)findViewById(R.id.image_view);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);

        slot_Game = (Button)findViewById(R.id.slot_Game);
        rulet_Game = (Button)findViewById(R.id.rulet_Game);
        scrach_Game = (Button)findViewById(R.id.scrach_Game);

        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

            }
        });
        // 슬롯게임
        slot_Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), RandomGame_Gacha.class);
                startActivity(intent);
            }
        });
        // 룰렛게임
        rulet_Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), RandomGame_Rulet.class);
                startActivity(intent);
            }
        });
        // 즉석복권
        scrach_Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplication(), RandomGame_Scrach.class);
                startActivity(intent);

            }
        });

    }
}