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

public class bucket30_Info extends AppCompatActivity {

    TextView self50_anwser1, self50_anwser2, self50_anwser3, self50_anwser4, self50_anwser5, self50_anwser6, self50_anwser7, self50_anwser8,
            self50_anwser9, self50_anwser10, self50_anwser11, self50_anwser12, self50_anwser13, self50_anwser14, self50_anwser15, self50_anwser16,
            self50_anwser17, self50_anwser18, self50_anwser19, self50_anwser20, self50_anwser21, self50_anwser22, self50_anwser23,  self50_anwser24,
            self50_anwser25, self50_anwser26, self50_anwser27, self50_anwser28, self50_anwser29, self50_anwser30;

    List<BUCKET30> bucket30List;
    ImageView de_no_cancle, de_no_can;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket30__info);
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

        new BackgroundTask_you50List().execute();
    }

    // 채팅방
    class BackgroundTask_you50List extends AsyncTask<Void, Void, String> {

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


                    if(bucket30ID.equals(CoupleID)) {
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
                self50_anwser1.setText(bucket30List.get(0).getbucket30Answer1());
                self50_anwser2.setText(bucket30List.get(0).getbucket30Answer2());
                self50_anwser3.setText(bucket30List.get(0).getbucket30Answer3());
                self50_anwser4.setText(bucket30List.get(0).getbucket30Answer4());
                self50_anwser5.setText(bucket30List.get(0).getbucket30Answer5());
                self50_anwser6.setText(bucket30List.get(0).getbucket30Answer6());
                self50_anwser7.setText(bucket30List.get(0).getbucket30Answer7());
                self50_anwser8.setText(bucket30List.get(0).getbucket30Answer8());
                self50_anwser9.setText(bucket30List.get(0).getbucket30Answer9());
                self50_anwser10.setText(bucket30List.get(0).getbucket30Answer10());
                self50_anwser11.setText(bucket30List.get(0).getbucket30Answer11());
                self50_anwser12.setText(bucket30List.get(0).getbucket30Answer12());
                self50_anwser13.setText(bucket30List.get(0).getbucket30Answer13());
                self50_anwser14.setText(bucket30List.get(0).getbucket30Answer14());
                self50_anwser15.setText(bucket30List.get(0).getbucket30Answer15());
                self50_anwser16.setText(bucket30List.get(0).getbucket30Answer16());
                self50_anwser17.setText(bucket30List.get(0).getbucket30Answer17());
                self50_anwser18.setText(bucket30List.get(0).getbucket30Answer18());
                self50_anwser19.setText(bucket30List.get(0).getbucket30Answer19());
                self50_anwser20.setText(bucket30List.get(0).getbucket30Answer20());
                self50_anwser21.setText(bucket30List.get(0).getbucket30Answer21());
                self50_anwser22.setText(bucket30List.get(0).getbucket30Answer22());
                self50_anwser23.setText(bucket30List.get(0).getbucket30Answer23());
                self50_anwser24.setText(bucket30List.get(0).getbucket30Answer24());
                self50_anwser25.setText(bucket30List.get(0).getbucket30Answer25());
                self50_anwser26.setText(bucket30List.get(0).getbucket30Answer26());
                self50_anwser27.setText(bucket30List.get(0).getbucket30Answer27());
                self50_anwser28.setText(bucket30List.get(0).getbucket30Answer28());
                self50_anwser29.setText(bucket30List.get(0).getbucket30Answer29());
                self50_anwser30.setText(bucket30List.get(0).getbucket30Answer30());


            }



        }

    }
}
