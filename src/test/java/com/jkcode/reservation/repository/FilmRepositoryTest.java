//package com.jkcode.reservation.repository;
//
//import com.jkcode.reservation.entity.Film;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.time.LocalDate;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//class FilmRepositoryTest {
//    @Autowired
//    private FilmRepository filmRepository;
//
//    @Test
//    void testSaveFilm() {
//        Film film = new Film(1L, "The Matrix", "A dystopian science fiction film", LocalDate.of(1999, 3, 31), 136, false);
//        Film savedFilm = filmRepository.save(film);
//        assertEquals(film.getTitle(), savedFilm.getTitle());
//        assertEquals(film.getDescription(), savedFilm.getDescription());
//        assertEquals(film.getReleaseDate(), savedFilm.getReleaseDate());
//        assertEquals(film.getDuration(), savedFilm.getDuration());
//        assertEquals(film.isDeleted(), savedFilm.isDeleted());
//    }
//}
