package com.hp.controller;


import com.hp.client.UserClient;
import com.hp.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("customer")
//@DefaultProperties(defaultFallback = "defaultFallback")
@EnableFeignClients
public class ConsumerController {

//    @Autowired
//    private DiscoveryClient discoveryClient;//eureka客户端

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

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

//    @GetMapping("{id}")
//    public User queryById(@PathVariable("id") Long id) {
//        String url="http://user-service/user/"+id;
//        return this.restTemplate.getForObject(url, User.class);
//    }

//    @GetMapping("{id}") //第一种熔断
//    @HystrixCommand(fallbackMethod = "queryback")
//    public String queryById(@PathVariable("id") Long id) {
//        String url="http://user-service/user/"+id;
//        return this.restTemplate.getForObject(url, String.class);
//    }
//
//    //当发生失败调用
//    public String queryback(Long id){
//        return "呵呵网络拥堵";
//    }


//    @GetMapping("{id}")
//    @HystrixCommand  //第二种熔断
//    public String queryById(@PathVariable("id") Long id) {
//        String url="http://user-service/user/"+id;
//        return this.restTemplate.getForObject(url, String.class);
//    }
//
//    //当发生失败调用defaultFallback
//    public String defaultFallback(){
//        return "呵呵网络拥堵";
//    }

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userClient.queryById(id);
    }
}
