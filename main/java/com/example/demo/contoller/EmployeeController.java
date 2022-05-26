package com.example.demo.contoller;

import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeDTO;
import com.example.demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;
    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{age}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesAgeGreater(@PathVariable int age) {
        String url = "http://dummy.restapiexample.com/api/v1/employees"
        RestTemplate restTemplate = new RestTemplate();
        Employee[] employees = restTemplate.getForObject(url, Employee[].class);
        return ResponseEntity<>(this.employeeService.filterByAgeGreaterThan(Arrays.asList(employees), age));
    }

}
