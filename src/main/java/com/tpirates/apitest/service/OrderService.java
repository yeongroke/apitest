package com.tpirates.apitest.service;

import com.tpirates.apitest.model.bean.OrderDTO;
import com.tpirates.apitest.model.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void addOrder(OrderDTO orderDTO);
    List<Order> findAllOrderList();
}
