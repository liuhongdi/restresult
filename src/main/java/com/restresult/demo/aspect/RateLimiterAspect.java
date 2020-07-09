package com.restresult.demo.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restresult.demo.constant.ResponseCode;
import com.restresult.demo.exception.BusinessException;
import com.restresult.demo.exception.ThrowException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Component
@Aspect
public class RateLimiterAspect {
    //for json
    private static ObjectMapper objectMapper = new ObjectMapper();



    @Pointcut("@annotation(com.restresult.demo.annotation.RateLimiter)")
    private void pointcut() {}

    /*
    *   around,
    *   if reach limit in time
    *   return error info
    * */
    @Around(value = "pointcut()")
    public Object requestLimit(ProceedingJoinPoint joinPoint) throws Exception {

        Object[] args = joinPoint.getArgs();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        //int divisor = 0;
        //int res = 100 / divisor;
        //return joinPoint.proceed();

        String id = request.getParameter("id");
        if (id!=null && id.equals("1")) {
            int divisor = 0;
            int res = 100 / divisor;
        }


        try {
            /*
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature)signature;
            //获取目标方法
            Method targetMethod = methodSignature.getMethod();
            String method_name = targetMethod.getName();
            //System.out.println("method_name:"+method_name);
            if (targetMethod.isAnnotationPresent(RedisRateLimiter.class)) {
                //获取目标方法的@LxRateLimit注解
                RedisRateLimiter limit = targetMethod.getAnnotation(RedisRateLimiter.class);

                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
                String ip = request.getRemoteAddr();
                String key = "req_limit_".concat(method_name).concat("_").concat(ip);
                boolean checkResult = checkByRedis(limit, key);

                if (checkResult) {
                    return joinPoint.proceed();
                } else {
                    return objectMapper.writeValueAsString(ServerResponseUtil.error(ResponseCode.ACCESS_LIMIT.getMsg()));
                }
            } else {
                return joinPoint.proceed();
            }
            */
            int divisor = 0;
            int res = 100 / divisor;
            return joinPoint.proceed();

        } catch (Throwable e) {
            //e.printStackTrace();
            //throw new BusinessException(e);
            //throw new BusinessException(e);
            //return null;
            throw new ThrowException(e);
        }

    }


}