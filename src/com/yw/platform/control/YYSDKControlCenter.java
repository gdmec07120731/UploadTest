package com.yw.platform.control;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import android.app.Activity;
import android.os.Message;

import com.yiyou.gamesdk.container.TTGameSDK;
import com.yiyou.gamesdk.outer.IOperateCallback;
import com.yiyou.gamesdk.outer.consts.TTCodeDef;
import com.yiyou.gamesdk.outer.model.ExInfo;
import com.yiyou.gamesdk.outer.model.GameParamInfo;
import com.yiyou.gamesdk.outer.model.OrderInfo;
import com.yiyou.gamesdk.outer.model.PaymentInfo;
import com.yiyou.gamesdk.outer.util.Log;
import com.yw.platform.YWCallBackListener;
import com.yw.platform.YWCallBackListener.OnExitListener;
import com.yw.platform.YWCallBackListener.OnInitializeListener;
import com.yw.platform.YWCallBackListener.OnLoginListener;
import com.yw.platform.YWCallBackListener.OnLogoutListener;
import com.yw.platform.YWCallBackListener.OnPayListener;
import com.yw.platform.YWCallBackListener.OnSwitchAccountListener;
import com.yw.platform.base.YWReturnCode;
import com.yw.platform.base.model.YWBaseUserInfo;
import com.yw.platform.base.model.YWInitInfo;
import com.yw.platform.base.model.YWPayInfo;
import com.yw.platform.utils.RequestManager;
import com.yw.platform.utils.TlListener;
import com.yw.platform.utils.TlRequest;

public class YYSDKControlCenter extends AllSDKControlCenter {

	private String session_url = null;
	private String game_id = null;
	private static YYSDKControlCenter mInstance;

	public static YYSDKControlCenter getInstance() {
		if (mInstance == null) {
			synchronized (YYSDKControlCenter.class) {
				if (mInstance == null) {
					mInstance = new YYSDKControlCenter();
				}

			}
		}
		return mInstance;

	}

	@Override
	public void inital(final Activity ctx, YWInitInfo appInfo,
			OnInitializeListener onInitializeListener) {
		// TODO Auto-generated method stub

		if (onInitializeListener == null)
			return;
		YWCallBackListener.mOnInitializeListener = onInitializeListener;
		GameParamInfo paramInfo = new GameParamInfo();
		paramInfo.setCpId(appInfo.getCpId());
		ExInfo exInfo = new ExInfo();
		exInfo.setCpServiceContact("");
		paramInfo.setExInfo(exInfo);
		if (0 != appInfo.getGameId())
			paramInfo.setGameId(appInfo.getGameId());
		if (0 != appInfo.getGameId())
			paramInfo.setServerId(appInfo.getServerId());
		if (null != appInfo.getServerName())
			paramInfo.setServerName(appInfo.getServerName());
		game_id = appInfo.getGameId() + "";
		session_url = appInfo.getSessionUrl();
		TTGameSDK.defaultSDK().initSDK(ctx, appInfo.getOrientation(),
				Log.LogLevel.Verbose, true, paramInfo,
				new IOperateCallback<String>() {

					@Override
					public void onResult(int i, String s) {
						// TODO Auto-generated method stub
						if (i == 0) {
							YWCallBackListener.mOnInitializeListener
									.sendEmptyMessage(YWReturnCode.YW_COM_PLATFORM_SUCCESS);
							TTGameSDK.defaultSDK().setLogoutNotifyListener(
									new IOperateCallback<String>() {

										@Override
										public void onResult(int code,
												String arg1) {
											// TODO Auto-generated method stub
											if (TTCodeDef.LOGOUT_NO_INIT == code
													|| TTCodeDef.LOGOUT_FAIL == code) {
												YWCallBackListener.mOnLogoutListener
														.sendEmptyMessage(YWReturnCode.YW_COM_PLATFORM_ERROR);
											} else if (TTCodeDef.LOGOUT_NO_LOGIN == code
													|| TTCodeDef.SUCCESS == code) {
												TTGameSDK
														.defaultSDK()
														.destroyFloatButton(ctx);
												YWCallBackListener.mOnLogoutListener
														.sendEmptyMessage(YWReturnCode.YW_COM_PLATFORM_SUCCESS);
											}
										}
									});
						}
					}
				});
	}

	@Override
	public void showLoginView(final Activity ctx,
			OnLoginListener onLoginListener) {
		// TODO Auto-generated method stub
		if (onLoginListener == null)
			return;
		YWCallBackListener.mOnLoginListener = onLoginListener;

		TTGameSDK.defaultSDK().login(ctx, new IOperateCallback<String>() {

			@Override
			public void onResult(int code, String resultData) {
				// TODO Auto-generated method stub
				if (code == TTCodeDef.SUCCESS) {
					Map<String, String> params = new TreeMap<String, String>();
					params.put("game_id", game_id);
					params.put("session_id", TTGameSDK.defaultSDK()
							.getSession());
					params.put("uid", TTGameSDK.defaultSDK().getUid() + "");
					TlRequest request = new TlRequest(session_url, params,
							new TlListener() {

								public void onNetSucc(String url,
										org.json.JSONObject result) {
									if (result == null)
										return;
									int code = result.optInt("code");

									if (code == 0) {

										YWBaseUserInfo info = new YWBaseUserInfo();
										info.setSessionId(TTGameSDK
												.defaultSDK().getSession());
										info.setUid(TTGameSDK.defaultSDK()
												.getUid() + "");
										Message msMessage = Message.obtain();
										msMessage.what = YWReturnCode.YW_COM_PLATFORM_SUCCESS;
										msMessage.obj = info;
										YWCallBackListener.mOnLoginListener
												.sendMessage(msMessage);
										TTGameSDK.defaultSDK()
												.createFloatButton(ctx);
									}

								};
							});

					RequestManager.getInstance(ctx).addRequest(request);
				}
			}
		}, "Login");
	}

	@Override
	public void showChargePage(Activity ctx, final YWPayInfo payInfo,
			OnPayListener onPayListener) {
		// TODO Auto-generated method stub
		if (onPayListener == null)
			return;
		YWCallBackListener.mOnPayListener = onPayListener;

		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setBody(payInfo.getProductDesc());
		paymentInfo.setCpFee(payInfo.getProductPrice());
		paymentInfo.setCpOrderId(payInfo.getOrderId());
		paymentInfo.setServerId(payInfo.getServerId());
		paymentInfo.setExInfo(payInfo.getExtraInfo());
		paymentInfo.setSubject(payInfo.getProductName());
		paymentInfo.setPayMethod(PaymentInfo.PAY_METHOD_ALL);
		paymentInfo.setCpCallbackUrl(payInfo.getNotifyUrl());
		paymentInfo.setChargeDate(new Date().getTime());
		TTGameSDK.defaultSDK().pay(paymentInfo, ctx,
				new IOperateCallback<OrderInfo>() {

					@Override
					public void onResult(int status, OrderInfo orderInfo) {
						// TODO Auto-generated method stub
						if (orderInfo == null)
							return;
						Map<String, String> params = new TreeMap<String, String>();
						params.put("partner_id", "1434314314");
						params.put("game_id", game_id);
						params.put("cp_order_id", orderInfo.getCpOrderId()); // CP订单号
						params.put("product_id", orderInfo.getSdkOrderId()); // 商品id
						params.put("total_price", orderInfo.getPayFee() + ""); // 支付金额
						params.put("session_id", TTGameSDK.defaultSDK()
								.getSession()); // 用户sid
						params.put("uid", TTGameSDK.defaultSDK().getUid() + ""); // 用户uid
						switch (status) {
						case -1:
							YWCallBackListener.mOnPayListener
									.sendEmptyMessage(YWReturnCode.YW_COM_PLATFORM_ERROR);
							break;
						case 0:
							YWCallBackListener.mOnPayListener
									.sendEmptyMessage(YWReturnCode.YW_COM_PLATFORM_SUCCESS);
							break;

						case 1:
							YWCallBackListener.mOnPayListener
									.sendEmptyMessage(YWReturnCode.YW_COM_PLATFORM_SUMMIT);
						default:
							YWCallBackListener.mOnPayListener
									.sendEmptyMessage(YWReturnCode.YW_COM_PLATFORM_ERROR);
							break;
						}

					}
				});

	}

	@Override
	public void onSwitch(Activity ctx,
			OnSwitchAccountListener onSwitchAccountListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logout(Activity ctx, OnLogoutListener onLogoutListener) {
		// TODO Auto-generated method stub
		if (onLogoutListener == null)
			return;
		YWCallBackListener.mOnLogoutListener = onLogoutListener;
		TTGameSDK.defaultSDK().logout();
	}

	@Override
	public void exit(Activity ctx, OnExitListener onExitListener) {
		// TODO Auto-generated method stub
		if (onExitListener == null)
			return;
		YWCallBackListener.mOnExitListener = onExitListener;
		TTGameSDK.defaultSDK().exitSDK(ctx, new IOperateCallback<String>() {
			@Override
			public void onResult(int i, String arg1) {
				// TODO Auto-generated method stub
                      if(i==TTCodeDef.SUCCESS){
                    	  YWCallBackListener.mOnExitListener.sendEmptyMessage(YWReturnCode.YW_COM_PLATFORM_SUCCESS);
                      }else{
                    	  
                    	  YWCallBackListener.mOnExitListener.sendEmptyMessage(YWReturnCode.YW_COM_PLATFORM_ERROR);
                      }
			}
		});
	}

	public void onResume(Activity act) {
		TTGameSDK.defaultSDK().createFloatButton(act);
	}

	public void onDestory(Activity act) {
		TTGameSDK.defaultSDK().destroyFloatButton(act);
	}

}
