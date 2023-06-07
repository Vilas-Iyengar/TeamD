package com.spring3.practice.service;

import com.spring3.practice.Employee;
import com.spring3.practice.repository.UserInfoRepo;
import com.spring3.practice.security.UserInfo;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpService {

    @Autowired
    ObservationRegistry registry;

    @Autowired
   private UserInfoRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;
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

    public String addUserInfo(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repo.save(userInfo);
        return "User added successfully";

    }
}
