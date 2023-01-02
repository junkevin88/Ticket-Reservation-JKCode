package com.jkcode.reservation.service.impl;

import com.jkcode.reservation.entity.Film;
import com.jkcode.reservation.repository.FilmRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FilmServiceImplTest {
    @Mock
    private FilmRepository filmRepository;

    @Mock
    private Pageable pageable;

    @InjectMocks
    private FilmServiceImpl filmService;

    @Test
    void testFindByTitle() {
        List<Film> expectedFilms = Collections.singletonList(new Film());
        when(filmRepository.findByTitle("title", pageable)).thenReturn(expectedFilms);

        List<Film> actualFilms = filmService.findByTitle("title", pageable);
        assertEquals(expectedFilms, actualFilms);
    }

    @Test
    void testCreate() {
        Film film = new Film();
        when(filmRepository.save(film)).thenReturn(film);

        Film actualFilm = filmService.create(film);
        assertEquals(film, actualFilm);
        verify(filmRepository).save(film);
    }

    @Test
    void testUpdate() {
        Film film = new Film();
        when(filmRepository.save(film)).thenReturn(film);

        Film actualFilm = filmService.update(film);
        assertEquals(film, actualFilm);
        verify(filmRepository).save(film);
    }

    @Test
    void testSoftdelete() {
        Film film = new Film();
        when(filmRepository.findById(1L)).thenReturn(Optional.of(film));

        filmService.softdelete(1L);
        assertTrue(film.isDeleted());
        verify(filmRepository).save(film);
    }



}