/**
 * FileName:         GuestController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月25日     上午10:05:48
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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:       GuestController
 * @author:          zhuWeichao
 * @date:            2018年9月25日        上午10:05:48
 */
@RestController
@RequestMapping("/guest")
public class GuestController {
	
	Map<String, Object> resultMap = null;
	
	@RequestMapping(value = "/enter", method = RequestMethod.GET)
	 public Map<String, Object> login() {
			resultMap = new HashMap<>();
			resultMap.put("message", "欢迎进入，您的身份是游客");
		return resultMap;
	 }
	 @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
	 public Map<String, Object> submitLogin() {
		 	resultMap = new HashMap<>();
			resultMap.put("message", "您拥有获得该接口的信息的权限！");
	 return resultMap;
	 }
}
