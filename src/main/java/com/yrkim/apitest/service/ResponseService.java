package com.yrkim.apitest.service;

import com.yrkim.apitest.handler.ResponseCode;
import com.yrkim.apitest.model.response.ResponseResult;
import com.yrkim.apitest.model.response.ListResult;
import com.yrkim.apitest.model.response.SingleResult;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    // 단일건 결과를 처리하는 메소드
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setSingleData(data);
        setSuccessResult(result);
        return result;
    }

    // 다중건 결과를 처리하는 메소드
    public <T> ListResult<T> getListResult(Page<T> pageObj) {
        ListResult<T> result = new ListResult<>();
        result.setListData(pageObj.getContent());
        result.setTotalElements(pageObj.getTotalElements());
        result.setTotalPages(pageObj.getTotalPages());
        result.setNowPage(pageObj.getNumber() + 1);
        result.setPageLimit(pageObj.getSize());
        setSuccessResult(result);
        return result;
    }

    // 성공 결과만 처리하는 메소드
    public ResponseResult getSuccessResult() {
        ResponseResult result = new ResponseResult();
        result.setResponseCode(200);
        result.setMessage("Success");
        return result;
    }

    // 실패 결과만 처리하는 메소드
    public ResponseResult getFailResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        result.setResponseCode(code);
        result.setMessage(msg);
        return result;
    }

    // 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
    private void setSuccessResult(ResponseResult result) {
        result.setResponseCode(ResponseCode.SUCCESS.getStatus());
        result.setMessage(ResponseCode.SUCCESS.getMessage());
    }
}