package com.yrkim.apitest.repository;

import com.yrkim.apitest.model.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {

}
