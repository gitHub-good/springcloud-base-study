package com.xu.springcloud.springcloudprovider8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 微服务的提供者 8003号：该服务启动后会自动注入到Eureka的服务注册中心，后可以配其他消费者发现然后进行操作
 *          1.主要练习在Eureka的服务注册中心注册该服务并让其他客户端服务进行访问操作
 *          2.流程：
 *              1）配置application.yml和POM.xml添加相应的依赖
 *              2）在启动类上添加@EnableEurekaClient注解作用：使该服务启动后会自动注册进eureka服务中
 *              3）@EnableDiscoveryClient注解作用：可以使该服务暴露给其他服务，让其他服务发现该服务且使用操作
 *              4）需要注意如果有多个服务的提供者则spring.application.name的配置值如果多个项目需要使用一个微服务的名称进行访问则该名称必须一样
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudProvider8003Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider8003Application.class, args);
    }
}
