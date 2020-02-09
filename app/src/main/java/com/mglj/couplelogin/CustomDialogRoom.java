package com.mglj.couplelogin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class CustomDialogRoom {

    EditText room_name,room_pw,room_re_pw;
    String userID;
    private Context context;

    public CustomDialogRoom(Context context) {
        this.context = context;
    }

    // 호출할 다이얼로그 함수를 정의한다.
    public void callFunction(final String userID2) {

        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.custom_dialog_room);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        userID = userID2;

        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        room_name = (EditText) dlg.findViewById(R.id.room_name);
        room_pw = (EditText) dlg.findViewById(R.id.room_pw);
        room_re_pw = (EditText) dlg.findViewById(R.id.room_re_pw);

        final Button okButton = (Button) dlg.findViewById(R.id.okButton);
        final Button cancelButton = (Button) dlg.findViewById(R.id.cancelButton);



        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // '확인' 버튼 클릭시 메인 액티비티에서 설정한 main_label에
                // 커스텀 다이얼로그에서 입력한 메시지를 대입한다.

                if(room_name.getText().toString().equals("")||room_pw.getText().toString().equals("")||room_re_pw.getText().toString().equals("")){
                    Toast.makeText(context,"공백이 있습니다",Toast.LENGTH_SHORT).show();
                }
                else if(!room_pw.getText().toString().equals(room_re_pw.getText().toString())){
                    Toast.makeText(context,"비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show();
                }
                else{
                    regitser();

                    // 커스텀 다이얼로그를 종료한다.
                    dlg.dismiss();
                }

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
        String roomName = room_name.getText().toString();
        String roomPass = room_pw.getText().toString();
        String room_makeID = userID;



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

        RoomAddRequest registerRequest = new RoomAddRequest(roomName, roomPass, room_makeID,responseListener);
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(registerRequest);

        // --------------------유저 DB 등록 끝--------------------


    }


}
