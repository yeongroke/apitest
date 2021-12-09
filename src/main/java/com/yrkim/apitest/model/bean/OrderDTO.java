package com.yrkim.apitest.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    @NotEmpty(message = "상품 이름은 필수 입니다.")
    private String productName;
    private String productDescription;
    private DeliveryDTO delivery;
    private List<OptionInfoDTO> options;
}
