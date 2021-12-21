package com.yrkim.apitest.model.bean;

import com.yrkim.apitest.model.entity.Delivery;
import com.yrkim.apitest.model.entity.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryDTO {
    private DeliveryStatusDTO deliveryStatusDTO;
    private String deliveryClosing;
    private String deliveryPrice;

    public DeliveryDTO(Delivery delivery) {
        this.deliveryClosing = delivery.getDeliveryClosing();
        this.deliveryPrice = delivery.getDeliveryPrice();
        this.deliveryStatusDTO = new DeliveryStatusDTO(delivery.getDeliveryType());
    }

    public Delivery toDelivery(DeliveryDTO deliveryDTO) {
        Delivery delivery = Delivery.builder()
                .deliveryPrice(deliveryDTO.deliveryPrice)
                .deliveryClosing(deliveryDTO.deliveryClosing)
                .deliveryType(new DeliveryStatusDTO().toDeliveryStatus(deliveryDTO.getDeliveryStatusDTO()))
                .build();
        return delivery;
    }
}
