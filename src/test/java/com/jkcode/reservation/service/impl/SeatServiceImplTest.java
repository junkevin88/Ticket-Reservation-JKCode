package com.jkcode.reservation.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.jkcode.reservation.entity.Seat;
import com.jkcode.reservation.repository.SeatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SeatServiceImplTest {

    @Mock
    private SeatRepository seatRepository;

    @InjectMocks
    private SeatServiceImpl seatService;

    @Test
    void testGetSeatsBySchedule() {
        List<Seat> expectedSeats = Arrays.asList(new Seat(), new Seat());
        when(seatRepository.findByScheduleId(1L)).thenReturn(expectedSeats);

        List<Seat> actualSeats = seatService.getSeatsBySchedule(1L);
        assertEquals(expectedSeats, actualSeats);
    }

    @Test
    void testCreateSeat() {
        Seat seat = new Seat();
        when(seatRepository.save(seat)).thenReturn(seat);

        Seat actualSeat = seatService.createSeat(seat);
        assertEquals(seat, actualSeat);
    }

    @Test
    void testUpdateSeat() {
        Seat seat = new Seat();
        when(seatRepository.save(seat)).thenReturn(seat);

        Seat actualSeat = seatService.updateSeat(seat);
        assertEquals(seat, actualSeat);
    }

    @Test
    void testDeleteSeat() {
        Seat seat = new Seat();
        when(seatRepository.findById(1L)).thenReturn(Optional.of(seat));

        seatService.deleteSeat(1L);
        assertTrue(seat.isDeleted());
        verify(seatRepository).save(seat);
    }

}
