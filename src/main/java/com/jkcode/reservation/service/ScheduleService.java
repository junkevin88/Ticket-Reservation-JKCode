package com.jkcode.reservation.service;

import com.jkcode.reservation.entity.Schedule;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleService {
    List<Schedule> getSchedulesByFilmAndStartTime(Long filmId, LocalDateTime startTime);
    Schedule createSchedule(Schedule schedule);
    Schedule updateSchedule(Schedule schedule);
    void deleteSchedule(Long id);
}
