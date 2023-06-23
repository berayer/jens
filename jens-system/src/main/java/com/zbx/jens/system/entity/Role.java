package com.zbx.jens.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zbx.jens.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 角色信息
 *
 * @TableName role
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "role")
@Data
public class Role extends BaseEntity {

    /**
     * 角色名称(唯一)
     */
    @TableField(value = "name")
    private String name;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}