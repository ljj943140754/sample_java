package com.sample.mapper;

import com.sample.entity.Photo;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 予之文化传媒
 * @since 2019-12-24
 */
public interface PhotoMapper extends BaseMapper<Photo> {
	//图片条件查询接口
	List<Photo> selectQuery(Photo pho);
	
	//图片添加接口
	int insert(Photo pho);
	
	//图片删除接口
	int delete(Photo pho);
	
	//图片修改接口
	int update(Photo pho);
}
