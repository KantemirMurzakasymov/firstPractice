package com.example.firstpractice.employeerepository;

import com.example.firstpractice.employeedomein.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
