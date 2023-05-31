package com.zbx.jens.system.mapper;

import com.mybatisflex.core.BaseMapper;
import com.zbx.jens.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户表 映射层。
 *
 * @author Administrator
 * @since 2023-05-31
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
