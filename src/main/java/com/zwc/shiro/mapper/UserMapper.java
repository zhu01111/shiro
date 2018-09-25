/**
 * FileName:         UserMapper.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月25日     上午9:53:48
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月25日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName:       UserMapper
 * @author:          zhuWeichao
 * @date:            2018年9月25日        上午9:53:48
 */
@Mapper
public interface UserMapper {
	
	@Select("select `password` from `user` where `username` = #{username}")	
	String getPassword(@Param("username") String username);
	
	@Select("select `role` from `user` where `username` = #{username}")
	String getRole(@Param("username") String username);
}
