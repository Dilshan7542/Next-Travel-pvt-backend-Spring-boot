package lk.travel.hotelservice.repo;


import lk.travel.hotelservice.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepo extends JpaRepository<Guide,Integer> {
}
