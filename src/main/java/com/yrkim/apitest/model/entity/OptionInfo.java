package com.yrkim.apitest.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OptionInfo")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opId" , updatable = false, nullable = false, columnDefinition = "INT(11)")
    private Long id;

    @Column(name = "optionName" , nullable = false, length = 50)
    private String optionName;

    @Column(name = "optionPrice" , nullable = false, length = 50)
    private String optionPrice;

    @Column(name = "optionStock" , nullable = false, length = 50)
    private String optionStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order optionid;
}
