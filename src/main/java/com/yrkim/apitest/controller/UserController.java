package com.yrkim.apitest.controller;

import com.yrkim.apitest.model.bean.UserDTO;
import com.yrkim.apitest.model.response.ResponseResult;
import com.yrkim.apitest.service.ResponseService;
import com.yrkim.apitest.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
@ApiOperation(value = "/api/user", tags = "user api")
public class UserController {

    private final UserService userService;
    private final ResponseService responseService;

    @ApiOperation(value = "insert user" , notes = "유저 등록")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "정상 실행"),
            @ApiResponse(code = 400, message = "SQL실행 실패"),
            @ApiResponse(code = 403, message = "권한 없음"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping(value = "user" , consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseResult insertUser(
        @ApiParam(name = "userDto" , required = true)
        @RequestBody UserDTO userDto , BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()) {
            return responseService.getFailResult(500,"Error Insert User");
        }
        log.info("insertUser : {}" , String.format("%s",userDto.toString()));
        ResponseResult responseResult = userService.saveUser(userDto);

        return responseResult;
    }

    @GetMapping("users")
    @ApiOperation(value = "all users", notes = "유저 조회")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "정상 실행"),
            @ApiResponse(code = 400, message = "SQL실행 실패"),
            @ApiResponse(code = 403, message = "권한 없음"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public ResponseResult findAllUsers(final Pageable pageable) {
        return userService.findAllUsers(pageable);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "find user" , notes = "특정 유저 조회")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "정상 실행"),
            @ApiResponse(code = 400, message = "SQL실행 실패"),
            @ApiResponse(code = 403, message = "권한 없음"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public ResponseResult findByIdUser(@PathVariable Long id) {
        return userService.findByIdUser(id);
    }
}
