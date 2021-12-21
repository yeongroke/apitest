package com.yrkim.apitest.events;

import com.yrkim.apitest.annotation.TestDscription;
import com.yrkim.apitest.common.CommonTest;
import com.yrkim.apitest.model.bean.*;
import groovy.util.logging.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class OrderControllerTest extends CommonTest {

    @Before
    public void before() {

    }

    /*
    * MockMvc을 활용한 테스트 케이스 생성
    * TODO junit 등 활용하기
    * */
    @TestDscription(value = "order craete")
    @Test
    @Rollback(value = true)
    public void createOrderTest() throws Exception {
        UserDTO userDTO = UserDTO.builder()
                .id(2L)
                .build();

        DeliveryStatusDTO deliveryStatusDTO = DeliveryStatusDTO.builder()
                .deliveryStatus("READY")
                .build();

        DeliveryDTO deliveryDTO = DeliveryDTO.builder()
                .deliveryClosing("Open")
                .deliveryPrice("20000")
                .deliveryStatusDTO(deliveryStatusDTO)
                .build();

        List<OptionInfoDTO> options = IntStream.range(0,5)
                .mapToObj(index -> {
                    OptionInfoDTO optionInfoDTO = OptionInfoDTO.builder()
                            .optionName("optionInfo"+index)
                            .optionPrice(String.valueOf(index*10000))
                            .optionStock(String.valueOf(index*10))
                            .build();
                    return optionInfoDTO;
                }).collect(Collectors.toList());

        OrderDTO orderDTO = OrderDTO.builder()
                .user(userDTO)
                .delivery(deliveryDTO)
                .productDescription("order1")
                .productName("ordername1")
                .options(options)
                .build();

        mockMvc.perform(post("/api/order/order")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .content(objectMapper.writeValueAsString(orderDTO))
                )
            .andDo(print())
            .andExpect(HttpStatus.OK);
    }
}
