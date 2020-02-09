package com.mglj.couplelogin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RoomAddRequest extends StringRequest {

    final static private String URL = "https://tlsalsrn1.cafe24.com/Couple_addRoom.php";
    private Map<String, String> parameters;

    public RoomAddRequest(String roomName, String roomPass, String room_makeID, Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put( "roomName",roomName);
        parameters.put( "roomPass",roomPass);
        parameters.put( "room_makeID",room_makeID);

    }
    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
