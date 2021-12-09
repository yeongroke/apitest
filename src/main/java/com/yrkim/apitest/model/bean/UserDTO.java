package com.yrkim.apitest.model.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yrkim.apitest.model.entity.Address;
import com.yrkim.apitest.model.entity.User;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class UserDTO {
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String email;
    private String phone;
    private String city;
    private String street;
    private String zipcode;

    public UserDTO(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.city = user.getAddress().getCity();
        this.street = user.getAddress().getStreet();
        this.zipcode = user.getAddress().getZipcode();
    }

    public User toUser(UserDTO userDTO) {
        User user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .address(new Address(userDTO.getCity(), userDTO.getStreet(), userDTO.getZipcode()))
                .build();
        return user;
    }
}
