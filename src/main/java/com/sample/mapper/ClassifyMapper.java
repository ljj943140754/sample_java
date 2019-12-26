package com.sample.mapper;

import com.sample.entity.Classify;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  分类 Mapper 接口
 * </p>
 *
 * @author 予之文化传媒
 * @since 2019-12-24
 */
public interface ClassifyMapper extends BaseMapper<Classify> {
	//分类条件查询接口
	List<Classify> selectQuery(Classify clfy);
	
	//分类添加接口
	int insert(Classify clfy);
	
	//分类删除接口
	int delete(Classify clfy);
	
	//分类修改接口
	int update(Classify clfy);
}
