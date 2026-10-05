package com.example.spring_data_jpa_complete.entity;

import com.example.spring_data_jpa_complete.dto.EmployeeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String status;
    Long salary;

    public static EmployeeDTO toDTO(Employee employee){
        return new EmployeeDTO(employee);
    }
}
