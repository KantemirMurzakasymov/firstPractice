package com.example.firstpractice.employeedomein;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    private String streetAddress;
    private String postalCode;
    private String city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Set<Department> departments = new HashSet<>();

    public Location() {
    }

    public Location(String streetAddress, String postalCode, String city){
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
    }
}
