package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeJSON {
    private String status;
    private Employee[] data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee[] getData() {
        return data;
    }

    public void setData(Employee[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EmployeeJSON{" +
                "status='" + status + '\'' +
                ", employeesArray=" + Arrays.toString(data) +
                '}';
    }
}
