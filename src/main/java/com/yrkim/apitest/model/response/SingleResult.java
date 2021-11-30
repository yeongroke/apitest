package com.yrkim.apitest.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleResult<T> extends ResponseResult {
    private T singleData;
}
