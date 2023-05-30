package com.consumer.clientconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ClientController {

    @Autowired
    ConsumerServiceApp consumerServiceApp;

    @GetMapping("/consumer")
    public List<Employee> getEmployees(){
        return consumerServiceApp.getEmployees();
    }
}
