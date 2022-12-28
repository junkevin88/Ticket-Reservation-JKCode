package com.jkcode.reservation.util;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(Long id) {
        super("Film with id " + id + " not found");
    }
}
