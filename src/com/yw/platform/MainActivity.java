package com.yw.platform;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.sdkdemo.R;
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

public class MainActivity extends Activity {

	private Activity ctx;

	private YWPayInfo pInfo = new YWPayInfo();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);

		this.ctx = this;

	}

	public void OnButtonClick(View view) {
		int id = view.getId();
		if (id == R.id.init) {
			YWInitInfo info = new YWInitInfo();
			info.setPlatformId("yy");// 初始化
			info.setCpId("G100");
			info.setGameId(1000);
			info.setServerId(2);
			info.setServerName("aaa");
			info.setOrientation(Configuration.ORIENTATION_PORTRAIT);
			info.setSessionUrl("http://120.132.68.148/im-server/check.jsp");

			YWCommPlatform.getInstance().initialize(ctx, info,
					new OnInitializeListener() {

						@Override
						public void onComplete(int status) {
							// TODO Auto-generated method stub
							if (status == YWReturnCode.YW_COM_PLATFORM_SUCCESS) {
								Log.i("init", "success");
								Toast.makeText(ctx, "初始化成功", Toast.LENGTH_SHORT)
										.show();

							}
						}
					});
		} else if (id == R.id.login) {
			YWCommPlatform.getInstance().showLoginView(ctx,
					new OnLoginListener() {

						@Override
						public void onComplete(int code, YWBaseUserInfo userInfo) {
							// TODO Auto-generated method stub
							if (code == YWReturnCode.YW_COM_PLATFORM_SUCCESS) {

								Log.i("login",
										userInfo.getUid() + ","
												+ userInfo.getUid() + ","
												+ userInfo.getToken());
								Toast.makeText(ctx, "登录成功", Toast.LENGTH_SHORT)
										.show();

							} else if (code == YWReturnCode.YW_COM_PLATFORM_CANCEL) {

								Log.i("login", "cancel");
							} else {
								Log.i("login", "error");

							}
						}

					});
		} else if (id == R.id.charge) {
			// 支付前设置参数

			pInfo.setProductDesc("xx");
			pInfo.setProductPrice(1);// 元
			pInfo.setOrderId(System.currentTimeMillis() + "");
			pInfo.setServerId("a");
			pInfo.setExtraInfo("x");
			pInfo.setProductName("name");
			pInfo.setNotifyUrl("http://120.132.68.148/game/rest/mock/callback.shtml");

			YWCommPlatform.getInstance().showChargePage(ctx, pInfo,
					new OnPayListener() {

						@Override
						public void onComplete(int code) {
							// TODO Auto-generated method stub
							if (code == YWReturnCode.YW_COM_PLATFORM_SUCCESS) {
								Log.i("pay", "sucess");

							} else {
								Toast.makeText(ctx, "pay error",
										Toast.LENGTH_SHORT).show();
							}

						}

					});
		} else if (id == R.id.logout) {
			YWCommPlatform.getInstance().logout(ctx, new OnLogoutListener() {

				@Override
				public void onComplete(int code) {
					// TODO Auto-generated method stub
					if (code == YWReturnCode.YW_COM_PLATFORM_SUCCESS) {
						Log.i("logout", "success");
						Toast.makeText(ctx, "logout成功", Toast.LENGTH_SHORT)
								.show();
					} else {
						Log.i("logout", "error");
					}
				}

			});
		} else if (id == R.id.switchAccount) {
			YWCommPlatform.getInstance().switchAccount(ctx,
					new OnSwitchAccountListener() {

						@Override
						public void onComplete(int code, YWBaseUserInfo userInfo) {
							// TODO Auto-generated method stub
							if (code == YWReturnCode.YW_COM_PLATFORM_SUCCESS) {
								Log.i("login", userInfo.getUid() + ","
										+ userInfo.getUserName() + ","
										+ userInfo.getSessionId() + ","
										+ userInfo.getCheckUrl());
								Toast.makeText(ctx, "switch成功",
										Toast.LENGTH_SHORT).show();

							} else {

								Log.i("switch", "error");
							}
						}

					});

		} else if (id == R.id.exit) {

			YWCommPlatform.getInstance().exit(ctx, new OnExitListener() {

				@Override
				public void onComplete(int code) {
					// TODO Auto-generated method stub
					if (code == YWReturnCode.YW_COM_PLATFORM_SUCCESS) {
						Log.i("exit", "success");
					} else {
						Log.i("exit", "error");
					}
				}

			});
		} else {
		}
	}

	protected void onResume() {
		YWCommPlatform.getInstance().onResume(ctx);
		super.onResume();
	}

	protected void onDestory() {
		YWCommPlatform.getInstance().onDestory(ctx);
		super.onDestroy();

	}

}
