package com.yw.platform.base.model;

import android.content.Context;

public class YWInitInfo {
	public String packageName;
	private Context ctx;
	private String appId;
	private String appKey;
	private String platformId;
	private String privateKey;
	private String publicKey;
	private String cpId;
	private int orientation;
	public String sessionUrl;
	public String serverName;
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getSessionUrl() {
		return sessionUrl;
	}
	public void setSessionUrl(String sessionUrl) {
		this.sessionUrl = sessionUrl;
	}
	public int getOrientation() {
		return orientation;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	private int gameVersion;
	private String channelId;
	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
	public String siteId; 
	private int gameId;
	private int serverId;
	private String gameName;
	public String md5Key;
	public String rsaKey;
	
	public String getRsaKey() {
		return rsaKey;
	}
	public void setRsaKey(String rsaKey) {
		this.rsaKey = rsaKey;
	}
	public String getMd5Key() {
		return md5Key;
	}
	public void setMd5Key(String md5Key) {
		this.md5Key = md5Key;
	}
	
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	private String secretkey;
	

	public String getSecretkey() {
		return secretkey;
	}

	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}

	public String getCpId() {
		return cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Context getCtx() {
		return ctx;
	}
	
	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	/**
	 * @return the gameVersion
	 */
	public int getGameVersion() {
		return gameVersion;
	}

	/**
	 * @param gameVersion the gameVersion to set
	 */
	public void setGameVersion(int gameVersion) {
		this.gameVersion = gameVersion;
	}
}
