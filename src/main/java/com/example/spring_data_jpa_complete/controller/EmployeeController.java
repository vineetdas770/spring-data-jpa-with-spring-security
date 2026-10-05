package com.example.spring_data_jpa_complete.controller;

import com.example.spring_data_jpa_complete.dto.EmployeeDTO;
import com.example.spring_data_jpa_complete.entity.Employee;
import com.example.spring_data_jpa_complete.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody Employee employee){
        EmployeeDTO e =employeeService.addEmployee(employee);
        return ResponseEntity.ok(e);
    }

    @GetMapping("/findAllEmployees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        List<EmployeeDTO> e = employeeService.getAllEmployee();
        return ResponseEntity.ok(e);
    }

    @GetMapping("/findActiveEmployees")
    public ResponseEntity<List<EmployeeDTO>> getAllActiveEmployee(){
        List<EmployeeDTO> e = employeeService.getAllActiveEmployee("Active");
        return ResponseEntity.ok(e);
    }

    @GetMapping("/findAllEmployeesWithPaging")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeWithPaging
            (@RequestParam("page")int page, @RequestParam("size")int size){
        List<EmployeeDTO> e = employeeService.getAllEmployeeWithPaging(page,size);
        return ResponseEntity.ok(e);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/healthStatus")
    public String getHealth(){
        return "Healthy";
    }

}
