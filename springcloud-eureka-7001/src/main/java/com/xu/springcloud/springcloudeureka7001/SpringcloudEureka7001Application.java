package com.xu.springcloud.springcloudeureka7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 微服务的注册中心：EurekaServer服务器端 7001号服务
 *         1.主要练习Eureka的服务的注册，是Eureka的Server服务端
 *         2.流程：
 *                 1）配置application.yml文件
 *                 2）在启动类上添加@EnableEurekaServer注解，通知springcloud该项目为注册中心
 *                 3）Eureka与Zookeeper的对比
 *                 A：高可用，C：强一致性，P：分布式容错性
 *                         Eureka保证了AP：AP为高可用和分布式容错性
 *                         Zookeeper是CP：满足强一致性和分布容错性
 *         注意：1.如果出现master的Zookeeper机器down掉，则根据Zookeeper集群算法需要重新选举一个header
 *                     这时需要好处时间一般在30-120s之间，则这是的服务注册中心是完全瘫痪的不可用的。
 *               2.而Eureka则不是，因为Eureka集群的每一台服务都是平行的，没有主从关系，则不会出现以上问题，
 *                     除非Eureka集群的服务全部down掉。
 *
 *
 */
@EnableEurekaServer // EurekaServer服务器端启动类,接受其它微服务注册进来
@SpringBootApplication
public class SpringcloudEureka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEureka7001Application.class, args);
    }
}

