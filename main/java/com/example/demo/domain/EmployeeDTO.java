package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private int id;
    private String name;
    private int age;
    private int salary;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name  = employee.getName();
        this.age = employee.getAge();
        this.salary = employee.getSalary();
    }
}
