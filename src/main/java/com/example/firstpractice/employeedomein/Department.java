package com.example.firstpractice.employeedomein;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
//@NamedQueries({
//        @NamedQuery(name = "department.findByName", query = "SELECT d FROM department d")
//})
public class Department {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @NotBlank
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // buraya sonradan koyuldu cascade type
    @JoinColumn(name="locationId")
     private Location location;      //foreignKey = @ForeignKey(foreignKeyDefinition = "location_fk")

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department") // buraya sonradan koyuldu cascade type
    private Set<Job> jobs = new HashSet<>();

    public Department() {
    }

    public Department(String departmentName, Location location){
        this.departmentName = departmentName;
        this.location = location;
    }
}
