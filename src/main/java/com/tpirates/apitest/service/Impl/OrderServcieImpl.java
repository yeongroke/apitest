package com.tpirates.apitest.service.Impl;

import com.tpirates.apitest.model.bean.OrderDTO;
import com.tpirates.apitest.model.entity.Order;
import com.tpirates.apitest.repository.DeliveryRepository;
import com.tpirates.apitest.repository.OptionRepository;
import com.tpirates.apitest.repository.OrderRepository;
import com.tpirates.apitest.service.OrderService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServcieImpl implements OrderService {

    @Setter(onMethod_ = @Autowired)
    private OrderRepository orderRepository;
    @Setter(onMethod_ = @Autowired)
    private OptionRepository optionRepository;
    @Setter(onMethod_ = @Autowired)
    private DeliveryRepository deliveryRepository;

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
