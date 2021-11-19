package com.yrkim.apitest.service;

import com.yrkim.apitest.model.bean.OrderDTO;
import com.yrkim.apitest.model.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void addOrder(OrderDTO orderDTO);
    List<Order> findAllOrderList();
}
