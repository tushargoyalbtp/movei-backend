package com.practice.springboot.backend_project.Repository;

import com.practice.springboot.backend_project.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
