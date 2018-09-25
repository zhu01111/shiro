/**
 * FileName:         ExceptionController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月25日     上午11:28:21
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

import org.apache.shiro.authc.AccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName:       ExceptionController
 * @author:          zhuWeichao
 * @date:            2018年9月25日        上午11:28:21
 */
@RestControllerAdvice
public class ExceptionController {
	
	Map<String, Object> resultMap = null;
	/**
	 * 捕获CustomRealm类里面thorw AccountException异常
	 * @Title:             handleShiroException
	 * @param:             @param ex
	 * @param:             @return   
	 * @return:            Map<String,Object>   
	 * @throws
	 */
	@ExceptionHandler(AccountException.class)
	 public Map<String, Object> handleShiroException(Exception ex) {
		resultMap = new HashMap<>();
		resultMap.put("message", ex.getMessage());		
		return resultMap;
	 }
}
