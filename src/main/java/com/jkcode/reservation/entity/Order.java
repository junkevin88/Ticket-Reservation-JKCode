package com.jkcode.reservation.entity;

import com.jkcode.reservation.util.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="orders")
@Where(clause = "deleted is null")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Column(name = "price")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;  // order status (pending, confirmed, etc.)

    @Column(name = "deleted")
    private boolean deleted;
}