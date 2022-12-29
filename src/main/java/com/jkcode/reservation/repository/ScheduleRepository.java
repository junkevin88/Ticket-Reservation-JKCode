package com.jkcode.reservation.repository;
import com.jkcode.reservation.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // additional custom methods go here
    List<Schedule> findByFilmIdAndStartTime(Long film, LocalDateTime startTime);
}
