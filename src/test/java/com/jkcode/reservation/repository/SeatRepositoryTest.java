package com.jkcode.reservation.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import com.jkcode.reservation.entity.Schedule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jkcode.reservation.entity.Seat;
import com.jkcode.reservation.repository.SeatRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SeatRepositoryTest {

    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    public void testFindByScheduleId() {

        LocalDateTime startTime = LocalDateTime.of(2022, 1, 1, 10, 0);

        Schedule schedule1 = new Schedule();
        schedule1.setId(1L);
        scheduleRepository.save(schedule1);

        Schedule schedule2 = new Schedule();
        schedule2.setId(2L);
        scheduleRepository.save(schedule2);

        // given:
        Seat seat1 = new Seat();
        seat1.setSchedule(schedule1);
        seatRepository.save(seat1);

        Seat seat2 = new Seat();
        seat2.setSchedule(schedule2);
        seatRepository.save(seat2);

        Seat seat3 = new Seat();
        seat3.setSchedule(schedule1);
        seatRepository.save(seat3);

        // when:
        List<Seat> seatSame = seatRepository.findByScheduleId(schedule1.getId());

        // then:
        assertEquals(2, seatSame.size());
        assertTrue(seatSame.contains(seat1));
        assertTrue(seatSame.contains(seat3));
    }
}

