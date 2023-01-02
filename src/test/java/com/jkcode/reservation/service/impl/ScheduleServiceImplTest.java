package com.jkcode.reservation.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.jkcode.reservation.entity.Schedule;
import com.jkcode.reservation.repository.ScheduleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScheduleServiceImplTest {

    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleServiceImpl scheduleService;

    @Test
    void testGetSchedulesByFilmAndStartTime() {
        LocalDateTime startTime = LocalDateTime.now();
        List<Schedule> expectedSchedules = Arrays.asList(new Schedule(), new Schedule());
        when(scheduleRepository.findByFilmIdAndStartTime(1L, startTime)).thenReturn(expectedSchedules);

        List<Schedule> actualSchedules = scheduleService.getSchedulesByFilmAndStartTime(1L, startTime);
        assertEquals(expectedSchedules, actualSchedules);
    }

    @Test
    void testUpdateSchedule() {
        Schedule schedule = new Schedule();
        when(scheduleRepository.save(schedule)).thenReturn(schedule);

        Schedule actualSchedule = scheduleService.updateSchedule(schedule);
        assertEquals(schedule, actualSchedule);
    }

    @Test
    void testDeleteSchedule() {
        Schedule schedule = new Schedule();
        when(scheduleRepository.findById(1L)).thenReturn(Optional.of(schedule));

        scheduleService.deleteSchedule(1L);
        assertTrue(schedule.isDeleted());
        verify(scheduleRepository).save(schedule);
    }

}