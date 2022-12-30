package com.jkcode.reservation.service.impl;

import com.jkcode.reservation.entity.Film;
import com.jkcode.reservation.repository.FilmRepository;
import com.jkcode.reservation.service.FilmService;
import com.jkcode.reservation.util.FilmNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> findByTitle(String title, Pageable pageable) {
        return filmRepository.findByTitle(title, pageable);
    }

    @Override
    public Film create(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public Film update(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public void delete(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public void softdelete(Long id) {
        Film film = filmRepository.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
        film.setDeleted(true);
        filmRepository.save(film);
    }
}
