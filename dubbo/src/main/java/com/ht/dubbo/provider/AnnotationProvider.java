package com.ht.dubbo.provider;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class AnnotationProvider {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProviderConfigguratuin.class);
        context.start();
        System.in.read();

    }
}


