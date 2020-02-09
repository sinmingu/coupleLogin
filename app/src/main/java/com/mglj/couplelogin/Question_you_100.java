package com.mglj.couplelogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

public class Question_you_100 extends AppCompatActivity {

    TabHost reg_tabHost;
    TextView text_page;
    ImageView de_no_cancle, de_no_can, back_page, next_page;
    int page;
    TextView btn_save, btn_send;
    List<Self100> you50List;
    InterstitialAd adfull;
    EditText edit_you50_1, edit_you50_2, edit_you50_3, edit_you50_4, edit_you50_5, edit_you50_6, edit_you50_7, edit_you50_8, edit_you50_9, edit_you50_10,
            edit_you50_11, edit_you50_12,edit_you50_13, edit_you50_14, edit_you50_15, edit_you50_16, edit_you50_17, edit_you50_18, edit_you50_19, edit_you50_20,
            edit_you50_21, edit_you50_22, edit_you50_23, edit_you50_24, edit_you50_25, edit_you50_26, edit_you50_27, edit_you50_28, edit_you50_29, edit_you50_30,
            edit_you50_31, edit_you50_32, edit_you50_33, edit_you50_34, edit_you50_35, edit_you50_36, edit_you50_37, edit_you50_38, edit_you50_39, edit_you50_40,
            edit_you50_41, edit_you50_42, edit_you50_43, edit_you50_44, edit_you50_45, edit_you50_46, edit_you50_47, edit_you50_48, edit_you50_49, edit_you50_50,
            edit_you50_51, edit_you50_52, edit_you50_53, edit_you50_54, edit_you50_55, edit_you50_56, edit_you50_57, edit_you50_58, edit_you50_59, edit_you50_60,
            edit_you50_61, edit_you50_62, edit_you50_63, edit_you50_64, edit_you50_65, edit_you50_66, edit_you50_67, edit_you50_68, edit_you50_69, edit_you50_70,
            edit_you50_71, edit_you50_72, edit_you50_73, edit_you50_74, edit_you50_75, edit_you50_76, edit_you50_77, edit_you50_78, edit_you50_79, edit_you50_80,
            edit_you50_81, edit_you50_82, edit_you50_83, edit_you50_84, edit_you50_85, edit_you50_86, edit_you50_87, edit_you50_88, edit_you50_89, edit_you50_90,
            edit_you50_91, edit_you50_92, edit_you50_93, edit_you50_94, edit_you50_95, edit_you50_96, edit_you50_97, edit_you50_98, edit_you50_99, edit_you50_100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_you_100);

        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        back_page = (ImageView)findViewById(R.id.back_page);
        next_page = (ImageView)findViewById(R.id.next_page);
        text_page = (TextView)findViewById(R.id.text_page);
        btn_save = (TextView)findViewById(R.id.btn_save);
        btn_send = (TextView)findViewById(R.id.btn_send);
        adfull = new InterstitialAd(this);
        adfull.setAdUnitId("ca-app-pub-5784293657699097/5193862959");
        adfull.loadAd(new AdRequest.Builder().build());
        page = 0;

        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);
        Glide.with(this).load(R.drawable.back_2).fitCenter().into(back_page);
        Glide.with(this).load(R.drawable.next_2).fitCenter().into(next_page);

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
        edit_you50_51 = (EditText)findViewById(R.id.edit_you50_51);
        edit_you50_52 = (EditText)findViewById(R.id.edit_you50_52);
        edit_you50_53 = (EditText)findViewById(R.id.edit_you50_53);
        edit_you50_54 = (EditText)findViewById(R.id.edit_you50_54);
        edit_you50_55 = (EditText)findViewById(R.id.edit_you50_55);
        edit_you50_56 = (EditText)findViewById(R.id.edit_you50_56);
        edit_you50_57 = (EditText)findViewById(R.id.edit_you50_57);
        edit_you50_58 = (EditText)findViewById(R.id.edit_you50_58);
        edit_you50_59 = (EditText)findViewById(R.id.edit_you50_59);
        edit_you50_60 = (EditText)findViewById(R.id.edit_you50_60);
        edit_you50_61 = (EditText)findViewById(R.id.edit_you50_61);
        edit_you50_62 = (EditText)findViewById(R.id.edit_you50_62);
        edit_you50_63 = (EditText)findViewById(R.id.edit_you50_63);
        edit_you50_64 = (EditText)findViewById(R.id.edit_you50_64);
        edit_you50_65 = (EditText)findViewById(R.id.edit_you50_65);
        edit_you50_66 = (EditText)findViewById(R.id.edit_you50_66);
        edit_you50_67 = (EditText)findViewById(R.id.edit_you50_67);
        edit_you50_68 = (EditText)findViewById(R.id.edit_you50_68);
        edit_you50_69 = (EditText)findViewById(R.id.edit_you50_69);
        edit_you50_70 = (EditText)findViewById(R.id.edit_you50_70);
        edit_you50_71 = (EditText)findViewById(R.id.edit_you50_71);
        edit_you50_72 = (EditText)findViewById(R.id.edit_you50_72);
        edit_you50_73 = (EditText)findViewById(R.id.edit_you50_73);
        edit_you50_74 = (EditText)findViewById(R.id.edit_you50_74);
        edit_you50_75 = (EditText)findViewById(R.id.edit_you50_75);
        edit_you50_76 = (EditText)findViewById(R.id.edit_you50_76);
        edit_you50_77 = (EditText)findViewById(R.id.edit_you50_77);
        edit_you50_78 = (EditText)findViewById(R.id.edit_you50_78);
        edit_you50_79 = (EditText)findViewById(R.id.edit_you50_79);
        edit_you50_80 = (EditText)findViewById(R.id.edit_you50_80);
        edit_you50_81 = (EditText)findViewById(R.id.edit_you50_81);
        edit_you50_82 = (EditText)findViewById(R.id.edit_you50_82);
        edit_you50_83 = (EditText)findViewById(R.id.edit_you50_83);
        edit_you50_84 = (EditText)findViewById(R.id.edit_you50_84);
        edit_you50_85 = (EditText)findViewById(R.id.edit_you50_85);
        edit_you50_86 = (EditText)findViewById(R.id.edit_you50_86);
        edit_you50_87 = (EditText)findViewById(R.id.edit_you50_87);
        edit_you50_88 = (EditText)findViewById(R.id.edit_you50_88);
        edit_you50_89 = (EditText)findViewById(R.id.edit_you50_89);
        edit_you50_90 = (EditText)findViewById(R.id.edit_you50_90);
        edit_you50_91 = (EditText)findViewById(R.id.edit_you50_91);
        edit_you50_92 = (EditText)findViewById(R.id.edit_you50_92);
        edit_you50_93 = (EditText)findViewById(R.id.edit_you50_93);
        edit_you50_94 = (EditText)findViewById(R.id.edit_you50_94);
        edit_you50_95 = (EditText)findViewById(R.id.edit_you50_95);
        edit_you50_96 = (EditText)findViewById(R.id.edit_you50_96);
        edit_you50_97 = (EditText)findViewById(R.id.edit_you50_97);
        edit_you50_98 = (EditText)findViewById(R.id.edit_you50_98);
        edit_you50_99 = (EditText)findViewById(R.id.edit_you50_99);
        edit_you50_100 = (EditText)findViewById(R.id.edit_you50_100);

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

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec11 = reg_tabHost.newTabSpec("Tab11");
        reg_tabSpec11.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec11.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec11.setContent(R.id.reg_tab_view11); // Tab Content
        reg_tabHost.addTab(reg_tabSpec11);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec12 = reg_tabHost.newTabSpec("Tab12");
        reg_tabSpec12.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec12.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec12.setContent(R.id.reg_tab_view12); // Tab Content
        reg_tabHost.addTab(reg_tabSpec12);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec13 = reg_tabHost.newTabSpec("Tab13");
        reg_tabSpec13.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec13.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec13.setContent(R.id.reg_tab_view13); // Tab Content
        reg_tabHost.addTab(reg_tabSpec13);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec14 = reg_tabHost.newTabSpec("Tab14");
        reg_tabSpec14.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec14.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec14.setContent(R.id.reg_tab_view14); // Tab Content
        reg_tabHost.addTab(reg_tabSpec14);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec15 = reg_tabHost.newTabSpec("Tab15");
        reg_tabSpec15.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec15.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec15.setContent(R.id.reg_tab_view15); // Tab Content
        reg_tabHost.addTab(reg_tabSpec15);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec16 = reg_tabHost.newTabSpec("Tab16");
        reg_tabSpec16.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec16.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec16.setContent(R.id.reg_tab_view16); // Tab Content
        reg_tabHost.addTab(reg_tabSpec16);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec17 = reg_tabHost.newTabSpec("Tab17");
        reg_tabSpec17.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec17.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec17.setContent(R.id.reg_tab_view17); // Tab Content
        reg_tabHost.addTab(reg_tabSpec17);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec18 = reg_tabHost.newTabSpec("Tab18");
        reg_tabSpec18.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec18.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec18.setContent(R.id.reg_tab_view18); // Tab Content
        reg_tabHost.addTab(reg_tabSpec18);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec19 = reg_tabHost.newTabSpec("Tab19");
        reg_tabSpec19.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec19.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec19.setContent(R.id.reg_tab_view19); // Tab Content
        reg_tabHost.addTab(reg_tabSpec19);

        // 그래프 탭
        TabHost.TabSpec reg_tabSpec20 = reg_tabHost.newTabSpec("Tab20");
        reg_tabSpec20.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec20.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec20.setContent(R.id.reg_tab_view20); // Tab Content
        reg_tabHost.addTab(reg_tabSpec20);


        reg_tabHost.getTabWidget().getChildAt(0)

                .setBackgroundColor(Color.parseColor("#ffffff"));


        reg_tabHost.getTabWidget().getChildAt(1)

                .setBackgroundColor(Color.parseColor("#ffffff"));

        reg_tabHost.getTabWidget().getChildAt(2)

                .setBackgroundColor(Color.parseColor("#ffffff"));

        reg_tabHost.setCurrentTab(0); // 처음 열리는 탭

        text_page.setText(page+1 +" / 20");

        //-----------------------탭 호스트 끝--------------------------------
        new BackgroundTask_you50List().execute();

        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

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
                    text_page.setText(page+1 +" / 20");

                }
            }
        });

        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page==19){
                    Toast.makeText(getApplicationContext(),"최대 입니다",Toast.LENGTH_SHORT).show();
                }
                else {
                    page+=1;
                    reg_tabHost.setCurrentTab(page);
                    text_page.setText(page+1 +" / 20");

                }
            }
        });

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

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //임시저장
    public void self50(){

        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10,
                answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30,
                answer31, answer32, answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40,
                answer41, answer42, answer43, answer44, answer45, answer46, answer47, answer48, answer49, answer50,
                answer51, answer52, answer53, answer54, answer55, answer56, answer57, answer58, answer59, answer60,
                answer61, answer62, answer63, answer64, answer65, answer66, answer67, answer68, answer69, answer70,
                answer71, answer72, answer73, answer74, answer75, answer76, answer77, answer78, answer79, answer80,
                answer81, answer82, answer83, answer84, answer85, answer86, answer87, answer88, answer89, answer90,
                answer91, answer92, answer93, answer94, answer95, answer96, answer97, answer98, answer99, answer100;


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

        if(edit_you50_51.getText().toString().equals("")){
            answer51 = "미응답";
        }
        else
            answer51=edit_you50_51.getText().toString();

        if(edit_you50_52.getText().toString().equals("")){
            answer52 = "미응답";
        }
        else
            answer52=edit_you50_52.getText().toString();

        if(edit_you50_53.getText().toString().equals("")){
            answer53 = "미응답";
        }
        else
            answer53=edit_you50_53.getText().toString();

        if(edit_you50_54.getText().toString().equals("")){
            answer54 = "미응답";
        }
        else
            answer54=edit_you50_54.getText().toString();

        if(edit_you50_55.getText().toString().equals("")){
            answer55 = "미응답";
        }
        else
            answer55=edit_you50_55.getText().toString();

        if(edit_you50_56.getText().toString().equals("")){
            answer56 = "미응답";
        }
        else
            answer56=edit_you50_56.getText().toString();

        if(edit_you50_57.getText().toString().equals("")){
            answer57 = "미응답";
        }
        else
            answer57=edit_you50_57.getText().toString();

        if(edit_you50_58.getText().toString().equals("")){
            answer58 = "미응답";
        }
        else
            answer58=edit_you50_58.getText().toString();

        if(edit_you50_59.getText().toString().equals("")){
            answer59 = "미응답";
        }
        else
            answer59=edit_you50_59.getText().toString();

        if(edit_you50_60.getText().toString().equals("")){
            answer60 = "미응답";
        }
        else
            answer60=edit_you50_60.getText().toString();

        if(edit_you50_61.getText().toString().equals("")){
            answer61 = "미응답";
        }
        else
            answer61=edit_you50_61.getText().toString();

        if(edit_you50_62.getText().toString().equals("")){
            answer62 = "미응답";
        }
        else
            answer62=edit_you50_62.getText().toString();

        if(edit_you50_63.getText().toString().equals("")){
            answer63 = "미응답";
        }
        else
            answer63=edit_you50_63.getText().toString();

        if(edit_you50_64.getText().toString().equals("")){
            answer64 = "미응답";
        }
        else
            answer64=edit_you50_64.getText().toString();

        if(edit_you50_65.getText().toString().equals("")){
            answer65 = "미응답";
        }
        else
            answer65=edit_you50_65.getText().toString();

        if(edit_you50_66.getText().toString().equals("")){
            answer66 = "미응답";
        }
        else
            answer66=edit_you50_66.getText().toString();

        if(edit_you50_67.getText().toString().equals("")){
            answer67 = "미응답";
        }
        else
            answer67=edit_you50_67.getText().toString();

        if(edit_you50_68.getText().toString().equals("")){
            answer68 = "미응답";
        }
        else
            answer68=edit_you50_68.getText().toString();

        if(edit_you50_69.getText().toString().equals("")){
            answer69 = "미응답";
        }
        else
            answer69=edit_you50_69.getText().toString();

        if(edit_you50_70.getText().toString().equals("")){
            answer70 = "미응답";
        }
        else
            answer70=edit_you50_70.getText().toString();

        if(edit_you50_71.getText().toString().equals("")){
            answer71 = "미응답";
        }
        else
            answer71=edit_you50_71.getText().toString();

        if(edit_you50_72.getText().toString().equals("")){
            answer72 = "미응답";
        }
        else
            answer72=edit_you50_72.getText().toString();

        if(edit_you50_73.getText().toString().equals("")){
            answer73 = "미응답";
        }
        else
            answer73=edit_you50_73.getText().toString();

        if(edit_you50_74.getText().toString().equals("")){
            answer74 = "미응답";
        }
        else
            answer74=edit_you50_74.getText().toString();

        if(edit_you50_75.getText().toString().equals("")){
            answer75 = "미응답";
        }
        else
            answer75=edit_you50_75.getText().toString();

        if(edit_you50_76.getText().toString().equals("")){
            answer76 = "미응답";
        }
        else
            answer76=edit_you50_76.getText().toString();

        if(edit_you50_77.getText().toString().equals("")){
            answer77 = "미응답";
        }
        else
            answer77=edit_you50_77.getText().toString();

        if(edit_you50_78.getText().toString().equals("")){
            answer78 = "미응답";
        }
        else
            answer78=edit_you50_78.getText().toString();

        if(edit_you50_79.getText().toString().equals("")){
            answer79 = "미응답";
        }
        else
            answer79=edit_you50_79.getText().toString();

        if(edit_you50_80.getText().toString().equals("")){
            answer80 = "미응답";
        }
        else
            answer80=edit_you50_80.getText().toString();

        if(edit_you50_81.getText().toString().equals("")){
            answer81 = "미응답";
        }
        else
            answer81=edit_you50_81.getText().toString();

        if(edit_you50_82.getText().toString().equals("")){
            answer82 = "미응답";
        }
        else
            answer82=edit_you50_82.getText().toString();

        if(edit_you50_83.getText().toString().equals("")){
            answer83 = "미응답";
        }
        else
            answer83=edit_you50_83.getText().toString();

        if(edit_you50_84.getText().toString().equals("")){
            answer84 = "미응답";
        }
        else
            answer84=edit_you50_84.getText().toString();

        if(edit_you50_85.getText().toString().equals("")){
            answer85 = "미응답";
        }
        else
            answer85=edit_you50_85.getText().toString();

        if(edit_you50_86.getText().toString().equals("")){
            answer86 = "미응답";
        }
        else
            answer86=edit_you50_86.getText().toString();

        if(edit_you50_87.getText().toString().equals("")){
            answer87 = "미응답";
        }
        else
            answer87=edit_you50_87.getText().toString();

        if(edit_you50_88.getText().toString().equals("")){
            answer88 = "미응답";
        }
        else
            answer88=edit_you50_88.getText().toString();

        if(edit_you50_89.getText().toString().equals("")){
            answer89 = "미응답";
        }
        else
            answer89=edit_you50_89.getText().toString();

        if(edit_you50_90.getText().toString().equals("")){
            answer90 = "미응답";
        }
        else
            answer90=edit_you50_90.getText().toString();

        if(edit_you50_91.getText().toString().equals("")){
            answer91 = "미응답";
        }
        else
            answer91=edit_you50_91.getText().toString();

        if(edit_you50_92.getText().toString().equals("")){
            answer92 = "미응답";
        }
        else
            answer92=edit_you50_92.getText().toString();

        if(edit_you50_93.getText().toString().equals("")){
            answer93 = "미응답";
        }
        else
            answer93=edit_you50_93.getText().toString();

        if(edit_you50_94.getText().toString().equals("")){
            answer94 = "미응답";
        }
        else
            answer94=edit_you50_94.getText().toString();

        if(edit_you50_95.getText().toString().equals("")){
            answer95 = "미응답";
        }
        else
            answer95=edit_you50_95.getText().toString();

        if(edit_you50_96.getText().toString().equals("")){
            answer96 = "미응답";
        }
        else
            answer96=edit_you50_96.getText().toString();

        if(edit_you50_97.getText().toString().equals("")){
            answer97 = "미응답";
        }
        else
            answer97=edit_you50_97.getText().toString();

        if(edit_you50_98.getText().toString().equals("")){
            answer98 = "미응답";
        }
        else
            answer98=edit_you50_98.getText().toString();

        if(edit_you50_99.getText().toString().equals("")){
            answer99 = "미응답";
        }
        else
            answer99=edit_you50_99.getText().toString();

        if(edit_you50_100.getText().toString().equals("")){
            answer100 = "미응답";
        }
        else
            answer100=edit_you50_100.getText().toString();

        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSave customDialog = new CustomDialogSave(Question_you_100.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_you_100.this);
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

        You100AddRequest registerRequest = new You100AddRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32,
                answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40, answer41, answer42, answer43,
                answer44, answer45, answer46, answer47, answer48, answer49, answer50, answer51, answer52, answer53,
                answer54, answer55, answer56, answer57, answer58, answer59, answer60,answer61, answer62, answer63,
                answer64, answer65, answer66, answer67, answer68, answer69, answer70,answer71, answer72, answer73,
                answer74, answer75, answer76, answer77, answer78, answer79, answer80,answer81, answer82, answer83,
                answer84, answer85, answer86, answer87, answer88, answer89, answer90,answer91, answer92, answer93,
                answer94, answer95, answer96, answer97, answer98, answer99, answer100, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_you_100.this);
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
                answer41, answer42, answer43, answer44, answer45, answer46, answer47, answer48, answer49, answer50,
                answer51, answer52, answer53, answer54, answer55, answer56, answer57, answer58, answer59, answer60,
                answer61, answer62, answer63, answer64, answer65, answer66, answer67, answer68, answer69, answer70,
                answer71, answer72, answer73, answer74, answer75, answer76, answer77, answer78, answer79, answer80,
                answer81, answer82, answer83, answer84, answer85, answer86, answer87, answer88, answer89, answer90,
                answer91, answer92, answer93, answer94, answer95, answer96, answer97, answer98, answer99, answer100;


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

        if(edit_you50_51.getText().toString().equals("")){
            answer51 = "미응답";
        }
        else
            answer51=edit_you50_51.getText().toString();

        if(edit_you50_52.getText().toString().equals("")){
            answer52 = "미응답";
        }
        else
            answer52=edit_you50_52.getText().toString();

        if(edit_you50_53.getText().toString().equals("")){
            answer53 = "미응답";
        }
        else
            answer53=edit_you50_53.getText().toString();

        if(edit_you50_54.getText().toString().equals("")){
            answer54 = "미응답";
        }
        else
            answer54=edit_you50_54.getText().toString();

        if(edit_you50_55.getText().toString().equals("")){
            answer55 = "미응답";
        }
        else
            answer55=edit_you50_55.getText().toString();

        if(edit_you50_56.getText().toString().equals("")){
            answer56 = "미응답";
        }
        else
            answer56=edit_you50_56.getText().toString();

        if(edit_you50_57.getText().toString().equals("")){
            answer57 = "미응답";
        }
        else
            answer57=edit_you50_57.getText().toString();

        if(edit_you50_58.getText().toString().equals("")){
            answer58 = "미응답";
        }
        else
            answer58=edit_you50_58.getText().toString();

        if(edit_you50_59.getText().toString().equals("")){
            answer59 = "미응답";
        }
        else
            answer59=edit_you50_59.getText().toString();

        if(edit_you50_60.getText().toString().equals("")){
            answer60 = "미응답";
        }
        else
            answer60=edit_you50_60.getText().toString();

        if(edit_you50_61.getText().toString().equals("")){
            answer61 = "미응답";
        }
        else
            answer61=edit_you50_61.getText().toString();

        if(edit_you50_62.getText().toString().equals("")){
            answer62 = "미응답";
        }
        else
            answer62=edit_you50_62.getText().toString();

        if(edit_you50_63.getText().toString().equals("")){
            answer63 = "미응답";
        }
        else
            answer63=edit_you50_63.getText().toString();

        if(edit_you50_64.getText().toString().equals("")){
            answer64 = "미응답";
        }
        else
            answer64=edit_you50_64.getText().toString();

        if(edit_you50_65.getText().toString().equals("")){
            answer65 = "미응답";
        }
        else
            answer65=edit_you50_65.getText().toString();

        if(edit_you50_66.getText().toString().equals("")){
            answer66 = "미응답";
        }
        else
            answer66=edit_you50_66.getText().toString();

        if(edit_you50_67.getText().toString().equals("")){
            answer67 = "미응답";
        }
        else
            answer67=edit_you50_67.getText().toString();

        if(edit_you50_68.getText().toString().equals("")){
            answer68 = "미응답";
        }
        else
            answer68=edit_you50_68.getText().toString();

        if(edit_you50_69.getText().toString().equals("")){
            answer69 = "미응답";
        }
        else
            answer69=edit_you50_69.getText().toString();

        if(edit_you50_70.getText().toString().equals("")){
            answer70 = "미응답";
        }
        else
            answer70=edit_you50_70.getText().toString();

        if(edit_you50_71.getText().toString().equals("")){
            answer71 = "미응답";
        }
        else
            answer71=edit_you50_71.getText().toString();

        if(edit_you50_72.getText().toString().equals("")){
            answer72 = "미응답";
        }
        else
            answer72=edit_you50_72.getText().toString();

        if(edit_you50_73.getText().toString().equals("")){
            answer73 = "미응답";
        }
        else
            answer73=edit_you50_73.getText().toString();

        if(edit_you50_74.getText().toString().equals("")){
            answer74 = "미응답";
        }
        else
            answer74=edit_you50_74.getText().toString();

        if(edit_you50_75.getText().toString().equals("")){
            answer75 = "미응답";
        }
        else
            answer75=edit_you50_75.getText().toString();

        if(edit_you50_76.getText().toString().equals("")){
            answer76 = "미응답";
        }
        else
            answer76=edit_you50_76.getText().toString();

        if(edit_you50_77.getText().toString().equals("")){
            answer77 = "미응답";
        }
        else
            answer77=edit_you50_77.getText().toString();

        if(edit_you50_78.getText().toString().equals("")){
            answer78 = "미응답";
        }
        else
            answer78=edit_you50_78.getText().toString();

        if(edit_you50_79.getText().toString().equals("")){
            answer79 = "미응답";
        }
        else
            answer79=edit_you50_79.getText().toString();

        if(edit_you50_80.getText().toString().equals("")){
            answer80 = "미응답";
        }
        else
            answer80=edit_you50_80.getText().toString();

        if(edit_you50_81.getText().toString().equals("")){
            answer81 = "미응답";
        }
        else
            answer81=edit_you50_81.getText().toString();

        if(edit_you50_82.getText().toString().equals("")){
            answer82 = "미응답";
        }
        else
            answer82=edit_you50_82.getText().toString();

        if(edit_you50_83.getText().toString().equals("")){
            answer83 = "미응답";
        }
        else
            answer83=edit_you50_83.getText().toString();

        if(edit_you50_84.getText().toString().equals("")){
            answer84 = "미응답";
        }
        else
            answer84=edit_you50_84.getText().toString();

        if(edit_you50_85.getText().toString().equals("")){
            answer85 = "미응답";
        }
        else
            answer85=edit_you50_85.getText().toString();

        if(edit_you50_86.getText().toString().equals("")){
            answer86 = "미응답";
        }
        else
            answer86=edit_you50_86.getText().toString();

        if(edit_you50_87.getText().toString().equals("")){
            answer87 = "미응답";
        }
        else
            answer87=edit_you50_87.getText().toString();

        if(edit_you50_88.getText().toString().equals("")){
            answer88 = "미응답";
        }
        else
            answer88=edit_you50_88.getText().toString();

        if(edit_you50_89.getText().toString().equals("")){
            answer89 = "미응답";
        }
        else
            answer89=edit_you50_89.getText().toString();

        if(edit_you50_90.getText().toString().equals("")){
            answer90 = "미응답";
        }
        else
            answer90=edit_you50_90.getText().toString();

        if(edit_you50_91.getText().toString().equals("")){
            answer91 = "미응답";
        }
        else
            answer91=edit_you50_91.getText().toString();

        if(edit_you50_92.getText().toString().equals("")){
            answer92 = "미응답";
        }
        else
            answer92=edit_you50_92.getText().toString();

        if(edit_you50_93.getText().toString().equals("")){
            answer93 = "미응답";
        }
        else
            answer93=edit_you50_93.getText().toString();

        if(edit_you50_94.getText().toString().equals("")){
            answer94 = "미응답";
        }
        else
            answer94=edit_you50_94.getText().toString();

        if(edit_you50_95.getText().toString().equals("")){
            answer95 = "미응답";
        }
        else
            answer95=edit_you50_95.getText().toString();

        if(edit_you50_96.getText().toString().equals("")){
            answer96 = "미응답";
        }
        else
            answer96=edit_you50_96.getText().toString();

        if(edit_you50_97.getText().toString().equals("")){
            answer97 = "미응답";
        }
        else
            answer97=edit_you50_97.getText().toString();

        if(edit_you50_98.getText().toString().equals("")){
            answer98 = "미응답";
        }
        else
            answer98=edit_you50_98.getText().toString();

        if(edit_you50_99.getText().toString().equals("")){
            answer99 = "미응답";
        }
        else
            answer99=edit_you50_99.getText().toString();

        if(edit_you50_100.getText().toString().equals("")){
            answer100 = "미응답";
        }
        else
            answer100=edit_you50_100.getText().toString();




        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSave customDialog = new CustomDialogSave(Question_you_100.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_you_100.this);
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

        You100UpdateRequest registerRequest = new You100UpdateRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32,
                answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40, answer41, answer42, answer43,
                answer44, answer45, answer46, answer47, answer48, answer49, answer50, answer51, answer52, answer53,
                answer54, answer55, answer56, answer57, answer58, answer59, answer60,answer61, answer62, answer63,
                answer64, answer65, answer66, answer67, answer68, answer69, answer70,answer71, answer72, answer73,
                answer74, answer75, answer76, answer77, answer78, answer79, answer80,answer81, answer82, answer83,
                answer84, answer85, answer86, answer87, answer88, answer89, answer90,answer91, answer92, answer93,
                answer94, answer95, answer96, answer97, answer98, answer99, answer100, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_you_100.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }

    // 채팅방
    class BackgroundTask_roomList extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_you100List.php";
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

            you50List = new ArrayList<Self100>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                        self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                        self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                        self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                        self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50,
                        self50Answer51, self50Answer52, self50Answer53, self50Answer54, self50Answer55, self50Answer56, self50Answer57, self50Answer58, self50Answer59, self50Answer60,
                        self50Answer61, self50Answer62, self50Answer63, self50Answer64, self50Answer65, self50Answer66, self50Answer67, self50Answer68, self50Answer69, self50Answer70,
                        self50Answer71, self50Answer72, self50Answer73, self50Answer74, self50Answer75, self50Answer76, self50Answer77, self50Answer78, self50Answer79, self50Answer80,
                        self50Answer81, self50Answer82, self50Answer83, self50Answer84, self50Answer85, self50Answer86, self50Answer87, self50Answer88, self50Answer89, self50Answer90,
                        self50Answer91, self50Answer92, self50Answer93, self50Answer94, self50Answer95, self50Answer96, self50Answer97, self50Answer98, self50Answer99, self50Answer100;

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
                    self50Answer51 = object.getString("self50Answer51");
                    self50Answer52 = object.getString("self50Answer52");
                    self50Answer53 = object.getString("self50Answer53");
                    self50Answer54 = object.getString("self50Answer54");
                    self50Answer55 = object.getString("self50Answer55");
                    self50Answer56 = object.getString("self50Answer56");
                    self50Answer57 = object.getString("self50Answer57");
                    self50Answer58 = object.getString("self50Answer58");
                    self50Answer59 = object.getString("self50Answer59");
                    self50Answer60 = object.getString("self50Answer60");
                    self50Answer61 = object.getString("self50Answer61");
                    self50Answer62 = object.getString("self50Answer62");
                    self50Answer63 = object.getString("self50Answer63");
                    self50Answer64 = object.getString("self50Answer64");
                    self50Answer65 = object.getString("self50Answer65");
                    self50Answer66 = object.getString("self50Answer66");
                    self50Answer67 = object.getString("self50Answer67");
                    self50Answer68 = object.getString("self50Answer68");
                    self50Answer69 = object.getString("self50Answer69");
                    self50Answer70 = object.getString("self50Answer70");
                    self50Answer71 = object.getString("self50Answer71");
                    self50Answer72 = object.getString("self50Answer72");
                    self50Answer73 = object.getString("self50Answer73");
                    self50Answer74 = object.getString("self50Answer74");
                    self50Answer75 = object.getString("self50Answer75");
                    self50Answer76 = object.getString("self50Answer76");
                    self50Answer77 = object.getString("self50Answer77");
                    self50Answer78 = object.getString("self50Answer78");
                    self50Answer79 = object.getString("self50Answer79");
                    self50Answer80 = object.getString("self50Answer80");
                    self50Answer81 = object.getString("self50Answer81");
                    self50Answer82 = object.getString("self50Answer82");
                    self50Answer83 = object.getString("self50Answer83");
                    self50Answer84 = object.getString("self50Answer84");
                    self50Answer85 = object.getString("self50Answer85");
                    self50Answer86 = object.getString("self50Answer86");
                    self50Answer87 = object.getString("self50Answer87");
                    self50Answer88 = object.getString("self50Answer88");
                    self50Answer89 = object.getString("self50Answer89");
                    self50Answer90 = object.getString("self50Answer90");
                    self50Answer91 = object.getString("self50Answer91");
                    self50Answer92 = object.getString("self50Answer92");
                    self50Answer93 = object.getString("self50Answer93");
                    self50Answer94 = object.getString("self50Answer94");
                    self50Answer95 = object.getString("self50Answer95");
                    self50Answer96 = object.getString("self50Answer96");
                    self50Answer97 = object.getString("self50Answer97");
                    self50Answer98 = object.getString("self50Answer98");
                    self50Answer99 = object.getString("self50Answer99");
                    self50Answer100 = object.getString("self50Answer100");

                    if(self50ID.equals(LoginUserID)) {
                        Self100 self100 = new Self100(self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                                self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                                self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                                self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                                self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50,
                                self50Answer51, self50Answer52, self50Answer53, self50Answer54, self50Answer55, self50Answer56, self50Answer57, self50Answer58, self50Answer59, self50Answer60,
                                self50Answer61, self50Answer62, self50Answer63, self50Answer64, self50Answer65, self50Answer66, self50Answer67, self50Answer68, self50Answer69, self50Answer70,
                                self50Answer71, self50Answer72, self50Answer73, self50Answer74, self50Answer75, self50Answer76, self50Answer77, self50Answer78, self50Answer79, self50Answer80,
                                self50Answer81, self50Answer82, self50Answer83, self50Answer84, self50Answer85, self50Answer86, self50Answer87, self50Answer88, self50Answer89, self50Answer90,
                                self50Answer91, self50Answer92, self50Answer93, self50Answer94, self50Answer95, self50Answer96, self50Answer97, self50Answer98, self50Answer99, self50Answer100);
                        you50List.add(self100);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(you50List.size()>=1){
                self50_update();
            }
            else if(you50List.size()==0){
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
                answer41, answer42, answer43, answer44, answer45, answer46, answer47, answer48, answer49, answer50,
                answer51, answer52, answer53, answer54, answer55, answer56, answer57, answer58, answer59, answer60,
                answer61, answer62, answer63, answer64, answer65, answer66, answer67, answer68, answer69, answer70,
                answer71, answer72, answer73, answer74, answer75, answer76, answer77, answer78, answer79, answer80,
                answer81, answer82, answer83, answer84, answer85, answer86, answer87, answer88, answer89, answer90,
                answer91, answer92, answer93, answer94, answer95, answer96, answer97, answer98, answer99, answer100;


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

        if(edit_you50_51.getText().toString().equals("")){
            answer51 = "미응답";
        }
        else
            answer51=edit_you50_51.getText().toString();

        if(edit_you50_52.getText().toString().equals("")){
            answer52 = "미응답";
        }
        else
            answer52=edit_you50_52.getText().toString();

        if(edit_you50_53.getText().toString().equals("")){
            answer53 = "미응답";
        }
        else
            answer53=edit_you50_53.getText().toString();

        if(edit_you50_54.getText().toString().equals("")){
            answer54 = "미응답";
        }
        else
            answer54=edit_you50_54.getText().toString();

        if(edit_you50_55.getText().toString().equals("")){
            answer55 = "미응답";
        }
        else
            answer55=edit_you50_55.getText().toString();

        if(edit_you50_56.getText().toString().equals("")){
            answer56 = "미응답";
        }
        else
            answer56=edit_you50_56.getText().toString();

        if(edit_you50_57.getText().toString().equals("")){
            answer57 = "미응답";
        }
        else
            answer57=edit_you50_57.getText().toString();

        if(edit_you50_58.getText().toString().equals("")){
            answer58 = "미응답";
        }
        else
            answer58=edit_you50_58.getText().toString();

        if(edit_you50_59.getText().toString().equals("")){
            answer59 = "미응답";
        }
        else
            answer59=edit_you50_59.getText().toString();

        if(edit_you50_60.getText().toString().equals("")){
            answer60 = "미응답";
        }
        else
            answer60=edit_you50_60.getText().toString();

        if(edit_you50_61.getText().toString().equals("")){
            answer61 = "미응답";
        }
        else
            answer61=edit_you50_61.getText().toString();

        if(edit_you50_62.getText().toString().equals("")){
            answer62 = "미응답";
        }
        else
            answer62=edit_you50_62.getText().toString();

        if(edit_you50_63.getText().toString().equals("")){
            answer63 = "미응답";
        }
        else
            answer63=edit_you50_63.getText().toString();

        if(edit_you50_64.getText().toString().equals("")){
            answer64 = "미응답";
        }
        else
            answer64=edit_you50_64.getText().toString();

        if(edit_you50_65.getText().toString().equals("")){
            answer65 = "미응답";
        }
        else
            answer65=edit_you50_65.getText().toString();

        if(edit_you50_66.getText().toString().equals("")){
            answer66 = "미응답";
        }
        else
            answer66=edit_you50_66.getText().toString();

        if(edit_you50_67.getText().toString().equals("")){
            answer67 = "미응답";
        }
        else
            answer67=edit_you50_67.getText().toString();

        if(edit_you50_68.getText().toString().equals("")){
            answer68 = "미응답";
        }
        else
            answer68=edit_you50_68.getText().toString();

        if(edit_you50_69.getText().toString().equals("")){
            answer69 = "미응답";
        }
        else
            answer69=edit_you50_69.getText().toString();

        if(edit_you50_70.getText().toString().equals("")){
            answer70 = "미응답";
        }
        else
            answer70=edit_you50_70.getText().toString();

        if(edit_you50_71.getText().toString().equals("")){
            answer71 = "미응답";
        }
        else
            answer71=edit_you50_71.getText().toString();

        if(edit_you50_72.getText().toString().equals("")){
            answer72 = "미응답";
        }
        else
            answer72=edit_you50_72.getText().toString();

        if(edit_you50_73.getText().toString().equals("")){
            answer73 = "미응답";
        }
        else
            answer73=edit_you50_73.getText().toString();

        if(edit_you50_74.getText().toString().equals("")){
            answer74 = "미응답";
        }
        else
            answer74=edit_you50_74.getText().toString();

        if(edit_you50_75.getText().toString().equals("")){
            answer75 = "미응답";
        }
        else
            answer75=edit_you50_75.getText().toString();

        if(edit_you50_76.getText().toString().equals("")){
            answer76 = "미응답";
        }
        else
            answer76=edit_you50_76.getText().toString();

        if(edit_you50_77.getText().toString().equals("")){
            answer77 = "미응답";
        }
        else
            answer77=edit_you50_77.getText().toString();

        if(edit_you50_78.getText().toString().equals("")){
            answer78 = "미응답";
        }
        else
            answer78=edit_you50_78.getText().toString();

        if(edit_you50_79.getText().toString().equals("")){
            answer79 = "미응답";
        }
        else
            answer79=edit_you50_79.getText().toString();

        if(edit_you50_80.getText().toString().equals("")){
            answer80 = "미응답";
        }
        else
            answer80=edit_you50_80.getText().toString();

        if(edit_you50_81.getText().toString().equals("")){
            answer81 = "미응답";
        }
        else
            answer81=edit_you50_81.getText().toString();

        if(edit_you50_82.getText().toString().equals("")){
            answer82 = "미응답";
        }
        else
            answer82=edit_you50_82.getText().toString();

        if(edit_you50_83.getText().toString().equals("")){
            answer83 = "미응답";
        }
        else
            answer83=edit_you50_83.getText().toString();

        if(edit_you50_84.getText().toString().equals("")){
            answer84 = "미응답";
        }
        else
            answer84=edit_you50_84.getText().toString();

        if(edit_you50_85.getText().toString().equals("")){
            answer85 = "미응답";
        }
        else
            answer85=edit_you50_85.getText().toString();

        if(edit_you50_86.getText().toString().equals("")){
            answer86 = "미응답";
        }
        else
            answer86=edit_you50_86.getText().toString();

        if(edit_you50_87.getText().toString().equals("")){
            answer87 = "미응답";
        }
        else
            answer87=edit_you50_87.getText().toString();

        if(edit_you50_88.getText().toString().equals("")){
            answer88 = "미응답";
        }
        else
            answer88=edit_you50_88.getText().toString();

        if(edit_you50_89.getText().toString().equals("")){
            answer89 = "미응답";
        }
        else
            answer89=edit_you50_89.getText().toString();

        if(edit_you50_90.getText().toString().equals("")){
            answer90 = "미응답";
        }
        else
            answer90=edit_you50_90.getText().toString();

        if(edit_you50_91.getText().toString().equals("")){
            answer91 = "미응답";
        }
        else
            answer91=edit_you50_91.getText().toString();

        if(edit_you50_92.getText().toString().equals("")){
            answer92 = "미응답";
        }
        else
            answer92=edit_you50_92.getText().toString();

        if(edit_you50_93.getText().toString().equals("")){
            answer93 = "미응답";
        }
        else
            answer93=edit_you50_93.getText().toString();

        if(edit_you50_94.getText().toString().equals("")){
            answer94 = "미응답";
        }
        else
            answer94=edit_you50_94.getText().toString();

        if(edit_you50_95.getText().toString().equals("")){
            answer95 = "미응답";
        }
        else
            answer95=edit_you50_95.getText().toString();

        if(edit_you50_96.getText().toString().equals("")){
            answer96 = "미응답";
        }
        else
            answer96=edit_you50_96.getText().toString();

        if(edit_you50_97.getText().toString().equals("")){
            answer97 = "미응답";
        }
        else
            answer97=edit_you50_97.getText().toString();

        if(edit_you50_98.getText().toString().equals("")){
            answer98 = "미응답";
        }
        else
            answer98=edit_you50_98.getText().toString();

        if(edit_you50_99.getText().toString().equals("")){
            answer99 = "미응답";
        }
        else
            answer99=edit_you50_99.getText().toString();

        if(edit_you50_100.getText().toString().equals("")){
            answer100 = "미응답";
        }
        else
            answer100=edit_you50_100.getText().toString();




        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogUpdate customDialog = new CustomDialogUpdate(Question_you_100.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_you_100.this);
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

        You100SendAddRequest registerRequest = new You100SendAddRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32,
                answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40, answer41, answer42, answer43,
                answer44, answer45, answer46, answer47, answer48, answer49, answer50, answer51, answer52, answer53,
                answer54, answer55, answer56, answer57, answer58, answer59, answer60,answer61, answer62, answer63,
                answer64, answer65, answer66, answer67, answer68, answer69, answer70,answer71, answer72, answer73,
                answer74, answer75, answer76, answer77, answer78, answer79, answer80,answer81, answer82, answer83,
                answer84, answer85, answer86, answer87, answer88, answer89, answer90,answer91, answer92, answer93,
                answer94, answer95, answer96, answer97, answer98, answer99, answer100, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_you_100.this);
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
                answer41, answer42, answer43, answer44, answer45, answer46, answer47, answer48, answer49, answer50,
                answer51, answer52, answer53, answer54, answer55, answer56, answer57, answer58, answer59, answer60,
                answer61, answer62, answer63, answer64, answer65, answer66, answer67, answer68, answer69, answer70,
                answer71, answer72, answer73, answer74, answer75, answer76, answer77, answer78, answer79, answer80,
                answer81, answer82, answer83, answer84, answer85, answer86, answer87, answer88, answer89, answer90,
                answer91, answer92, answer93, answer94, answer95, answer96, answer97, answer98, answer99, answer100;


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

        if(edit_you50_51.getText().toString().equals("")){
            answer51 = "미응답";
        }
        else
            answer51=edit_you50_51.getText().toString();

        if(edit_you50_52.getText().toString().equals("")){
            answer52 = "미응답";
        }
        else
            answer52=edit_you50_52.getText().toString();

        if(edit_you50_53.getText().toString().equals("")){
            answer53 = "미응답";
        }
        else
            answer53=edit_you50_53.getText().toString();

        if(edit_you50_54.getText().toString().equals("")){
            answer54 = "미응답";
        }
        else
            answer54=edit_you50_54.getText().toString();

        if(edit_you50_55.getText().toString().equals("")){
            answer55 = "미응답";
        }
        else
            answer55=edit_you50_55.getText().toString();

        if(edit_you50_56.getText().toString().equals("")){
            answer56 = "미응답";
        }
        else
            answer56=edit_you50_56.getText().toString();

        if(edit_you50_57.getText().toString().equals("")){
            answer57 = "미응답";
        }
        else
            answer57=edit_you50_57.getText().toString();

        if(edit_you50_58.getText().toString().equals("")){
            answer58 = "미응답";
        }
        else
            answer58=edit_you50_58.getText().toString();

        if(edit_you50_59.getText().toString().equals("")){
            answer59 = "미응답";
        }
        else
            answer59=edit_you50_59.getText().toString();

        if(edit_you50_60.getText().toString().equals("")){
            answer60 = "미응답";
        }
        else
            answer60=edit_you50_60.getText().toString();

        if(edit_you50_61.getText().toString().equals("")){
            answer61 = "미응답";
        }
        else
            answer61=edit_you50_61.getText().toString();

        if(edit_you50_62.getText().toString().equals("")){
            answer62 = "미응답";
        }
        else
            answer62=edit_you50_62.getText().toString();

        if(edit_you50_63.getText().toString().equals("")){
            answer63 = "미응답";
        }
        else
            answer63=edit_you50_63.getText().toString();

        if(edit_you50_64.getText().toString().equals("")){
            answer64 = "미응답";
        }
        else
            answer64=edit_you50_64.getText().toString();

        if(edit_you50_65.getText().toString().equals("")){
            answer65 = "미응답";
        }
        else
            answer65=edit_you50_65.getText().toString();

        if(edit_you50_66.getText().toString().equals("")){
            answer66 = "미응답";
        }
        else
            answer66=edit_you50_66.getText().toString();

        if(edit_you50_67.getText().toString().equals("")){
            answer67 = "미응답";
        }
        else
            answer67=edit_you50_67.getText().toString();

        if(edit_you50_68.getText().toString().equals("")){
            answer68 = "미응답";
        }
        else
            answer68=edit_you50_68.getText().toString();

        if(edit_you50_69.getText().toString().equals("")){
            answer69 = "미응답";
        }
        else
            answer69=edit_you50_69.getText().toString();

        if(edit_you50_70.getText().toString().equals("")){
            answer70 = "미응답";
        }
        else
            answer70=edit_you50_70.getText().toString();

        if(edit_you50_71.getText().toString().equals("")){
            answer71 = "미응답";
        }
        else
            answer71=edit_you50_71.getText().toString();

        if(edit_you50_72.getText().toString().equals("")){
            answer72 = "미응답";
        }
        else
            answer72=edit_you50_72.getText().toString();

        if(edit_you50_73.getText().toString().equals("")){
            answer73 = "미응답";
        }
        else
            answer73=edit_you50_73.getText().toString();

        if(edit_you50_74.getText().toString().equals("")){
            answer74 = "미응답";
        }
        else
            answer74=edit_you50_74.getText().toString();

        if(edit_you50_75.getText().toString().equals("")){
            answer75 = "미응답";
        }
        else
            answer75=edit_you50_75.getText().toString();

        if(edit_you50_76.getText().toString().equals("")){
            answer76 = "미응답";
        }
        else
            answer76=edit_you50_76.getText().toString();

        if(edit_you50_77.getText().toString().equals("")){
            answer77 = "미응답";
        }
        else
            answer77=edit_you50_77.getText().toString();

        if(edit_you50_78.getText().toString().equals("")){
            answer78 = "미응답";
        }
        else
            answer78=edit_you50_78.getText().toString();

        if(edit_you50_79.getText().toString().equals("")){
            answer79 = "미응답";
        }
        else
            answer79=edit_you50_79.getText().toString();

        if(edit_you50_80.getText().toString().equals("")){
            answer80 = "미응답";
        }
        else
            answer80=edit_you50_80.getText().toString();

        if(edit_you50_81.getText().toString().equals("")){
            answer81 = "미응답";
        }
        else
            answer81=edit_you50_81.getText().toString();

        if(edit_you50_82.getText().toString().equals("")){
            answer82 = "미응답";
        }
        else
            answer82=edit_you50_82.getText().toString();

        if(edit_you50_83.getText().toString().equals("")){
            answer83 = "미응답";
        }
        else
            answer83=edit_you50_83.getText().toString();

        if(edit_you50_84.getText().toString().equals("")){
            answer84 = "미응답";
        }
        else
            answer84=edit_you50_84.getText().toString();

        if(edit_you50_85.getText().toString().equals("")){
            answer85 = "미응답";
        }
        else
            answer85=edit_you50_85.getText().toString();

        if(edit_you50_86.getText().toString().equals("")){
            answer86 = "미응답";
        }
        else
            answer86=edit_you50_86.getText().toString();

        if(edit_you50_87.getText().toString().equals("")){
            answer87 = "미응답";
        }
        else
            answer87=edit_you50_87.getText().toString();

        if(edit_you50_88.getText().toString().equals("")){
            answer88 = "미응답";
        }
        else
            answer88=edit_you50_88.getText().toString();

        if(edit_you50_89.getText().toString().equals("")){
            answer89 = "미응답";
        }
        else
            answer89=edit_you50_89.getText().toString();

        if(edit_you50_90.getText().toString().equals("")){
            answer90 = "미응답";
        }
        else
            answer90=edit_you50_90.getText().toString();

        if(edit_you50_91.getText().toString().equals("")){
            answer91 = "미응답";
        }
        else
            answer91=edit_you50_91.getText().toString();

        if(edit_you50_92.getText().toString().equals("")){
            answer92 = "미응답";
        }
        else
            answer92=edit_you50_92.getText().toString();

        if(edit_you50_93.getText().toString().equals("")){
            answer93 = "미응답";
        }
        else
            answer93=edit_you50_93.getText().toString();

        if(edit_you50_94.getText().toString().equals("")){
            answer94 = "미응답";
        }
        else
            answer94=edit_you50_94.getText().toString();

        if(edit_you50_95.getText().toString().equals("")){
            answer95 = "미응답";
        }
        else
            answer95=edit_you50_95.getText().toString();

        if(edit_you50_96.getText().toString().equals("")){
            answer96 = "미응답";
        }
        else
            answer96=edit_you50_96.getText().toString();

        if(edit_you50_97.getText().toString().equals("")){
            answer97 = "미응답";
        }
        else
            answer97=edit_you50_97.getText().toString();

        if(edit_you50_98.getText().toString().equals("")){
            answer98 = "미응답";
        }
        else
            answer98=edit_you50_98.getText().toString();

        if(edit_you50_99.getText().toString().equals("")){
            answer99 = "미응답";
        }
        else
            answer99=edit_you50_99.getText().toString();

        if(edit_you50_100.getText().toString().equals("")){
            answer100 = "미응답";
        }
        else
            answer100=edit_you50_100.getText().toString();




        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogUpdate customDialog = new CustomDialogUpdate(Question_you_100.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_you_100.this);
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

        You100SendUpdateRequest registerRequest = new You100SendUpdateRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32,
                answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40, answer41, answer42, answer43,
                answer44, answer45, answer46, answer47, answer48, answer49, answer50, answer51, answer52, answer53,
                answer54, answer55, answer56, answer57, answer58, answer59, answer60,answer61, answer62, answer63,
                answer64, answer65, answer66, answer67, answer68, answer69, answer70,answer71, answer72, answer73,
                answer74, answer75, answer76, answer77, answer78, answer79, answer80,answer81, answer82, answer83,
                answer84, answer85, answer86, answer87, answer88, answer89, answer90,answer91, answer92, answer93,
                answer94, answer95, answer96, answer97, answer98, answer99, answer100, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_you_100.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }

    // 채팅방
    class BackgroundTask_send extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_you100SendList.php";
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

            you50List = new ArrayList<Self100>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                        self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                        self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                        self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                        self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50,
                        self50Answer51, self50Answer52, self50Answer53, self50Answer54, self50Answer55, self50Answer56, self50Answer57, self50Answer58, self50Answer59, self50Answer60,
                        self50Answer61, self50Answer62, self50Answer63, self50Answer64, self50Answer65, self50Answer66, self50Answer67, self50Answer68, self50Answer69, self50Answer70,
                        self50Answer71, self50Answer72, self50Answer73, self50Answer74, self50Answer75, self50Answer76, self50Answer77, self50Answer78, self50Answer79, self50Answer80,
                        self50Answer81, self50Answer82, self50Answer83, self50Answer84, self50Answer85, self50Answer86, self50Answer87, self50Answer88, self50Answer89, self50Answer90,
                        self50Answer91, self50Answer92, self50Answer93, self50Answer94, self50Answer95, self50Answer96, self50Answer97, self50Answer98, self50Answer99, self50Answer100;

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
                    self50Answer51 = object.getString("self50Answer51");
                    self50Answer52 = object.getString("self50Answer52");
                    self50Answer53 = object.getString("self50Answer53");
                    self50Answer54 = object.getString("self50Answer54");
                    self50Answer55 = object.getString("self50Answer55");
                    self50Answer56 = object.getString("self50Answer56");
                    self50Answer57 = object.getString("self50Answer57");
                    self50Answer58 = object.getString("self50Answer58");
                    self50Answer59 = object.getString("self50Answer59");
                    self50Answer60 = object.getString("self50Answer60");
                    self50Answer61 = object.getString("self50Answer61");
                    self50Answer62 = object.getString("self50Answer62");
                    self50Answer63 = object.getString("self50Answer63");
                    self50Answer64 = object.getString("self50Answer64");
                    self50Answer65 = object.getString("self50Answer65");
                    self50Answer66 = object.getString("self50Answer66");
                    self50Answer67 = object.getString("self50Answer67");
                    self50Answer68 = object.getString("self50Answer68");
                    self50Answer69 = object.getString("self50Answer69");
                    self50Answer70 = object.getString("self50Answer70");
                    self50Answer71 = object.getString("self50Answer71");
                    self50Answer72 = object.getString("self50Answer72");
                    self50Answer73 = object.getString("self50Answer73");
                    self50Answer74 = object.getString("self50Answer74");
                    self50Answer75 = object.getString("self50Answer75");
                    self50Answer76 = object.getString("self50Answer76");
                    self50Answer77 = object.getString("self50Answer77");
                    self50Answer78 = object.getString("self50Answer78");
                    self50Answer79 = object.getString("self50Answer79");
                    self50Answer80 = object.getString("self50Answer80");
                    self50Answer81 = object.getString("self50Answer81");
                    self50Answer82 = object.getString("self50Answer82");
                    self50Answer83 = object.getString("self50Answer83");
                    self50Answer84 = object.getString("self50Answer84");
                    self50Answer85 = object.getString("self50Answer85");
                    self50Answer86 = object.getString("self50Answer86");
                    self50Answer87 = object.getString("self50Answer87");
                    self50Answer88 = object.getString("self50Answer88");
                    self50Answer89 = object.getString("self50Answer89");
                    self50Answer90 = object.getString("self50Answer90");
                    self50Answer91 = object.getString("self50Answer91");
                    self50Answer92 = object.getString("self50Answer92");
                    self50Answer93 = object.getString("self50Answer93");
                    self50Answer94 = object.getString("self50Answer94");
                    self50Answer95 = object.getString("self50Answer95");
                    self50Answer96 = object.getString("self50Answer96");
                    self50Answer97 = object.getString("self50Answer97");
                    self50Answer98 = object.getString("self50Answer98");
                    self50Answer99 = object.getString("self50Answer99");
                    self50Answer100 = object.getString("self50Answer100");

                    if(self50ID.equals(LoginUserID)) {
                        Self100 self100 = new Self100(self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                                self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                                self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                                self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                                self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50,
                                self50Answer51, self50Answer52, self50Answer53, self50Answer54, self50Answer55, self50Answer56, self50Answer57, self50Answer58, self50Answer59, self50Answer60,
                                self50Answer61, self50Answer62, self50Answer63, self50Answer64, self50Answer65, self50Answer66, self50Answer67, self50Answer68, self50Answer69, self50Answer70,
                                self50Answer71, self50Answer72, self50Answer73, self50Answer74, self50Answer75, self50Answer76, self50Answer77, self50Answer78, self50Answer79, self50Answer80,
                                self50Answer81, self50Answer82, self50Answer83, self50Answer84, self50Answer85, self50Answer86, self50Answer87, self50Answer88, self50Answer89, self50Answer90,
                                self50Answer91, self50Answer92, self50Answer93, self50Answer94, self50Answer95, self50Answer96, self50Answer97, self50Answer98, self50Answer99, self50Answer100);
                        you50List.add(self100);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(you50List.size()>=1){
                self50_update_send();
            }
            else if(you50List.size()==0){
                self50_send();
            }




        }

    }

    // 채팅방
    class BackgroundTask_you50List extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_you100List.php";
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

            you50List = new ArrayList<Self100>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                        self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                        self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                        self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                        self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50,
                        self50Answer51, self50Answer52, self50Answer53, self50Answer54, self50Answer55, self50Answer56, self50Answer57, self50Answer58, self50Answer59, self50Answer60,
                        self50Answer61, self50Answer62, self50Answer63, self50Answer64, self50Answer65, self50Answer66, self50Answer67, self50Answer68, self50Answer69, self50Answer70,
                        self50Answer71, self50Answer72, self50Answer73, self50Answer74, self50Answer75, self50Answer76, self50Answer77, self50Answer78, self50Answer79, self50Answer80,
                        self50Answer81, self50Answer82, self50Answer83, self50Answer84, self50Answer85, self50Answer86, self50Answer87, self50Answer88, self50Answer89, self50Answer90,
                        self50Answer91, self50Answer92, self50Answer93, self50Answer94, self50Answer95, self50Answer96, self50Answer97, self50Answer98, self50Answer99, self50Answer100;

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
                    self50Answer51 = object.getString("self50Answer51");
                    self50Answer52 = object.getString("self50Answer52");
                    self50Answer53 = object.getString("self50Answer53");
                    self50Answer54 = object.getString("self50Answer54");
                    self50Answer55 = object.getString("self50Answer55");
                    self50Answer56 = object.getString("self50Answer56");
                    self50Answer57 = object.getString("self50Answer57");
                    self50Answer58 = object.getString("self50Answer58");
                    self50Answer59 = object.getString("self50Answer59");
                    self50Answer60 = object.getString("self50Answer60");
                    self50Answer61 = object.getString("self50Answer61");
                    self50Answer62 = object.getString("self50Answer62");
                    self50Answer63 = object.getString("self50Answer63");
                    self50Answer64 = object.getString("self50Answer64");
                    self50Answer65 = object.getString("self50Answer65");
                    self50Answer66 = object.getString("self50Answer66");
                    self50Answer67 = object.getString("self50Answer67");
                    self50Answer68 = object.getString("self50Answer68");
                    self50Answer69 = object.getString("self50Answer69");
                    self50Answer70 = object.getString("self50Answer70");
                    self50Answer71 = object.getString("self50Answer71");
                    self50Answer72 = object.getString("self50Answer72");
                    self50Answer73 = object.getString("self50Answer73");
                    self50Answer74 = object.getString("self50Answer74");
                    self50Answer75 = object.getString("self50Answer75");
                    self50Answer76 = object.getString("self50Answer76");
                    self50Answer77 = object.getString("self50Answer77");
                    self50Answer78 = object.getString("self50Answer78");
                    self50Answer79 = object.getString("self50Answer79");
                    self50Answer80 = object.getString("self50Answer80");
                    self50Answer81 = object.getString("self50Answer81");
                    self50Answer82 = object.getString("self50Answer82");
                    self50Answer83 = object.getString("self50Answer83");
                    self50Answer84 = object.getString("self50Answer84");
                    self50Answer85 = object.getString("self50Answer85");
                    self50Answer86 = object.getString("self50Answer86");
                    self50Answer87 = object.getString("self50Answer87");
                    self50Answer88 = object.getString("self50Answer88");
                    self50Answer89 = object.getString("self50Answer89");
                    self50Answer90 = object.getString("self50Answer90");
                    self50Answer91 = object.getString("self50Answer91");
                    self50Answer92 = object.getString("self50Answer92");
                    self50Answer93 = object.getString("self50Answer93");
                    self50Answer94 = object.getString("self50Answer94");
                    self50Answer95 = object.getString("self50Answer95");
                    self50Answer96 = object.getString("self50Answer96");
                    self50Answer97 = object.getString("self50Answer97");
                    self50Answer98 = object.getString("self50Answer98");
                    self50Answer99 = object.getString("self50Answer99");
                    self50Answer100 = object.getString("self50Answer100");

                    if(self50ID.equals(LoginUserID)) {
                        Self100 self100 = new Self100(self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                                self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                                self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                                self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                                self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50,
                                self50Answer51, self50Answer52, self50Answer53, self50Answer54, self50Answer55, self50Answer56, self50Answer57, self50Answer58, self50Answer59, self50Answer60,
                                self50Answer61, self50Answer62, self50Answer63, self50Answer64, self50Answer65, self50Answer66, self50Answer67, self50Answer68, self50Answer69, self50Answer70,
                                self50Answer71, self50Answer72, self50Answer73, self50Answer74, self50Answer75, self50Answer76, self50Answer77, self50Answer78, self50Answer79, self50Answer80,
                                self50Answer81, self50Answer82, self50Answer83, self50Answer84, self50Answer85, self50Answer86, self50Answer87, self50Answer88, self50Answer89, self50Answer90,
                                self50Answer91, self50Answer92, self50Answer93, self50Answer94, self50Answer95, self50Answer96, self50Answer97, self50Answer98, self50Answer99, self50Answer100);
                        you50List.add(self100);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }
            if(you50List.size()>=1) {
                edit_you50_1.setText(you50List.get(0).getSelf50Answer1());
                edit_you50_2.setText(you50List.get(0).getSelf50Answer2());
                edit_you50_3.setText(you50List.get(0).getSelf50Answer3());
                edit_you50_4.setText(you50List.get(0).getSelf50Answer4());
                edit_you50_5.setText(you50List.get(0).getSelf50Answer5());
                edit_you50_6.setText(you50List.get(0).getSelf50Answer6());
                edit_you50_7.setText(you50List.get(0).getSelf50Answer7());
                edit_you50_8.setText(you50List.get(0).getSelf50Answer8());
                edit_you50_9.setText(you50List.get(0).getSelf50Answer9());
                edit_you50_10.setText(you50List.get(0).getSelf50Answer10());
                edit_you50_11.setText(you50List.get(0).getSelf50Answer11());
                edit_you50_12.setText(you50List.get(0).getSelf50Answer12());
                edit_you50_13.setText(you50List.get(0).getSelf50Answer13());
                edit_you50_14.setText(you50List.get(0).getSelf50Answer14());
                edit_you50_15.setText(you50List.get(0).getSelf50Answer15());
                edit_you50_16.setText(you50List.get(0).getSelf50Answer16());
                edit_you50_17.setText(you50List.get(0).getSelf50Answer17());
                edit_you50_18.setText(you50List.get(0).getSelf50Answer18());
                edit_you50_19.setText(you50List.get(0).getSelf50Answer19());
                edit_you50_20.setText(you50List.get(0).getSelf50Answer20());
                edit_you50_21.setText(you50List.get(0).getSelf50Answer21());
                edit_you50_22.setText(you50List.get(0).getSelf50Answer22());
                edit_you50_23.setText(you50List.get(0).getSelf50Answer23());
                edit_you50_24.setText(you50List.get(0).getSelf50Answer24());
                edit_you50_25.setText(you50List.get(0).getSelf50Answer25());
                edit_you50_26.setText(you50List.get(0).getSelf50Answer26());
                edit_you50_27.setText(you50List.get(0).getSelf50Answer27());
                edit_you50_28.setText(you50List.get(0).getSelf50Answer28());
                edit_you50_29.setText(you50List.get(0).getSelf50Answer29());
                edit_you50_30.setText(you50List.get(0).getSelf50Answer30());
                edit_you50_31.setText(you50List.get(0).getSelf50Answer31());
                edit_you50_32.setText(you50List.get(0).getSelf50Answer32());
                edit_you50_33.setText(you50List.get(0).getSelf50Answer33());
                edit_you50_34.setText(you50List.get(0).getSelf50Answer34());
                edit_you50_35.setText(you50List.get(0).getSelf50Answer35());
                edit_you50_36.setText(you50List.get(0).getSelf50Answer36());
                edit_you50_37.setText(you50List.get(0).getSelf50Answer37());
                edit_you50_38.setText(you50List.get(0).getSelf50Answer38());
                edit_you50_39.setText(you50List.get(0).getSelf50Answer39());
                edit_you50_40.setText(you50List.get(0).getSelf50Answer40());
                edit_you50_41.setText(you50List.get(0).getSelf50Answer41());
                edit_you50_42.setText(you50List.get(0).getSelf50Answer42());
                edit_you50_43.setText(you50List.get(0).getSelf50Answer43());
                edit_you50_44.setText(you50List.get(0).getSelf50Answer44());
                edit_you50_45.setText(you50List.get(0).getSelf50Answer45());
                edit_you50_46.setText(you50List.get(0).getSelf50Answer46());
                edit_you50_47.setText(you50List.get(0).getSelf50Answer47());
                edit_you50_48.setText(you50List.get(0).getSelf50Answer48());
                edit_you50_49.setText(you50List.get(0).getSelf50Answer49());
                edit_you50_50.setText(you50List.get(0).getSelf50Answer50());
                edit_you50_51.setText(you50List.get(0).getSelf50Answer51());
                edit_you50_52.setText(you50List.get(0).getSelf50Answer52());
                edit_you50_53.setText(you50List.get(0).getSelf50Answer53());
                edit_you50_54.setText(you50List.get(0).getSelf50Answer54());
                edit_you50_55.setText(you50List.get(0).getSelf50Answer55());
                edit_you50_56.setText(you50List.get(0).getSelf50Answer56());
                edit_you50_57.setText(you50List.get(0).getSelf50Answer57());
                edit_you50_58.setText(you50List.get(0).getSelf50Answer58());
                edit_you50_59.setText(you50List.get(0).getSelf50Answer59());
                edit_you50_60.setText(you50List.get(0).getSelf50Answer60());
                edit_you50_61.setText(you50List.get(0).getSelf50Answer61());
                edit_you50_62.setText(you50List.get(0).getSelf50Answer62());
                edit_you50_63.setText(you50List.get(0).getSelf50Answer63());
                edit_you50_64.setText(you50List.get(0).getSelf50Answer64());
                edit_you50_65.setText(you50List.get(0).getSelf50Answer65());
                edit_you50_66.setText(you50List.get(0).getSelf50Answer66());
                edit_you50_67.setText(you50List.get(0).getSelf50Answer67());
                edit_you50_68.setText(you50List.get(0).getSelf50Answer68());
                edit_you50_69.setText(you50List.get(0).getSelf50Answer69());
                edit_you50_70.setText(you50List.get(0).getSelf50Answer70());
                edit_you50_71.setText(you50List.get(0).getSelf50Answer71());
                edit_you50_72.setText(you50List.get(0).getSelf50Answer72());
                edit_you50_73.setText(you50List.get(0).getSelf50Answer73());
                edit_you50_74.setText(you50List.get(0).getSelf50Answer74());
                edit_you50_75.setText(you50List.get(0).getSelf50Answer75());
                edit_you50_76.setText(you50List.get(0).getSelf50Answer76());
                edit_you50_77.setText(you50List.get(0).getSelf50Answer77());
                edit_you50_78.setText(you50List.get(0).getSelf50Answer78());
                edit_you50_79.setText(you50List.get(0).getSelf50Answer79());
                edit_you50_80.setText(you50List.get(0).getSelf50Answer80());
                edit_you50_81.setText(you50List.get(0).getSelf50Answer81());
                edit_you50_82.setText(you50List.get(0).getSelf50Answer82());
                edit_you50_83.setText(you50List.get(0).getSelf50Answer83());
                edit_you50_84.setText(you50List.get(0).getSelf50Answer84());
                edit_you50_85.setText(you50List.get(0).getSelf50Answer85());
                edit_you50_86.setText(you50List.get(0).getSelf50Answer86());
                edit_you50_87.setText(you50List.get(0).getSelf50Answer87());
                edit_you50_88.setText(you50List.get(0).getSelf50Answer88());
                edit_you50_89.setText(you50List.get(0).getSelf50Answer89());
                edit_you50_90.setText(you50List.get(0).getSelf50Answer90());
                edit_you50_91.setText(you50List.get(0).getSelf50Answer91());
                edit_you50_92.setText(you50List.get(0).getSelf50Answer92());
                edit_you50_93.setText(you50List.get(0).getSelf50Answer93());
                edit_you50_94.setText(you50List.get(0).getSelf50Answer94());
                edit_you50_95.setText(you50List.get(0).getSelf50Answer95());
                edit_you50_96.setText(you50List.get(0).getSelf50Answer96());
                edit_you50_97.setText(you50List.get(0).getSelf50Answer97());
                edit_you50_98.setText(you50List.get(0).getSelf50Answer98());
                edit_you50_99.setText(you50List.get(0).getSelf50Answer99());
                edit_you50_100.setText(you50List.get(0).getSelf50Answer100());

            }



        }

    }

}
