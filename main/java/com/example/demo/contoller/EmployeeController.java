package com.example.demo.contoller;

import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeDTO;
import com.example.demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/employees", params = "age")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesAgeGreater(@RequestParam int age) {
        return new ResponseEntity<>(this.employeeService.filterByAgeGreaterThan(age), HttpStatus.OK);
    }
    @GetMapping(value = "/employees", params = "group")
    public ResponseEntity<List<List<EmployeeDTO>>> getEmployeesGroupByAge() {
        return new ResponseEntity<>(this.employeeService.groupByAge(), HttpStatus.OK);
    }

}
