package com.yw.platform.control;

import android.app.Activity;

import com.yw.platform.YWCallBackListener.OnExitListener;
import com.yw.platform.YWCallBackListener.OnInitializeListener;
import com.yw.platform.YWCallBackListener.OnLoginListener;
import com.yw.platform.YWCallBackListener.OnLogoutListener;
import com.yw.platform.YWCallBackListener.OnPayListener;
import com.yw.platform.YWCallBackListener.OnSwitchAccountListener;
import com.yw.platform.base.model.YWInitInfo;
import com.yw.platform.base.model.YWPayInfo;

public abstract class AllSDKControlCenter {

	/**
	 * 初始化
	 * 
	 * @param ctx
	 * @param appInfo
	 * @param flag
	 * @param listener
	 */
	public abstract void inital(Activity ctx, YWInitInfo appInfo,
			OnInitializeListener onInitializeListener);

	/***
	 * 登录
	 * 
	 * @param ctx
	 * @param extraParam
	 * @param loginListener
	 */
	public abstract void showLoginView(Activity ctx,
			OnLoginListener onLoginListener);

	/**
	 * 充值
	 * 
	 * @param ctx
	 * @param yWPayInfo
	 * @param onPayProcessListener
	 */
	public abstract void showChargePage(Activity ctx, YWPayInfo payInfo,
			OnPayListener onPayListener);

	/**
	 * 切换账号
	 * 
	 * @param ctx
	 * @param onSwitchAccountListener
	 */
	public abstract void onSwitch(Activity ctx,
			OnSwitchAccountListener onSwitchAccountListener);

	/**
	 * 注销账号
	 * 
	 * @param ctx
	 * @param onCallbackListener
	 */
	public abstract void logout(Activity ctx, OnLogoutListener onLogoutListener);

	/**
	 * 退出游戏
	 * 
	 * @param ctx
	 * @param flag
	 * @param onCallBackfunction
	 */
	public abstract void exit(Activity ctx, 
			OnExitListener onExitListener);
}
