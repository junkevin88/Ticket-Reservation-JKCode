package com.jkcode.reservation.repository;

import com.jkcode.reservation.entity.Order;
import com.jkcode.reservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long user);
}
