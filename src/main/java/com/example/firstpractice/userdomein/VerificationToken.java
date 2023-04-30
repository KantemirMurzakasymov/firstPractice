//package com.example.firstpractice.userdomein;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.Calendar;
//import java.util.Date;
//
//@Data
//@Entity
//public class VerificationToken {
//
//    @Transient
//    private final Integer EXPIRE_DATE = 60 * 24;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long verificationTokenId;
//
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    private String token;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date expireDate;
//
//    public VerificationToken() {
//
//        this.expireDate = calculateExpireDate(EXPIRE_DATE);
//    }
//
//    public VerificationToken(User user, String token) {
//        this.user = user;
//        this.token = token;
//        this.expireDate = calculateExpireDate(EXPIRE_DATE);
//    }
//
//    private Date calculateExpireDate(Integer EXPIRE_DATE) {
//
//        Calendar calendar = Calendar.getInstance();
//
//        calendar.setTimeInMillis(new Date().getTime());
//
//        calendar.add(Calendar.MINUTE, EXPIRE_DATE);
//
//        return new Date(calendar.getTime().getTime());
//    }
//
//}
