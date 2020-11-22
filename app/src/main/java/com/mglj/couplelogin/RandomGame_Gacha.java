package com.mglj.couplelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RandomGame_Gacha extends AppCompatActivity {

    ImageView de_no_cancle, de_no_can, btn_rabber;
    ViewPager2 viewPager2;
    Handler handler;
    String slot_data[] = {"삽겹살", "갈비", "맥주","빙수","빵","햄버거","치킨","소고기","간장게장","양념게장","컵라면", ""};
    TextView slot_text, btnNewGame;
    boolean lever_status = true;
    int p = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_game__gacha);

        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        btn_rabber = (ImageView)findViewById(R.id.btn_rabber);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);
        Glide.with(this).load(R.drawable.lever).fitCenter().into(btn_rabber);
        slot_text = (TextView)findViewById(R.id.slot_text);
        btnNewGame = (TextView)findViewById(R.id.btnNewGame);

        // 뒤로가기
        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        viewPager2=findViewById(R.id.pager); // xml의 id의 값을 불러옴
        final ArrayList<DataPage> list=new ArrayList<>();
        list.add(new DataPage(R.drawable.apple_juice,"사과주스"));
        list.add(new DataPage(R.drawable.bacon,"삽겹살"));
        list.add(new DataPage(R.drawable.beef,"갈비"));
        list.add(new DataPage(R.drawable.beer,"맥주"));
        list.add(new DataPage(R.drawable.bingsu,"팥빙수"));
        list.add(new DataPage(R.drawable.bread,"빵"));
        list.add(new DataPage(R.drawable.burger,"햄버거"));
        viewPager2.setAdapter(new MyViewPagerAdapter(list));
        viewPager2.setCurrentItem(0); //화면에 보여질 페이지 설정
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL); // (페이지 넘어갈떄 가로,세로방향 설정)

        //버튼 클릭시 이벤트
        btn_rabber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getApplicationContext()).load(R.drawable.leverover).fitCenter().into(btn_rabber);
                lever_status = false;
            }
        });

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RandomGame_Gacha.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        handler = new Handler() {

            @Override
            public void handleMessage(@NonNull Message msg) {
//                if (p == 0) {
//                    viewPager2.setCurrentItem(0);
//                    p++;
//                } else if (p == 1) {
//                    viewPager2.setCurrentItem(1);
//                    p++;
//                } else if (p == 2) {
//                    viewPager2.setCurrentItem(2);
//                    p = 0;
//                }
                viewPager2.setCurrentItem(p);
                slot_text.setText(list.get(p).getTitle());
                Log.d("SMG","값 : "+list.get(p).getTitle()+"리스트 : "+ p );
                p++;
                if(p==list.size())
                    p=0;

            }
        };

        Thread thread = new Thread("My thread") {

            @Override
            public void run() {

                while (lever_status) {

                    Message message = handler.obtainMessage();

                    try {
                        handler.sendEmptyMessage(0);
                        Thread.sleep(200);

                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
            }
        };
        thread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();

        lever_status = false;
    }
}