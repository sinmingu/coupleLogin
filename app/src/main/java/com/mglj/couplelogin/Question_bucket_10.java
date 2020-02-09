package com.mglj.couplelogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.mglj.couplelogin.SerchActivity.LoginUserID;

public class Question_bucket_10 extends AppCompatActivity {

    TabHost reg_tabHost;
    int page;
    TextView text_page;
    List<BUCKET10> bucket10List;
    TextView btn_save, btn_send;
    ImageView de_no_cancle, de_no_can, back_page, next_page;
    EditText edit_bucket_1, edit_bucket_2, edit_bucket_3, edit_bucket_4, edit_bucket_5, edit_bucket_6, edit_bucket_7,
            edit_bucket_8, edit_bucket_9, edit_bucket_10;
    InterstitialAd adfull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bucket_10);

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

        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);
        Glide.with(this).load(R.drawable.back_2).fitCenter().into(back_page);
        Glide.with(this).load(R.drawable.next_2).fitCenter().into(next_page);

        new BackgroundTask_you50List().execute();

        //-----------------------탭 호스트 시작------------------------------

        reg_tabHost = (TabHost)findViewById(R.id.reg_tab_host);

        reg_tabHost.setup();

        // 홈 탭
        TabHost.TabSpec reg_tabSpec1 = reg_tabHost.newTabSpec("Tab1");
        reg_tabSpec1.setIndicator("",getResources().getDrawable(R.drawable.add_date)); // Tab Subject
        reg_tabSpec1.setContent(new Intent(this,Question_self_100.class));
        reg_tabSpec1.setContent(R.id.reg_tab_view1); // Tab Content
        reg_tabHost.addTab(reg_tabSpec1);



        reg_tabHost.getTabWidget().getChildAt(0)

                .setBackgroundColor(Color.parseColor("#ffffff"));





        reg_tabHost.setCurrentTab(0); // 처음 열리는 탭

        text_page.setText(page+1 +" / 1");

        //-----------------------탭 호스트 끝--------------------------------

        back_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page==0){
                    Toast.makeText(getApplicationContext(),"최소 입니다",Toast.LENGTH_SHORT).show();
                }
                else {
                    page-=1;
                    reg_tabHost.setCurrentTab(page);
                    text_page.setText(page+1 +" / 1");

                }
            }
        });

        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page==0){
                    Toast.makeText(getApplicationContext(),"최대 입니다",Toast.LENGTH_SHORT).show();
                }
                else {
                    page+=1;
                    reg_tabHost.setCurrentTab(page);
                    text_page.setText(page+1 +" / 1");

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
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10;

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


        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSave customDialog = new CustomDialogSave(Question_bucket_10.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_bucket_10.this);
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

        Bucket10AddRequest registerRequest = new Bucket10AddRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_bucket_10.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------


    }

    public void bucket10_update(){

        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10;

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




        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSave customDialog = new CustomDialogSave(Question_bucket_10.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_bucket_10.this);
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

        Bucket10UpdateRequest registerRequest = new Bucket10UpdateRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_bucket_10.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }

    // 채팅방
    class BackgroundTask_roomList extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_bucket10List.php";
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

            bucket10List = new ArrayList<BUCKET10>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String bucket10Num, bucket10ID, bucket10Send, bucket10Answer1, bucket10Answer2, bucket10Answer3, bucket10Answer4, bucket10Answer5, bucket10Answer6,
                        bucket10Answer7, bucket10Answer8, bucket10Answer9, bucket10Answer10;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    bucket10Num = object.getString("bucket10Num");
                    bucket10ID = object.getString("bucket10ID");
                    bucket10Send = object.getString("bucket10Send");
                    bucket10Answer1 = object.getString("bucket10Answer1");
                    bucket10Answer2 = object.getString("bucket10Answer2");
                    bucket10Answer3 = object.getString("bucket10Answer3");
                    bucket10Answer4 = object.getString("bucket10Answer4");
                    bucket10Answer5 = object.getString("bucket10Answer5");
                    bucket10Answer6 = object.getString("bucket10Answer6");
                    bucket10Answer7 = object.getString("bucket10Answer7");
                    bucket10Answer8 = object.getString("bucket10Answer8");
                    bucket10Answer9 = object.getString("bucket10Answer9");
                    bucket10Answer10 = object.getString("bucket10Answer10");


                    if(bucket10ID.equals(LoginUserID)) {
                        BUCKET10 bucket10 = new BUCKET10(bucket10Num, bucket10ID, bucket10Send, bucket10Answer1, bucket10Answer2, bucket10Answer3, bucket10Answer4, bucket10Answer5, bucket10Answer6,
                                bucket10Answer7, bucket10Answer8, bucket10Answer9, bucket10Answer10);
                        bucket10List.add(bucket10);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(bucket10List.size()>=1){
                bucket10_update();
            }
            else if(bucket10List.size()==0){
                bucket10();
            }


        }

    }


    public void bucket10_send(){

        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10;

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




        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogUpdate customDialog = new CustomDialogUpdate(Question_bucket_10.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_bucket_10.this);
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

        Bucket10SendAddRequest registerRequest = new Bucket10SendAddRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10, responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_bucket_10.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }

    public void bucket10_update_send(){

        // --------------------유저 DB 등록 시작--------------------
        String self50ID = LoginUserID;
        String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10;

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




        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogUpdate customDialog = new CustomDialogUpdate(Question_bucket_10.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Question_bucket_10.this);
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

        Bucket10SendUpdateRequest registerRequest = new Bucket10SendUpdateRequest(self50ID, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8,
                answer9, answer10,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Question_bucket_10.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------

    }


    // 채팅방
    class BackgroundTask_send extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_bucket10SendList.php";
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

            bucket10List = new ArrayList<BUCKET10>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String bucket10Num, bucket10ID, bucket10Send, bucket10Answer1, bucket10Answer2, bucket10Answer3, bucket10Answer4, bucket10Answer5, bucket10Answer6,
                        bucket10Answer7, bucket10Answer8, bucket10Answer9, bucket10Answer10;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    bucket10Num = object.getString("bucket10Num");
                    bucket10ID = object.getString("bucket10ID");
                    bucket10Send = object.getString("bucket10Send");
                    bucket10Answer1 = object.getString("bucket10Answer1");
                    bucket10Answer2 = object.getString("bucket10Answer2");
                    bucket10Answer3 = object.getString("bucket10Answer3");
                    bucket10Answer4 = object.getString("bucket10Answer4");
                    bucket10Answer5 = object.getString("bucket10Answer5");
                    bucket10Answer6 = object.getString("bucket10Answer6");
                    bucket10Answer7 = object.getString("bucket10Answer7");
                    bucket10Answer8 = object.getString("bucket10Answer8");
                    bucket10Answer9 = object.getString("bucket10Answer9");
                    bucket10Answer10 = object.getString("bucket10Answer10");

                    if(bucket10ID.equals(LoginUserID)) {
                        BUCKET10 bucket10 = new BUCKET10(bucket10Num, bucket10ID, bucket10Send, bucket10Answer1, bucket10Answer2, bucket10Answer3, bucket10Answer4, bucket10Answer5, bucket10Answer6,
                                bucket10Answer7, bucket10Answer8, bucket10Answer9, bucket10Answer10);
                        bucket10List.add(bucket10);
                    }

                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(bucket10List.size()>=1){
                bucket10_update_send();
            }
            else if(bucket10List.size()==0){
                bucket10_send();
            }




        }

    }

    // 채팅방
    class BackgroundTask_you50List extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_bucket10List.php";
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

            bucket10List = new ArrayList<BUCKET10>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String bucket10Num, bucket10ID, bucket10Send, bucket10Answer1, bucket10Answer2, bucket10Answer3, bucket10Answer4, bucket10Answer5, bucket10Answer6,
                        bucket10Answer7, bucket10Answer8, bucket10Answer9, bucket10Answer10;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    bucket10Num = object.getString("bucket10Num");
                    bucket10ID = object.getString("bucket10ID");
                    bucket10Send = object.getString("bucket10Send");
                    bucket10Answer1 = object.getString("bucket10Answer1");
                    bucket10Answer2 = object.getString("bucket10Answer2");
                    bucket10Answer3 = object.getString("bucket10Answer3");
                    bucket10Answer4 = object.getString("bucket10Answer4");
                    bucket10Answer5 = object.getString("bucket10Answer5");
                    bucket10Answer6 = object.getString("bucket10Answer6");
                    bucket10Answer7 = object.getString("bucket10Answer7");
                    bucket10Answer8 = object.getString("bucket10Answer8");
                    bucket10Answer9 = object.getString("bucket10Answer9");
                    bucket10Answer10 = object.getString("bucket10Answer10");

                    if(bucket10ID.equals(LoginUserID)) {
                        BUCKET10 bucket10 = new BUCKET10(bucket10Num, bucket10ID, bucket10Send, bucket10Answer1, bucket10Answer2, bucket10Answer3, bucket10Answer4, bucket10Answer5, bucket10Answer6,
                                bucket10Answer7, bucket10Answer8, bucket10Answer9, bucket10Answer10);
                        bucket10List.add(bucket10);
                    }

                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }
            if(bucket10List.size()>=1) {
                edit_bucket_1.setText(bucket10List.get(0).getBucket10Answer1());
                edit_bucket_2.setText(bucket10List.get(0).getBucket10Answer2());
                edit_bucket_3.setText(bucket10List.get(0).getBucket10Answer3());
                edit_bucket_4.setText(bucket10List.get(0).getBucket10Answer4());
                edit_bucket_5.setText(bucket10List.get(0).getBucket10Answer5());
                edit_bucket_6.setText(bucket10List.get(0).getBucket10Answer6());
                edit_bucket_7.setText(bucket10List.get(0).getBucket10Answer7());
                edit_bucket_8.setText(bucket10List.get(0).getBucket10Answer8());
                edit_bucket_9.setText(bucket10List.get(0).getBucket10Answer9());
                edit_bucket_10.setText(bucket10List.get(0).getBucket10Answer10());


            }



        }

    }
}
