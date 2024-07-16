package com.sxt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * exams   com.sxt.config
 * 2022-08-14  11:07
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/8/14  11:07
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册登陆拦截器
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
        //拦截所有路径
        interceptorRegistration.addPathPatterns("/**");
        //不用拦截的路径
        interceptorRegistration.excludePathPatterns(
                "/css/**",
                "/fonts/**",
                "/img/**",
                "/js/**",
                "/",
                "/student/login.html",
                "/teacher/login.html",
                "student/register.html",
                "/toTeacher",
                "/toStuLogin",
                "/stulogin",
                "/tealogin",
                "/register",
                "/CanRegister");
    }
}
