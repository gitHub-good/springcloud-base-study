package com.xu.springcloud.springcloudconsumer8100;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 微服务的消费者 8100号：该项目为一个消费者（客户端）调用的项目主要练习Spring Cloud 的Ribbon的负载均衡
 *             1.主要练习调用Eureka注册的提供者的服务以及客户端Ribbon的负载均衡
 *             2.流程：
 *                  1）配置application.yml和POM.xml添加相应的依赖
 *                  2）@EnableEurekaClient注解作用：消费者(客户端)如果需要调用某一个服务的提供者则必须首先去Eureka注册中心进行查询然后再进行调用
 *                  3）可以配置自已需求所需的默认的七种负载均衡算法或自定义编写负载均衡算法
 *                  4）如果需要自定义算法或需要切换默认负载均衡算法则该配置类的包必须要和启动类的包平行
 *                  5）@RibbonClient注解作用：在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
 *                  6）使用Feign封装Ribbon+RestTemplate 进行学习，Feign使用：注解+接口，接口在interface-api包中可以实现服务的负载均衡
 *                  7）使用@EnableFeignClients注解代替@RibbonClient
 *                  8）@EnableFeignClients注解的basePackages属性添加的包是有关于Feign的注解如@FeignClient
 *                  9）@EnableHystrixDashboard注解：服务的监控管理机制（需要在监控的服务者的POM.xml文件中加入actuator服务监控依赖）
 *                  10）@EnableCircuitBreaker注解：实现服务的熔断机制和服务降级处理
 */

@EnableEurekaClient   //消费者(客户端)如果需要调用某一个服务的提供者则必须首先去Eureka注册中心进行查询然后再进行调用
//@RibbonClient(name = "SPRINGCLOUD-TEST",configuration= MySelfRule.class)
@EnableFeignClients(basePackages= {"com.springcloud.springcloudcommoninterfaceapi.service"})
@SpringBootApplication
//@EnableHystrixDashboard
public class SpringcloudConsumer8100Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumer8100Application.class, args);
    }
}
