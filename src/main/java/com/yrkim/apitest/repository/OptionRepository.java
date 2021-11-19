package com.yrkim.apitest.repository;

import com.yrkim.apitest.model.entity.OptionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OptionRepository extends JpaRepository<OptionInfo,Long> {
    @Query(value = "SELECT op.* FROM OPTION_INFO op" , nativeQuery = true)
    List<OptionInfo> findAllOptionList();
}
