package com.retail.app.domain;

import com.retail.app.controller.EmployeeController;
import com.retail.app.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

    @MockBean
    private EmployeeService employeeService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnEmployeeDetails() throws Exception {
        BDDMockito.given(employeeService.FindAllEmployees()).willReturn(List.of());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
