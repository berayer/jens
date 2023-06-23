package com.zbx.jens.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zbx.jens.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 菜单信息
 *
 * @TableName menu
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "menu")
@Data
public class Menu extends BaseEntity {

    /**
     * 父级菜单id
     */
    @TableField(value = "pid")
    private Integer pid;

    /**
     * 菜单名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 菜单路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 菜单类型: 1=路由;2=iframe;3=_blank;
     */
    @TableField(value = "type")
    private Integer type;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}