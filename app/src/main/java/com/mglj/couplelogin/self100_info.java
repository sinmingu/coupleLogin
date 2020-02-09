package com.mglj.couplelogin;

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

import static com.mglj.couplelogin.MainLogin.CoupleID;

public class self100_info extends AppCompatActivity {

    TextView self50_anwser1, self50_anwser2, self50_anwser3, self50_anwser4, self50_anwser5, self50_anwser6, self50_anwser7, self50_anwser8,
            self50_anwser9, self50_anwser10, self50_anwser11, self50_anwser12, self50_anwser13, self50_anwser14, self50_anwser15, self50_anwser16
            ,self50_anwser17, self50_anwser18, self50_anwser19, self50_anwser20, self50_anwser21, self50_anwser22, self50_anwser23, self50_anwser24,
            self50_anwser25, self50_anwser26, self50_anwser27, self50_anwser28, self50_anwser29, self50_anwser30, self50_anwser31, self50_anwser32,
            self50_anwser33, self50_anwser34, self50_anwser35, self50_anwser36, self50_anwser37, self50_anwser38, self50_anwser39, self50_anwser40,
            self50_anwser41, self50_anwser42, self50_anwser43, self50_anwser44, self50_anwser45, self50_anwser46, self50_anwser47, self50_anwser48,
            self50_anwser49, self50_anwser50,self50_anwser51, self50_anwser52, self50_anwser53, self50_anwser54, self50_anwser55, self50_anwser56, self50_anwser57, self50_anwser58,
            self50_anwser59, self50_anwser60,self50_anwser61, self50_anwser62, self50_anwser63, self50_anwser64, self50_anwser65, self50_anwser66, self50_anwser67, self50_anwser68,
            self50_anwser69, self50_anwser70,self50_anwser71, self50_anwser72, self50_anwser73, self50_anwser74, self50_anwser75, self50_anwser76, self50_anwser77, self50_anwser78,
            self50_anwser79, self50_anwser80,self50_anwser81, self50_anwser82, self50_anwser83, self50_anwser84, self50_anwser85, self50_anwser86, self50_anwser87, self50_anwser88,
            self50_anwser89, self50_anwser90,self50_anwser91, self50_anwser92, self50_anwser93, self50_anwser94, self50_anwser95, self50_anwser96, self50_anwser97, self50_anwser98,
            self50_anwser99, self50_anwser100;

    List<Self100> self50List;
    ImageView de_no_cancle, de_no_can;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self100_info);

        de_no_cancle = (ImageView)findViewById(R.id.de_no_cancle);
        de_no_can = (ImageView)findViewById(R.id.de_no_can);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_cancle);
        Glide.with(this).load(R.drawable.cancel_2).fitCenter().into(de_no_can);

        de_no_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        self50_anwser1 = (TextView)findViewById(R.id.self50_anwser1);
        self50_anwser2 = (TextView)findViewById(R.id.self50_anwser2);
        self50_anwser3 = (TextView)findViewById(R.id.self50_anwser3);
        self50_anwser4 = (TextView)findViewById(R.id.self50_anwser4);
        self50_anwser5 = (TextView)findViewById(R.id.self50_anwser5);
        self50_anwser6 = (TextView)findViewById(R.id.self50_anwser6);
        self50_anwser7 = (TextView)findViewById(R.id.self50_anwser7);
        self50_anwser8 = (TextView)findViewById(R.id.self50_anwser8);
        self50_anwser9 = (TextView)findViewById(R.id.self50_anwser9);
        self50_anwser10 = (TextView)findViewById(R.id.self50_anwser10);
        self50_anwser11 = (TextView)findViewById(R.id.self50_anwser11);
        self50_anwser12 = (TextView)findViewById(R.id.self50_anwser12);
        self50_anwser13 = (TextView)findViewById(R.id.self50_anwser13);
        self50_anwser14 = (TextView)findViewById(R.id.self50_anwser14);
        self50_anwser15 = (TextView)findViewById(R.id.self50_anwser15);
        self50_anwser16 = (TextView)findViewById(R.id.self50_anwser16);
        self50_anwser17 = (TextView)findViewById(R.id.self50_anwser17);
        self50_anwser18 = (TextView)findViewById(R.id.self50_anwser18);
        self50_anwser19 = (TextView)findViewById(R.id.self50_anwser19);
        self50_anwser20 = (TextView)findViewById(R.id.self50_anwser20);
        self50_anwser21 = (TextView)findViewById(R.id.self50_anwser21);
        self50_anwser22 = (TextView)findViewById(R.id.self50_anwser22);
        self50_anwser23 = (TextView)findViewById(R.id.self50_anwser23);
        self50_anwser24 = (TextView)findViewById(R.id.self50_anwser24);
        self50_anwser25 = (TextView)findViewById(R.id.self50_anwser25);
        self50_anwser26 = (TextView)findViewById(R.id.self50_anwser26);
        self50_anwser27 = (TextView)findViewById(R.id.self50_anwser27);
        self50_anwser28 = (TextView)findViewById(R.id.self50_anwser28);
        self50_anwser29 = (TextView)findViewById(R.id.self50_anwser29);
        self50_anwser30 = (TextView)findViewById(R.id.self50_anwser30);
        self50_anwser31 = (TextView)findViewById(R.id.self50_anwser31);
        self50_anwser32 = (TextView)findViewById(R.id.self50_anwser32);
        self50_anwser33 = (TextView)findViewById(R.id.self50_anwser33);
        self50_anwser34 = (TextView)findViewById(R.id.self50_anwser34);
        self50_anwser35 = (TextView)findViewById(R.id.self50_anwser35);
        self50_anwser36 = (TextView)findViewById(R.id.self50_anwser36);
        self50_anwser37 = (TextView)findViewById(R.id.self50_anwser37);
        self50_anwser38 = (TextView)findViewById(R.id.self50_anwser38);
        self50_anwser39 = (TextView)findViewById(R.id.self50_anwser39);
        self50_anwser40 = (TextView)findViewById(R.id.self50_anwser40);
        self50_anwser41 = (TextView)findViewById(R.id.self50_anwser41);
        self50_anwser42 = (TextView)findViewById(R.id.self50_anwser42);
        self50_anwser43 = (TextView)findViewById(R.id.self50_anwser43);
        self50_anwser44 = (TextView)findViewById(R.id.self50_anwser44);
        self50_anwser45 = (TextView)findViewById(R.id.self50_anwser45);
        self50_anwser46 = (TextView)findViewById(R.id.self50_anwser46);
        self50_anwser47 = (TextView)findViewById(R.id.self50_anwser47);
        self50_anwser48 = (TextView)findViewById(R.id.self50_anwser48);
        self50_anwser49 = (TextView)findViewById(R.id.self50_anwser49);
        self50_anwser50 = (TextView)findViewById(R.id.self50_anwser50);
        self50_anwser51 = (TextView)findViewById(R.id.self50_anwser51);
        self50_anwser52 = (TextView)findViewById(R.id.self50_anwser52);
        self50_anwser53 = (TextView)findViewById(R.id.self50_anwser53);
        self50_anwser54 = (TextView)findViewById(R.id.self50_anwser54);
        self50_anwser55 = (TextView)findViewById(R.id.self50_anwser55);
        self50_anwser56 = (TextView)findViewById(R.id.self50_anwser56);
        self50_anwser57 = (TextView)findViewById(R.id.self50_anwser57);
        self50_anwser58 = (TextView)findViewById(R.id.self50_anwser58);
        self50_anwser59 = (TextView)findViewById(R.id.self50_anwser59);
        self50_anwser60 = (TextView)findViewById(R.id.self50_anwser60);
        self50_anwser61 = (TextView)findViewById(R.id.self50_anwser61);
        self50_anwser62 = (TextView)findViewById(R.id.self50_anwser62);
        self50_anwser63 = (TextView)findViewById(R.id.self50_anwser63);
        self50_anwser64 = (TextView)findViewById(R.id.self50_anwser64);
        self50_anwser65 = (TextView)findViewById(R.id.self50_anwser65);
        self50_anwser66 = (TextView)findViewById(R.id.self50_anwser66);
        self50_anwser67 = (TextView)findViewById(R.id.self50_anwser67);
        self50_anwser68 = (TextView)findViewById(R.id.self50_anwser68);
        self50_anwser69 = (TextView)findViewById(R.id.self50_anwser69);
        self50_anwser70 = (TextView)findViewById(R.id.self50_anwser70);
        self50_anwser71 = (TextView)findViewById(R.id.self50_anwser71);
        self50_anwser72 = (TextView)findViewById(R.id.self50_anwser72);
        self50_anwser73 = (TextView)findViewById(R.id.self50_anwser73);
        self50_anwser74 = (TextView)findViewById(R.id.self50_anwser74);
        self50_anwser75 = (TextView)findViewById(R.id.self50_anwser75);
        self50_anwser76 = (TextView)findViewById(R.id.self50_anwser76);
        self50_anwser77 = (TextView)findViewById(R.id.self50_anwser77);
        self50_anwser78 = (TextView)findViewById(R.id.self50_anwser78);
        self50_anwser79 = (TextView)findViewById(R.id.self50_anwser79);
        self50_anwser80 = (TextView)findViewById(R.id.self50_anwser80);
        self50_anwser81 = (TextView)findViewById(R.id.self50_anwser81);
        self50_anwser82 = (TextView)findViewById(R.id.self50_anwser82);
        self50_anwser83 = (TextView)findViewById(R.id.self50_anwser83);
        self50_anwser84 = (TextView)findViewById(R.id.self50_anwser84);
        self50_anwser85 = (TextView)findViewById(R.id.self50_anwser85);
        self50_anwser86 = (TextView)findViewById(R.id.self50_anwser86);
        self50_anwser87 = (TextView)findViewById(R.id.self50_anwser87);
        self50_anwser88 = (TextView)findViewById(R.id.self50_anwser88);
        self50_anwser89 = (TextView)findViewById(R.id.self50_anwser89);
        self50_anwser90 = (TextView)findViewById(R.id.self50_anwser90);
        self50_anwser91 = (TextView)findViewById(R.id.self50_anwser91);
        self50_anwser92 = (TextView)findViewById(R.id.self50_anwser92);
        self50_anwser93 = (TextView)findViewById(R.id.self50_anwser93);
        self50_anwser94 = (TextView)findViewById(R.id.self50_anwser94);
        self50_anwser95 = (TextView)findViewById(R.id.self50_anwser95);
        self50_anwser96 = (TextView)findViewById(R.id.self50_anwser96);
        self50_anwser97 = (TextView)findViewById(R.id.self50_anwser97);
        self50_anwser98 = (TextView)findViewById(R.id.self50_anwser98);
        self50_anwser99 = (TextView)findViewById(R.id.self50_anwser99);
        self50_anwser100 = (TextView)findViewById(R.id.self50_anwser100);

        new BackgroundTask_roomList().execute();
    }

    // 채팅방
    class BackgroundTask_roomList extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "https://tlsalsrn1.cafe24.com/Couple_self100SendList.php";
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

            self50List = new ArrayList<Self100>();

            try{

                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count= 0;
                String self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                        self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                        self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                        self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                        self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50,
                        self50Answer51, self50Answer52, self50Answer53, self50Answer54, self50Answer55, self50Answer56, self50Answer57, self50Answer58, self50Answer59, self50Answer60,
                        self50Answer61, self50Answer62, self50Answer63, self50Answer64, self50Answer65, self50Answer66, self50Answer67, self50Answer68, self50Answer69, self50Answer70,
                        self50Answer71, self50Answer72, self50Answer73, self50Answer74, self50Answer75, self50Answer76, self50Answer77, self50Answer78, self50Answer79, self50Answer80,
                        self50Answer81, self50Answer82, self50Answer83, self50Answer84, self50Answer85, self50Answer86, self50Answer87, self50Answer88, self50Answer89, self50Answer90,
                        self50Answer91, self50Answer92, self50Answer93, self50Answer94, self50Answer95, self50Answer96, self50Answer97, self50Answer98, self50Answer99, self50Answer100;

                while(count < jsonArray.length()){

                    JSONObject object = jsonArray.getJSONObject(count);
                    self50Num = object.getString("self50Num");
                    self50ID = object.getString("self50ID");
                    self50Send = object.getString("self50Send");
                    self50Answer1 = object.getString("self50Answer1");
                    self50Answer2 = object.getString("self50Answer2");
                    self50Answer3 = object.getString("self50Answer3");
                    self50Answer4 = object.getString("self50Answer4");
                    self50Answer5 = object.getString("self50Answer5");
                    self50Answer6 = object.getString("self50Answer6");
                    self50Answer7 = object.getString("self50Answer7");
                    self50Answer8 = object.getString("self50Answer8");
                    self50Answer9 = object.getString("self50Answer9");
                    self50Answer10 = object.getString("self50Answer10");
                    self50Answer11 = object.getString("self50Answer11");
                    self50Answer12 = object.getString("self50Answer12");
                    self50Answer13 = object.getString("self50Answer13");
                    self50Answer14 = object.getString("self50Answer14");
                    self50Answer15 = object.getString("self50Answer15");
                    self50Answer16 = object.getString("self50Answer16");
                    self50Answer17 = object.getString("self50Answer17");
                    self50Answer18 = object.getString("self50Answer18");
                    self50Answer19 = object.getString("self50Answer19");
                    self50Answer20 = object.getString("self50Answer20");
                    self50Answer21 = object.getString("self50Answer21");
                    self50Answer22 = object.getString("self50Answer22");
                    self50Answer23 = object.getString("self50Answer23");
                    self50Answer24 = object.getString("self50Answer24");
                    self50Answer25 = object.getString("self50Answer25");
                    self50Answer26 = object.getString("self50Answer26");
                    self50Answer27 = object.getString("self50Answer27");
                    self50Answer28 = object.getString("self50Answer28");
                    self50Answer29 = object.getString("self50Answer29");
                    self50Answer30 = object.getString("self50Answer30");
                    self50Answer31 = object.getString("self50Answer31");
                    self50Answer32 = object.getString("self50Answer32");
                    self50Answer33 = object.getString("self50Answer33");
                    self50Answer34 = object.getString("self50Answer34");
                    self50Answer35 = object.getString("self50Answer35");
                    self50Answer36 = object.getString("self50Answer36");
                    self50Answer37 = object.getString("self50Answer37");
                    self50Answer38 = object.getString("self50Answer38");
                    self50Answer39 = object.getString("self50Answer39");
                    self50Answer40 = object.getString("self50Answer40");
                    self50Answer41 = object.getString("self50Answer41");
                    self50Answer42 = object.getString("self50Answer42");
                    self50Answer43 = object.getString("self50Answer43");
                    self50Answer44 = object.getString("self50Answer44");
                    self50Answer45 = object.getString("self50Answer45");
                    self50Answer46 = object.getString("self50Answer46");
                    self50Answer47 = object.getString("self50Answer47");
                    self50Answer48 = object.getString("self50Answer48");
                    self50Answer49 = object.getString("self50Answer49");
                    self50Answer50 = object.getString("self50Answer50");
                    self50Answer51 = object.getString("self50Answer51");
                    self50Answer52 = object.getString("self50Answer52");
                    self50Answer53 = object.getString("self50Answer53");
                    self50Answer54 = object.getString("self50Answer54");
                    self50Answer55 = object.getString("self50Answer55");
                    self50Answer56 = object.getString("self50Answer56");
                    self50Answer57 = object.getString("self50Answer57");
                    self50Answer58 = object.getString("self50Answer58");
                    self50Answer59 = object.getString("self50Answer59");
                    self50Answer60 = object.getString("self50Answer60");
                    self50Answer61 = object.getString("self50Answer61");
                    self50Answer62 = object.getString("self50Answer62");
                    self50Answer63 = object.getString("self50Answer63");
                    self50Answer64 = object.getString("self50Answer64");
                    self50Answer65 = object.getString("self50Answer65");
                    self50Answer66 = object.getString("self50Answer66");
                    self50Answer67 = object.getString("self50Answer67");
                    self50Answer68 = object.getString("self50Answer68");
                    self50Answer69 = object.getString("self50Answer69");
                    self50Answer70 = object.getString("self50Answer70");
                    self50Answer71 = object.getString("self50Answer71");
                    self50Answer72 = object.getString("self50Answer72");
                    self50Answer73 = object.getString("self50Answer73");
                    self50Answer74 = object.getString("self50Answer74");
                    self50Answer75 = object.getString("self50Answer75");
                    self50Answer76 = object.getString("self50Answer76");
                    self50Answer77 = object.getString("self50Answer77");
                    self50Answer78 = object.getString("self50Answer78");
                    self50Answer79 = object.getString("self50Answer79");
                    self50Answer80 = object.getString("self50Answer80");
                    self50Answer81 = object.getString("self50Answer81");
                    self50Answer82 = object.getString("self50Answer82");
                    self50Answer83 = object.getString("self50Answer83");
                    self50Answer84 = object.getString("self50Answer84");
                    self50Answer85 = object.getString("self50Answer85");
                    self50Answer86 = object.getString("self50Answer86");
                    self50Answer87 = object.getString("self50Answer87");
                    self50Answer88 = object.getString("self50Answer88");
                    self50Answer89 = object.getString("self50Answer89");
                    self50Answer90 = object.getString("self50Answer90");
                    self50Answer91 = object.getString("self50Answer91");
                    self50Answer92 = object.getString("self50Answer92");
                    self50Answer93 = object.getString("self50Answer93");
                    self50Answer94 = object.getString("self50Answer94");
                    self50Answer95 = object.getString("self50Answer95");
                    self50Answer96 = object.getString("self50Answer96");
                    self50Answer97 = object.getString("self50Answer97");
                    self50Answer98 = object.getString("self50Answer98");
                    self50Answer99 = object.getString("self50Answer99");
                    self50Answer100 = object.getString("self50Answer100");

                    if(self50ID.equals(CoupleID)) {
                        Self100 self100 = new Self100(self50Num, self50ID, self50Send, self50Answer1, self50Answer2, self50Answer3, self50Answer4, self50Answer5, self50Answer6, self50Answer7, self50Answer8, self50Answer9, self50Answer10,
                                self50Answer11, self50Answer12, self50Answer13, self50Answer14, self50Answer15, self50Answer16, self50Answer17, self50Answer18, self50Answer19, self50Answer20,
                                self50Answer21, self50Answer22, self50Answer23, self50Answer24, self50Answer25, self50Answer26, self50Answer27, self50Answer28, self50Answer29, self50Answer30,
                                self50Answer31, self50Answer32, self50Answer33, self50Answer34, self50Answer35, self50Answer36, self50Answer37, self50Answer38, self50Answer39, self50Answer40,
                                self50Answer41, self50Answer42, self50Answer43, self50Answer44, self50Answer45, self50Answer46, self50Answer47, self50Answer48, self50Answer49, self50Answer50,self50Answer51, self50Answer52, self50Answer53, self50Answer54, self50Answer55, self50Answer56, self50Answer57, self50Answer58, self50Answer59, self50Answer60,
                                self50Answer61, self50Answer62, self50Answer63, self50Answer64, self50Answer65, self50Answer66, self50Answer67, self50Answer68, self50Answer69, self50Answer70,
                                self50Answer71, self50Answer72, self50Answer73, self50Answer74, self50Answer75, self50Answer76, self50Answer77, self50Answer78, self50Answer79, self50Answer80,
                                self50Answer81, self50Answer82, self50Answer83, self50Answer84, self50Answer85, self50Answer86, self50Answer87, self50Answer88, self50Answer89, self50Answer90,
                                self50Answer91, self50Answer92, self50Answer93, self50Answer94, self50Answer95, self50Answer96, self50Answer97, self50Answer98, self50Answer99, self50Answer100);
                        self50List.add(self100);
                    }


                    count++;

                }

            }catch(Exception e){

                e.getStackTrace();

            }

            if(self50List.size()>=1){
                self50_anwser1.setText(self50List.get(0).getSelf50Answer1());
                self50_anwser2.setText(self50List.get(0).getSelf50Answer2());
                self50_anwser3.setText(self50List.get(0).getSelf50Answer3());
                self50_anwser4.setText(self50List.get(0).getSelf50Answer4());
                self50_anwser5.setText(self50List.get(0).getSelf50Answer5());
                self50_anwser6.setText(self50List.get(0).getSelf50Answer6());
                self50_anwser7.setText(self50List.get(0).getSelf50Answer7());
                self50_anwser8.setText(self50List.get(0).getSelf50Answer8());
                self50_anwser9.setText(self50List.get(0).getSelf50Answer9());
                self50_anwser10.setText(self50List.get(0).getSelf50Answer10());
                self50_anwser11.setText(self50List.get(0).getSelf50Answer11());
                self50_anwser12.setText(self50List.get(0).getSelf50Answer12());
                self50_anwser13.setText(self50List.get(0).getSelf50Answer13());
                self50_anwser14.setText(self50List.get(0).getSelf50Answer14());
                self50_anwser15.setText(self50List.get(0).getSelf50Answer15());
                self50_anwser16.setText(self50List.get(0).getSelf50Answer16());
                self50_anwser17.setText(self50List.get(0).getSelf50Answer17());
                self50_anwser18.setText(self50List.get(0).getSelf50Answer18());
                self50_anwser19.setText(self50List.get(0).getSelf50Answer19());
                self50_anwser20.setText(self50List.get(0).getSelf50Answer20());
                self50_anwser21.setText(self50List.get(0).getSelf50Answer21());
                self50_anwser22.setText(self50List.get(0).getSelf50Answer22());
                self50_anwser23.setText(self50List.get(0).getSelf50Answer23());
                self50_anwser24.setText(self50List.get(0).getSelf50Answer24());
                self50_anwser25.setText(self50List.get(0).getSelf50Answer25());
                self50_anwser26.setText(self50List.get(0).getSelf50Answer26());
                self50_anwser27.setText(self50List.get(0).getSelf50Answer27());
                self50_anwser28.setText(self50List.get(0).getSelf50Answer28());
                self50_anwser29.setText(self50List.get(0).getSelf50Answer29());
                self50_anwser30.setText(self50List.get(0).getSelf50Answer30());
                self50_anwser31.setText(self50List.get(0).getSelf50Answer31());
                self50_anwser32.setText(self50List.get(0).getSelf50Answer32());
                self50_anwser33.setText(self50List.get(0).getSelf50Answer33());
                self50_anwser34.setText(self50List.get(0).getSelf50Answer34());
                self50_anwser35.setText(self50List.get(0).getSelf50Answer35());
                self50_anwser36.setText(self50List.get(0).getSelf50Answer36());
                self50_anwser37.setText(self50List.get(0).getSelf50Answer37());
                self50_anwser38.setText(self50List.get(0).getSelf50Answer38());
                self50_anwser39.setText(self50List.get(0).getSelf50Answer39());
                self50_anwser40.setText(self50List.get(0).getSelf50Answer40());
                self50_anwser41.setText(self50List.get(0).getSelf50Answer41());
                self50_anwser42.setText(self50List.get(0).getSelf50Answer42());
                self50_anwser43.setText(self50List.get(0).getSelf50Answer43());
                self50_anwser44.setText(self50List.get(0).getSelf50Answer44());
                self50_anwser45.setText(self50List.get(0).getSelf50Answer45());
                self50_anwser46.setText(self50List.get(0).getSelf50Answer46());
                self50_anwser47.setText(self50List.get(0).getSelf50Answer47());
                self50_anwser48.setText(self50List.get(0).getSelf50Answer48());
                self50_anwser49.setText(self50List.get(0).getSelf50Answer49());
                self50_anwser50.setText(self50List.get(0).getSelf50Answer50());
                self50_anwser51.setText(self50List.get(0).getSelf50Answer51());
                self50_anwser52.setText(self50List.get(0).getSelf50Answer52());
                self50_anwser53.setText(self50List.get(0).getSelf50Answer53());
                self50_anwser54.setText(self50List.get(0).getSelf50Answer54());
                self50_anwser55.setText(self50List.get(0).getSelf50Answer55());
                self50_anwser56.setText(self50List.get(0).getSelf50Answer56());
                self50_anwser57.setText(self50List.get(0).getSelf50Answer57());
                self50_anwser58.setText(self50List.get(0).getSelf50Answer58());
                self50_anwser59.setText(self50List.get(0).getSelf50Answer59());
                self50_anwser60.setText(self50List.get(0).getSelf50Answer60());
                self50_anwser61.setText(self50List.get(0).getSelf50Answer61());
                self50_anwser62.setText(self50List.get(0).getSelf50Answer62());
                self50_anwser63.setText(self50List.get(0).getSelf50Answer63());
                self50_anwser64.setText(self50List.get(0).getSelf50Answer64());
                self50_anwser65.setText(self50List.get(0).getSelf50Answer65());
                self50_anwser66.setText(self50List.get(0).getSelf50Answer66());
                self50_anwser67.setText(self50List.get(0).getSelf50Answer67());
                self50_anwser68.setText(self50List.get(0).getSelf50Answer68());
                self50_anwser69.setText(self50List.get(0).getSelf50Answer69());
                self50_anwser70.setText(self50List.get(0).getSelf50Answer70());
                self50_anwser71.setText(self50List.get(0).getSelf50Answer71());
                self50_anwser72.setText(self50List.get(0).getSelf50Answer72());
                self50_anwser73.setText(self50List.get(0).getSelf50Answer73());
                self50_anwser74.setText(self50List.get(0).getSelf50Answer74());
                self50_anwser75.setText(self50List.get(0).getSelf50Answer75());
                self50_anwser76.setText(self50List.get(0).getSelf50Answer76());
                self50_anwser77.setText(self50List.get(0).getSelf50Answer77());
                self50_anwser78.setText(self50List.get(0).getSelf50Answer78());
                self50_anwser79.setText(self50List.get(0).getSelf50Answer79());
                self50_anwser80.setText(self50List.get(0).getSelf50Answer80());
                self50_anwser81.setText(self50List.get(0).getSelf50Answer81());
                self50_anwser82.setText(self50List.get(0).getSelf50Answer82());
                self50_anwser83.setText(self50List.get(0).getSelf50Answer83());
                self50_anwser84.setText(self50List.get(0).getSelf50Answer84());
                self50_anwser85.setText(self50List.get(0).getSelf50Answer85());
                self50_anwser86.setText(self50List.get(0).getSelf50Answer86());
                self50_anwser87.setText(self50List.get(0).getSelf50Answer87());
                self50_anwser88.setText(self50List.get(0).getSelf50Answer88());
                self50_anwser89.setText(self50List.get(0).getSelf50Answer89());
                self50_anwser90.setText(self50List.get(0).getSelf50Answer90());
                self50_anwser91.setText(self50List.get(0).getSelf50Answer91());
                self50_anwser92.setText(self50List.get(0).getSelf50Answer92());
                self50_anwser93.setText(self50List.get(0).getSelf50Answer93());
                self50_anwser94.setText(self50List.get(0).getSelf50Answer94());
                self50_anwser95.setText(self50List.get(0).getSelf50Answer95());
                self50_anwser96.setText(self50List.get(0).getSelf50Answer96());
                self50_anwser97.setText(self50List.get(0).getSelf50Answer97());
                self50_anwser98.setText(self50List.get(0).getSelf50Answer98());
                self50_anwser99.setText(self50List.get(0).getSelf50Answer99());
                self50_anwser100.setText(self50List.get(0).getSelf50Answer100());

            }
            else if(self50List.size()==0){

            }




        }

    }
}
