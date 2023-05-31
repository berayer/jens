package com.zbx.jens.system.api;

import com.zbx.jens.core.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbx
 * @date 2023/5/26
 * @description
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public Result<String> sayHello() {
        return Result.success("Hello!");
    }

}
