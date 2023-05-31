package com.zbx.jens.system.pojo.form;

import lombok.Data;

/**
 * @author zbx
 * @date 2023/5/24
 * @description
 **/
@Data
public class LoginForm {

    private String username;
    private String password;
    private boolean rememberMe = false;

}
