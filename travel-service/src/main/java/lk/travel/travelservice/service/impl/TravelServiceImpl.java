package lk.travel.travelservice.service.impl;

import lk.travel.travelservice.dto.TravelDTO;
import lk.travel.travelservice.entity.Travel;
import lk.travel.travelservice.repo.TravelRepo;
import lk.travel.travelservice.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TravelServiceImpl implements TravelService {
    private final TravelRepo travelRepo;
    private final ModelMapper mapper;
    @Override
    public TravelDTO saveTravel(TravelDTO travelDTO) {
        if(travelRepo.existsById(travelDTO.getTravelID())){
            throw new RuntimeException("Travel Already Exists..!!");
        }
  travelDTO.setTravelID(travelRepo.save(mapper.map(travelDTO, Travel.class)).getTravelID());
        return travelDTO;
    }

    @Override
    public TravelDTO updateTravel(TravelDTO travelDTO) {
        if(!travelRepo.existsById(travelDTO.getTravelID())){
            throw new RuntimeException("Travel Not Exists..!!");
        }
        travelRepo.save(mapper.map(travelDTO, Travel.class));
        return travelDTO;
    }

    @Override
    public TravelDTO searchTravel(int travelID) {
        if(!travelRepo.existsById(travelID)){
            throw new RuntimeException("Travel Not Exists..!!");
        }
        return mapper.map(travelRepo.findById(travelID), TravelDTO.class);
    }

    @Override
    public void deleteTravel(int travelID) {
        if(!travelRepo.existsById(travelID)){
            throw new RuntimeException("Travel Not Exists..!!");
        }
        travelRepo.deleteById(travelID);
    }

    @Override
    public List<TravelDTO> getAllTravel() {
        return mapper.map(travelRepo.findAll(),new TypeToken<List<TravelDTO>>(){}.getType());
    }
}
