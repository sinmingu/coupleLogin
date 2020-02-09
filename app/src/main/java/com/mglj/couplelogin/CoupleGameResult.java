package com.mglj.couplelogin;

import android.graphics.Color;
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

import static com.mglj.couplelogin.CoupleGame.CoupleUserName;
import static com.mglj.couplelogin.CoupleGame.LoginUserName;
import static com.mglj.couplelogin.MainLogin.CoupleID;
import static com.mglj.couplelogin.SerchActivity.LoginUserID;

public class CoupleGameResult extends AppCompatActivity {

    TextView couple_score, my_id, couple_id;
    TextView my_score1, my_score2, my_score3, my_score4, my_score5, my_score6, my_score7, my_score8, my_score9, my_score10, my_score11, my_score12,
            my_score13, my_score14, my_score15, my_score16, my_score17, my_score18, my_score19, my_score20;
    TextView couple_score1, couple_score2, couple_score3, couple_score4, couple_score5, couple_score6, couple_score7, couple_score8, couple_score9,
            couple_score10, couple_score11, couple_score12, couple_score13, couple_score14, couple_score15, couple_score16, couple_score17,
            couple_score18, couple_score19, couple_score20;

    List<GAME> gameList;
    List<GAME> gameCoupleList;

    ImageView de_no_cancle, de_no_can;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couple_game_result);

        couple_score = (TextView)findViewById(R.id.couple_score);

        my_id = (TextView)findViewById(R.id.my_id);
        couple_id = (TextView)findViewById(R.id.couple_id);
        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);

        my_score1 = (TextView)findViewById(R.id.my_score1);
        my_score2 = (TextView)findViewById(R.id.my_score2);
        my_score3 = (TextView)findViewById(R.id.my_score3);
        my_score4 = (TextView)findViewById(R.id.my_score4);
        my_score5 = (TextView)findViewById(R.id.my_score5);
        my_score6 = (TextView)findViewById(R.id.my_score6);
        my_score7 = (TextView)findViewById(R.id.my_score7);
        my_score8 = (TextView)findViewById(R.id.my_score8);
        my_score9 = (TextView)findViewById(R.id.my_score9);
        my_score10 = (TextView)findViewById(R.id.my_score10);
        my_score11 = (TextView)findViewById(R.id.my_score11);
        my_score12 = (TextView)findViewById(R.id.my_score12);
        my_score13 = (TextView)findViewById(R.id.my_score13);
        my_score14 = (TextView)findViewById(R.id.my_score14);
        my_score15 = (TextView)findViewById(R.id.my_score15);
        my_score16= (TextView)findViewById(R.id.my_score16);
        my_score17 = (TextView)findViewById(R.id.my_score17);
        my_score18 = (TextView)findViewById(R.id.my_score18);
        my_score19 = (TextView)findViewById(R.id.my_score19);
        my_score20 = (TextView)findViewById(R.id.my_score20);

        couple_score1 = (TextView)findViewById(R.id.couple_score1);
        couple_score2 = (TextView)findViewById(R.id.couple_score2);
        couple_score3 = (TextView)findViewById(R.id.couple_score3);
        couple_score4 = (TextView)findViewById(R.id.couple_score4);
        couple_score5 = (TextView)findViewById(R.id.couple_score5);
        couple_score6 = (TextView)findViewById(R.id.couple_score6);
        couple_score7 = (TextView)findViewById(R.id.couple_score7);
        couple_score8 = (TextView)findViewById(R.id.couple_score8);
        couple_score9 = (TextView)findViewById(R.id.couple_score9);
        couple_score10 = (TextView)findViewById(R.id.couple_score10);
        couple_score11 = (TextView)findViewById(R.id.couple_score11);
        couple_score12 = (TextView)findViewById(R.id.couple_score12);
        couple_score13 = (TextView)findViewById(R.id.couple_score13);
        couple_score14 = (TextView)findViewById(R.id.couple_score14);
        couple_score15 = (TextView)findViewById(R.id.couple_score15);
        couple_score16 = (TextView)findViewById(R.id.couple_score16);
        couple_score17 = (TextView)findViewById(R.id.couple_score17);
        couple_score18 = (TextView)findViewById(R.id.couple_score18);
        couple_score19 = (TextView)findViewById(R.id.couple_score19);
        couple_score20 = (TextView)findViewById(R.id.couple_score20);

        new BackgroundTask_roomList().execute();
        new BackgroundTask_roomList2().execute();

        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    // 채팅방
    class BackgroundTask_roomList extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_gameList.php";
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

            gameList = new ArrayList<GAME>();
            gameCoupleList = new ArrayList<GAME>();
            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String gameNum, gameID, gameCode, gameAnswer1, gameAnswer2, gameAnswer3, gameAnswer4, gameAnswer5, gameAnswer6,
                        gameAnswer7, gameAnswer8, gameAnswer9, gameAnswer10, gameAnswer11, gameAnswer12, gameAnswer13, gameAnswer14,
                        gameAnswer15, gameAnswer16, gameAnswer17, gameAnswer18, gameAnswer19, gameAnswer20;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    gameNum = object.getString("gameNum");
                    gameID = object.getString("gameID");
                    gameCode = object.getString("gameCode");
                    gameAnswer1 = object.getString("gameAnswer1");
                    gameAnswer2 = object.getString("gameAnswer2");
                    gameAnswer3 = object.getString("gameAnswer3");
                    gameAnswer4 = object.getString("gameAnswer4");
                    gameAnswer5 = object.getString("gameAnswer5");
                    gameAnswer6 = object.getString("gameAnswer6");
                    gameAnswer7 = object.getString("gameAnswer7");
                    gameAnswer8 = object.getString("gameAnswer8");
                    gameAnswer9 = object.getString("gameAnswer9");
                    gameAnswer10 = object.getString("gameAnswer10");
                    gameAnswer11 = object.getString("gameAnswer11");
                    gameAnswer12 = object.getString("gameAnswer12");
                    gameAnswer13 = object.getString("gameAnswer13");
                    gameAnswer14 = object.getString("gameAnswer14");
                    gameAnswer15 = object.getString("gameAnswer15");
                    gameAnswer16 = object.getString("gameAnswer16");
                    gameAnswer17 = object.getString("gameAnswer17");
                    gameAnswer18 = object.getString("gameAnswer18");
                    gameAnswer19 = object.getString("gameAnswer19");
                    gameAnswer20 = object.getString("gameAnswer20");

                    if(gameID.equals(LoginUserID)) {
                        GAME game = new GAME(gameNum, gameID, gameCode, gameAnswer1, gameAnswer2, gameAnswer3, gameAnswer4, gameAnswer5, gameAnswer6,
                                gameAnswer7, gameAnswer8, gameAnswer9, gameAnswer10, gameAnswer11,gameAnswer12, gameAnswer13, gameAnswer14, gameAnswer15,
                                gameAnswer16, gameAnswer17, gameAnswer18, gameAnswer19, gameAnswer20);
                        gameList.add(game);
                    }

                    if(gameID.equals(CoupleID)) {
                        GAME game = new GAME(gameNum, gameID, gameCode, gameAnswer1, gameAnswer2, gameAnswer3, gameAnswer4, gameAnswer5, gameAnswer6,
                                gameAnswer7, gameAnswer8, gameAnswer9, gameAnswer10, gameAnswer11,gameAnswer12, gameAnswer13, gameAnswer14, gameAnswer15,
                                gameAnswer16, gameAnswer17, gameAnswer18, gameAnswer19, gameAnswer20);
                        gameCoupleList.add(game);
                    }

                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(gameCoupleList.size()>=1&&gameList.size()>=1){
                couple_score1.setText(gameCoupleList.get(0).getGameAnswer1());
                couple_score2.setText(gameCoupleList.get(0).getGameAnswer2());
                couple_score3.setText(gameCoupleList.get(0).getGameAnswer3());
                couple_score4.setText(gameCoupleList.get(0).getGameAnswer4());
                couple_score5.setText(gameCoupleList.get(0).getGameAnswer5());
                couple_score6.setText(gameCoupleList.get(0).getGameAnswer6());
                couple_score7.setText(gameCoupleList.get(0).getGameAnswer7());
                couple_score8.setText(gameCoupleList.get(0).getGameAnswer8());
                couple_score9.setText(gameCoupleList.get(0).getGameAnswer9());
                couple_score10.setText(gameCoupleList.get(0).getGameAnswer10());
                couple_score11.setText(gameCoupleList.get(0).getGameAnswer11());
                couple_score12.setText(gameCoupleList.get(0).getGameAnswer12());
                couple_score13.setText(gameCoupleList.get(0).getGameAnswer13());
                couple_score14.setText(gameCoupleList.get(0).getGameAnswer14());
                couple_score15.setText(gameCoupleList.get(0).getGameAnswer15());
                couple_score16.setText(gameCoupleList.get(0).getGameAnswer16());
                couple_score17.setText(gameCoupleList.get(0).getGameAnswer17());
                couple_score18.setText(gameCoupleList.get(0).getGameAnswer18());
                couple_score19.setText(gameCoupleList.get(0).getGameAnswer19());
                couple_score20.setText(gameCoupleList.get(0).getGameAnswer20());


                couple_id.setText(CoupleUserName);

                if(gameList.get(0).getGameAnswer1().equals(gameCoupleList.get(0).getGameAnswer1())&&!gameList.get(0).getGameAnswer1().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer1().equals("시간초과")){
                    score+=5;
                    couple_score1.setTextColor(Color.rgb(255,72,72));
                    my_score1.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer2().equals(gameCoupleList.get(0).getGameAnswer2())&&!gameList.get(0).getGameAnswer2().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer2().equals("시간초과")){
                    score+=5;
                    couple_score2.setTextColor(Color.rgb(255,72,72));
                    my_score2.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer3().equals(gameCoupleList.get(0).getGameAnswer3())&&!gameList.get(0).getGameAnswer3().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer3().equals("시간초과")){
                    score+=5;
                    couple_score3.setTextColor(Color.rgb(255,72,72));
                    my_score3.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer4().equals(gameCoupleList.get(0).getGameAnswer4())&&!gameList.get(0).getGameAnswer4().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer4().equals("시간초과")){
                    score+=5;
                    couple_score4.setTextColor(Color.rgb(255,72,72));
                    my_score4.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer5().equals(gameCoupleList.get(0).getGameAnswer5())&&!gameList.get(0).getGameAnswer5().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer5().equals("시간초과")){
                    score+=5;
                    couple_score5.setTextColor(Color.rgb(255,72,72));
                    my_score5.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer6().equals(gameCoupleList.get(0).getGameAnswer6())&&!gameList.get(0).getGameAnswer6().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer6().equals("시간초과")){
                    score+=5;
                    couple_score6.setTextColor(Color.rgb(255,72,72));
                    my_score6.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer7().equals(gameCoupleList.get(0).getGameAnswer7())&&!gameList.get(0).getGameAnswer7().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer7().equals("시간초과")){
                    score+=5;
                    couple_score7.setTextColor(Color.rgb(255,72,72));
                    my_score7.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer8().equals(gameCoupleList.get(0).getGameAnswer8())&&!gameList.get(0).getGameAnswer8().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer8().equals("시간초과")){
                    score+=5;
                    couple_score8.setTextColor(Color.rgb(255,72,72));
                    my_score8.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer9().equals(gameCoupleList.get(0).getGameAnswer9())&&!gameList.get(0).getGameAnswer9().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer9().equals("시간초과")){
                    score+=5;
                    couple_score9.setTextColor(Color.rgb(255,72,72));
                    my_score9.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer10().equals(gameCoupleList.get(0).getGameAnswer10())&&!gameList.get(0).getGameAnswer10().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer10().equals("시간초과")){
                    score+=5;
                    couple_score10.setTextColor(Color.rgb(255,72,72));
                    my_score10.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer11().equals(gameCoupleList.get(0).getGameAnswer11())&&!gameList.get(0).getGameAnswer11().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer11().equals("시간초과")){
                    score+=5;
                    couple_score11.setTextColor(Color.rgb(255,72,72));
                    my_score11.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer12().equals(gameCoupleList.get(0).getGameAnswer12())&&!gameList.get(0).getGameAnswer12().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer12().equals("시간초과")){
                    score+=5;
                    couple_score12.setTextColor(Color.rgb(255,72,72));
                    my_score12.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer13().equals(gameCoupleList.get(0).getGameAnswer13())&&!gameList.get(0).getGameAnswer13().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer13().equals("시간초과")){
                    score+=5;
                    couple_score13.setTextColor(Color.rgb(255,72,72));
                    my_score13.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer14().equals(gameCoupleList.get(0).getGameAnswer14())&&!gameList.get(0).getGameAnswer14().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer14().equals("시간초과")){
                    score+=5;
                    couple_score14.setTextColor(Color.rgb(255,72,72));
                    my_score14.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer15().equals(gameCoupleList.get(0).getGameAnswer15())&&!gameList.get(0).getGameAnswer15().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer15().equals("시간초과")){
                    score+=5;
                    couple_score15.setTextColor(Color.rgb(255,72,72));
                    my_score15.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer16().equals(gameCoupleList.get(0).getGameAnswer16())&&!gameList.get(0).getGameAnswer16().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer16().equals("시간초과")){
                    score+=5;
                    couple_score16.setTextColor(Color.rgb(255,72,72));
                    my_score16.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer17().equals(gameCoupleList.get(0).getGameAnswer17())&&!gameList.get(0).getGameAnswer17().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer17().equals("시간초과")){
                    score+=5;
                    couple_score17.setTextColor(Color.rgb(255,72,72));
                    my_score17.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer18().equals(gameCoupleList.get(0).getGameAnswer18())&&!gameList.get(0).getGameAnswer18().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer18().equals("시간초과")){
                    score+=5;
                    couple_score18.setTextColor(Color.rgb(255,72,72));
                    my_score18.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer19().equals(gameCoupleList.get(0).getGameAnswer19())&&!gameList.get(0).getGameAnswer19().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer19().equals("시간초과")){
                    score+=5;
                    couple_score19.setTextColor(Color.rgb(255,72,72));
                    my_score19.setTextColor(Color.rgb(255,72,72));
                }
                if(gameList.get(0).getGameAnswer20().equals(gameCoupleList.get(0).getGameAnswer20())&&!gameList.get(0).getGameAnswer20().equals("시간초과")&&!gameCoupleList.get(0).getGameAnswer20().equals("시간초과")){
                    score+=5;
                    couple_score20.setTextColor(Color.rgb(255,72,72));
                    my_score20.setTextColor(Color.rgb(255,72,72));
                }

                couple_score.setText(score+"점");


            }
            else if(gameList.size()==0){


            }


        }

    }

    // 채팅방
    class BackgroundTask_roomList2 extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_gameList.php";
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

            gameList = new ArrayList<GAME>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String gameNum, gameID, gameCode, gameAnswer1, gameAnswer2, gameAnswer3, gameAnswer4, gameAnswer5, gameAnswer6,
                        gameAnswer7, gameAnswer8, gameAnswer9, gameAnswer10, gameAnswer11, gameAnswer12, gameAnswer13, gameAnswer14,
                        gameAnswer15, gameAnswer16, gameAnswer17, gameAnswer18, gameAnswer19, gameAnswer20;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    gameNum = object.getString("gameNum");
                    gameID = object.getString("gameID");
                    gameCode = object.getString("gameCode");
                    gameAnswer1 = object.getString("gameAnswer1");
                    gameAnswer2 = object.getString("gameAnswer2");
                    gameAnswer3 = object.getString("gameAnswer3");
                    gameAnswer4 = object.getString("gameAnswer4");
                    gameAnswer5 = object.getString("gameAnswer5");
                    gameAnswer6 = object.getString("gameAnswer6");
                    gameAnswer7 = object.getString("gameAnswer7");
                    gameAnswer8 = object.getString("gameAnswer8");
                    gameAnswer9 = object.getString("gameAnswer9");
                    gameAnswer10 = object.getString("gameAnswer10");
                    gameAnswer11 = object.getString("gameAnswer11");
                    gameAnswer12 = object.getString("gameAnswer12");
                    gameAnswer13 = object.getString("gameAnswer13");
                    gameAnswer14 = object.getString("gameAnswer14");
                    gameAnswer15 = object.getString("gameAnswer15");
                    gameAnswer16 = object.getString("gameAnswer16");
                    gameAnswer17 = object.getString("gameAnswer17");
                    gameAnswer18 = object.getString("gameAnswer18");
                    gameAnswer19 = object.getString("gameAnswer19");
                    gameAnswer20 = object.getString("gameAnswer20");

                    if(gameID.equals(LoginUserID)) {
                        GAME game = new GAME(gameNum, gameID, gameCode, gameAnswer1, gameAnswer2, gameAnswer3, gameAnswer4, gameAnswer5, gameAnswer6,
                                gameAnswer7, gameAnswer8, gameAnswer9, gameAnswer10, gameAnswer11,gameAnswer12, gameAnswer13, gameAnswer14, gameAnswer15,
                                gameAnswer16, gameAnswer17, gameAnswer18, gameAnswer19, gameAnswer20);
                        gameList.add(game);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(gameList.size()>=1){
                my_score1.setText(gameList.get(0).getGameAnswer1());
                my_score2.setText(gameList.get(0).getGameAnswer2());
                my_score3.setText(gameList.get(0).getGameAnswer3());
                my_score4.setText(gameList.get(0).getGameAnswer4());
                my_score5.setText(gameList.get(0).getGameAnswer5());
                my_score6.setText(gameList.get(0).getGameAnswer6());
                my_score7.setText(gameList.get(0).getGameAnswer7());
                my_score8.setText(gameList.get(0).getGameAnswer8());
                my_score9.setText(gameList.get(0).getGameAnswer9());
                my_score10.setText(gameList.get(0).getGameAnswer10());
                my_score11.setText(gameList.get(0).getGameAnswer11());
                my_score12.setText(gameList.get(0).getGameAnswer12());
                my_score13.setText(gameList.get(0).getGameAnswer13());
                my_score14.setText(gameList.get(0).getGameAnswer14());
                my_score15.setText(gameList.get(0).getGameAnswer15());
                my_score16.setText(gameList.get(0).getGameAnswer16());
                my_score17.setText(gameList.get(0).getGameAnswer17());
                my_score18.setText(gameList.get(0).getGameAnswer18());
                my_score19.setText(gameList.get(0).getGameAnswer19());
                my_score20.setText(gameList.get(0).getGameAnswer20());

                my_id.setText(LoginUserName);


            }
            else if(gameList.size()==0){


            }


        }

    }
}
