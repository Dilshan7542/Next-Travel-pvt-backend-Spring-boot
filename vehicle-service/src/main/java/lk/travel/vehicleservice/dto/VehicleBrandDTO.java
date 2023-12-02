package lk.travel.vehicleservice.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VehicleBrandDTO {
    private int vehicleID;
    private String brandName;
    private int seat;
    private double fee1KM;
    private double fuel1KM;
    private double fee1Day;
    private byte[] image;

    private VehicleCategoryDTO vehicleCategory;
}
