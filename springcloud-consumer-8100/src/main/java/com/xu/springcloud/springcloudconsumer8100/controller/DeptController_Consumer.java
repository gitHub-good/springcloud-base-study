package com.xu.springcloud.springcloudconsumer8100.controller;


import com.springcloud.springcloudcommoninterfaceapi.entities.Dept;
import com.springcloud.springcloudcommoninterfaceapi.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 该类为Feign客户端的负载均衡和服务的降级
 * 		1.客户端发送请求到该Controller控制器然后进行调用service业务逻辑接口（springcloud-common-interface-api）
 * 			则如果该发现的服务出现异常或down机则需要服务的降级，防止用户访问时出现较长的等待
 */
@RestController
public class DeptController_Consumer {
	@Autowired
	private DeptClientService service;

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return this.service.list();
	}

	@RequestMapping(value = "/consumer/dept/add")
	public Object add(Dept dept) {
		return this.service.add(dept);
	}
}


/**
 * 客户端的Controller的测试
 * 如下代码为Ribbon+RestTemplate的方式进行客户端的负载均衡
 */
//@RestController
//public class DeptController_Consumer {
//
//
//
//	//private static final String REST_URL_PREFIX = "http://localhost:8001";
//	//可以体现出微服务的概念：使用spring.application.name配置名称来进行访问，该名称为微服务的名称
//	private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-TEST";
//
//	/**
//	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
//	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
//	 * */
//
//	@Autowired
//	private RestTemplate restTemplate;
//
//	@RequestMapping(value = "/consumer/dept/add")
//	public boolean add(Dept dept) {
//		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
//	}
//
//	@RequestMapping(value = "/consumer/dept/get/{id}")
//	public Dept get(@PathVariable("id") Long id) {
//		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
//	}
//
//	@SuppressWarnings("unchecked")
//	@RequestMapping(value = "/consumer/dept/list")
//	public List<Dept> list() {
//		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
//	}
//
//	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
//	@RequestMapping(value = "/consumer/dept/discovery")
//	public Object discovery() {
//		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
//	}
//
//}
