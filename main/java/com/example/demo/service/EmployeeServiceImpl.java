package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<EmployeeDTO> filterByAgeGreaterThan(List<Employee> employeeList, int age) {
        return employeeList.stream().filter(e -> e.getAge() > age).map(employee -> new EmployeeDTO(employee)).collect(Collectors.toList());
    }

    @Override
    public List<List<EmployeeDTO>> groupByAge(List<Employee> employeeList, int age) {
        List<EmployeeDTO> employeeDTOList = employeeList.stream().map(e -> new EmployeeDTO(e)).collect(Collectors.toList());
        Map<Integer, List<EmployeeDTO>> emp = employeeDTOList.stream().collect(Collectors.groupingBy(EmployeeDTO::getAge, Collectors.toList()));
        return emp.values().stream().collect(Collectors.toList());
    }
}
