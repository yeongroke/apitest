package com.yrkim.apitest.service.Impl;

import com.yrkim.apitest.model.bean.OrderDTO;
import com.yrkim.apitest.model.bean.UserDTO;
import com.yrkim.apitest.model.entity.Order;
import com.yrkim.apitest.model.response.ListResult;
import com.yrkim.apitest.model.response.SingleResult;
import com.yrkim.apitest.repository.DeliveryRepository;
import com.yrkim.apitest.repository.OptionRepository;
import com.yrkim.apitest.repository.OrderRepository;
import com.yrkim.apitest.service.OrderService;
import com.yrkim.apitest.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServcieImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OptionRepository optionRepository;
    private final DeliveryRepository deliveryRepository;
    private final ResponseService responseService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SingleResult<OrderDTO> addOrder(OrderDTO orderDTO) {
        Order order = orderRepository.save(orderDTO.toOrder(orderDTO));

        return responseService.getSingleResult(new OrderDTO(orderRepository.findById(order.getId()).get()));
    }

    @Override
    public ListResult<OrderDTO> findAllOrderList() {
        return null;
    }
}
