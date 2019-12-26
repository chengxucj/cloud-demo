package com.hp.controller;

import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("customer")
public class ConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;//eureka客户端

    @Autowired
    private RestTemplate restTemplate;

//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id) {
//        String url = "http://localhost:8089/user/" + id;
//        return this.restTemplate.getForObject(url, User.class);
//    }

//        @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id) {
//            //获取服务
//            final List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//            //列表中取出一个服务实例
//            ServiceInstance ServiceInstance=instances.get(0);
//            String url="http://"+ServiceInstance.getHost()+":"+ServiceInstance.getPort()+"/user/"+id;
//            return this.restTemplate.getForObject(url, User.class);
//    }

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        String url="http://user-service/user/"+id;
        return this.restTemplate.getForObject(url, User.class);
    }
}
