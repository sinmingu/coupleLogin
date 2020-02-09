package com.mglj.couplelogin;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Self50AddRequest extends StringRequest {

    final static private String URL = "https://tlsalsrn1.cafe24.com/Couple_self50_add.php";
    private Map<String, String> parameters;

    public Self50AddRequest(String self50ID, String self50Answer1, String self50Answer2, String self50Answer3,
                            String self50Answer4, String self50Answer5, String self50Answer6, String self50Answer7,
                            String self50Answer8, String self50Answer9, String self50Answer10, String self50Answer11, String self50Answer12, String self50Answer13,
                            String self50Answer14, String self50Answer15, String self50Answer16, String self50Answer17,
                            String self50Answer18, String self50Answer19, String self50Answer20, String self50Answer21, String self50Answer22, String self50Answer23,
                            String self50Answer24, String self50Answer25, String self50Answer26, String self50Answer27,
                            String self50Answer28, String self50Answer29, String self50Answer30, String self50Answer31, String self50Answer32, String self50Answer33,
                            String self50Answer34, String self50Answer35, String self50Answer36, String self50Answer37,
                            String self50Answer38, String self50Answer39, String self50Answer40, String self50Answer41, String self50Answer42, String self50Answer43,
                            String self50Answer44, String self50Answer45, String self50Answer46, String self50Answer47,
                            String self50Answer48, String self50Answer49, String self50Answer50,Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put( "self50ID",self50ID);
        parameters.put( "self50Answer1",self50Answer1);
        parameters.put( "self50Answer2",self50Answer2);
        parameters.put( "self50Answer3",self50Answer3);
        parameters.put( "self50Answer4",self50Answer4);
        parameters.put( "self50Answer5",self50Answer5);
        parameters.put( "self50Answer6",self50Answer6);
        parameters.put( "self50Answer7",self50Answer7);
        parameters.put( "self50Answer8",self50Answer8);
        parameters.put( "self50Answer9",self50Answer9);
        parameters.put( "self50Answer10",self50Answer10);
        parameters.put( "self50Answer11",self50Answer11);
        parameters.put( "self50Answer12",self50Answer12);
        parameters.put( "self50Answer13",self50Answer13);
        parameters.put( "self50Answer14",self50Answer14);
        parameters.put( "self50Answer15",self50Answer15);
        parameters.put( "self50Answer16",self50Answer16);
        parameters.put( "self50Answer17",self50Answer17);
        parameters.put( "self50Answer18",self50Answer18);
        parameters.put( "self50Answer19",self50Answer19);
        parameters.put( "self50Answer20",self50Answer20);
        parameters.put( "self50Answer21",self50Answer21);
        parameters.put( "self50Answer22",self50Answer22);
        parameters.put( "self50Answer23",self50Answer23);
        parameters.put( "self50Answer24",self50Answer24);
        parameters.put( "self50Answer25",self50Answer25);
        parameters.put( "self50Answer26",self50Answer26);
        parameters.put( "self50Answer27",self50Answer27);
        parameters.put( "self50Answer28",self50Answer28);
        parameters.put( "self50Answer29",self50Answer29);
        parameters.put( "self50Answer30",self50Answer30);
        parameters.put( "self50Answer31",self50Answer31);
        parameters.put( "self50Answer32",self50Answer32);
        parameters.put( "self50Answer33",self50Answer33);
        parameters.put( "self50Answer34",self50Answer34);
        parameters.put( "self50Answer35",self50Answer35);
        parameters.put( "self50Answer36",self50Answer36);
        parameters.put( "self50Answer37",self50Answer37);
        parameters.put( "self50Answer38",self50Answer38);
        parameters.put( "self50Answer39",self50Answer39);
        parameters.put( "self50Answer40",self50Answer40);
        parameters.put( "self50Answer41",self50Answer41);
        parameters.put( "self50Answer42",self50Answer42);
        parameters.put( "self50Answer43",self50Answer43);
        parameters.put( "self50Answer44",self50Answer44);
        parameters.put( "self50Answer45",self50Answer45);
        parameters.put( "self50Answer46",self50Answer46);
        parameters.put( "self50Answer47",self50Answer47);
        parameters.put( "self50Answer48",self50Answer48);
        parameters.put( "self50Answer49",self50Answer49);
        parameters.put( "self50Answer50",self50Answer50);

    }
    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}

