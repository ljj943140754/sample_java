package com.sample.mapper;

import java.util.List;

import com.sample.entity.Album;

/**
 * <p>
 *  相册 Mapper 接口
 * </p>
 *
 * @author 予之文化传媒
 * @since 2019-12-24
 */
public interface AlbumMapper{
	//相册条件查询接口
	List<Album> selectQuery(Album alb);
	
	//相册添加接口
	int insert(Album alb);
	
	//相册删除接口
	int delete(Album alb);
	
	//相册修改接口
	int update(Album alb);
}
