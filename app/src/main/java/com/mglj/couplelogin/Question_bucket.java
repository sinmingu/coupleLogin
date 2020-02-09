package com.mglj.couplelogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Question_bucket extends AppCompatActivity {

    Button question_10, question_30;
    ImageView img_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bucket);

        question_10 = (Button)findViewById(R.id.question_10);
        question_30 = (Button)findViewById(R.id.question_30);
        img_test = (ImageView)findViewById(R.id.img_test);
        Glide.with(this).load(R.drawable.infologo).fitCenter().into(img_test);

        question_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Question_bucket_10.class);
                startActivity(intent);

            }
        });

        question_30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Question_bucket_30.class);
                startActivity(intent);

            }
        });

    }
}
