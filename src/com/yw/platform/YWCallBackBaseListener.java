package com.yw.platform;

import android.R.integer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.yw.platform.base.Constants;

public abstract class YWCallBackBaseListener {

	private static final String TAG = Constants.G_TAG + "YWCallBackBaseListener";
	private Handler mHandler;

	public YWCallBackBaseListener() {
		if(Looper.myLooper() != null){
			mHandler = new Handler(){

				@Override
				public void handleMessage(Message msg) {
					YWCallBackBaseListener.this.handleMessage(msg);
				}
			};
		}
	}

	public abstract void handleMessage(Message msg);
	
	public void sendMessage(Message msg){
        if(mHandler != null){
        	mHandler.sendMessage(msg);
        } else {
            handleMessage(msg);
        }
	}
	
	public void sendEmptyMessage(int what){
        Message msg = Message.obtain();
        msg.what = what;
        Log.i(TAG,"sendEmptyMessage");
		if(mHandler != null){
        	mHandler.sendEmptyMessage(what);
        } else {
            handleMessage(msg);
        }
	}
	
	public void sendEmptyMessageDelayed(int what,int delayMillis){
        Message msg = Message.obtain();
        msg.what = what;
        Log.i(TAG,"sendEmptyMessage");
		if(mHandler != null){
        	
        	mHandler.sendEmptyMessageDelayed(what, delayMillis);
        } else {
            handleMessage(msg);
        }
	}
}
