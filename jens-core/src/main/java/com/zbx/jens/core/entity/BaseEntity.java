package com.zbx.jens.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zbx
 * @date 2023/5/30
 * @description
 **/
@Data
public class BaseEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建人
     */
    @TableField("createBy")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 最后修改人
     */
    @TableField("updateBy")
    private String updateBy;

    /**
     * 最后修改时间
     */
    @TableField("updateTime")
    private LocalDateTime updateTime;
}
