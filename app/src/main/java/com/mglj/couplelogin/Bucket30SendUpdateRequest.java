package com.mglj.couplelogin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Bucket30SendUpdateRequest extends StringRequest {

    final static private String URL = "https://tlsalsrn1.cafe24.com/Couple_bucket30_send_update.php";
    private Map<String, String> parameters;

    public Bucket30SendUpdateRequest(String self50ID, String self50Answer1, String self50Answer2, String self50Answer3, String self50Answer4, String self50Answer5, String self50Answer6, String self50Answer7,
                                  String self50Answer8, String self50Answer9, String self50Answer10, String self50Answer11, String self50Answer12, String self50Answer13,
                                  String self50Answer14, String self50Answer15, String self50Answer16, String self50Answer17,
                                  String self50Answer18, String self50Answer19, String self50Answer20, String self50Answer21, String self50Answer22, String self50Answer23,
                                  String self50Answer24, String self50Answer25, String self50Answer26, String self50Answer27,
                                  String self50Answer28, String self50Answer29, String self50Answer30, Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put( "bucket30ID",self50ID);
        parameters.put( "bucket30Answer1",self50Answer1);
        parameters.put( "bucket30Answer2",self50Answer2);
        parameters.put( "bucket30Answer3",self50Answer3);
        parameters.put( "bucket30Answer4",self50Answer4);
        parameters.put( "bucket30Answer5",self50Answer5);
        parameters.put( "bucket30Answer6",self50Answer6);
        parameters.put( "bucket30Answer7",self50Answer7);
        parameters.put( "bucket30Answer8",self50Answer8);
        parameters.put( "bucket30Answer9",self50Answer9);
        parameters.put( "bucket30Answer10",self50Answer10);
        parameters.put( "bucket30Answer11",self50Answer11);
        parameters.put( "bucket30Answer12",self50Answer12);
        parameters.put( "bucket30Answer13",self50Answer13);
        parameters.put( "bucket30Answer14",self50Answer14);
        parameters.put( "bucket30Answer15",self50Answer15);
        parameters.put( "bucket30Answer16",self50Answer16);
        parameters.put( "bucket30Answer17",self50Answer17);
        parameters.put( "bucket30Answer18",self50Answer18);
        parameters.put( "bucket30Answer19",self50Answer19);
        parameters.put( "bucket30Answer20",self50Answer20);
        parameters.put( "bucket30Answer21",self50Answer21);
        parameters.put( "bucket30Answer22",self50Answer22);
        parameters.put( "bucket30Answer23",self50Answer23);
        parameters.put( "bucket30Answer24",self50Answer24);
        parameters.put( "bucket30Answer25",self50Answer25);
        parameters.put( "bucket30Answer26",self50Answer26);
        parameters.put( "bucket30Answer27",self50Answer27);
        parameters.put( "bucket30Answer28",self50Answer28);
        parameters.put( "bucket30Answer29",self50Answer29);
        parameters.put( "bucket30Answer30",self50Answer30);

    }
    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}





