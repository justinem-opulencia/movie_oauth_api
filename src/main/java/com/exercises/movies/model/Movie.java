package com.exercises.movies.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@Setter


@Entity //mark class as entity
@Table
@SecondaryTable(name = "genre",pkJoinColumns = @PrimaryKeyJoinColumn(name = "genre"))//defining class name as Table name
public class Movie {

    @Column //defining id as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int yearReleased;

    @Column
    private boolean isSequel;

    @Column
    @Enumerated(EnumType.STRING)
    private List<Genre> genre;

    @Column
    private List<String> castList;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public boolean isSequel() {
        return isSequel;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public List<String> getCastList() {
        return castList;
    }
}
