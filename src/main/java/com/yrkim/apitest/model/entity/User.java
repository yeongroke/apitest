package com.yrkim.apitest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yrkim.apitest.util.ValidationPattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Setter @Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "UserName")
    private String name;

    @Column(name = "UserEmail")
    private String email;

    @Column(name = "UserPassword")
    private String password;

    @Column(name = "UserEnabled")
    private Boolean enabled;

    @Column(name = "UserPhone")
    private String phone;

    @Embedded
    private Address address;

    @Column(name = "UserCreateDate")
    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime createDate;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.REMOVE)
    @JsonIgnore
    @ToString.Exclude
    private List<UserFiles> userFilesList = new ArrayList<>();

    @OneToMany(mappedBy = "user_order_id" , cascade = CascadeType.REMOVE)
    @JsonIgnore
    @ToString.Exclude
    private List<Order> orderList = new ArrayList<>();

    @Transient
    @JsonIgnore
    private static final int MAX_PASSWORD_LENGTH = 21;

    @Transient
    @JsonIgnore
    private static final int MIN_PASSWORD_LENGTH = 5;

    @Transient
    public boolean isValid() {
        return isValidId(this.email) && isValidPassword(this.password);
    }

    @Transient
    public static boolean isValidId(String userEmail) {
        return ValidationPattern.EMAIL_Check.matcher(userEmail).matches();
    }

    @Transient
    public static boolean isValidPassword(String userPassword) {
        int userPasswordLength = userPassword.length();

        return userPasswordLength >= MIN_PASSWORD_LENGTH &&
                userPasswordLength <= MAX_PASSWORD_LENGTH;
    }
}

