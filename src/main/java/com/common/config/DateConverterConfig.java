package com.common.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/*
 * 全局时间转换定义处理类
 * 作全局前端String 转换为 Date 
 * */
@Component
public class DateConverterConfig implements Converter<String,Date>{

	private static final List<String> formats=new ArrayList<String>(4);
	/*静态代码块，类加载而加载，切只加载一次
	 * 初始化数据*/
	static{
		formats.add("yyyy-MM");
		formats.add("yyyy-MM-dd");
		formats.add("yyyy-MM-dd hh:mm");
		formats.add("yyyy-MM-dd hh:mm:ss");
	}
	
	//实现Converter的转换方法调用自定义转换方法
	@Override
	public Date convert(String source) {
		String value=source.trim();
		if("".equals(value)){
			return null;
		}
		if(source.matches("^\\d{4}-\\d{1,2}$")){
			return parseDate(source,formats.get(0));
		}else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
			return parseDate(source,formats.get(1));
		}else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
			return parseDate(source,formats.get(2));
		}else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
			return parseDate(source,formats.get(3));
		}else{
			throw new IllegalArgumentException("格式错误： '" + source + "'");
		}
	}
	//定义时间转换方法
	public Date parseDate(String dateStr,String format){
		Date date=null;
		DateFormat dateformat = new SimpleDateFormat(format);
		try {
			date=dateformat.parse(dateStr);
		} catch (ParseException e) {
			System.err.println("时间转换出错！");
			e.printStackTrace();
		}
		return date;
	}
}
