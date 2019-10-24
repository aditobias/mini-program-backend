package com.example.miniProject.Repository;

import com.example.miniProject.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository <Booking, Long> {
    Booking findByWayBillNumber(String wayBillNumber);
}
