/**
 * FileName:         UserController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月25日     上午10:11:00
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
 * @ClassName:       UserController
 * @author:          zhuWeichao
 * @date:            2018年9月25日        上午10:11:00
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	Map<String, Object> resultMap = null;
	
	 @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
	 public Map<String, Object> submitLogin() {
		 	resultMap = new HashMap<>();
			resultMap.put("message", "您拥有用户权限，可以获得该接口的信息！");
	 return resultMap;
	 }
}
