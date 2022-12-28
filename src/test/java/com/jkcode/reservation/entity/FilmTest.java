package com.jkcode.reservation.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.Assert.*;

@SpringBootTest
public class FilmTest {
    @Test
    public void testGetIdAndSetId() {
        // Create a new Film instance
        Film film = new Film();

        // Set the ID using the setId method
        film.setId(1L);

        // Verify that the ID can be retrieved correctly using the getId method
        assertEquals(1L, film.getId().longValue());
    }

    @Test
    public void testGetTitleAndSetTitle() {
        // Create a new Film instance
        Film film = new Film();

        // Set the title using the setTitle method
        film.setTitle("The Shawshank Redemption");

        // Verify that the title can be retrieved correctly using the getTitle method
        assertEquals("The Shawshank Redemption", film.getTitle());
    }

    @Test
    public void testGetDescriptionAndSetDescription() {
        // Create a new Film instance
        Film film = new Film();

        // Set the description using the setDescription method
        film.setDescription("Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.");

        // Verify that the description can be retrieved correctly using the getDescription method
        assertEquals("Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", film.getDescription());
    }

    @Test
    public void testGetReleaseDateAndSetReleaseDate() {
        // Create a new Film instance
        Film film = new Film();

        // Set the release date using the setReleaseDate method
        film.setReleaseDate(LocalDate.of(1994, 10, 14));

        // Verify that the release date can be retrieved correctly using the getReleaseDate method
        assertEquals(LocalDate.of(1994, 10, 14), film.getReleaseDate());
    }

    @Test
    public void testGetDurationAndSetDuration() {
        // Create a new Film instance
        Film film = new Film();

        // Set the duration using the setDuration method
        film.setDuration(142);

        // Verify that the duration can be retrieved correctly using the getDuration method
        assertEquals(142, film.getDuration());
    }

    @Test
    public void testIsDeletedAndSetDeleted() {
        // Create a new Film instance
        Film film = new Film();

        // Set the deleted flag using the setDeleted method
        film.setDeleted(true);

        // Verify that the deleted flag can be retrieved correctly using the isDeleted method
        assertTrue(film.isDeleted());
    }
}
