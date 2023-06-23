package com.zbx.jens.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbx.jens.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【user(用户信息)】的数据库操作Mapper
* @createDate 2023-06-23 08:48:32
* @Entity com.zbx.jens.system.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    String selectPasswordById(Integer id);
}




