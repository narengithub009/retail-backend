package com.retail.app.controller;

import com.retail.app.model.Employee;
import com.retail.app.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) {

        Employee savedEmployee = employeeService.saveEmployee(employee);
        MDC.put("UserId", savedEmployee.getName());
        logger.info("Saved Employee : " + savedEmployee.getName());
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.info("Employee Object : ");
        return new ResponseEntity<>(employeeService.FindAllEmployees(), HttpStatus.OK);
    }
}
