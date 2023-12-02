package lk.travel.travelservice.service.impl;

import lk.travel.travelservice.dto.TravelCategoryDTO;
import lk.travel.travelservice.entity.TravelCategory;
import lk.travel.travelservice.repo.TravelCategoryRepo;
import lk.travel.travelservice.service.TravelCategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TravelCategoryServiceImpl implements TravelCategoryService {
    private final TravelCategoryRepo travelCategoryRepo;
    private final ModelMapper mapper;

    @Override
    public TravelCategoryDTO saveTravelCategory(TravelCategoryDTO travelDTO) {
        if(travelCategoryRepo.existsById(travelDTO.getTravelCategoryID())){
            throw new RuntimeException("Travel Category Already Exists..!!");
        }
        travelCategoryRepo.save(mapper.map(travelDTO, TravelCategory.class));
        return travelDTO;
    }

    @Override
    public TravelCategoryDTO updateTravelCategory(TravelCategoryDTO travelDTO) {
        if(!travelCategoryRepo.existsById(travelDTO.getTravelCategoryID())){
            throw new RuntimeException("Travel Category Not Exists..!!");
        }
        travelCategoryRepo.save(mapper.map(travelDTO, TravelCategory.class));
        return travelDTO;
    }

    @Override
    public TravelCategoryDTO searchTravelCategory(int travelCategoryID) {
        if(!travelCategoryRepo.existsById(travelCategoryID)){
            throw new RuntimeException("Travel Category Not Exists..!!");
        }
        return mapper.map(travelCategoryRepo.findById(travelCategoryID),TravelCategoryDTO.class);
    }

    @Override
    public void deleteTravelCategory(int travelCategoryID) {
        if(!travelCategoryRepo.existsById(travelCategoryID)){
            throw new RuntimeException("Travel Category Not Exists..!!");
        }
        travelCategoryRepo.deleteById(travelCategoryID);
    }

    @Override
    public List<TravelCategoryDTO> getAllTravelCategory() {
        return mapper.map(travelCategoryRepo.findAll(),new TypeToken<List<TravelCategoryDTO>>(){}.getType());
    }
}
