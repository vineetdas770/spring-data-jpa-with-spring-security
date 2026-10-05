package com.example.spring_data_jpa_complete.repository;

import com.example.spring_data_jpa_complete.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.Arrays;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e from Employee e")
    List<Employee> findAllEmployee();

    @Query("SELECT e from Employee e where e.status = :status")
    List<Employee> findAllActiveEmployee(@Param("status") String status);

    @Query("SELECT e from Employee e")
    Page<Employee> findALlEmployeeWithPaging(Pageable pageable);
}
