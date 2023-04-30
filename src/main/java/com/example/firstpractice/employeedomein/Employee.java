package com.example.firstpractice.employeedomein;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String phoneNumber;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId")
    private Job job;  // , foreignKey = @ForeignKey(foreignKeyDefinition = "job_fk")

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentId")
    private Department department; // foreignKey = @ForeignKey(foreignKeyDefinition = "department_fk")

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd ")
    private LocalDate registerDate;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String phoneNumber, Job job,
                    Department department, LocalDate registerDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.department = department;
        this.registerDate = registerDate;
    }

    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    //    private LocalDateTime registerTime;

}
