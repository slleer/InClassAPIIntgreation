package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeDTO;
import com.example.demo.domain.EmployeeJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final RestTemplate restTemplate;
    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<EmployeeDTO> filterByAgeGreaterThan(int age) {
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        RestTemplate restTemplate = new RestTemplate();
        EmployeeJSON employeesArr = restTemplate.getForObject(url, EmployeeJSON.class);
        List<Employee> employees = Arrays.asList(employeesArr.getData());
        return employees.stream().filter(e -> e.getEmployee_age() > age).map(employee -> new EmployeeDTO(employee)).collect(Collectors.toList());
    }

    @Override
    public List<List<EmployeeDTO>> groupByAge() {
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        RestTemplate restTemplate = new RestTemplate();
        EmployeeJSON employeesArr = restTemplate.getForObject(url, EmployeeJSON.class);
        List<Employee> employees = Arrays.asList(employeesArr.getData());
        List<EmployeeDTO> employeeDTOList = employees.stream().map(e -> new EmployeeDTO(e)).collect(Collectors.toList());
        Map<Integer, List<EmployeeDTO>> emp = employeeDTOList.stream().collect(Collectors.groupingBy(EmployeeDTO::getAge, Collectors.toList()));
        return emp.values().stream().collect(Collectors.toList());
    }
}
