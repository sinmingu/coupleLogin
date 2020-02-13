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

import static com.mglj.couplelogin.SerchActivity.LoginUserID;


public class detail_room extends AppCompatActivity {

    String name;
    String userID;
    String number;
    String date;
    String pass;
    TextView room_name, room_id, room_date;
    Button btn_into, btn_login;
    private List<Room> roomArrayList;
    private List<Room> roomArrayList2;
    String LoginID;
    ImageView de_no_can, de_no_cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_room);

        final Intent intent = getIntent();
        name = intent.getStringExtra("name");
        userID = intent.getStringExtra("userID");
        number = intent.getStringExtra("number");
        date = intent.getStringExtra("date");
        pass = intent.getStringExtra("pass");

        room_name = (TextView)findViewById(R.id.room_name);
        room_id = (TextView)findViewById(R.id.room_id);
        room_date = (TextView)findViewById(R.id.room_date);
        btn_into = (Button)findViewById(R.id.btn_into);
        btn_login = (Button)findViewById(R.id.btn_login);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);

        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        LoginID = LoginUserID;

        room_name.setText(name);
        room_id.setText(userID);
        room_date.setText(date);
        new BackgroundTask_roomList().execute();

        btn_into.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new BackgroundTask_roomList_2().execute();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(),MainLogin.class);
                intent1.putExtra("roomNum",roomArrayList.get(0).getRoomNum());
                startActivity(intent1);

            }
        });



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
                String roomNum, roomName, roomPass, room_makeID,room_intoID,roomDate,roomDay;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    roomNum = object.getString("roomNum");
                    roomName = object.getString("roomName");
                    roomPass = object.getString("roomPass");
                    room_makeID = object.getString("room_makeID");
                    room_intoID = object.getString("room_intoID");
                    roomDate = object.getString("roomDate");
                    roomDay = object.getString("roomDay");
                    if(roomNum.equals(number)) {
                        Room room = new Room(roomNum, roomName, roomPass, room_makeID, room_intoID, roomDate,roomDay);
                        roomArrayList.add(room);
                    }



                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(roomArrayList.get(0).getRoom_intoID().equals(LoginID)||roomArrayList.get(0).getRoom_makeID().equals(LoginID)){
                btn_into.setVisibility(View.GONE);
            }
            else{

                btn_login.setVisibility(View.GONE);
            }

//            if(roomArrayList.size()==0){
//                btn_login.setVisibility(View.GONE);
//            }
//            else{
//                btn_into.setVisibility(View.GONE);
//            }


        }

    }

    // 채팅방
    class BackgroundTask_roomList_2 extends AsyncTask<Void, Void, String> {

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
            roomArrayList2 = new ArrayList<Room>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String roomNum, roomName, roomPass, room_makeID,room_intoID,roomDate,roomDay;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    roomNum = object.getString("roomNum");
                    roomName = object.getString("roomName");
                    roomPass = object.getString("roomPass");
                    room_makeID = object.getString("room_makeID");
                    room_intoID = object.getString("room_intoID");
                    roomDate = object.getString("roomDate");
                    roomDay = object.getString("roomDay");


                    if(number.equals(roomNum)) {
                        Room room = new Room(roomNum, roomName, roomPass, room_makeID, room_intoID, roomDate,roomDay);
                        roomArrayList.add(room);
                    }
                    Room room2 = new Room(roomNum, roomName, roomPass, room_makeID, room_intoID, roomDate,roomDay);
                    roomArrayList2.add(room2);




                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            for(int i = 0; i<roomArrayList2.size();i++){

                if(roomArrayList2.get(i).getRoom_makeID().equals(LoginUserID)||roomArrayList2.get(i).getRoom_intoID().equals(LoginUserID)){
                    Toast.makeText(getApplicationContext(),"들어갈 수 있는 커플방은 최대1개입니다.",Toast.LENGTH_SHORT).show();
                    return;
                }

            }

            if(roomArrayList.get(0).getRoom_intoID().equals("null")){
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialogInto customDialog = new CustomDialogInto(detail_room.this);

                // 커스텀 다이얼로그를 호출한다.
                // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                customDialog.callFunction(userID, pass, Integer.parseInt(number), LoginID);

            }
            else{
                Toast.makeText(getApplicationContext(),"이미 꽉찬 방입니다.",Toast.LENGTH_SHORT).show();
            }

        }

    }

}
