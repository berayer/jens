package com.zbx.jens.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbx.jens.system.entity.Role;
import com.zbx.jens.system.mapper.RoleMapper;
import com.zbx.jens.system.service.RoleService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【role(角色信息)】的数据库操作Service实现
* @createDate 2023-06-23 08:48:32
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




