package com.daotong;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author 陈井彬
 * @date 2019/07/14
 */
@Configuration
@MapperScan(basePackages = "com.daotong.springboot.service.infrastructure.persistence.mybatis")
public class TestMybatisConfig {

    @Resource
    private ResourcePatternResolver resourcePatternResolver;

    /**
     * 数据源: 使用内存数据库进行单元测试.
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
        return databaseBuilder
            .setType(EmbeddedDatabaseType.H2)

            .addScript("classpath:ddl/h2_config.sql")
            //启动时初始化建表语句
            .addScript("classpath:ddl/tms_car.sql")

            // dml
            .addScript("classpath:dml/tms_car_init.sql")
            .build();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(resourcePatternResolver.getResource("classpath:/mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath:/mybatis/sqlmap/*"));
        return sqlSessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
