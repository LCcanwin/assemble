package com.jijian.common;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+Constant.IMAGE_PATH);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有后台请求 不包含登录请求
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/back/api/**").excludePathPatterns("/back/api/login");
    }
}
