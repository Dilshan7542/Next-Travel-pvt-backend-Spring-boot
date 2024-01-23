package lk.travel.customerservice.repo;


import lk.travel.customerservice.dto.BookingDTO;
import lk.travel.customerservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
    List<Booking> findByCustomerCustomerID(int customerID);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Booking SET paymentStatus=:payment WHERE bookingID=:bookingID")
    void updateBookingByBookingID(int bookingID,boolean payment);

}
