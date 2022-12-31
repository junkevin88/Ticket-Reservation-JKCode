package com.jkcode.reservation.service.impl;

import com.jkcode.reservation.entity.Order;
import com.jkcode.reservation.entity.User;
import com.jkcode.reservation.repository.OrderRepository;
import com.jkcode.reservation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> getOrdersByUser(User user) {
            return orderRepository.findByUserId(user.getId());
        }


    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {

            // Retrieve the Order entity with the given id
            Order order = orderRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));

            // Set the 'deleted' field of the Order entity to true
            order.setDeleted(true);
            // Save the updated Order entity
            orderRepository.save(order);
    }
}
