package com.sample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.bean.BaseController;
import com.common.bean.ResultData;
import com.github.pagehelper.PageHelper;
import com.sample.entity.Photo;
import com.sample.mapper.PhotoMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 予之文化传媒
 * @since 2019-12-24
 */
@RestController
@RequestMapping("/photo")
@Api("图片控制层")
public class PhotoController extends BaseController{
	@Autowired
	private PhotoMapper mapper;
	
	@ApiOperation("图片条件查询接口")
	@GetMapping("query.action")
	public ResultData conditionQuery(Photo pho){
		info("图片条件查询"+pho);
		//分页功能
		PageHelper.startPage(pho.getPageNum(), pho.getPageSize());
		return ResultData.success().setData(mapper.selectQuery(pho));
	}
	
	/*默认传参其他根据需求：
	 * 	pho_type: 所属类型：1、照片2、视频
	 * 	pho_name: 不为空
	 *  pho_isdel: 默认参数 2*/
	@ApiOperation("图片添加接口")
	@PostMapping("add.action")
	public ResultData add(Photo pho){
		info("图片添加接口"+pho);
		return ResultData.success().setData(mapper.insert(pho));
	}
	
	/*按需传参修改*/
	@ApiOperation("图片修改接口")
	@PostMapping("update.action")
	public ResultData update(Photo pho){
		info("图片修改接口"+pho);
		return ResultData.success().setData(mapper.update(pho));
	}
	
	/*主键id必传*/
	@ApiOperation("图片删除接口")
	@PostMapping("delete.action")
	public ResultData deleteByid(Photo pho){
		info("图片删除接口"+pho);
		return ResultData.success().setData(mapper.delete(pho));
	}
}

