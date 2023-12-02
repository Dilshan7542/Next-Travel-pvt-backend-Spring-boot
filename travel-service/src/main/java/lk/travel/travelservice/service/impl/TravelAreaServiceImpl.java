package lk.travel.travelservice.service.impl;

import lk.travel.travelservice.dto.TravelAreaDTO;
import lk.travel.travelservice.entity.TravelArea;
import lk.travel.travelservice.repo.TravelAreaRepo;
import lk.travel.travelservice.service.TravelAreaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class TravelAreaServiceImpl implements TravelAreaService {
    private final TravelAreaRepo travelAreaRepo;
    private final ModelMapper mapper;
    @Override
    public TravelAreaDTO saveTravelArea(TravelAreaDTO travelAreaDTO) {
        if(travelAreaRepo.existsById(travelAreaDTO.getTravelAreaID())){
            throw new RuntimeException("Travel Area Already Exists..!");
        }
        travelAreaRepo.save(mapper.map(travelAreaDTO, TravelArea.class));
        return travelAreaDTO;
    }

    @Override
    public TravelAreaDTO updateTravelArea(TravelAreaDTO travelAreaDTO) {
        if(!travelAreaRepo.existsById(travelAreaDTO.getTravelAreaID())){
            throw new RuntimeException("Travel Area Not Exists..!");
        }
        travelAreaRepo.save(mapper.map(travelAreaDTO, TravelArea.class));
        return travelAreaDTO;
    }

    @Override
    public TravelAreaDTO searchTravelArea(int travelAreaID) {
        if(!travelAreaRepo.existsById(travelAreaID)){
            throw new RuntimeException("Travel Area Not Exists..!");
        }
        return mapper.map(travelAreaRepo.findById(travelAreaID),TravelAreaDTO.class);
    }

    @Override
    public void deleteTravelArea(int travelAreaID) {
        if(!travelAreaRepo.existsById(travelAreaID)){
            throw new RuntimeException("Travel Area Not Exists..!");
        }
        travelAreaRepo.deleteById(travelAreaID);
    }

    @Override
    public List<TravelAreaDTO> getAllTravelArea() {
        return mapper.map(travelAreaRepo.findAll(),new TypeToken<List<TravelAreaDTO>>(){}.getType());
    }
}
