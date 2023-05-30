package com.spring3.practice.service;

import com.spring3.practice.Employee;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpService {

    @Autowired
    ObservationRegistry registry;
    List<Employee>employees=new ArrayList<>();
    public EmpService(){
        employees.add(new Employee(100,"Shiva",23,25000));
        employees.add(new Employee(101,"Vilas",23,25001));
    }
    public List<Employee> getEmployees(){
        return Observation.createNotStarted("getEmployees",registry)
                .observe(()->employees);
    }
    public Employee getEmployee(int id){
        return Observation.createNotStarted("getEmployee",registry)
                .observe(()-> employees.stream().filter(employee -> employee.id()==id)
                .findAny().orElseThrow(()->new RuntimeException("Id not found")));
    }
}
