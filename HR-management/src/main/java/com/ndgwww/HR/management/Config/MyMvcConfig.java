package com.ndgwww.HR.management.Config;

import com.ndgwww.HR.management.Config.interceptor.HeaderTokenInterceptor;
import com.ndgwww.HR.management.Config.interceptor.HttpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //跨域
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
        //token
        registry.addInterceptor(new HeaderTokenInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/upload/**","/portal/**","/hello/**","/**");
    }

    /*
    实现了WebMvcConfigurer 接口，WebMvcConfigurer 这个接口十分强大，
    里面还有很多可用的方法，在SpringBoot2.0里面可以解决WebMvcConfigurerAdapter曾经的部分任务。
    其中一个方法就是addCorsMappings()，是专门为开发人员解决跨域而诞生的接口。
    其中构造参数为CorsRegistry。
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }
}