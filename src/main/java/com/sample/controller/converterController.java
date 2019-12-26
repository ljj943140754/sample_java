package com.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.bean.ResultData;

/* 处理Shiro 跳转路由*/
@RestController
public class converterController {

	/*Shiro 拦截未登陆用户*/
	@GetMapping("toLogin")
	public ResultData toLogin(){
		System.err.println("未登陆，已被拦截！");
		return ResultData.fail("您未登陆!请先登陆！");
	}
	
	/*Shiro 拦截没权限用户*/
	@GetMapping("noAuth")
	public ResultData noAuth(){
		System.err.println("没有权限，已被拦截！");
		return ResultData.fail("您没有权限！请联系管理员...");
	}
}
