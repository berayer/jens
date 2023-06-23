package com.zbx.jens.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zbx.jens.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 用户组信息
 *
 * @TableName user_group
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "user_group")
@Data
public class UserGroup extends BaseEntity {

    /**
     * 用户组名称(唯一)
     */
    @TableField(value = "name")
    private String name;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}