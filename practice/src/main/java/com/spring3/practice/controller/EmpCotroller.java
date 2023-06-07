package com.spring3.practice.controller;

import com.spring3.practice.Employee;
import com.spring3.practice.security.UserInfo;
import com.spring3.practice.service.EmpService;
import io.micrometer.observation.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpCotroller {

    @Autowired
    EmpService empService;

    @GetMapping("/welcome")
    public String welcome(){
        return  "Welocome to security part";
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Employee> getEmployees(){
        return empService.getEmployees();
    }
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable int id){
        return empService.getEmployee(id);
    }

    @PostMapping("/newUser")
    public String addUserInfo(@RequestBody UserInfo userInfo){
        return empService.addUserInfo(userInfo);
    }
}
