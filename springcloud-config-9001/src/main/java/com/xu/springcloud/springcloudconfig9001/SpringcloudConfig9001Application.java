package com.xu.springcloud.springcloudconfig9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *  微服务的配置文件服务中心
 *      1.整合所有项目的配置文件统一上传到gitHub中进行管理
 *      2.方便维护和操作
 *      3.@EnableConfigServer使用该注解进行启动配置服务
 */
@EnableConfigServer
@SpringBootApplication
public class SpringcloudConfig9001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfig9001Application.class, args);
    }
}
