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
@Table(name="users")
@Where(clause = "deleted is null")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "deleted")
    private Boolean deleted;

    // Constructors, getters, and setters omitted for brevity
}