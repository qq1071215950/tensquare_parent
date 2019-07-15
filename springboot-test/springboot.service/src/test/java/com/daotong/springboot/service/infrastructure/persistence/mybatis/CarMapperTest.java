package com.daotong.springboot.service.infrastructure.persistence.mybatis;

import com.daotong.TestMybatisConfig;
import com.daotong.springboot.service.domain.repository.CarDO;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 陈井彬
 * @date 2019/07/14
 */
@SpringBootTest(classes = {
    TestMybatisConfig.class
})
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
class CarMapperTest {

    @Autowired
    private CarMapper carMapper;

    @DisplayName("when_通过编码获取车辆信息_存在对应的车辆_then_正确获取车辆信息")
    @Test
    public void test_getByCode() {
        String code = "1526303256727";

        CarDO carDO = carMapper.getByCode(code);

        Assert.assertTrue("获取车辆信息为空", carDO != null);
        Assert.assertEquals("商家编码不为预期", "ISV01", carDO.getMerchantCode());
        Assert.assertEquals("车辆编码不为预期", "1526303256727", carDO.getCode());
    }
}