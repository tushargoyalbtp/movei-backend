package com.practice.springboot.backend_project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "Shows")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String showTime;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
