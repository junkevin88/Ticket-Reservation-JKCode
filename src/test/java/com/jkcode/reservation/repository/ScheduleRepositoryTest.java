package com.jkcode.reservation.repository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.jkcode.reservation.entity.Film;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jkcode.reservation.entity.Schedule;
import com.jkcode.reservation.repository.ScheduleRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ScheduleRepositoryTest {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private FilmRepository filmRepository;

    @Test
    public void testFindByFilmIdAndStartTime() {
        // Given
        Film film1 = new Film(1L, "The Shawshank Redemption", "A story of hope and redemption", LocalDate.of(1994, 9, 10), 142, false);
        Film film2 = new Film(2L, "The Godfather", "The story of a powerful mafia family", LocalDate.of(1972, 3, 24), 175, false);
        filmRepository.save(film1);
        filmRepository.save(film2);

        LocalDateTime startTime = LocalDateTime.of(2022, 1, 1, 10, 0);
        Schedule schedule1 = new Schedule(1L, film1, startTime, startTime.plusHours(2));
        Schedule schedule2 = new Schedule(2L, film2, startTime.plusHours(3), startTime.plusHours(5));
        Schedule schedule3 = new Schedule(3L, film2, startTime, startTime.plusHours(2));
        scheduleRepository.save(schedule1);
        scheduleRepository.save(schedule2);
        scheduleRepository.save(schedule3);

        // When
        List<Schedule> scheduleSame = scheduleRepository.findByFilmIdAndStartTime(film2.getId(), startTime);

        // Then
        assertEquals(1, scheduleSame.size());
        assertEquals(schedule3, scheduleSame.get(0));
    }
}
