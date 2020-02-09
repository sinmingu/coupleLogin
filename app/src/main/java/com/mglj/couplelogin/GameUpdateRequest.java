package com.mglj.couplelogin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class GameUpdateRequest extends StringRequest {

    final static private String URL = "https://tlsalsrn1.cafe24.com/Couple_game_update.php";
    private Map<String, String> parameters;

    public GameUpdateRequest(String gameID, int gameCode, String gameAnswer1, String gameAnswer2, String gameAnswer3,
                          String gameAnswer4, String gameAnswer5, String gameAnswer6, String gameAnswer7, String gameAnswer8,
                          String gameAnswer9, String gameAnswer10, String gameAnswer11, String gameAnswer12, String gameAnswer13,
                          String gameAnswer14, String gameAnswer15, String gameAnswer16, String gameAnswer17,
                          String gameAnswer18, String gameAnswer19, String gameAnswer20, Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put( "gameID",gameID);
        parameters.put( "gameCode",gameCode+"");
        parameters.put( "gameAnswer1",gameAnswer1);
        parameters.put( "gameAnswer2",gameAnswer2);
        parameters.put( "gameAnswer3",gameAnswer3);
        parameters.put( "gameAnswer4",gameAnswer4);
        parameters.put( "gameAnswer5",gameAnswer5);
        parameters.put( "gameAnswer6",gameAnswer6);
        parameters.put( "gameAnswer7",gameAnswer7);
        parameters.put( "gameAnswer8",gameAnswer8);
        parameters.put( "gameAnswer9",gameAnswer9);
        parameters.put( "gameAnswer10",gameAnswer10);
        parameters.put( "gameAnswer11",gameAnswer11);
        parameters.put( "gameAnswer12",gameAnswer12);
        parameters.put( "gameAnswer13",gameAnswer13);
        parameters.put( "gameAnswer14",gameAnswer14);
        parameters.put( "gameAnswer15",gameAnswer15);
        parameters.put( "gameAnswer16",gameAnswer16);
        parameters.put( "gameAnswer17",gameAnswer17);
        parameters.put( "gameAnswer18",gameAnswer18);
        parameters.put( "gameAnswer19",gameAnswer19);
        parameters.put( "gameAnswer20",gameAnswer20);


    }
    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}



