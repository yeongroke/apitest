package com.yrkim.apitest.repository;

import com.yrkim.apitest.model.entity.OptionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<OptionInfo,Long> {

}
