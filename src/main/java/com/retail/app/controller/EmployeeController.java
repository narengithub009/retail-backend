package com.retail.app.controller;

import com.retail.app.model.Employee;
import com.retail.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee){

        Employee savedEmployee = employeeService.saveEmployee(employee);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.FindAllEmployees(),HttpStatus.OK);
    }
}
