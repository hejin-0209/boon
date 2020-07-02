package com.boon.admin.utils;

import com.boon.admin.constants.UserConstants;
import com.boon.pojo.Right;
import com.boon.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.text.DecimalFormat;
import java.util.List;

public class UserUtil {

	public static User getCurrentUser() {
		User user = (User) getSession().getAttribute(UserConstants.LOGIN_USER);

		return user;
	}

	public static void setUserSession(User user) {
		getSession().setAttribute(UserConstants.LOGIN_USER, user);
	}

	@SuppressWarnings("unchecked")
	public static List<Right> getCurrentPermissions() {
		List<Right> list = (List<Right>) getSession().getAttribute(UserConstants.USER_PERMISSIONS);

		return list;
	}

	public static void setPermissionSession(List<Right> list) {
		getSession().setAttribute(UserConstants.USER_PERMISSIONS, list);
	}

	public static Session getSession() {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();

		return session;
	}

	public static boolean isChinese(String input){
		return input.matches("^[\u4e00-\u9fa5]+$");
	}


	public static Double trim(Double num){
		DecimalFormat df = new DecimalFormat("#.00");
		String s = df.format(num);
		return Double.valueOf(s);
	}
}
