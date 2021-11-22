package com.yrkim.apitest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Table(name = "Delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deId" , updatable = false, nullable = false, columnDefinition = "INT(11)")
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryType;

    @Column(name = "deliveryClosing" , nullable = false, length = 50)
    private String deliveryClosing;

    @Column(name = "deliveryPrice" , nullable = false, length = 50)
    private String deliveryPrice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    @JsonIgnore
    @ToString.Exclude
    private Order deliveryid;
}
