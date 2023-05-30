package com.consumer.clientconsumer;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/emp")
public interface ConsumerServiceApp {


    @GetExchange("/getAll")
    List<Employee> getEmployees();
}
