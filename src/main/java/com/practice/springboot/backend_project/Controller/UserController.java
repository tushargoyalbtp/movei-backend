package com.practice.springboot.backend_project.Controller;

import com.practice.springboot.backend_project.Model.Booking;
import com.practice.springboot.backend_project.Service.BookingService;
import com.practice.springboot.backend_project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired private BookingService bookingService;

    @Autowired private UserService userService;

    @PostMapping("/book")
    public Booking bookShow(@RequestParam Long showId, Authentication authentication) {
        Long userId = getUserIdFromAuthentication(authentication);
        return bookingService.bookShow(userId, showId);
    }

    private Long getUserIdFromAuthentication(Authentication authentication) {
        return Long.parseLong(authentication.getName()); // update based on your token setup
    }
}
