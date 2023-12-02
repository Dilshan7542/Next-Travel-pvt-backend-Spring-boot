package lk.travel.travelservice.service;

import lk.travel.travelservice.dto.TravelCategoryDTO;

import java.util.List;

public interface TravelCategoryService {
    TravelCategoryDTO saveTravelCategory(TravelCategoryDTO travelDTO);
    TravelCategoryDTO updateTravelCategory(TravelCategoryDTO travelDTO);
    TravelCategoryDTO searchTravelCategory(int travelCategoryID);
    void deleteTravelCategory(int travelCategoryID);
    List<TravelCategoryDTO> getAllTravelCategory();
}
