package com.sample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.bean.BaseController;
import com.common.bean.ResultData;
import com.github.pagehelper.PageHelper;
import com.sample.entity.Qr_code;
import com.sample.mapper.Qr_codeMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  二维码 前端控制器
 * </p>
 *
 * @author 予之文化传媒
 * @since 2019-12-24
 */
@RestController
@RequestMapping("/qr_code")
@Api("二维码控制层")
public class Qr_codeController extends BaseController{
	@Autowired
	private Qr_codeMapper mapper;
	
	@ApiOperation("二维码条件查询接口")
	@GetMapping("query.action")
	public ResultData conditionQuery(Qr_code qr){
		info("二维码条件查询："+qr);
		//分类查询分页实现
		PageHelper.startPage(qr.getPageNum(), qr.getPageSize());
		return ResultData.success().setData(mapper.selectQuery(qr));
	}
	
	/*默认传参其他根据需求：*/
	@ApiOperation("二维码添加接口")
	@PostMapping("add.action")
	public ResultData add(Qr_code qr){
		info("二维码添加接口"+qr);
		return ResultData.success().setData(mapper.insert(qr));
	}
	
	/*按需传参修改*/
	@ApiOperation("二维码修改接口")
	@PostMapping("update.action")
	public ResultData update(Qr_code qr){
		info("二维码修改接口"+qr);
		return ResultData.success().setData(mapper.update(qr));
	}
	
	/*主键id必传*/
	@ApiOperation("二维码删除接口")
	@PostMapping("delete.action")
	public ResultData deleteByid(Qr_code qr){
		info("二维码删除接口"+qr);
		return ResultData.success().setData(mapper.delete(qr));
	}
}

