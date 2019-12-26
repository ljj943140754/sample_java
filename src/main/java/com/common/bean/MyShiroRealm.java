package com.common.bean;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.utils.HttpSessionKey;
import com.sample.entity.Worker;
import com.sample.mapper.WorkerMapper;
/*
 * 自定义myShiroRealm 类继承AuthorizingRealm*/
public class MyShiroRealm extends AuthorizingRealm{
	@Autowired
	private WorkerMapper mapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
		System.err.println("执行了 => 授权 doGetAuthorizationInfo");
		// 获取 SimpleAuthorizationInfo 对象，用于设置权限
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获取到当前登陆的 Shiro 对象
		Subject subject = SecurityUtils.getSubject();
		Worker currentWor = (Worker)subject.getPrincipal();
		//设置当前用户权限
		info.addRole(currentWor.getWk_type());
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.err.println("执行了 => 认证 doGetAuthorizationInfo");
		//获取到 token 
		UsernamePasswordToken userToken=(UsernamePasswordToken)token;
		Worker wor=new Worker();
		//设置账号密码
		wor.setWk_num(String.valueOf(userToken.getUsername()));
		wor.setWk_password(String.valueOf(userToken.getPassword()));
		//查询数据库
		Worker login = mapper.login(wor);
		//数据库没有返回null 代表用户名或密码错误
		if(login==null){
			return null;
		}else{
			//获取到当前用户
			Subject currentWorker=SecurityUtils.getSubject();
			//设置Seesion 的值
			currentWorker.getSession().setAttribute(HttpSessionKey.USER_SESSION_KEY.getCode(), login);
			//Shiro 进行验证...
			return new SimpleAuthenticationInfo(login, wor.getWk_password(), "");
		}
	}

}
