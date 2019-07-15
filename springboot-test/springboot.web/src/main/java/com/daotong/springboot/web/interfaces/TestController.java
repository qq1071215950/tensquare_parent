package com.daotong.springboot.web.interfaces;

import com.daotong.springboot.web.base.RestResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 陈井彬
 * @date 2019/07/13
 */
@Controller()
@RequestMapping(value = "/mvc")
public class TestController {

    @PostMapping("post")
    public RestResponse<Boolean> postTest() {
        return RestResponse.single(true);
    }
}
