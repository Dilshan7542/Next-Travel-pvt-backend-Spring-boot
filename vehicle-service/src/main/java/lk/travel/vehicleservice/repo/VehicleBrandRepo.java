package lk.travel.vehicleservice.repo;

import lk.travel.vehicleservice.entity.VehicleBrand;
import lk.travel.vehicleservice.entity.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleBrandRepo extends JpaRepository<VehicleBrand, Integer> {
    List<VehicleBrand> findAllByVehicleCategory(VehicleCategory vehicleCategory);

}
