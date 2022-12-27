package com.jkcode.reservation.repository;
import com.jkcode.reservation.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    // additional custom methods go here
    List<Film> findByTitle(String title, Pageable pageable);

}
