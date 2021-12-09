package com.yrkim.apitest.service;

import com.yrkim.apitest.model.bean.UserDTO;
import com.yrkim.apitest.model.response.ListResult;
import com.yrkim.apitest.model.response.SingleResult;
import org.springframework.data.domain.Pageable;

public interface UserService {
    SingleResult<UserDTO> saveUser(UserDTO userDTO);
    ListResult<UserDTO> findAllUsers(Pageable pageable);
    SingleResult<UserDTO> findByIdUser(Long id);
}
