/**
 * FileName:         ShiroConfig.java
 * @author:          zhuWeichao
 * @version            V1.0
 * Createdate:      2018年9月25日     上午9:46:16
 * Copyright:        Copyright(C) 2018
 * Company           CY.
 * All rights Reserved, Designed By zhuWeichao

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018年9月25日     zhuWeichao       1.0             1.0

 * Why & What is modified:

 */
package com.zwc.shiro.config;

import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
/**
 * @ClassName:       ShiroConfig
 * @author:          zhuWeichao
 * @date:            2018年9月25日        上午9:46:16
 */
@Configuration
public class ShiroConfig {
	
	@Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;
   // @Value("${spring.redis.password}")
    //private String password;

	
	
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		 ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		 // 必须设置 SecurityManager
		 shiroFilterFactoryBean.setSecurityManager(securityManager);
		 // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
		 //shiroFilterFactoryBean.setLoginUrl("/");
		 // 设置无权限时跳转的 url;
		 shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
		 // 设置拦截器
		 Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
		 //游客，开发权限
		 filterChainDefinitionMap.put("/guest/**", "anon");
		 //用户，需要角色权限 “1:user”
		 filterChainDefinitionMap.put("/user/**", "roles[1]");
		 //管理员，需要角色权限 “2:admin”
		 filterChainDefinitionMap.put("/admin/**", "roles[2]");
		 //开放登陆接口
		 filterChainDefinitionMap.put("/login", "anon");
		 //默认首页
		 filterChainDefinitionMap.put("/", "anon");
		 //html页面
		 filterChainDefinitionMap.put("/page/**", "anon");
		 
		 filterChainDefinitionMap.put("/static/**", "anon");
		 
		 filterChainDefinitionMap.put("/jquery/**", "anon");
		 
		 filterChainDefinitionMap.put("/logout", "logout");
		 
		 //shiroFilterFactoryBean.setLoginUrl("/unauth");
		 //其余接口一律拦截
		 //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
		 filterChainDefinitionMap.put("/**", "authc");
		 shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		 System.out.println("Shiro拦截器工厂类注入成功");
		 return shiroFilterFactoryBean;
	}
	
	 @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }

	
	
	@Bean
	 public SecurityManager securityManager() {
	 DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
	 // 设置realm.
	 securityManager.setRealm(customRealm());
	 // 自定义session管理 使用redis
     securityManager.setSessionManager(sessionManager());
     // 自定义缓存实现 使用redis	 
     securityManager.setCacheManager(cacheManager());
	 return securityManager;
	 }
	//自定义sessionManager
    @Bean
    public SessionManager sessionManager() {
        MySessionManager mySessionManager = new MySessionManager();
        mySessionManager.setSessionDAO(redisSessionDAO());
        return mySessionManager;

    }
    /**
     * cacheManager 缓存 redis实现
     * <p>
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }
    /**
     * 配置shiro redisManager
     * <p>
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setExpire(1800);// 配置缓存过期时间
        redisManager.setTimeout(timeout);
       // redisManager.setPassword(password);
        return redisManager;
    }
    
    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * <p>
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    
	/**
	 * 自定义身份认证 realm;
	 * <p>
	 * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm，
	 * 否则会影响 CustomRealm类 中其他类的依赖注入
	 */
	 @Bean
	 public CustomRealm customRealm() {
		 CustomRealm myShiroRealm = new CustomRealm();
		 	//myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		 return myShiroRealm;
	 }
	 
	 /**
	     * 开启shiro aop注解支持.
	     * 使用代理方式;所以需要开启代码支持;
	     *
	     * @param securityManager
	     * @return
	     */
	    @Bean
	    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
	        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
	        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
	        return authorizationAttributeSourceAdvisor;
	    }
	    /**
	     * 注册全局异常处理
	     * @return
	     */
	    @Bean(name = "exceptionHandler")
	    public HandlerExceptionResolver handlerExceptionResolver() {
	        return new MyExceptionHandler();
	    }

}
