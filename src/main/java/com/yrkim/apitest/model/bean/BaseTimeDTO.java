package com.yrkim.apitest.model.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.ZonedDateTime;

@Data
public class BaseTimeDTO {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime createDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime updateDate;
}
