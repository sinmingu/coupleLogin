package com.mglj.couplelogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

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
import java.util.Locale;
import java.util.Random;

import static com.mglj.couplelogin.MainLogin.CoupleID;
import static com.mglj.couplelogin.SerchActivity.LoginUserID;

public class CoupleGameStart extends AppCompatActivity implements RewardedVideoAdListener{

    TextView left_answer1, right_answer1, left_answer2, left_answer3, right_answer2, right_answer3, left_answer4, left_answer5, left_answer6, left_answer7,
            left_answer8, left_answer9, left_answer10, left_answer11, left_answer12, left_answer13, left_answer14, left_answer15, left_answer16, left_answer17,
            left_answer18, left_answer19, left_answer20, right_answer4, right_answer5, right_answer6, right_answer7, right_answer8, right_answer9, right_answer10,
            right_answer11, right_answer12,right_answer13, right_answer14, right_answer15, right_answer16, right_answer17, right_answer18, right_answer19, right_answer20;
    TextView this_page, text_timer, btn_regame;
    LinearLayout Linear_page1, Linear_page2, Linear_page3, Linear_page4, Linear_page5, Linear_page6, Linear_page7, Linear_page8, Linear_page9,
            Linear_page10, Linear_page11, Linear_page12, Linear_page13, Linear_page14, Linear_page15, Linear_page16, Linear_page17, Linear_page18,Linear_page19, Linear_page20;
    TextView btn_send;

    ImageView left_img1, left_img2, left_img3, left_img4, left_img5, left_img6, left_img7, left_img8, left_img9, left_img10, left_img11, left_img12,left_img13,
    left_img14,left_img15,left_img16,left_img17,left_img18,left_img19,left_img20;
    ImageView right_img1, right_img2, right_img3, right_img4, right_img5, right_img6,right_img7, right_img8, right_img9, right_img10, right_img11, right_img12, right_img13,
            right_img14, right_img15, right_img16, right_img17, right_img18, right_img19, right_img20;

    String question_01_left[]  = {"산","부먹","강아지","버스","비빔냉면","여름","치킨","짜장","낮","해외여행","소고기","갤럭시","집","시골","사랑","아이스커피","삼겹살","문자","소주","콜라"};
    String question_01_right[] = {"바다","찍먹","고양이","지하철","물냉면","겨울","피자","짬뽕","밤","국내여행","돼지고기","아이폰","밖","도시","우정","따뜻한커피","돼지갈비","전화","맥주", "사이다"};

    String question_02_left[]  = {"김치찌개","눈오는날씨","초코","후라이드치킨","엄마","밝은색","만화책","여름","과일","아이스크림","물","사랑","근육몸매","족발","무관심","매운맛","국어시간","비빔밥","시크한성격","귀여움"};
    String question_02_right[] = {"된장찌개","비오는날씨","딸기","양념치킨","아빠","어두운색","소설책","겨울","고기","과자","음료수","우정","슬림몸매","보쌈","집착","순한맛","수학시간","볶음밥","밝은성격", "성숙함"};

    String question_03_left[]  = {"나이키","긴머리","아들","밖으로가자","발라드음악","돈","파란색","사과","봄","버스안쪽자리","한식","맑은날","돈","미래여행","마른몸매","비행기","양념게장","롯데월드","삼겹살","라이언"};
    String question_03_right[] = {"아디다스","짧은머리","딸","밖은위험해","댄스음악","사랑","빨간색","배","가을","버스복도자리","양식","비or눈오는날","명예","과거여행","통통한몸매","여객선","간장게장","에버랜드","갈비", "뽀로로"};

    String question_04_right[] = {"회전목마","행동력있는사람","닭볶음탕","뼈있는닭발","밤잠","절친","섹시함","우주탐험","영화","야구","콜라","비or눈오는날","딜러","무선","노트북","한식","중식","문자","소주", "3D"};
    String question_04_left[]  = {"롤러코스터","신중한사람","찜닭","무뼈닭발","낮잠","연인","청순함","해저탐험","드라마","축구","사이다","맑은날","힐러","유선","데스크탑","양식","일식","전화","맥주","2D"};

    String question_05_right[] = {"긴머리","발라드음악","눈오는날씨","소설책","체육시간","침대","여름","매운맛","치킨","밝은색","일식","피씨방","아파트","과거여행","통통한몸매","아이스커피","해외여행","에버랜드","비빔냉면", "군만두"};
    String question_05_left[]  = {"짧은머리","댄스음악","비오는날씨","만화책","미술시간","바닥","겨울","순한맛","햄버거","어두운색","중식","노래방","단독주택","미래여행","마른몸매","따뜻한커피","국내여행","롯데월드","물냉명","물만두"};

    String arr_answer[] = new String[20];

    private RewardedVideoAd mRewardedVideoAd;

    InterstitialAd adfull;
    ProgressBar h_progressbar;
    Random rnd = new Random();
    int couple_code=0;

    ImageView de_no_cancle, de_no_can;
    int page = 1;
    int game_num=0;
    List<GAME> gameList;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couple_game_start);

        Intent coupleIntent = getIntent();
        couple_code = Integer.parseInt(coupleIntent.getStringExtra("gameCode"));
        adfull = new InterstitialAd(this);
        adfull.setAdUnitId("ca-app-pub-5784293657699097/5193862959");
        adfull.loadAd(new AdRequest.Builder().build());
        this_page = (TextView)findViewById(R.id.this_page);
        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        h_progressbar =(ProgressBar)findViewById(R.id.h_progressbar);
        text_timer = (TextView)findViewById(R.id.text_timer);
        btn_regame = (TextView)findViewById(R.id.btn_regame);



        timer();

        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {

            }

            @Override
            public void onRewardedVideoAdOpened() {
            }

            @Override
            public void onRewardedVideoStarted() {
            }

            @Override
            public void onRewardedVideoAdClosed() {

            }

            @Override
            public void onRewarded(RewardItem rewardItem) {

            }

            @Override
            public void onRewardedVideoAdLeftApplication() {
            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {

            }

            @Override
            public void onRewardedVideoCompleted() {

            }
        });

        loadRewardedVideoAd();



        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);

        left_img1 = (ImageView)findViewById(R.id.left_img1);
        left_img2 = (ImageView)findViewById(R.id.left_img2);
        left_img3 = (ImageView)findViewById(R.id.left_img3);
        left_img4 = (ImageView)findViewById(R.id.left_img4);
        left_img5 = (ImageView)findViewById(R.id.left_img5);
        left_img6 = (ImageView)findViewById(R.id.left_img6);
        left_img7 = (ImageView)findViewById(R.id.left_img7);
        left_img8 = (ImageView)findViewById(R.id.left_img8);
        left_img9 = (ImageView)findViewById(R.id.left_img9);
        left_img10 = (ImageView)findViewById(R.id.left_img10);
        left_img11 = (ImageView)findViewById(R.id.left_img11);
        left_img12 = (ImageView)findViewById(R.id.left_img12);
        left_img13 = (ImageView)findViewById(R.id.left_img13);
        left_img14 = (ImageView)findViewById(R.id.left_img14);
        left_img15 = (ImageView)findViewById(R.id.left_img15);
        left_img16 = (ImageView)findViewById(R.id.left_img16);
        left_img17 = (ImageView)findViewById(R.id.left_img17);
        left_img18 = (ImageView)findViewById(R.id.left_img18);
        left_img19 = (ImageView)findViewById(R.id.left_img19);
        left_img20 = (ImageView)findViewById(R.id.left_img20);
        right_img1 = (ImageView)findViewById(R.id.right_img1);
        right_img2 = (ImageView)findViewById(R.id.right_img2);
        right_img3 = (ImageView)findViewById(R.id.right_img3);
        right_img4 = (ImageView)findViewById(R.id.right_img4);
        right_img5 = (ImageView)findViewById(R.id.right_img5);
        right_img6 = (ImageView)findViewById(R.id.right_img6);
        right_img7 = (ImageView)findViewById(R.id.right_img7);
        right_img8 = (ImageView)findViewById(R.id.right_img8);
        right_img9 = (ImageView)findViewById(R.id.right_img9);
        right_img10 = (ImageView)findViewById(R.id.right_img10);
        right_img11 = (ImageView)findViewById(R.id.right_img11);
        right_img12 = (ImageView)findViewById(R.id.right_img12);
        right_img13 = (ImageView)findViewById(R.id.right_img13);
        right_img14 = (ImageView)findViewById(R.id.right_img14);
        right_img15 = (ImageView)findViewById(R.id.right_img15);
        right_img16 = (ImageView)findViewById(R.id.right_img16);
        right_img17 = (ImageView)findViewById(R.id.right_img17);
        right_img18 = (ImageView)findViewById(R.id.right_img18);
        right_img19 = (ImageView)findViewById(R.id.right_img19);
        right_img20 = (ImageView)findViewById(R.id.right_img20);


        left_answer1 = (TextView)findViewById(R.id.left_answer1);
        right_answer1 = (TextView)findViewById(R.id.right_answer1);
        left_answer2 = (TextView)findViewById(R.id.left_answer2);
        right_answer2 = (TextView)findViewById(R.id.right_answer2);
        left_answer3 = (TextView)findViewById(R.id.left_answer3);
        right_answer3 = (TextView)findViewById(R.id.right_answer3);
        left_answer4 = (TextView)findViewById(R.id.left_answer4);
        right_answer4 = (TextView)findViewById(R.id.right_answer4);
        left_answer5 = (TextView)findViewById(R.id.left_answer5);
        right_answer5 = (TextView)findViewById(R.id.right_answer5);
        left_answer6 = (TextView)findViewById(R.id.left_answer6);
        right_answer6 = (TextView)findViewById(R.id.right_answer6);
        left_answer7 = (TextView)findViewById(R.id.left_answer7);
        right_answer7 = (TextView)findViewById(R.id.right_answer7);
        left_answer8 = (TextView)findViewById(R.id.left_answer8);
        right_answer8 = (TextView)findViewById(R.id.right_answer8);
        left_answer9 = (TextView)findViewById(R.id.left_answer9);
        right_answer9 = (TextView)findViewById(R.id.right_answer9);
        left_answer10 = (TextView)findViewById(R.id.left_answer10);
        right_answer10 = (TextView)findViewById(R.id.right_answer10);
        left_answer11 = (TextView)findViewById(R.id.left_answer11);
        right_answer11 = (TextView)findViewById(R.id.right_answer11);
        left_answer12 = (TextView)findViewById(R.id.left_answer12);
        right_answer12= (TextView)findViewById(R.id.right_answer12);
        left_answer13 = (TextView)findViewById(R.id.left_answer13);
        right_answer13 = (TextView)findViewById(R.id.right_answer13);
        left_answer14 = (TextView)findViewById(R.id.left_answer14);
        right_answer14 = (TextView)findViewById(R.id.right_answer14);
        left_answer15 = (TextView)findViewById(R.id.left_answer15);
        right_answer15 = (TextView)findViewById(R.id.right_answer15);
        left_answer16 = (TextView)findViewById(R.id.left_answer16);
        right_answer16 = (TextView)findViewById(R.id.right_answer16);
        left_answer17 = (TextView)findViewById(R.id.left_answer17);
        right_answer17 = (TextView)findViewById(R.id.right_answer17);
        left_answer18 = (TextView)findViewById(R.id.left_answer18);
        right_answer18 = (TextView)findViewById(R.id.right_answer18);
        left_answer19 = (TextView)findViewById(R.id.left_answer19);
        right_answer19 = (TextView)findViewById(R.id.right_answer19);
        left_answer20 = (TextView)findViewById(R.id.left_answer20);
        right_answer20 = (TextView)findViewById(R.id.right_answer20);

        Linear_page1 = (LinearLayout)findViewById(R.id.Linear_page1);
        Linear_page2 = (LinearLayout)findViewById(R.id.Linear_page2);
        Linear_page3 = (LinearLayout)findViewById(R.id.Linear_page3);
        Linear_page4 = (LinearLayout)findViewById(R.id.Linear_page4);
        Linear_page5 = (LinearLayout)findViewById(R.id.Linear_page5);
        Linear_page6 = (LinearLayout)findViewById(R.id.Linear_page6);
        Linear_page7 = (LinearLayout)findViewById(R.id.Linear_page7);
        Linear_page8 = (LinearLayout)findViewById(R.id.Linear_page8);
        Linear_page9 = (LinearLayout)findViewById(R.id.Linear_page9);
        Linear_page10 = (LinearLayout)findViewById(R.id.Linear_page10);
        Linear_page11 = (LinearLayout)findViewById(R.id.Linear_page11);
        Linear_page12 = (LinearLayout)findViewById(R.id.Linear_page12);
        Linear_page13 = (LinearLayout)findViewById(R.id.Linear_page13);
        Linear_page14 = (LinearLayout)findViewById(R.id.Linear_page14);
        Linear_page15 = (LinearLayout)findViewById(R.id.Linear_page15);
        Linear_page16 = (LinearLayout)findViewById(R.id.Linear_page16);
        Linear_page17 = (LinearLayout)findViewById(R.id.Linear_page17);
        Linear_page18 = (LinearLayout)findViewById(R.id.Linear_page18);
        Linear_page19 = (LinearLayout)findViewById(R.id.Linear_page19);
        Linear_page20 = (LinearLayout)findViewById(R.id.Linear_page20);

        if(couple_code==0){
            game_num = rnd.nextInt(5)+1;
        }
        else game_num =couple_code;

        if(game_num==1){
            left_answer1.setText(question_01_left[0]);
            left_answer2.setText(question_01_left[1]);
            left_answer3.setText(question_01_left[2]);
            left_answer4.setText(question_01_left[3]);
            left_answer5.setText(question_01_left[4]);
            left_answer6.setText(question_01_left[5]);
            left_answer7.setText(question_01_left[6]);
            left_answer8.setText(question_01_left[7]);
            left_answer9.setText(question_01_left[8]);
            left_answer10.setText(question_01_left[9]);
            left_answer11.setText(question_01_left[10]);
            left_answer12.setText(question_01_left[11]);
            left_answer13.setText(question_01_left[12]);
            left_answer14.setText(question_01_left[13]);
            left_answer15.setText(question_01_left[14]);
            left_answer16.setText(question_01_left[15]);
            left_answer17.setText(question_01_left[16]);
            left_answer18.setText(question_01_left[17]);
            left_answer19.setText(question_01_left[18]);
            left_answer20.setText(question_01_left[19]);

            right_answer1.setText(question_01_right[0]);
            right_answer2.setText(question_01_right[1]);
            right_answer3.setText(question_01_right[2]);
            right_answer4.setText(question_01_right[3]);
            right_answer5.setText(question_01_right[4]);
            right_answer6.setText(question_01_right[5]);
            right_answer7.setText(question_01_right[6]);
            right_answer8.setText(question_01_right[7]);
            right_answer9.setText(question_01_right[8]);
            right_answer10.setText(question_01_right[9]);
            right_answer11.setText(question_01_right[10]);
            right_answer12.setText(question_01_right[11]);
            right_answer13.setText(question_01_right[12]);
            right_answer14.setText(question_01_right[13]);
            right_answer15.setText(question_01_right[14]);
            right_answer16.setText(question_01_right[15]);
            right_answer17.setText(question_01_right[16]);
            right_answer18.setText(question_01_right[17]);
            right_answer19.setText(question_01_right[18]);
            right_answer20.setText(question_01_right[19]);

            Glide.with(this).load(R.drawable.mountains).fitCenter().into(left_img1);
            Glide.with(this).load(R.drawable.lunch).fitCenter().into(left_img2);
            Glide.with(this).load(R.drawable.puppy9).fitCenter().into(left_img3);
            Glide.with(this).load(R.drawable.bus).fitCenter().into(left_img4);
            Glide.with(this).load(R.drawable.noodles2).fitCenter().into(left_img5);
            Glide.with(this).load(R.drawable.summer).fitCenter().into(left_img6);
            Glide.with(this).load(R.drawable.chicken).fitCenter().into(left_img7);
            Glide.with(this).load(R.drawable.jjajang).fitCenter().into(left_img8);
            Glide.with(this).load(R.drawable.sun).fitCenter().into(left_img9);
            Glide.with(this).load(R.drawable.globe).fitCenter().into(left_img10);
            Glide.with(this).load(R.drawable.beef).fitCenter().into(left_img11);
            Glide.with(this).load(R.drawable.samsung).fitCenter().into(left_img12);
            Glide.with(this).load(R.drawable.home).fitCenter().into(left_img13);
            Glide.with(this).load(R.drawable.notown).fitCenter().into(left_img14);
            Glide.with(this).load(R.drawable.heart).fitCenter().into(left_img15);
            Glide.with(this).load(R.drawable.ice_coffee).fitCenter().into(left_img16);
            Glide.with(this).load(R.drawable.beef).fitCenter().into(left_img17);
            Glide.with(this).load(R.drawable.sms).fitCenter().into(left_img18);
            Glide.with(this).load(R.drawable.soju).fitCenter().into(left_img19);
            Glide.with(this).load(R.drawable.coke).fitCenter().into(left_img20);

            Glide.with(this).load(R.drawable.sea).fitCenter().into(right_img1);
            Glide.with(this).load(R.drawable.lunch2).fitCenter().into(right_img2);
            Glide.with(this).load(R.drawable.cat).fitCenter().into(right_img3);
            Glide.with(this).load(R.drawable.subway).fitCenter().into(right_img4);
            Glide.with(this).load(R.drawable.noodle).fitCenter().into(right_img5);
            Glide.with(this).load(R.drawable.winter).fitCenter().into(right_img6);
            Glide.with(this).load(R.drawable.pizza).fitCenter().into(right_img7);
            Glide.with(this).load(R.drawable.jjamppong).fitCenter().into(right_img8);
            Glide.with(this).load(R.drawable.moon).fitCenter().into(right_img9);
            Glide.with(this).load(R.drawable.train).fitCenter().into(right_img10);
            Glide.with(this).load(R.drawable.meat).fitCenter().into(right_img11);
            Glide.with(this).load(R.drawable.smartphone).fitCenter().into(right_img12);
            Glide.with(this).load(R.drawable.park).fitCenter().into(right_img13);
            Glide.with(this).load(R.drawable.town).fitCenter().into(right_img14);
            Glide.with(this).load(R.drawable.conversation).fitCenter().into(right_img15);
            Glide.with(this).load(R.drawable.hot_coffee).fitCenter().into(right_img16);
            Glide.with(this).load(R.drawable.meat).fitCenter().into(right_img17);
            Glide.with(this).load(R.drawable.call).fitCenter().into(right_img18);
            Glide.with(this).load(R.drawable.beer).fitCenter().into(right_img19);
            Glide.with(this).load(R.drawable.soda).fitCenter().into(right_img20);
        }
        else if(game_num ==2){
            left_answer1.setText(question_02_left[0]);
            left_answer2.setText(question_02_left[1]);
            left_answer3.setText(question_02_left[2]);
            left_answer4.setText(question_02_left[3]);
            left_answer5.setText(question_02_left[4]);
            left_answer6.setText(question_02_left[5]);
            left_answer7.setText(question_02_left[6]);
            left_answer8.setText(question_02_left[7]);
            left_answer9.setText(question_02_left[8]);
            left_answer10.setText(question_02_left[9]);
            left_answer11.setText(question_02_left[10]);
            left_answer12.setText(question_02_left[11]);
            left_answer13.setText(question_02_left[12]);
            left_answer14.setText(question_02_left[13]);
            left_answer15.setText(question_02_left[14]);
            left_answer16.setText(question_02_left[15]);
            left_answer17.setText(question_02_left[16]);
            left_answer18.setText(question_02_left[17]);
            left_answer19.setText(question_02_left[18]);
            left_answer20.setText(question_02_left[19]);

            right_answer1.setText(question_02_right[0]);
            right_answer2.setText(question_02_right[1]);
            right_answer3.setText(question_02_right[2]);
            right_answer4.setText(question_02_right[3]);
            right_answer5.setText(question_02_right[4]);
            right_answer6.setText(question_02_right[5]);
            right_answer7.setText(question_02_right[6]);
            right_answer8.setText(question_02_right[7]);
            right_answer9.setText(question_02_right[8]);
            right_answer10.setText(question_02_right[9]);
            right_answer11.setText(question_02_right[10]);
            right_answer12.setText(question_02_right[11]);
            right_answer13.setText(question_02_right[12]);
            right_answer14.setText(question_02_right[13]);
            right_answer15.setText(question_02_right[14]);
            right_answer16.setText(question_02_right[15]);
            right_answer17.setText(question_02_right[16]);
            right_answer18.setText(question_02_right[17]);
            right_answer19.setText(question_02_right[18]);
            right_answer20.setText(question_02_right[19]);

            Glide.with(this).load(R.drawable.soup).fitCenter().into(left_img1);
            Glide.with(this).load(R.drawable.snow).fitCenter().into(left_img2);
            Glide.with(this).load(R.drawable.chocolate).fitCenter().into(left_img3);
            Glide.with(this).load(R.drawable.chicken).fitCenter().into(left_img4);
            Glide.with(this).load(R.drawable.mother).fitCenter().into(left_img5);
            Glide.with(this).load(R.drawable.color2).fitCenter().into(left_img6);
            Glide.with(this).load(R.drawable.book2).fitCenter().into(left_img7);
            Glide.with(this).load(R.drawable.sun).fitCenter().into(left_img8);
            Glide.with(this).load(R.drawable.fruit).fitCenter().into(left_img9);
            Glide.with(this).load(R.drawable.icecream).fitCenter().into(left_img10);
            Glide.with(this).load(R.drawable.water).fitCenter().into(left_img11);
            Glide.with(this).load(R.drawable.heart).fitCenter().into(left_img12);
            Glide.with(this).load(R.drawable.strong).fitCenter().into(left_img13);
            Glide.with(this).load(R.drawable.meat).fitCenter().into(left_img14);
            Glide.with(this).load(R.drawable.novoice).fitCenter().into(left_img15);
            Glide.with(this).load(R.drawable.spicy).fitCenter().into(left_img16);
            Glide.with(this).load(R.drawable.abc).fitCenter().into(left_img17);
            Glide.with(this).load(R.drawable.curry).fitCenter().into(left_img18);
            Glide.with(this).load(R.drawable.face2).fitCenter().into(left_img19);
            Glide.with(this).load(R.drawable.cute2).fitCenter().into(left_img20);

            Glide.with(this).load(R.drawable.soup2).fitCenter().into(right_img1);
            Glide.with(this).load(R.drawable.rain).fitCenter().into(right_img2);
            Glide.with(this).load(R.drawable.jam).fitCenter().into(right_img3);
            Glide.with(this).load(R.drawable.chicken2).fitCenter().into(right_img4);
            Glide.with(this).load(R.drawable.father).fitCenter().into(right_img5);
            Glide.with(this).load(R.drawable.color).fitCenter().into(right_img6);
            Glide.with(this).load(R.drawable.book).fitCenter().into(right_img7);
            Glide.with(this).load(R.drawable.winter).fitCenter().into(right_img8);
            Glide.with(this).load(R.drawable.meat).fitCenter().into(right_img9);
            Glide.with(this).load(R.drawable.snack).fitCenter().into(right_img10);
            Glide.with(this).load(R.drawable.coke).fitCenter().into(right_img11);
            Glide.with(this).load(R.drawable.conversation).fitCenter().into(right_img12);
            Glide.with(this).load(R.drawable.muscle).fitCenter().into(right_img13);
            Glide.with(this).load(R.drawable.beef).fitCenter().into(right_img14);
            Glide.with(this).load(R.drawable.voice).fitCenter().into(right_img15);
            Glide.with(this).load(R.drawable.jam).fitCenter().into(right_img16);
            Glide.with(this).load(R.drawable.math).fitCenter().into(right_img17);
            Glide.with(this).load(R.drawable.rice).fitCenter().into(right_img18);
            Glide.with(this).load(R.drawable.face).fitCenter().into(right_img19);
            Glide.with(this).load(R.drawable.cute).fitCenter().into(right_img20);

        }
        else if(game_num==3){
            left_answer1.setText(question_03_left[0]);
            left_answer2.setText(question_03_left[1]);
            left_answer3.setText(question_03_left[2]);
            left_answer4.setText(question_03_left[3]);
            left_answer5.setText(question_03_left[4]);
            left_answer6.setText(question_03_left[5]);
            left_answer7.setText(question_03_left[6]);
            left_answer8.setText(question_03_left[7]);
            left_answer9.setText(question_03_left[8]);
            left_answer10.setText(question_03_left[9]);
            left_answer11.setText(question_03_left[10]);
            left_answer12.setText(question_03_left[11]);
            left_answer13.setText(question_03_left[12]);
            left_answer14.setText(question_03_left[13]);
            left_answer15.setText(question_03_left[14]);
            left_answer16.setText(question_03_left[15]);
            left_answer17.setText(question_03_left[16]);
            left_answer18.setText(question_03_left[17]);
            left_answer19.setText(question_03_left[18]);
            left_answer20.setText(question_03_left[19]);

            right_answer1.setText(question_03_right[0]);
            right_answer2.setText(question_03_right[1]);
            right_answer3.setText(question_03_right[2]);
            right_answer4.setText(question_03_right[3]);
            right_answer5.setText(question_03_right[4]);
            right_answer6.setText(question_03_right[5]);
            right_answer7.setText(question_03_right[6]);
            right_answer8.setText(question_03_right[7]);
            right_answer9.setText(question_03_right[8]);
            right_answer10.setText(question_03_right[9]);
            right_answer11.setText(question_03_right[10]);
            right_answer12.setText(question_03_right[11]);
            right_answer13.setText(question_03_right[12]);
            right_answer14.setText(question_03_right[13]);
            right_answer15.setText(question_03_right[14]);
            right_answer16.setText(question_03_right[15]);
            right_answer17.setText(question_03_right[16]);
            right_answer18.setText(question_03_right[17]);
            right_answer19.setText(question_03_right[18]);
            right_answer20.setText(question_03_right[19]);
            Glide.with(this).load(R.drawable.shose).fitCenter().into(left_img1);
            Glide.with(this).load(R.drawable.woman).fitCenter().into(left_img2);
            Glide.with(this).load(R.drawable.son).fitCenter().into(left_img3);
            Glide.with(this).load(R.drawable.park).fitCenter().into(left_img4);
            Glide.with(this).load(R.drawable.headphones).fitCenter().into(left_img5);
            Glide.with(this).load(R.drawable.money).fitCenter().into(left_img6);
            Glide.with(this).load(R.drawable.plus).fitCenter().into(left_img7);
            Glide.with(this).load(R.drawable.fruit).fitCenter().into(left_img8);
            Glide.with(this).load(R.drawable.spring).fitCenter().into(left_img9);
            Glide.with(this).load(R.drawable.seat).fitCenter().into(left_img10);
            Glide.with(this).load(R.drawable.rice).fitCenter().into(left_img11);
            Glide.with(this).load(R.drawable.sun).fitCenter().into(left_img12);
            Glide.with(this).load(R.drawable.money).fitCenter().into(left_img13);
            Glide.with(this).load(R.drawable.time).fitCenter().into(left_img14);
            Glide.with(this).load(R.drawable.slim).fitCenter().into(left_img15);
            Glide.with(this).load(R.drawable.plane).fitCenter().into(left_img16);
            Glide.with(this).load(R.drawable.crab2).fitCenter().into(left_img17);
            Glide.with(this).load(R.drawable.playground).fitCenter().into(left_img18);
            Glide.with(this).load(R.drawable.beef).fitCenter().into(left_img19);
            Glide.with(this).load(R.drawable.lion).fitCenter().into(left_img20);

            Glide.with(this).load(R.drawable.shose2).fitCenter().into(right_img1);
            Glide.with(this).load(R.drawable.head).fitCenter().into(right_img2);
            Glide.with(this).load(R.drawable.daughter).fitCenter().into(right_img3);
            Glide.with(this).load(R.drawable.home).fitCenter().into(right_img4);
            Glide.with(this).load(R.drawable.speaker).fitCenter().into(right_img5);
            Glide.with(this).load(R.drawable.heart).fitCenter().into(right_img6);
            Glide.with(this).load(R.drawable.cross).fitCenter().into(right_img7);
            Glide.with(this).load(R.drawable.pear).fitCenter().into(right_img8);
            Glide.with(this).load(R.drawable.fall).fitCenter().into(right_img9);
            Glide.with(this).load(R.drawable.seat).fitCenter().into(right_img10);
            Glide.with(this).load(R.drawable.beef).fitCenter().into(right_img11);
            Glide.with(this).load(R.drawable.rain).fitCenter().into(right_img12);
            Glide.with(this).load(R.drawable.award).fitCenter().into(right_img13);
            Glide.with(this).load(R.drawable.time2).fitCenter().into(right_img14);
            Glide.with(this).load(R.drawable.fet).fitCenter().into(right_img15);
            Glide.with(this).load(R.drawable.boat).fitCenter().into(right_img16);
            Glide.with(this).load(R.drawable.crab).fitCenter().into(right_img17);
            Glide.with(this).load(R.drawable.ride).fitCenter().into(right_img18);
            Glide.with(this).load(R.drawable.meat).fitCenter().into(right_img19);
            Glide.with(this).load(R.drawable.penguin).fitCenter().into(right_img20);


        }
        else if(game_num==4){
            left_answer1.setText(question_04_left[0]);
            left_answer2.setText(question_04_left[1]);
            left_answer3.setText(question_04_left[2]);
            left_answer4.setText(question_04_left[3]);
            left_answer5.setText(question_04_left[4]);
            left_answer6.setText(question_04_left[5]);
            left_answer7.setText(question_04_left[6]);
            left_answer8.setText(question_04_left[7]);
            left_answer9.setText(question_04_left[8]);
            left_answer10.setText(question_04_left[9]);
            left_answer11.setText(question_04_left[10]);
            left_answer12.setText(question_04_left[11]);
            left_answer13.setText(question_04_left[12]);
            left_answer14.setText(question_04_left[13]);
            left_answer15.setText(question_04_left[14]);
            left_answer16.setText(question_04_left[15]);
            left_answer17.setText(question_04_left[16]);
            left_answer18.setText(question_04_left[17]);
            left_answer19.setText(question_04_left[18]);
            left_answer20.setText(question_04_left[19]);

            right_answer1.setText(question_04_right[0]);
            right_answer2.setText(question_04_right[1]);
            right_answer3.setText(question_04_right[2]);
            right_answer4.setText(question_04_right[3]);
            right_answer5.setText(question_04_right[4]);
            right_answer6.setText(question_04_right[5]);
            right_answer7.setText(question_04_right[6]);
            right_answer8.setText(question_04_right[7]);
            right_answer9.setText(question_04_right[8]);
            right_answer10.setText(question_04_right[9]);
            right_answer11.setText(question_04_right[10]);
            right_answer12.setText(question_04_right[11]);
            right_answer13.setText(question_04_right[12]);
            right_answer14.setText(question_04_right[13]);
            right_answer15.setText(question_04_right[14]);
            right_answer16.setText(question_04_right[15]);
            right_answer17.setText(question_04_right[16]);
            right_answer18.setText(question_04_right[17]);
            right_answer19.setText(question_04_right[18]);
            right_answer20.setText(question_04_right[19]);

            Glide.with(this).load(R.drawable.amusement).fitCenter().into(right_img1);
            Glide.with(this).load(R.drawable.walk).fitCenter().into(right_img2);
            Glide.with(this).load(R.drawable.chicken3).fitCenter().into(right_img3);
            Glide.with(this).load(R.drawable.chicken5).fitCenter().into(right_img4);
            Glide.with(this).load(R.drawable.moon).fitCenter().into(right_img5);
            Glide.with(this).load(R.drawable.conversation).fitCenter().into(right_img6);
            Glide.with(this).load(R.drawable.mouth).fitCenter().into(right_img7);
            Glide.with(this).load(R.drawable.rocket).fitCenter().into(right_img8);
            Glide.with(this).load(R.drawable.movie).fitCenter().into(right_img9);
            Glide.with(this).load(R.drawable.baseball).fitCenter().into(right_img10);
            Glide.with(this).load(R.drawable.coke).fitCenter().into(right_img11);
            Glide.with(this).load(R.drawable.rain).fitCenter().into(right_img12);
            Glide.with(this).load(R.drawable.soldier).fitCenter().into(right_img13);
            Glide.with(this).load(R.drawable.mouse2).fitCenter().into(right_img14);
            Glide.with(this).load(R.drawable.macbook).fitCenter().into(right_img15);
            Glide.with(this).load(R.drawable.rice).fitCenter().into(right_img16);
            Glide.with(this).load(R.drawable.jjajang).fitCenter().into(right_img17);
            Glide.with(this).load(R.drawable.sms).fitCenter().into(right_img18);
            Glide.with(this).load(R.drawable.soju).fitCenter().into(right_img19);
            Glide.with(this).load(R.drawable.d3d).fitCenter().into(right_img20);

            Glide.with(this).load(R.drawable.rollercoaster).fitCenter().into(left_img1);
            Glide.with(this).load(R.drawable.face2).fitCenter().into(left_img2);
            Glide.with(this).load(R.drawable.turkey).fitCenter().into(left_img3);
            Glide.with(this).load(R.drawable.chicken4).fitCenter().into(left_img4);
            Glide.with(this).load(R.drawable.sun).fitCenter().into(left_img5);
            Glide.with(this).load(R.drawable.heart).fitCenter().into(left_img6);
            Glide.with(this).load(R.drawable.mouth2).fitCenter().into(left_img7);
            Glide.with(this).load(R.drawable.seaweed).fitCenter().into(left_img8);
            Glide.with(this).load(R.drawable.tv).fitCenter().into(left_img9);
            Glide.with(this).load(R.drawable.soccer).fitCenter().into(left_img10);
            Glide.with(this).load(R.drawable.soda).fitCenter().into(left_img11);
            Glide.with(this).load(R.drawable.sun).fitCenter().into(left_img12);
            Glide.with(this).load(R.drawable.cross).fitCenter().into(left_img13);
            Glide.with(this).load(R.drawable.usb).fitCenter().into(left_img14);
            Glide.with(this).load(R.drawable.computer).fitCenter().into(left_img15);
            Glide.with(this).load(R.drawable.meat).fitCenter().into(left_img16);
            Glide.with(this).load(R.drawable.sushi).fitCenter().into(left_img17);
            Glide.with(this).load(R.drawable.call).fitCenter().into(left_img18);
            Glide.with(this).load(R.drawable.beer).fitCenter().into(left_img19);
            Glide.with(this).load(R.drawable.d2d).fitCenter().into(left_img20);

        }
        else if(game_num==5){
            left_answer1.setText(question_05_left[0]);
            left_answer2.setText(question_05_left[1]);
            left_answer3.setText(question_05_left[2]);
            left_answer4.setText(question_05_left[3]);
            left_answer5.setText(question_05_left[4]);
            left_answer6.setText(question_05_left[5]);
            left_answer7.setText(question_05_left[6]);
            left_answer8.setText(question_05_left[7]);
            left_answer9.setText(question_05_left[8]);
            left_answer10.setText(question_05_left[9]);
            left_answer11.setText(question_05_left[10]);
            left_answer12.setText(question_05_left[11]);
            left_answer13.setText(question_05_left[12]);
            left_answer14.setText(question_05_left[13]);
            left_answer15.setText(question_05_left[14]);
            left_answer16.setText(question_05_left[15]);
            left_answer17.setText(question_05_left[16]);
            left_answer18.setText(question_05_left[17]);
            left_answer19.setText(question_05_left[18]);
            left_answer20.setText(question_05_left[19]);

            right_answer1.setText(question_05_right[0]);
            right_answer2.setText(question_05_right[1]);
            right_answer3.setText(question_05_right[2]);
            right_answer4.setText(question_05_right[3]);
            right_answer5.setText(question_05_right[4]);
            right_answer6.setText(question_05_right[5]);
            right_answer7.setText(question_05_right[6]);
            right_answer8.setText(question_05_right[7]);
            right_answer9.setText(question_05_right[8]);
            right_answer10.setText(question_05_right[9]);
            right_answer11.setText(question_05_right[10]);
            right_answer12.setText(question_05_right[11]);
            right_answer13.setText(question_05_right[12]);
            right_answer14.setText(question_05_right[13]);
            right_answer15.setText(question_05_right[14]);
            right_answer16.setText(question_05_right[15]);
            right_answer17.setText(question_05_right[16]);
            right_answer18.setText(question_05_right[17]);
            right_answer19.setText(question_05_right[18]);
            right_answer20.setText(question_05_right[19]);

            Glide.with(this).load(R.drawable.woman).fitCenter().into(right_img1);
            Glide.with(this).load(R.drawable.headphones).fitCenter().into(right_img2);
            Glide.with(this).load(R.drawable.snow).fitCenter().into(right_img3);
            Glide.with(this).load(R.drawable.book).fitCenter().into(right_img4);
            Glide.with(this).load(R.drawable.soccer).fitCenter().into(right_img5);
            Glide.with(this).load(R.drawable.bed).fitCenter().into(right_img6);
            Glide.with(this).load(R.drawable.summer).fitCenter().into(right_img7);
            Glide.with(this).load(R.drawable.spicy).fitCenter().into(right_img8);
            Glide.with(this).load(R.drawable.chicken).fitCenter().into(right_img9);
            Glide.with(this).load(R.drawable.color2).fitCenter().into(right_img10);
            Glide.with(this).load(R.drawable.sushi).fitCenter().into(right_img11);
            Glide.with(this).load(R.drawable.computer).fitCenter().into(right_img12);
            Glide.with(this).load(R.drawable.aparment).fitCenter().into(right_img13);
            Glide.with(this).load(R.drawable.time2).fitCenter().into(right_img14);
            Glide.with(this).load(R.drawable.fet).fitCenter().into(right_img15);
            Glide.with(this).load(R.drawable.ice_coffee).fitCenter().into(right_img16);
            Glide.with(this).load(R.drawable.globe).fitCenter().into(right_img17);
            Glide.with(this).load(R.drawable.ride).fitCenter().into(right_img18);
            Glide.with(this).load(R.drawable.noodles2).fitCenter().into(right_img19);
            Glide.with(this).load(R.drawable.food).fitCenter().into(right_img20);

            Glide.with(this).load(R.drawable.head).fitCenter().into(left_img1);
            Glide.with(this).load(R.drawable.speaker).fitCenter().into(left_img2);
            Glide.with(this).load(R.drawable.rain).fitCenter().into(left_img3);
            Glide.with(this).load(R.drawable.book2).fitCenter().into(left_img4);
            Glide.with(this).load(R.drawable.d3d).fitCenter().into(left_img5);
            Glide.with(this).load(R.drawable.tatami).fitCenter().into(left_img6);
            Glide.with(this).load(R.drawable.winter).fitCenter().into(left_img7);
            Glide.with(this).load(R.drawable.jam).fitCenter().into(left_img8);
            Glide.with(this).load(R.drawable.burger).fitCenter().into(left_img9);
            Glide.with(this).load(R.drawable.color).fitCenter().into(left_img10);
            Glide.with(this).load(R.drawable.jjajang).fitCenter().into(left_img11);
            Glide.with(this).load(R.drawable.speaker).fitCenter().into(left_img12);
            Glide.with(this).load(R.drawable.home).fitCenter().into(left_img13);
            Glide.with(this).load(R.drawable.time).fitCenter().into(left_img14);
            Glide.with(this).load(R.drawable.slim).fitCenter().into(left_img15);
            Glide.with(this).load(R.drawable.hot_coffee).fitCenter().into(left_img16);
            Glide.with(this).load(R.drawable.train).fitCenter().into(left_img17);
            Glide.with(this).load(R.drawable.playground).fitCenter().into(left_img18);
            Glide.with(this).load(R.drawable.noodle).fitCenter().into(left_img19);
            Glide.with(this).load(R.drawable.food2).fitCenter().into(left_img20);
        }

        btn_send = (TextView)findViewById(R.id.btn_send);

        this_page.setText(page+" / "+"20");

        left_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page1.setVisibility(View.GONE);
                Linear_page2.setVisibility(View.VISIBLE);
                arr_answer[0] = left_answer1.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page1.setVisibility(View.GONE);
                Linear_page2.setVisibility(View.VISIBLE);
                arr_answer[0] = right_answer1.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page2.setVisibility(View.GONE);
                Linear_page3.setVisibility(View.VISIBLE);
                arr_answer[1] = left_answer2.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page2.setVisibility(View.GONE);
                Linear_page3.setVisibility(View.VISIBLE);
                arr_answer[1] = right_answer2.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page3.setVisibility(View.GONE);
                Linear_page4.setVisibility(View.VISIBLE);
                arr_answer[2] = left_answer3.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page3.setVisibility(View.GONE);
                Linear_page4.setVisibility(View.VISIBLE);
                arr_answer[2] = right_answer3.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page4.setVisibility(View.GONE);
                Linear_page5.setVisibility(View.VISIBLE);
                arr_answer[3] = left_answer4.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page4.setVisibility(View.GONE);
                Linear_page5.setVisibility(View.VISIBLE);
                arr_answer[3] = right_answer4.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page5.setVisibility(View.GONE);
                Linear_page6.setVisibility(View.VISIBLE);
                arr_answer[4] = left_answer5.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page5.setVisibility(View.GONE);
                Linear_page6.setVisibility(View.VISIBLE);
                arr_answer[4] = right_answer5.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page6.setVisibility(View.GONE);
                Linear_page7.setVisibility(View.VISIBLE);
                arr_answer[5] = left_answer6.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page6.setVisibility(View.GONE);
                Linear_page7.setVisibility(View.VISIBLE);
                arr_answer[5] = right_answer6.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page7.setVisibility(View.GONE);
                Linear_page8.setVisibility(View.VISIBLE);
                arr_answer[6] = left_answer7.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page7.setVisibility(View.GONE);
                Linear_page8.setVisibility(View.VISIBLE);
                arr_answer[6] = right_answer7.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page8.setVisibility(View.GONE);
                Linear_page9.setVisibility(View.VISIBLE);
                arr_answer[7] = left_answer8.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page8.setVisibility(View.GONE);
                Linear_page9.setVisibility(View.VISIBLE);
                arr_answer[7] = right_answer8.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page9.setVisibility(View.GONE);
                Linear_page10.setVisibility(View.VISIBLE);
                arr_answer[8] = left_answer9.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page9.setVisibility(View.GONE);
                Linear_page10.setVisibility(View.VISIBLE);
                arr_answer[8] = right_answer9.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page10.setVisibility(View.GONE);
                Linear_page11.setVisibility(View.VISIBLE);
                arr_answer[9] = left_answer10.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page10.setVisibility(View.GONE);
                Linear_page11.setVisibility(View.VISIBLE);
                arr_answer[9] = right_answer10.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page11.setVisibility(View.GONE);
                Linear_page12.setVisibility(View.VISIBLE);
                arr_answer[10] = left_answer11.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page11.setVisibility(View.GONE);
                Linear_page12.setVisibility(View.VISIBLE);
                arr_answer[10] = right_answer11.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page12.setVisibility(View.GONE);
                Linear_page13.setVisibility(View.VISIBLE);
                arr_answer[11] = left_answer12.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page12.setVisibility(View.GONE);
                Linear_page13.setVisibility(View.VISIBLE);
                arr_answer[11] = right_answer12.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page13.setVisibility(View.GONE);
                Linear_page14.setVisibility(View.VISIBLE);
                arr_answer[12] = left_answer13.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page13.setVisibility(View.GONE);
                Linear_page14.setVisibility(View.VISIBLE);
                arr_answer[12] = right_answer13.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page14.setVisibility(View.GONE);
                Linear_page15.setVisibility(View.VISIBLE);
                arr_answer[13] = left_answer14.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page14.setVisibility(View.GONE);
                Linear_page15.setVisibility(View.VISIBLE);
                arr_answer[13] = right_answer14.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page15.setVisibility(View.GONE);
                Linear_page16.setVisibility(View.VISIBLE);
                arr_answer[14] = left_answer15.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page15.setVisibility(View.GONE);
                Linear_page16.setVisibility(View.VISIBLE);
                arr_answer[14] = right_answer15.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page16.setVisibility(View.GONE);
                Linear_page17.setVisibility(View.VISIBLE);
                arr_answer[15] = left_answer16.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page16.setVisibility(View.GONE);
                Linear_page17.setVisibility(View.VISIBLE);
                arr_answer[15] = right_answer16.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page17.setVisibility(View.GONE);
                Linear_page18.setVisibility(View.VISIBLE);
                arr_answer[16] = left_answer17.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page17.setVisibility(View.GONE);
                Linear_page18.setVisibility(View.VISIBLE);
                arr_answer[16] = right_answer17.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page18.setVisibility(View.GONE);
                Linear_page19.setVisibility(View.VISIBLE);
                arr_answer[17] = left_answer18.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page18.setVisibility(View.GONE);
                Linear_page19.setVisibility(View.VISIBLE);
                arr_answer[17] = right_answer18.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page19.setVisibility(View.GONE);
                Linear_page20.setVisibility(View.VISIBLE);
                arr_answer[18] = left_answer19.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        right_img19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page19.setVisibility(View.GONE);
                Linear_page20.setVisibility(View.VISIBLE);
                arr_answer[18] = right_answer19.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_img20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page==20){
                    page++;
                    arr_answer[19] = left_answer20.getText().toString();
                    countDownTimer.cancel();
                    timer();
                }

                Toast.makeText(getApplicationContext(),"끝입니다",Toast.LENGTH_SHORT).show();
            }
        });
        right_img20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page==20){
                    page++;
                    arr_answer[19] = right_answer20.getText().toString();
                    countDownTimer.cancel();
                    timer();
                }

                Toast.makeText(getApplicationContext(),"끝입니다",Toast.LENGTH_SHORT).show();
            }
        });
        left_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page1.setVisibility(View.GONE);
                Linear_page2.setVisibility(View.VISIBLE);
                arr_answer[0] = left_answer1.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page1.setVisibility(View.GONE);
                Linear_page2.setVisibility(View.VISIBLE);
                arr_answer[0] = right_answer1.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        left_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page2.setVisibility(View.GONE);
                Linear_page3.setVisibility(View.VISIBLE);
                arr_answer[1] = left_answer2.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page2.setVisibility(View.GONE);
                Linear_page3.setVisibility(View.VISIBLE);
                arr_answer[1] = right_answer2.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        left_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page3.setVisibility(View.GONE);
                Linear_page4.setVisibility(View.VISIBLE);
                arr_answer[2] = left_answer3.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page3.setVisibility(View.GONE);
                Linear_page4.setVisibility(View.VISIBLE);
                arr_answer[2] = right_answer3.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        left_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page4.setVisibility(View.GONE);
                Linear_page5.setVisibility(View.VISIBLE);
                arr_answer[3] = left_answer4.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page4.setVisibility(View.GONE);
                Linear_page5.setVisibility(View.VISIBLE);
                arr_answer[3] = right_answer4.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page5.setVisibility(View.GONE);
                Linear_page6.setVisibility(View.VISIBLE);
                arr_answer[4] = left_answer5.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page5.setVisibility(View.GONE);
                Linear_page6.setVisibility(View.VISIBLE);
                arr_answer[4] = right_answer5.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page6.setVisibility(View.GONE);
                Linear_page7.setVisibility(View.VISIBLE);
                arr_answer[5] = left_answer6.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page6.setVisibility(View.GONE);
                Linear_page7.setVisibility(View.VISIBLE);
                arr_answer[5] = right_answer6.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page7.setVisibility(View.GONE);
                Linear_page8.setVisibility(View.VISIBLE);
                arr_answer[6] = left_answer7.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page7.setVisibility(View.GONE);
                Linear_page8.setVisibility(View.VISIBLE);
                arr_answer[6] = right_answer7.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page8.setVisibility(View.GONE);
                Linear_page9.setVisibility(View.VISIBLE);
                arr_answer[7] = left_answer8.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page8.setVisibility(View.GONE);
                Linear_page9.setVisibility(View.VISIBLE);
                arr_answer[7] = right_answer8.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page9.setVisibility(View.GONE);
                Linear_page10.setVisibility(View.VISIBLE);
                arr_answer[8] = left_answer9.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page9.setVisibility(View.GONE);
                Linear_page10.setVisibility(View.VISIBLE);
                arr_answer[8] = right_answer9.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page10.setVisibility(View.GONE);
                Linear_page11.setVisibility(View.VISIBLE);
                arr_answer[9] = left_answer10.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page10.setVisibility(View.GONE);
                Linear_page11.setVisibility(View.VISIBLE);
                arr_answer[9] = right_answer10.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page11.setVisibility(View.GONE);
                Linear_page12.setVisibility(View.VISIBLE);
                arr_answer[10] = left_answer11.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page11.setVisibility(View.GONE);
                Linear_page12.setVisibility(View.VISIBLE);
                arr_answer[10] = right_answer11.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page12.setVisibility(View.GONE);
                Linear_page13.setVisibility(View.VISIBLE);
                arr_answer[11] = left_answer12.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page12.setVisibility(View.GONE);
                Linear_page13.setVisibility(View.VISIBLE);
                arr_answer[11] = right_answer12.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page13.setVisibility(View.GONE);
                Linear_page14.setVisibility(View.VISIBLE);
                arr_answer[12] = left_answer13.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page13.setVisibility(View.GONE);
                Linear_page14.setVisibility(View.VISIBLE);
                arr_answer[12] = right_answer13.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        left_answer14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page14.setVisibility(View.GONE);
                Linear_page15.setVisibility(View.VISIBLE);
                arr_answer[13] = left_answer14.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page14.setVisibility(View.GONE);
                Linear_page15.setVisibility(View.VISIBLE);
                arr_answer[13] = right_answer14.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        left_answer15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page15.setVisibility(View.GONE);
                Linear_page16.setVisibility(View.VISIBLE);
                arr_answer[14] = left_answer15.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page15.setVisibility(View.GONE);
                Linear_page16.setVisibility(View.VISIBLE);
                arr_answer[14] = right_answer15.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page16.setVisibility(View.GONE);
                Linear_page17.setVisibility(View.VISIBLE);
                arr_answer[15] = left_answer16.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page16.setVisibility(View.GONE);
                Linear_page17.setVisibility(View.VISIBLE);
                arr_answer[15] = right_answer16.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        left_answer17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page17.setVisibility(View.GONE);
                Linear_page18.setVisibility(View.VISIBLE);
                arr_answer[16] = left_answer17.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page17.setVisibility(View.GONE);
                Linear_page18.setVisibility(View.VISIBLE);
                arr_answer[16] = right_answer17.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page18.setVisibility(View.GONE);
                Linear_page19.setVisibility(View.VISIBLE);
                arr_answer[17] = left_answer18.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page18.setVisibility(View.GONE);
                Linear_page19.setVisibility(View.VISIBLE);
                arr_answer[17] = right_answer18.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page19.setVisibility(View.GONE);
                Linear_page20.setVisibility(View.VISIBLE);
                arr_answer[18] = left_answer19.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });

        right_answer19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Linear_page19.setVisibility(View.GONE);
                Linear_page20.setVisibility(View.VISIBLE);
                arr_answer[18] = right_answer19.getText().toString();
                page++;
                this_page.setText(page+" / "+"20");
                countDownTimer.cancel();
                timer();
            }
        });
        left_answer20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page==20){
                    page++;
                    arr_answer[19] = left_answer20.getText().toString();
                    countDownTimer.cancel();
                    timer();
                }

                Toast.makeText(getApplicationContext(),"끝입니다",Toast.LENGTH_SHORT).show();
            }
        });

        right_answer20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page==20){
                    page++;
                    arr_answer[19] = right_answer20.getText().toString();
                    countDownTimer.cancel();
                    timer();
                }
                Toast.makeText(getApplicationContext(),"끝입니다",Toast.LENGTH_SHORT).show();
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(page!=21){
                    Toast.makeText(getApplicationContext(),"문제를 끝까지 풀어주세요",Toast.LENGTH_SHORT).show();
                }
                else{

                    if (mRewardedVideoAd.isLoaded()) {
                        mRewardedVideoAd.show();
                    }

//                    mRewardedVideoAd.loadAd("ca-app-pub-5784293657699097/3686555184",
//                            new AdRequest.Builder().build());

//                    if(adfull.isLoaded()){
//                        adfull.show();
//                    };

                    new BackgroundTask_roomList().execute();
                }
            }
        });

        btn_regame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CoupleGameStart.class);
                intent.putExtra("gameCode","0");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    //임시저장
    public void gameAdd(){

        // --------------------유저 DB 등록 시작--------------------
        String gameID = LoginUserID;
        int gameCode = game_num;
        String gameAnswer1, gameAnswer2, gameAnswer3, gameAnswer4, gameAnswer5, gameAnswer6, gameAnswer7, gameAnswer8, gameAnswer9, gameAnswer10,
                gameAnswer11,gameAnswer12,gameAnswer13,gameAnswer14,gameAnswer15,gameAnswer16,gameAnswer17,gameAnswer18,gameAnswer19,gameAnswer20;

        gameAnswer1 = arr_answer[0];
        gameAnswer2 = arr_answer[1];
        gameAnswer3 = arr_answer[2];
        gameAnswer4 = arr_answer[3];
        gameAnswer5 = arr_answer[4];
        gameAnswer6 = arr_answer[5];
        gameAnswer7 = arr_answer[6];
        gameAnswer8 = arr_answer[7];
        gameAnswer9 = arr_answer[8];
        gameAnswer10 = arr_answer[9];
        gameAnswer11 = arr_answer[10];
        gameAnswer12 = arr_answer[11];
        gameAnswer13 = arr_answer[12];
        gameAnswer14 = arr_answer[13];
        gameAnswer15 = arr_answer[14];
        gameAnswer16 = arr_answer[15];
        gameAnswer17 = arr_answer[16];
        gameAnswer18 = arr_answer[17];
        gameAnswer19 = arr_answer[18];
        gameAnswer20 = arr_answer[19];


        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogUpdate customDialog = new CustomDialogUpdate(CoupleGameStart.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(CoupleGameStart.this);
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

        GameAddRequest registerRequest = new GameAddRequest(gameID, gameCode, gameAnswer1, gameAnswer2, gameAnswer3, gameAnswer4, gameAnswer5,
                gameAnswer6, gameAnswer7, gameAnswer8, gameAnswer9, gameAnswer10, gameAnswer11, gameAnswer12, gameAnswer13, gameAnswer14, gameAnswer15,
                gameAnswer16, gameAnswer17, gameAnswer18, gameAnswer19, gameAnswer20, responseListener);
        RequestQueue queue = Volley.newRequestQueue(CoupleGameStart.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------


    }

    //임시저장
    public void gameUpdate(){

        // --------------------유저 DB 등록 시작--------------------
        String gameID = LoginUserID;
        int gameCode = game_num;
        String gameAnswer1, gameAnswer2, gameAnswer3, gameAnswer4, gameAnswer5, gameAnswer6, gameAnswer7, gameAnswer8, gameAnswer9, gameAnswer10,
                gameAnswer11,gameAnswer12,gameAnswer13,gameAnswer14,gameAnswer15,gameAnswer16,gameAnswer17,gameAnswer18,gameAnswer19,gameAnswer20;

        gameAnswer1 = arr_answer[0];
        gameAnswer2 = arr_answer[1];
        gameAnswer3 = arr_answer[2];
        gameAnswer4 = arr_answer[3];
        gameAnswer5 = arr_answer[4];
        gameAnswer6 = arr_answer[5];
        gameAnswer7 = arr_answer[6];
        gameAnswer8 = arr_answer[7];
        gameAnswer9 = arr_answer[8];
        gameAnswer10 = arr_answer[9];
        gameAnswer11 = arr_answer[10];
        gameAnswer12 = arr_answer[11];
        gameAnswer13 = arr_answer[12];
        gameAnswer14 = arr_answer[13];
        gameAnswer15 = arr_answer[14];
        gameAnswer16 = arr_answer[15];
        gameAnswer17 = arr_answer[16];
        gameAnswer18 = arr_answer[17];
        gameAnswer19 = arr_answer[18];
        gameAnswer20 = arr_answer[19];

        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSucces customDialog = new CustomDialogSucces(CoupleGameStart.this);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.


                        customDialog.callFunction();



                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(CoupleGameStart.this);
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

        GameUpdateRequest registerRequest = new GameUpdateRequest(gameID, gameCode, gameAnswer1, gameAnswer2, gameAnswer3, gameAnswer4, gameAnswer5,
                gameAnswer6, gameAnswer7, gameAnswer8, gameAnswer9, gameAnswer10, gameAnswer11, gameAnswer12, gameAnswer13, gameAnswer14, gameAnswer15,
                gameAnswer16, gameAnswer17, gameAnswer18, gameAnswer19, gameAnswer20, responseListener);
        RequestQueue queue = Volley.newRequestQueue(CoupleGameStart.this);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------




    }

    public void timer(){

        countDownTimer = new CountDownTimer(6000, 1000) {
            public void onTick(long millisUntilFinished) {
                text_timer.setText(String.format(Locale.getDefault(), "남은시간 : %d초", millisUntilFinished / 1000L));
                h_progressbar.setProgress(Integer.parseInt(String.valueOf(millisUntilFinished / 1000L)));
            }

            public void onFinish() {

                if(page==1) {
                    Linear_page1.setVisibility(View.GONE);
                    Linear_page2.setVisibility(View.VISIBLE);
                    arr_answer[0] = "시간초과";
                }
                else if(page==2){
                    Linear_page2.setVisibility(View.GONE);
                    Linear_page3.setVisibility(View.VISIBLE);
                    arr_answer[1] = "시간초과";
                }
                else if(page==3){
                    Linear_page3.setVisibility(View.GONE);
                    Linear_page4.setVisibility(View.VISIBLE);
                    arr_answer[2] = "시간초과";
                }
                else if(page==4){
                    Linear_page4.setVisibility(View.GONE);
                    Linear_page5.setVisibility(View.VISIBLE);
                    arr_answer[3] = "시간초과";
                }
                else if(page==5){
                    Linear_page5.setVisibility(View.GONE);
                    Linear_page6.setVisibility(View.VISIBLE);
                    arr_answer[4] = "시간초과";
                }
                else if(page==6){
                    Linear_page6.setVisibility(View.GONE);
                    Linear_page7.setVisibility(View.VISIBLE);
                    arr_answer[5] = "시간초과";
                }
                else if(page==7){
                    Linear_page7.setVisibility(View.GONE);
                    Linear_page8.setVisibility(View.VISIBLE);
                    arr_answer[6] = "시간초과";
                }
                else if(page==8){
                    Linear_page8.setVisibility(View.GONE);
                    Linear_page9.setVisibility(View.VISIBLE);
                    arr_answer[7] = "시간초과";
                }
                else if(page==9){
                    Linear_page9.setVisibility(View.GONE);
                    Linear_page10.setVisibility(View.VISIBLE);
                    arr_answer[8] = "시간초과";
                }
                else if(page==10){
                    Linear_page10.setVisibility(View.GONE);
                    Linear_page11.setVisibility(View.VISIBLE);
                    arr_answer[9] = "시간초과";
                }
                else if(page==11){
                    Linear_page11.setVisibility(View.GONE);
                    Linear_page12.setVisibility(View.VISIBLE);
                    arr_answer[10] = "시간초과";
                }
                else if(page==12){
                    Linear_page12.setVisibility(View.GONE);
                    Linear_page13.setVisibility(View.VISIBLE);
                    arr_answer[11] = "시간초과";
                }
                else if(page==13){
                    Linear_page13.setVisibility(View.GONE);
                    Linear_page14.setVisibility(View.VISIBLE);
                    arr_answer[12] = "시간초과";
                }
                else if(page==14){
                    Linear_page14.setVisibility(View.GONE);
                    Linear_page15.setVisibility(View.VISIBLE);
                    arr_answer[13] = "시간초과";
                }
                else if(page==15){
                    Linear_page15.setVisibility(View.GONE);
                    Linear_page16.setVisibility(View.VISIBLE);
                    arr_answer[14] = "시간초과";
                }
                else if(page==16){
                    Linear_page16.setVisibility(View.GONE);
                    Linear_page17.setVisibility(View.VISIBLE);
                    arr_answer[15] = "시간초과";
                }
                else if(page==17){
                    Linear_page17.setVisibility(View.GONE);
                    Linear_page18.setVisibility(View.VISIBLE);
                    arr_answer[16] = "시간초과";
                }
                else if(page==18){
                    Linear_page18.setVisibility(View.GONE);
                    Linear_page19.setVisibility(View.VISIBLE);
                    arr_answer[17] = "시간초과";
                }
                else if(page==19){
                    Linear_page19.setVisibility(View.GONE);
                    Linear_page20.setVisibility(View.VISIBLE);
                    arr_answer[18] = "시간초과";
                }
                else if(page==20){
                    arr_answer[19] = "시간초과";
                }

                if(page!=21) {

                    page++;
                    if(page>=0&&page<=21) {
                        this_page.setText(page + " / " + "20");
                        countDownTimer.cancel();
                        timer();
                    }

                }
            }

        }.start();
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

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

                gameUpdate();

            }
            else if(gameList.size()==0){

                gameAdd();
            }

        }

    }

    private void loadRewardedVideoAd() {

        mRewardedVideoAd.loadAd("ca-app-pub-5784293657699097/3686555184", new AdRequest.Builder().build());
    }



}
