package com.mglj.couplelogin;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.mglj.couplelogin.R;

public class CustomDialogSex {

    private Context context;

    public CustomDialogSex(Context context) {
        this.context = context;
    }

    // 호출할 다이얼로그 함수를 정의한다.
    public void callFunction(final TextView edit_today_walk) {

        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.custom_dialog_sex);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        final CheckBox pet_sex1 = (CheckBox) dlg.findViewById(R.id.pet_sex1);
        final CheckBox pet_sex2 = (CheckBox) dlg.findViewById(R.id.pet_sex2);

        final Button okButton = (Button) dlg.findViewById(R.id.okButton);
        final Button cancelButton = (Button) dlg.findViewById(R.id.cancelButton);

        pet_sex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pet_sex2.setChecked(false);
            }
        });

        pet_sex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pet_sex1.setChecked(false);
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // '확인' 버튼 클릭시 메인 액티비티에서 설정한 main_label에
                // 커스텀 다이얼로그에서 입력한 메시지를 대입한다.

                if(pet_sex1.isChecked())
                    edit_today_walk.setText("남자");
                else if(pet_sex2.isChecked())
                    edit_today_walk.setText("여자");

                // 커스텀 다이얼로그를 종료한다.
                dlg.dismiss();
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

}

