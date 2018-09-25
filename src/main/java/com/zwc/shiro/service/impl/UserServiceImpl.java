/**
 * FileName:         UserServiceImpl.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月25日     上午11:21:02
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月25日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwc.shiro.mapper.UserMapper;
import com.zwc.shiro.service.UserService;

/**
 * @ClassName:       UserServiceImpl
 * @author:          zhuWeichao
 * @date:            2018年9月25日        上午11:21:02
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * <p>Title: getPassword</p>
	 * @param username
	 * @return
	 * @see com.zwc.shiro.service.UserService#getPassword(java.lang.String)
	 */ 
	@Override
	public String getPassword(String username) {
		String password = userMapper.getPassword(username);
		return password;
	}

	/**
	 * <p>Title: getRole</p>
	 * @param username
	 * @return
	 * @see com.zwc.shiro.service.UserService#getRole(java.lang.String)
	 */ 
	@Override
	public String getRole(String username) {
		return userMapper.getRole(username);
	}

}
