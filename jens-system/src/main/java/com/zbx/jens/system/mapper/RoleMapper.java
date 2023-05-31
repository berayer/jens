package com.zbx.jens.system.mapper;

import com.mybatisflex.core.BaseMapper;
import com.zbx.jens.system.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色表 映射层。
 *
 * @author Administrator
 * @since 2023-05-31
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
