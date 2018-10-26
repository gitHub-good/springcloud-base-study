package com.xu.springcloud.springcloudconsumer8100.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/10/26 18:06
 * @Description: 该配置类是为了让Feign支持使用Hystrix熔断机制
 *              注意：在spring cloud Finchley.SR1版本让Feign使用Hystrix必须添加该方法
 */
@Configuration
public class FooConfiguration {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
