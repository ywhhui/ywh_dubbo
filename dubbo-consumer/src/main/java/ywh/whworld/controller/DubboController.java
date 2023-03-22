package ywh.whworld.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ywh.whworld.model.RpcRequestVo;
import ywh.whworld.model.RpcResponse;
import ywh.whworld.service.DemoService;


@RestController
public class DubboController {

    /**
     * interfaceClass 需要发布的 服务提供方的实现类 interfaceName 实现类名称 version  check启动时忽略检查
     * loadbalance 负载均衡算法  random,roundrobin,leastactive，分别表示：随机，轮循，最少活跃调用
     * timeout 远程服务调用超时时间(毫秒)
     * retries 远程服务调用重试次数，不包括第一次调用，不需要重试请设为0
     * async 是否缺省异步执行，不可靠异步，只是忽略返回值，不阻塞执行线程
     */
    @DubboReference(interfaceClass = DemoService.class,interfaceName = "${demo.service.name}",version = "${demo.service.version}",check = false,timeout = 3000,retries=2,loadbalance = "random")
    private DemoService demoService;

    @RequestMapping("/hello")
    public String sayHello(){
        return demoService.sayName("张");
    }

    @PostMapping("/rpc/test")
    public RpcResponse rpcTest(@RequestBody RpcRequestVo rpcRequestVo){
        return demoService.rpcTest(rpcRequestVo);
    }

}
