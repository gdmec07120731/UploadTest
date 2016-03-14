package com.yw.platform.base.model;

/**
 * 用户登录后的基本信息
 * 
 * @author Administrator
 * 
 */
public class YWBaseUserInfo {

	private String uid;
	private String userName;
	private String sessionId;
	private String token;
	private String loginTime;
	private String sign;
	private String code;
	private String pwd;
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

	private String channelId;
	private String checkUrl;
    private String openid;
    private String iconurl;
    private String tag;
    private String desc;
    private String tagId;
    private String appId;
    private String channelKey;
    private String deviceType;
    private String imei;
    private String version;

	
	
	
	public YWBaseUserInfo(String uid, String userName, String sessionId
			) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.sessionId = sessionId;
		
	}
	public YWBaseUserInfo(String uid, String userName, String sessionId
			,String checkUrl) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.sessionId = sessionId;
		this.checkUrl=checkUrl;
		
	}
	public YWBaseUserInfo(String uid, String userName, String sessionId,
			String code, String pwd, String channelId) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.sessionId = sessionId;
		this.code = code;
		this.pwd = pwd;
		this.channelId = channelId;
	}
	
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getIconurl() {
		return iconurl;
	}
	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getChannelKey() {
		return channelKey;
	}
	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}
	public String getCheckUrl() {
		return checkUrl;
	}
	public void setCheckUrl(String checkUrl) {
		this.checkUrl = checkUrl;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public YWBaseUserInfo() {
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "YWBaseUserInfo [uid=" + uid + ", userName=" + userName
				+ ", sessionId=" + sessionId + ", token=" + token + "]";
	}
}
