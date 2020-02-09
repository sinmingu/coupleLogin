package com.mglj.couplelogin;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

public class CoupleGame extends AppCompatActivity {

    TextView couple_id, text_couple_id, getFile;
    ImageView center_img;
    Button btn_start, btn_couple_start, btn_result;

    public static String LoginUserName;
    public static String CoupleUserName;
    List<GAME> gameList;

    List<User> userList;
    List<User> ColpleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couple_game);

        couple_id = (TextView)findViewById(R.id.couple_id);
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_couple_start = (Button)findViewById(R.id.btn_couple_start);
        btn_result = (Button)findViewById(R.id.btn_result);
        text_couple_id = (TextView)findViewById(R.id.text_couple_id);
        getFile = (TextView)findViewById(R.id.getFile);
        center_img = (ImageView)findViewById(R.id.center_img);

        Glide.with(this).load(R.drawable.heart).fitCenter().into(center_img);

//        couple_id.setText(LoginUserID+ " / " +CoupleID);

        new BackgroundTask_roomList().execute();

        new BackgroundTask_userList().execute();

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CoupleGameStart.class);
                intent.putExtra("gameCode","0");
                startActivity(intent);
            }
        });

        btn_couple_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CoupleGameStart.class);
                intent.putExtra("gameCode",gameList.get(0).getGameCode());
                startActivity(intent);
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CoupleGameResult.class);
                startActivity(intent);
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

                    if(gameID.equals(CoupleID)) {
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
                btn_couple_start.setVisibility(View.VISIBLE);
                btn_start.setVisibility(View.GONE);

            }
            else if(gameList.size()==0){
                btn_couple_start.setVisibility(View.GONE);
                btn_start.setVisibility(View.VISIBLE);

            }


        }

    }

    // 채팅방
    class BackgroundTask_userList extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_userList.php";
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

            userList = new ArrayList<User>();
            ColpleList  = new ArrayList<User>();
            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String userID, userPassword, userName,userSex, userRoom;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    userID = object.getString("userID");
                    userPassword = object.getString("userPassword");
                    userName = object.getString("userName");
                    userSex = object.getString("userSex");
                    userRoom = object.getString("userRoom");

                    if(userID.equals(LoginUserID)) {

                        User user = new User(userID, userPassword, userName, userSex, userRoom);
                        userList.add(user);
                    }

                    if(userID.equals(CoupleID)) {

                        User user = new User(userID, userPassword, userName, userSex, userRoom);
                        ColpleList.add(user);
                    }




                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(ColpleList.size()!=0&&userList.size()!=0){
                text_couple_id.setText(ColpleList.get(0).getUserName());
                getFile.setText(userList.get(0).getUserName());
                LoginUserName = userList.get(0).getUserName();
                CoupleUserName = ColpleList.get(0).getUserName();
            }
            else{
                getFile.setText(userList.get(0).getUserName());
                LoginUserName = userList.get(0).getUserName();
            }




        }

    }
}
