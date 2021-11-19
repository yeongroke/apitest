package com.yrkim.apitest.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String productName;
    private String productDescription;
    private DeliveryDTO delivery;
    private List<OptionInfoDTO> options;
}
