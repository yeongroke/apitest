package com.yrkim.apitest.controller;

import com.yrkim.apitest.model.response.ResponseResult;
import com.yrkim.apitest.service.OrderService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/*
* @Slf4j : Lombok 어노테이션 , 로그 남기기위해 추가함.
* @RestController : @Controller와 @ResponseBody가 결합된 어노테이션이다. 
* @RequiredArgsConstructor : 
* @RequestMapping("/api") : url에 따라 어떠한 메서드를 매핑하여 처리하는 어노테이션
* @ApiOperation :
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@ApiOperation(value = "/api" , tags = "Order Api")
public class ApiOrderController {

    private final OrderService orderService;

    // TODO yrkim : 상품등록
    /*@ApiOperation(value = "상품등록" , notes = "상품등록")
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
    @PostMapping(value = "/insertOrder" , consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseResult insertOrder(
            @RequestBody @Valid OrderDTO orderDTOParams , BindingResult result
    ) {
        log.info("[Request start] {}" , orderDTOParams.getProductName());
        if(result.hasErrors()) {
            return ResponseResult.builder()
                    .responseCode(500)
                    .message("Fail")
                    .build();
        }
        try {
            orderService.addOrder(orderDTOParams);
        } catch(Exception e) {
            log.error("Catch Exception : {}" ,e);
            return ApiResult.<ResponseResult>builder().responseCode(500).message("FAIL").data(new ResponseResult()).build();
        }
        return ApiResult.<ResponseResult>builder().responseCode(200).message("Success").data(new ResponseResult()).build();
    }*/


    // TODO yrkim : 상품목록 반환
    @ApiOperation(value = "상품 목록을 반환")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "정상 실행"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping(value = "/OrderList/{user_id}" , consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseResult getOrderList(
            @PathVariable(value = "user_id") Long id
    ){

        return null;
    }

}
