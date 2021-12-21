package com.yrkim.apitest.repository;

import com.yrkim.apitest.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepositoyCustom {

    Page<User> findByUserId(long id , Pageable pageable);
}
