package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    List<EmployeeDTO> filterByAgeGreaterThan(int age);
    List<List<EmployeeDTO>> groupByAge();

}
