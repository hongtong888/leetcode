package com.ht.dubbo.provider;

import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDubbo(scanBasePackages = "com.ht.dubbo.provider")
public class ProviderConfigguratuin {

    @Bean
    public ProviderConfig providerConfig(){
        return new ProviderConfig();
    }
}
