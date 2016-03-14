package com.yw.platform;

import android.app.Activity;
import android.content.Intent;

import com.yw.platform.YWCallBackListener.OnExitListener;
import com.yw.platform.YWCallBackListener.OnInitializeListener;
import com.yw.platform.YWCallBackListener.OnLoginListener;
import com.yw.platform.YWCallBackListener.OnLogoutListener;
import com.yw.platform.YWCallBackListener.OnPayListener;
import com.yw.platform.YWCallBackListener.OnSwitchAccountListener;
import com.yw.platform.base.model.YWInitInfo;
import com.yw.platform.base.model.YWPayInfo;
import com.yw.platform.control.YWControlCenter;

public class YWCommPlatform {
	/**
	 * 屏幕方向
	 */
	public static final int SCREEN_ORIENTATION_PORTRAIT = 0;
	public static final int SCREEN_ORIENTATION_LANDSCAPE = 1;
	public static final int SCREEN_ORIENTATION_AUTO = 2;

	public static int LOGOUT_TO_RESET_AUTO_LOGIN_CONFIG = 3; // 注销时清除自动登录
	public static int LOGOUT_TO_NON_RESET_AUTO_LOGIN_CONFIG = 4; // 注销时不清除自动登录

	private static YWCommPlatform commplatform = null;

	private YWCommPlatform() {

	}

	public static YWCommPlatform getInstance() {
		if (commplatform == null) {
			commplatform = new YWCommPlatform();
		}
		return commplatform;
	}

	/**
	 * 初始化
	 * 
	 * @param ctx
	 * @param info
	 * @param flag
	 */
	public void initialize(Activity ctx, YWInitInfo info,
			OnInitializeListener onInitializeListener) {
		YWControlCenter.getInstance().inital(ctx, info, onInitializeListener);
	}

	/**
	 * @param ctx
	 * @param extraParam
	 * @param loginListener
	 */
	public void showLoginView(Activity ctx, OnLoginListener loginListener) {
		YWControlCenter.getInstance().showLoginView(ctx, loginListener);
	}

	/**
	 * 退出
	 * 
	 * @param ctx
	 * @param flag
	 * @param onCallBackfunction
	 */
	public void exit(Activity ctx, OnExitListener onCallBackfunction) {
		YWControlCenter.getInstance().exit(ctx, onCallBackfunction);
	}

	public void logout(Activity ctx, OnLogoutListener onCallbackListener) {
		YWControlCenter.getInstance().logout(ctx, onCallbackListener);
	}
	public void logoutFromCenter(Activity ctx, OnLogoutListener onCallbackListener) {
		YWControlCenter.getInstance().logoutFromCenter(ctx, onCallbackListener);
	}

	/**
	 * @param ctx
	 * @param yWPayInfo
	 * @param price
	 * @param onPayProcessListener
	 */

	/**
	 * @param ctx
	 * @param yWPayInfo
	 * @param onPayProcessListener
	 */
	public void showChargePage(Activity ctx, YWPayInfo yWPayInfo,
			OnPayListener onPayProcessListener) {
		YWControlCenter.getInstance().showChargePage(ctx, yWPayInfo,
				onPayProcessListener);
	}

	public void switchAccount(Activity act,
			OnSwitchAccountListener onSwitchAccountListener) {
		// TODO Auto-generated method stub
		YWControlCenter.getInstance().onSwitch(act, onSwitchAccountListener);
	}
	
	public void switchAccountFromCenter(Activity act,
			OnSwitchAccountListener onSwitchAccountListener) {
		// TODO Auto-generated method stub
		YWControlCenter.getInstance().onSwitchFromCenter(act, onSwitchAccountListener);
	}


	public void onRestart(Activity act) {
		YWControlCenter.getInstance().onRestart(act);

	}

	public void onResume(Activity act) {

		YWControlCenter.getInstance().onResume(act);
	}

	public void onStop(Activity act) {

		YWControlCenter.getInstance().onStop(act);
	}

	public void onPause(Activity act) {

		YWControlCenter.getInstance().onPause(act);
	}

	public void updateData(Activity act, YWPayInfo payInfo) {

		YWControlCenter.getInstance().updateData(act, payInfo);
	}

	public void onCreate(Activity act) {
		YWControlCenter.getInstance().onCreate(act);
	}
	public void onNewIntent(Intent intent){
		YWControlCenter.getInstance().onNewIntent(intent);
	}
	public void onActivityResult(Activity act,int requestCode,int resultCode, Intent data){
		YWControlCenter.getInstance().onActivityResult(act, requestCode, resultCode, data);
		
	}
	public void onDestory(Activity ctx){
		YWControlCenter.getInstance().onDestory(ctx);
		
	}
	public void onConfigurationChanged(Activity ctx){
		YWControlCenter.getInstance().onConfigurationChanged(ctx);
		
	}
	public void onStart(Activity ctx){
		YWControlCenter.getInstance().onStart(ctx);
		
	}
}
