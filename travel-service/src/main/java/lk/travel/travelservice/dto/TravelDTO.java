package lk.travel.travelservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TravelDTO {
    private int travelID;
    // @JsonFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "yyy-MM-dd") //
    private LocalDate startDate;
    @JsonFormat(pattern = "yyy-MM-dd")
    private LocalDate endDate;
    private int countDay;
    private int countNight;
    private int adults;
    private int children;
    private int room;
    private int vehicleCount;
    private int vehicleCost;
    private TravelAreaDTO travelArea;
    private TravelCategoryDTO travelCategory;
}
