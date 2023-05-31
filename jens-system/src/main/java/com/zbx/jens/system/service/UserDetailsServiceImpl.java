package com.zbx.jens.system.service;


import com.mybatisflex.core.query.QueryWrapper;
import com.zbx.jens.system.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.zbx.jens.system.entity.table.UserTableDef.USER;


/**
 * @author zbx
 * @date 2023/5/27
 * @description
 **/
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper query = QueryWrapper.create().where(USER.USERNAME.eq(username));
        com.zbx.jens.system.entity.User user = userMapper.selectOneByQuery(query);
        if (user != null) {
            return User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles("admin", "user")
                    .authorities("add", "delete", "update")
                    .build();
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }

}
