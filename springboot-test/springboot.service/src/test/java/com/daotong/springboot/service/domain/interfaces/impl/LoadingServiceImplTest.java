package com.daotong.springboot.service.domain.interfaces.impl;

import com.daotong.TestMybatisConfig;
import com.daotong.springboot.service.domain.bo.LoadingBO;
import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
import com.daotong.springboot.service.domain.interfaces.LoadingService;
import com.daotong.springboot.service.domain.vo.LoadingVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {
        TestMybatisConfig.class,
        LoadingServiceImpl.class,
        LoadingStationServiceImpl.class
})
@DisplayName(value = "运单服务功能测试")
@Slf4j
class LoadingServiceImplTest {
    @Autowired
    private LoadingService loadingService;
    private static int EXPECT_COUNT = 1;

    @Test
    @DisplayName(value = "when_保存运单_参数异常_then_抛出预期的异常和提示")
    void saveLoadingTest() {
        LoadingBO loadingBO = new LoadingBO();
        RuntimeException ex = Assertions.assertThrows(RuntimeException.class, () -> loadingService.saveLoading(loadingBO));
        Assert.assertTrue(ex.getMessage().equals("线路名称不能为空"));
    }

    @Test
    @DisplayName(value = "when_通过条件查询运单_then_正确获取运单信息")
    void getByQueryParamTest() {
        LoadingQueryParam loadingQueryParam = new LoadingQueryParam();
        loadingQueryParam.setDriverName("张");
        List<LoadingVO> byQueryParam = loadingService.getByQueryParam(loadingQueryParam);
        LoadingVO loadingVO = byQueryParam.get(0);
        String loadingNo = loadingVO.getLoadingNo();
        log.info(byQueryParam.toString());
        Assert.assertNotNull("运单信息为空", byQueryParam);
        Assert.assertEquals("运单结果数量超出预期", EXPECT_COUNT, byQueryParam.size());
        Assert.assertEquals("运单号不为预期 ", "1113110851", loadingNo);
    }

    @Test
    @DisplayName(value = "when_根据id_手动设置完成_then_正确获取到修改后的信息")
    void manualCompleteTest() {
        loadingService.manualComplete(1L);
        LoadingQueryParam loadingQueryParam = new LoadingQueryParam();
        loadingQueryParam.setDriverName("张");
        List<LoadingVO> byQueryParam = loadingService.getByQueryParam(loadingQueryParam);
        LoadingVO loadingVO = byQueryParam.get(0);
        Assert.assertEquals("运单状态信息不为预期", "manual", loadingVO.getLoadingStatus());
    }

    @Test
    @DisplayName(value = "when_更新运单状态_状态不可编辑_then_抛出预期的异常")
    void updateLoadingMsgTest() {
        LoadingDTO loadingDTO = new LoadingDTO();
        loadingDTO.setLoadingId(1L);
        loadingDTO.setLoadingStatus("arrival");
        RuntimeException ex = Assertions.assertThrows(RuntimeException.class, () -> loadingService.updateLoadingMsg(loadingDTO));
        String message = ex.getMessage();
        Assert.assertEquals("参数校验失败", "当前状态不可编辑", message);
    }

}