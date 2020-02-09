package com.mglj.couplelogin;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class IntoRoomRequest extends StringRequest {

    final static private String URL = "https://tlsalsrn1.cafe24.com/Couple_IntoRoom.php";
    private Map<String, String> parameters;

    public IntoRoomRequest(int roomNum, String room_intoID, Response.Listener<String> listener){

        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put( "roomNum",roomNum+"");
        parameters.put( "room_intoID",room_intoID);


    }
    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}

