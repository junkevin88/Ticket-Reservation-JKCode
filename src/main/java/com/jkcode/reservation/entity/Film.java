package com.jkcode.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Film {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String title;

    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private int duration;

    private boolean deleted;
}
