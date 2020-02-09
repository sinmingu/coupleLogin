package com.mglj.couplelogin;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class You100GiveUpdateRequest extends StringRequest {

    final static private String URL = "https://tlsalsrn1.cafe24.com/Couple_you100_give_update.php";
    private Map<String, String> parameters;

    public You100GiveUpdateRequest(String self50ID, String self50Answer1, String self50Answer2, String self50Answer3,
                                String self50Answer4, String self50Answer5, String self50Answer6, String self50Answer7,
                                String self50Answer8, String self50Answer9, String self50Answer10, String self50Answer11, String self50Answer12, String self50Answer13,
                                String self50Answer14, String self50Answer15, String self50Answer16, String self50Answer17,
                                String self50Answer18, String self50Answer19, String self50Answer20, String self50Answer21, String self50Answer22, String self50Answer23,
                                String self50Answer24, String self50Answer25, String self50Answer26, String self50Answer27,
                                String self50Answer28, String self50Answer29, String self50Answer30, String self50Answer31, String self50Answer32, String self50Answer33,
                                String self50Answer34, String self50Answer35, String self50Answer36, String self50Answer37,
                                String self50Answer38, String self50Answer39, String self50Answer40, String self50Answer41, String self50Answer42, String self50Answer43,
                                String self50Answer44, String self50Answer45, String self50Answer46, String self50Answer47,
                                String self50Answer48, String self50Answer49, String self50Answer50,
                                String self50Answer51, String self50Answer52, String self50Answer53,
                                String self50Answer54, String self50Answer55, String self50Answer56, String self50Answer57,
                                String self50Answer58, String self50Answer59, String self50Answer60,
                                String self50Answer61, String self50Answer62, String self50Answer63,
                                String self50Answer64, String self50Answer65, String self50Answer66, String self50Answer67,
                                String self50Answer68, String self50Answer69, String self50Answer70,
                                String self50Answer71, String self50Answer72, String self50Answer73,
                                String self50Answer74, String self50Answer75, String self50Answer76, String self50Answer77,
                                String self50Answer78, String self50Answer79, String self50Answer80,
                                String self50Answer81, String self50Answer82, String self50Answer83,
                                String self50Answer84, String self50Answer85, String self50Answer86, String self50Answer87,
                                String self50Answer88, String self50Answer89, String self50Answer90,
                                String self50Answer91, String self50Answer92, String self50Answer93,
                                String self50Answer94, String self50Answer95, String self50Answer96, String self50Answer97,
                                String self50Answer98, String self50Answer99, String self50Answer100, Response.Listener<String> listener){

        super(Request.Method.POST, URL, listener, null);
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
        parameters.put( "self50Answer51",self50Answer51);
        parameters.put( "self50Answer52",self50Answer52);
        parameters.put( "self50Answer53",self50Answer53);
        parameters.put( "self50Answer54",self50Answer54);
        parameters.put( "self50Answer55",self50Answer55);
        parameters.put( "self50Answer56",self50Answer56);
        parameters.put( "self50Answer57",self50Answer57);
        parameters.put( "self50Answer58",self50Answer58);
        parameters.put( "self50Answer59",self50Answer59);
        parameters.put( "self50Answer60",self50Answer60);
        parameters.put( "self50Answer61",self50Answer61);
        parameters.put( "self50Answer62",self50Answer62);
        parameters.put( "self50Answer63",self50Answer63);
        parameters.put( "self50Answer64",self50Answer64);
        parameters.put( "self50Answer65",self50Answer65);
        parameters.put( "self50Answer66",self50Answer66);
        parameters.put( "self50Answer67",self50Answer67);
        parameters.put( "self50Answer68",self50Answer68);
        parameters.put( "self50Answer69",self50Answer69);
        parameters.put( "self50Answer70",self50Answer70);
        parameters.put( "self50Answer71",self50Answer71);
        parameters.put( "self50Answer72",self50Answer72);
        parameters.put( "self50Answer73",self50Answer73);
        parameters.put( "self50Answer74",self50Answer74);
        parameters.put( "self50Answer75",self50Answer75);
        parameters.put( "self50Answer76",self50Answer76);
        parameters.put( "self50Answer77",self50Answer77);
        parameters.put( "self50Answer78",self50Answer78);
        parameters.put( "self50Answer79",self50Answer79);
        parameters.put( "self50Answer80",self50Answer80);
        parameters.put( "self50Answer81",self50Answer81);
        parameters.put( "self50Answer82",self50Answer82);
        parameters.put( "self50Answer83",self50Answer83);
        parameters.put( "self50Answer84",self50Answer84);
        parameters.put( "self50Answer85",self50Answer85);
        parameters.put( "self50Answer86",self50Answer86);
        parameters.put( "self50Answer87",self50Answer87);
        parameters.put( "self50Answer88",self50Answer88);
        parameters.put( "self50Answer89",self50Answer89);
        parameters.put( "self50Answer90",self50Answer90);
        parameters.put( "self50Answer91",self50Answer91);
        parameters.put( "self50Answer92",self50Answer92);
        parameters.put( "self50Answer93",self50Answer93);
        parameters.put( "self50Answer94",self50Answer94);
        parameters.put( "self50Answer95",self50Answer95);
        parameters.put( "self50Answer96",self50Answer96);
        parameters.put( "self50Answer97",self50Answer97);
        parameters.put( "self50Answer98",self50Answer98);
        parameters.put( "self50Answer99",self50Answer99);
        parameters.put( "self50Answer100",self50Answer100);

    }
    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}





