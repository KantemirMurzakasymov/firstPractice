//package com.example.firstpractice.userdomein;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Data
//@Entity
//public class Privilege {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long privilegeId;
//
//    private String name;
//
//    @ManyToMany(mappedBy = "privileges")
//    private List<Role> roles;
//
//    public Privilege() {
//    }
//
//    public Privilege(String name, List<Role> roles) {
//        this.name = name;
//        this.roles = roles;
//    }
//}
