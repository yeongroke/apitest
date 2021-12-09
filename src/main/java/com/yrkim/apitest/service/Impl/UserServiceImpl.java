package com.yrkim.apitest.service.Impl;

import com.yrkim.apitest.model.bean.UserDTO;
import com.yrkim.apitest.model.entity.User;
import com.yrkim.apitest.model.response.ListResult;
import com.yrkim.apitest.model.response.SingleResult;
import com.yrkim.apitest.repository.UserRepository;
import com.yrkim.apitest.service.ResponseService;
import com.yrkim.apitest.service.UserService;
import com.yrkim.apitest.util.EntityConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ResponseService responseService;
    private final UserRepository userRepository;
    private final EntityConverter entityConverter;

    @Override
    public SingleResult<UserDTO> saveUser(UserDTO userDTO) {
        log.info("save User : {}", String.format("%s",userDTO.toString()));
        User user = userRepository.save(userDTO.toUser(userDTO));
        log.info("save User : {}", String.format("%s",user.toString()));
        return responseService.getSingleResult(new UserDTO(userRepository.findById(user.getId()).get()));
    }

    @Override
    public ListResult<UserDTO> findAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return getUserDTOList(pageable , users);
    }

    @Override
    public SingleResult<UserDTO> findByIdUser(Long id) {
        UserDTO userDTO = new UserDTO(userRepository.findById(id).get());
        return responseService.getSingleResult(userDTO);
    }

    private ListResult<UserDTO> getUserDTOList(Pageable pageable , Page<User>  users) {
        List<UserDTO> userDTOListResult = users.getContent().stream().map(
                (user) -> {
                    return new UserDTO(user);
                }
        ).collect(Collectors.toList());
        Page<UserDTO> userDTOS = new PageImpl<>(userDTOListResult , pageable, users.getTotalElements());
        return responseService.getListResult(userDTOS);
    }
}
