package com.yrkim.apitest.repository;

import com.yrkim.apitest.model.entity.Delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
    @Query(value = "SELECT d.* FROM DELIVERY d" , nativeQuery = true)
    List<Delivery> findAllDeliveryList();
}
