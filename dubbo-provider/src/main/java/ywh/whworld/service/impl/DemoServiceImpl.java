package ywh.whworld.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Value;
import ywh.whworld.model.RpcRequestVo;
import ywh.whworld.model.RpcResponse;
import ywh.whworld.service.DemoService;


/**
 * 提供服务调
 */
@DubboService(interfaceClass = DemoService.class,interfaceName = "${demo.service.name}",version = "${demo.service.version}")
public class DemoServiceImpl  implements DemoService {

    @Value("${demo.service.name}")
    private String serviceName;

    @Override
    public String sayName(String name) {
        RpcContext rpcContext = RpcContext.getContext();
        return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s",
                serviceName,
                rpcContext.getLocalPort(),
                rpcContext.getMethodName(),
                name,
                name);
    }

    @Override
    public RpcResponse rpcTest(RpcRequestVo rpcRequestVo) {
        RpcResponse rpcResponse = new RpcResponse();
        rpcResponse.setKhh("11");
        rpcResponse.setMm("22");
        return rpcResponse;
    }


}
