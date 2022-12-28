package com.jkcode.reservation.entity;

import com.jkcode.reservation.util.OrderStatus;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;


@SpringBootTest
public class OrderTest {

    @Test
    public void testGetIdAndSetId() {
        // Create a new Order instance
        Order order = new Order();

        // Set the ID using the setId method
        order.setId(1L);

        // Verify that the ID can be retrieved correctly using the getId method
        assertEquals(1L, order.getId().longValue());
    }

    @Test
    public void testGetUserAndSetUser() {
        // Create a new Order instance
        Order order = new Order();

        // Create a new User instance
        User user = new User();
        user.setId(1L);
        user.setFirstName("john");

        // Set the user using the setUser method
        order.setUser(user);

        // Verify that the user can be retrieved correctly using the getUser method
        assertSame(user, order.getUser());
    }
    @Test
    public void testGetFilmAndSetFilm() {
        // Create a new Order instance
        Order order = new Order();

        // Create a new Film instance
        Film film = new Film();
        film.setId(1L);
        film.setTitle("The Shawshank Redemption");

        // Set the film using the setFilm method
        order.setFilm(film);

        // Verify that the film can be retrieved correctly using the getFilm method
        assertSame(film, order.getFilm());
    }

    @Test
    public void testGetScheduleAndSetSchedule() {
        // Create a new Order instance
        Order order = new Order();

        // Create a new Schedule instance
        Schedule schedule = new Schedule();
        schedule.setId(1L);

        // Create a LocalDateTime object using the of method
        LocalDateTime startTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 0));

        // Set the start time using the setStartTime method
        schedule.setStartTime(startTime);

        // Set the schedule using the setSchedule method
        order.setSchedule(schedule);

        // Verify that the schedule can be retrieved correctly using the getSchedule method
        assertTrue(schedule.getStartTime().equals(order.getSchedule().getStartTime()));
    }

    @Test
    public void testGetSeatAndSetSeat() {
        // Create a new Order instance
        Order order = new Order();

        // Create a new Seat instance
        Seat seat = new Seat();
        seat.setId(1L);
        seat.setRow(1);
        seat.setColumn(1);

        // Set the seat using the setSeat method
        order.setSeat(seat);

        // Verify that the seat can be retrieved correctly using the getSeat method
        assertSame(seat, order.getSeat());
    }

    @Test
    public void testGetPriceAndSetPrice() {
        // Create a new Order instance
        Order order = new Order();

        // Set the price using the setPrice method
        order.setPrice(9.99);

        // Verify that the price can be retrieved correctly using the getPrice method
        assertEquals(9.99, order.getPrice(), 0.001);
    }

    @Test
    public void testGetStatusAndSetStatus() {
        // Create a new Order instance
        Order order = new Order();

        // Set the status using the setStatus method
        order.setStatus(OrderStatus.PENDING);

        // Verify that the status can be retrieved correctly using the getStatus method
        assertEquals(OrderStatus.PENDING, order.getStatus());
    }

    @Test
    public void testIsDeletedAndSetDeleted() {
        // Create a new Order instance
        Order order = new Order();

        // Set the deleted flag using the setDeleted method
        order.setDeleted(true);

        // Verify that the deleted flag can be retrieved correctly using the isDeleted method
        assertTrue(order.isDeleted());
    }
}
