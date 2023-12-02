package lk.travel.hotelservice.api;


import lk.travel.hotelservice.dto.GuideDTO;
import lk.travel.hotelservice.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/guide")
public class GuideController {
    @Autowired
    GuideService guideService;

    @PostMapping
    public ResponseEntity<GuideDTO> saveGuide(@RequestBody GuideDTO guideDTO) {
        return ResponseEntity.ok(guideService.saveGuide(guideDTO));
    }

    @PutMapping
    public ResponseEntity<GuideDTO> updateGuide(@RequestBody GuideDTO guideDTO) {
        return ResponseEntity.ok(guideService.updateGuide(guideDTO));
    }

    @GetMapping(path = "search", params = "guideID")
    public ResponseEntity<GuideDTO> searchGuide(@RequestParam int guideID) {
        return ResponseEntity.ok(guideService.searchGuide(guideID));
    }

    @GetMapping
    public ResponseEntity<List<GuideDTO>> getAllGuide() {
        return ResponseEntity.ok(guideService.getAllGuide());
    }
}
