package com.zbx.jens.system.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbx.jens.core.response.Result;
import com.zbx.jens.system.entity.User;
import com.zbx.jens.system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author zbx
 * @date 2023/6/2
 * @description
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/search")
    public Result<Page<User>> search(Integer page, Integer size) {
        Page<User> p = new Page<>(page, size);
        Page<User> list = userService.page(p);
        return Result.success(list);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result<String> add(User user) {
        return Result.success();
    }

    /**
     * 修改用信息
     * @param user
     * @return
     */
    @PutMapping("/edit")
    public Result<String> edit(User user) {
        return Result.success();
    }

    // 修改密码
    @PutMapping("/changePassword")
    public Result<String> changePassword() {
        return Result.success();
    }

    // 重置密码
    @PutMapping("/resetPassword")
    public Result<String> resetPassword() {
        return Result.success();
    }

    // 锁定用户
    @PutMapping("/lockUser")
    public Result<String> lockUser() {
        return Result.success();
    }

    // 解锁用户
    @PutMapping("/unlockUser")
    public Result<String> unlockUser() {
        return Result.success();
    }


}
