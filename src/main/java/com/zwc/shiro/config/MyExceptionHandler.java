/**
 * FileName:         MyExceptionHandler.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年10月25日     下午2:24:41
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年10月25日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.config;


import com.alibaba.fastjson.support.spring.FastJsonJsonView;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
 
/**
 * Created by Administrator on 2017/12/11.
 * 全局异常处理
 */
public class MyExceptionHandler implements HandlerExceptionResolver {
 
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
    	ModelAndView mv = new ModelAndView();
        FastJsonJsonView view = new FastJsonJsonView();
    	Map<String, Object> attributes = new HashMap<String, Object>();
        if (ex instanceof IncorrectCredentialsException) {
            attributes.put("code", "1000001");
            attributes.put("msg", "密码错误!");
        } else if (ex instanceof UnknownAccountException) {
            attributes.put("code", "1000002");
            attributes.put("msg", "用户不存在");
        } else if(ex instanceof LockedAccountException){
            attributes.put("code", "1000003");
            attributes.put("msg", "登录失败，该用户已被冻结");
        }else {
            attributes.put("code", "1000004");
            attributes.put("msg", ex.getMessage());
		}
        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }
}
