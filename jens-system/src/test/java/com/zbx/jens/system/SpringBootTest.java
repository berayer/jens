package com.zbx.jens.system;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zbx.jens.core.entity.BaseEntity;

/**
 * @author zbx
 * @date 2023/5/27
 * @description
 **/
public class SpringBootTest {

    public static void main(String[] args) {
        //配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3388/jens?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("root");


        //创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfigUseStyle1();
        //GlobalConfig globalConfig = createGlobalConfigUseStyle2();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        //生成代码
        generator.generate();
    }

    public static GlobalConfig createGlobalConfigUseStyle1() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        globalConfig.setSourceDir("D:\\IdeaPorject\\jens\\jens-system\\src\\main\\java");
        //设置根包
        globalConfig.setBasePackage("com.zbx.jens.system");

        //设置表前缀和只生成哪些表
        globalConfig.setTablePrefix("system_");
        globalConfig.setGenerateTable("system_user", "system_role", "system_user_role");

        //设置生成 entity 并启用 Lombok
        globalConfig.setEntityGenerateEnable(true);
        globalConfig.setEntityWithLombok(true);
        globalConfig.setEntitySupperClass(BaseEntity.class);

        //设置生成 mapper
        globalConfig.setMapperGenerateEnable(true);

        // 设置生成service
        globalConfig.setServiceGenerateEnable(true);

        globalConfig.setMapperXmlGenerateEnable(true);
        globalConfig.setMapperXmlPath("D:\\IdeaPorject\\jens\\jens-system\\src\\main\\resources\\mapper");

        return globalConfig;
    }

    public static GlobalConfig createGlobalConfigUseStyle2() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包
        globalConfig.getPackageConfig()
                .setBasePackage("com.test");


        //设置表前缀和只生成哪些表
        globalConfig.getStrategyConfig()
                .setTablePrefix("tb_")
                .setGenerateTable("account", "account_session");

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true);

        //设置生成 mapper
        globalConfig.setMapperXmlGenerateEnable(true);
        globalConfig.setMapperXmlOverwriteEnable(true);

        //可以单独配置某个列
        ColumnConfig columnConfig = new ColumnConfig();
        columnConfig.setColumnName("tenant_id");
        columnConfig.setLarge(true);
        columnConfig.setVersion(true);
        globalConfig.getStrategyConfig()
                .setColumnConfig("account", columnConfig);

        return globalConfig;
    }
}