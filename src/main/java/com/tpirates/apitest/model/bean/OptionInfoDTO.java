package com.tpirates.apitest.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionInfoDTO {
    private String optionName;
    private String optionPrice;
    private String optionStock;
}
