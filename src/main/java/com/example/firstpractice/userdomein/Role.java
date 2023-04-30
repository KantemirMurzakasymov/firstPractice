//package com.example.firstpractice.userdomein;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Data
//@Entity
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long roleId;
//
//    private String name;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "roles_privileges",
//            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"),
//            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "privilegeId"))
//    private List<Privilege> privileges;
//
//    @OneToMany(mappedBy = "role")
//    private List<User> users;
//
//    public Role() {
//    }
//
//    public Role(String name, List<Privilege> privileges, List<User> users) {
//        this.name = name;
//        this.privileges = privileges;
//        this.users = users;
//    }
//}
