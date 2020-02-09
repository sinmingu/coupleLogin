package com.mglj.couplelogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Question_self extends AppCompatActivity {

    Button question_50, question_100;
    ImageView img_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_self);

        question_50 = (Button)findViewById(R.id.question_50);
        question_100 = (Button)findViewById(R.id.question_100);
        img_test = (ImageView)findViewById(R.id.img_test);
        Glide.with(this).load(R.drawable.infologo).fitCenter().into(img_test);

        question_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Question_self_50.class);
                startActivity(intent);
            }
        });

        question_100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Question_self_100.class);
                startActivity(intent);

            }
        });

    }
}
