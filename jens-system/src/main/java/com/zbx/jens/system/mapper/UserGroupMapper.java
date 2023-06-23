package com.zbx.jens.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbx.jens.system.entity.UserGroup;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【user_group(用户组信息)】的数据库操作Mapper
* @createDate 2023-06-23 08:48:32
* @Entity com.zbx.jens.system.entity.UserGroup
*/
@Mapper
public interface UserGroupMapper extends BaseMapper<UserGroup> {

}




