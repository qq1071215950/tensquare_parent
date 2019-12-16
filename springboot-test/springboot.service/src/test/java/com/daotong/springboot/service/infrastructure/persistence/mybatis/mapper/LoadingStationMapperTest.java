package com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper;

import com.daotong.TestMybatisConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {
        TestMybatisConfig.class,
        LoadingStationMapper.class
})
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@Slf4j
class LoadingStationMapperTest {
    @Autowired
    private LoadingStationMapper loadingStationMapper;
    @Test
    void getSeqs() {
        ArrayList<Integer> seqs = loadingStationMapper.getSeqs(1L);
        Object[] arr = new Object[]{1,2};
        Object[] objects = seqs.toArray();
        log.info(seqs.toString());
        Assert.assertArrayEquals(arr,objects);
    }
}