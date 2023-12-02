package lk.travel.hotelservice.service.impl;

import jakarta.persistence.EntityManager;
import lk.travel.hotelservice.dto.HotelDTO;
import lk.travel.hotelservice.entity.Hotel;
import lk.travel.hotelservice.repo.HotelRepo;
import lk.travel.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
private final HotelRepo hotelRepo;
private final ModelMapper mapper;
private final EntityManager entityManager;
    @Override
    public HotelDTO saveHotel(HotelDTO hotelDTO) {
        if(hotelRepo.existsById(hotelDTO.getHotelID())){
            throw new RuntimeException("Hotel Already Exists...!!");
        }
        hotelRepo.save(mapper.map(hotelDTO, Hotel.class));
        return hotelDTO;
    }

    @Override
    public HotelDTO updateHotel(HotelDTO hotelDTO) {
        if(!hotelRepo.existsById(hotelDTO.getHotelID())){
            throw new RuntimeException("Hotel Not Exists...!!");
        }
        hotelRepo.save(mapper.map(hotelDTO, Hotel.class));
        return hotelDTO;
    }

    @Override
    public HotelDTO searchHotel(int hotelID) {
        if(!hotelRepo.existsById(hotelID)){
            throw new RuntimeException("Hotel Not Exists...!!");
        }
        return mapper.map(hotelRepo.findById(hotelID),HotelDTO.class);
    }

    @Override
    public void deleteHotel(int hotelID) {
        if(!hotelRepo.existsById(hotelID)){
            throw new RuntimeException("Hotel Not Exists...!!");
        }
        hotelRepo.deleteById(hotelID);
    }

    @Override
    public List<HotelDTO> getAllHotel() {
        return mapper.map(hotelRepo.findAll(),new TypeToken<List<HotelDTO>>(){}.getType());
    }

    @Override
    public List<HotelDTO> getAllHotelFindByLocation(String location) {
        return mapper.map(hotelRepo.findAllByLocation(location),new TypeToken<List<HotelDTO>>(){}.getType());
    }

    @Override
    public List<HotelDTO> getAllHotelWithOutImage() {
        List<Hotel> list = hotelRepo.findAll();
        for (Hotel hotel : list) {
            entityManager.detach(hotel);
            hotel.setImage(null);
        }
         return mapper.map(list,new TypeToken<List<HotelDTO>>(){}.getType());
    }
}
