package com.mglj.couplelogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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

import static com.mglj.couplelogin.MainLogin.CoupleID;
import static com.mglj.couplelogin.SerchActivity.LoginUserID;

public class you100_info extends AppCompatActivity {
    InterstitialAd adfull;
    TextView self50_anwser1, self50_anwser2, self50_anwser3, self50_anwser4, self50_anwser5, self50_anwser6, self50_anwser7, self50_anwser8,
            self50_anwser9, self50_anwser10, self50_anwser11, self50_anwser12, self50_anwser13, self50_anwser14, self50_anwser15, self50_anwser16
            ,self50_anwser17, self50_anwser18, self50_anwser19, self50_anwser20, self50_anwser21, self50_anwser22, self50_anwser23, self50_anwser24,
            self50_anwser25, self50_anwser26, self50_anwser27, self50_anwser28, self50_anwser29, self50_anwser30, self50_anwser31, self50_anwser32,
            self50_anwser33, self50_anwser34, self50_anwser35, self50_anwser36, self50_anwser37, self50_anwser38, self50_anwser39, self50_anwser40,
            self50_anwser41, self50_anwser42, self50_anwser43, self50_anwser44, self50_anwser45, self50_anwser46, self50_anwser47, self50_anwser48,
            self50_anwser49, self50_anwser50, self50_anwser51, self50_anwser52, self50_anwser53, self50_anwser54, self50_anwser55, self50_anwser56, self50_anwser57, self50_anwser58,
            self50_anwser59, self50_anwser60, self50_anwser61, self50_anwser62, self50_anwser63, self50_anwser64, self50_anwser65, self50_anwser66, self50_anwser67, self50_anwser68,
            self50_anwser69, self50_anwser70, self50_anwser71, self50_anwser72, self50_anwser73, self50_anwser74, self50_anwser75, self50_anwser76, self50_anwser77, self50_anwser78,
            self50_anwser79, self50_anwser80, self50_anwser81, self50_anwser82, self50_anwser83, self50_anwser84, self50_anwser85, self50_anwser86, self50_anwser87, self50_anwser88,
            self50_anwser89, self50_anwser90 ,self50_anwser91, self50_anwser92, self50_anwser93, self50_anwser94, self50_anwser95, self50_anwser96, self50_anwser97, self50_anwser98,
            self50_anwser99, self50_anwser100;

    EditText you50_answer1, you50_answer2, you50_answer3, you50_answer4, you50_answer5, you50_answer6, you50_answer7, you50_answer8, you50_answer9, you50_answer10,
            you50_answer11, you50_answer12, you50_answer13, you50_answer14, you50_answer15, you50_answer16, you50_answer17, you50_answer18, you50_answer19, you50_answer20,
            you50_answer21, you50_answer22, you50_answer23, you50_answer24, you50_answer25, you50_answer26, you50_answer27, you50_answer28, you50_answer29, you50_answer30,
            you50_answer31, you50_answer32, you50_answer33, you50_answer34, you50_answer35, you50_answer36, you50_answer37, you50_answer38, you50_answer39, you50_answer40,
            you50_answer41, you50_answer42, you50_answer43, you50_answer44, you50_answer45, you50_answer46, you50_answer47, you50_answer48, you50_answer49, you50_answer50,
            you50_answer51, you50_answer52, you50_answer53, you50_answer54, you50_answer55, you50_answer56, you50_answer57, you50_answer58, you50_answer59, you50_answer60,
            you50_answer61, you50_answer62, you50_answer63, you50_answer64, you50_answer65, you50_answer66, you50_answer67, you50_answer68, you50_answer69, you50_answer70,
            you50_answer71, you50_answer72, you50_answer73, you50_answer74, you50_answer75, you50_answer76, you50_answer77, you50_answer78, you50_answer79, you50_answer80,
            you50_answer81, you50_answer82, you50_answer83, you50_answer84, you50_answer85, you50_answer86, you50_answer87, you50_answer88, you50_answer89, you50_answer90,
            you50_answer91, you50_answer92, you50_answer93, you50_answer94, you50_answer95, you50_answer96, you50_answer97, you50_answer98, you50_answer99, you50_answer100;

    TextView btn_send, text_hide;
    ScrollView scroll_hide;
    ImageView de_no_cancle, de_no_can;
    List<Self100> self50List;
    LinearLayout layout_hide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you100_info);

        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);

        text_hide = (TextView)findViewById(R.id.text_hide);
        scroll_hide = (ScrollView)findViewById(R.id.scroll_hide);
        layout_hide = (LinearLayout)findViewById(R.id.layout_hide);
        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        adfull = new InterstitialAd(this);
        adfull.setAdUnitId("ca-app-pub-5784293657699097/5193862959");
        adfull.loadAd(new AdRequest.Builder().build());
        self50_anwser1 = (TextView)findViewById(R.id.self50_anwser1);
        self50_anwser2 = (TextView)findViewById(R.id.self50_anwser2);
        self50_anwser3 = (TextView)findViewById(R.id.self50_anwser3);
        self50_anwser4 = (TextView)findViewById(R.id.self50_anwser4);
        self50_anwser5 = (TextView)findViewById(R.id.self50_anwser5);
        self50_anwser6 = (TextView)findViewById(R.id.self50_anwser6);
        self50_anwser7 = (TextView)findViewById(R.id.self50_anwser7);
        self50_anwser8 = (TextView)findViewById(R.id.self50_anwser8);
        self50_anwser9 = (TextView)findViewById(R.id.self50_anwser9);
        self50_anwser10 = (TextView)findViewById(R.id.self50_anwser10);
        self50_anwser11 = (TextView)findViewById(R.id.self50_anwser11);
        self50_anwser12 = (TextView)findViewById(R.id.self50_anwser12);
        self50_anwser13 = (TextView)findViewById(R.id.self50_anwser13);
        self50_anwser14 = (TextView)findViewById(R.id.self50_anwser14);
        self50_anwser15 = (TextView)findViewById(R.id.self50_anwser15);
        self50_anwser16 = (TextView)findViewById(R.id.self50_anwser16);
        self50_anwser17 = (TextView)findViewById(R.id.self50_anwser17);
        self50_anwser18 = (TextView)findViewById(R.id.self50_anwser18);
        self50_anwser19 = (TextView)findViewById(R.id.self50_anwser19);
        self50_anwser20 = (TextView)findViewById(R.id.self50_anwser20);
        self50_anwser21 = (TextView)findViewById(R.id.self50_anwser21);
        self50_anwser22 = (TextView)findViewById(R.id.self50_anwser22);
        self50_anwser23 = (TextView)findViewById(R.id.self50_anwser23);
        self50_anwser24 = (TextView)findViewById(R.id.self50_anwser24);
        self50_anwser25 = (TextView)findViewById(R.id.self50_anwser25);
        self50_anwser26 = (TextView)findViewById(R.id.self50_anwser26);
        self50_anwser27 = (TextView)findViewById(R.id.self50_anwser27);
        self50_anwser28 = (TextView)findViewById(R.id.self50_anwser28);
        self50_anwser29 = (TextView)findViewById(R.id.self50_anwser29);
        self50_anwser30 = (TextView)findViewById(R.id.self50_anwser30);
        self50_anwser31 = (TextView)findViewById(R.id.self50_anwser31);
        self50_anwser32 = (TextView)findViewById(R.id.self50_anwser32);
        self50_anwser33 = (TextView)findViewById(R.id.self50_anwser33);
        self50_anwser34 = (TextView)findViewById(R.id.self50_anwser34);
        self50_anwser35 = (TextView)findViewById(R.id.self50_anwser35);
        self50_anwser36 = (TextView)findViewById(R.id.self50_anwser36);
        self50_anwser37 = (TextView)findViewById(R.id.self50_anwser37);
        self50_anwser38 = (TextView)findViewById(R.id.self50_anwser38);
        self50_anwser39 = (TextView)findViewById(R.id.self50_anwser39);
        self50_anwser40 = (TextView)findViewById(R.id.self50_anwser40);
        self50_anwser41 = (TextView)findViewById(R.id.self50_anwser41);
        self50_anwser42 = (TextView)findViewById(R.id.self50_anwser42);
        self50_anwser43 = (TextView)findViewById(R.id.self50_anwser43);
        self50_anwser44 = (TextView)findViewById(R.id.self50_anwser44);
        self50_anwser45 = (TextView)findViewById(R.id.self50_anwser45);
        self50_anwser46 = (TextView)findViewById(R.id.self50_anwser46);
        self50_anwser47 = (TextView)findViewById(R.id.self50_anwser47);
        self50_anwser48 = (TextView)findViewById(R.id.self50_anwser48);
        self50_anwser49 = (TextView)findViewById(R.id.self50_anwser49);
        self50_anwser50 = (TextView)findViewById(R.id.self50_anwser50);
        self50_anwser51 = (TextView)findViewById(R.id.self50_anwser51);
        self50_anwser52 = (TextView)findViewById(R.id.self50_anwser52);
        self50_anwser53 = (TextView)findViewById(R.id.self50_anwser53);
        self50_anwser54 = (TextView)findViewById(R.id.self50_anwser54);
        self50_anwser55 = (TextView)findViewById(R.id.self50_anwser55);
        self50_anwser56 = (TextView)findViewById(R.id.self50_anwser56);
        self50_anwser57 = (TextView)findViewById(R.id.self50_anwser57);
        self50_anwser58 = (TextView)findViewById(R.id.self50_anwser58);
        self50_anwser59 = (TextView)findViewById(R.id.self50_anwser59);
        self50_anwser60 = (TextView)findViewById(R.id.self50_anwser60);
        self50_anwser61 = (TextView)findViewById(R.id.self50_anwser61);
        self50_anwser62 = (TextView)findViewById(R.id.self50_anwser62);
        self50_anwser63 = (TextView)findViewById(R.id.self50_anwser63);
        self50_anwser64 = (TextView)findViewById(R.id.self50_anwser64);
        self50_anwser65 = (TextView)findViewById(R.id.self50_anwser65);
        self50_anwser66 = (TextView)findViewById(R.id.self50_anwser66);
        self50_anwser67 = (TextView)findViewById(R.id.self50_anwser67);
        self50_anwser68 = (TextView)findViewById(R.id.self50_anwser68);
        self50_anwser69 = (TextView)findViewById(R.id.self50_anwser69);
        self50_anwser70 = (TextView)findViewById(R.id.self50_anwser70);
        self50_anwser71 = (TextView)findViewById(R.id.self50_anwser71);
        self50_anwser72 = (TextView)findViewById(R.id.self50_anwser72);
        self50_anwser73 = (TextView)findViewById(R.id.self50_anwser73);
        self50_anwser74 = (TextView)findViewById(R.id.self50_anwser74);
        self50_anwser75 = (TextView)findViewById(R.id.self50_anwser75);
        self50_anwser76 = (TextView)findViewById(R.id.self50_anwser76);
        self50_anwser77 = (TextView)findViewById(R.id.self50_anwser77);
        self50_anwser78 = (TextView)findViewById(R.id.self50_anwser78);
        self50_anwser79 = (TextView)findViewById(R.id.self50_anwser79);
        self50_anwser80 = (TextView)findViewById(R.id.self50_anwser80);
        self50_anwser81 = (TextView)findViewById(R.id.self50_anwser81);
        self50_anwser82 = (TextView)findViewById(R.id.self50_anwser82);
        self50_anwser83 = (TextView)findViewById(R.id.self50_anwser83);
        self50_anwser84 = (TextView)findViewById(R.id.self50_anwser84);
        self50_anwser85 = (TextView)findViewById(R.id.self50_anwser85);
        self50_anwser86 = (TextView)findViewById(R.id.self50_anwser86);
        self50_anwser87 = (TextView)findViewById(R.id.self50_anwser87);
        self50_anwser88 = (TextView)findViewById(R.id.self50_anwser88);
        self50_anwser89 = (TextView)findViewById(R.id.self50_anwser89);
        self50_anwser90 = (TextView)findViewById(R.id.self50_anwser90);
        self50_anwser91 = (TextView)findViewById(R.id.self50_anwser91);
        self50_anwser92 = (TextView)findViewById(R.id.self50_anwser92);
        self50_anwser93 = (TextView)findViewById(R.id.self50_anwser93);
        self50_anwser94 = (TextView)findViewById(R.id.self50_anwser94);
        self50_anwser95 = (TextView)findViewById(R.id.self50_anwser95);
        self50_anwser96 = (TextView)findViewById(R.id.self50_anwser96);
        self50_anwser97 = (TextView)findViewById(R.id.self50_anwser97);
        self50_anwser98 = (TextView)findViewById(R.id.self50_anwser98);
        self50_anwser99 = (TextView)findViewById(R.id.self50_anwser99);
        self50_anwser100 = (TextView)findViewById(R.id.self50_anwser100);

        you50_answer1 = (EditText)findViewById(R.id.you50_answer1);
        you50_answer2 = (EditText)findViewById(R.id.you50_answer2);
        you50_answer3 = (EditText)findViewById(R.id.you50_answer3);
        you50_answer4 = (EditText)findViewById(R.id.you50_answer4);
        you50_answer5 = (EditText)findViewById(R.id.you50_answer5);
        you50_answer6 = (EditText)findViewById(R.id.you50_answer6);
        you50_answer7 = (EditText)findViewById(R.id.you50_answer7);
        you50_answer8 = (EditText)findViewById(R.id.you50_answer8);
        you50_answer9 = (EditText)findViewById(R.id.you50_answer9);
        you50_answer10 = (EditText)findViewById(R.id.you50_answer10);
        you50_answer11 = (EditText)findViewById(R.id.you50_answer11);
        you50_answer12 = (EditText)findViewById(R.id.you50_answer12);
        you50_answer13 = (EditText)findViewById(R.id.you50_answer13);
        you50_answer14 = (EditText)findViewById(R.id.you50_answer14);
        you50_answer15 = (EditText)findViewById(R.id.you50_answer15);
        you50_answer16 = (EditText)findViewById(R.id.you50_answer16);
        you50_answer17 = (EditText)findViewById(R.id.you50_answer17);
        you50_answer18 = (EditText)findViewById(R.id.you50_answer18);
        you50_answer19 = (EditText)findViewById(R.id.you50_answer19);
        you50_answer20 = (EditText)findViewById(R.id.you50_answer20);
        you50_answer21 = (EditText)findViewById(R.id.you50_answer21);
        you50_answer22 = (EditText)findViewById(R.id.you50_answer22);
        you50_answer23 = (EditText)findViewById(R.id.you50_answer23);
        you50_answer24 = (EditText)findViewById(R.id.you50_answer24);
        you50_answer25 = (EditText)findViewById(R.id.you50_answer25);
        you50_answer26 = (EditText)findViewById(R.id.you50_answer26);
        you50_answer27 = (EditText)findViewById(R.id.you50_answer27);
        you50_answer28 = (EditText)findViewById(R.id.you50_answer28);
        you50_answer29 = (EditText)findViewById(R.id.you50_answer29);
        you50_answer30 = (EditText)findViewById(R.id.you50_answer30);
        you50_answer31 = (EditText)findViewById(R.id.you50_answer31);
        you50_answer32 = (EditText)findViewById(R.id.you50_answer32);
        you50_answer33 = (EditText)findViewById(R.id.you50_answer33);
        you50_answer34 = (EditText)findViewById(R.id.you50_answer34);
        you50_answer35 = (EditText)findViewById(R.id.you50_answer35);
        you50_answer36 = (EditText)findViewById(R.id.you50_answer36);
        you50_answer37 = (EditText)findViewById(R.id.you50_answer37);
        you50_answer38 = (EditText)findViewById(R.id.you50_answer38);
        you50_answer39 = (EditText)findViewById(R.id.you50_answer39);
        you50_answer40 = (EditText)findViewById(R.id.you50_answer40);
        you50_answer41 = (EditText)findViewById(R.id.you50_answer41);
        you50_answer42 = (EditText)findViewById(R.id.you50_answer42);
        you50_answer43 = (EditText)findViewById(R.id.you50_answer43);
        you50_answer44 = (EditText)findViewById(R.id.you50_answer44);
        you50_answer45 = (EditText)findViewById(R.id.you50_answer45);
        you50_answer46 = (EditText)findViewById(R.id.you50_answer46);
        you50_answer47 = (EditText)findViewById(R.id.you50_answer47);
        you50_answer48 = (EditText)findViewById(R.id.you50_answer48);
        you50_answer49 = (EditText)findViewById(R.id.you50_answer49);
        you50_answer50 = (EditText)findViewById(R.id.you50_answer50);
        you50_answer51 = (EditText)findViewById(R.id.you50_answer51);
        you50_answer52 = (EditText)findViewById(R.id.you50_answer52);
        you50_answer53 = (EditText)findViewById(R.id.you50_answer53);
        you50_answer54 = (EditText)findViewById(R.id.you50_answer54);
        you50_answer55 = (EditText)findViewById(R.id.you50_answer55);
        you50_answer56 = (EditText)findViewById(R.id.you50_answer56);
        you50_answer57 = (EditText)findViewById(R.id.you50_answer57);
        you50_answer58 = (EditText)findViewById(R.id.you50_answer58);
        you50_answer59 = (EditText)findViewById(R.id.you50_answer59);
        you50_answer60 = (EditText)findViewById(R.id.you50_answer60);
        you50_answer61 = (EditText)findViewById(R.id.you50_answer61);
        you50_answer62 = (EditText)findViewById(R.id.you50_answer62);
        you50_answer63 = (EditText)findViewById(R.id.you50_answer63);
        you50_answer64 = (EditText)findViewById(R.id.you50_answer64);
        you50_answer65 = (EditText)findViewById(R.id.you50_answer65);
        you50_answer66 = (EditText)findViewById(R.id.you50_answer66);
        you50_answer67 = (EditText)findViewById(R.id.you50_answer67);
        you50_answer68 = (EditText)findViewById(R.id.you50_answer68);
        you50_answer69 = (EditText)findViewById(R.id.you50_answer69);
        you50_answer70 = (EditText)findViewById(R.id.you50_answer70);
        you50_answer71 = (EditText)findViewById(R.id.you50_answer71);
        you50_answer72 = (EditText)findViewById(R.id.you50_answer72);
        you50_answer73 = (EditText)findViewById(R.id.you50_answer73);
        you50_answer74 = (EditText)findViewById(R.id.you50_answer74);
        you50_answer75 = (EditText)findViewById(R.id.you50_answer75);
        you50_answer76 = (EditText)findViewById(R.id.you50_answer76);
        you50_answer77 = (EditText)findViewById(R.id.you50_answer77);
        you50_answer78 = (EditText)findViewById(R.id.you50_answer78);
        you50_answer79 = (EditText)findViewById(R.id.you50_answer79);
        you50_answer80 = (EditText)findViewById(R.id.you50_answer80);
        you50_answer81 = (EditText)findViewById(R.id.you50_answer81);
        you50_answer82 = (EditText)findViewById(R.id.you50_answer82);
        you50_answer83 = (EditText)findViewById(R.id.you50_answer83);
        you50_answer84 = (EditText)findViewById(R.id.you50_answer84);
        you50_answer85 = (EditText)findViewById(R.id.you50_answer85);
        you50_answer86 = (EditText)findViewById(R.id.you50_answer86);
        you50_answer87 = (EditText)findViewById(R.id.you50_answer87);
        you50_answer88 = (EditText)findViewById(R.id.you50_answer88);
        you50_answer89 = (EditText)findViewById(R.id.you50_answer89);
        you50_answer90 = (EditText)findViewById(R.id.you50_answer90);
        you50_answer91 = (EditText)findViewById(R.id.you50_answer91);
        you50_answer92 = (EditText)findViewById(R.id.you50_answer92);
        you50_answer93 = (EditText)findViewById(R.id.you50_answer93);
        you50_answer94 = (EditText)findViewById(R.id.you50_answer94);
        you50_answer95 = (EditText)findViewById(R.id.you50_answer95);
        you50_answer96 = (EditText)findViewById(R.id.you50_answer96);
        you50_answer97 = (EditText)findViewById(R.id.you50_answer97);
        you50_answer98 = (EditText)findViewById(R.id.you50_answer98);
        you50_answer99 = (EditText)findViewById(R.id.you50_answer99);
        you50_answer100 = (EditText)findViewById(R.id.you50_answer100);

        btn_send =(TextView)findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(adfull.isLoaded()){
                    adfull.show();
                };
                new BackgroundTask_giveList_send().execute();

            }
        });

        new BackgroundTask_giveList().execute();

        new BackgroundTask_roomList().execute();
    }

    // 채팅방
    class BackgroundTask_roomList extends AsyncTask<Void, Void, String> {

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

            self50List = new ArrayList<Self100>();

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

                    if(self50ID.equals(CoupleID)) {
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
                        self50List.add(self100);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(self50List.size()>=1){
                self50_anwser1.setText("1. "+self50List.get(0).getSelf50Answer1());
                self50_anwser2.setText("2. "+self50List.get(0).getSelf50Answer2());
                self50_anwser3.setText("3. "+self50List.get(0).getSelf50Answer3());
                self50_anwser4.setText("4. "+self50List.get(0).getSelf50Answer4());
                self50_anwser5.setText("5. "+self50List.get(0).getSelf50Answer5());
                self50_anwser6.setText("6. "+self50List.get(0).getSelf50Answer6());
                self50_anwser7.setText("7. "+self50List.get(0).getSelf50Answer7());
                self50_anwser8.setText("8. "+self50List.get(0).getSelf50Answer8());
                self50_anwser9.setText("9. "+self50List.get(0).getSelf50Answer9());
                self50_anwser10.setText("10. "+self50List.get(0).getSelf50Answer10());
                self50_anwser11.setText("11. "+self50List.get(0).getSelf50Answer11());
                self50_anwser12.setText("12. "+self50List.get(0).getSelf50Answer12());
                self50_anwser13.setText("13. "+self50List.get(0).getSelf50Answer13());
                self50_anwser14.setText("14. "+self50List.get(0).getSelf50Answer14());
                self50_anwser15.setText("15. "+self50List.get(0).getSelf50Answer15());
                self50_anwser16.setText("16. "+self50List.get(0).getSelf50Answer16());
                self50_anwser17.setText("17. "+self50List.get(0).getSelf50Answer17());
                self50_anwser18.setText("18. "+self50List.get(0).getSelf50Answer18());
                self50_anwser19.setText("19. "+self50List.get(0).getSelf50Answer19());
                self50_anwser20.setText("20. "+self50List.get(0).getSelf50Answer20());
                self50_anwser21.setText("21. "+self50List.get(0).getSelf50Answer21());
                self50_anwser22.setText("22. "+self50List.get(0).getSelf50Answer22());
                self50_anwser23.setText("23. "+self50List.get(0).getSelf50Answer23());
                self50_anwser24.setText("24. "+self50List.get(0).getSelf50Answer24());
                self50_anwser25.setText("25. "+self50List.get(0).getSelf50Answer25());
                self50_anwser26.setText("26. "+self50List.get(0).getSelf50Answer26());
                self50_anwser27.setText("27. "+self50List.get(0).getSelf50Answer27());
                self50_anwser28.setText("28. "+self50List.get(0).getSelf50Answer28());
                self50_anwser29.setText("29. "+self50List.get(0).getSelf50Answer29());
                self50_anwser30.setText("30. "+self50List.get(0).getSelf50Answer30());
                self50_anwser31.setText("31. "+self50List.get(0).getSelf50Answer31());
                self50_anwser32.setText("32. "+self50List.get(0).getSelf50Answer32());
                self50_anwser33.setText("33. "+self50List.get(0).getSelf50Answer33());
                self50_anwser34.setText("34. "+self50List.get(0).getSelf50Answer34());
                self50_anwser35.setText("35. "+self50List.get(0).getSelf50Answer35());
                self50_anwser36.setText("36. "+self50List.get(0).getSelf50Answer36());
                self50_anwser37.setText("37. "+self50List.get(0).getSelf50Answer37());
                self50_anwser38.setText("38. "+self50List.get(0).getSelf50Answer38());
                self50_anwser39.setText("39. "+self50List.get(0).getSelf50Answer39());
                self50_anwser40.setText("40. "+self50List.get(0).getSelf50Answer40());
                self50_anwser41.setText("41. "+self50List.get(0).getSelf50Answer41());
                self50_anwser42.setText("42. "+self50List.get(0).getSelf50Answer42());
                self50_anwser43.setText("43. "+self50List.get(0).getSelf50Answer43());
                self50_anwser44.setText("44. "+self50List.get(0).getSelf50Answer44());
                self50_anwser45.setText("45. "+self50List.get(0).getSelf50Answer45());
                self50_anwser46.setText("46. "+self50List.get(0).getSelf50Answer46());
                self50_anwser47.setText("47. "+self50List.get(0).getSelf50Answer47());
                self50_anwser48.setText("48. "+self50List.get(0).getSelf50Answer48());
                self50_anwser49.setText("49. "+self50List.get(0).getSelf50Answer49());
                self50_anwser50.setText("50. "+self50List.get(0).getSelf50Answer50());
                self50_anwser51.setText("51. "+self50List.get(0).getSelf50Answer51());
                self50_anwser52.setText("52. "+self50List.get(0).getSelf50Answer52());
                self50_anwser53.setText("53. "+self50List.get(0).getSelf50Answer53());
                self50_anwser54.setText("54. "+self50List.get(0).getSelf50Answer54());
                self50_anwser55.setText("55. "+self50List.get(0).getSelf50Answer55());
                self50_anwser56.setText("56. "+self50List.get(0).getSelf50Answer56());
                self50_anwser57.setText("57. "+self50List.get(0).getSelf50Answer57());
                self50_anwser58.setText("58. "+self50List.get(0).getSelf50Answer58());
                self50_anwser59.setText("59. "+self50List.get(0).getSelf50Answer59());
                self50_anwser60.setText("60. "+self50List.get(0).getSelf50Answer60());
                self50_anwser61.setText("61. "+self50List.get(0).getSelf50Answer61());
                self50_anwser62.setText("62. "+self50List.get(0).getSelf50Answer62());
                self50_anwser63.setText("63. "+self50List.get(0).getSelf50Answer63());
                self50_anwser64.setText("64. "+self50List.get(0).getSelf50Answer64());
                self50_anwser65.setText("65. "+self50List.get(0).getSelf50Answer65());
                self50_anwser66.setText("66. "+self50List.get(0).getSelf50Answer66());
                self50_anwser67.setText("67. "+self50List.get(0).getSelf50Answer67());
                self50_anwser68.setText("68. "+self50List.get(0).getSelf50Answer68());
                self50_anwser69.setText("69. "+self50List.get(0).getSelf50Answer69());
                self50_anwser70.setText("70. "+self50List.get(0).getSelf50Answer70());
                self50_anwser71.setText("71. "+self50List.get(0).getSelf50Answer71());
                self50_anwser72.setText("72. "+self50List.get(0).getSelf50Answer72());
                self50_anwser73.setText("73. "+self50List.get(0).getSelf50Answer73());
                self50_anwser74.setText("74. "+self50List.get(0).getSelf50Answer74());
                self50_anwser75.setText("75. "+self50List.get(0).getSelf50Answer75());
                self50_anwser76.setText("76. "+self50List.get(0).getSelf50Answer76());
                self50_anwser77.setText("77. "+self50List.get(0).getSelf50Answer77());
                self50_anwser78.setText("78. "+self50List.get(0).getSelf50Answer78());
                self50_anwser79.setText("79. "+self50List.get(0).getSelf50Answer79());
                self50_anwser80.setText("80. "+self50List.get(0).getSelf50Answer80());
                self50_anwser81.setText("81. "+self50List.get(0).getSelf50Answer81());
                self50_anwser82.setText("82. "+self50List.get(0).getSelf50Answer82());
                self50_anwser83.setText("83. "+self50List.get(0).getSelf50Answer83());
                self50_anwser84.setText("84. "+self50List.get(0).getSelf50Answer84());
                self50_anwser85.setText("85. "+self50List.get(0).getSelf50Answer85());
                self50_anwser86.setText("86. "+self50List.get(0).getSelf50Answer86());
                self50_anwser87.setText("87. "+self50List.get(0).getSelf50Answer87());
                self50_anwser88.setText("88. "+self50List.get(0).getSelf50Answer88());
                self50_anwser89.setText("89. "+self50List.get(0).getSelf50Answer89());
                self50_anwser90.setText("90. "+self50List.get(0).getSelf50Answer90());
                self50_anwser91.setText("91. "+self50List.get(0).getSelf50Answer91());
                self50_anwser92.setText("92. "+self50List.get(0).getSelf50Answer92());
                self50_anwser93.setText("93. "+self50List.get(0).getSelf50Answer93());
                self50_anwser94.setText("94. "+self50List.get(0).getSelf50Answer94());
                self50_anwser95.setText("95. "+self50List.get(0).getSelf50Answer95());
                self50_anwser96.setText("96. "+self50List.get(0).getSelf50Answer96());
                self50_anwser97.setText("97. "+self50List.get(0).getSelf50Answer97());
                self50_anwser98.setText("98. "+self50List.get(0).getSelf50Answer98());
                self50_anwser99.setText("99. "+self50List.get(0).getSelf50Answer99());
                self50_anwser100.setText("100. "+self50List.get(0).getSelf50Answer100());

            }
            else if(self50List.size()==0){
                text_hide.setVisibility(View.VISIBLE);
                scroll_hide.setVisibility(View.GONE);
                layout_hide.setVisibility(View.GONE);
            }

        }

    }

    // 채팅방
    class BackgroundTask_giveList extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_you100GiveList.php";
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

            self50List = new ArrayList<Self100>();

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
                        self50List.add(self100);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(self50List.size()>=1){
                you50_answer1.setText(self50List.get(0).getSelf50Answer1());
                you50_answer2.setText(self50List.get(0).getSelf50Answer2());
                you50_answer3.setText(self50List.get(0).getSelf50Answer3());
                you50_answer4.setText(self50List.get(0).getSelf50Answer4());
                you50_answer5.setText(self50List.get(0).getSelf50Answer5());
                you50_answer6.setText(self50List.get(0).getSelf50Answer6());
                you50_answer7.setText(self50List.get(0).getSelf50Answer7());
                you50_answer8.setText(self50List.get(0).getSelf50Answer8());
                you50_answer9.setText(self50List.get(0).getSelf50Answer9());
                you50_answer10.setText(self50List.get(0).getSelf50Answer10());
                you50_answer11.setText(self50List.get(0).getSelf50Answer11());
                you50_answer12.setText(self50List.get(0).getSelf50Answer12());
                you50_answer13.setText(self50List.get(0).getSelf50Answer13());
                you50_answer14.setText(self50List.get(0).getSelf50Answer14());
                you50_answer15.setText(self50List.get(0).getSelf50Answer15());
                you50_answer16.setText(self50List.get(0).getSelf50Answer16());
                you50_answer17.setText(self50List.get(0).getSelf50Answer17());
                you50_answer18.setText(self50List.get(0).getSelf50Answer18());
                you50_answer19.setText(self50List.get(0).getSelf50Answer19());
                you50_answer20.setText(self50List.get(0).getSelf50Answer20());
                you50_answer21.setText(self50List.get(0).getSelf50Answer21());
                you50_answer22.setText(self50List.get(0).getSelf50Answer22());
                you50_answer23.setText(self50List.get(0).getSelf50Answer23());
                you50_answer24.setText(self50List.get(0).getSelf50Answer24());
                you50_answer25.setText(self50List.get(0).getSelf50Answer25());
                you50_answer26.setText(self50List.get(0).getSelf50Answer26());
                you50_answer27.setText(self50List.get(0).getSelf50Answer27());
                you50_answer28.setText(self50List.get(0).getSelf50Answer28());
                you50_answer29.setText(self50List.get(0).getSelf50Answer29());
                you50_answer30.setText(self50List.get(0).getSelf50Answer30());
                you50_answer31.setText(self50List.get(0).getSelf50Answer31());
                you50_answer32.setText(self50List.get(0).getSelf50Answer32());
                you50_answer33.setText(self50List.get(0).getSelf50Answer33());
                you50_answer34.setText(self50List.get(0).getSelf50Answer34());
                you50_answer35.setText(self50List.get(0).getSelf50Answer35());
                you50_answer36.setText(self50List.get(0).getSelf50Answer36());
                you50_answer37.setText(self50List.get(0).getSelf50Answer37());
                you50_answer38.setText(self50List.get(0).getSelf50Answer38());
                you50_answer39.setText(self50List.get(0).getSelf50Answer39());
                you50_answer40.setText(self50List.get(0).getSelf50Answer40());
                you50_answer41.setText(self50List.get(0).getSelf50Answer41());
                you50_answer42.setText(self50List.get(0).getSelf50Answer42());
                you50_answer43.setText(self50List.get(0).getSelf50Answer43());
                you50_answer44.setText(self50List.get(0).getSelf50Answer44());
                you50_answer45.setText(self50List.get(0).getSelf50Answer45());
                you50_answer46.setText(self50List.get(0).getSelf50Answer46());
                you50_answer47.setText(self50List.get(0).getSelf50Answer47());
                you50_answer48.setText(self50List.get(0).getSelf50Answer48());
                you50_answer49.setText(self50List.get(0).getSelf50Answer49());
                you50_answer50.setText(self50List.get(0).getSelf50Answer50());
                you50_answer51.setText(self50List.get(0).getSelf50Answer51());
                you50_answer52.setText(self50List.get(0).getSelf50Answer52());
                you50_answer53.setText(self50List.get(0).getSelf50Answer53());
                you50_answer54.setText(self50List.get(0).getSelf50Answer54());
                you50_answer55.setText(self50List.get(0).getSelf50Answer55());
                you50_answer56.setText(self50List.get(0).getSelf50Answer56());
                you50_answer57.setText(self50List.get(0).getSelf50Answer57());
                you50_answer58.setText(self50List.get(0).getSelf50Answer58());
                you50_answer59.setText(self50List.get(0).getSelf50Answer59());
                you50_answer60.setText(self50List.get(0).getSelf50Answer60());
                you50_answer61.setText(self50List.get(0).getSelf50Answer61());
                you50_answer62.setText(self50List.get(0).getSelf50Answer62());
                you50_answer63.setText(self50List.get(0).getSelf50Answer63());
                you50_answer64.setText(self50List.get(0).getSelf50Answer64());
                you50_answer65.setText(self50List.get(0).getSelf50Answer65());
                you50_answer66.setText(self50List.get(0).getSelf50Answer66());
                you50_answer67.setText(self50List.get(0).getSelf50Answer67());
                you50_answer68.setText(self50List.get(0).getSelf50Answer68());
                you50_answer69.setText(self50List.get(0).getSelf50Answer69());
                you50_answer70.setText(self50List.get(0).getSelf50Answer70());
                you50_answer71.setText(self50List.get(0).getSelf50Answer71());
                you50_answer72.setText(self50List.get(0).getSelf50Answer72());
                you50_answer73.setText(self50List.get(0).getSelf50Answer73());
                you50_answer74.setText(self50List.get(0).getSelf50Answer74());
                you50_answer75.setText(self50List.get(0).getSelf50Answer75());
                you50_answer76.setText(self50List.get(0).getSelf50Answer76());
                you50_answer77.setText(self50List.get(0).getSelf50Answer77());
                you50_answer78.setText(self50List.get(0).getSelf50Answer78());
                you50_answer79.setText(self50List.get(0).getSelf50Answer79());
                you50_answer80.setText(self50List.get(0).getSelf50Answer80());
                you50_answer81.setText(self50List.get(0).getSelf50Answer81());
                you50_answer82.setText(self50List.get(0).getSelf50Answer82());
                you50_answer83.setText(self50List.get(0).getSelf50Answer83());
                you50_answer84.setText(self50List.get(0).getSelf50Answer84());
                you50_answer85.setText(self50List.get(0).getSelf50Answer85());
                you50_answer86.setText(self50List.get(0).getSelf50Answer86());
                you50_answer87.setText(self50List.get(0).getSelf50Answer87());
                you50_answer88.setText(self50List.get(0).getSelf50Answer88());
                you50_answer89.setText(self50List.get(0).getSelf50Answer89());
                you50_answer90.setText(self50List.get(0).getSelf50Answer90());
                you50_answer91.setText(self50List.get(0).getSelf50Answer91());
                you50_answer92.setText(self50List.get(0).getSelf50Answer92());
                you50_answer93.setText(self50List.get(0).getSelf50Answer93());
                you50_answer94.setText(self50List.get(0).getSelf50Answer94());
                you50_answer95.setText(self50List.get(0).getSelf50Answer95());
                you50_answer96.setText(self50List.get(0).getSelf50Answer96());
                you50_answer97.setText(self50List.get(0).getSelf50Answer97());
                you50_answer98.setText(self50List.get(0).getSelf50Answer98());
                you50_answer99.setText(self50List.get(0).getSelf50Answer99());
                you50_answer100.setText(self50List.get(0).getSelf50Answer100());

            }
            else if(self50List.size()==0){

            }

        }

    }

    // 채팅방
    class BackgroundTask_giveList_send extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_you100GiveList.php";
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

            self50List = new ArrayList<Self100>();

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
                        self50List.add(self100);
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
                give50();
            }

        }

    }

    //임시저장
    public void give50(){

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


        if(you50_answer1.getText().toString().equals("")){
            answer1 = "미응답";
        }
        else
            answer1=you50_answer1.getText().toString();

        if(you50_answer2.getText().toString().equals("")){
            answer2 = "미응답";
        }
        else
            answer2=you50_answer2.getText().toString();

        if(you50_answer3.getText().toString().equals("")){
            answer3 = "미응답";
        }
        else
            answer3=you50_answer3.getText().toString();

        if(you50_answer4.getText().toString().equals("")){
            answer4 = "미응답";
        }
        else
            answer4=you50_answer4.getText().toString();

        if(you50_answer5.getText().toString().equals("")){
            answer5 = "미응답";
        }
        else
            answer5=you50_answer5.getText().toString();

        if(you50_answer6.getText().toString().equals("")){
            answer6 = "미응답";
        }
        else
            answer6=you50_answer6.getText().toString();

        if(you50_answer7.getText().toString().equals("")){
            answer7 = "미응답";
        }
        else
            answer7=you50_answer7.getText().toString();

        if(you50_answer8.getText().toString().equals("")){
            answer8 = "미응답";
        }
        else
            answer8=you50_answer8.getText().toString();

        if(you50_answer9.getText().toString().equals("")){
            answer9 = "미응답";
        }
        else
            answer9=you50_answer9.getText().toString();

        if(you50_answer10.getText().toString().equals("")){
            answer10 = "미응답";
        }
        else
            answer10=you50_answer10.getText().toString();

        if(you50_answer11.getText().toString().equals("")){
            answer11 = "미응답";
        }
        else
            answer11=you50_answer11.getText().toString();

        if(you50_answer12.getText().toString().equals("")){
            answer12 = "미응답";
        }
        else
            answer12=you50_answer12.getText().toString();

        if(you50_answer13.getText().toString().equals("")){
            answer13 = "미응답";
        }
        else
            answer13=you50_answer13.getText().toString();

        if(you50_answer14.getText().toString().equals("")){
            answer14 = "미응답";
        }
        else
            answer14=you50_answer14.getText().toString();

        if(you50_answer15.getText().toString().equals("")){
            answer15 = "미응답";
        }
        else
            answer15=you50_answer15.getText().toString();

        if(you50_answer16.getText().toString().equals("")){
            answer16 = "미응답";
        }
        else
            answer16=you50_answer16.getText().toString();

        if(you50_answer17.getText().toString().equals("")){
            answer17 = "미응답";
        }
        else
            answer17=you50_answer17.getText().toString();

        if(you50_answer18.getText().toString().equals("")){
            answer18 = "미응답";
        }
        else
            answer18=you50_answer18.getText().toString();

        if(you50_answer19.getText().toString().equals("")){
            answer19 = "미응답";
        }
        else
            answer19=you50_answer19.getText().toString();

        if(you50_answer20.getText().toString().equals("")){
            answer20 = "미응답";
        }
        else
            answer20=you50_answer20.getText().toString();


        if(you50_answer21.getText().toString().equals("")){
            answer21 = "미응답";
        }
        else
            answer21=you50_answer21.getText().toString();

        if(you50_answer22.getText().toString().equals("")){
            answer22 = "미응답";
        }
        else
            answer22=you50_answer22.getText().toString();

        if(you50_answer23.getText().toString().equals("")){
            answer23 = "미응답";
        }
        else
            answer23=you50_answer23.getText().toString();

        if(you50_answer24.getText().toString().equals("")){
            answer24 = "미응답";
        }
        else
            answer24=you50_answer24.getText().toString();

        if(you50_answer25.getText().toString().equals("")){
            answer25 = "미응답";
        }
        else
            answer25=you50_answer25.getText().toString();

        if(you50_answer26.getText().toString().equals("")){
            answer26 = "미응답";
        }
        else
            answer26=you50_answer26.getText().toString();

        if(you50_answer27.getText().toString().equals("")){
            answer27 = "미응답";
        }
        else
            answer27=you50_answer27.getText().toString();

        if(you50_answer28.getText().toString().equals("")){
            answer28 = "미응답";
        }
        else
            answer28=you50_answer28.getText().toString();

        if(you50_answer29.getText().toString().equals("")){
            answer29 = "미응답";
        }
        else
            answer29=you50_answer29.getText().toString();

        if(you50_answer30.getText().toString().equals("")){
            answer30 = "미응답";
        }
        else
            answer30=you50_answer30.getText().toString();


        if(you50_answer31.getText().toString().equals("")){
            answer31 = "미응답";
        }
        else
            answer31=you50_answer31.getText().toString();

        if(you50_answer32.getText().toString().equals("")){
            answer32 = "미응답";
        }
        else
            answer32=you50_answer32.getText().toString();

        if(you50_answer33.getText().toString().equals("")){
            answer33 = "미응답";
        }
        else
            answer33=you50_answer33.getText().toString();

        if(you50_answer34.getText().toString().equals("")){
            answer34 = "미응답";
        }
        else
            answer34=you50_answer34.getText().toString();

        if(you50_answer35.getText().toString().equals("")){
            answer35 = "미응답";
        }
        else
            answer35=you50_answer35.getText().toString();

        if(you50_answer36.getText().toString().equals("")){
            answer36 = "미응답";
        }
        else
            answer36=you50_answer36.getText().toString();

        if(you50_answer37.getText().toString().equals("")){
            answer37 = "미응답";
        }
        else
            answer37=you50_answer37.getText().toString();

        if(you50_answer38.getText().toString().equals("")){
            answer38 = "미응답";
        }
        else
            answer38=you50_answer38.getText().toString();

        if(you50_answer39.getText().toString().equals("")){
            answer39 = "미응답";
        }
        else
            answer39=you50_answer39.getText().toString();

        if(you50_answer40.getText().toString().equals("")){
            answer40 = "미응답";
        }
        else
            answer40=you50_answer40.getText().toString();

        if(you50_answer41.getText().toString().equals("")){
            answer41 = "미응답";
        }
        else
            answer41=you50_answer41.getText().toString();

        if(you50_answer42.getText().toString().equals("")){
            answer42 = "미응답";
        }
        else
            answer42=you50_answer42.getText().toString();

        if(you50_answer43.getText().toString().equals("")){
            answer43 = "미응답";
        }
        else
            answer43=you50_answer43.getText().toString();

        if(you50_answer44.getText().toString().equals("")){
            answer44 = "미응답";
        }
        else
            answer44=you50_answer44.getText().toString();

        if(you50_answer45.getText().toString().equals("")){
            answer45 = "미응답";
        }
        else
            answer45=you50_answer45.getText().toString();

        if(you50_answer46.getText().toString().equals("")){
            answer46 = "미응답";
        }
        else
            answer46=you50_answer46.getText().toString();

        if(you50_answer47.getText().toString().equals("")){
            answer47 = "미응답";
        }
        else
            answer47=you50_answer47.getText().toString();

        if(you50_answer48.getText().toString().equals("")){
            answer48 = "미응답";
        }
        else
            answer48=you50_answer48.getText().toString();

        if(you50_answer49.getText().toString().equals("")){
            answer49 = "미응답";
        }
        else
            answer49=you50_answer49.getText().toString();

        if(you50_answer50.getText().toString().equals("")){
            answer50 = "미응답";
        }
        else
            answer50=you50_answer50.getText().toString();

        if(you50_answer51.getText().toString().equals("")){
            answer51 = "미응답";
        }
        else
            answer51=you50_answer51.getText().toString();

        if(you50_answer52.getText().toString().equals("")){
            answer52 = "미응답";
        }
        else
            answer52=you50_answer52.getText().toString();

        if(you50_answer53.getText().toString().equals("")){
            answer53 = "미응답";
        }
        else
            answer53=you50_answer53.getText().toString();

        if(you50_answer54.getText().toString().equals("")){
            answer54 = "미응답";
        }
        else
            answer54=you50_answer54.getText().toString();

        if(you50_answer55.getText().toString().equals("")){
            answer55 = "미응답";
        }
        else
            answer55=you50_answer55.getText().toString();

        if(you50_answer56.getText().toString().equals("")){
            answer56 = "미응답";
        }
        else
            answer56=you50_answer56.getText().toString();

        if(you50_answer57.getText().toString().equals("")){
            answer57 = "미응답";
        }
        else
            answer57=you50_answer57.getText().toString();

        if(you50_answer58.getText().toString().equals("")){
            answer58 = "미응답";
        }
        else
            answer58=you50_answer58.getText().toString();

        if(you50_answer59.getText().toString().equals("")){
            answer59 = "미응답";
        }
        else
            answer59=you50_answer59.getText().toString();

        if(you50_answer60.getText().toString().equals("")){
            answer60 = "미응답";
        }
        else
            answer60=you50_answer60.getText().toString();

        if(you50_answer61.getText().toString().equals("")){
            answer61 = "미응답";
        }
        else
            answer61=you50_answer61.getText().toString();

        if(you50_answer62.getText().toString().equals("")){
            answer62 = "미응답";
        }
        else
            answer62=you50_answer62.getText().toString();

        if(you50_answer63.getText().toString().equals("")){
            answer63 = "미응답";
        }
        else
            answer63=you50_answer63.getText().toString();

        if(you50_answer64.getText().toString().equals("")){
            answer64 = "미응답";
        }
        else
            answer64=you50_answer64.getText().toString();

        if(you50_answer65.getText().toString().equals("")){
            answer65 = "미응답";
        }
        else
            answer65=you50_answer65.getText().toString();

        if(you50_answer66.getText().toString().equals("")){
            answer66 = "미응답";
        }
        else
            answer66=you50_answer66.getText().toString();

        if(you50_answer67.getText().toString().equals("")){
            answer67 = "미응답";
        }
        else
            answer67=you50_answer67.getText().toString();

        if(you50_answer68.getText().toString().equals("")){
            answer68 = "미응답";
        }
        else
            answer68=you50_answer68.getText().toString();

        if(you50_answer69.getText().toString().equals("")){
            answer69 = "미응답";
        }
        else
            answer69=you50_answer69.getText().toString();

        if(you50_answer70.getText().toString().equals("")){
            answer70 = "미응답";
        }
        else
            answer70=you50_answer70.getText().toString();

        if(you50_answer71.getText().toString().equals("")){
            answer71 = "미응답";
        }
        else
            answer71=you50_answer71.getText().toString();

        if(you50_answer72.getText().toString().equals("")){
            answer72 = "미응답";
        }
        else
            answer72=you50_answer72.getText().toString();

        if(you50_answer73.getText().toString().equals("")){
            answer73 = "미응답";
        }
        else
            answer73=you50_answer73.getText().toString();

        if(you50_answer74.getText().toString().equals("")){
            answer74 = "미응답";
        }
        else
            answer74=you50_answer74.getText().toString();

        if(you50_answer75.getText().toString().equals("")){
            answer75 = "미응답";
        }
        else
            answer75=you50_answer75.getText().toString();

        if(you50_answer76.getText().toString().equals("")){
            answer76 = "미응답";
        }
        else
            answer76=you50_answer76.getText().toString();

        if(you50_answer77.getText().toString().equals("")){
            answer77 = "미응답";
        }
        else
            answer77=you50_answer77.getText().toString();

        if(you50_answer78.getText().toString().equals("")){
            answer78 = "미응답";
        }
        else
            answer78=you50_answer78.getText().toString();

        if(you50_answer79.getText().toString().equals("")){
            answer79 = "미응답";
        }
        else
            answer79=you50_answer79.getText().toString();

        if(you50_answer80.getText().toString().equals("")){
            answer80 = "미응답";
        }
        else
            answer80=you50_answer80.getText().toString();

        if(you50_answer81.getText().toString().equals("")){
            answer81 = "미응답";
        }
        else
            answer81=you50_answer81.getText().toString();

        if(you50_answer82.getText().toString().equals("")){
            answer82 = "미응답";
        }
        else
            answer82=you50_answer82.getText().toString();

        if(you50_answer83.getText().toString().equals("")){
            answer83 = "미응답";
        }
        else
            answer83=you50_answer83.getText().toString();

        if(you50_answer84.getText().toString().equals("")){
            answer84 = "미응답";
        }
        else
            answer84=you50_answer84.getText().toString();

        if(you50_answer85.getText().toString().equals("")){
            answer85 = "미응답";
        }
        else
            answer85=you50_answer85.getText().toString();

        if(you50_answer86.getText().toString().equals("")){
            answer86 = "미응답";
        }
        else
            answer86=you50_answer86.getText().toString();

        if(you50_answer87.getText().toString().equals("")){
            answer87 = "미응답";
        }
        else
            answer87=you50_answer87.getText().toString();

        if(you50_answer88.getText().toString().equals("")){
            answer88 = "미응답";
        }
        else
            answer88=you50_answer88.getText().toString();

        if(you50_answer89.getText().toString().equals("")){
            answer89 = "미응답";
        }
        else
            answer89=you50_answer89.getText().toString();

        if(you50_answer90.getText().toString().equals("")){
            answer90 = "미응답";
        }
        else
            answer90=you50_answer90.getText().toString();

        if(you50_answer91.getText().toString().equals("")){
            answer91 = "미응답";
        }
        else
            answer91=you50_answer91.getText().toString();

        if(you50_answer92.getText().toString().equals("")){
            answer92 = "미응답";
        }
        else
            answer92=you50_answer92.getText().toString();

        if(you50_answer93.getText().toString().equals("")){
            answer93 = "미응답";
        }
        else
            answer93=you50_answer93.getText().toString();

        if(you50_answer94.getText().toString().equals("")){
            answer94 = "미응답";
        }
        else
            answer94=you50_answer94.getText().toString();

        if(you50_answer95.getText().toString().equals("")){
            answer95 = "미응답";
        }
        else
            answer95=you50_answer95.getText().toString();

        if(you50_answer96.getText().toString().equals("")){
            answer96 = "미응답";
        }
        else
            answer96=you50_answer96.getText().toString();

        if(you50_answer97.getText().toString().equals("")){
            answer97 = "미응답";
        }
        else
            answer97=you50_answer97.getText().toString();

        if(you50_answer98.getText().toString().equals("")){
            answer98 = "미응답";
        }
        else
            answer98=you50_answer98.getText().toString();

        if(you50_answer99.getText().toString().equals("")){
            answer99 = "미응답";
        }
        else
            answer99=you50_answer99.getText().toString();

        if(you50_answer100.getText().toString().equals("")){
            answer100 = "미응답";
        }
        else
            answer100=you50_answer100.getText().toString();

        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogUpdate customDialog = new CustomDialogUpdate(you100_info.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(you100_info.this);
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

        You100GiveAddRequest registerRequest = new You100GiveAddRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32,
                answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40, answer41, answer42, answer43,
                answer44, answer45, answer46, answer47, answer48, answer49, answer50, answer51, answer52, answer53,
                answer54, answer55, answer56, answer57, answer58, answer59, answer60,answer61, answer62, answer63,
                answer64, answer65, answer66, answer67, answer68, answer69, answer70,answer71, answer72, answer73,
                answer74, answer75, answer76, answer77, answer78, answer79, answer80,answer81, answer82, answer83,
                answer84, answer85, answer86, answer87, answer88, answer89, answer90,answer91, answer92, answer93,
                answer94, answer95, answer96, answer97, answer98, answer99, answer100, responseListener);
        RequestQueue queue = Volley.newRequestQueue(you100_info.this);
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

        if(you50_answer1.getText().toString().equals("")){
            answer1 = "미응답";
        }
        else
            answer1=you50_answer1.getText().toString();

        if(you50_answer2.getText().toString().equals("")){
            answer2 = "미응답";
        }
        else
            answer2=you50_answer2.getText().toString();

        if(you50_answer3.getText().toString().equals("")){
            answer3 = "미응답";
        }
        else
            answer3=you50_answer3.getText().toString();

        if(you50_answer4.getText().toString().equals("")){
            answer4 = "미응답";
        }
        else
            answer4=you50_answer4.getText().toString();

        if(you50_answer5.getText().toString().equals("")){
            answer5 = "미응답";
        }
        else
            answer5=you50_answer5.getText().toString();

        if(you50_answer6.getText().toString().equals("")){
            answer6 = "미응답";
        }
        else
            answer6=you50_answer6.getText().toString();

        if(you50_answer7.getText().toString().equals("")){
            answer7 = "미응답";
        }
        else
            answer7=you50_answer7.getText().toString();

        if(you50_answer8.getText().toString().equals("")){
            answer8 = "미응답";
        }
        else
            answer8=you50_answer8.getText().toString();

        if(you50_answer9.getText().toString().equals("")){
            answer9 = "미응답";
        }
        else
            answer9=you50_answer9.getText().toString();

        if(you50_answer10.getText().toString().equals("")){
            answer10 = "미응답";
        }
        else
            answer10=you50_answer10.getText().toString();

        if(you50_answer11.getText().toString().equals("")){
            answer11 = "미응답";
        }
        else
            answer11=you50_answer11.getText().toString();

        if(you50_answer12.getText().toString().equals("")){
            answer12 = "미응답";
        }
        else
            answer12=you50_answer12.getText().toString();

        if(you50_answer13.getText().toString().equals("")){
            answer13 = "미응답";
        }
        else
            answer13=you50_answer13.getText().toString();

        if(you50_answer14.getText().toString().equals("")){
            answer14 = "미응답";
        }
        else
            answer14=you50_answer14.getText().toString();

        if(you50_answer15.getText().toString().equals("")){
            answer15 = "미응답";
        }
        else
            answer15=you50_answer15.getText().toString();

        if(you50_answer16.getText().toString().equals("")){
            answer16 = "미응답";
        }
        else
            answer16=you50_answer16.getText().toString();

        if(you50_answer17.getText().toString().equals("")){
            answer17 = "미응답";
        }
        else
            answer17=you50_answer17.getText().toString();

        if(you50_answer18.getText().toString().equals("")){
            answer18 = "미응답";
        }
        else
            answer18=you50_answer18.getText().toString();

        if(you50_answer19.getText().toString().equals("")){
            answer19 = "미응답";
        }
        else
            answer19=you50_answer19.getText().toString();

        if(you50_answer20.getText().toString().equals("")){
            answer20 = "미응답";
        }
        else
            answer20=you50_answer20.getText().toString();


        if(you50_answer21.getText().toString().equals("")){
            answer21 = "미응답";
        }
        else
            answer21=you50_answer21.getText().toString();

        if(you50_answer22.getText().toString().equals("")){
            answer22 = "미응답";
        }
        else
            answer22=you50_answer22.getText().toString();

        if(you50_answer23.getText().toString().equals("")){
            answer23 = "미응답";
        }
        else
            answer23=you50_answer23.getText().toString();

        if(you50_answer24.getText().toString().equals("")){
            answer24 = "미응답";
        }
        else
            answer24=you50_answer24.getText().toString();

        if(you50_answer25.getText().toString().equals("")){
            answer25 = "미응답";
        }
        else
            answer25=you50_answer25.getText().toString();

        if(you50_answer26.getText().toString().equals("")){
            answer26 = "미응답";
        }
        else
            answer26=you50_answer26.getText().toString();

        if(you50_answer27.getText().toString().equals("")){
            answer27 = "미응답";
        }
        else
            answer27=you50_answer27.getText().toString();

        if(you50_answer28.getText().toString().equals("")){
            answer28 = "미응답";
        }
        else
            answer28=you50_answer28.getText().toString();

        if(you50_answer29.getText().toString().equals("")){
            answer29 = "미응답";
        }
        else
            answer29=you50_answer29.getText().toString();

        if(you50_answer30.getText().toString().equals("")){
            answer30 = "미응답";
        }
        else
            answer30=you50_answer30.getText().toString();


        if(you50_answer31.getText().toString().equals("")){
            answer31 = "미응답";
        }
        else
            answer31=you50_answer31.getText().toString();

        if(you50_answer32.getText().toString().equals("")){
            answer32 = "미응답";
        }
        else
            answer32=you50_answer32.getText().toString();

        if(you50_answer33.getText().toString().equals("")){
            answer33 = "미응답";
        }
        else
            answer33=you50_answer33.getText().toString();

        if(you50_answer34.getText().toString().equals("")){
            answer34 = "미응답";
        }
        else
            answer34=you50_answer34.getText().toString();

        if(you50_answer35.getText().toString().equals("")){
            answer35 = "미응답";
        }
        else
            answer35=you50_answer35.getText().toString();

        if(you50_answer36.getText().toString().equals("")){
            answer36 = "미응답";
        }
        else
            answer36=you50_answer36.getText().toString();

        if(you50_answer37.getText().toString().equals("")){
            answer37 = "미응답";
        }
        else
            answer37=you50_answer37.getText().toString();

        if(you50_answer38.getText().toString().equals("")){
            answer38 = "미응답";
        }
        else
            answer38=you50_answer38.getText().toString();

        if(you50_answer39.getText().toString().equals("")){
            answer39 = "미응답";
        }
        else
            answer39=you50_answer39.getText().toString();

        if(you50_answer40.getText().toString().equals("")){
            answer40 = "미응답";
        }
        else
            answer40=you50_answer40.getText().toString();

        if(you50_answer41.getText().toString().equals("")){
            answer41 = "미응답";
        }
        else
            answer41=you50_answer41.getText().toString();

        if(you50_answer42.getText().toString().equals("")){
            answer42 = "미응답";
        }
        else
            answer42=you50_answer42.getText().toString();

        if(you50_answer43.getText().toString().equals("")){
            answer43 = "미응답";
        }
        else
            answer43=you50_answer43.getText().toString();

        if(you50_answer44.getText().toString().equals("")){
            answer44 = "미응답";
        }
        else
            answer44=you50_answer44.getText().toString();

        if(you50_answer45.getText().toString().equals("")){
            answer45 = "미응답";
        }
        else
            answer45=you50_answer45.getText().toString();

        if(you50_answer46.getText().toString().equals("")){
            answer46 = "미응답";
        }
        else
            answer46=you50_answer46.getText().toString();

        if(you50_answer47.getText().toString().equals("")){
            answer47 = "미응답";
        }
        else
            answer47=you50_answer47.getText().toString();

        if(you50_answer48.getText().toString().equals("")){
            answer48 = "미응답";
        }
        else
            answer48=you50_answer48.getText().toString();

        if(you50_answer49.getText().toString().equals("")){
            answer49 = "미응답";
        }
        else
            answer49=you50_answer49.getText().toString();

        if(you50_answer50.getText().toString().equals("")){
            answer50 = "미응답";
        }
        else
            answer50=you50_answer50.getText().toString();

        if(you50_answer51.getText().toString().equals("")){
            answer51 = "미응답";
        }
        else
            answer51=you50_answer51.getText().toString();

        if(you50_answer52.getText().toString().equals("")){
            answer52 = "미응답";
        }
        else
            answer52=you50_answer52.getText().toString();

        if(you50_answer53.getText().toString().equals("")){
            answer53 = "미응답";
        }
        else
            answer53=you50_answer53.getText().toString();

        if(you50_answer54.getText().toString().equals("")){
            answer54 = "미응답";
        }
        else
            answer54=you50_answer54.getText().toString();

        if(you50_answer55.getText().toString().equals("")){
            answer55 = "미응답";
        }
        else
            answer55=you50_answer55.getText().toString();

        if(you50_answer56.getText().toString().equals("")){
            answer56 = "미응답";
        }
        else
            answer56=you50_answer56.getText().toString();

        if(you50_answer57.getText().toString().equals("")){
            answer57 = "미응답";
        }
        else
            answer57=you50_answer57.getText().toString();

        if(you50_answer58.getText().toString().equals("")){
            answer58 = "미응답";
        }
        else
            answer58=you50_answer58.getText().toString();

        if(you50_answer59.getText().toString().equals("")){
            answer59 = "미응답";
        }
        else
            answer59=you50_answer59.getText().toString();

        if(you50_answer60.getText().toString().equals("")){
            answer60 = "미응답";
        }
        else
            answer60=you50_answer60.getText().toString();

        if(you50_answer61.getText().toString().equals("")){
            answer61 = "미응답";
        }
        else
            answer61=you50_answer61.getText().toString();

        if(you50_answer62.getText().toString().equals("")){
            answer62 = "미응답";
        }
        else
            answer62=you50_answer62.getText().toString();

        if(you50_answer63.getText().toString().equals("")){
            answer63 = "미응답";
        }
        else
            answer63=you50_answer63.getText().toString();

        if(you50_answer64.getText().toString().equals("")){
            answer64 = "미응답";
        }
        else
            answer64=you50_answer64.getText().toString();

        if(you50_answer65.getText().toString().equals("")){
            answer65 = "미응답";
        }
        else
            answer65=you50_answer65.getText().toString();

        if(you50_answer66.getText().toString().equals("")){
            answer66 = "미응답";
        }
        else
            answer66=you50_answer66.getText().toString();

        if(you50_answer67.getText().toString().equals("")){
            answer67 = "미응답";
        }
        else
            answer67=you50_answer67.getText().toString();

        if(you50_answer68.getText().toString().equals("")){
            answer68 = "미응답";
        }
        else
            answer68=you50_answer68.getText().toString();

        if(you50_answer69.getText().toString().equals("")){
            answer69 = "미응답";
        }
        else
            answer69=you50_answer69.getText().toString();

        if(you50_answer70.getText().toString().equals("")){
            answer70 = "미응답";
        }
        else
            answer70=you50_answer70.getText().toString();

        if(you50_answer71.getText().toString().equals("")){
            answer71 = "미응답";
        }
        else
            answer71=you50_answer71.getText().toString();

        if(you50_answer72.getText().toString().equals("")){
            answer72 = "미응답";
        }
        else
            answer72=you50_answer72.getText().toString();

        if(you50_answer73.getText().toString().equals("")){
            answer73 = "미응답";
        }
        else
            answer73=you50_answer73.getText().toString();

        if(you50_answer74.getText().toString().equals("")){
            answer74 = "미응답";
        }
        else
            answer74=you50_answer74.getText().toString();

        if(you50_answer75.getText().toString().equals("")){
            answer75 = "미응답";
        }
        else
            answer75=you50_answer75.getText().toString();

        if(you50_answer76.getText().toString().equals("")){
            answer76 = "미응답";
        }
        else
            answer76=you50_answer76.getText().toString();

        if(you50_answer77.getText().toString().equals("")){
            answer77 = "미응답";
        }
        else
            answer77=you50_answer77.getText().toString();

        if(you50_answer78.getText().toString().equals("")){
            answer78 = "미응답";
        }
        else
            answer78=you50_answer78.getText().toString();

        if(you50_answer79.getText().toString().equals("")){
            answer79 = "미응답";
        }
        else
            answer79=you50_answer79.getText().toString();

        if(you50_answer80.getText().toString().equals("")){
            answer80 = "미응답";
        }
        else
            answer80=you50_answer80.getText().toString();

        if(you50_answer81.getText().toString().equals("")){
            answer81 = "미응답";
        }
        else
            answer81=you50_answer81.getText().toString();

        if(you50_answer82.getText().toString().equals("")){
            answer82 = "미응답";
        }
        else
            answer82=you50_answer82.getText().toString();

        if(you50_answer83.getText().toString().equals("")){
            answer83 = "미응답";
        }
        else
            answer83=you50_answer83.getText().toString();

        if(you50_answer84.getText().toString().equals("")){
            answer84 = "미응답";
        }
        else
            answer84=you50_answer84.getText().toString();

        if(you50_answer85.getText().toString().equals("")){
            answer85 = "미응답";
        }
        else
            answer85=you50_answer85.getText().toString();

        if(you50_answer86.getText().toString().equals("")){
            answer86 = "미응답";
        }
        else
            answer86=you50_answer86.getText().toString();

        if(you50_answer87.getText().toString().equals("")){
            answer87 = "미응답";
        }
        else
            answer87=you50_answer87.getText().toString();

        if(you50_answer88.getText().toString().equals("")){
            answer88 = "미응답";
        }
        else
            answer88=you50_answer88.getText().toString();

        if(you50_answer89.getText().toString().equals("")){
            answer89 = "미응답";
        }
        else
            answer89=you50_answer89.getText().toString();

        if(you50_answer90.getText().toString().equals("")){
            answer90 = "미응답";
        }
        else
            answer90=you50_answer90.getText().toString();

        if(you50_answer91.getText().toString().equals("")){
            answer91 = "미응답";
        }
        else
            answer91=you50_answer91.getText().toString();

        if(you50_answer92.getText().toString().equals("")){
            answer92 = "미응답";
        }
        else
            answer92=you50_answer92.getText().toString();

        if(you50_answer93.getText().toString().equals("")){
            answer93 = "미응답";
        }
        else
            answer93=you50_answer93.getText().toString();

        if(you50_answer94.getText().toString().equals("")){
            answer94 = "미응답";
        }
        else
            answer94=you50_answer94.getText().toString();

        if(you50_answer95.getText().toString().equals("")){
            answer95 = "미응답";
        }
        else
            answer95=you50_answer95.getText().toString();

        if(you50_answer96.getText().toString().equals("")){
            answer96 = "미응답";
        }
        else
            answer96=you50_answer96.getText().toString();

        if(you50_answer97.getText().toString().equals("")){
            answer97 = "미응답";
        }
        else
            answer97=you50_answer97.getText().toString();

        if(you50_answer98.getText().toString().equals("")){
            answer98 = "미응답";
        }
        else
            answer98=you50_answer98.getText().toString();

        if(you50_answer99.getText().toString().equals("")){
            answer99 = "미응답";
        }
        else
            answer99=you50_answer99.getText().toString();

        if(you50_answer100.getText().toString().equals("")){
            answer100 = "미응답";
        }
        else
            answer100=you50_answer100.getText().toString();




        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogUpdate customDialog = new CustomDialogUpdate(you100_info.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(you100_info.this);
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

        You100GiveUpdateRequest registerRequest = new You100GiveUpdateRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, answer31, answer32,
                answer33, answer34, answer35, answer36, answer37, answer38, answer39, answer40, answer41, answer42, answer43,
                answer44, answer45, answer46, answer47, answer48, answer49, answer50, answer51, answer52, answer53,
                answer54, answer55, answer56, answer57, answer58, answer59, answer60,answer61, answer62, answer63,
                answer64, answer65, answer66, answer67, answer68, answer69, answer70,answer71, answer72, answer73,
                answer74, answer75, answer76, answer77, answer78, answer79, answer80,answer81, answer82, answer83,
                answer84, answer85, answer86, answer87, answer88, answer89, answer90,answer91, answer92, answer93,
                answer94, answer95, answer96, answer97, answer98, answer99, answer100, responseListener);
        RequestQueue queue = Volley.newRequestQueue(you100_info.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }
}
