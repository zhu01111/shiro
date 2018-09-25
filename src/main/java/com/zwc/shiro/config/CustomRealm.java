/**
 * FileName:         CustomRealm.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月25日     上午9:51:55
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月25日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.config;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zwc.shiro.service.UserService;

/**
 * @ClassName:       CustomRealm
 * @author:          zhuWeichao
 * @date:            2018年9月25日        上午9:51:55
 */
@Component
public class CustomRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userMapper;
	
	/**
	 * 获取身份验证信息
	 * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
	 *
	 * @param authenticationToken 用户身份信息 token
	 * @return 返回封装了用户信息的 AuthenticationInfo 实例
	 */
	 @Override
	 protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
	 System.out.println("————身份认证方法————");
	 UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
	 // 从数据库获取对应用户名密码的用户
	 String password = userMapper.getPassword(token.getUsername());
	 if (null == password) {
		 throw new AccountException("用户名不正确");
	 } else if (!password.equals(new String((char[]) token.getCredentials()))) {
		 throw new AccountException("密码不正确");
	 }
	 return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
	 }
	 /**
	 * 获取授权信息
	 *
	 * @param principalCollection
	 * @return
	 */
	 @Override
	 protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
			 System.out.println("————权限认证————");
			 String username = (String) SecurityUtils.getSubject().getPrincipal();
			 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			 //获得该用户角色
			 String role = userMapper.getRole(username);
			 Set<String> set = new HashSet<>();
			 //需要将 role 封装到 Set 作为 info.setRoles() 的参数
			 set.add(role);
			 //设置该用户拥有的角色
			 info.setRoles(set);
		 return info;
	 }
}
