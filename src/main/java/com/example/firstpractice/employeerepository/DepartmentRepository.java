package com.example.firstpractice.employeerepository;

import com.example.firstpractice.employeedomein.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

       //@Query(" SELECT  departmentName FROM Department")
       //@Query("SELECT d FROM Department d WHERE d.departmentName = :departmentName")
//      @Query("SELECT departmentName FROM Department ")
//      List<Department> findByName();





}
