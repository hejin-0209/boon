package com.boon.admin.filter;

import com.alibaba.fastjson.JSONObject;
import com.boon.admin.common.dto.LogMapper;
import com.boon.admin.common.dto.ResponseInfo;
import com.boon.admin.service.IUserService;
import com.boon.admin.service.LogService;
import com.boon.admin.service.TokenManager;
import com.boon.admin.utils.SpringUtil;
import com.boon.pojo.Logs;
import com.boon.pojo.User;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 退出<br>
 * web退出和restful方式退出<br>
 * 后者会删除缓存的token
 *
 *         2017年8月13日
 */
public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {

	private static final Logger log = LoggerFactory.getLogger("adminLogger");

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		String loginToken = RestfulFilter.getToken(request);
		System.out.println("登录的token是："+loginToken);
		String sno = RestfulFilter.getSno(request);
		IUserService userService = SpringUtil.getBean(IUserService.class);
		User user = userService.findBySno(sno);
		Logs logs = new Logs();

		System.out.println("要退出的用户是："+user.getName());
			TokenManager tokenManager = SpringUtil.getBean(TokenManager.class);
			boolean flag = tokenManager.deleteToken(loginToken);
			if (flag) {
				RestfulFilter.writeResponse(WebUtils.toHttp(response), HttpStatus.OK.value(), SUCCESS_INFO);
				log.debug("{}退出成功", user.getName());
			} else {
				RestfulFilter.writeResponse(WebUtils.toHttp(response), HttpStatus.BAD_REQUEST.value(), ERR_INFO);
			}
			logs.setUserSno(user.getSno());
			logs.setModule("用户退出");
			logs.setFlag(flag);
			logs.setRemark(null);
			SpringUtil.getBean(LogMapper.class).save(logs);
			return false;
	}

	private static String SUCCESS_INFO = JSONObject.toJSONString(new ResponseInfo(HttpStatus.OK.value() + "", "退出成功"));
	private static String ERR_INFO = JSONObject
			.toJSONString(new ResponseInfo(HttpStatus.BAD_REQUEST.value() + "", "退出失败,token不存在"));

}
