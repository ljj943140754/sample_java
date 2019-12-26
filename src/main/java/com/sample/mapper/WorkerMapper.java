package com.sample.mapper;

import com.sample.entity.Worker;

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
public interface WorkerMapper extends BaseMapper<Worker> {
	//CMS 登陆接口
	Worker login(Worker wor);
	
	//员工条件查询接口
	List<Worker> selectQuery(Worker wor);
	
	//员工添加接口
	int insert(Worker wor);
	
	//员工删除接口
	int delete(Worker wor);
	
	//员工修改接口
	int update(Worker wor);
}
