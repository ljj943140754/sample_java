package com.sample.service.impl;

import com.sample.entity.Photo;
import com.sample.mapper.PhotoMapper;
import com.sample.service.PhotoService;
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
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, Photo> implements PhotoService {

}
