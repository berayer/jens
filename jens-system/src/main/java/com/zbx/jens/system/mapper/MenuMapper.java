package com.zbx.jens.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbx.jens.system.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【menu(菜单信息)】的数据库操作Mapper
* @createDate 2023-06-23 08:48:32
* @Entity com.zbx.jens.system.entity.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}




