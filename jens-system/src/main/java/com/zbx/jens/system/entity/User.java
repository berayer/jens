package com.zbx.jens.system.entity;

import com.mybatisflex.annotation.Table;
import com.zbx.jens.core.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户表 实体类。
 *
 * @author Administrator
 * @since 2023-05-31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Table(value = "system_user")
public class User extends BaseEntity {


    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否锁定
     */
    private Boolean locked;


}
