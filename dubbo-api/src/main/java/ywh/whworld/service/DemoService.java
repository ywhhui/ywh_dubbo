package ywh.whworld.service;

import org.springframework.web.bind.annotation.RequestBody;
import ywh.whworld.model.RpcRequestVo;
import ywh.whworld.model.RpcResponse;

/**
 * api
 */
public interface DemoService {

    String sayName(String name);

    RpcResponse rpcTest(@RequestBody RpcRequestVo rpcRequestVo);
}
