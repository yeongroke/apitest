package com.yrkim.apitest.controller;

import com.yrkim.apitest.exception.ApiNullException;
import com.yrkim.apitest.handler.ResponseCode;
import com.yrkim.apitest.model.bean.UserDTO;
import com.yrkim.apitest.model.entity.User;
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
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

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
    @PostMapping(value = "user" , consumes = {MediaType.APPLICATION_JSON_VALUE} , produces = "application/json")
    public ResponseResult insertUser(
        @ApiParam(name = "userDto", value = "회원정보", required = true)
        @RequestBody @Valid UserDTO userDto
    ) {
        if(userDto.getName().trim().length() == 0) {
            throw new ApiNullException(ResponseCode.INVALID_PARAMETER);
        }
        ResponseResult responseResult = userService.saveUser(userDto);

        return responseResult;
    }

    @GetMapping(value = "users" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
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

    @GetMapping(value = "{id}" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
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

    @DeleteMapping(value = "{id}" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
    @ApiOperation(value = "delete user" , notes = "유저 삭제")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "정상 실행"),
            @ApiResponse(code = 400, message = "SQL실행 실패"),
            @ApiResponse(code = 403, message = "권한 없음"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public ResponseResult deleteUserById(@PathVariable Long id) {
        return userService.deleteByIdUser(id);
    }

    @PutMapping(value = "{id}")
    @ApiOperation(value = "update user" , notes = "유저 변경")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "정상 실행"),
            @ApiResponse(code = 400, message = "SQL실행 실패"),
            @ApiResponse(code = 403, message = "권한 없음"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    public ResponseResult updateUser(@PathVariable Long id ,
        @ApiParam(name = "userDTO" , value = "회원정보" , required = true)
        @RequestBody @Valid UserDTO userDTO
    ) {
        return ResponseResult.builder().build();
    }
}
