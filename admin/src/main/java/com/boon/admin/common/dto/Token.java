package com.boon.admin.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Restful方式登陆token
 * 
 * @author 小威老师 xiaoweijiagou@163.com
 *
 *         2017年8月4日
 */

public class Token implements Serializable {

	private static final long serialVersionUID = 4043470238789599973L;

	private String token;

	/**
	 * 到期时间
	 */
	private Date expireTime;

	public Token(String token, Date expireTime) {
		super();
		this.token = token;
		this.expireTime = expireTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

}
