package com.yrkim.apitest.model.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.yrkim.apitest.model.entity.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryStatusDTO {

    private String deliveryStatus;

    public DeliveryStatusDTO(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus.name();
    }

    public DeliveryStatus toDeliveryStatus(DeliveryStatusDTO deliveryStatusDTO) {
        return DeliveryStatus.valueOf(deliveryStatusDTO.getDeliveryStatus().toUpperCase());
    }
}
