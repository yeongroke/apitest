package com.yrkim.apitest.service.Impl;

import com.yrkim.apitest.model.bean.OrderDTO;
import com.yrkim.apitest.model.entity.Order;
import com.yrkim.apitest.repository.DeliveryRepository;
import com.yrkim.apitest.repository.OptionRepository;
import com.yrkim.apitest.repository.OrderRepository;
import com.yrkim.apitest.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServcieImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OptionRepository optionRepository;
    private final DeliveryRepository deliveryRepository;

    @Override
    public void addOrder(OrderDTO orderDTO) {
        Order order = new Order(orderDTO);
        orderRepository.save(order);
    }

    @Override
    public List<Order> findAllOrderList() {
        return orderRepository.findAll().stream()
                .map(val -> {
                    if(val == null) return null;
                    return val;
                })
                .collect(Collectors.toList());
    }
}
