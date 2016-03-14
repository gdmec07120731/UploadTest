package com.yw.platform.base.model;

import java.util.ArrayList;

import android.content.Context;
import android.content.pm.ActivityInfo;

//br.class
public class YWBaseInfo {
	public static final String gVersion = "yaowan_V1.1";   //此SDK版本号 第一次发布
	
	public static int screenOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;   //屏幕方向 0-竖  1-横
	//切换账号时 是否游戏重启
	public static boolean gIsRestartWhenSwitchAccount = false;
	
	//退出平台时 支付是否完成回调过回调函数
	private static boolean gIsPayCallback = false;  //对应退出支付
	
	//退出平台时 支付是否完成回调过回调函数
   private static boolean gIsExitCallback = true;  //是否调用 退出平台回调函数
	
	public static String gAppId = "";       //appid
	
	public static String gAppKey = "";      //appKye
	
	public static String gPlatformId = ""; //平台标识
	
	//ucsdk配置开始
	public static String gCpId;
	
	public static int gGameId;
	
	public static int gServerId;
	
	public static boolean gDebugMode;
	
	//ucsdk配置结束
	
	
	public static Context gContext = null;   //全局 context
	
	public static String gIMSI = null;
	
	public static YWBaseUserInfo gUserInfo = null;
	
	public static ArrayList<String> gCookiesList =null;
	/**
	 * 设置支付请求  是否 回调
	 * @param isCallback
	 */
	public static void setIsPayCallback(boolean isCallback){
		gIsPayCallback = isCallback;
	}
	
	/**
	 * 获取支付请求是否被回调
	 * @return
	 */
	public static boolean isPayCallback(){
		return gIsPayCallback;
	}

	/**
	 * 设置支付请求  是否 回调
	 * @param isCallback
	 */
	public static void setIsExitCallback (boolean isCallback){
		gIsExitCallback = isCallback;
	}
	
	/**
	 * 获取支付请求是否被回调
	 * @return
	 */
	public static boolean isExitCallback (){
		return gIsExitCallback;
	}
}
