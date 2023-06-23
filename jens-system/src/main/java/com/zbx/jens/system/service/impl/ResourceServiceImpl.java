package com.zbx.jens.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbx.jens.system.entity.Resource;
import com.zbx.jens.system.mapper.ResourceMapper;
import com.zbx.jens.system.service.ResourceService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【resource(资源信息)】的数据库操作Service实现
* @createDate 2023-06-23 08:48:32
*/
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource>
    implements ResourceService{

}




