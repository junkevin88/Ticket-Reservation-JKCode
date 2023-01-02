package com.jkcode.reservation.service.impl;

import com.jkcode.reservation.entity.Seat;
import com.jkcode.reservation.repository.SeatRepository;
import com.jkcode.reservation.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }


    @Override
    public List<Seat> getSeatsBySchedule(Long scheduleId) {
        return seatRepository.findByScheduleId(scheduleId);
    }

    @Override
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public Seat updateSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    @Transactional
    public void deleteSeat(Long id) {
        // Retrieve the Seat entity with the given id
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seat not found with id: " + id));

        // Set the 'deleted' field of the Seat entity to true
        seat.setDeleted(true);
        // Save the updated Seat entity
        seatRepository.save(seat);
    }
}
