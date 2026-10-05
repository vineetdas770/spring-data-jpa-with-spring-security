package com.example.spring_data_jpa_complete.service;

import com.example.spring_data_jpa_complete.dto.EmployeeDTO;
import com.example.spring_data_jpa_complete.entity.Employee;
import com.example.spring_data_jpa_complete.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeDTO addEmployee(Employee employee) {
        Employee emp = employeeRepository.save(employee);
        return employee.toDTO(emp);
    }

    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepository.findAllEmployee().stream().map(Employee::toDTO).toList();
    }

    public List<EmployeeDTO> getAllActiveEmployee(String status) {
        return employeeRepository.findAllActiveEmployee(status).stream().map(Employee::toDTO).toList();
    }

    public List<EmployeeDTO> getAllEmployeeWithPaging(int page, int size) {
        Pageable pageable = PageRequest.of(page,size,Sort.by("id").descending());
        return employeeRepository.findALlEmployeeWithPaging(pageable).map(Employee::toDTO).toList();
    }
}
