package com.xu.springcloud.springcloudprovider8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 微服务的提供者 8001号：该服务启动后会自动注入到Eureka的服务注册中心，后可以配其他消费者发现然后进行操作
 *          1.主要练习在Eureka的服务注册中心注册该服务并让其他客户端服务进行访问操作
 *          2.流程：
 *              1）配置application.yml文件
 *              2）在启动类上添加@EnableEurekaClient注解作用：使该服务启动后会自动注册进eureka服务中
 *              3）@EnableDiscoveryClient注解作用：可以使该服务暴露给其他服务，让其他服务发现该服务且使用操作
 *              4）需要注意如果有多个服务的提供者则spring.application.name的配置值如果多个项目需要使用一个微服务的名称进行访问则该名称必须一样
 */
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
@EnableCircuitBreaker//对hystrixR熔断机制的支持
@SpringBootApplication
public class SpringcloudProvider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvider8001Application.class, args);
    }
}
