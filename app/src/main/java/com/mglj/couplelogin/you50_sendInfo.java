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

public class you50_sendInfo extends AppCompatActivity {

    TextView self50_anwser1, self50_anwser2, self50_anwser3, self50_anwser4, self50_anwser5, self50_anwser6, self50_anwser7, self50_anwser8,
            self50_anwser9, self50_anwser10, self50_anwser11, self50_anwser12, self50_anwser13, self50_anwser14, self50_anwser15, self50_anwser16
            ,self50_anwser17, self50_anwser18, self50_anwser19, self50_anwser20, self50_anwser21, self50_anwser22, self50_anwser23, self50_anwser24,
            self50_anwser25, self50_anwser26, self50_anwser27, self50_anwser28, self50_anwser29, self50_anwser30, self50_anwser31, self50_anwser32,
            self50_anwser33, self50_anwser34, self50_anwser35, self50_anwser36, self50_anwser37, self50_anwser38, self50_anwser39, self50_anwser40,
            self50_anwser41, self50_anwser42, self50_anwser43, self50_anwser44, self50_anwser45, self50_anwser46, self50_anwser47, self50_anwser48,
            self50_anwser49, self50_anwser50;

    TextView you50_answer1, you50_answer2, you50_answer3, you50_answer4, you50_answer5, you50_answer6, you50_answer7, you50_answer8,
            you50_answer9, you50_answer10, you50_answer11, you50_answer12, you50_answer13, you50_answer14, you50_answer15, you50_answer16
            ,you50_answer17, you50_answer18, you50_answer19, you50_answer20, you50_answer21, you50_answer22, you50_answer23, you50_answer24,
            you50_answer25, you50_answer26, you50_answer27, you50_answer28, you50_answer29, you50_answer30, you50_answer31, you50_answer32,
            you50_answer33, you50_answer34, you50_answer35, you50_answer36, you50_answer37, you50_answer38, you50_answer39, you50_answer40,
            you50_answer41, you50_answer42, you50_answer43, you50_answer44, you50_answer45, you50_answer46, you50_answer47, you50_answer48,
            you50_answer49, you50_answer50;

    ImageView de_no_cancle, de_no_can;
    List<Self50> self50List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you50_send_info);

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

        you50_answer1 = (TextView)findViewById(R.id.you50_answer1);
        you50_answer2 = (TextView)findViewById(R.id.you50_answer2);
        you50_answer3 = (TextView)findViewById(R.id.you50_answer3);
        you50_answer4 = (TextView)findViewById(R.id.you50_answer4);
        you50_answer5 = (TextView)findViewById(R.id.you50_answer5);
        you50_answer6 = (TextView)findViewById(R.id.you50_answer6);
        you50_answer7 = (TextView)findViewById(R.id.you50_answer7);
        you50_answer8 = (TextView)findViewById(R.id.you50_answer8);
        you50_answer9 = (TextView)findViewById(R.id.you50_answer9);
        you50_answer10 = (TextView)findViewById(R.id.you50_answer10);
        you50_answer11 = (TextView)findViewById(R.id.you50_answer11);
        you50_answer12 = (TextView)findViewById(R.id.you50_answer12);
        you50_answer13 = (TextView)findViewById(R.id.you50_answer13);
        you50_answer14 = (TextView)findViewById(R.id.you50_answer14);
        you50_answer15 = (TextView)findViewById(R.id.you50_answer15);
        you50_answer16 = (TextView)findViewById(R.id.you50_answer16);
        you50_answer17 = (TextView)findViewById(R.id.you50_answer17);
        you50_answer18 = (TextView)findViewById(R.id.you50_answer18);
        you50_answer19 = (TextView)findViewById(R.id.you50_answer19);
        you50_answer20 = (TextView)findViewById(R.id.you50_answer20);
        you50_answer21 = (TextView)findViewById(R.id.you50_answer21);
        you50_answer22 = (TextView)findViewById(R.id.you50_answer22);
        you50_answer23 = (TextView)findViewById(R.id.you50_answer23);
        you50_answer24 = (TextView)findViewById(R.id.you50_answer24);
        you50_answer25 = (TextView)findViewById(R.id.you50_answer25);
        you50_answer26 = (TextView)findViewById(R.id.you50_answer26);
        you50_answer27 = (TextView)findViewById(R.id.you50_answer27);
        you50_answer28 = (TextView)findViewById(R.id.you50_answer28);
        you50_answer29 = (TextView)findViewById(R.id.you50_answer29);
        you50_answer30 = (TextView)findViewById(R.id.you50_answer30);
        you50_answer31 = (TextView)findViewById(R.id.you50_answer31);
        you50_answer32 = (TextView)findViewById(R.id.you50_answer32);
        you50_answer33 = (TextView)findViewById(R.id.you50_answer33);
        you50_answer34 = (TextView)findViewById(R.id.you50_answer34);
        you50_answer35 = (TextView)findViewById(R.id.you50_answer35);
        you50_answer36 = (TextView)findViewById(R.id.you50_answer36);
        you50_answer37 = (TextView)findViewById(R.id.you50_answer37);
        you50_answer38 = (TextView)findViewById(R.id.you50_answer38);
        you50_answer39 = (TextView)findViewById(R.id.you50_answer39);
        you50_answer40 = (TextView)findViewById(R.id.you50_answer40);
        you50_answer41 = (TextView)findViewById(R.id.you50_answer41);
        you50_answer42 = (TextView)findViewById(R.id.you50_answer42);
        you50_answer43 = (TextView)findViewById(R.id.you50_answer43);
        you50_answer44 = (TextView)findViewById(R.id.you50_answer44);
        you50_answer45 = (TextView)findViewById(R.id.you50_answer45);
        you50_answer46 = (TextView)findViewById(R.id.you50_answer46);
        you50_answer47 = (TextView)findViewById(R.id.you50_answer47);
        you50_answer48 = (TextView)findViewById(R.id.you50_answer48);
        you50_answer49 = (TextView)findViewById(R.id.you50_answer49);
        you50_answer50 = (TextView)findViewById(R.id.you50_answer50);

        new BackgroundTask_roomList().execute();
        new BackgroundTask_give().execute();
    }

    // 채팅방
    class BackgroundTask_roomList extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_you50SendList.php";
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

            }
            else if(self50List.size()==0){

            }




        }

    }


    // 채팅방
    class BackgroundTask_give extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_you50GiveList.php";
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

                    if(self50ID.equals(CoupleID)) {
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

            }
            else if(self50List.size()==0){

            }




        }

    }
}
