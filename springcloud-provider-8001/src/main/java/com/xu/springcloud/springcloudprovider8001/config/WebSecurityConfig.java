//package com.xu.springcloud.springcloudprovider8001.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @Auther: 徐亮亮
// * @Date: 2018/10/25 15:53
// * @Description: web访问安全配置类
// */
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    /**
//     * 定义授权规则
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("dept/**").hasRole("VIP");
//    }
//
//    /**
//     * 定义认证规则
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("小小高").password("123").roles("VIP");
//    }
//}
