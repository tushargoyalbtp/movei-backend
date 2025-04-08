package com.practice.springboot.backend_project.Controller;

import com.practice.springboot.backend_project.Model.Movie;
import com.practice.springboot.backend_project.Model.Show;
import com.practice.springboot.backend_project.Service.MovieService;
import com.practice.springboot.backend_project.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired private MovieService movieService;

    @Autowired private ShowService showService;

    @PostMapping("/createMovie")
    public ResponseEntity<?> createMovieByAdmin(@RequestBody Movie movie){
        return ResponseEntity.ok().body(movieService.createMovie(movie));
    }

    @PostMapping("/createShow")
    public ResponseEntity<?> createShowByAdmin(@RequestBody Show show){
        return ResponseEntity.ok().body(showService.createShow(show));
    }

}
