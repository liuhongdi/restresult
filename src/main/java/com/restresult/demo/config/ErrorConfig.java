package com.restresult.demo.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


/*
@Configuration
public class ErrorPagesConfig {
    @Bean
    //public Embedded
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                //状态码 ：HttpStatus.NOT_FOUND（404）       错误页面的存储路径：/WEB-INF/views/common/error_404.jsp
                ErrorPage errorPage400 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/error400.html");
                ErrorPage errorPage404 = new ErrorPage(HttpStatus.FORBIDDEN, "/error/error.html");
                ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/WEB-INF/views/common/error_500.jsp");
                container.addErrorPages(errorPage400, errorPage404, errorPage500);
            }
        };
    }
}
*/
@Component
public class ErrorConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/error/400");
        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/error/401");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/error/404");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/error/500");
        registry.addErrorPages(error400Page,error401Page,error404Page,error500Page);
    }
}