package com.example.firstpractice.employeerepository;


import com.example.firstpractice.employeedomein.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
