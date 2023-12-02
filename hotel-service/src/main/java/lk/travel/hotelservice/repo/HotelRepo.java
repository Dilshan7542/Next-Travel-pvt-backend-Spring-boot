package lk.travel.hotelservice.repo;

import lk.travel.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface HotelRepo extends JpaRepository<Hotel,Integer> {
    List<Hotel> findAllByLocation(String location);
}
