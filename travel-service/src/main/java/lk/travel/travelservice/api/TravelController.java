package lk.travel.travelservice.api;


import lk.travel.travelservice.dto.TravelDTO;
import lk.travel.travelservice.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/travel")
@RequiredArgsConstructor
public class TravelController {
    private final TravelService travelService;
    @PostMapping
    public ResponseEntity<TravelDTO> saveTravelCategory(@RequestBody TravelDTO travelDTO) {
        return new ResponseEntity<>(travelService.saveTravel(travelDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TravelDTO> updateTravelCategory(@RequestBody TravelDTO travelDTO) {
        return new ResponseEntity<>(travelService.updateTravel(travelDTO), HttpStatus.OK);
    }

    @GetMapping(path = "search/{travelID}")
    public ResponseEntity<TravelDTO> searchTravelCategory(@PathVariable int travelID) {
        return new ResponseEntity<>(travelService.searchTravel(travelID), HttpStatus.OK);
    }

    @DeleteMapping(path = "{travelID}")
    public ResponseEntity<TravelDTO> deleteTravelCategory(@PathVariable int travelID) {
        travelService.deleteTravel(travelID);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TravelDTO>> getAllTravelCategory() {
        return new ResponseEntity<>(travelService.getAllTravel(), HttpStatus.OK);
    }
}
