package com.zbx.jens.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbx.jens.system.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【role(角色信息)】的数据库操作Mapper
* @createDate 2023-06-23 08:48:32
* @Entity com.zbx.jens.system.entity.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}




