package com.mglj.couplelogin;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

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

public class SerchActivity extends AppCompatActivity {

    ImageView btn_room, de_no_cancle, de_no_can;
    EditText search_room;

    ListView room_List;
    private RoomListAdapter adapter;
    private List<Room> roomArrayList;
    public static String LoginUserID="";
    String userPassword;
    String userName;
    String userSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serch);

        Intent intent =getIntent();
        LoginUserID = intent.getStringExtra("userID");
        userPassword = intent.getStringExtra("userPassword");
        userName = intent.getStringExtra("userName");
        userSex = intent.getStringExtra("userSex");

        room_List = (ListView)findViewById(R.id.room_List);
        btn_room = (ImageView)findViewById(R.id.btn_room);
        search_room = (EditText)findViewById(R.id.search_room);
        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);

        Glide.with(this).load(R.drawable.check_1).fitCenter().into(btn_room);
        Glide.with(this).load(R.drawable.cancel_1).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.plus_1).fitCenter().into(de_no_can);


        roomArrayList = new ArrayList<Room>();
        adapter = new RoomListAdapter(getApplicationContext(), roomArrayList);
        room_List.setAdapter(adapter);

        de_no_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        btn_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new BackgroundTask_roomList().execute();

            }
        });

        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BackgroundTask_roomList2().execute();
            }
        });

////        room_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////
////                Intent intent1 = new Intent(SerchActivity.this,detail_room.class);
////                intent1.putExtra("name",roomArrayList.get(i).getRoomName());
////                intent1.putExtra("userID", roomArrayList.get(i).getRoom_makeID());
////                intent1.putExtra("number", roomArrayList.get(i).getRoomNum());
////                intent1.putExtra("date",roomArrayList.get(i).getRoomDate());
////                intent1.putExtra("pass",roomArrayList.get(i).getRoomPass());
////                startActivity(intent1);
////
////            }
////        });

        new BackgroundTask_roomList3().execute();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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

                    if(search_room.getText().toString().equals(roomName)) {
                        Room room = new Room(roomNum, roomName, roomPass, room_makeID, room_intoID, roomDate);
                        roomArrayList.add(room);
                    }

                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            adapter = new RoomListAdapter(getApplicationContext(), roomArrayList);
            room_List.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }

    }


    // 채팅방
    class BackgroundTask_roomList2 extends AsyncTask<Void, Void, String> {

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

                    if(LoginUserID.equals(room_makeID)||LoginUserID.equals(room_intoID)) {
                        Room room = new Room(roomNum, roomName, roomPass, room_makeID, room_intoID, roomDate);
                        roomArrayList.add(room);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

           if(roomArrayList.size()>=1){
               Toast.makeText(getApplicationContext(),"이미 활성중인 방이 있습니다",Toast.LENGTH_SHORT).show();
           }
           else{
               // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
               CustomDialogRoom customDialog = new CustomDialogRoom(SerchActivity.this);

               // 커스텀 다이얼로그를 호출한다.
               // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
               customDialog.callFunction(LoginUserID);
           }

        }

    }


    // 채팅방
    class BackgroundTask_roomList3 extends AsyncTask<Void, Void, String> {

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

                    if(LoginUserID.equals(room_makeID)||LoginUserID.equals(room_intoID)) {
                        Room room = new Room(roomNum, roomName, roomPass, room_makeID, room_intoID, roomDate);
                        roomArrayList.add(room);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(roomArrayList.size()>=1){
                SharedPreferences prefs =getSharedPreferences("LoginUser", MODE_PRIVATE);
                if((prefs.getString("auto", "0").equals("yes"))){

                    SharedPreferences sharedPreferences = getSharedPreferences("LoginUser",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("roomNum",roomArrayList.get(0).getRoomNum());
                    editor.commit();
                }



                Intent intent = new Intent(getApplicationContext(),MainLogin.class);
                intent.putExtra("roomNum",roomArrayList.get(0).getRoomNum());
                startActivity(intent);
            }



        }

    }

}
