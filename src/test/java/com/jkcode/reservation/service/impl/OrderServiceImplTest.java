package com.jkcode.reservation.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.jkcode.reservation.entity.Order;
import com.jkcode.reservation.entity.User;
import com.jkcode.reservation.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void testGetOrdersByUser() {
        User user = new User();
        user.setId(1L);
        List<Order> expectedOrders = Arrays.asList(new Order(), new Order());
        when(orderRepository.findByUserId(1L)).thenReturn(expectedOrders);

        List<Order> actualOrders = orderService.getOrdersByUser(user);
        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    void testCreateOrder() {
        Order order = new Order();
        when(orderRepository.save(order)).thenReturn(order);

        Order actualOrder = orderService.createOrder(order);
        assertEquals(order, actualOrder);
    }

    @Test
    void testUpdateOrder() {
        Order order = new Order();
        when(orderRepository.save(order)).thenReturn(order);

        Order actualOrder = orderService.updateOrder(order);
        assertEquals(order, actualOrder);
    }

    @Test
    void testDeleteOrder() {
        Order order = new Order();
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        orderService.deleteOrder(1L);
        assertTrue(order.isDeleted());
        verify(orderRepository).save(order);
    }

}
