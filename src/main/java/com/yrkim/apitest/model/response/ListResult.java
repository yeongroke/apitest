package com.yrkim.apitest.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class ListResult<T> extends ResponseResult {
    private Collection<T> listData;
    private long totalPages;
    private long nowPage;
    private long totalElements;
    private long pageLimit;
}
