/**
 * FileName:         LoginController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月25日     上午10:13:47
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月25日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zwc.shiro.mapper.UserMapper;

/**
 * @ClassName:       LoginController
 * @author:          zhuWeichao
 * @date:            2018年9月25日        上午10:13:47
 */
@RestController
public class LoginController {
	Map<String, Object> resultMap = null;
	@Autowired
	private UserMapper userMapper;
	@RequestMapping(value = "/notLogin", method = RequestMethod.GET)
	 public Map<String, Object> notLogin() {
		resultMap = new HashMap<>();
		resultMap.put("message", "您尚未登陆！");
	 return resultMap;
	 }
	 @RequestMapping(value = "/notRole", method = RequestMethod.GET)
	 public Map<String, Object> notRole() {
		 resultMap = new HashMap<>();
			resultMap.put("message", "您没有权限");
	 return resultMap;
	 }
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	 public Map<String, Object> logout() {
	 Subject subject = SecurityUtils.getSubject();
	 //注销
	 subject.logout();
	 resultMap = new HashMap<>();
	 resultMap.put("message", "成功注销");
	 return resultMap;
	 }
	 
	 /**
	  * 登陆
	  *
	  * @param username 用户名
	  * @param password 密码
	  */
	  @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public Map<String, Object> login(String username, String password) {
		  resultMap = new HashMap<>();
	  // 从SecurityUtils里边创建一个 subject
	  Subject subject = SecurityUtils.getSubject();
	  // 在认证提交前准备 token（令牌）
	  UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	  // 执行认证登陆
	  subject.login(token);
	  //根据权限，指定返回数据
	  String role = userMapper.getRole(username);
	  if ("1".equals(role)) {
		  resultMap.put("message", "欢迎登陆");
		  return resultMap;
	  }
	  if ("2".equals(role)) {
		  resultMap.put("message", "欢迎来到管理员页面");
		  return resultMap;
	  } 
		  resultMap.put("message", "权限错误！");
		  return resultMap;
	  }
}
