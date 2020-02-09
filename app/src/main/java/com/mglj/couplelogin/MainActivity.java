package com.mglj.couplelogin;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
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

public class MainActivity extends AppCompatActivity {

    TextView move_RegiAc;
    ImageView id_img, pw_img;
    Button login_btn;
    EditText userId, userPw;
    ImageView main_img;

    CheckBox auto_login;
    private List<Room> roomArrayList;
    public static int auto_int = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        move_RegiAc = (TextView)findViewById(R.id.move_RegiAc);
        id_img = (ImageView)findViewById(R.id.id_img);
        pw_img = (ImageView)findViewById(R.id.pw_img);
        login_btn = (Button)findViewById(R.id.login_btn);
        userId = (EditText)findViewById(R.id.userId);
        userPw = (EditText)findViewById(R.id.userPw);
        auto_login = (CheckBox)findViewById(R.id.auto_login);
        main_img =(ImageView)findViewById(R.id.main_img);

        Glide.with(this).load(R.drawable.s_user).fitCenter().into(id_img);
        Glide.with(this).load(R.drawable.pass).fitCenter().into(pw_img);
        Glide.with(this).load(R.drawable.maincha).fitCenter().into(main_img);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                                progressDialog.setIndeterminate(true);
                                progressDialog.setMessage("로그인 요청중입니다.");
                                progressDialog.show();


                                final String userID = userId.getText().toString();
                                String userPassword = userPw.getText().toString();


                                Response.Listener<String>  responseListener = new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        try{
                                            JSONObject jsonReponse = new JSONObject(response);
                                            boolean success = jsonReponse.getBoolean("success");
                                            if(success){

                                                if(auto_login.isChecked()==true){

                                                    String userID = jsonReponse.getString("userID");
                                                    String userPassword = jsonReponse.getString("userPassword");
                                                    String userName = jsonReponse.getString("userName");
                                                    String userSex = jsonReponse.getString("userSex");
                                                    Intent intent = new Intent(MainActivity.this, SerchActivity.class);
                                                    intent.putExtra("userID", userID);
                                                    intent.putExtra("userPassword", userPassword);
                                                    intent.putExtra("userName", userName);
                                                    intent.putExtra("userSex", userSex);

                                                    SharedPreferences sharedPreferences = getSharedPreferences("LoginUser",MODE_PRIVATE);
                                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                                    editor.putString("userID",userID); // key, value를 이용하여 저장하는 형태
                                                    editor.putString("userPassword",userPassword);
                                                    editor.putString("userName",userName);
                                                    editor.putString("userSex",userSex);
                                                    editor.putString("auto","yes");
                                                    editor.commit();
                                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                                                    MainActivity.this.startActivity(intent);
                                                    progressDialog.dismiss();

                                                    }
                                                    else {
                                                        String userID = jsonReponse.getString("userID");
                                                        String userPassword = jsonReponse.getString("userPassword");
                                                        String userName = jsonReponse.getString("userName");
                                                        String userSex = jsonReponse.getString("userSex");
                                                        Intent intent = new Intent(MainActivity.this, SerchActivity.class);
                                                        intent.putExtra("userID", userID);
                                                        intent.putExtra("userPassword", userPassword);
                                                        intent.putExtra("userName", userName);
                                                        intent.putExtra("userSex", userSex);


                                                        SharedPreferences sharedPreferences = getSharedPreferences("LoginUser",MODE_PRIVATE);
                                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                                        editor.putString("userID",""); // key, value를 이용하여 저장하는 형태
                                                        editor.putString("userPassword","");
                                                        editor.putString("userName","");
                                                        editor.putString("userSex","");
                                                        editor.putString("auto","");
                                                        editor.commit();

                                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                        MainActivity.this.startActivity(intent);
                                                        progressDialog.dismiss();
                                                    }


                                            }
                                            else{
                                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                                builder.setMessage("로그인에 실패했습니다.")
                                                        .setNegativeButton("다시시도",null)
                                                        .create()
                                                        .show();

                                                progressDialog.dismiss();

                                            }

                                        }
                                        catch(Exception e){
                                            e.getStackTrace();
                                        }
                                    }
                                };

                                LoginRequest loginRequest = new LoginRequest(userID,userPassword,responseListener);
                                RequestQueue queue  = Volley.newRequestQueue(MainActivity.this);
                                queue.add(loginRequest);




                            }
                        }, 300);


            }
        });


        move_RegiAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);

            }
        });

        // 자동로그인
        SharedPreferences sf = getSharedPreferences("LoginUser",MODE_PRIVATE);

        if(!sf.getString("userID","").equals("")){
            Intent intent = new Intent(getApplicationContext(),SerchActivity.class);
            intent.putExtra("userID", sf.getString("userID",""));
            intent.putExtra("userPassword", sf.getString("userPassword",""));
            intent.putExtra("userName", sf.getString("userName",""));
            intent.putExtra("userSex", sf.getString("userSex",""));
            intent.putExtra("auto", sf.getString("auto",""));
            startActivity(intent);
        }

    }

    // 채팅방
    class BackgroundTask_roomList extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_RoomList.php";
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

            roomArrayList = new ArrayList<Room>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String roomNum, roomName, roomPass, room_makeID,room_intoID,roomDate;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    roomNum = object.getString("roomNum");
                    roomName = object.getString("roomName");
                    roomPass = object.getString("roomPass");
                    room_makeID = object.getString("room_makeID");
                    room_intoID = object.getString("room_intoID");
                    roomDate = object.getString("roomDate");


                    Room room = new Room(roomNum, roomName, roomPass, room_makeID, room_intoID, roomDate);
                    roomArrayList.add(room);



                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }




        }

    }

    @Override
    public void onBackPressed() {


        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
        CustomDialogExit customDialog = new CustomDialogExit(MainActivity.this);

        // 커스텀 다이얼로그를 호출한다.
        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.


        customDialog.callFunction();

    }
}
