package com.sample.service.impl;

import com.sample.entity.Worker;
import com.sample.mapper.WorkerMapper;
import com.sample.service.WorkerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 予之文化传媒
 * @since 2019-12-24
 */
@Service
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker> implements WorkerService {

}
