package com.jkcode.reservation.repository;

import com.jkcode.reservation.entity.Film;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class FilmRepositoryTest {
    @Autowired
    private FilmRepository filmRepository;

    @Test
    void testSaveFilm() {
        Film film = new Film(1L, "The Matrix", "A dystopian science fiction film", LocalDate.of(1999, 3, 31), 136, false);
        Film savedFilm = filmRepository.save(film);
        assertEquals(film.getTitle(), savedFilm.getTitle());
        assertEquals(film.getDescription(), savedFilm.getDescription());
        assertEquals(film.getReleaseDate(), savedFilm.getReleaseDate());
        assertEquals(film.getDuration(), savedFilm.getDuration());
        assertEquals(film.isDeleted(), savedFilm.isDeleted());
    }

    @Test
    public void testFindByTitle() {
        // Given
        Film film1 = new Film(1L, "The Shawshank Redemption", "A story of hope and redemption", LocalDate.of(1994, 9, 10), 142, false);
        Film film2 = new Film(2L, "The Godfather", "The story of a powerful mafia family", LocalDate.of(1972, 3, 24), 175, false);
        Film film3 = new Film(3L, "The Godfather: Part II", "The continuing story of the Corleone family", LocalDate.of(1974, 12, 20), 202, false);
        Film film4 = new Film(4L, "The Dark Knight", "The rise of Batman and the Joker's reign of terror", LocalDate.of(2008, 7, 18), 152, false);
        filmRepository.save(film1);
        filmRepository.save(film2);
        filmRepository.save(film3);
        filmRepository.save(film4);

        // When
        List<Film> films = filmRepository.findByTitle("The Godfather", PageRequest.of(0, 2));

        // Then
        assertEquals(1, films.size());
        assertEquals("The Godfather", films.get(0).getTitle());
    }
}
