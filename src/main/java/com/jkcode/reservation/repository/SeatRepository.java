package com.jkcode.reservation.repository;

import com.jkcode.reservation.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    // additional custom methods go here
    List<Seat> findByScheduleId(Long schedule);
}
