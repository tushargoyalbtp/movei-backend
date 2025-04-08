package com.practice.springboot.backend_project.Service;

import com.practice.springboot.backend_project.Model.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {

    Movie createMovie(Movie movie);
}
