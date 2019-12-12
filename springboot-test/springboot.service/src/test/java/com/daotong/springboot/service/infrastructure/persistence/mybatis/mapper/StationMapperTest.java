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
@SpringBootTest(classes = {
        TestMybatisConfig.class,
        StationMapper.class
})
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@Slf4j
class StationMapperTest {
    @Autowired(required = false)
    private StationMapper stationMapper;
//    @Test
//    void saveStationTest() {
//        StationDTO stationDTO = new StationDTO(null,"jx","江西","江西","萍乡","芦溪");
//        int i = stationMapper.saveStation(stationDTO);
//        log.info(i+"");
//        Assert.assertFalse("插入失败",i<1);
//    }

    @Test
    void removeStationTest() {
        int i = stationMapper.removeStation(1);
        log.info(i+"");
        Assert.assertFalse("删除失败",i<1);
    }

//    @Test
//    void updateAndSelectStationTest() {
//        StationDTO stationDTO = new StationDTO(1, "jx", "江西", null, "宜春", null);
//        int i = stationMapper.updateStation(stationDTO);
//        StationDTO byStationId = stationMapper.getByStationId(1);
//        log.info(byStationId.toString());
//        Assert.assertFalse("更新失败",i<1);
//        Assert.assertNotNull("查询成功",byStationId);
//    }

//    @Test
//    void getStationListTest() {
//        PageHelper.startPage(1,10);
//        Page<StationDTO> stationList = stationMapper.getStationList(null);
//        List<StationDTO> result = stationList.getResult();
//        log.info(result.toString());
//        Assert.assertFalse("failed",result.size()<1||result==null);
//    }
//    @Test
//    void getByLoadingNoTest(){
//        List<StationDTO> byLoadingNo = stationMapper.getByLoadingId(1);
//        log.info(byLoadingNo.toString());
//        Assert.assertNotNull("查询成功",byLoadingNo);
//    }
}