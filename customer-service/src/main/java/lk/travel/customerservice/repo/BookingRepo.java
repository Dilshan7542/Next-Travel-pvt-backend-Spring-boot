package lk.travel.customerservice.repo;


import lk.travel.customerservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
    List<Booking> findByCustomerCustomerID(int customerID);

}
