package lk.travel.travelservice.service;

import lk.travel.travelservice.dto.TravelDTO;

import java.util.List;

public interface TravelService {
    TravelDTO saveTravel(TravelDTO travelDTO);
    TravelDTO updateTravel(TravelDTO travelDTO);
    TravelDTO searchTravel(int travelID);
    void deleteTravel(int travelID);
    List<TravelDTO> getAllTravel();
}
