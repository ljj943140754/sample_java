package com.common.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.Filter;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.common.bean.MyRolesAuthorizationFilter;
import com.common.bean.MyShiroRealm;

@Configuration
public class ShiroConfig {
	
	/*1、注册自定义 myShiroRealm 的Bean*/
	@Bean(name="myShiroRealm")
	public MyShiroRealm myShiroRealm(){
		return new MyShiroRealm();
	}
	
	/*2、注入 DefaultWebSecurityManager 的 Bean 并把自定义 myShiroRealm关联*/
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myShiroRealm") MyShiroRealm myShiroRealm){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		/*关联 myShiroRealm*/
		securityManager.setRealm(myShiroRealm);
		return securityManager;
	}
	
	/*3、注入 ShiroFilterFactoryBean 的 Bean 并把自定义 securityManager 关联*/
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
		ShiroFilterFactoryBean bean= new ShiroFilterFactoryBean();
		/*设置安全管理器
		 * anon:	无需认证即可访问
		 * authc:	需要认证才可访问
		 * user:	点击“记住我”功能可访问
		 * perms:	拥有权限才可以访问
		 * roles:	拥有某个角色权限才能访问*/
		bean.setSecurityManager(securityManager);
		
		//添加自定义验证方法 注意：这个Filter继承javax.servlet.Filter
        Map<String, Filter> roleFilter=new HashMap<>();
        roleFilter.put("rolesOr",roleFilter());
        bean.setFilters(roleFilter);
        
		//拦截器;
		Map<String, String> filterMap = new LinkedHashMap<>();
		filterMap.put("/album/query.action", "anon");
		filterMap.put("/album/add.action", "roles,rolesOr[admin,worker,user]");
		filterMap.put("/album/update.action", "roles,rolesOr[admin,worker,user]");
		filterMap.put("/album/delete.action", "roles,rolesOr[admin,user]");
		filterMap.put("/photo/query.action", "anon");
		filterMap.put("/photo/add.action", "roles,rolesOr[admin,worker,user]");
		filterMap.put("/photo/update.action", "roles,rolesOr[admin,worker,user]");
		filterMap.put("/photo/delete.action", "roles,rolesOr[admin,worker,user]");
		filterMap.put("/classify/query.action", "anon");
		filterMap.put("/classify/add.action", "roles,rolesOr[admin,worker,user]");
		filterMap.put("/classify/update.action", "roles,rolesOr[admin,worker,user]");
		filterMap.put("/classify/delete.action", "roles,rolesOr[admin,worker,user]");
		filterMap.put("/qr_code/query.action", "anon");
		filterMap.put("/qr_code/add.action", "roles,rolesOr[admin,worker]");
		filterMap.put("/qr_code/update.action", "roles,rolesOr[admin,worker]");
		filterMap.put("/qr_code/delete.action", "roles,rolesOr[admin,worker]");
		filterMap.put("/upload/*", "authc");
		filterMap.put("/worker/query.action", "roles,rolesOr[admin]");
		filterMap.put("/worker/add.action", "roles,rolesOr[admin]");
		filterMap.put("/worker/update.action", "roles,rolesOr[admin]");
		filterMap.put("/worker/delete.action", "roles,rolesOr[admin]");
		//设置过滤器的链
		bean.setFilterChainDefinitionMap(filterMap);
		//设置登陆的默认请求路径
		bean.setLoginUrl("/toLogin");
		//设置未授权页面
		bean.setUnauthorizedUrl("/noAuth");
		return bean;
	}
	
		//注入自定义权限授权  MyRolesAuthorizationFilter 的 Bean 
	  @Bean
	    public MyRolesAuthorizationFilter roleFilter(){
	        MyRolesAuthorizationFilter roleFilter=new MyRolesAuthorizationFilter();
	        return roleFilter;
	    }
}
