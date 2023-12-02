package lk.travel.vehicleservice.service.impl;

import jakarta.persistence.EntityManager;
import lk.travel.vehicleservice.dto.VehicleCategoryDTO;
import lk.travel.vehicleservice.entity.VehicleCategory;
import lk.travel.vehicleservice.repo.VehicleCategoryRepo;
import lk.travel.vehicleservice.service.VehicleCategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleCategoryServiceImpl implements VehicleCategoryService {
   private final VehicleCategoryRepo vehicleCategoryRepo;
   private final ModelMapper mapper;

    @Override
    public VehicleCategoryDTO saveVehicleCategory(VehicleCategoryDTO vehicleCategoryDTO) {
            if(vehicleCategoryRepo.existsById(vehicleCategoryDTO.getVehicleCategoryID())){
                throw new RuntimeException("VehicleCategory Already exists...!!");
            }
            vehicleCategoryRepo.save(mapper.map(vehicleCategoryDTO, VehicleCategory.class));
        return vehicleCategoryDTO;
    }

    @Override
    public VehicleCategoryDTO updateVehicleCategory(VehicleCategoryDTO vehicleCategoryDTO) {
        if(!vehicleCategoryRepo.existsById(vehicleCategoryDTO.getVehicleCategoryID())){
            throw new RuntimeException("VehicleCategory Not exists...!!");
        }
        vehicleCategoryRepo.save(mapper.map(vehicleCategoryDTO, VehicleCategory.class));
        return vehicleCategoryDTO;
    }

    @Override
    public VehicleCategoryDTO searchVehicleCategory(int vehicleCategoryID) {
        if(!vehicleCategoryRepo.existsById(vehicleCategoryID)){
            throw new RuntimeException("VehicleCategory Not exists...!!");
        }
        return mapper.map(vehicleCategoryRepo.findById(vehicleCategoryID), VehicleCategoryDTO.class);
    }

    @Override
    public void deleteVehicleCategory(int vehicleCategoryID) {
        if(!vehicleCategoryRepo.existsById(vehicleCategoryID)){
            throw new RuntimeException("VehicleCategory Not exists...!!");
        }
        vehicleCategoryRepo.deleteById(vehicleCategoryID);
    }

    @Override
    public List<VehicleCategoryDTO> getAllVehicleCategory() {
        return mapper.map(vehicleCategoryRepo.findAll(),new TypeToken<List<VehicleCategoryDTO>>(){}.getType());
    }


}
