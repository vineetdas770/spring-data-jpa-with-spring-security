package com.example.spring_data_jpa_complete.dto;

import com.example.spring_data_jpa_complete.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class EmployeeDTO {
    Long employeeId;
    String employeeName;
    Long employeeSalary;

    public EmployeeDTO(Employee employee){
        this.employeeId = employee.getId();
        this.employeeName=employee.getName();
        this.employeeSalary=employee.getSalary();
    }

}
