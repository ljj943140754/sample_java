package com.sample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.bean.BaseController;
import com.common.bean.ResultData;
import com.github.pagehelper.PageHelper;
import com.sample.entity.Album;
import com.sample.mapper.AlbumMapper;

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
@RequestMapping("/album")
@Api("相册控制层")
public class AlbumController extends BaseController{
	@Autowired
	private AlbumMapper mapper;
	
	@ApiOperation("相册查询接口")
	@GetMapping("query.action")
	public ResultData conditionQuery(Album alb){
		info("相册条件查询："+alb);
		//分类查询分页实现
		PageHelper.startPage(alb.getPageNum(), alb.getPageSize());
		return ResultData.success().setData(mapper.selectQuery(alb));
	}
	
	/*默认传参其他根据需求：
	 * 	alb_wor_id: 创建者id
	 * 	alb_visible: 1
	 * 	alb_isdel: 3
	 *  alb_createdby 创建者id*/
	@ApiOperation("相册添加接口")
	@PostMapping("add.action")
	public ResultData add(Album alb){
		info("相册添加接口"+alb);
		return ResultData.success().setData(mapper.insert(alb));
	}
	
	/*按需传参修改*/
	@ApiOperation("相册修改接口")
	@PostMapping("update.action")
	public ResultData update(Album alb){
		info("相册修改接口"+alb);
		return ResultData.success().setData(mapper.update(alb));
	}
	
	/*主键id必传*/
	@ApiOperation("相册删除接口")
	@PostMapping("delete.action")
	public ResultData deleteByid(Album alb){
		info("相册删除接口"+alb);
		return ResultData.success().setData(mapper.delete(alb));
	}

}

