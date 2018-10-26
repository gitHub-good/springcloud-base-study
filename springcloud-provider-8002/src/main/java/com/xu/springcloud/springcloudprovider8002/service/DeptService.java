package com.xu.springcloud.springcloudprovider8002.service;


import com.springcloud.springcloudcommoninterfaceapi.entities.Dept;

import java.util.List;

public interface DeptService {

	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
