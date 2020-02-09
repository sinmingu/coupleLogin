package com.mglj.couplelogin;

import android.os.AsyncTask;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
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

public class bucket10_Info extends AppCompatActivity {

    TextView self50_anwser1, self50_anwser2, self50_anwser3, self50_anwser4, self50_anwser5, self50_anwser6, self50_anwser7, self50_anwser8,
            self50_anwser9, self50_anwser10;

    List<BUCKET10> bucket10List;
    ImageView de_no_cancle, de_no_can;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket10__info);

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

        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);

        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        new BackgroundTask_roomList().execute();

    }

    // 채팅방
    class BackgroundTask_roomList extends AsyncTask<Void, Void, String> {

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


                    if(bucket10ID.equals(CoupleID)) {
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
                self50_anwser1.setText(bucket10List.get(0).getBucket10Answer1());
                self50_anwser2.setText(bucket10List.get(0).getBucket10Answer2());
                self50_anwser3.setText(bucket10List.get(0).getBucket10Answer3());
                self50_anwser4.setText(bucket10List.get(0).getBucket10Answer4());
                self50_anwser5.setText(bucket10List.get(0).getBucket10Answer5());
                self50_anwser6.setText(bucket10List.get(0).getBucket10Answer6());
                self50_anwser7.setText(bucket10List.get(0).getBucket10Answer7());
                self50_anwser8.setText(bucket10List.get(0).getBucket10Answer8());
                self50_anwser9.setText(bucket10List.get(0).getBucket10Answer9());
                self50_anwser10.setText(bucket10List.get(0).getBucket10Answer10());


            }
            else if(bucket10List.size()==0){

            }




        }

    }
}
