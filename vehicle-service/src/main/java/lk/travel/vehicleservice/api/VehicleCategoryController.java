package lk.travel.vehicleservice.api;

import lk.travel.vehicleservice.dto.VehicleCategoryDTO;
import lk.travel.vehicleservice.service.VehicleCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle/category")
@RequiredArgsConstructor
public class VehicleCategoryController {
   private final VehicleCategoryService vehicleCategoryService;

    @PostMapping
    public ResponseEntity<VehicleCategoryDTO> saveVehicleCategory(@RequestBody VehicleCategoryDTO vehicleCategoryDTO) {
        return new ResponseEntity<>(vehicleCategoryService.saveVehicleCategory(vehicleCategoryDTO), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<VehicleCategoryDTO> updateVehicleCategory(@RequestBody VehicleCategoryDTO vehicleCategoryDTO) {
        return new ResponseEntity<>(vehicleCategoryService.updateVehicleCategory(vehicleCategoryDTO), HttpStatus.OK);
    }


    @GetMapping(path = "search/{vehicleCategoryID}")
    public ResponseEntity<VehicleCategoryDTO> searchVehicleCategory(@PathVariable int vehicleCategoryID) {
        return new ResponseEntity<>(vehicleCategoryService.searchVehicleCategory(vehicleCategoryID), HttpStatus.OK);
    }

    @DeleteMapping(path = "{vehicleCategoryID}")
    public ResponseEntity<VehicleCategoryDTO> deleteVehicleCategory(@PathVariable int vehicleCategoryID) {
        vehicleCategoryService.deleteVehicleCategory(vehicleCategoryID);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<VehicleCategoryDTO>> getAllVehicleCategory() {
        return new ResponseEntity<>(vehicleCategoryService.getAllVehicleCategory(), HttpStatus.OK);
    }

}

