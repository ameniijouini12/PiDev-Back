package com.example.pidevge.services;

import com.example.pidevge.Entities.Booking;
import com.example.pidevge.Entities.Event;
import com.example.pidevge.Entities.Type;
import com.example.pidevge.Entities.User;
import com.example.pidevge.Repositories.BookingRepository;
import com.example.pidevge.Repositories.EventRepository;
import com.example.pidevge.Repositories.UserRepository;
import com.example.pidevge.interfaces.IBookingService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookingServiceImp implements IBookingService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    @Override
    public Booking addBooking(int eventId, int userId) {

        Event event=eventRepository.findById(eventId).orElse(null);
        User user=userRepository.findById(userId).orElse(null);

        if(event!=null && user!=null){

            int nb=event.getNbPlaceRestantes();
            if(nb>=1)
            {  Booking booking=new Booking(user,event,true,event.getCoutParticipation());


                event.setNbPlaceRestantes(nb--);
                eventRepository.save(event);
                return bookingRepository.save(booking);}


        }
        return null;
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> retreiveAll() {
        return bookingRepository.findAll();
    }

    @Override
    public String deleteBooking(int bookingId) {
        Booking booking=bookingRepository.findById(bookingId).orElse(null);
        if(booking!=null){bookingRepository.deleteById(bookingId);
            return "Booking deleted Succesfully";}
        return "Booking not found";
    }

    @Override
    public Booking retreiveById(int bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override

    public List<Booking> retreiveBookingByType(Type type) {

        return bookingRepository.findBookingsByEvent_Type(type);
    }

    @Override
    @Scheduled(fixedDelay = 800000)
    public void archiverBooking() {
        List<Booking>bookingActive=bookingRepository.findBookingsByStateIsTrue();
        Date currentDate = new Date(); // Get the current date

        bookingActive.stream()
                .map(booking -> {
                    if (booking.getEvent().getDateFin().before(currentDate)) {
                        booking.setState(false);
                    }
                    return bookingRepository.save(booking);
                })
                .collect(Collectors.toList());
    }


}
