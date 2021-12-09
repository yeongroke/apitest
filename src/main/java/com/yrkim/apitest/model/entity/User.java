package com.yrkim.apitest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yrkim.apitest.model.bean.UserDTO;
import com.yrkim.apitest.util.ValidationPattern;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "UserName" ,nullable = false)
    private String name;

    @Column(name = "UserEmail" ,nullable = false)
    private String email;

    @Column(name = "UserPassword")
    @ColumnDefault("test1234")
    private String password;

    @Column(name = "UserEnabled" , nullable = false)
    @ColumnDefault("N")
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
        return isValidId(this.name) && isValidPassword(this.password);
    }

    @Transient
    public static boolean isValidId(String userName) {
        return ValidationPattern.EMAIL_Check.matcher(userName).matches();
    }

    @Transient
    public static boolean isValidPassword(String userPassword) {
        int userPasswordLength = userPassword.length();

        return userPasswordLength >= MIN_PASSWORD_LENGTH &&
                userPasswordLength <= MAX_PASSWORD_LENGTH;
    }
}

