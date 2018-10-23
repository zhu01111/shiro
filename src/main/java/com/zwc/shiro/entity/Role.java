/**
 * FileName:         Role.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月25日     上午10:02:37
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

/**
 * @ClassName:       Role
 * @author:          zhuWeichao
 * @date:            2018年9月25日        上午10:02:37
 */
@SuppressWarnings("serial")
public class Role implements Serializable{
	
	private Long id;
	
	private String role;
	
	/**
	 * @Title:            Role
	 * @param:            
	 * @throws
	 */
	public Role() {
		// TODO Auto-generated constructor stub
	}

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
	 * @Title:            getRole <BR>
	 * @return:           String <BR>
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @Title:          setRole <BR>
	 * @return:         String <BR>
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @Title:            Role
	 * @param:            @param id
	 * @param:            @param role
	 * @throws
	 */ 
	public Role(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
}
