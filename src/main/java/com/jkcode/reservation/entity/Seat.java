package com.jkcode.reservation.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="seats")
@Where(clause = "deleted is null")
public class Seat implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "seat_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Column(name = "studio_row")
    private int row;

    @Column(name = "studio_column")
    private int column;

    @Column(name = "reserved")
    private boolean reserved;

    @Column(name = "deleted")
    private boolean deleted;

    // Constructors, getters, and setters omitted for brevity
}
