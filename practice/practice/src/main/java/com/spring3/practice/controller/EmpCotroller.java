package com.spring3.practice.controller;

import com.spring3.practice.Employee;
import com.spring3.practice.service.EmpService;
import io.micrometer.observation.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpCotroller {

    @Autowired
    EmpService empService;
    @GetMapping("/getAll")
    public List<Employee> getEmployees(){
        return empService.getEmployees();
    }
    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable int id){
        return empService.getEmployee(id);
    }
}
