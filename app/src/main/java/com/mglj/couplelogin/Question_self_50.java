package com.mglj.couplelogin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.mglj.couplelogin.SerchActivity.LoginUserID;

public class Question_self_50 extends AppCompatActivity {

    TabHost reg_tabHost;
    ImageView de_no_cancle, de_no_can, back_page, next_page;
    ViewPager vp;
    List<Self50> self50List;
    TextView btn_save, btn_send;
    TextView text_page;
    int page;

    InterstitialAd adfull;

    EditText edit_you50_1, edit_you50_2, edit_you50_3, edit_you50_4, edit_you50_5, edit_you50_6, edit_you50_7, edit_you50_8, edit_you50_9, edit_you50_10,
            edit_you50_11, edit_you50_12,edit_you50_13, edit_you50_14, edit_you50_15, edit_you50_16, edit_you50_17, edit_you50_18, edit_you50_19, edit_you50_20,
            edit_you50_21, edit_you50_22, edit_you50_23, edit_you50_24, edit_you50_25, edit_you50_26, edit_you50_27, edit_you50_28, edit_you50_29, edit_you50_30,
            edit_you50_31, edit_you50_32, edit_you50_33, edit_you50_34, edit_you50_35, edit_you50_36, edit_you50_37, edit_you50_38, edit_you50_39, edit_you50_40,
            edit_you50_41, edit_you50_42, edit_you50_43, edit_you50_44, edit_you50_45, edit_you50_46, edit_you50_47, edit_you50_48, edit_you50_49, edit_you50_50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_self_50);

        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);

        back_page = (ImageView)findViewById(R.id.back_page);
        next_page = (ImageView)findViewById(R.id.next_page);
        text_page = (TextView)findViewById(R.id.text_page);

        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);
        Glide.with(this).load(R.drawable.back_2).fitCenter().into(back_page);
        Glide.with(this).load(R.drawable.next_2).fitCenter().into(next_page);

        adfull = new InterstitialAd(this);
        adfull.setAdUnitId("ca-app-pub-5784293657699097/5193862959");
        adfull.loadAd(new AdRequest.Builder().build());

        edit_you50_1 = (EditText)findViewById(R.id.edit_you50_1);
        edit_you50_2 = (EditText)findViewById(R.id.edit_you50_2);
        edit_you50_3 = (EditText)findViewById(R.id.edit_you50_3);
        edit_you50_4 = (EditText)findViewById(R.id.edit_you50_4);
        edit_you50_5 = (EditText)findViewById(R.id.edit_you50_5);
        edit_you50_6 = (EditText)findViewById(R.id.edit_you50_6);
        edit_you50_7 = (EditText)findViewById(R.id.edit_you50_7);
        edit_you50_8 = (EditText)findViewById(R.id.edit_you50_8);
        edit_you50_9 = (EditText)findViewById(R.id.edit_you50_9);
        edit_you50_10 = (EditText)findViewById(R.id.edit_you50_10);
        edit_you50_11 = (EditText)findViewById(R.id.edit_you50_11);
        edit_you50_12 = (EditText)findViewById(R.id.edit_you50_12);
        edit_you50_13 = (EditText)findViewById(R.id.edit_you50_13);
        edit_you50_14 = (EditText)findViewById(R.id.edit_you50_14);
        edit_you50_15 = (EditText)findViewById(R.id.edit_you50_15);
        edit_you50_16 = (EditText)findViewById(R.id.edit_you50_16);
        edit_you50_17 = (EditText)findViewById(R.id.edit_you50_17);
        edit_you50_18 = (EditText)findViewById(R.id.edit_you50_18);
        edit_you50_19 = (EditText)findViewById(R.id.edit_you50_19);
        edit_you50_20 = (EditText)findViewById(R.id.edit_you50_20);
        edit_you50_21 = (EditText)findViewById(R.id.edit_you50_21);
        edit_you50_22 = (EditText)findViewById(R.id.edit_you50_22);
        edit_you50_23 = (EditText)findViewById(R.id.edit_you50_23);
        edit_you50_24 = (EditText)findViewById(R.id.edit_you50_24);
        edit_you50_25 = (EditText)findViewById(R.id.edit_you50_25);
        edit_you50_26 = (EditText)findViewById(R.id.edit_you50_26);
        edit_you50_27 = (EditText)findViewById(R.id.edit_you50_27);
        edit_you50_28 = (EditText)findViewById(R.id.edit_you50_28);
        edit_you50_29 = (EditText)findViewById(R.id.edit_you50_29);
        edit_you50_30 = (EditText)findViewById(R.id.edit_you50_30);
        edit_you50_31 = (EditText)findViewById(R.id.edit_you50_31);
        edit_you50_32 = (EditText)findViewById(R.id.edit_you50_32);
        edit_you50_33 = (EditText)findViewById(R.id.edit_you50_33);
        edit_you50_34 = (EditText)findViewById(R.id.edit_you50_34);
        edit_you50_35 = (EditText)findViewById(R.id.edit_you50_35);
        edit_you50_36 = (EditText)findViewById(R.id.edit_you50_36);
        edit_you50_37 = (EditText)findViewById(R.id.edit_you50_37);
        edit_you50_38 = (EditText)findViewById(R.id.edit_you50_38);
        edit_you50_39 = (EditText)findViewById(R.id.edit_you50_39);
        edit_you50_40 = (EditText)findViewById(R.id.edit_you50_40);
        edit_you50_41 = (EditText)findViewById(R.id.edit_you50_41);
        edit_you50_42 = (EditText)findViewById(R.id.edit_you50_42);
        edit_you50_43 = (EditText)findViewById(R.id.edit_you50_43);
        edit_you50_44 = (EditText)findViewById(R.id.edit_you50_44);
        edit_you50_45 = (EditText)findViewById(R.id.edit_you50_45);
        edit_you50_46 = (EditText)findViewById(R.id.edit_you50_46);
        edit_you50_47 = (EditText)findViewById(R.id.edit_you50_47);
        edit_you50_48 = (EditText)findViewById(R.id.edit_you50_48);
        edit_you50_49 = (EditText)findViewById(R.id.edit_you50_49);
        edit_you50_50 = (EditText)findViewById(R.id.edit_you50_50);

        btn_save = (TextView)findViewById(R.id.btn_save);
        btn_send = (TextView)findViewById(R.id.btn_send);

        //-----------------------탭 호스트 시작------------------------------

        reg_tabHost = (TabHost)findViewById(R.id.reg_tab_host);

        reg_tabHost.setup();

        // 홈 탭
        TabHost.TabSpec reg_tabSpec1 = reg_tabHost.newTabSpec("Tab1");
        reg_tabSpec1.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec1.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec1.setContent(R.id.reg_tab_view1); // Tab Content
        reg_tabHost.addTab(reg_tabSpec1);

        // 일정 탭
        final TabHost.TabSpec reg_tabSpec2 = reg_tabHost.newTabSpec("Tab2");
        reg_tabSpec2.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec2.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec2.setContent(R.id.reg_tab_view2); // Tab Content
        reg_tabHost.addTab(reg_tabSpec2);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec3 = reg_tabHost.newTabSpec("Tab3");
        reg_tabSpec3.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec3.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec3.setContent(R.id.reg_tab_view3); // Tab Content
        reg_tabHost.addTab(reg_tabSpec3);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec4 = reg_tabHost.newTabSpec("Tab4");
        reg_tabSpec4.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec4.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec4.setContent(R.id.reg_tab_view4); // Tab Content
        reg_tabHost.addTab(reg_tabSpec4);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec5 = reg_tabHost.newTabSpec("Tab5");
        reg_tabSpec5.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec5.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec5.setContent(R.id.reg_tab_view5); // Tab Content
        reg_tabHost.addTab(reg_tabSpec5);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec6 = reg_tabHost.newTabSpec("Tab6");
        reg_tabSpec6.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec6.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec6.setContent(R.id.reg_tab_view6); // Tab Content
        reg_tabHost.addTab(reg_tabSpec6);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec7 = reg_tabHost.newTabSpec("Tab7");
        reg_tabSpec7.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec7.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec7.setContent(R.id.reg_tab_view7); // Tab Content
        reg_tabHost.addTab(reg_tabSpec7);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec8 = reg_tabHost.newTabSpec("Tab8");
        reg_tabSpec8.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec8.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec8.setContent(R.id.reg_tab_view8); // Tab Content
        reg_tabHost.addTab(reg_tabSpec8);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec9 = reg_tabHost.newTabSpec("Tab9");
        reg_tabSpec9.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec9.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec9.setContent(R.id.reg_tab_view9); // Tab Content
        reg_tabHost.addTab(reg_tabSpec9);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec10 = reg_tabHost.newTabSpec("Tab10");
        reg_tabSpec10.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec10.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec10.setContent(R.id.reg_tab_view10); // Tab Content
        reg_tabHost.addTab(reg_tabSpec10);


        reg_tabHost.getTabWidget().getChildAt(0)

                .setBackgroundColor(Color.parseColor("#ffffff"));


        reg_tabHost.getTabWidget().getChildAt(1)

                .setBackgroundColor(Color.parseColor("#ffffff"));

        reg_tabHost.getTabWidget().getChildAt(2)

                .setBackgroundColor(Color.parseColor("#ffffff"));

        reg_tabHost.setCurrentTab(0); // 처음 열리는 탭

        text_page.setText(page+1 +" / 10");
        new BackgroundTask_you50List().execute();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new BackgroundTask_roomList().execute();


            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(adfull.isLoaded()){
                    adfull.show();
                };
                new BackgroundTask_roomList().execute();
                new BackgroundTask_send().execute();



            }
        });

        back_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page==0){
                    Toast.makeText(getApplicationContext(),"최소 입니다",Toast.LENGTH_SHORT).show();
                }
                else {
                    page-=1;
                    reg_tabHost.setCurrentTab(page);
                    text_page.setText(page+1 +" / 10");

                }
            }
        });

        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page==9){
                    Toast.makeText(getApplicationContext(),"최대 입니다",Toast.LENGTH_SHORT).show();
                }
                else {
                    page+=1;
                    reg_tabHost.setCurrentTab(page);
                    text_page.setText(page+1 +" / 10");

                }
            }
        });



        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void self50(){
        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10,
                answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
        answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30,
        answer31, answer32, answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40,
        answer41, answer42, answer43, answer44, answer45, answer46, answer47, answer48, answer49, answer50;

        if(edit_you50_1.getText().toString().equals("")){
            answer1 = "미응답";
        }
        else
            answer1=edit_you50_1.getText().toString();

        if(edit_you50_2.getText().toString().equals("")){
            answer2 = "미응답";
        }
        else
            answer2=edit_you50_2.getText().toString();

        if(edit_you50_3.getText().toString().equals("")){
            answer3 = "미응답";
        }
        else
            answer3=edit_you50_3.getText().toString();

        if(edit_you50_4.getText().toString().equals("")){
            answer4 = "미응답";
        }
        else
            answer4=edit_you50_4.getText().toString();

        if(edit_you50_5.getText().toString().equals("")){
            answer5 = "미응답";
        }
        else
            answer5=edit_you50_5.getText().toString();

        if(edit_you50_6.getText().toString().equals("")){
            answer6 = "미응답";
        }
        else
            answer6=edit_you50_6.getText().toString();

        if(edit_you50_7.getText().toString().equals("")){
            answer7 = "미응답";
        }
        else
            answer7=edit_you50_7.getText().toString();

        if(edit_you50_8.getText().toString().equals("")){
            answer8 = "미응답";
        }
        else
            answer8=edit_you50_8.getText().toString();

        if(edit_you50_9.getText().toString().equals("")){
            answer9 = "미응답";
        }
        else
            answer9=edit_you50_9.getText().toString();

        if(edit_you50_10.getText().toString().equals("")){
            answer10 = "미응답";
        }
        else
            answer10=edit_you50_10.getText().toString();

        if(edit_you50_11.getText().toString().equals("")){
            answer11 = "미응답";
        }
        else
            answer11=edit_you50_11.getText().toString();

        if(edit_you50_12.getText().toString().equals("")){
            answer12 = "미응답";
        }
        else
            answer12=edit_you50_12.getText().toString();

        if(edit_you50_13.getText().toString().equals("")){
            answer13 = "미응답";
        }
        else
            answer13=edit_you50_13.getText().toString();

        if(edit_you50_14.getText().toString().equals("")){
            answer14 = "미응답";
        }
        else
            answer14=edit_you50_14.getText().toString();

        if(edit_you50_15.getText().toString().equals("")){
            answer15 = "미응답";
        }
        else
            answer15=edit_you50_15.getText().toString();

        if(edit_you50_16.getText().toString().equals("")){
            answer16 = "미응답";
        }
        else
            answer16=edit_you50_16.getText().toString();

        if(edit_you50_17.getText().toString().equals("")){
            answer17 = "미응답";
        }
        else
            answer17=edit_you50_17.getText().toString();

        if(edit_you50_18.getText().toString().equals("")){
            answer18 = "미응답";
        }
        else
            answer18=edit_you50_18.getText().toString();

        if(edit_you50_19.getText().toString().equals("")){
            answer19 = "미응답";
        }
        else
            answer19=edit_you50_19.getText().toString();

        if(edit_you50_20.getText().toString().equals("")){
            answer20 = "미응답";
        }
        else
            answer20=edit_you50_20.getText().toString();


        if(edit_you50_21.getText().toString().equals("")){
            answer21 = "미응답";
        }
        else
            answer21=edit_you50_21.getText().toString();

        if(edit_you50_22.getText().toString().equals("")){
            answer22 = "미응답";
        }
        else
            answer22=edit_you50_22.getText().toString();

        if(edit_you50_23.getText().toString().equals("")){
            answer23 = "미응답";
        }
        else
            answer23=edit_you50_23.getText().toString();

        if(edit_you50_24.getText().toString().equals("")){
            answer24 = "미응답";
        }
        else
            answer24=edit_you50_24.getText().toString();

        if(edit_you50_25.getText().toString().equals("")){
            answer25 = "미응답";
        }
        else
            answer25=edit_you50_25.getText().toString();

        if(edit_you50_26.getText().toString().equals("")){
            answer26 = "미응답";
        }
        else
            answer26=edit_you50_26.getText().toString();

        if(edit_you50_27.getText().toString().equals("")){
            answer27 = "미응답";
        }
        else
            answer27=edit_you50_27.getText().toString();

        if(edit_you50_28.getText().toString().equals("")){
            answer28 = "미응답";
        }
        else
            answer28=edit_you50_28.getText().toString();

        if(edit_you50_29.getText().toString().equals("")){
            answer29 = "미응답";
        }
        else
            answer29=edit_you50_29.getText().toString();

        if(edit_you50_30.getText().toString().equals("")){
            answer30 = "미응답";
        }
        else
            answer30=edit_you50_30.getText().toString();


        if(edit_you50_31.getText().toString().equals("")){
            answer31 = "미응답";
        }
        else
            answer31=edit_you50_31.getText().toString();

        if(edit_you50_32.getText().toString().equals("")){
            answer32 = "미응답";
        }
        else
            answer32=edit_you50_32.getText().toString();

        if(edit_you50_33.getText().toString().equals("")){
            answer33 = "미응답";
        }
        else
            answer33=edit_you50_33.getText().toString();

        if(edit_you50_34.getText().toString().equals("")){
            answer34 = "미응답";
        }
        else
            answer34=edit_you50_34.getText().toString();

        if(edit_you50_35.getText().toString().equals("")){
            answer35 = "미응답";
        }
        else
            answer35=edit_you50_35.getText().toString();

        if(edit_you50_36.getText().toString().equals("")){
            answer36 = "미응답";
        }
        else
            answer36=edit_you50_36.getText().toString();

        if(edit_you50_37.getText().toString().equals("")){
            answer37 = "미응답";
        }
        else
            answer37=edit_you50_37.getText().toString();

        if(edit_you50_38.getText().toString().equals("")){
            answer38 = "미응답";
        }
        else
            answer38=edit_you50_38.getText().toString();

        if(edit_you50_39.getText().toString().equals("")){
            answer39 = "미응답";
        }
        else
            answer39=edit_you50_39.getText().toString();

        if(edit_you50_40.getText().toString().equals("")){
            answer40 = "미응답";
        }
        else
            answer40=edit_you50_40.getText().toString();

        if(edit_you50_41.getText().toString().equals("")){
            answer41 = "미응답";
        }
        else
            answer41=edit_you50_41.getText().toString();

        if(edit_you50_42.getText().toString().equals("")){
            answer42 = "미응답";
        }
        else
            answer42=edit_you50_42.getText().toString();

        if(edit_you50_43.getText().toString().equals("")){
            answer43 = "미응답";
        }
        else
            answer43=edit_you50_43.getText().toString();

        if(edit_you50_44.getText().toString().equals("")){
            answer44 = "미응답";
        }
        else
            answer44=edit_you50_44.getText().toString();

        if(edit_you50_45.getText().toString().equals("")){
            answer45 = "미응답";
        }
        else
            answer45=edit_you50_45.getText().toString();

        if(edit_you50_46.getText().toString().equals("")){
            answer46 = "미응답";
        }
        else
            answer46=edit_you50_46.getText().toString();

        if(edit_you50_47.getText().toString().equals("")){
            answer47 = "미응답";
        }
        else
            answer47=edit_you50_47.getText().toString();

        if(edit_you50_48.getText().toString().equals("")){
            answer48 = "미응답";
        }
        else
            answer48=edit_you50_48.getText().toString();

        if(edit_you50_49.getText().toString().equals("")){
            answer49 = "미응답";
        }
        else
            answer49=edit_you50_49.getText().toString();

        if(edit_you50_50.getText().toString().equals("")){
            answer50 = "미응답";
        }
        else
            answer50=edit_you50_50.getText().toString();



        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSave customDialog = new CustomDialogSave(Question_self_50.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_self_50.this);
                        builder.setMessage("회원 등록에 실패했습니다.")
                                .setNegativeButton("다시 시도", null)
                                .create()
                                .show();

                    }
                }
                catch(JSONException e ){
                    e.getStackTrace();
                }
            }
        };

        Self50AddRequest registerRequest = new Self50AddRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32,
                answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40, answer41, answer42, answer43,
                answer44, answer45, answer46, answer47, answer48, answer49, answer50,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_self_50.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }

    public void self50_update(){
        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10,
                answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30,
                answer31, answer32, answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40,
                answer41, answer42, answer43, answer44, answer45, answer46, answer47, answer48, answer49, answer50;


        if(edit_you50_1.getText().toString().equals("")){
            answer1 = "미응답";
        }
        else
            answer1=edit_you50_1.getText().toString();

        if(edit_you50_2.getText().toString().equals("")){
            answer2 = "미응답";
        }
        else
            answer2=edit_you50_2.getText().toString();

        if(edit_you50_3.getText().toString().equals("")){
            answer3 = "미응답";
        }
        else
            answer3=edit_you50_3.getText().toString();

        if(edit_you50_4.getText().toString().equals("")){
            answer4 = "미응답";
        }
        else
            answer4=edit_you50_4.getText().toString();

        if(edit_you50_5.getText().toString().equals("")){
            answer5 = "미응답";
        }
        else
            answer5=edit_you50_5.getText().toString();

        if(edit_you50_6.getText().toString().equals("")){
            answer6 = "미응답";
        }
        else
            answer6=edit_you50_6.getText().toString();

        if(edit_you50_7.getText().toString().equals("")){
            answer7 = "미응답";
        }
        else
            answer7=edit_you50_7.getText().toString();

        if(edit_you50_8.getText().toString().equals("")){
            answer8 = "미응답";
        }
        else
            answer8=edit_you50_8.getText().toString();

        if(edit_you50_9.getText().toString().equals("")){
            answer9 = "미응답";
        }
        else
            answer9=edit_you50_9.getText().toString();

        if(edit_you50_10.getText().toString().equals("")){
            answer10 = "미응답";
        }
        else
            answer10=edit_you50_10.getText().toString();

        if(edit_you50_11.getText().toString().equals("")){
            answer11 = "미응답";
        }
        else
            answer11=edit_you50_11.getText().toString();

        if(edit_you50_12.getText().toString().equals("")){
            answer12 = "미응답";
        }
        else
            answer12=edit_you50_12.getText().toString();

        if(edit_you50_13.getText().toString().equals("")){
            answer13 = "미응답";
        }
        else
            answer13=edit_you50_13.getText().toString();

        if(edit_you50_14.getText().toString().equals("")){
            answer14 = "미응답";
        }
        else
            answer14=edit_you50_14.getText().toString();

        if(edit_you50_15.getText().toString().equals("")){
            answer15 = "미응답";
        }
        else
            answer15=edit_you50_15.getText().toString();

        if(edit_you50_16.getText().toString().equals("")){
            answer16 = "미응답";
        }
        else
            answer16=edit_you50_16.getText().toString();

        if(edit_you50_17.getText().toString().equals("")){
            answer17 = "미응답";
        }
        else
            answer17=edit_you50_17.getText().toString();

        if(edit_you50_18.getText().toString().equals("")){
            answer18 = "미응답";
        }
        else
            answer18=edit_you50_18.getText().toString();

        if(edit_you50_19.getText().toString().equals("")){
            answer19 = "미응답";
        }
        else
            answer19=edit_you50_19.getText().toString();

        if(edit_you50_20.getText().toString().equals("")){
            answer20 = "미응답";
        }
        else
            answer20=edit_you50_20.getText().toString();


        if(edit_you50_21.getText().toString().equals("")){
            answer21 = "미응답";
        }
        else
            answer21=edit_you50_21.getText().toString();

        if(edit_you50_22.getText().toString().equals("")){
            answer22 = "미응답";
        }
        else
            answer22=edit_you50_22.getText().toString();

        if(edit_you50_23.getText().toString().equals("")){
            answer23 = "미응답";
        }
        else
            answer23=edit_you50_23.getText().toString();

        if(edit_you50_24.getText().toString().equals("")){
            answer24 = "미응답";
        }
        else
            answer24=edit_you50_24.getText().toString();

        if(edit_you50_25.getText().toString().equals("")){
            answer25 = "미응답";
        }
        else
            answer25=edit_you50_25.getText().toString();

        if(edit_you50_26.getText().toString().equals("")){
            answer26 = "미응답";
        }
        else
            answer26=edit_you50_26.getText().toString();

        if(edit_you50_27.getText().toString().equals("")){
            answer27 = "미응답";
        }
        else
            answer27=edit_you50_27.getText().toString();

        if(edit_you50_28.getText().toString().equals("")){
            answer28 = "미응답";
        }
        else
            answer28=edit_you50_28.getText().toString();

        if(edit_you50_29.getText().toString().equals("")){
            answer29 = "미응답";
        }
        else
            answer29=edit_you50_29.getText().toString();

        if(edit_you50_30.getText().toString().equals("")){
            answer30 = "미응답";
        }
        else
            answer30=edit_you50_30.getText().toString();


        if(edit_you50_31.getText().toString().equals("")){
            answer31 = "미응답";
        }
        else
            answer31=edit_you50_31.getText().toString();

        if(edit_you50_32.getText().toString().equals("")){
            answer32 = "미응답";
        }
        else
            answer32=edit_you50_32.getText().toString();

        if(edit_you50_33.getText().toString().equals("")){
            answer33 = "미응답";
        }
        else
            answer33=edit_you50_33.getText().toString();

        if(edit_you50_34.getText().toString().equals("")){
            answer34 = "미응답";
        }
        else
            answer34=edit_you50_34.getText().toString();

        if(edit_you50_35.getText().toString().equals("")){
            answer35 = "미응답";
        }
        else
            answer35=edit_you50_35.getText().toString();

        if(edit_you50_36.getText().toString().equals("")){
            answer36 = "미응답";
        }
        else
            answer36=edit_you50_36.getText().toString();

        if(edit_you50_37.getText().toString().equals("")){
            answer37 = "미응답";
        }
        else
            answer37=edit_you50_37.getText().toString();

        if(edit_you50_38.getText().toString().equals("")){
            answer38 = "미응답";
        }
        else
            answer38=edit_you50_38.getText().toString();

        if(edit_you50_39.getText().toString().equals("")){
            answer39 = "미응답";
        }
        else
            answer39=edit_you50_39.getText().toString();

        if(edit_you50_40.getText().toString().equals("")){
            answer40 = "미응답";
        }
        else
            answer40=edit_you50_40.getText().toString();

        if(edit_you50_41.getText().toString().equals("")){
            answer41 = "미응답";
        }
        else
            answer41=edit_you50_41.getText().toString();

        if(edit_you50_42.getText().toString().equals("")){
            answer42 = "미응답";
        }
        else
            answer42=edit_you50_42.getText().toString();

        if(edit_you50_43.getText().toString().equals("")){
            answer43 = "미응답";
        }
        else
            answer43=edit_you50_43.getText().toString();

        if(edit_you50_44.getText().toString().equals("")){
            answer44 = "미응답";
        }
        else
            answer44=edit_you50_44.getText().toString();

        if(edit_you50_45.getText().toString().equals("")){
            answer45 = "미응답";
        }
        else
            answer45=edit_you50_45.getText().toString();

        if(edit_you50_46.getText().toString().equals("")){
            answer46 = "미응답";
        }
        else
            answer46=edit_you50_46.getText().toString();

        if(edit_you50_47.getText().toString().equals("")){
            answer47 = "미응답";
        }
        else
            answer47=edit_you50_47.getText().toString();

        if(edit_you50_48.getText().toString().equals("")){
            answer48 = "미응답";
        }
        else
            answer48=edit_you50_48.getText().toString();

        if(edit_you50_49.getText().toString().equals("")){
            answer49 = "미응답";
        }
        else
            answer49=edit_you50_49.getText().toString();

        if(edit_you50_50.getText().toString().equals("")){
            answer50 = "미응답";
        }
        else
            answer50=edit_you50_50.getText().toString();



        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSave customDialog = new CustomDialogSave(Question_self_50.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_self_50.this);
                        builder.setMessage("회원 등록에 실패했습니다.")
                                .setNegativeButton("다시 시도", null)
                                .create()
                                .show();

                    }
                }
                catch(JSONException e ){
                    e.getStackTrace();
                }
            }
        };

        Self50UpdateRequest registerRequest = new Self50UpdateRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32,
                answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40, answer41, answer42, answer43,
                answer44, answer45, answer46, answer47, answer48, answer49, answer50,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_self_50.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }

    // 채팅방
    class BackgroundTask_roomList extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_self50List.php";
        }

        @Override
        protected String doInBackground(Void... voids) {

            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine())!= null){
                    stringBuilder.append((temp + "\n"));
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            }
            catch(Exception e){
                e.getStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {

            self50List = new ArrayList<Self50>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                        self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                        self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                        self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                        self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    self50Num = object.getString("self50Num");
                    self50ID = object.getString("self50ID");
                    self50Send = object.getString("self50Send");
                    self50Answer1 = object.getString("self50Answer1");
                    self50Answer2 = object.getString("self50Answer2");
                    self50Answer3 = object.getString("self50Answer3");
                    self50Answer4 = object.getString("self50Answer4");
                    self50Answer5 = object.getString("self50Answer5");
                    self50Answer6 = object.getString("self50Answer6");
                    self50Answer7 = object.getString("self50Answer7");
                    self50Answer8 = object.getString("self50Answer8");
                    self50Answer9 = object.getString("self50Answer9");
                    self50Answer10 = object.getString("self50Answer10");
                    self50Answer11 = object.getString("self50Answer11");
                    self50Answer12 = object.getString("self50Answer12");
                    self50Answer13 = object.getString("self50Answer13");
                    self50Answer14 = object.getString("self50Answer14");
                    self50Answer15 = object.getString("self50Answer15");
                    self50Answer16 = object.getString("self50Answer16");
                    self50Answer17 = object.getString("self50Answer17");
                    self50Answer18 = object.getString("self50Answer18");
                    self50Answer19 = object.getString("self50Answer19");
                    self50Answer20 = object.getString("self50Answer20");
                    self50Answer21 = object.getString("self50Answer21");
                    self50Answer22 = object.getString("self50Answer22");
                    self50Answer23 = object.getString("self50Answer23");
                    self50Answer24 = object.getString("self50Answer24");
                    self50Answer25 = object.getString("self50Answer25");
                    self50Answer26 = object.getString("self50Answer26");
                    self50Answer27 = object.getString("self50Answer27");
                    self50Answer28 = object.getString("self50Answer28");
                    self50Answer29 = object.getString("self50Answer29");
                    self50Answer30 = object.getString("self50Answer30");
                    self50Answer31 = object.getString("self50Answer31");
                    self50Answer32 = object.getString("self50Answer32");
                    self50Answer33 = object.getString("self50Answer33");
                    self50Answer34 = object.getString("self50Answer34");
                    self50Answer35 = object.getString("self50Answer35");
                    self50Answer36 = object.getString("self50Answer36");
                    self50Answer37 = object.getString("self50Answer37");
                    self50Answer38 = object.getString("self50Answer38");
                    self50Answer39 = object.getString("self50Answer39");
                    self50Answer40 = object.getString("self50Answer40");
                    self50Answer41 = object.getString("self50Answer41");
                    self50Answer42 = object.getString("self50Answer42");
                    self50Answer43 = object.getString("self50Answer43");
                    self50Answer44 = object.getString("self50Answer44");
                    self50Answer45 = object.getString("self50Answer45");
                    self50Answer46 = object.getString("self50Answer46");
                    self50Answer47 = object.getString("self50Answer47");
                    self50Answer48 = object.getString("self50Answer48");
                    self50Answer49 = object.getString("self50Answer49");
                    self50Answer50 = object.getString("self50Answer50");

                    if(self50ID.equals(LoginUserID)) {
                        Self50 self50 = new Self50(self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                                self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                                self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                                self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                                self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50);
                        self50List.add(self50);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(self50List.size()>=1){
                self50_update();
            }
            else if(self50List.size()==0){
                self50();
            }




        }

    }


    public void self50_send(){
        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10,
                answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30,
                answer31, answer32, answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40,
                answer41, answer42, answer43, answer44, answer45, answer46, answer47, answer48, answer49, answer50;


        if(edit_you50_1.getText().toString().equals("")){
            answer1 = "미응답";
        }
        else
            answer1=edit_you50_1.getText().toString();

        if(edit_you50_2.getText().toString().equals("")){
            answer2 = "미응답";
        }
        else
            answer2=edit_you50_2.getText().toString();

        if(edit_you50_3.getText().toString().equals("")){
            answer3 = "미응답";
        }
        else
            answer3=edit_you50_3.getText().toString();

        if(edit_you50_4.getText().toString().equals("")){
            answer4 = "미응답";
        }
        else
            answer4=edit_you50_4.getText().toString();

        if(edit_you50_5.getText().toString().equals("")){
            answer5 = "미응답";
        }
        else
            answer5=edit_you50_5.getText().toString();

        if(edit_you50_6.getText().toString().equals("")){
            answer6 = "미응답";
        }
        else
            answer6=edit_you50_6.getText().toString();

        if(edit_you50_7.getText().toString().equals("")){
            answer7 = "미응답";
        }
        else
            answer7=edit_you50_7.getText().toString();

        if(edit_you50_8.getText().toString().equals("")){
            answer8 = "미응답";
        }
        else
            answer8=edit_you50_8.getText().toString();

        if(edit_you50_9.getText().toString().equals("")){
            answer9 = "미응답";
        }
        else
            answer9=edit_you50_9.getText().toString();

        if(edit_you50_10.getText().toString().equals("")){
            answer10 = "미응답";
        }
        else
            answer10=edit_you50_10.getText().toString();

        if(edit_you50_11.getText().toString().equals("")){
            answer11 = "미응답";
        }
        else
            answer11=edit_you50_11.getText().toString();

        if(edit_you50_12.getText().toString().equals("")){
            answer12 = "미응답";
        }
        else
            answer12=edit_you50_12.getText().toString();

        if(edit_you50_13.getText().toString().equals("")){
            answer13 = "미응답";
        }
        else
            answer13=edit_you50_13.getText().toString();

        if(edit_you50_14.getText().toString().equals("")){
            answer14 = "미응답";
        }
        else
            answer14=edit_you50_14.getText().toString();

        if(edit_you50_15.getText().toString().equals("")){
            answer15 = "미응답";
        }
        else
            answer15=edit_you50_15.getText().toString();

        if(edit_you50_16.getText().toString().equals("")){
            answer16 = "미응답";
        }
        else
            answer16=edit_you50_16.getText().toString();

        if(edit_you50_17.getText().toString().equals("")){
            answer17 = "미응답";
        }
        else
            answer17=edit_you50_17.getText().toString();

        if(edit_you50_18.getText().toString().equals("")){
            answer18 = "미응답";
        }
        else
            answer18=edit_you50_18.getText().toString();

        if(edit_you50_19.getText().toString().equals("")){
            answer19 = "미응답";
        }
        else
            answer19=edit_you50_19.getText().toString();

        if(edit_you50_20.getText().toString().equals("")){
            answer20 = "미응답";
        }
        else
            answer20=edit_you50_20.getText().toString();


        if(edit_you50_21.getText().toString().equals("")){
            answer21 = "미응답";
        }
        else
            answer21=edit_you50_21.getText().toString();

        if(edit_you50_22.getText().toString().equals("")){
            answer22 = "미응답";
        }
        else
            answer22=edit_you50_22.getText().toString();

        if(edit_you50_23.getText().toString().equals("")){
            answer23 = "미응답";
        }
        else
            answer23=edit_you50_23.getText().toString();

        if(edit_you50_24.getText().toString().equals("")){
            answer24 = "미응답";
        }
        else
            answer24=edit_you50_24.getText().toString();

        if(edit_you50_25.getText().toString().equals("")){
            answer25 = "미응답";
        }
        else
            answer25=edit_you50_25.getText().toString();

        if(edit_you50_26.getText().toString().equals("")){
            answer26 = "미응답";
        }
        else
            answer26=edit_you50_26.getText().toString();

        if(edit_you50_27.getText().toString().equals("")){
            answer27 = "미응답";
        }
        else
            answer27=edit_you50_27.getText().toString();

        if(edit_you50_28.getText().toString().equals("")){
            answer28 = "미응답";
        }
        else
            answer28=edit_you50_28.getText().toString();

        if(edit_you50_29.getText().toString().equals("")){
            answer29 = "미응답";
        }
        else
            answer29=edit_you50_29.getText().toString();

        if(edit_you50_30.getText().toString().equals("")){
            answer30 = "미응답";
        }
        else
            answer30=edit_you50_30.getText().toString();


        if(edit_you50_31.getText().toString().equals("")){
            answer31 = "미응답";
        }
        else
            answer31=edit_you50_31.getText().toString();

        if(edit_you50_32.getText().toString().equals("")){
            answer32 = "미응답";
        }
        else
            answer32=edit_you50_32.getText().toString();

        if(edit_you50_33.getText().toString().equals("")){
            answer33 = "미응답";
        }
        else
            answer33=edit_you50_33.getText().toString();

        if(edit_you50_34.getText().toString().equals("")){
            answer34 = "미응답";
        }
        else
            answer34=edit_you50_34.getText().toString();

        if(edit_you50_35.getText().toString().equals("")){
            answer35 = "미응답";
        }
        else
            answer35=edit_you50_35.getText().toString();

        if(edit_you50_36.getText().toString().equals("")){
            answer36 = "미응답";
        }
        else
            answer36=edit_you50_36.getText().toString();

        if(edit_you50_37.getText().toString().equals("")){
            answer37 = "미응답";
        }
        else
            answer37=edit_you50_37.getText().toString();

        if(edit_you50_38.getText().toString().equals("")){
            answer38 = "미응답";
        }
        else
            answer38=edit_you50_38.getText().toString();

        if(edit_you50_39.getText().toString().equals("")){
            answer39 = "미응답";
        }
        else
            answer39=edit_you50_39.getText().toString();

        if(edit_you50_40.getText().toString().equals("")){
            answer40 = "미응답";
        }
        else
            answer40=edit_you50_40.getText().toString();

        if(edit_you50_41.getText().toString().equals("")){
            answer41 = "미응답";
        }
        else
            answer41=edit_you50_41.getText().toString();

        if(edit_you50_42.getText().toString().equals("")){
            answer42 = "미응답";
        }
        else
            answer42=edit_you50_42.getText().toString();

        if(edit_you50_43.getText().toString().equals("")){
            answer43 = "미응답";
        }
        else
            answer43=edit_you50_43.getText().toString();

        if(edit_you50_44.getText().toString().equals("")){
            answer44 = "미응답";
        }
        else
            answer44=edit_you50_44.getText().toString();

        if(edit_you50_45.getText().toString().equals("")){
            answer45 = "미응답";
        }
        else
            answer45=edit_you50_45.getText().toString();

        if(edit_you50_46.getText().toString().equals("")){
            answer46 = "미응답";
        }
        else
            answer46=edit_you50_46.getText().toString();

        if(edit_you50_47.getText().toString().equals("")){
            answer47 = "미응답";
        }
        else
            answer47=edit_you50_47.getText().toString();

        if(edit_you50_48.getText().toString().equals("")){
            answer48 = "미응답";
        }
        else
            answer48=edit_you50_48.getText().toString();

        if(edit_you50_49.getText().toString().equals("")){
            answer49 = "미응답";
        }
        else
            answer49=edit_you50_49.getText().toString();

        if(edit_you50_50.getText().toString().equals("")){
            answer50 = "미응답";
        }
        else
            answer50=edit_you50_50.getText().toString();



        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogUpdate customDialog = new CustomDialogUpdate(Question_self_50.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_self_50.this);
                        builder.setMessage("회원 등록에 실패했습니다.")
                                .setNegativeButton("다시 시도", null)
                                .create()
                                .show();

                    }
                }
                catch(JSONException e ){
                    e.getStackTrace();
                }
            }
        };

        Self50SendAddRequest registerRequest = new Self50SendAddRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32,
                answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40, answer41, answer42, answer43,
                answer44, answer45, answer46, answer47, answer48, answer49, answer50,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_self_50.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }

    public void self50_update_send(){
        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10,
                answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30,
                answer31, answer32, answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40,
                answer41, answer42, answer43, answer44, answer45, answer46, answer47, answer48, answer49, answer50;


        if(edit_you50_1.getText().toString().equals("")){
            answer1 = "미응답";
        }
        else
            answer1=edit_you50_1.getText().toString();

        if(edit_you50_2.getText().toString().equals("")){
            answer2 = "미응답";
        }
        else
            answer2=edit_you50_2.getText().toString();

        if(edit_you50_3.getText().toString().equals("")){
            answer3 = "미응답";
        }
        else
            answer3=edit_you50_3.getText().toString();

        if(edit_you50_4.getText().toString().equals("")){
            answer4 = "미응답";
        }
        else
            answer4=edit_you50_4.getText().toString();

        if(edit_you50_5.getText().toString().equals("")){
            answer5 = "미응답";
        }
        else
            answer5=edit_you50_5.getText().toString();

        if(edit_you50_6.getText().toString().equals("")){
            answer6 = "미응답";
        }
        else
            answer6=edit_you50_6.getText().toString();

        if(edit_you50_7.getText().toString().equals("")){
            answer7 = "미응답";
        }
        else
            answer7=edit_you50_7.getText().toString();

        if(edit_you50_8.getText().toString().equals("")){
            answer8 = "미응답";
        }
        else
            answer8=edit_you50_8.getText().toString();

        if(edit_you50_9.getText().toString().equals("")){
            answer9 = "미응답";
        }
        else
            answer9=edit_you50_9.getText().toString();

        if(edit_you50_10.getText().toString().equals("")){
            answer10 = "미응답";
        }
        else
            answer10=edit_you50_10.getText().toString();

        if(edit_you50_11.getText().toString().equals("")){
            answer11 = "미응답";
        }
        else
            answer11=edit_you50_11.getText().toString();

        if(edit_you50_12.getText().toString().equals("")){
            answer12 = "미응답";
        }
        else
            answer12=edit_you50_12.getText().toString();

        if(edit_you50_13.getText().toString().equals("")){
            answer13 = "미응답";
        }
        else
            answer13=edit_you50_13.getText().toString();

        if(edit_you50_14.getText().toString().equals("")){
            answer14 = "미응답";
        }
        else
            answer14=edit_you50_14.getText().toString();

        if(edit_you50_15.getText().toString().equals("")){
            answer15 = "미응답";
        }
        else
            answer15=edit_you50_15.getText().toString();

        if(edit_you50_16.getText().toString().equals("")){
            answer16 = "미응답";
        }
        else
            answer16=edit_you50_16.getText().toString();

        if(edit_you50_17.getText().toString().equals("")){
            answer17 = "미응답";
        }
        else
            answer17=edit_you50_17.getText().toString();

        if(edit_you50_18.getText().toString().equals("")){
            answer18 = "미응답";
        }
        else
            answer18=edit_you50_18.getText().toString();

        if(edit_you50_19.getText().toString().equals("")){
            answer19 = "미응답";
        }
        else
            answer19=edit_you50_19.getText().toString();

        if(edit_you50_20.getText().toString().equals("")){
            answer20 = "미응답";
        }
        else
            answer20=edit_you50_20.getText().toString();


        if(edit_you50_21.getText().toString().equals("")){
            answer21 = "미응답";
        }
        else
            answer21=edit_you50_21.getText().toString();

        if(edit_you50_22.getText().toString().equals("")){
            answer22 = "미응답";
        }
        else
            answer22=edit_you50_22.getText().toString();

        if(edit_you50_23.getText().toString().equals("")){
            answer23 = "미응답";
        }
        else
            answer23=edit_you50_23.getText().toString();

        if(edit_you50_24.getText().toString().equals("")){
            answer24 = "미응답";
        }
        else
            answer24=edit_you50_24.getText().toString();

        if(edit_you50_25.getText().toString().equals("")){
            answer25 = "미응답";
        }
        else
            answer25=edit_you50_25.getText().toString();

        if(edit_you50_26.getText().toString().equals("")){
            answer26 = "미응답";
        }
        else
            answer26=edit_you50_26.getText().toString();

        if(edit_you50_27.getText().toString().equals("")){
            answer27 = "미응답";
        }
        else
            answer27=edit_you50_27.getText().toString();

        if(edit_you50_28.getText().toString().equals("")){
            answer28 = "미응답";
        }
        else
            answer28=edit_you50_28.getText().toString();

        if(edit_you50_29.getText().toString().equals("")){
            answer29 = "미응답";
        }
        else
            answer29=edit_you50_29.getText().toString();

        if(edit_you50_30.getText().toString().equals("")){
            answer30 = "미응답";
        }
        else
            answer30=edit_you50_30.getText().toString();


        if(edit_you50_31.getText().toString().equals("")){
            answer31 = "미응답";
        }
        else
            answer31=edit_you50_31.getText().toString();

        if(edit_you50_32.getText().toString().equals("")){
            answer32 = "미응답";
        }
        else
            answer32=edit_you50_32.getText().toString();

        if(edit_you50_33.getText().toString().equals("")){
            answer33 = "미응답";
        }
        else
            answer33=edit_you50_33.getText().toString();

        if(edit_you50_34.getText().toString().equals("")){
            answer34 = "미응답";
        }
        else
            answer34=edit_you50_34.getText().toString();

        if(edit_you50_35.getText().toString().equals("")){
            answer35 = "미응답";
        }
        else
            answer35=edit_you50_35.getText().toString();

        if(edit_you50_36.getText().toString().equals("")){
            answer36 = "미응답";
        }
        else
            answer36=edit_you50_36.getText().toString();

        if(edit_you50_37.getText().toString().equals("")){
            answer37 = "미응답";
        }
        else
            answer37=edit_you50_37.getText().toString();

        if(edit_you50_38.getText().toString().equals("")){
            answer38 = "미응답";
        }
        else
            answer38=edit_you50_38.getText().toString();

        if(edit_you50_39.getText().toString().equals("")){
            answer39 = "미응답";
        }
        else
            answer39=edit_you50_39.getText().toString();

        if(edit_you50_40.getText().toString().equals("")){
            answer40 = "미응답";
        }
        else
            answer40=edit_you50_40.getText().toString();

        if(edit_you50_41.getText().toString().equals("")){
            answer41 = "미응답";
        }
        else
            answer41=edit_you50_41.getText().toString();

        if(edit_you50_42.getText().toString().equals("")){
            answer42 = "미응답";
        }
        else
            answer42=edit_you50_42.getText().toString();

        if(edit_you50_43.getText().toString().equals("")){
            answer43 = "미응답";
        }
        else
            answer43=edit_you50_43.getText().toString();

        if(edit_you50_44.getText().toString().equals("")){
            answer44 = "미응답";
        }
        else
            answer44=edit_you50_44.getText().toString();

        if(edit_you50_45.getText().toString().equals("")){
            answer45 = "미응답";
        }
        else
            answer45=edit_you50_45.getText().toString();

        if(edit_you50_46.getText().toString().equals("")){
            answer46 = "미응답";
        }
        else
            answer46=edit_you50_46.getText().toString();

        if(edit_you50_47.getText().toString().equals("")){
            answer47 = "미응답";
        }
        else
            answer47=edit_you50_47.getText().toString();

        if(edit_you50_48.getText().toString().equals("")){
            answer48 = "미응답";
        }
        else
            answer48=edit_you50_48.getText().toString();

        if(edit_you50_49.getText().toString().equals("")){
            answer49 = "미응답";
        }
        else
            answer49=edit_you50_49.getText().toString();

        if(edit_you50_50.getText().toString().equals("")){
            answer50 = "미응답";
        }
        else
            answer50=edit_you50_50.getText().toString();



        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogUpdate customDialog = new CustomDialogUpdate(Question_self_50.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();


                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_self_50.this);
                        builder.setMessage("회원 등록에 실패했습니다.")
                                .setNegativeButton("다시 시도", null)
                                .create()
                                .show();

                    }
                }
                catch(JSONException e ){
                    e.getStackTrace();
                }
            }
        };

        Self50SendUpdateRequest registerRequest = new Self50SendUpdateRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32,
                answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40, answer41, answer42, answer43,
                answer44, answer45, answer46, answer47, answer48, answer49, answer50,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_self_50.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------
    }


    // 채팅방
    class BackgroundTask_send extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_self50SendList.php";
        }

        @Override
        protected String doInBackground(Void... voids) {

            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine())!= null){
                    stringBuilder.append((temp + "\n"));
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            }
            catch(Exception e){
                e.getStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {

            self50List = new ArrayList<Self50>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                        self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                        self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                        self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                        self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    self50Num = object.getString("self50Num");
                    self50ID = object.getString("self50ID");
                    self50Send = object.getString("self50Send");
                    self50Answer1 = object.getString("self50Answer1");
                    self50Answer2 = object.getString("self50Answer2");
                    self50Answer3 = object.getString("self50Answer3");
                    self50Answer4 = object.getString("self50Answer4");
                    self50Answer5 = object.getString("self50Answer5");
                    self50Answer6 = object.getString("self50Answer6");
                    self50Answer7 = object.getString("self50Answer7");
                    self50Answer8 = object.getString("self50Answer8");
                    self50Answer9 = object.getString("self50Answer9");
                    self50Answer10 = object.getString("self50Answer10");
                    self50Answer11 = object.getString("self50Answer11");
                    self50Answer12 = object.getString("self50Answer12");
                    self50Answer13 = object.getString("self50Answer13");
                    self50Answer14 = object.getString("self50Answer14");
                    self50Answer15 = object.getString("self50Answer15");
                    self50Answer16 = object.getString("self50Answer16");
                    self50Answer17 = object.getString("self50Answer17");
                    self50Answer18 = object.getString("self50Answer18");
                    self50Answer19 = object.getString("self50Answer19");
                    self50Answer20 = object.getString("self50Answer20");
                    self50Answer21 = object.getString("self50Answer21");
                    self50Answer22 = object.getString("self50Answer22");
                    self50Answer23 = object.getString("self50Answer23");
                    self50Answer24 = object.getString("self50Answer24");
                    self50Answer25 = object.getString("self50Answer25");
                    self50Answer26 = object.getString("self50Answer26");
                    self50Answer27 = object.getString("self50Answer27");
                    self50Answer28 = object.getString("self50Answer28");
                    self50Answer29 = object.getString("self50Answer29");
                    self50Answer30 = object.getString("self50Answer30");
                    self50Answer31 = object.getString("self50Answer31");
                    self50Answer32 = object.getString("self50Answer32");
                    self50Answer33 = object.getString("self50Answer33");
                    self50Answer34 = object.getString("self50Answer34");
                    self50Answer35 = object.getString("self50Answer35");
                    self50Answer36 = object.getString("self50Answer36");
                    self50Answer37 = object.getString("self50Answer37");
                    self50Answer38 = object.getString("self50Answer38");
                    self50Answer39 = object.getString("self50Answer39");
                    self50Answer40 = object.getString("self50Answer40");
                    self50Answer41 = object.getString("self50Answer41");
                    self50Answer42 = object.getString("self50Answer42");
                    self50Answer43 = object.getString("self50Answer43");
                    self50Answer44 = object.getString("self50Answer44");
                    self50Answer45 = object.getString("self50Answer45");
                    self50Answer46 = object.getString("self50Answer46");
                    self50Answer47 = object.getString("self50Answer47");
                    self50Answer48 = object.getString("self50Answer48");
                    self50Answer49 = object.getString("self50Answer49");
                    self50Answer50 = object.getString("self50Answer50");

                    if(self50ID.equals(LoginUserID)) {
                        Self50 self50 = new Self50(self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                                self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                                self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                                self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                                self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50);
                        self50List.add(self50);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(self50List.size()>=1){
                self50_update_send();
            }
            else if(self50List.size()==0){
                self50_send();
            }

        }

    }
    // 채팅방
    class BackgroundTask_you50List extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_self50List.php";
        }

        @Override
        protected String doInBackground(Void... voids) {

            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine())!= null){
                    stringBuilder.append((temp + "\n"));
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            }
            catch(Exception e){
                e.getStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {

            self50List = new ArrayList<Self50>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                        self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                        self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                        self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                        self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    self50Num = object.getString("self50Num");
                    self50ID = object.getString("self50ID");
                    self50Send = object.getString("self50Send");
                    self50Answer1 = object.getString("self50Answer1");
                    self50Answer2 = object.getString("self50Answer2");
                    self50Answer3 = object.getString("self50Answer3");
                    self50Answer4 = object.getString("self50Answer4");
                    self50Answer5 = object.getString("self50Answer5");
                    self50Answer6 = object.getString("self50Answer6");
                    self50Answer7 = object.getString("self50Answer7");
                    self50Answer8 = object.getString("self50Answer8");
                    self50Answer9 = object.getString("self50Answer9");
                    self50Answer10 = object.getString("self50Answer10");
                    self50Answer11 = object.getString("self50Answer11");
                    self50Answer12 = object.getString("self50Answer12");
                    self50Answer13 = object.getString("self50Answer13");
                    self50Answer14 = object.getString("self50Answer14");
                    self50Answer15 = object.getString("self50Answer15");
                    self50Answer16 = object.getString("self50Answer16");
                    self50Answer17 = object.getString("self50Answer17");
                    self50Answer18 = object.getString("self50Answer18");
                    self50Answer19 = object.getString("self50Answer19");
                    self50Answer20 = object.getString("self50Answer20");
                    self50Answer21 = object.getString("self50Answer21");
                    self50Answer22 = object.getString("self50Answer22");
                    self50Answer23 = object.getString("self50Answer23");
                    self50Answer24 = object.getString("self50Answer24");
                    self50Answer25 = object.getString("self50Answer25");
                    self50Answer26 = object.getString("self50Answer26");
                    self50Answer27 = object.getString("self50Answer27");
                    self50Answer28 = object.getString("self50Answer28");
                    self50Answer29 = object.getString("self50Answer29");
                    self50Answer30 = object.getString("self50Answer30");
                    self50Answer31 = object.getString("self50Answer31");
                    self50Answer32 = object.getString("self50Answer32");
                    self50Answer33 = object.getString("self50Answer33");
                    self50Answer34 = object.getString("self50Answer34");
                    self50Answer35 = object.getString("self50Answer35");
                    self50Answer36 = object.getString("self50Answer36");
                    self50Answer37 = object.getString("self50Answer37");
                    self50Answer38 = object.getString("self50Answer38");
                    self50Answer39 = object.getString("self50Answer39");
                    self50Answer40 = object.getString("self50Answer40");
                    self50Answer41 = object.getString("self50Answer41");
                    self50Answer42 = object.getString("self50Answer42");
                    self50Answer43 = object.getString("self50Answer43");
                    self50Answer44 = object.getString("self50Answer44");
                    self50Answer45 = object.getString("self50Answer45");
                    self50Answer46 = object.getString("self50Answer46");
                    self50Answer47 = object.getString("self50Answer47");
                    self50Answer48 = object.getString("self50Answer48");
                    self50Answer49 = object.getString("self50Answer49");
                    self50Answer50 = object.getString("self50Answer50");

                    if(self50ID.equals(LoginUserID)) {
                        Self50 self100 = new Self50(self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                                self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                                self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                                self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                                self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50);
                        self50List.add(self100);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }
            if(self50List.size()>=1) {
                edit_you50_1.setText(self50List.get(0).getSelf50Answer1());
                edit_you50_2.setText(self50List.get(0).getSelf50Answer2());
                edit_you50_3.setText(self50List.get(0).getSelf50Answer3());
                edit_you50_4.setText(self50List.get(0).getSelf50Answer4());
                edit_you50_5.setText(self50List.get(0).getSelf50Answer5());
                edit_you50_6.setText(self50List.get(0).getSelf50Answer6());
                edit_you50_7.setText(self50List.get(0).getSelf50Answer7());
                edit_you50_8.setText(self50List.get(0).getSelf50Answer8());
                edit_you50_9.setText(self50List.get(0).getSelf50Answer9());
                edit_you50_10.setText(self50List.get(0).getSelf50Answer10());
                edit_you50_11.setText(self50List.get(0).getSelf50Answer11());
                edit_you50_12.setText(self50List.get(0).getSelf50Answer12());
                edit_you50_13.setText(self50List.get(0).getSelf50Answer13());
                edit_you50_14.setText(self50List.get(0).getSelf50Answer14());
                edit_you50_15.setText(self50List.get(0).getSelf50Answer15());
                edit_you50_16.setText(self50List.get(0).getSelf50Answer16());
                edit_you50_17.setText(self50List.get(0).getSelf50Answer17());
                edit_you50_18.setText(self50List.get(0).getSelf50Answer18());
                edit_you50_19.setText(self50List.get(0).getSelf50Answer19());
                edit_you50_20.setText(self50List.get(0).getSelf50Answer20());
                edit_you50_21.setText(self50List.get(0).getSelf50Answer21());
                edit_you50_22.setText(self50List.get(0).getSelf50Answer22());
                edit_you50_23.setText(self50List.get(0).getSelf50Answer23());
                edit_you50_24.setText(self50List.get(0).getSelf50Answer24());
                edit_you50_25.setText(self50List.get(0).getSelf50Answer25());
                edit_you50_26.setText(self50List.get(0).getSelf50Answer26());
                edit_you50_27.setText(self50List.get(0).getSelf50Answer27());
                edit_you50_28.setText(self50List.get(0).getSelf50Answer28());
                edit_you50_29.setText(self50List.get(0).getSelf50Answer29());
                edit_you50_30.setText(self50List.get(0).getSelf50Answer30());
                edit_you50_31.setText(self50List.get(0).getSelf50Answer31());
                edit_you50_32.setText(self50List.get(0).getSelf50Answer32());
                edit_you50_33.setText(self50List.get(0).getSelf50Answer33());
                edit_you50_34.setText(self50List.get(0).getSelf50Answer34());
                edit_you50_35.setText(self50List.get(0).getSelf50Answer35());
                edit_you50_36.setText(self50List.get(0).getSelf50Answer36());
                edit_you50_37.setText(self50List.get(0).getSelf50Answer37());
                edit_you50_38.setText(self50List.get(0).getSelf50Answer38());
                edit_you50_39.setText(self50List.get(0).getSelf50Answer39());
                edit_you50_40.setText(self50List.get(0).getSelf50Answer40());
                edit_you50_41.setText(self50List.get(0).getSelf50Answer41());
                edit_you50_42.setText(self50List.get(0).getSelf50Answer42());
                edit_you50_43.setText(self50List.get(0).getSelf50Answer43());
                edit_you50_44.setText(self50List.get(0).getSelf50Answer44());
                edit_you50_45.setText(self50List.get(0).getSelf50Answer45());
                edit_you50_46.setText(self50List.get(0).getSelf50Answer46());
                edit_you50_47.setText(self50List.get(0).getSelf50Answer47());
                edit_you50_48.setText(self50List.get(0).getSelf50Answer48());
                edit_you50_49.setText(self50List.get(0).getSelf50Answer49());
                edit_you50_50.setText(self50List.get(0).getSelf50Answer50());

            }

        }

    }

}
