package com.yrkim.apitest.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult implements Serializable {
    private static final long serialVersionUID = 5057954049311281252L;

    @ApiModelProperty(value = "실행결과", required = true)
    private String result;

    @ApiModelProperty(value = "Error 발생여부", required = true)
    private boolean isSuccess;

}
