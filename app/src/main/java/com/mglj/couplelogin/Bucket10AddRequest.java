package com.mglj.couplelogin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Bucket10AddRequest extends StringRequest {

    final static private String URL = "https://tlsalsrn1.cafe24.com/Couple_bucket10_add.php";
    private Map<String, String> parameters;

    public Bucket10AddRequest(String self50ID, String self50Answer1, String self50Answer2, String self50Answer3,
                            String self50Answer4, String self50Answer5, String self50Answer6, String self50Answer7,
                            String self50Answer8, String self50Answer9, String self50Answer10, Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put( "bucket10ID",self50ID);
        parameters.put( "bucket10Answer1",self50Answer1);
        parameters.put( "bucket10Answer2",self50Answer2);
        parameters.put( "bucket10Answer3",self50Answer3);
        parameters.put( "bucket10Answer4",self50Answer4);
        parameters.put( "bucket10Answer5",self50Answer5);
        parameters.put( "bucket10Answer6",self50Answer6);
        parameters.put( "bucket10Answer7",self50Answer7);
        parameters.put( "bucket10Answer8",self50Answer8);
        parameters.put( "bucket10Answer9",self50Answer9);
        parameters.put( "bucket10Answer10",self50Answer10);

    }
    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}


