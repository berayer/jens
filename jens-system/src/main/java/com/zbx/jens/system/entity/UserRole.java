package com.zbx.jens.system.entity;

import com.mybatisflex.annotation.Table;
import com.zbx.jens.core.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色用户映射表 实体类。
 *
 * @author Administrator
 * @since 2023-05-31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Table(value = "system_user_role")
public class UserRole extends BaseEntity {


    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 角色Id
     */
    private Long roleId;


}
