package com.mglj.couplelogin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class CustomDialogInto {

    EditText room_pw;
    TextView room_name;
    String room, pw;
    private Context context;
    int num;
    String id;

    public CustomDialogInto(Context context) {
        this.context = context;
    }

    // 호출할 다이얼로그 함수를 정의한다.
    public void callFunction(final String ID, final String pass, final int c_num, final String c_id) {

        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.custom_dialog_into);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        room = ID;
        pw = pass;
        num = c_num;
        id = c_id;

        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        room_name = (TextView) dlg.findViewById(R.id.room_name);
        room_pw = (EditText) dlg.findViewById(R.id.room_pw);

        room_name.setText(room);


        final Button okButton = (Button) dlg.findViewById(R.id.okButton);
        final Button cancelButton = (Button) dlg.findViewById(R.id.cancelButton);



        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // '확인' 버튼 클릭시 메인 액티비티에서 설정한 main_label에
                // 커스텀 다이얼로그에서 입력한 메시지를 대입한다.
                if(room_pw.getText().toString().equals(pw)){
                    Toast.makeText(context, "일치", Toast.LENGTH_SHORT).show();
                    regitser();
                }
                else{
                    Toast.makeText(context, "비밀번호가 다릅니다", Toast.LENGTH_SHORT).show();
                    dlg.dismiss();
                }


                // 커스텀 다이얼로그를 종료한다.



            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "취소 했습니다.", Toast.LENGTH_SHORT).show();

                // 커스텀 다이얼로그를 종료한다.
                dlg.dismiss();
            }
        });
    }


    //회원가입
    public void regitser(){

        // --------------------유저 DB 등록 시작--------------------
        final int roomNum = num;
        String room_intoID = id;

        // 특정요청후 리스너에서 원하는 결과값을 다룰 수 있게 함
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonResponse = new JSONObject(response);  // 결과를 담을 수 있게 함
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                        CustomDialogSucces customDialog = new CustomDialogSucces(context);

                        // 커스텀 다이얼로그를 호출한다.
                        // 커스텀 다이얼로그의 결과를 출력할 TextView를 매개변수로 같이 넘겨준다.
                        customDialog.callFunction();

                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
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

        IntoRoomRequest registerRequest = new IntoRoomRequest(roomNum, room_intoID,responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------


    }




}
