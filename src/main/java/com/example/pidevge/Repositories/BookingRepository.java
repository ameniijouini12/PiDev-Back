package com.example.pidevge.Repositories;

import com.example.pidevge.Entities.Booking;
import com.example.pidevge.Entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
    public List<Booking> findBookingsByEvent_Type(Type type);
    public List<Booking>findBookingsByStateIsTrue();
}
