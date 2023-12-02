package lk.travel.customerservice.service;



import lk.travel.customerservice.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    BookingDTO saveBooking(BookingDTO bookingDTO);
    BookingDTO updateBooking(BookingDTO bookingDTO);
    BookingDTO searchBooking(int bookingID);
    List<BookingDTO> searchBookingCustomerID(int customerID);
    void deleteBooking(int bookingID);
    List<BookingDTO> getAllBooking();
}
