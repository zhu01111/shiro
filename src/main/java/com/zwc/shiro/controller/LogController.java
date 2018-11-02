/**
 * FileName:         LogController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年11月1日     下午3:12:20
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年11月1日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:       LogController
 * @author:          zhuWeichao
 * @date:            2018年11月1日        下午3:12:20
 */
@RestController
public class LogController {
	
	@RequestMapping("index")
	public String login(HttpSession session) {
		//session.setAttribute("2222", 222);
		System.err.println(session.getAttribute("2222"));
		return "aaaaaaaa";
	}
}
