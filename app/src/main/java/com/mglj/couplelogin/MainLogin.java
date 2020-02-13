package com.mglj.couplelogin;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mglj.couplelogin.SerchActivity.LoginUserID;


public class MainLogin extends AppCompatActivity {

    String roomNum2;
    private List<Room> roomArrayList;
    TextView text_Login, getFile, text_Couple, text_couple_id;
    Button question_send, question_file, question_list, couple_tele;
    public static String CoupleID="";
    ImageView main_img2, center_img;
    AdView adBanner;

    List<User> userList;
    List<User> ColpleList;
    Handler handler;
    TextView text_day;
    String start_day, end_day, d_day;
    String strFormat = "yyyyMMdd";

    int mainCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        mainCount = 0;
//        adMob();
//        애드몹
        MobileAds.initialize(this,"ca-app-pub-5784293657699097~5852338508");

        adBanner = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adBanner.loadAd(adRequest);


        Intent intent = getIntent();
        roomNum2 = intent.getStringExtra("roomNum");
        text_Login = (TextView)findViewById(R.id.text_Login);
        getFile = (TextView)findViewById(R.id.getFile);
        question_send = (Button)findViewById(R.id.question_send);
        question_file = (Button)findViewById(R.id.question_file);
        question_list = (Button)findViewById(R.id.question_list);
        couple_tele = (Button)findViewById(R.id.couple_tele);
        main_img2 = (ImageView)findViewById(R.id.main_img2);
        text_couple_id = (TextView)findViewById(R.id.text_couple_id);

        center_img = (ImageView)findViewById(R.id.center_img);
        text_day = (TextView)findViewById(R.id.text_day);
        text_Couple = (TextView)findViewById(R.id.text_Couple);

        Glide.with(this).load(R.drawable.main_img).fitCenter().into(main_img2);


        Glide.with(this).load(R.drawable.heart).fitCenter().into(center_img);

        //받은 내용 확인하기
        getFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(),GetContent.class);
                startActivity(intent1);

            }
        });

        //문답 보내기
        question_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(),Question_you.class);
                startActivity(intent1);

            }
        });

        //자가 문답
        question_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Question_self.class);
                startActivity(intent);

            }
        });

        //버킷리스트
        question_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Question_bucket.class);
                startActivity(intent);

            }
        });

        //이구동성
        couple_tele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(getApplicationContext(),CoupleGame.class);
                startActivity(intent1);

            }
        });

        new BackgroundTask_roomList().execute();

        handler = new Handler() {

            @Override

            public void handleMessage(Message msg) {

                if(mainCount<=3) {

                    int status = NetworkStatus.getConnectivityStatus(getApplicationContext());
                    if (status == NetworkStatus.TYPE_MOBILE) {
                        new BackgroundTask_userList().execute();
                    } else if (status == NetworkStatus.TYPE_WIFI) {
                        new BackgroundTask_userList().execute();
                    } else {
                        Toast.makeText(getApplicationContext(), "인터넷연결안됨", Toast.LENGTH_SHORT).show();
                    }

//                    Toast.makeText(getApplicationContext(),"count : " + mainCount, Toast.LENGTH_SHORT).show();
                }

            }

        };

        new BackgroundTask_roomList_Day().execute();

        Thread myThread = new Thread(new Runnable() {

            public void run() {

                while (true) {

                    try {
                        Thread.sleep(1000);
                        mainCount++;
                        handler.sendMessage(handler.obtainMessage());


                    } catch (Throwable t) {

                    }

                }

            }

        });
        myThread.start();




        //D_day설정
        text_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DatePickerDialog dialog = new DatePickerDialog(MainLogin.this, listener, 2020, 01, 11);
                dialog.show();

//                Date today = new Date();
//                SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
//                String date1 = date.format(today);
//                text_day.setText(date1);

            }
        });




    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

        @Override

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            String month = null;
            if(monthOfYear==1){
                month="02";
            }
            else if(monthOfYear==2){
                month="03";
            }
            else if(monthOfYear==3){
                month="04";
            }
            else if(monthOfYear==4){
                month="05";
            }
            else if(monthOfYear==5){
                month="06";
            }
            else if(monthOfYear==6){
                month="07";
            }
            else if(monthOfYear==7){
                month="08";
            }
            else if(monthOfYear==8){
                month="09";
            }
            else if(monthOfYear==9){
                month="10";
            }
            else if(monthOfYear==10){
                month="11";
            }
            else if(monthOfYear==11){
                month="12";
            }
            else if(monthOfYear==0){
                month="01";
            }

            start_day = String.valueOf(year)+month+dayOfMonth;


            day_update();






        }

    };

    public void day_update(){

        // --------------------유저 DB 등록 시작--------------------
        int roomNum3 = Integer.parseInt(roomNum2);
        String roomDay = start_day;

        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
//                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
//                        CustomDialogSucces customDialog = new CustomDialogSucces(MainLogin.this);
//
//                        // 커스텀 다이얼로그를 호출한다.
//                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
//                        customDialog.callFunction();
                        new BackgroundTask_roomList_Day().execute();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainLogin.this);
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

        RoomDayUpdateRequest registerRequest = new RoomDayUpdateRequest(roomNum3, roomDay, responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainLogin.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------


    }


    // 그래프 보기 시작(펫)
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

                    if(roomNum.equals(roomNum2)) {
                        Room room = new Room(roomNum, roomName, roomPass, room_makeID, room_intoID, roomDate,roomDay);
                        roomArrayList.add(room);
                    }

                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }
            if(roomArrayList.size()>=1) {

                getFile.setText(roomArrayList.get(0).getRoom_makeID()+"\n(내정보)");
                text_couple_id.setText(roomArrayList.get(0).getRoom_intoID());

                if(roomArrayList.get(0).getRoom_makeID().equals(LoginUserID)){
                    CoupleID = roomArrayList.get(0).getRoom_intoID();

                }
                else{
                    CoupleID = roomArrayList.get(0).getRoom_makeID();

                }

            }

        }

    }


    // 그래프 보기 시작(펫)
    class BackgroundTask_roomList_Day extends AsyncTask<Void, Void, String> {

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

                    if(roomNum.equals(roomNum2)) {
                        Room room = new Room(roomNum, roomName, roomPass, room_makeID, room_intoID, roomDate,roomDay);
                        roomArrayList.add(room);
                    }

                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }
            if(roomArrayList.size()>=1) {

                Date today = new Date();
                SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
                end_day = date.format(today);
                try {
                    if(!roomArrayList.get(0).getRoomDay().equals(null)) {

                        String Cal_day = roomArrayList.get(0).getRoomDay();

                        Date startDate = date.parse(Cal_day);
                        Date endDate = date.parse(end_day);

                        long diff = endDate.getTime() - startDate.getTime();

                        long diffDay = diff / (24*60*60*1000);

                        text_day.setText("Day : "+diffDay+"일");
                    }




                }catch(ParseException e){
                    e.printStackTrace();
                }

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

                getFile.setText(userList.get(0).getUserName()+"\n(내정보)");
                text_couple_id.setText(ColpleList.get(0).getUserName());

            }
            else{
                getFile.setText(userList.get(0).getUserName());
            }




        }

    }

    private void adMob(){
        MobileAds.initialize(this, getString(R.string.ad_unit_id));
        AdView mAdView = findViewById(R.id.adView);
        Bundle extras = new Bundle();
        extras.putString("max_ad_content_rating", "G"); // 앱이 3세 이상 사용가능이라면 광고레벨을 설정해줘야 한다
        AdRequest adRequest = new AdRequest.Builder()
                .addNetworkExtrasBundle(AdMobAdapter.class, extras)
                .build();
        mAdView.loadAd(adRequest);
    }

}
