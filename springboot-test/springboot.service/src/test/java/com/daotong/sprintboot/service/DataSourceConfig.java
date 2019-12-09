package com.daotong.sprintboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * 嵌入式数据库配置
 *
 * @author 陈井彬
 * @date 2019/05/23
 */
@Configurable
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
        return databaseBuilder
            .setType(EmbeddedDatabaseType.H2)
            .addScript("classpath:ddl/h2_config.sql")
            .addScript("classpath:ddl/tms_car.sql")
            .addScript("classpath:loading.sql")
            .addScript("classpath:dml/t_station.sql")
            .addScript("classpath:dml/tms_car_init.sql")
            .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }
}
