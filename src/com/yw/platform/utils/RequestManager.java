package com.yw.platform.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


/**
 * Created by chenshuide on 15/7/7.
 */
public class RequestManager {

    private static RequestManager instance;
    private RequestQueue mRequestQueue;


    private RequestManager(Context context) {
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }



    public static RequestManager getInstance(Context context){

        if (instance == null)
            instance = new RequestManager(context);

        return instance;
    }


    public <T> void addRequest(Request<T> request){
        getRequestQueue().add(request);
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}
