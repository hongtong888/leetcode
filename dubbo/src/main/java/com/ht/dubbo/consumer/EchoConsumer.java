package com.ht.dubbo.consumer;

import com.ht.dubbo.provider.EchoService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Component;

@Component
public class EchoConsumer {

    @Reference
    private EchoService echoService;

    public String echo(String name){
        return echoService.echo(name);
    }
}
