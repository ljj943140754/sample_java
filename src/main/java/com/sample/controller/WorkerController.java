package com.sample.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.bean.BaseController;
import com.common.bean.ResultData;
import com.common.utils.HttpSessionKey;
import com.github.pagehelper.PageHelper;
import com.sample.entity.Worker;
import com.sample.mapper.WorkerMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 予之文化传媒
 * @since 2019-12-24
 */
@RestController
@RequestMapping("/worker")
@Api("员工控制层")
public class WorkerController extends BaseController {
	@Autowired
	private WorkerMapper mapper;
	
	@ApiOperation("员工条件查询接口")
	@GetMapping("query.action")
	public ResultData conditionQuery(Worker wor) {
		info("员工条件查询" + wor);
		PageHelper.startPage(wor.getPageNum(), wor.getPageSize());
		return ResultData.success().setData(mapper.selectQuery(wor));
	}

	/*
	 * 默认传参其他根据需求： 账号随机生成不用参数
	 * wk_password: 默认给原始密码 123456 
	 * wk_type: worker 
	 * wk_isdel: 1
	 */
	@ApiOperation("员工添加接口")
	@PostMapping("add.action")
	public ResultData add(Worker wor) {
		info("员工添加接口" + wor);
		//随机生成账号
		wor.setWk_num(RandomStringUtils.random(12, false, true));
		return ResultData.success().setData(mapper.insert(wor));
	}

	/* 按需传参修改 */
	@ApiOperation("员工修改接口")
	@PostMapping("update.action")
	public ResultData update(Worker wor) {
		info("员工修改接口" + wor);
		return ResultData.success().setData(mapper.update(wor));
	}

	/* 主键id必传 */
	@ApiOperation("员工删除接口")
	@PostMapping("delete.action")
	public ResultData deleteByid(Worker wor) {
		info("员工删除接口" + wor);
		return ResultData.success().setData(mapper.delete(wor));
	}

	@ApiOperation("员工登陆接口")
	@PostMapping("login.action")
	public ResultData login(Worker wor, HttpSession ss) {
		info("员工登陆" + wor);
		Worker currentWor = (Worker) ss.getAttribute(HttpSessionKey.USER_SESSION_KEY.getCode());
		System.err.println("currentWor的id:" + ss.getId());
		if (currentWor != null) {
			return ResultData.success().setData(currentWor);
		}
		if (wor.getWk_num() == null) {
			System.err.println("账号不能为空");
			return ResultData.fail("账号不能为空");
		} else if (wor.getWk_password() == null) {
			System.err.println("密码不能为空");
			return ResultData.fail("密码不能为空");
		} else {
			Subject subject = SecurityUtils.getSubject();
			// 获取当前 Shiro 用户对象 封装 Shiro 用户的登陆数据
			UsernamePasswordToken token = new UsernamePasswordToken(wor.getWk_num(), wor.getWk_password());
			try {
				subject.login(token);
				// 此处 前端可以在 Session 中取，可以省略多查一次数据库，后期修改
				return ResultData.success("成功！").setData(mapper.login(wor));
			} catch (UnknownAccountException e) {
				return ResultData.fail("用户名/密码错误！");
			} catch (IncorrectCredentialsException e) {
				return ResultData.fail("密码错误！");
			}
		}
	}

	@PostMapping("logout.action")
	@ApiOperation("CMS 用户注销")
	public ResultData logout() {
		// 获取Shiro 的 subject 对象注销 session
		Subject subject = SecurityUtils.getSubject();
		// 获取 session 用于判断注销
		Session session = subject.getSession();
		if (session != null) {
			subject.logout();
			info("正在为您注销！");
		} else {
			info("您未登陆，无需注销");
		}
		return ResultData.success();
	}
	
	/*CMS检测是否已经登陆*/
	@ApiOperation("登陆检测")
	@GetMapping("checklogin.action")
	public ResultData checklogin(HttpSession ss) {
		Worker wor = (Worker) ss.getAttribute(HttpSessionKey.USER_SESSION_KEY.getCode());
		if (wor != null) {
			return ResultData.success().setData(wor);
		}
		return ResultData.fail();
	}
}
