package com.jkcode.reservation.service;

import com.jkcode.reservation.entity.Film;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FilmService {
    List<Film> findByTitle(String title, Pageable pageable);
    Film create(Film film);
    Film update(Film film);
    void softdelete(Long id);

}
