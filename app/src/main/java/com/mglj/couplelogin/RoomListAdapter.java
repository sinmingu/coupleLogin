package com.mglj.couplelogin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Response;
import org.json.JSONObject;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class RoomListAdapter extends BaseAdapter {

    private Context context;
    private List<Room> roomList;


    public RoomListAdapter(Context context, List<Room> roomList){
        this.context = context;
        this.roomList = roomList;

    }

    @Override
    public int getCount() {
        return roomList.size();
    }

    @Override
    public Object getItem(int i) {
        return roomList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.couple_room, null);
        final TextView room_name = (TextView)v.findViewById(R.id.room_name);
        TextView user_name = (TextView)v.findViewById(R.id.user_name);

        room_name.setText(roomList.get(i).getRoomName());
        user_name.setText(roomList.get(i).getRoom_makeID());

        v.setTag(roomList.get(i).getRoomName());

        Button deleteButton = (Button)v.findViewById(R.id.Delete_btn);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context,detail_room.class);
                intent.putExtra("name",roomList.get(i).getRoomName());
                intent.putExtra("userID", roomList.get(i).getRoom_makeID());
                intent.putExtra("number", roomList.get(i).getRoomNum());
                intent.putExtra("date",roomList.get(i).getRoomDate());
                intent.putExtra("pass",roomList.get(i).getRoomPass());
                context.startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK));




            }

        });

        return v;

    }





}
