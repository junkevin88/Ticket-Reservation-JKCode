package com.jkcode.reservation.entity;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;


@SpringBootTest
public class SeatTest {

    @Test
    public void testGetIdAndSetId() {
        // Create a new Seat instance
        Seat seat = new Seat();

        // Set the ID using the setId method
        seat.setId(1L);

        // Verify that the ID can be retrieved correctly using the getId method
        assertEquals(1L, seat.getId().longValue());
    }

    @Test
    public void testGetScheduleAndSetSchedule() {
        // Create a new Seat instance
        Seat seat = new Seat();

        // Create a new Schedule instance
        Schedule schedule = new Schedule();
        schedule.setId(1L);

        // Set the schedule using the setSchedule method
        seat.setSchedule(schedule);

        // Verify that the schedule can be retrieved correctly using the getSchedule method
        assertSame(schedule, seat.getSchedule());
    }

    @Test
    public void testGetRowAndSetRow() {
        // Create a new Seat instance
        Seat seat = new Seat();

        // Set the row using the setRow method
        seat.setRow(1);

        // Verify that the row can be retrieved correctly using the getRow method
        assertEquals(1, seat.getRow());
    }

    @Test
    public void testGetColumnAndSetColumn() {
        // Create a new Seat instance
        Seat seat = new Seat();

        // Set the column using the setColumn method
        seat.setColumn(1);

        // Verify that the column can be retrieved correctly using the getColumn method
        assertEquals(1, seat.getColumn());
    }

    @Test
    public void testIsReservedAndSetReserved() {
        // Create a new Seat instance
        Seat seat = new Seat();

        // Set the reserved status using the setReserved method
        seat.setReserved(true);

        // Verify that the reserved status can be retrieved correctly using the isReserved method
        assertTrue(seat.isReserved());
    }
}
