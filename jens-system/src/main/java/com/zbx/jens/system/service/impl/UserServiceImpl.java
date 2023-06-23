package com.zbx.jens.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbx.jens.system.entity.User;
import com.zbx.jens.system.mapper.UserMapper;
import com.zbx.jens.system.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2023-06-23 08:48:32
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




