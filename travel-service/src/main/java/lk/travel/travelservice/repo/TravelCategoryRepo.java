package lk.travel.travelservice.repo;

import lk.travel.travelservice.entity.TravelCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelCategoryRepo extends JpaRepository<TravelCategory,Integer> {
}
