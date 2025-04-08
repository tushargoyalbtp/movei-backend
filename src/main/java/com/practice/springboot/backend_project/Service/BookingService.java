package com.practice.springboot.backend_project.Service;

import com.practice.springboot.backend_project.Model.Booking;

public interface BookingService {

    Booking bookShow(Long userId, Long showId);
}
