package com.jkcode.reservation.entity;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="films")
@Where(clause = "deleted is null")
public class Film implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "film_id")
    private Long id;

    @NonNull
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "duration")
    private int duration;

    @Column(name = "deleted")
    private boolean deleted;
}
