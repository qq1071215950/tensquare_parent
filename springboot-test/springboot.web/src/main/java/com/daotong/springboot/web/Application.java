package com.daotong.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 陈井彬
 * @date 2019/07/13
 */
@SpringBootApplication(
    scanBasePackages = {
        "com.daotong.springboot"
    }
)
@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
