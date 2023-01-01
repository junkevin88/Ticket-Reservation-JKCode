package com.jkcode.reservation.service.impl;

import com.jkcode.reservation.entity.Schedule;
import com.jkcode.reservation.repository.ScheduleRepository;
import com.jkcode.reservation.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    @Override
    public List<Schedule> getSchedulesByFilmAndStartTime(Long filmId, LocalDateTime startTime) {
        return scheduleRepository.findByFilmIdAndStartTime(filmId, startTime);
    }


    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    @Transactional
    public void deleteSchedule(Long id) {
// Retrieve the Schedule entity with the given id
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + id));

        // Set the 'deleted' field of the Schedule entity to true
        schedule.setDeleted(true);
// Save the updated Schedule entity
        scheduleRepository.save(schedule);

    }
}
