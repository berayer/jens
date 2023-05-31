package com.zbx.jens.system.entity;

import com.mybatisflex.annotation.Table;
import com.zbx.jens.core.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色表 实体类。
 *
 * @author Administrator
 * @since 2023-05-31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Table(value = "system_role")
public class Role extends BaseEntity  {

    /**
     * 用户名
     */
    private String name;
}
