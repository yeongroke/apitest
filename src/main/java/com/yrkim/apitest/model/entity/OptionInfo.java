package com.yrkim.apitest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Setter @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Builder
@Table(name = "OptionInfo")
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
    @ToString.Exclude
    @JsonIgnore
    private Order optionid;
}
