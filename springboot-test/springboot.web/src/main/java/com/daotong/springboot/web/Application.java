package com.daotong.springboot.web;

import org.allenwang.frameworker.swagger.EnableSwaggerDoc;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 陈井彬
 * @date 2019/07/13
 */
@SpringBootApplication(
    scanBasePackages = {
        "com.daotong.springboot"
    }
)
@EnableSwaggerDoc
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {

    public static void main(String[] args) {

    }
}
