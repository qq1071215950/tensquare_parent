package com.daotong.springboot.service.domain.repository;

import com.daotong.TestMybatisConfig;
import com.daotong.springboot.service.domain.model.Car;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.CarRepoMybatis;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.dataobject.CarDO;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.CarMapper;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        TestMybatisConfig.class,
        CarRepoMybatis.class
})
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
class CarRepoTest {

    @Autowired
    private CarRepo carRepo;

    @DisplayName("when_通过编码获取车辆信息_存在对应的车辆_then_正确获取车辆信息")
    @Test
    public void test_getByCode() {
        String code = "1526303256727";

        Car car = carRepo.getByCode(code);

        Assert.assertTrue("获取车辆信息为空", car != null);
        Assert.assertEquals("商家编码不为预期", "ISV01", car.getMerchantCode());
        Assert.assertEquals("车辆编码不为预期", "1526303256727", car.getCode());
    }
}