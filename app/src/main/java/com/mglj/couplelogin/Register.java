package com.mglj.couplelogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

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

public class Register extends AppCompatActivity {

    ImageView de_no_cancle, de_no_can;
    Button register_btn;
    EditText user_id, user_pw, user_name, user_pw_re;
    TextView user_sex;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        register_btn = (Button)findViewById(R.id.register_btn);

        user_id = (EditText)findViewById(R.id.user_id);
        user_pw = (EditText)findViewById(R.id.user_pw);
        user_name = (EditText)findViewById(R.id.user_name);
        user_sex = (TextView)findViewById(R.id.user_sex);
        user_pw_re = (EditText)findViewById(R.id.user_pw_re);

        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);



        user_sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialogSex customDialog = new CustomDialogSex(Register.this);

                // 커스텀 다이얼로그를 호출한다.
                // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                customDialog.callFunction(user_sex);

            }
        });



        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();

            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!user_pw.getText().toString().equals(user_pw_re.getText().toString())){
                    Toast.makeText(getApplicationContext(),"비밀번호가 서로다릅니다",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(user_id.getText().toString().equals("")||user_pw.getText().toString().equals("")||
                        user_name.getText().toString().equals("")||user_sex.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(),"정보를 입력해주세요",Toast.LENGTH_SHORT).show();
                }
                else{

                    new BackgroundTask_roomList_2().execute();

                }


            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //회원가입
    public void regitser(){

        // --------------------유저 DB 등록 시작--------------------
        String userID = user_id.getText().toString();
        String userPassword = user_pw.getText().toString();
        String userName = user_name.getText().toString();
        String userSex = user_sex.getText().toString();


        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSucces customDialog = new CustomDialogSucces(Register.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
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

        RegisterRequest registerRequest = new RegisterRequest(userID, userPassword, userName, userSex,responseListener);
        RequestQueue queue = Volley.newRequestQueue(Register.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------


    }

    // 채팅방
    class BackgroundTask_roomList_2 extends AsyncTask<Void, Void, String> {

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


                    if(userID.equals(user_id.getText().toString())) {
                        User user = new User(userID, userPassword, userName, userSex, userRoom);
                        userList.add(user);
                    }



                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(userList.size()==0){
                regitser();
            }
            else {
                Toast.makeText(getApplicationContext(), "중복된 아이디가 있습니다", Toast.LENGTH_SHORT).show();
            }


        }

    }

}
