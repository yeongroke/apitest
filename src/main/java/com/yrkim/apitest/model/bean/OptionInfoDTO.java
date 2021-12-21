package com.yrkim.apitest.model.bean;

import com.yrkim.apitest.model.entity.OptionInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionInfoDTO {
    private String optionName;
    private String optionPrice;
    private String optionStock;

    public OptionInfoDTO(OptionInfo optionInfo) {
        this.optionName = optionInfo.getOptionName();

    }

    public OptionInfo toOptionInfo(OptionInfoDTO optionInfoDTO) {
        OptionInfo optionInfo = OptionInfo.builder()
                .optionName(optionInfoDTO.getOptionName())
                .optionPrice(optionInfoDTO.getOptionPrice())
                .optionStock(optionInfoDTO.getOptionStock())
                .build();
        return optionInfo;
    }
}
