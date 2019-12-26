package com.common.bean;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * 定义全局BaseController类使用推荐的 SLF4j 作日志处理
 * 其他 Controller 并继承实现*/
public class BaseController {
	
	protected final Logger loger = LoggerFactory.getLogger(getClass());
	
	//trace級別日志
	protected void trace(String msg){
		loger.trace(msg);
	}
	
	//debug級別日志
	protected void debug(String msg){
		loger.debug(msg);
	}
	
	//info級別日志
	protected void info(String msg){
		loger.info(msg);
	}
	
	//warn級別日志
	protected void warn(String msg){
		loger.warn(msg);
	}
	
	//error級別日志
	protected void error(String msg){
		loger.error(msg);
	}
	
	public static ResultData quickReturn(boolean ok){
		if(ok ) {
			return ResultData.success();
		}else {
			return ResultData.fail();
		}
	}
	
	public static ResultData quickReturn(int row){
		 return quickReturn(row > 0);
	}
	
	public static ResultData quickReturn(List list){
		if( list != null && list.size() >0 ) {
			return ResultData.success().setData(list);
		}else {
			return ResultData.fail().setData(list);
		}
	}
	
	
}
