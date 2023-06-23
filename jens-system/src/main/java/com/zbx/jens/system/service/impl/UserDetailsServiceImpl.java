package com.zbx.jens.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbx.jens.system.entity.User;
import com.zbx.jens.system.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


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
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));

        if (user != null) {
            String password = userMapper.selectPasswordById(user.getId());
            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(password)
                    .roles("admin", "users")
                    .build();
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }

}
