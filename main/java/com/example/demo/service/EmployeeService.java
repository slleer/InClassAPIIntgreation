package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> filterByAgeGreaterThan(List<Employee> employeeList, int age);
    List<List<EmployeeDTO>> groupByAge(List<Employee> employeeList, int age);


}
