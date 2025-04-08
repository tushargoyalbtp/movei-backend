package com.practice.springboot.backend_project.Service.Implementation;

import com.practice.springboot.backend_project.Model.Movie;
import com.practice.springboot.backend_project.Model.Show;
import com.practice.springboot.backend_project.Repository.MovieRepository;
import com.practice.springboot.backend_project.Repository.ShowRepository;
import com.practice.springboot.backend_project.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowServiceImplementation implements ShowService {

    @Autowired private ShowRepository showRepository;
    @Autowired
    private MovieRepository movieRepository;  // <-- Add this

    @Override
    public Show createShow(Show show) {
        if (show.getMovie() == null || show.getMovie().getId() == null) {
            throw new RuntimeException("Movie ID is required to create a show.");
        }

        Optional<Movie> movieOptional = movieRepository.findById(show.getMovie().getId());

        if (movieOptional.isEmpty()) {
            throw new RuntimeException("Movie not found with ID: " + show.getMovie().getId());
        }

        // Set the actual Movie object
        show.setMovie(movieOptional.get());

        return showRepository.save(show);
    }
}
