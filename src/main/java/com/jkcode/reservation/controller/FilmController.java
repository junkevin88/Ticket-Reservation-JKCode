//package com.jkcode.reservation.controller;
//
//
//import com.jkcode.reservation.entity.Schedule;
//import com.jkcode.reservation.repository.ScheduleRepository;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/schedules")
//public class FilmController {
//    private final ScheduleRepository scheduleRepository;
//
//    public FilmController(ScheduleRepository scheduleRepository) {
//        this.scheduleRepository = scheduleRepository;
//    }
//
//    @GetMapping
//    public List<Schedule> getAllSchedules() {
//        return scheduleRepository.findByDeletedIsFalse();
//    }
//}
