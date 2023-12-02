package lk.travel.vehicleservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lk.travel.vehicleservice.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class VehicleCategoryDTO  {
   private int vehicleCategoryID;
   private String categoryName;
    @JsonIgnore
   private List<VehicleBrandDTO> vehicleBrandList;

    public VehicleCategoryDTO(int vehicleCategoryID) {
        this.vehicleCategoryID = vehicleCategoryID;
    }
}
