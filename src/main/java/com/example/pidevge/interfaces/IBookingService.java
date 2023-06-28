package com.example.pidevge.interfaces;

import com.example.pidevge.Entities.Booking;
import com.example.pidevge.Entities.Type;

import java.util.List;

public interface IBookingService {
    public Booking addBooking(int eventId, int userId);
    public Booking updateBooking(Booking booking);
    public List<Booking> retreiveAll();
    public String deleteBooking(int bookingId);
    public Booking retreiveById(int bookingId);
    public List<Booking> retreiveBookingByType(Type type);
    public void archiverBooking();


}
