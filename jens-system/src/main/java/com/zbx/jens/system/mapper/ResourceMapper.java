package com.zbx.jens.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbx.jens.system.entity.Resource;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【resource(资源信息)】的数据库操作Mapper
* @createDate 2023-06-23 08:48:32
* @Entity com.zbx.jens.system.entity.Resource
*/
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

}




