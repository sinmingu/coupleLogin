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

public class Question_bucket_30 extends AppCompatActivity {

    TabHost reg_tabHost;
    List<BUCKET30> bucket30List;
    TextView btn_save, btn_send;
    ImageView de_no_cancle, de_no_can, back_page, next_page;
    TextView text_page;
    int page;
    EditText edit_bucket_1, edit_bucket_2, edit_bucket_3, edit_bucket_4, edit_bucket_5, edit_bucket_6, edit_bucket_7,
            edit_bucket_8, edit_bucket_9, edit_bucket_10,edit_bucket_11, edit_bucket_12, edit_bucket_13, edit_bucket_14, edit_bucket_15, edit_bucket_16, edit_bucket_17,
            edit_bucket_18, edit_bucket_19, edit_bucket_20,edit_bucket_21, edit_bucket_22, edit_bucket_23, edit_bucket_24, edit_bucket_25, edit_bucket_26, edit_bucket_27,
            edit_bucket_28, edit_bucket_29, edit_bucket_30;
    InterstitialAd adfull;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bucket_30);
        text_page = (TextView)findViewById(R.id.text_page);
        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        back_page = (ImageView)findViewById(R.id.back_page);
        next_page = (ImageView)findViewById(R.id.next_page);

        btn_save = (TextView) findViewById(R.id.btn_save);
        btn_send = (TextView) findViewById(R.id.btn_send);
        adfull = new InterstitialAd(this);
        adfull.setAdUnitId("ca-app-pub-5784293657699097/5193862959");
        adfull.loadAd(new AdRequest.Builder().build());
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);
        Glide.with(this).load(R.drawable.back_2).fitCenter().into(back_page);
        Glide.with(this).load(R.drawable.next_2).fitCenter().into(next_page);

        edit_bucket_1 = (EditText)findViewById(R.id.edit_bucket_1);
        edit_bucket_2 = (EditText)findViewById(R.id.edit_bucket_2);
        edit_bucket_3 = (EditText)findViewById(R.id.edit_bucket_3);
        edit_bucket_4 = (EditText)findViewById(R.id.edit_bucket_4);
        edit_bucket_5 = (EditText)findViewById(R.id.edit_bucket_5);
        edit_bucket_6 = (EditText)findViewById(R.id.edit_bucket_6);
        edit_bucket_7 = (EditText)findViewById(R.id.edit_bucket_7);
        edit_bucket_8 = (EditText)findViewById(R.id.edit_bucket_8);
        edit_bucket_9 = (EditText)findViewById(R.id.edit_bucket_9);
        edit_bucket_10 = (EditText)findViewById(R.id.edit_bucket_10);
        edit_bucket_11 = (EditText)findViewById(R.id.edit_bucket_11);
        edit_bucket_12 = (EditText)findViewById(R.id.edit_bucket_12);
        edit_bucket_13 = (EditText)findViewById(R.id.edit_bucket_13);
        edit_bucket_14 = (EditText)findViewById(R.id.edit_bucket_14);
        edit_bucket_15 = (EditText)findViewById(R.id.edit_bucket_15);
        edit_bucket_16 = (EditText)findViewById(R.id.edit_bucket_16);
        edit_bucket_17 = (EditText)findViewById(R.id.edit_bucket_17);
        edit_bucket_18 = (EditText)findViewById(R.id.edit_bucket_18);
        edit_bucket_19 = (EditText)findViewById(R.id.edit_bucket_19);
        edit_bucket_20 = (EditText)findViewById(R.id.edit_bucket_20);
        edit_bucket_21 = (EditText)findViewById(R.id.edit_bucket_21);
        edit_bucket_22 = (EditText)findViewById(R.id.edit_bucket_22);
        edit_bucket_23 = (EditText)findViewById(R.id.edit_bucket_23);
        edit_bucket_24 = (EditText)findViewById(R.id.edit_bucket_24);
        edit_bucket_25 = (EditText)findViewById(R.id.edit_bucket_25);
        edit_bucket_26 = (EditText)findViewById(R.id.edit_bucket_26);
        edit_bucket_27 = (EditText)findViewById(R.id.edit_bucket_27);
        edit_bucket_28 = (EditText)findViewById(R.id.edit_bucket_28);
        edit_bucket_29 = (EditText)findViewById(R.id.edit_bucket_29);
        edit_bucket_30 = (EditText)findViewById(R.id.edit_bucket_30);

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

        // 일정 탭
        final TabHost.TabSpec reg_tabSpec3 = reg_tabHost.newTabSpec("Tab3");
        reg_tabSpec3.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec3.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec3.setContent(R.id.reg_tab_view3); // Tab Content
        reg_tabHost.addTab(reg_tabSpec3);



        reg_tabHost.getTabWidget().getChildAt(0)

                .setBackgroundColor(Color.parseColor("#ffffff"));


        reg_tabHost.getTabWidget().getChildAt(1)

                .setBackgroundColor(Color.parseColor("#ffffff"));
        reg_tabHost.getTabWidget().getChildAt(2)

                .setBackgroundColor(Color.parseColor("#ffffff"));


        reg_tabHost.setCurrentTab(0); // 처음 열리는 탭

        text_page.setText(page+1 +" / 3");

        //-----------------------탭 호스트 끝--------------------------------

        new BackgroundTask_you50List().execute();

        back_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page==0){
                    Toast.makeText(getApplicationContext(),"최소 입니다",Toast.LENGTH_SHORT).show();
                }
                else {
                    page-=1;
                    reg_tabHost.setCurrentTab(page);
                    text_page.setText(page+1 +" / 3");

                }
            }
        });

        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page==2){
                    Toast.makeText(getApplicationContext(),"최대 입니다",Toast.LENGTH_SHORT).show();
                }
                else {
                    page+=1;
                    reg_tabHost.setCurrentTab(page);
                    text_page.setText(page+1 +" / 3");

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


        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    //임시저장
    public void bucket10(){

        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10,
                answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30;

        if(edit_bucket_1.getText().toString().equals("")){
            answer1 = "미응답";
        }
        else
            answer1=edit_bucket_1.getText().toString();

        if(edit_bucket_2.getText().toString().equals("")){
            answer2 = "미응답";
        }
        else
            answer2=edit_bucket_2.getText().toString();

        if(edit_bucket_3.getText().toString().equals("")){
            answer3 = "미응답";
        }
        else
            answer3=edit_bucket_3.getText().toString();

        if(edit_bucket_4.getText().toString().equals("")){
            answer4 = "미응답";
        }
        else
            answer4=edit_bucket_4.getText().toString();

        if(edit_bucket_5.getText().toString().equals("")){
            answer5 = "미응답";
        }
        else
            answer5=edit_bucket_5.getText().toString();

        if(edit_bucket_6.getText().toString().equals("")){
            answer6 = "미응답";
        }
        else
            answer6=edit_bucket_6.getText().toString();

        if(edit_bucket_7.getText().toString().equals("")){
            answer7 = "미응답";
        }
        else
            answer7=edit_bucket_7.getText().toString();

        if(edit_bucket_8.getText().toString().equals("")){
            answer8 = "미응답";
        }
        else
            answer8=edit_bucket_8.getText().toString();

        if(edit_bucket_9.getText().toString().equals("")){
            answer9 = "미응답";
        }
        else
            answer9=edit_bucket_9.getText().toString();

        if(edit_bucket_10.getText().toString().equals("")){
            answer10 = "미응답";
        }
        else
            answer10=edit_bucket_10.getText().toString();

        if(edit_bucket_11.getText().toString().equals("")){
            answer11 = "미응답";
        }
        else
            answer11=edit_bucket_11.getText().toString();

        if(edit_bucket_12.getText().toString().equals("")){
            answer12 = "미응답";
        }
        else
            answer12=edit_bucket_12.getText().toString();

        if(edit_bucket_13.getText().toString().equals("")){
            answer13 = "미응답";
        }
        else
            answer13=edit_bucket_13.getText().toString();

        if(edit_bucket_14.getText().toString().equals("")){
            answer14 = "미응답";
        }
        else
            answer14=edit_bucket_14.getText().toString();

        if(edit_bucket_15.getText().toString().equals("")){
            answer15 = "미응답";
        }
        else
            answer15=edit_bucket_15.getText().toString();

        if(edit_bucket_16.getText().toString().equals("")){
            answer16 = "미응답";
        }
        else
            answer16=edit_bucket_16.getText().toString();

        if(edit_bucket_17.getText().toString().equals("")){
            answer17 = "미응답";
        }
        else
            answer17=edit_bucket_17.getText().toString();

        if(edit_bucket_18.getText().toString().equals("")){
            answer18 = "미응답";
        }
        else
            answer18=edit_bucket_18.getText().toString();

        if(edit_bucket_19.getText().toString().equals("")){
            answer19 = "미응답";
        }
        else
            answer19=edit_bucket_19.getText().toString();

        if(edit_bucket_20.getText().toString().equals("")){
            answer20 = "미응답";
        }
        else
            answer20=edit_bucket_20.getText().toString();

        if(edit_bucket_21.getText().toString().equals("")){
            answer21 = "미응답";
        }
        else
            answer21=edit_bucket_21.getText().toString();

        if(edit_bucket_22.getText().toString().equals("")){
            answer22 = "미응답";
        }
        else
            answer22=edit_bucket_22.getText().toString();

        if(edit_bucket_23.getText().toString().equals("")){
            answer23 = "미응답";
        }
        else
            answer23=edit_bucket_23.getText().toString();

        if(edit_bucket_24.getText().toString().equals("")){
            answer24 = "미응답";
        }
        else
            answer24=edit_bucket_24.getText().toString();

        if(edit_bucket_25.getText().toString().equals("")){
            answer25 = "미응답";
        }
        else
            answer25=edit_bucket_25.getText().toString();

        if(edit_bucket_26.getText().toString().equals("")){
            answer26 = "미응답";
        }
        else
            answer26=edit_bucket_26.getText().toString();

        if(edit_bucket_27.getText().toString().equals("")){
            answer27 = "미응답";
        }
        else
            answer27=edit_bucket_27.getText().toString();

        if(edit_bucket_28.getText().toString().equals("")){
            answer28 = "미응답";
        }
        else
            answer28=edit_bucket_28.getText().toString();

        if(edit_bucket_29.getText().toString().equals("")){
            answer29 = "미응답";
        }
        else
            answer29=edit_bucket_29.getText().toString();

        if(edit_bucket_30.getText().toString().equals("")){
            answer30 = "미응답";
        }
        else
            answer30=edit_bucket_30.getText().toString();


        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSave customDialog = new CustomDialogSave(Question_bucket_30.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_bucket_30.this);
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

        Bucket30AddRequest registerRequest = new Bucket30AddRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12,answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_bucket_30.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------


    }

    public void bucket10_update(){

        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10,
                answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30;

        if(edit_bucket_1.getText().toString().equals("")){
            answer1 = "미응답";
        }
        else
            answer1=edit_bucket_1.getText().toString();

        if(edit_bucket_2.getText().toString().equals("")){
            answer2 = "미응답";
        }
        else
            answer2=edit_bucket_2.getText().toString();

        if(edit_bucket_3.getText().toString().equals("")){
            answer3 = "미응답";
        }
        else
            answer3=edit_bucket_3.getText().toString();

        if(edit_bucket_4.getText().toString().equals("")){
            answer4 = "미응답";
        }
        else
            answer4=edit_bucket_4.getText().toString();

        if(edit_bucket_5.getText().toString().equals("")){
            answer5 = "미응답";
        }
        else
            answer5=edit_bucket_5.getText().toString();

        if(edit_bucket_6.getText().toString().equals("")){
            answer6 = "미응답";
        }
        else
            answer6=edit_bucket_6.getText().toString();

        if(edit_bucket_7.getText().toString().equals("")){
            answer7 = "미응답";
        }
        else
            answer7=edit_bucket_7.getText().toString();

        if(edit_bucket_8.getText().toString().equals("")){
            answer8 = "미응답";
        }
        else
            answer8=edit_bucket_8.getText().toString();

        if(edit_bucket_9.getText().toString().equals("")){
            answer9 = "미응답";
        }
        else
            answer9=edit_bucket_9.getText().toString();

        if(edit_bucket_10.getText().toString().equals("")){
            answer10 = "미응답";
        }
        else
            answer10=edit_bucket_10.getText().toString();

        if(edit_bucket_11.getText().toString().equals("")){
            answer11 = "미응답";
        }
        else
            answer11=edit_bucket_11.getText().toString();

        if(edit_bucket_12.getText().toString().equals("")){
            answer12 = "미응답";
        }
        else
            answer12=edit_bucket_12.getText().toString();

        if(edit_bucket_13.getText().toString().equals("")){
            answer13 = "미응답";
        }
        else
            answer13=edit_bucket_13.getText().toString();

        if(edit_bucket_14.getText().toString().equals("")){
            answer14 = "미응답";
        }
        else
            answer14=edit_bucket_14.getText().toString();

        if(edit_bucket_15.getText().toString().equals("")){
            answer15 = "미응답";
        }
        else
            answer15=edit_bucket_15.getText().toString();

        if(edit_bucket_16.getText().toString().equals("")){
            answer16 = "미응답";
        }
        else
            answer16=edit_bucket_16.getText().toString();

        if(edit_bucket_17.getText().toString().equals("")){
            answer17 = "미응답";
        }
        else
            answer17=edit_bucket_17.getText().toString();

        if(edit_bucket_18.getText().toString().equals("")){
            answer18 = "미응답";
        }
        else
            answer18=edit_bucket_18.getText().toString();

        if(edit_bucket_19.getText().toString().equals("")){
            answer19 = "미응답";
        }
        else
            answer19=edit_bucket_19.getText().toString();

        if(edit_bucket_20.getText().toString().equals("")){
            answer20 = "미응답";
        }
        else
            answer20=edit_bucket_20.getText().toString();

        if(edit_bucket_21.getText().toString().equals("")){
            answer21 = "미응답";
        }
        else
            answer21=edit_bucket_21.getText().toString();

        if(edit_bucket_22.getText().toString().equals("")){
            answer22 = "미응답";
        }
        else
            answer22=edit_bucket_22.getText().toString();

        if(edit_bucket_23.getText().toString().equals("")){
            answer23 = "미응답";
        }
        else
            answer23=edit_bucket_23.getText().toString();

        if(edit_bucket_24.getText().toString().equals("")){
            answer24 = "미응답";
        }
        else
            answer24=edit_bucket_24.getText().toString();

        if(edit_bucket_25.getText().toString().equals("")){
            answer25 = "미응답";
        }
        else
            answer25=edit_bucket_25.getText().toString();

        if(edit_bucket_26.getText().toString().equals("")){
            answer26 = "미응답";
        }
        else
            answer26=edit_bucket_26.getText().toString();

        if(edit_bucket_27.getText().toString().equals("")){
            answer27 = "미응답";
        }
        else
            answer27=edit_bucket_27.getText().toString();

        if(edit_bucket_28.getText().toString().equals("")){
            answer28 = "미응답";
        }
        else
            answer28=edit_bucket_28.getText().toString();

        if(edit_bucket_29.getText().toString().equals("")){
            answer29 = "미응답";
        }
        else
            answer29=edit_bucket_29.getText().toString();

        if(edit_bucket_30.getText().toString().equals("")){
            answer30 = "미응답";
        }
        else
            answer30=edit_bucket_30.getText().toString();




        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSave customDialog = new CustomDialogSave(Question_bucket_30.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_bucket_30.this);
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

        Bucket30UpdateRequest registerRequest = new Bucket30UpdateRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12,answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_bucket_30.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }

    // 채팅방
    class BackgroundTask_roomList extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_bucket30List.php";
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

            bucket30List = new ArrayList<BUCKET30>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String bucket30Num, bucket30ID, bucket30Send, bucket30Answer1, bucket30Answer2, bucket30Answer3, bucket30Answer4, bucket30Answer5, bucket30Answer6,
                        bucket30Answer7, bucket30Answer8, bucket30Answer9, bucket30Answer10, bucket30Answer11, bucket30Answer12, bucket30Answer13, bucket30Answer14,
                        bucket30Answer15, bucket30Answer16, bucket30Answer17, bucket30Answer18, bucket30Answer19, bucket30Answer20, bucket30Answer21, bucket30Answer22,
                        bucket30Answer23, bucket30Answer24, bucket30Answer25 ,bucket30Answer26, bucket30Answer27, bucket30Answer28, bucket30Answer29, bucket30Answer30;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    bucket30Num = object.getString("bucket30Num");
                    bucket30ID = object.getString("bucket30ID");
                    bucket30Send = object.getString("bucket30Send");
                    bucket30Answer1 = object.getString("bucket30Answer1");
                    bucket30Answer2 = object.getString("bucket30Answer2");
                    bucket30Answer3 = object.getString("bucket30Answer3");
                    bucket30Answer4 = object.getString("bucket30Answer4");
                    bucket30Answer5 = object.getString("bucket30Answer5");
                    bucket30Answer6 = object.getString("bucket30Answer6");
                    bucket30Answer7 = object.getString("bucket30Answer7");
                    bucket30Answer8 = object.getString("bucket30Answer8");
                    bucket30Answer9 = object.getString("bucket30Answer9");
                    bucket30Answer10 = object.getString("bucket30Answer10");
                    bucket30Answer11 = object.getString("bucket30Answer11");
                    bucket30Answer12 = object.getString("bucket30Answer12");
                    bucket30Answer13 = object.getString("bucket30Answer13");
                    bucket30Answer14 = object.getString("bucket30Answer14");
                    bucket30Answer15 = object.getString("bucket30Answer15");
                    bucket30Answer16 = object.getString("bucket30Answer16");
                    bucket30Answer17 = object.getString("bucket30Answer17");
                    bucket30Answer18 = object.getString("bucket30Answer18");
                    bucket30Answer19 = object.getString("bucket30Answer19");
                    bucket30Answer20 = object.getString("bucket30Answer20");
                    bucket30Answer21 = object.getString("bucket30Answer21");
                    bucket30Answer22 = object.getString("bucket30Answer22");
                    bucket30Answer23 = object.getString("bucket30Answer23");
                    bucket30Answer24 = object.getString("bucket30Answer24");
                    bucket30Answer25 = object.getString("bucket30Answer25");
                    bucket30Answer26 = object.getString("bucket30Answer26");
                    bucket30Answer27 = object.getString("bucket30Answer27");
                    bucket30Answer28 = object.getString("bucket30Answer28");
                    bucket30Answer29 = object.getString("bucket30Answer29");
                    bucket30Answer30 = object.getString("bucket30Answer30");


                    if(bucket30ID.equals(LoginUserID)) {
                        BUCKET30 bucket30 = new BUCKET30(bucket30Num, bucket30ID, bucket30Send, bucket30Answer1, bucket30Answer2, bucket30Answer3, bucket30Answer4, bucket30Answer5, bucket30Answer6,
                                bucket30Answer7, bucket30Answer8, bucket30Answer9, bucket30Answer10,bucket30Answer11,bucket30Answer12,bucket30Answer13, bucket30Answer14,
                                bucket30Answer15,bucket30Answer16, bucket30Answer17, bucket30Answer18, bucket30Answer19, bucket30Answer20, bucket30Answer21,bucket30Answer22,
                                bucket30Answer23, bucket30Answer24, bucket30Answer25, bucket30Answer26, bucket30Answer27, bucket30Answer28, bucket30Answer29, bucket30Answer30);
                        bucket30List.add(bucket30);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(bucket30List.size()>=1){
                bucket10_update();
            }
            else if(bucket30List.size()==0){
                bucket10();
            }


        }

    }


    public void bucket10_send(){

        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10,
                answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30;

        if(edit_bucket_1.getText().toString().equals("")){
            answer1 = "미응답";
        }
        else
            answer1=edit_bucket_1.getText().toString();

        if(edit_bucket_2.getText().toString().equals("")){
            answer2 = "미응답";
        }
        else
            answer2=edit_bucket_2.getText().toString();

        if(edit_bucket_3.getText().toString().equals("")){
            answer3 = "미응답";
        }
        else
            answer3=edit_bucket_3.getText().toString();

        if(edit_bucket_4.getText().toString().equals("")){
            answer4 = "미응답";
        }
        else
            answer4=edit_bucket_4.getText().toString();

        if(edit_bucket_5.getText().toString().equals("")){
            answer5 = "미응답";
        }
        else
            answer5=edit_bucket_5.getText().toString();

        if(edit_bucket_6.getText().toString().equals("")){
            answer6 = "미응답";
        }
        else
            answer6=edit_bucket_6.getText().toString();

        if(edit_bucket_7.getText().toString().equals("")){
            answer7 = "미응답";
        }
        else
            answer7=edit_bucket_7.getText().toString();

        if(edit_bucket_8.getText().toString().equals("")){
            answer8 = "미응답";
        }
        else
            answer8=edit_bucket_8.getText().toString();

        if(edit_bucket_9.getText().toString().equals("")){
            answer9 = "미응답";
        }
        else
            answer9=edit_bucket_9.getText().toString();

        if(edit_bucket_10.getText().toString().equals("")){
            answer10 = "미응답";
        }
        else
            answer10=edit_bucket_10.getText().toString();

        if(edit_bucket_11.getText().toString().equals("")){
            answer11 = "미응답";
        }
        else
            answer11=edit_bucket_11.getText().toString();

        if(edit_bucket_12.getText().toString().equals("")){
            answer12 = "미응답";
        }
        else
            answer12=edit_bucket_12.getText().toString();

        if(edit_bucket_13.getText().toString().equals("")){
            answer13 = "미응답";
        }
        else
            answer13=edit_bucket_13.getText().toString();

        if(edit_bucket_14.getText().toString().equals("")){
            answer14 = "미응답";
        }
        else
            answer14=edit_bucket_14.getText().toString();

        if(edit_bucket_15.getText().toString().equals("")){
            answer15 = "미응답";
        }
        else
            answer15=edit_bucket_15.getText().toString();

        if(edit_bucket_16.getText().toString().equals("")){
            answer16 = "미응답";
        }
        else
            answer16=edit_bucket_16.getText().toString();

        if(edit_bucket_17.getText().toString().equals("")){
            answer17 = "미응답";
        }
        else
            answer17=edit_bucket_17.getText().toString();

        if(edit_bucket_18.getText().toString().equals("")){
            answer18 = "미응답";
        }
        else
            answer18=edit_bucket_18.getText().toString();

        if(edit_bucket_19.getText().toString().equals("")){
            answer19 = "미응답";
        }
        else
            answer19=edit_bucket_19.getText().toString();

        if(edit_bucket_20.getText().toString().equals("")){
            answer20 = "미응답";
        }
        else
            answer20=edit_bucket_20.getText().toString();

        if(edit_bucket_21.getText().toString().equals("")){
            answer21 = "미응답";
        }
        else
            answer21=edit_bucket_21.getText().toString();

        if(edit_bucket_22.getText().toString().equals("")){
            answer22 = "미응답";
        }
        else
            answer22=edit_bucket_22.getText().toString();

        if(edit_bucket_23.getText().toString().equals("")){
            answer23 = "미응답";
        }
        else
            answer23=edit_bucket_23.getText().toString();

        if(edit_bucket_24.getText().toString().equals("")){
            answer24 = "미응답";
        }
        else
            answer24=edit_bucket_24.getText().toString();

        if(edit_bucket_25.getText().toString().equals("")){
            answer25 = "미응답";
        }
        else
            answer25=edit_bucket_25.getText().toString();

        if(edit_bucket_26.getText().toString().equals("")){
            answer26 = "미응답";
        }
        else
            answer26=edit_bucket_26.getText().toString();

        if(edit_bucket_27.getText().toString().equals("")){
            answer27 = "미응답";
        }
        else
            answer27=edit_bucket_27.getText().toString();

        if(edit_bucket_28.getText().toString().equals("")){
            answer28 = "미응답";
        }
        else
            answer28=edit_bucket_28.getText().toString();

        if(edit_bucket_29.getText().toString().equals("")){
            answer29 = "미응답";
        }
        else
            answer29=edit_bucket_29.getText().toString();

        if(edit_bucket_30.getText().toString().equals("")){
            answer30 = "미응답";
        }
        else
            answer30=edit_bucket_30.getText().toString();



        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogUpdate customDialog = new CustomDialogUpdate(Question_bucket_30.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_bucket_30.this);
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

        Bucket30SendAddRequest registerRequest = new Bucket30SendAddRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12,answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_bucket_30.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }

    public void bucket10_update_send(){

        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10,
                answer11, answer12, answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30;

        if(edit_bucket_1.getText().toString().equals("")){
            answer1 = "미응답";
        }
        else
            answer1=edit_bucket_1.getText().toString();

        if(edit_bucket_2.getText().toString().equals("")){
            answer2 = "미응답";
        }
        else
            answer2=edit_bucket_2.getText().toString();

        if(edit_bucket_3.getText().toString().equals("")){
            answer3 = "미응답";
        }
        else
            answer3=edit_bucket_3.getText().toString();

        if(edit_bucket_4.getText().toString().equals("")){
            answer4 = "미응답";
        }
        else
            answer4=edit_bucket_4.getText().toString();

        if(edit_bucket_5.getText().toString().equals("")){
            answer5 = "미응답";
        }
        else
            answer5=edit_bucket_5.getText().toString();

        if(edit_bucket_6.getText().toString().equals("")){
            answer6 = "미응답";
        }
        else
            answer6=edit_bucket_6.getText().toString();

        if(edit_bucket_7.getText().toString().equals("")){
            answer7 = "미응답";
        }
        else
            answer7=edit_bucket_7.getText().toString();

        if(edit_bucket_8.getText().toString().equals("")){
            answer8 = "미응답";
        }
        else
            answer8=edit_bucket_8.getText().toString();

        if(edit_bucket_9.getText().toString().equals("")){
            answer9 = "미응답";
        }
        else
            answer9=edit_bucket_9.getText().toString();

        if(edit_bucket_10.getText().toString().equals("")){
            answer10 = "미응답";
        }
        else
            answer10=edit_bucket_10.getText().toString();

        if(edit_bucket_11.getText().toString().equals("")){
            answer11 = "미응답";
        }
        else
            answer11=edit_bucket_11.getText().toString();

        if(edit_bucket_12.getText().toString().equals("")){
            answer12 = "미응답";
        }
        else
            answer12=edit_bucket_12.getText().toString();

        if(edit_bucket_13.getText().toString().equals("")){
            answer13 = "미응답";
        }
        else
            answer13=edit_bucket_13.getText().toString();

        if(edit_bucket_14.getText().toString().equals("")){
            answer14 = "미응답";
        }
        else
            answer14=edit_bucket_14.getText().toString();

        if(edit_bucket_15.getText().toString().equals("")){
            answer15 = "미응답";
        }
        else
            answer15=edit_bucket_15.getText().toString();

        if(edit_bucket_16.getText().toString().equals("")){
            answer16 = "미응답";
        }
        else
            answer16=edit_bucket_16.getText().toString();

        if(edit_bucket_17.getText().toString().equals("")){
            answer17 = "미응답";
        }
        else
            answer17=edit_bucket_17.getText().toString();

        if(edit_bucket_18.getText().toString().equals("")){
            answer18 = "미응답";
        }
        else
            answer18=edit_bucket_18.getText().toString();

        if(edit_bucket_19.getText().toString().equals("")){
            answer19 = "미응답";
        }
        else
            answer19=edit_bucket_19.getText().toString();

        if(edit_bucket_20.getText().toString().equals("")){
            answer20 = "미응답";
        }
        else
            answer20=edit_bucket_20.getText().toString();

        if(edit_bucket_21.getText().toString().equals("")){
            answer21 = "미응답";
        }
        else
            answer21=edit_bucket_21.getText().toString();

        if(edit_bucket_22.getText().toString().equals("")){
            answer22 = "미응답";
        }
        else
            answer22=edit_bucket_22.getText().toString();

        if(edit_bucket_23.getText().toString().equals("")){
            answer23 = "미응답";
        }
        else
            answer23=edit_bucket_23.getText().toString();

        if(edit_bucket_24.getText().toString().equals("")){
            answer24 = "미응답";
        }
        else
            answer24=edit_bucket_24.getText().toString();

        if(edit_bucket_25.getText().toString().equals("")){
            answer25 = "미응답";
        }
        else
            answer25=edit_bucket_25.getText().toString();

        if(edit_bucket_26.getText().toString().equals("")){
            answer26 = "미응답";
        }
        else
            answer26=edit_bucket_26.getText().toString();

        if(edit_bucket_27.getText().toString().equals("")){
            answer27 = "미응답";
        }
        else
            answer27=edit_bucket_27.getText().toString();

        if(edit_bucket_28.getText().toString().equals("")){
            answer28 = "미응답";
        }
        else
            answer28=edit_bucket_28.getText().toString();

        if(edit_bucket_29.getText().toString().equals("")){
            answer29 = "미응답";
        }
        else
            answer29=edit_bucket_29.getText().toString();

        if(edit_bucket_30.getText().toString().equals("")){
            answer30 = "미응답";
        }
        else
            answer30=edit_bucket_30.getText().toString();




        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogUpdate customDialog = new CustomDialogUpdate(Question_bucket_30.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_bucket_30.this);
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

        Bucket30SendUpdateRequest registerRequest = new Bucket30SendUpdateRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, answer11, answer12,answer13, answer14, answer15, answer16, answer17, answer18, answer19, answer20,
                answer21, answer22, answer23, answer24, answer25, answer26, answer27, answer28, answer29, answer30, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_bucket_30.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }


    // 채팅방
    class BackgroundTask_send extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_bucket30SendList.php";
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

            bucket30List = new ArrayList<BUCKET30>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String bucket30Num, bucket30ID, bucket30Send, bucket30Answer1, bucket30Answer2, bucket30Answer3, bucket30Answer4, bucket30Answer5, bucket30Answer6,
                        bucket30Answer7, bucket30Answer8, bucket30Answer9, bucket30Answer10, bucket30Answer11, bucket30Answer12, bucket30Answer13, bucket30Answer14,
                        bucket30Answer15, bucket30Answer16, bucket30Answer17, bucket30Answer18, bucket30Answer19, bucket30Answer20, bucket30Answer21, bucket30Answer22,
                        bucket30Answer23, bucket30Answer24, bucket30Answer25 ,bucket30Answer26, bucket30Answer27, bucket30Answer28, bucket30Answer29, bucket30Answer30;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    bucket30Num = object.getString("bucket30Num");
                    bucket30ID = object.getString("bucket30ID");
                    bucket30Send = object.getString("bucket30Send");
                    bucket30Answer1 = object.getString("bucket30Answer1");
                    bucket30Answer2 = object.getString("bucket30Answer2");
                    bucket30Answer3 = object.getString("bucket30Answer3");
                    bucket30Answer4 = object.getString("bucket30Answer4");
                    bucket30Answer5 = object.getString("bucket30Answer5");
                    bucket30Answer6 = object.getString("bucket30Answer6");
                    bucket30Answer7 = object.getString("bucket30Answer7");
                    bucket30Answer8 = object.getString("bucket30Answer8");
                    bucket30Answer9 = object.getString("bucket30Answer9");
                    bucket30Answer10 = object.getString("bucket30Answer10");
                    bucket30Answer11 = object.getString("bucket30Answer11");
                    bucket30Answer12 = object.getString("bucket30Answer12");
                    bucket30Answer13 = object.getString("bucket30Answer13");
                    bucket30Answer14 = object.getString("bucket30Answer14");
                    bucket30Answer15 = object.getString("bucket30Answer15");
                    bucket30Answer16 = object.getString("bucket30Answer16");
                    bucket30Answer17 = object.getString("bucket30Answer17");
                    bucket30Answer18 = object.getString("bucket30Answer18");
                    bucket30Answer19 = object.getString("bucket30Answer19");
                    bucket30Answer20 = object.getString("bucket30Answer20");
                    bucket30Answer21 = object.getString("bucket30Answer21");
                    bucket30Answer22 = object.getString("bucket30Answer22");
                    bucket30Answer23 = object.getString("bucket30Answer23");
                    bucket30Answer24 = object.getString("bucket30Answer24");
                    bucket30Answer25 = object.getString("bucket30Answer25");
                    bucket30Answer26 = object.getString("bucket30Answer26");
                    bucket30Answer27 = object.getString("bucket30Answer27");
                    bucket30Answer28 = object.getString("bucket30Answer28");
                    bucket30Answer29 = object.getString("bucket30Answer29");
                    bucket30Answer30 = object.getString("bucket30Answer30");


                    if(bucket30ID.equals(LoginUserID)) {
                        BUCKET30 bucket30 = new BUCKET30(bucket30Num, bucket30ID, bucket30Send, bucket30Answer1, bucket30Answer2, bucket30Answer3, bucket30Answer4, bucket30Answer5, bucket30Answer6,
                                bucket30Answer7, bucket30Answer8, bucket30Answer9, bucket30Answer10,bucket30Answer11,bucket30Answer12,bucket30Answer13, bucket30Answer14,
                                bucket30Answer15,bucket30Answer16, bucket30Answer17, bucket30Answer18, bucket30Answer19, bucket30Answer20, bucket30Answer21,bucket30Answer22,
                                bucket30Answer23, bucket30Answer24, bucket30Answer25, bucket30Answer26, bucket30Answer27, bucket30Answer28, bucket30Answer29, bucket30Answer30);
                        bucket30List.add(bucket30);
                    }

                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(bucket30List.size()>=1){
                bucket10_update_send();
            }
            else if(bucket30List.size()==0){
                bucket10_send();
            }




        }

    }

    // 채팅방
    class BackgroundTask_you50List extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_bucket30List.php";
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

            bucket30List = new ArrayList<BUCKET30>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String bucket30Num, bucket30ID, bucket30Send, bucket30Answer1, bucket30Answer2, bucket30Answer3, bucket30Answer4, bucket30Answer5, bucket30Answer6,
                        bucket30Answer7, bucket30Answer8, bucket30Answer9, bucket30Answer10, bucket30Answer11, bucket30Answer12, bucket30Answer13, bucket30Answer14,
                        bucket30Answer15, bucket30Answer16, bucket30Answer17, bucket30Answer18, bucket30Answer19, bucket30Answer20, bucket30Answer21, bucket30Answer22,
                        bucket30Answer23, bucket30Answer24, bucket30Answer25 ,bucket30Answer26, bucket30Answer27, bucket30Answer28, bucket30Answer29, bucket30Answer30;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    bucket30Num = object.getString("bucket30Num");
                    bucket30ID = object.getString("bucket30ID");
                    bucket30Send = object.getString("bucket30Send");
                    bucket30Answer1 = object.getString("bucket30Answer1");
                    bucket30Answer2 = object.getString("bucket30Answer2");
                    bucket30Answer3 = object.getString("bucket30Answer3");
                    bucket30Answer4 = object.getString("bucket30Answer4");
                    bucket30Answer5 = object.getString("bucket30Answer5");
                    bucket30Answer6 = object.getString("bucket30Answer6");
                    bucket30Answer7 = object.getString("bucket30Answer7");
                    bucket30Answer8 = object.getString("bucket30Answer8");
                    bucket30Answer9 = object.getString("bucket30Answer9");
                    bucket30Answer10 = object.getString("bucket30Answer10");
                    bucket30Answer11 = object.getString("bucket30Answer11");
                    bucket30Answer12 = object.getString("bucket30Answer12");
                    bucket30Answer13 = object.getString("bucket30Answer13");
                    bucket30Answer14 = object.getString("bucket30Answer14");
                    bucket30Answer15 = object.getString("bucket30Answer15");
                    bucket30Answer16 = object.getString("bucket30Answer16");
                    bucket30Answer17 = object.getString("bucket30Answer17");
                    bucket30Answer18 = object.getString("bucket30Answer18");
                    bucket30Answer19 = object.getString("bucket30Answer19");
                    bucket30Answer20 = object.getString("bucket30Answer20");
                    bucket30Answer21 = object.getString("bucket30Answer21");
                    bucket30Answer22 = object.getString("bucket30Answer22");
                    bucket30Answer23 = object.getString("bucket30Answer23");
                    bucket30Answer24 = object.getString("bucket30Answer24");
                    bucket30Answer25 = object.getString("bucket30Answer25");
                    bucket30Answer26 = object.getString("bucket30Answer26");
                    bucket30Answer27 = object.getString("bucket30Answer27");
                    bucket30Answer28 = object.getString("bucket30Answer28");
                    bucket30Answer29 = object.getString("bucket30Answer29");
                    bucket30Answer30 = object.getString("bucket30Answer30");


                    if(bucket30ID.equals(LoginUserID)) {
                        BUCKET30 bucket30 = new BUCKET30(bucket30Num, bucket30ID, bucket30Send, bucket30Answer1, bucket30Answer2, bucket30Answer3, bucket30Answer4, bucket30Answer5, bucket30Answer6,
                                bucket30Answer7, bucket30Answer8, bucket30Answer9, bucket30Answer10,bucket30Answer11,bucket30Answer12,bucket30Answer13, bucket30Answer14,
                                bucket30Answer15,bucket30Answer16, bucket30Answer17, bucket30Answer18, bucket30Answer19, bucket30Answer20, bucket30Answer21,bucket30Answer22,
                                bucket30Answer23, bucket30Answer24, bucket30Answer25, bucket30Answer26, bucket30Answer27, bucket30Answer28, bucket30Answer29, bucket30Answer30);
                        bucket30List.add(bucket30);
                    }

                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }
            if(bucket30List.size()>=1) {
                edit_bucket_1.setText(bucket30List.get(0).getbucket30Answer1());
                edit_bucket_2.setText(bucket30List.get(0).getbucket30Answer2());
                edit_bucket_3.setText(bucket30List.get(0).getbucket30Answer3());
                edit_bucket_4.setText(bucket30List.get(0).getbucket30Answer4());
                edit_bucket_5.setText(bucket30List.get(0).getbucket30Answer5());
                edit_bucket_6.setText(bucket30List.get(0).getbucket30Answer6());
                edit_bucket_7.setText(bucket30List.get(0).getbucket30Answer7());
                edit_bucket_8.setText(bucket30List.get(0).getbucket30Answer8());
                edit_bucket_9.setText(bucket30List.get(0).getbucket30Answer9());
                edit_bucket_10.setText(bucket30List.get(0).getbucket30Answer10());
                edit_bucket_11.setText(bucket30List.get(0).getbucket30Answer11());
                edit_bucket_12.setText(bucket30List.get(0).getbucket30Answer12());
                edit_bucket_13.setText(bucket30List.get(0).getbucket30Answer13());
                edit_bucket_14.setText(bucket30List.get(0).getbucket30Answer14());
                edit_bucket_15.setText(bucket30List.get(0).getbucket30Answer15());
                edit_bucket_16.setText(bucket30List.get(0).getbucket30Answer16());
                edit_bucket_17.setText(bucket30List.get(0).getbucket30Answer17());
                edit_bucket_18.setText(bucket30List.get(0).getbucket30Answer18());
                edit_bucket_19.setText(bucket30List.get(0).getbucket30Answer19());
                edit_bucket_20.setText(bucket30List.get(0).getbucket30Answer20());
                edit_bucket_21.setText(bucket30List.get(0).getbucket30Answer21());
                edit_bucket_22.setText(bucket30List.get(0).getbucket30Answer22());
                edit_bucket_23.setText(bucket30List.get(0).getbucket30Answer23());
                edit_bucket_24.setText(bucket30List.get(0).getbucket30Answer24());
                edit_bucket_25.setText(bucket30List.get(0).getbucket30Answer25());
                edit_bucket_26.setText(bucket30List.get(0).getbucket30Answer26());
                edit_bucket_27.setText(bucket30List.get(0).getbucket30Answer27());
                edit_bucket_28.setText(bucket30List.get(0).getbucket30Answer28());
                edit_bucket_29.setText(bucket30List.get(0).getbucket30Answer29());
                edit_bucket_30.setText(bucket30List.get(0).getbucket30Answer30());


            }



        }

    }
}
