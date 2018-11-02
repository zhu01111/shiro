/**
 * FileName:         MySessionManager.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年10月25日     下午1:59:54
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


import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;


/**
 * @ClassName:       MySessionManager
 * @author:          zhuWeichao
 * @date:            2018年10月25日        下午1:59:54
 */
public class MySessionManager extends DefaultWebSessionManager {
	
	private static final String AUTHORIZATION = "Authorization";
	 
    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
 
    public MySessionManager() {
        super();
    }
 
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        //如果请求头中有 Authorization 则其值为sessionId
        if (!StringUtils.isEmpty(id)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        } else {
            //否则按默认规则从cookie取sessionId
            return super.getSessionId(request, response);
        }
    }


}
