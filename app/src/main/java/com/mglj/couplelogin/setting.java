package com.mglj.couplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

import static com.mglj.couplelogin.SerchActivity.LoginUserID;

public class setting extends AppCompatActivity {

    ImageView de_no_cancle, de_no_can;
    TextView userId, userNick, userNick_change, password_re;
    List<User> userList;
    EditText edit_userNick, edit_pass, edit_pass_re;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);

        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);

        userId = (TextView)findViewById(R.id.userId);
        userNick = (TextView)findViewById(R.id.userNick);
        edit_userNick = (EditText)findViewById(R.id.edit_userNick);
        userNick_change = (TextView)findViewById(R.id.userNick_change);
        edit_pass = (EditText)findViewById(R.id.edit_pass);
        edit_pass_re = (EditText)findViewById(R.id.edit_pass_re);
        password_re = (TextView)findViewById(R.id.password_re);

        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        userNick_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userNick_change.getText().toString().equals("수정")) {
                    edit_userNick.setVisibility(View.VISIBLE);
                    userNick.setVisibility(View.GONE);
                    userNick_change.setText("확인");
                }
                // 확인 버튼
                else{
                    edit_userNick.setVisibility(View.GONE);
                    userNick.setVisibility(View.VISIBLE);
                    userNick_change.setText("수정");
                    userNick_update();
                }
            }
        });

        password_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit_pass.getText().toString().equals("")||edit_pass_re.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"공백이 있습니다.",Toast.LENGTH_SHORT).show();
                }
                else if(!(edit_pass.getText().toString().equals(edit_pass_re.getText().toString()))){
                    Toast.makeText(getApplicationContext(),"비밀번호가 서로 다릅니다",Toast.LENGTH_SHORT).show();
                }
                else{
                    userPass_update();
                }
            }
        });


        new BackgroundTask_userList().execute();

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

            try {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null) {
                    stringBuilder.append((temp + "\n"));
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (Exception e) {
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

            try {

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                String userID, userPassword, userName, userSex, userRoom;

                while (count < jsonArray.length()) {

                    JSONObject object = jsonArray.getJSONObject(count);
                    userID = object.getString("userID");
                    userPassword = object.getString("userPassword");
                    userName = object.getString("userName");
                    userSex = object.getString("userSex");
                    userRoom = object.getString("userRoom");

                    if (userID.equals(LoginUserID)) {

                        User user = new User(userID, userPassword, userName, userSex, userRoom);
                        userList.add(user);
                    }


                    count++;

                }

            } catch (Exception e) {

                e.getStackTrace();

            }
            if (userList.size() != 0) {
                userId.setText(userList.get(0).getUserID());
                userNick.setText(userList.get(0).getUserName());

            } else {

            }


        }
    }

    public void userNick_update(){

        // --------------------유저 DB 등록 시작--------------------
        String userID = userId.getText().toString();
        String userName = edit_userNick.getText().toString();



        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSucces customDialog = new CustomDialogSucces(setting.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();
                        new BackgroundTask_userList().execute();


                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(setting.this);
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

        UserNickUpdateRequest registerRequest = new UserNickUpdateRequest(userID, userName, responseListener);
        RequestQueue queue = Volley.newRequestQueue(setting.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------


    }

    public void userPass_update(){

        // --------------------유저 DB 등록 시작--------------------
        String userID = userId.getText().toString();
        String userPassword = edit_pass.getText().toString();



        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSucces customDialog = new CustomDialogSucces(setting.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();


                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(setting.this);
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

        UserPassUpdateRequest registerRequest = new UserPassUpdateRequest(userID, userPassword, responseListener);
        RequestQueue queue = Volley.newRequestQueue(setting.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------


    }

}
