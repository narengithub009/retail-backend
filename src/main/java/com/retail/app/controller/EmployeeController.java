package com.retail.app.controller;

import com.retail.app.model.Employee;
import com.retail.app.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@Endpoint(id="customActuator")
@RequestMapping("/api/employees/")
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    @WriteOperation
    @PostMapping("/register")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> registerEmployee(@Valid  @RequestBody Employee employee, BindingResult bindResult) {

        if (bindResult.hasErrors()){
            return new ResponseEntity<>(bindResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        Optional<Employee> employee1=employeeService.findByEmail(employee.getEmail());
        if(employee1.isPresent()){
            logger.info("Employee with email {} already exists ",employee.getEmail());
            return  new ResponseEntity<>("Employee already exists",HttpStatus.CONFLICT);
        }
        Employee savedEmployee = employeeService.saveEmployee(employee);
       // MDC.put("UserId", savedEmployee.getName());
        logger.info("Saved Employee Name is  : " + savedEmployee.getName());
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @ReadOperation
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.info("Employee Object : ");
        return new ResponseEntity<>(employeeService.FindAllEmployees(), HttpStatus.OK);
    }
}
