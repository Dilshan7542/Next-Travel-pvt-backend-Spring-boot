package lk.travel.travelservice.service;

import lk.travel.travelservice.dto.TravelAreaDTO;
import lk.travel.travelservice.dto.TravelCategoryDTO;
import lk.travel.travelservice.dto.TravelDTO;

import java.util.List;

public interface TravelAreaService {
    TravelAreaDTO saveTravelArea(TravelAreaDTO travelAreaDTO);
    TravelAreaDTO updateTravelArea(TravelAreaDTO travelAreaDTO);
    TravelAreaDTO searchTravelArea(int travelAreaID);
    void deleteTravelArea(int travelAreaID);
    List<TravelAreaDTO> getAllTravelArea();
}
