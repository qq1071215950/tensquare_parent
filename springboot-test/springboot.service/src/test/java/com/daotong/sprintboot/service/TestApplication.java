package com.daotong.sprintboot.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author 陈井彬
 * @date 2019/05/21
 */
@EnableAutoConfiguration
@PropertySource(value = { "classpath:test.properties" })
public class TestApplication {
}
