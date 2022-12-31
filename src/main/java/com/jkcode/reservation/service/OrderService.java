package com.jkcode.reservation.service;

import com.jkcode.reservation.entity.Order;
import com.jkcode.reservation.entity.User;

import java.util.List;

public interface OrderService {

    /**
     * Retrieves all orders made by the given user
     * @param user the user
     * @return a list of orders made by the user
     */
    List<Order> getOrdersByUser(User user);

    /**
     * Creates a new order
     * @param order the order to be created
     * @return the created order
     */
    Order createOrder(Order order);

    /**
     * Updates an existing order
     * @param order the updated order
     * @return the updated order
     */
    Order updateOrder(Order order);

    /**
     * Deletes an existing order
     * @param id the id of the order to be deleted
     */
    void deleteOrder(Long id);

}
