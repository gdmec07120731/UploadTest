package com.yw.platform.control;

import android.app.Activity;
import android.content.Intent;

import com.yw.platform.YWCallBackListener.OnExitListener;
import com.yw.platform.YWCallBackListener.OnInitializeListener;
import com.yw.platform.YWCallBackListener.OnLoginListener;
import com.yw.platform.YWCallBackListener.OnLogoutListener;
import com.yw.platform.YWCallBackListener.OnPayListener;
import com.yw.platform.YWCallBackListener.OnSwitchAccountListener;
import com.yw.platform.base.Constants;
import com.yw.platform.base.model.YWBaseInfo;
import com.yw.platform.base.model.YWInitInfo;
import com.yw.platform.base.model.YWPayInfo;

public class YWControlCenter {
	private static final String TAG = Constants.G_TAG + "YWControlCenter";

	private static YWControlCenter instance;

	private YWControlCenter() {
	}

	public static YWControlCenter getInstance() {
		if (instance == null)
			instance = new YWControlCenter();
		return instance;
	}

	/**
	 * 初始化 SDK
	 * 
	 * @param ctx
	 * @param appInfo
	 * @param flag
	 * @return
	 */
	public void inital(Activity ctx, YWInitInfo appInfo,
			OnInitializeListener listener) {

		YWBaseInfo.gAppId = appInfo.getAppId();
		YWBaseInfo.gAppKey = appInfo.getAppKey();
		YWBaseInfo.gContext = appInfo.getCtx();
		YWBaseInfo.gPlatformId = appInfo.getPlatformId();
		YWBaseInfo.gCpId = appInfo.getCpId();
		YWBaseInfo.gGameId = appInfo.getGameId();
		YWBaseInfo.gServerId = appInfo.getServerId();
		YWBaseInfo.gUserInfo = null;

		if ("yy".equals(YWBaseInfo.gPlatformId)) {
			YYSDKControlCenter.getInstance().inital(ctx, appInfo, listener);

		}
	}

	/**
	 * 登录
	 * 
	 * @param ctx
	 * @param info
	 * @param onInitializeListener
	 */
	public void showLoginView(Activity ctx, OnLoginListener loginListener) {

		if ("yy".equals(YWBaseInfo.gPlatformId)) {
			YYSDKControlCenter.getInstance().showLoginView(ctx, loginListener);
		}
	}

	/**
	 * 退出
	 * 
	 * @param ctx
	 * @param flag
	 * @param onCallBackfunction
	 */
	public void exit(Activity ctx, OnExitListener onExitListener) {
		if ("yy".equals(YWBaseInfo.gPlatformId)) {
			YYSDKControlCenter.getInstance().exit(ctx, onExitListener);
		}

	}

	/**
	 * 
	 * 
	 * @param ctx
	 * @param cooOrderSerial
	 * @param extraInfo
	 * @param serverId
	 * @param onPayProcessListener
	 */
	public void showChargePage(Activity ctx, YWPayInfo payInfo,
			OnPayListener onPayProcessListener) {
		// TODO Auto-generated method stub

		if ("yy".equals(YWBaseInfo.gPlatformId)) {
			YYSDKControlCenter.getInstance().showChargePage(ctx, payInfo,
					onPayProcessListener);
		}
	}

	public void logout(Activity ctx, OnLogoutListener onLogoutListener) {
		if ("yy".equals(YWBaseInfo.gPlatformId)) {

			YYSDKControlCenter.getInstance().logout(ctx, onLogoutListener);
		}

	}

	public void logoutFromCenter(Activity ctx, OnLogoutListener onLogoutListener) {

	}

	public void onSwitch(Activity act,
			OnSwitchAccountListener onSwitchAccountListener) {

	}

	public void onSwitchFromCenter(Activity act,
			OnSwitchAccountListener onSwitchAccountListener) {

	}

	public void onRestart(Activity act) {

	}

	public void onResume(Activity act) {
		if ("yy".equals(YWBaseInfo.gPlatformId)) {

			YYSDKControlCenter.getInstance().onResume(act);
		}

	}

	public void onStop(Activity act) {

	}

	public void onPause(Activity act) {

	}

	public void updateData(Activity act, YWPayInfo payInfo) {

	}

	public void onNewIntent(Intent intent) {

	}

	public void onActivityResult(Activity act, int requestCode, int resultCode,
			Intent data) {

	}

	public void onCreate(Activity act) {

	}

	public void onDestory(Activity ctx) {
		if ("yy".equals(YWBaseInfo.gPlatformId)) {

			YYSDKControlCenter.getInstance().onDestory(ctx);
		}

	}

	public void onConfigurationChanged(Activity ctx) {

	}

	public void onStart(Activity ctx) {

	}

}
