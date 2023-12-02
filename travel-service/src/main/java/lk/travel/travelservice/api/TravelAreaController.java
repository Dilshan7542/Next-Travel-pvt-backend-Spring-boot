package lk.travel.travelservice.api;

import lk.travel.travelservice.dto.TravelAreaDTO;
import lk.travel.travelservice.service.TravelAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/travel/area")
@RequiredArgsConstructor
public class TravelAreaController {
    private final TravelAreaService travelAreaService;

    @PostMapping
    public ResponseEntity<TravelAreaDTO> saveTravelCategory(@RequestBody TravelAreaDTO travelAreaDTO) {
        return new ResponseEntity<>(travelAreaService.saveTravelArea(travelAreaDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TravelAreaDTO> updateTravelCategory(@RequestBody TravelAreaDTO travelAreaDTO) {
        return new ResponseEntity<>(travelAreaService.updateTravelArea(travelAreaDTO), HttpStatus.OK);
    }

    @GetMapping(path = "search/{travelAreaID}")
    public ResponseEntity<TravelAreaDTO> searchTravelCategory(@PathVariable int travelAreaID) {
        return new ResponseEntity<>(travelAreaService.searchTravelArea(travelAreaID), HttpStatus.OK);
    }

    @DeleteMapping(path = "{travelAreaID}")
    public ResponseEntity<TravelAreaDTO> deleteTravelCategory(@PathVariable int travelAreaID) {
        travelAreaService.deleteTravelArea(travelAreaID);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<TravelAreaDTO>> getAllTravelCategory() {
        return new ResponseEntity<>(travelAreaService.getAllTravelArea(), HttpStatus.OK);
    }
}
