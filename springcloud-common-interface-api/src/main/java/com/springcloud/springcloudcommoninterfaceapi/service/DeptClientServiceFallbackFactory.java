package com.springcloud.springcloudcommoninterfaceapi.service;

import com.springcloud.springcloudcommoninterfaceapi.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务的降级处理
 * 	FallbackFactory必须继承该类：
 * 		1.如果出现调用的服务出现故障或暂时停止服务则需要进行服务的降级处理，防止客户访问长时间的等待
 * 		2.则如下该类可以批量处理业务的请求操作并进行降级返回信息给客户
 */
@Component // 不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable throwable) {
		return new DeptClientService() {
			@Override
			public Dept get(long id) {
				Dept dept = new Dept();
				dept.setDeptno(id);
				dept.setDname(clientMessage());
				dept.setDb_source("no this database in MySQL");
				return dept;
			}
			@Override
			public List<Dept> list() {
				List<Dept> deptList = new ArrayList<Dept>();
				Dept dept = new Dept();
				dept.setDname(clientMessage());
				dept.setDb_source("no this database in MySQL");
				deptList.add(dept);
				return deptList;
			}
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

    /**
     * 服务降级时的友好提示
	 * @return
     */
	private String clientMessage(){
		String msg = "该服务正在维护升级，暂停服务，请访问xxxxx服务，谢谢配合！！！";
		return msg;
	}
}
