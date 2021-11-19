package com.yrkim.apitest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yrkim.apitest.model.bean.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrderApi")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId" , updatable = false, nullable = false, columnDefinition = "INT(11)")
    private Long id;

    @Column(name = "productName" , nullable = false, length = 50)
    private String productName;

    @Column(name = "productDescription" , nullable = false)
    private String productDescription;

    @OneToOne(mappedBy = "deliveryid")
    @JsonIgnore
    private Delivery delivery;

    @Column(name = "registerDate" , nullable = false)
    @CreationTimestamp
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime registerDate;

    @OneToMany(mappedBy = "optionid")
    @JsonIgnore
    private List<OptionInfo> options;

    public Order(OrderDTO orderDTO) {
        this.productName = orderDTO.getProductName();
        this.productDescription = orderDTO.getProductDescription();
    }

}
