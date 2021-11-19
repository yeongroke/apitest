package com.yrkim.apitest.model.response;

import lombok.Data;

import java.util.Collection;

@Data
public class ListReslut<T> {
    private Collection<T> listData;
}
