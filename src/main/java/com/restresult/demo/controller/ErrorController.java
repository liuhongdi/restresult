package com.restresult.demo.controller;

import com.restresult.demo.annotation.RateLimiter;
import com.restresult.demo.constant.ResponseCode;
import com.restresult.demo.util.ResultUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/error")
public class ErrorController {

    @GetMapping("/error/{code}")
    @ResponseBody
    public ResultUtil error(@PathVariable String code) {

        if (code.equals("404")) {
            return ResultUtil.error(ResponseCode.WEB_404);
        } else if (code.equals("400")) {
            return ResultUtil.error(ResponseCode.WEB_400);
        } else if (code.equals("401")) {
            return ResultUtil.error(ResponseCode.WEB_401);
        } else if (code.equals("500")) {
            return ResultUtil.error(ResponseCode.WEB_500);
        }
        return ResultUtil.error(ResponseCode.WEB_UNKOWN);
    }

}
