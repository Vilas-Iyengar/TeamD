package com.consumer.clientconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ApiConfig {

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl("http://localhost:8080")
                .build();
    }
    @Bean
    public ConsumerServiceApp consumerServiceApp(){
        HttpServiceProxyFactory httpServiceProxyFactory= HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient()))
                .build();
        return httpServiceProxyFactory.createClient(ConsumerServiceApp.class);
    }

}
