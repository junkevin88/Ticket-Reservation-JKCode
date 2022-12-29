package com.jkcode.reservation.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jkcode.reservation.entity.Order;
import com.jkcode.reservation.entity.User;
import java.util.List;

import com.jkcode.reservation.util.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserId() {

        // create user1 and save it to the database
        User user1 = new User(1L, "John", "Doe", "john@example.com", "password");
        userRepository.save(user1);

        // create user2 and save it to the database
        User user2 = new User(2L, "Jane", "Doe", "jane@example.com", "password");
        userRepository.save(user2);

        // Save a few orders to the database
        Order order1 = new Order(1L, user1, null, null, null, 5000, OrderStatus.PENDING, false);
        Order order2 = new Order(2L, null, null, null, null, 5000, OrderStatus.PENDING, false);
        Order order3 = new Order(3L, user2, null, null, null, 0, OrderStatus.PENDING, false);
        Order order4 = new Order(4L, user2, null, null, null, 500, OrderStatus.PENDING, false);

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);


        // When
        List<Order> ordersForUser2  = orderRepository.findByUserId(user2.getId());

        // check that the correct number of orders is returned
        assertEquals(2, ordersForUser2.size());

//         check that the orders are the ones we expect
        assertTrue(ordersForUser2.contains(order3));
        assertTrue(ordersForUser2.contains(order4));
    }

}

