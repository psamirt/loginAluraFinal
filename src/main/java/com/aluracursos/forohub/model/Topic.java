package com.aluracursos.forohub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    @Setter
    private long id;

    @Column(name = "title")
    @Getter
    @Setter
    private String title;

    @Column(name = "message")
    @Getter
    @Setter
    private String message;

    @Column(name = "release_date")
    @Getter
    @Setter
    private String releaseDate;

    @Column(name = "name_course")
    @Getter
    @Setter
    private String nameCourse;

    @Column(name = "user_id")
    @Getter
    @Setter
    private String userId;

    @PrePersist
    protected void onCreate() {
        this.releaseDate = String.valueOf(LocalDate.now());
    }
}