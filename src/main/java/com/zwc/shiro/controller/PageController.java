/**
 * FileName:         PageController.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年10月19日     上午10:35:55
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年10月19日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName:       PageController
 * @author:          zhuWeichao
 * @date:            2018年10月19日        上午10:35:55
 */
@Controller
public class PageController {
	
	@RequestMapping("/")
	public String pageIndex() {
		return "login";
	}
	
	@RequestMapping("/console/{page}")
	public String page(@PathVariable("page") String page) {
		return "page/"+page;
	}
}
