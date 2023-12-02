package lk.travel.hotelservice.service;



import lk.travel.hotelservice.dto.GuideDTO;

import java.util.List;

public interface GuideService {
    GuideDTO saveGuide(GuideDTO guideDTO);
    GuideDTO updateGuide(GuideDTO guideDTO);
    GuideDTO searchGuide(int guideID);
    void deleteGuide(int guideID);
    List<GuideDTO> getAllGuide();
}
