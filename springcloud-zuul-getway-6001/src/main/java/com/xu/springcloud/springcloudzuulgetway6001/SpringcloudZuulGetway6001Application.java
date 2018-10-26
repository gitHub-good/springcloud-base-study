package com.xu.springcloud.springcloudzuulgetway6001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 微服务的路由网关机制服务：
 *          1）@EnableZuulProxy注解：启动该路由配置
 */
@SpringBootApplication
@EnableZuulProxy
public class SpringcloudZuulGetway6001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuulGetway6001Application.class, args);
    }
}
