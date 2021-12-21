package com.yrkim.apitest.service;

import com.yrkim.apitest.model.bean.OrderDTO;
import com.yrkim.apitest.model.entity.Order;
import com.yrkim.apitest.model.response.ListResult;
import com.yrkim.apitest.model.response.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    SingleResult<OrderDTO> addOrder(OrderDTO orderDTO);
    ListResult<OrderDTO> findAllOrderList();
}
