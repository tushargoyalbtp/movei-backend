package com.practice.springboot.backend_project.Repository;

import com.practice.springboot.backend_project.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Long> {
}
