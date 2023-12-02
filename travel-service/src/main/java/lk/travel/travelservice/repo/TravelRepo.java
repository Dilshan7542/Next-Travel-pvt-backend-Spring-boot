package lk.travel.travelservice.repo;

import lk.travel.travelservice.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepo extends JpaRepository<Travel,Integer> {
}
