//package com.example.firstpractice.userdomein;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Data
//@Entity
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long userId;
//
//    private String firstName;
//
//    private String lastName;
//
//    @Column(unique = true, nullable = false)
//    private String username;
//
//    private String email;
//
//    private String password;
//
//    private boolean enabled;
//
//    private boolean accountNonExpired;
//
//    private boolean credentialsNonExpired;
//
//    private boolean accountNonBlocked;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "roleId")
//    private Role role;
//
//    public User() {
//
//        this.enabled = false;
//        this.accountNonExpired = true;
//        this.credentialsNonExpired = true;
//        this.accountNonBlocked = true;
//    }
//
//    public User(String firstName, String lastName, String username, String email, String password, Role role) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//
//        this.enabled = false;
//        this.accountNonExpired = true;
//        this.credentialsNonExpired = true;
//        this.accountNonBlocked = true;
//    }
//}
