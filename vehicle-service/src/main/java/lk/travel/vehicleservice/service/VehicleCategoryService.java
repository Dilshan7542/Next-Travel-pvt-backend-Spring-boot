package lk.travel.vehicleservice.service;

import lk.travel.vehicleservice.dto.VehicleBrandDTO;
import lk.travel.vehicleservice.dto.VehicleCategoryDTO;

import java.util.List;

public interface VehicleCategoryService {
    VehicleCategoryDTO saveVehicleCategory(VehicleCategoryDTO vehicleCategoryDTO);
    VehicleCategoryDTO updateVehicleCategory(VehicleCategoryDTO vehicleCategoryDTO);
    VehicleCategoryDTO searchVehicleCategory(int vehicleCategoryID);
    void deleteVehicleCategory(int vehicleCategoryID);
    List<VehicleCategoryDTO> getAllVehicleCategory();

}
