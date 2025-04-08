package com.practice.springboot.backend_project.Repository;

import com.practice.springboot.backend_project.Model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {

}
