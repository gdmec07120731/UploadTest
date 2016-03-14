package com.yw.platform;

import com.yw.platform.base.model.YWBaseUserInfo;

import android.os.Handler;
import android.os.Message;

public class YWCallBackListener {

	public static OnLoginListener mOnLoginListener; // 登录回调

	public static OnPayListener mOnPayListener; // 支付结果通知

	public static OnLogoutListener mOnLogoutListener; // 注销
	public static OnLogoutListener mOnLogoutFormCenter; // 个人中心的注销
	public static OnLogoutListener mChangePasswordListener; // 修改密码

	public static OnExitListener mOnExitListener; // 退出平台的 回调函数

	public static OnLogoutListener mRegisterListener; // 注册

	public static OnInitializeListener mOnInitializeListener; // 初始化

	public static OnLogoutListener mOnShowDashboardListener; // 进入平台中心

	public static OnSwitchAccountListener mOnSwitchAccountListener; // 切换账号
	public static OnSwitchAccountListener mOnSwitchAccountFormCenter; // 个人中心的切换账号

	public static Handler mHandler;

	/**
	 * 初始化
	 * 
	 * @author Rc3
	 * 
	 */
	public static abstract class OnInitializeListener extends
			YWCallBackBaseListener {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			onComplete(msg.what);
		}

		public abstract void onComplete(int code);
	}

	/**
	 * 切换账号
	 * 
	 * @author Rc3
	 * 
	 */

	public static abstract class OnSwitchAccountListener extends
			YWCallBackBaseListener {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			onComplete(msg.what, (YWBaseUserInfo) msg.obj);
		}

		public abstract void onComplete(int code, YWBaseUserInfo userInfo);
	}


	/**
	 * 登录
	 * 
	 * @author Rc3
	 * 
	 */
	public static abstract class OnLoginListener extends YWCallBackBaseListener {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			onComplete(msg.what, (YWBaseUserInfo) msg.obj);
		}

		public abstract void onComplete(int code, YWBaseUserInfo userInfo);
	}

	/**
	 * 退出平台
	 * 
	 * @author Rc3
	 * 
	 */
	public static abstract class OnExitListener extends YWCallBackBaseListener {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			onComplete(msg.what);

		}

		public abstract void onComplete(int code);
	}

	/**
	 * 支付
	 * 
	 * @author Rc3
	 * 
	 */
	public static abstract class OnPayListener extends YWCallBackBaseListener {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			onComplete(msg.what);
		}

		public abstract void onComplete(int code);
	}

	/**
	 * 注销
	 * 
	 * @author Rc3
	 * 
	 */
	public static abstract class OnLogoutListener extends
			YWCallBackBaseListener {

		@Override
		public void handleMessage(Message msg) {
			onComplete(msg.what);
		}

		public abstract void onComplete(int code);
	}

}
