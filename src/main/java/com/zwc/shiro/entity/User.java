/**
 * FileName:         User.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月25日     上午10:00:22
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月25日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @ClassName:       User
 * @author:          zhuWeichao
 * @date:            2018年9月25日        上午10:00:22
 */
@SuppressWarnings("serial")
@Component
public class User implements Serializable{
	
	private Long id;
	
	private String username;
	
	private String password;
	
	private Long roleId;
	
	/**
	 * @Title:            getId <BR>
	 * @return:           Long <BR>
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @Title:          setId <BR>
	 * @return:         Long <BR>
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @Title:            getUsername <BR>
	 * @return:           String <BR>
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @Title:          setUsername <BR>
	 * @return:         String <BR>
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @Title:            getPassword <BR>
	 * @return:           String <BR>
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @Title:          setPassword <BR>
	 * @return:         String <BR>
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @Title:            User
	 * @param:            @param id
	 * @param:            @param username
	 * @param:            @param password
	 * @param:            @param role
	 * @throws
	 */ 
	public User(Long id, String username, String password, Long roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}
	
	/**
	 * @Title:            User
	 * @param:            
	 * @throws
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @Title:            getRoleId <BR>
	 * @return:           Long <BR>
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @Title:          setRoleId <BR>
	 * @return:         Long <BR>
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
