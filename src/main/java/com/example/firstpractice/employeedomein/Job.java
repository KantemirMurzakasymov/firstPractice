package com.example.firstpractice.employeedomein;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @NotBlank
    private String jobTitle;

    @NotBlank
    private String minSalary;

    @NotBlank
    private String maxSalary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="departmentId")
    private Department department;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job") // buraya sonradan koyuldu cascade type
    private Set<Employee> employees = new HashSet<>();
//    private Set<Employee> employees = new HashSet<>();

    public Job() {
    }

    public Job(String jobTitle, String minSalary, String maxSalary){
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }
}
