package com.jkcode.reservation.entity;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.Assert.*;


@SpringBootTest
public class ScheduleTest {

    @Test
    public void testGetIdAndSetId() {
        // Create a new Schedule instance
        Schedule schedule = new Schedule();

        // Set the ID using the setId method
        schedule.setId(1L);

        // Verify that the ID can be retrieved correctly using the getId method
        assertEquals(1L, schedule.getId().longValue());
    }

    @Test
    public void testGetFilmAndSetFilm() {
        // Create a new Schedule instance
        Schedule schedule = new Schedule();

        // Create a new Film instance
        Film film = new Film();
        film.setId(1L);
        film.setTitle("The Shawshank Redemption");

        // Set the film using the setFilm method
        schedule.setFilm(film);

        // Verify that the film can be retrieved correctly using the getFilm method
        assertSame(film, schedule.getFilm());
    }
    @Test
    public void testGetEndTimeAndSetEndTime() {
        // Create a new Schedule instance
        Schedule schedule = new Schedule();

        // Create a LocalDateTime object using the of method
        LocalDateTime endTime = LocalDateTime.of(2022, 12, 31, 23, 59);

        // Set the end time using the setEndTime method
        schedule.setEndTime(endTime);

        // Verify that the end time can be retrieved correctly using the getEndTime method
        assertEquals(endTime, schedule.getEndTime());
    }
}