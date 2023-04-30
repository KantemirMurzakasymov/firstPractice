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
//public class PasswordResetToken {
//
//    @Transient
//    private final Integer EXPIRE_DATE = 60 * 24;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long passwordResetTokenId;
//
//    private String token;
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(foreignKeyDefinition = "user_fk"))
//    private User user;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date expireDate;
//
//    public PasswordResetToken() {
//
//        this.expireDate = calculateExpireDate(EXPIRE_DATE);
//    }
//
//    public PasswordResetToken(String token, User user) {
//        this.token = token;
//        this.user = user;
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
//}
