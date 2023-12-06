package lk.travel.authservice.repo;

import lk.travel.authservice.entity.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
import java.util.Optional;
public interface UserRepo extends MongoRepository<Users,Integer> {
    Optional<Users> findByEmail(String email);
  List<Users> findAllByOrderByUserIDDesc(Pageable pageable);
}
