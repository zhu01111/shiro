/**
 * FileName:         UserService.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月25日     上午11:20:29
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月25日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.service;

/**
 * @ClassName:       UserService
 * @author:          zhuWeichao
 * @date:            2018年9月25日        上午11:20:29
 */
public interface UserService {
	
	String getPassword(String username);
	
	String getRole(String username);
}