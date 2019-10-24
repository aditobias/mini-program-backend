package com.example.miniProject.Controller;


import com.example.miniProject.Model.Booking;
import com.example.miniProject.Sevice.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postNewBooking(@RequestBody Booking booking){
        Booking newBooking = bookingService.save(booking);
        if(isNull(newBooking)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newBooking,HttpStatus.CREATED);
    }

    @GetMapping(path= "/{wayBillNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Booking getNewBooking(@PathVariable String wayBillNumber){
        return bookingService.findByWayBillNumber(wayBillNumber);
    }


}
