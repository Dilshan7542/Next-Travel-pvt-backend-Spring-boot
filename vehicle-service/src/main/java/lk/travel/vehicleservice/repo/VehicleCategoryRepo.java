package lk.travel.vehicleservice.repo;

import lk.travel.vehicleservice.entity.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryRepo extends JpaRepository<VehicleCategory,Integer> {
}
