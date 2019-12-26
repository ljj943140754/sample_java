package com.common.utils;

public enum HttpSessionKey {
	 
	USER_SESSION_KEY("sample_sys_user_login_key");
	 
	private String code;
	private HttpSessionKey(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
