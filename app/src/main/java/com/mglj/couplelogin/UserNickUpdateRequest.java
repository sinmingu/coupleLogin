package com.mglj.couplelogin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UserNickUpdateRequest extends StringRequest {

    final static private String URL = "https://tlsalsrn1.cafe24.com/Couple_userNick_update.php";
    private Map<String, String> parameters;

    public UserNickUpdateRequest(String userID, String userName, Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put( "userID",userID);
        parameters.put( "userName",userName);


    }
    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
