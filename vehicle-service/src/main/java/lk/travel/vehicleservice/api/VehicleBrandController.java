package lk.travel.vehicleservice.api;

import lk.travel.vehicleservice.dto.VehicleBrandDTO;
import lk.travel.vehicleservice.dto.VehicleCategoryDTO;
import lk.travel.vehicleservice.service.VehicleBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle/brand")
@RequiredArgsConstructor
public class VehicleBrandController {
    private final VehicleBrandService vehicleBrandService;


    @PostMapping
    public ResponseEntity<VehicleBrandDTO> saveVehicleBrand(@RequestBody VehicleBrandDTO vehicleBrandDTO) {
        return new ResponseEntity<>(vehicleBrandService.saveVehicleBrand(vehicleBrandDTO), HttpStatus.OK);
    }

    @PostMapping(path = "image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<VehicleBrandDTO> saveWithImageVehicleBrand(@RequestPart int vehicleID, @RequestPart String brandName, @RequestPart int seat, @RequestPart double fee1Day, @RequestPart double fee1KM, @RequestPart double fuel1KM, @RequestPart byte[] image, @RequestPart int vehicleCategoryID) {
        return new ResponseEntity<>(vehicleBrandService.saveVehicleBrand(new VehicleBrandDTO(vehicleID, brandName, seat, fee1Day, fee1KM, fuel1KM, image, new VehicleCategoryDTO(vehicleCategoryID))), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VehicleBrandDTO> updateVehicleBrand(@RequestBody VehicleBrandDTO vehicleBrandDTO) {
        return new ResponseEntity<>(vehicleBrandService.updateVehicleBrand(vehicleBrandDTO), HttpStatus.OK);
    }

    @PutMapping(path = "image/{vehicleID}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<VehicleBrandDTO> uploadImageVehicleBrand(@RequestPart byte[] file, @PathVariable int vehicleID) throws IOException {
        VehicleBrandDTO vehicleBrandDTO = vehicleBrandService.searchVehicleBrand(vehicleID);
        vehicleBrandDTO.setImage(file);
        return new ResponseEntity<>(vehicleBrandService.updateVehicleBrand(vehicleBrandDTO), HttpStatus.OK);
    }


    @GetMapping(path = "search/{vehicleBrandID}")
    public ResponseEntity<VehicleBrandDTO> searchVehicleBrand(@PathVariable int vehicleBrandID) {
        return new ResponseEntity<>(vehicleBrandService.searchVehicleBrand(vehicleBrandID), HttpStatus.OK);
    }

    @DeleteMapping(path = "{vehicleBrandID}")
    public ResponseEntity<VehicleBrandDTO> deleteVehicleBrand(@PathVariable int vehicleBrandID) {
        vehicleBrandService.deleteVehicleBrand(vehicleBrandID);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<VehicleBrandDTO>> getAllVehicleBrand() {
        return new ResponseEntity<>(vehicleBrandService.getAllVehicleBrand(), HttpStatus.OK);
    }
    @GetMapping(path = "!image")
    public ResponseEntity<List<VehicleBrandDTO>> getAllVehicleBrandWithOutImage() {
        return new ResponseEntity<>(vehicleBrandService.getAllVehicleCategoryWithOutImage(), HttpStatus.OK);
    }
    @GetMapping(path = "search/category/{vehicleCategoryID}")
    public ResponseEntity<List<VehicleBrandDTO>> findAllVehicleCategory(@PathVariable int vehicleCategoryID) {
        return new ResponseEntity<>(vehicleBrandService.findByAllVehicleCategoryID(vehicleCategoryID), HttpStatus.OK);
    }
}
