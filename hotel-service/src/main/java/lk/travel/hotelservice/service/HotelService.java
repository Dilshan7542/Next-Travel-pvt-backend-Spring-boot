package lk.travel.hotelservice.service;

import lk.travel.hotelservice.dto.HotelDTO;


import java.util.List;

public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotelDTO);
    HotelDTO updateHotel(HotelDTO hotelDTO);
    HotelDTO searchHotel(int hotelID);
    void deleteHotel(int hotelID);
    List<HotelDTO> getAllHotel();
    List<HotelDTO> getAllHotelFindByLocation(String location);
    List<HotelDTO> getAllHotelWithOutImage();
}
