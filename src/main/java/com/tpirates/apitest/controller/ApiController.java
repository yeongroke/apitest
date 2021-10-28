package com.tpirates.apitest.controller;

import com.tpirates.apitest.model.bean.ApiDTO;
import com.tpirates.apitest.model.bean.OrderDTO;
import com.tpirates.apitest.model.entity.Order;
import com.tpirates.apitest.model.response.ResponseResult;
import com.tpirates.apitest.service.OrderService;
import io.swagger.annotations.*;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@ApiOperation(value = "/api" , tags = "Order Api")
public class ApiController {
    @Setter(onMethod_ = @Autowired)
    private OrderService orderService;

    // TODO yrkim : 상품등록
    @ApiOperation(value = "상품등록" , notes = "상품등록")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "정상 실행"),
                    @ApiResponse(code = 400, message = "SQL실행 실패"),
                    @ApiResponse(code = 403, message = "권한 없음"),
                    @ApiResponse(code = 500, message = "서버 에러")
            }
    )
    @ApiParam(name = "orderDTOParams" , value = "" , required = true,
            examples = @Example(value = @ExampleProperty(mediaType = MediaType.APPLICATION_JSON_VALUE , value = "")))
    @PostMapping(value = "/insertOrder")
    public ApiDTO<ResponseResult> insertOrder(
            @RequestBody @Validated final OrderDTO orderDTOParams
    ) {
        log.info("[Request start] {}" , orderDTOParams.getProductName());
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderService.addOrder(orderDTO);
        } catch(Exception e) {
            log.error("Catch : {}" ,e);
            return ApiDTO.<ResponseResult>builder().responseCode(500).message("FAIL").data(new ResponseResult()).build();
        }
        return ApiDTO.<ResponseResult>builder().responseCode(200).message("Success").data(new ResponseResult()).build();
    }

    @ApiOperation(value = "상품 목록을 반환")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "정상 실행"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/OrderList")
    public ResponseEntity<List<Order>> getOrderList(){
        List<Order> orderList = orderService.findAllOrderList();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

}
