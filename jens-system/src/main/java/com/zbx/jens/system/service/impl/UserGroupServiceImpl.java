package com.zbx.jens.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbx.jens.system.entity.UserGroup;
import com.zbx.jens.system.mapper.UserGroupMapper;
import com.zbx.jens.system.service.UserGroupService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user_group(用户组信息)】的数据库操作Service实现
* @createDate 2023-06-23 08:48:32
*/
@Service
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup>
    implements UserGroupService{

}




