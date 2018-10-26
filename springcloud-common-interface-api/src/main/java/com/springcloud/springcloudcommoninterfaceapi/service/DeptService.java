package com.springcloud.springcloudcommoninterfaceapi.service;

import com.springcloud.springcloudcommoninterfaceapi.entities.Dept;

import java.util.List;

/**
 * @Auther: 徐亮亮
 * @Date: 2018/10/26 19:28
 * @Description:Dept服务提供者使用的接口
 */
public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
