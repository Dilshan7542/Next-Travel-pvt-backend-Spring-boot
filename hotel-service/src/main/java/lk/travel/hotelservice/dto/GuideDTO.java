package lk.travel.hotelservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideDTO {
    private int guideID;
    private String name;
    private String address;
    private String tel;
    private double price;
}
