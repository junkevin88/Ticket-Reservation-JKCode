package com.jkcode.reservation.service;

import com.jkcode.reservation.entity.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> getSeatsBySchedule(Long scheduleId);
    Seat createSeat(Seat seat);
    Seat updateSeat(Seat seat);
    void deleteSeat(Long id);
}
