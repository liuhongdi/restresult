package com.restresult.demo.interceptor;

import com.alibaba.fastjson.JSON;
import com.restresult.demo.constant.ResponseCode;
import com.restresult.demo.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
*
* interceptor for api sign
*
* */
@Component
public class SignInterceptor implements HandlerInterceptor {
    private static final String SIGN_KEY = "apisign_";
    private static final Logger logger = LogManager.getLogger("bussniesslog");


    /*
    *@author:liuhongdi
    *@date:2020/7/1 下午4:00
    *@description:
     * @param request：请求对象
     * @param response：响应对象
     * @param handler：处理对象：controller中的信息   *
     * *@return:true表示正常,false表示被拦截
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //依次检查各变量是否存在？

        String id = request.getParameter("id");
        if (id!=null && id.equals("1")) {
            int divisor = 0;
            int res = 100 / divisor;
        }

        String appId = request.getHeader("appId");
        if (StringUtils.isBlank(appId)) {
            //ServletUtil.renderString(response, JSON.toJSONString(ResultUtil.error(ResponseCode.SIGN_NO_APPID)));
            throw new BusinessException(ResponseCode.SIGN_NO_APPID);
            //dreturn false;
        }

        //sign校验无问题,放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}