package com.ggoreb.practice.config;

import com.ggoreb.practice.interceptor.SignInCheckInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private SignInCheckInterceptor signInCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInCheckInterceptor)
        .addPathPatterns("/question/create"); //게시글 올리기
        //.excludePathPatterns("/signin", "/signup"); //제외
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
//로그인한 사람만 게시글 올릴 수 있도록