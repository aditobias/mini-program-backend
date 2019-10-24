package com.example.miniProject.Sevice;


import com.example.miniProject.Model.Booking;
import com.example.miniProject.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;


    public Booking save(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking findByWayBillNumber(String wayBillNumber) {
        return bookingRepository.findByWayBillNumber(wayBillNumber);
    }
}
