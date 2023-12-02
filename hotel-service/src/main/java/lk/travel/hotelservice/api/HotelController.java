package lk.travel.hotelservice.api;

import lk.travel.hotelservice.dto.HotelDTO;
import lk.travel.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDTO> saveHotel(@RequestBody HotelDTO hotelDTO) {
        return new ResponseEntity(hotelService.saveHotel(hotelDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDTO) {
        return new ResponseEntity(hotelService.updateHotel(hotelDTO), HttpStatus.OK);
    }

    @PutMapping(path = "image/{hotelID}",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<HotelDTO> updateImageHotel(@RequestPart byte[] image, @PathVariable int hotelID) {
        HotelDTO hotelDTO = hotelService.searchHotel(hotelID);
        hotelDTO.setImage(image);
        hotelService.updateHotel(hotelDTO);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping(path = "search", params = "hotelID")
    public ResponseEntity<HotelDTO> searchHotel(@RequestParam int hotelID) {
        return new ResponseEntity(hotelService.searchHotel(hotelID), HttpStatus.OK);
    }

    @DeleteMapping(path = "{hotelID}")
    public ResponseEntity<HotelDTO> deleteHotel(@PathVariable("hotelID") int hotelID) {
        hotelService.deleteHotel(hotelID);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<HotelDTO>> getAllHotel() {
        return ResponseEntity.ok(hotelService.getAllHotel());
    }
    @GetMapping(path = "search/location/{location}")
    public ResponseEntity<List<HotelDTO>> getAllHotelFindByLocation(@PathVariable String location) {
        return new ResponseEntity<>(hotelService.getAllHotelFindByLocation(location),HttpStatus.OK);
    }
    @GetMapping(path = "!image")
    public ResponseEntity<List<HotelDTO>> getAllHotelWithOutImage() {
        return ResponseEntity.ok(hotelService.getAllHotelWithOutImage());
    }

}
