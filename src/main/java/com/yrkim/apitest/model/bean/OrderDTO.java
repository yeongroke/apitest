package com.yrkim.apitest.model.bean;

import com.yrkim.apitest.model.entity.Delivery;
import com.yrkim.apitest.model.entity.OptionInfo;
import com.yrkim.apitest.model.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

    private UserDTO user;
    @NotNull(message = "상품 이름은 필수 입니다.")
    private String productName;
    private String productDescription;
    private DeliveryDTO delivery;
    private List<OptionInfoDTO> options;

    public OrderDTO(Order order) {
        this.user = new UserDTO(order.getUser_order_id());
        this.productName = order.getProductName();
        this.productDescription = order.getProductDescription();
        this.delivery = new DeliveryDTO(order.getDelivery());
        this.options = toOptionInfoDTOs(order.getOptions());
    }

    private List<OptionInfoDTO> toOptionInfoDTOs(List<OptionInfo> entityOptions) {
        List<OptionInfoDTO> optionInfoDTOList = entityOptions.stream()
                .map(optionInfo -> {
                    return new OptionInfoDTO(optionInfo);
                }).collect(Collectors.toList());
        return optionInfoDTOList;
    }

    private List<OptionInfo> toOptions(List<OptionInfoDTO> optionInfoDTOS) {
        List<OptionInfo> optionInfoList = optionInfoDTOS.stream()
                .map(optionInfo -> {
                    return new OptionInfoDTO().toOptionInfo(optionInfo);
                }).collect(Collectors.toList());
        return optionInfoList;
    }

    public Order toOrder(OrderDTO orderDTO) {
        Order order = Order.builder()
                .user_order_id(new UserDTO().toUser(orderDTO.getUser()))
                .options(toOptions(orderDTO.getOptions()))
                .delivery(new DeliveryDTO().toDelivery(orderDTO.getDelivery()))
                .productDescription(orderDTO.getProductDescription())
                .productName(orderDTO.getProductName())
                .build();
        return order;
    }
}
