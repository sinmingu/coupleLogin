package com.mglj.couplelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RandomGame_Gacha extends AppCompatActivity {

    ImageView de_no_cancle, de_no_can;
    ViewPager2 viewPager2;
    Handler handler;
    String slot_data[] = {"삽겹살", "갈비", "맥주","빙수","빵","햄버거","치킨","소고기","간장게장","양념게장","컵라면", ""};
    int p = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_game__gacha);

        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);

        // 뒤로가기
        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        viewPager2=findViewById(R.id.pager); // xml의 id의 값을 불러옴
        ArrayList<DataPage> list=new ArrayList<>();
        list.add(new DataPage(R.drawable.apple_juice,"data1"));
        list.add(new DataPage(R.drawable.bacon,"data2"));
        list.add(new DataPage(R.drawable.beef,"data3"));
        viewPager2.setAdapter(new MyViewPagerAdapter(list));
        viewPager2.setCurrentItem(0); //화면에 보여질 페이지 설정
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL); // (페이지 넘어갈떄 가로,세로방향 설정)

        handler = new Handler() {

            @Override
            public void handleMessage(@NonNull Message msg) {
                if (p == 0) {
                    viewPager2.setCurrentItem(0);
                    p++;
                } else if (p == 1) {
                    viewPager2.setCurrentItem(1);
                    p++;
                } else if (p == 2) {
                    viewPager2.setCurrentItem(2);
                    p = 0;
                }
            }
        };

        Thread thread = new Thread("My thread") {

            @Override
            public void run() {

                while (true) {

                    Message message = handler.obtainMessage();

                    try {
                        handler.sendEmptyMessage(0);
                        Thread.sleep(2000);

                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
            }
        };
        thread.start();


    }
}