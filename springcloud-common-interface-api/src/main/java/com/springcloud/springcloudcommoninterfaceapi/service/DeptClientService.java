package com.springcloud.springcloudcommoninterfaceapi.service;

import com.springcloud.config.MySelfRule;
import com.springcloud.springcloudcommoninterfaceapi.entities.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 *
 * 微服务的Feign服务的负载均衡：
 * 			1.主要通过@FeignClient注解进行操作并且实现服务的负载均衡的功能
 *			2.Feign封装了Ribbon+RestTemplate，则Feign的实现原理是：注解+接口的形式就可以实现服务的负载均衡和服务的降级
 *			3.注解：@FeignClient
 *						1）value：作用为添加指定微服务的名称
 *						2）	fallbackFactory：指定服务降级的类，该类必须实现FallbackFactory接口
 *						3）该注解必须使用在一个业务调用的接口上
 * 根据已经有的DeptClientService接口新建一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 *
 *注意：该接口为客户端使用的接口
 */
@FeignClient(configuration = MySelfRule.class, value = "SPRINGCLOUD-TEST",fallbackFactory= DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	boolean add(Dept dept);
}
