package com.tpirates.apitest.model.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "API Response Message", description = "API Response Message")
public class ApiDTO<T> implements Serializable {
    private static final long serialVersionUID = -8987146499044811408L;

    @ApiModelProperty(required = true)
    private Integer responseCode;
    @ApiModelProperty(required = true)
    private String message;
    @ApiModelProperty(required = true)
    private T data;
}