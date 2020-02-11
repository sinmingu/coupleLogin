package com.mglj.couplelogin;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);


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

                int status = NetworkStatus.getConnectivityStatus(getApplicationContext());
                if(status == NetworkStatus.TYPE_MOBILE){
                    new BackgroundTask_userList().execute();
                }else if (status == NetworkStatus.TYPE_WIFI){
                    new BackgroundTask_userList().execute();
                }else {
                    Toast.makeText(getApplicationContext(),"인터넷연결안됨",Toast.LENGTH_SHORT).show();
                }

            }

        };

        Thread myThread = new Thread(new Runnable() {

            public void run() {

                while (true) {

                    try {
                        Thread.sleep(1000);
                        handler.sendMessage(handler.obtainMessage());


                    } catch (Throwable t) {

                    }

                }

            }

        });


        myThread.start();






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
                String roomNum, roomName, roomPass, room_makeID,room_intoID,roomDate;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    roomNum = object.getString("roomNum");
                    roomName = object.getString("roomName");
                    roomPass = object.getString("roomPass");
                    room_makeID = object.getString("room_makeID");
                    room_intoID = object.getString("room_intoID");
                    roomDate = object.getString("roomDate");

                    if(roomNum.equals(roomNum2)) {
                        Room room = new Room(roomNum, roomName, roomPass, room_makeID, room_intoID, roomDate);
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
