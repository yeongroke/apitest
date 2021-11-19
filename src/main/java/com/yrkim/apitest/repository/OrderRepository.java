package com.yrkim.apitest.repository;

import com.yrkim.apitest.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(value = "SELECT o.* FROM ORDER_API o" , nativeQuery = true)
    List<Order> findAllOrderList();

}
