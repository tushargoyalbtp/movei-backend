package com.practice.springboot.backend_project.Service.Implementation;

import com.practice.springboot.backend_project.Model.Movie;
import com.practice.springboot.backend_project.Repository.MovieRepository;
import com.practice.springboot.backend_project.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService {

    @Autowired private MovieRepository movieRepository;

    /**
     * @param movie
     * @return
     */
    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
