package com.yrkim.apitest.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Delivery")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deId" , updatable = false, nullable = false, columnDefinition = "INT(11)")
    private Long id;

    @Column(name = "deliveryType" , nullable = false, length = 50)
    private String deliveryType;

    @Column(name = "deliveryClosing" , nullable = false, length = 50)
    private String deliveryClosing;

    @Column(name = "deliveryPrice" , nullable = false, length = 50)
    private String deliveryPrice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order deliveryid;
}
