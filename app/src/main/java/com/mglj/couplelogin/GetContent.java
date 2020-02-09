package com.mglj.couplelogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class GetContent extends AppCompatActivity {

     Button btn_self50_info, btn_self100_info, btn_you50_info, btn_bucket10, btn_you50_info2, bucket30_move, btn_you100_info2,btn_you100_give;
     TextView text_logout;
    ImageView setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_content);

        btn_self50_info = (Button)findViewById(R.id.btn_self50_info);
        btn_self100_info = (Button)findViewById(R.id.btn_self100_info);
        btn_you50_info = (Button)findViewById(R.id.btn_you50_info);
        btn_bucket10 =(Button)findViewById(R.id.btn_bucket10);
        btn_you50_info2 =(Button)findViewById(R.id.btn_you50_info2);
        bucket30_move = (Button)findViewById(R.id.bucket30_move);
        btn_you100_info2 = (Button)findViewById(R.id.btn_you100_info2);
        btn_you100_give = (Button)findViewById(R.id.btn_you100_give);
        text_logout = (TextView)findViewById(R.id.text_logout);
        setting = (ImageView)findViewById(R.id.setting);

        Glide.with(this).load(R.drawable.setting).fitCenter().into(setting);

        btn_self50_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), self50_Info.class);
                startActivity(intent);

            }
        });

        btn_self100_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), self100_info.class);
                startActivity(intent);
            }
        });

        btn_you50_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), you50_info.class);
                startActivity(intent);

            }
        });

        btn_bucket10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),bucket10_Info.class);
                startActivity(intent);
            }
        });

        btn_you50_info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),you50_sendInfo.class);
                startActivity(intent);


            }
        });

        bucket30_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),bucket30_Info.class);
                startActivity(intent);
            }
        });

        btn_you100_info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),you100_info.class);
                startActivity(intent);
            }
        });

        btn_you100_give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),you100_send_info.class);
                startActivity(intent);
            }
        });

        text_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GetContent.this);
                builder.setMessage("로그아웃 하시겠습니까?")
                        .setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        SharedPreferences sharedPreferences = getSharedPreferences("LoginUser",MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("userID",""); // key, value를 이용하여 저장하는 형태
                        editor.putString("userPassword","");
                        editor.putString("userName","");
                        editor.putString("userSex","");
                        editor.putString("auto","");
                        editor.commit();

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);


                    }
                })
                        .create()
                        .show();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),setting.class);
                startActivity(intent);
            }
        });



    }
}
