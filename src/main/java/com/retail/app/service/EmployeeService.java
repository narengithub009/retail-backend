package com.retail.app.service;

import com.retail.app.model.Employee;
import com.retail.app.repositry.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> FindAllEmployees(){

        return employeeRepository.findAll();
    }

}
