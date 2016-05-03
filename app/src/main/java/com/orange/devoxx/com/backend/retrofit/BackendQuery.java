package com.orange.devoxx.com.backend.retrofit;

import com.google.gson.Gson;
import com.orange.devoxx.com.backend.beans.*;


/**
 * Created by xylome on 02/05/2016.
 */
public class BackendQuery {

    public static String login(String login, String password) {
        Gson gson = new Gson() ;
        return gson.toJson(new LoginQuery(login, password));
    }

}
