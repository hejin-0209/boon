package com.boon.admin.security;

import com.boon.admin.service.IUserService;
import com.boon.admin.utils.MD5Util;
import com.boon.admin.utils.UserUtil;
import com.boon.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * author:       HeJin
 * Date:         2020/3/7
 * version:      1.0
 * Description:  关于这个类的描述
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Autowired
    private IUserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String sno = usernamePasswordToken.getUsername();
        User user = userService.findBySno(sno);
        if (user == null) {
            throw new UnknownAccountException("用户名不存在");
        }

        if (!user.getPassword()
                .equals(MD5Util.passwordEncoder(new String(usernamePasswordToken.getPassword()), user.getName()+"salt"))) {
            throw new IncorrectCredentialsException("密码错误");
        }

        if (user.getState() != 1) {
            throw new IncorrectCredentialsException("无效状态，请联系管理员");
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
                ByteSource.Util.bytes(user.getName()+"salt"), getName());

        UserUtil.setUserSession(user);

        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.debug("权限配置");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = UserUtil.getCurrentUser();
        Set<String> roles = userService.findRoleNameByUserSno(user);
        authorizationInfo.setRoles(roles);
        Set<String> right = userService.findRightByUserSno(user);
        authorizationInfo.addStringPermissions(right);

        return authorizationInfo;
    }

    /**
     * 重写缓存key，否则集群下session共享时，会重复执行doGetAuthorizationInfo权限配置
     */
    @Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
        SimplePrincipalCollection principalCollection = (SimplePrincipalCollection) principals;
        Object object = principalCollection.getPrimaryPrincipal();

        if (object instanceof User) {
            User user = (User) object;

            return "authorization:cache:key:users:" + user.getSno();
        }

        return super.getAuthorizationCacheKey(principals);
    }

}
