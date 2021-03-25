package com.ht.dubbo.provider;

public class EchoServiceImpl implements EchoService {
    public String echo(String message) {
        System.out.println(message);
        return message;
    }
}
