package com.sample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.bean.BaseController;
import com.common.bean.ResultData;
import com.github.pagehelper.PageHelper;
import com.sample.entity.Classify;
import com.sample.mapper.ClassifyMapper;

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
@RequestMapping("/classify")
@Api("分类控制层")
public class ClassifyController extends BaseController{
	@Autowired
	private ClassifyMapper mapper;
	
	@ApiOperation("分类条件查询接口")
	@GetMapping("query.action")
	public ResultData conditionQuery(Classify cls){
		info("分类条件查询"+cls);
		PageHelper.startPage(cls.getPageNum(), cls.getPageSize());
		return ResultData.success().setData(mapper.selectQuery(cls));
	}
	
	/*默认传参其他根据需求：
	 * 	cla_wor_id: 指向 worker表主键id (创建者id)
	 * 	cla_createdby: 创建者id
	 * 	cla_lastupdatedby: 最后更新人id
	 * 	cla_isdel: 3*/
	@ApiOperation("分类添加接口")
	@PostMapping("add.action")
	public ResultData add(Classify cls){
		info("分类添加接口"+cls);
		return ResultData.success().setData(mapper.insert(cls));
	}
	
	/*按需传参修改*/
	@ApiOperation("分类修改接口")
	@PostMapping("update.action")
	public ResultData update(Classify cls){
		info("分类修改接口"+cls);
		return ResultData.success().setData(mapper.update(cls));
	}
	
	/*主键id必传*/
	@ApiOperation("分类删除接口")
	@PostMapping("delete.action")
	public ResultData deleteByid(Classify cls){
		info("分类删除接口"+cls);
		return ResultData.success().setData(mapper.delete(cls));
	}

}

