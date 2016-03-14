package com.yw.platform.utils;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by chenshuide on 15/7/7.
 */
public class TlRequest extends Request<JSONObject> {
    public static final String TAG = "TlRequest";
    private TlListener mTlListener;
    private Map<String, String> mParams;
    private String mUrl;

    private TlRequest(int method, String url) {
        super(method, url, null);
    }


    public TlRequest(String url, Map<String, String> params, TlListener listener) {
        this(Method.POST, url);
        mTlListener = listener;
        mParams = params;
        mUrl = url;

    }


    public TlRequest(String url, TlListener listener) {
        this(Method.GET, url);
        mTlListener = listener;
        mUrl = url;
    }


    @Override
    public Map<String, String> getParams() {
        return mParams;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString =
                    new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            Log.e(TAG,"json= "+jsonString);
            return Response.success(new JSONObject(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }

    @Override
    protected void deliverResponse(JSONObject response) {
        Log.e(TAG, "url = " + mUrl + "   params = " + mParams + "   json = " + response.toString());
        if (mTlListener == null) {
            return;
        }


        mTlListener.onNetComplete();


        mTlListener.onNetSucc(mUrl, response);


    }

    @Override
    public void deliverError(VolleyError error) {
        if (mTlListener != null) {
            mTlListener.onNetComplete();
        }

        String errmsg = error.getMessage();
        if (error.networkResponse != null) {
            errmsg = errmsg + "  code= " + error.networkResponse.statusCode;
        }

        Log.e(TAG, "url = " + mUrl + "  params = " + mParams + "  errormsg = " + errmsg);
    }
}
