package com.retail.app.domain;

import com.retail.app.model.Employee;
import com.retail.app.repositry.EmployeeRepository;
import com.retail.app.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllEmployees(){

        //Arrange
        Employee emp1 = new Employee(121,"Narender","naren@gmail.com","xyz","admin");
        Employee emp2 = new Employee(122,"Narender2","naren@gmail.com","xyz","admin");

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(emp1,emp2));
        //Act

        List<Employee> employees=employeeService.FindAllEmployees();

        //Assert

        assertEquals(2, employees.size());
        assertEquals("Narender",employees.get(0).getName());
        assertEquals("Narender2",employees.get(1).getName());

    }
}
