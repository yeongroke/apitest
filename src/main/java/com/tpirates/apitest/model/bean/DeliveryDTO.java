package com.tpirates.apitest.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDTO {
    private String deliveryType;
    private String deliveryClosing;
    private String deliveryPrice;
}
