package com.sample.mapper;

import com.sample.entity.Qr_code;

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
public interface Qr_codeMapper extends BaseMapper<Qr_code> {
	//二维码条件查询
	List<Qr_code> selectQuery(Qr_code qr);
	
	//二维码添加接口
	int insert(Qr_code qr);
	
	//二维码删除接口
	int delete(Qr_code qr);
	
	//二维码修改接口
	int update(Qr_code qr);
}
