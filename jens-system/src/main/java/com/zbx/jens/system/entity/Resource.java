package com.zbx.jens.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zbx.jens.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 资源信息
 *
 * @TableName resource
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "resource")
@Data
public class Resource extends BaseEntity {

    /**
     * 资源地址(唯一)
     */
    @TableField(value = "url")
    private String url;

    /**
     * 资源名称
     */
    @TableField(value = "name")
    private String name;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}