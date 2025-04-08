package com.practice.springboot.backend_project.Service.Implementation;

import com.practice.springboot.backend_project.Model.Booking;
import com.practice.springboot.backend_project.Model.Show;
import com.practice.springboot.backend_project.Model.User;
import com.practice.springboot.backend_project.Repository.BookingRepository;
import com.practice.springboot.backend_project.Repository.MovieRepository;
import com.practice.springboot.backend_project.Repository.ShowRepository;
import com.practice.springboot.backend_project.Repository.UserRepository;
import com.practice.springboot.backend_project.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImplementation implements BookingService {

    @Autowired private UserRepository userRepository;
    @Autowired private ShowRepository showRepository;
    @Autowired private BookingRepository bookingRepository;



    /**
     * @param userId
     * @param showId
     * @return
     */
    @Override
    public Booking bookShow(Long userId, Long showId) {
        Optional<User> userDetails  = userRepository.findById(userId);
        Optional<Show> showDetails = showRepository.findById(showId);

        Booking newBooking = new Booking();
        newBooking.setShow(showDetails.get());
        newBooking.setUser(userDetails.get());
        return bookingRepository.save(newBooking);
    }
}
