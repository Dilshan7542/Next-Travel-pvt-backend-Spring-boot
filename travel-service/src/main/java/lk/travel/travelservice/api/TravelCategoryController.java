package lk.travel.travelservice.api;

import lk.travel.travelservice.dto.TravelCategoryDTO;
import lk.travel.travelservice.service.TravelCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/travel/category")
@RequiredArgsConstructor
public class TravelCategoryController {
    private final TravelCategoryService travelCategoryService;
    @PostMapping
    public ResponseEntity<TravelCategoryDTO> saveTravelCategory(@RequestBody TravelCategoryDTO travelCategoryDTO){
        return new ResponseEntity<>(travelCategoryService.saveTravelCategory(travelCategoryDTO), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<TravelCategoryDTO> updateTravelCategory(@RequestBody TravelCategoryDTO travelCategoryDTO){
        return new ResponseEntity<>(travelCategoryService.updateTravelCategory(travelCategoryDTO), HttpStatus.OK);
    }
    @GetMapping(path = "search/{travelCategoryID}")
    public ResponseEntity<TravelCategoryDTO> searchTravelCategory(@PathVariable int travelCategoryID){
        return new ResponseEntity<>(travelCategoryService.searchTravelCategory(travelCategoryID), HttpStatus.OK);
    }
    @DeleteMapping(path = "{travelCategoryID}")
    public ResponseEntity<TravelCategoryDTO> deleteTravelCategory(@PathVariable int travelCategoryID){
        travelCategoryService.deleteTravelCategory(travelCategoryID);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<TravelCategoryDTO>> getAllTravelCategory(){
        return new ResponseEntity<>(travelCategoryService.getAllTravelCategory(), HttpStatus.OK);
    }
}
