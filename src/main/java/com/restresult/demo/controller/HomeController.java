package com.restresult.demo.controller;

import com.restresult.demo.annotation.RateLimiter;
import com.restresult.demo.constant.ResponseCode;
import com.restresult.demo.exception.BusinessException;
import com.restresult.demo.form.HomeidForm;
import com.restresult.demo.util.ResultUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/home1")
    @ResponseBody
    public ResultUtil home1(@RequestParam(value="homeid",required = true,defaultValue = "0") int homeId) {
        return ResultUtil.success("this is home");
    }


    @GetMapping("/age")
    @ResponseBody
    public ResultUtil age(@Min(value = 10,message = "年龄最小为10")@Max(value = 100,message = "年龄最大为100") @RequestParam("age") Integer age) {
        return ResultUtil.success("this is age");
    }

    @GetMapping("/home")
    @ResponseBody
    public ResultUtil home(@Validated HomeidForm homeidForm) {
        return ResultUtil.success("this is home");
    }


    @GetMapping("/aop")
    @ResponseBody
    @RateLimiter(count = 3, time = 1)
    public ResultUtil aop(@RequestParam(value="id",required = true,defaultValue = "0") String id) {
        return ResultUtil.success("this is aop");
    }


    @GetMapping("/inter")
    @ResponseBody
    public ResultUtil inter(@RequestParam(value="id",required = true,defaultValue = "0") String id) {

        return ResultUtil.success("this is home inter");
    }

    @GetMapping("/list")
    @ResponseBody
    public ResultUtil list(@RequestParam(value="id",required = true,defaultValue = "0") String id) {
        if (id.equals("1")){
            int divisor = 0;
            int res = 100 / divisor;
        }
        return ResultUtil.success("this is home list");
    }


    @GetMapping("/throwe")
    @ResponseBody
    public ResultUtil throwe(@RequestParam(value="id",required = true,defaultValue = "0") String id) {
        if (id.equals("1")) {
            throw new BusinessException(ResponseCode.ERROR);
        } else {
            return ResultUtil.success("this is throwe");
        }
    }

}
