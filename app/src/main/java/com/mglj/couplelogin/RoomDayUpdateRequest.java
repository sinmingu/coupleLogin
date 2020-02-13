package com.mglj.couplelogin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RoomDayUpdateRequest extends StringRequest {

    final static private String URL = "https://tlsalsrn1.cafe24.com/Couple_day_update.php";
    private Map<String, String> parameters;

    public RoomDayUpdateRequest(int roomNum, String roomDay, Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put( "roomNum",roomNum+"");
        parameters.put( "roomDay",roomDay);


    }
    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
